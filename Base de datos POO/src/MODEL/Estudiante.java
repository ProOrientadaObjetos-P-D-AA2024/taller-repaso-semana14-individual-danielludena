package MODEL;

public class Estudiante {
    private String nombre;
    private String estado;
    private String id;
    private double calificacion1;
    private double calificacion2;
    private double promedio;

    public Estudiante(String nombre, double calificacion1, double calificacion2, String id) {
        this.nombre = nombre;
        this.calificacion1 = calificacion1;
        this.calificacion2 = calificacion2;
        this.id = id;
        calcularPromedioYEstado();
    }

    private void calcularPromedioYEstado() {
        this.promedio = (calificacion1 + calificacion2) / 2;
        this.estado = this.promedio >= 7 ? "Aprobado" : "Reprobado";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        calcularPromedioYEstado();
    }

    public double getCalificacion1() {
        return calificacion1;
    }

    public void setCalificacion1(double calificacion1) {
        this.calificacion1 = calificacion1;
        calcularPromedioYEstado();
    }

    public double getCalificacion2() {
        return calificacion2;
    }

    public void setCalificacion2(double calificacion2) {
        this.calificacion2 = calificacion2;
        calcularPromedioYEstado();
    }

    public double getPromedio() {
        return promedio;
    }

    public String getEstado() {
        return estado;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Estudiante: %s\nCalificación 1: %.2f\nCalificación 2: %.2f\nPromedio: %.2f\nEstado: %s\nID: %s",
                nombre, calificacion1, calificacion2, promedio, estado, id);
    }
}
