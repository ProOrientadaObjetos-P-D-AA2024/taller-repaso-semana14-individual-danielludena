package CONTROLER;

import MODEL.Estudiante;
import MODEL.ConexionDB;
import java.util.LinkedList;

public class GestionarEstudiantes {
    private LinkedList<Estudiante> estudiantes;

    public GestionarEstudiantes(LinkedList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        ConexionDB conexionDB = new ConexionDB();
        conexionDB.insertarEstudiante(estudiante);
    }

    public LinkedList<Estudiante> obtenerEstudiantes(Estudiante estudiante) {
        ConexionDB conexionDB = new ConexionDB();
        return conexionDB.obtenerEstudiantes();
    }

    public void modificarEstudiante(Estudiante estudiante) {
        estudiantes.set(estudiantes.indexOf(estudiante), estudiante);
        ConexionDB conexionDB = new ConexionDB();
        conexionDB.actualizarEstudiante(estudiante);
    }

    public void eliminarEstudiante(String id) {
        ConexionDB conexionDB = new ConexionDB();
        conexionDB.eliminarEstudiante(id);
    }
}
