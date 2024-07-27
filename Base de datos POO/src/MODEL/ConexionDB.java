package MODEL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.LinkedList;

public class ConexionDB {

    private Connection conexion;
    private LinkedList<Estudiante> estudiantes;
    private String mensaje;

    public void conectar() {
        try {
            String url = "jdbc:sqlite:bd/db_estudiantes.db";
            conexion = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public LinkedList<Estudiante> obtenerEstudiantes() {
        estudiantes = new LinkedList<>();
        try {
            conectar();
            try (Statement statement = conexion.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Estudiante");
                while (resultSet.next()) {
                    estudiantes.add(new Estudiante(resultSet.getString("nombre"),
                            resultSet.getDouble("calificacion1"),
                            resultSet.getDouble("calificacion2"),
                            resultSet.getString("id")));
                }
            }
        } catch (SQLException e) {
            this.mensaje = e.getMessage();
        }
        return estudiantes;
    }

    public void insertarEstudiante(Estudiante estudiante) {
        try {
            conectar();
            try (Statement statement = conexion.createStatement()) {
                String query = String.format("INSERT INTO Estudiante(nombre, calificacion1, calificacion2, promedio, estado, id) "
                        + "VALUES('%s', %.2f, %.2f, %.2f, '%s', '%s')", estudiante.getNombre(),
                        estudiante.getCalificacion1(), estudiante.getCalificacion2(),
                        estudiante.getPromedio(), estudiante.getEstado(), estudiante.getId());
                statement.executeUpdate(query);
            }
        } catch (SQLException e) {
            this.mensaje = e.getMessage();
        }
    }

    public void actualizarEstudiante(Estudiante estudiante) {
        try {
            conectar();
            try (Statement statement = conexion.createStatement()) {
                String query = String.format("UPDATE Estudiante SET nombre='%s', calificacion1=%.2f, calificacion2=%.2f, promedio=%.2f, estado='%s' WHERE id='%s'",
                        estudiante.getNombre(), estudiante.getCalificacion1(), estudiante.getCalificacion2(),
                        estudiante.getPromedio(), estudiante.getEstado(), estudiante.getId());
                statement.executeUpdate(query);
                System.out.println("Estudiante actualizado: " + estudiante.getNombre());
            }
        } catch (SQLException e) {
            this.mensaje = e.getMessage();
            System.out.println("Error al actualizar estudiante: " + this.mensaje);
        }
    }

    public void eliminarEstudiante(String id) {
        try {
            conectar();
            try (Statement statement = conexion.createStatement()) {
                String query = String.format("DELETE FROM Estudiante WHERE id='%s'", id);
                statement.executeUpdate(query);
            }
        } catch (SQLException e) {
            this.mensaje = e.getMessage();
        }
    }
}
