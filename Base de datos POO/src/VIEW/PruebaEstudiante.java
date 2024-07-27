package VIEW;

import MODEL.Estudiante;
import CONTROLER.GestionarEstudiantes;
import java.util.LinkedList;
import java.util.Scanner;

public class PruebaEstudiante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String id;
        String nombre;
        double calificacion1;
        double calificacion2;
        LinkedList<Estudiante> listaEstudiantes = new LinkedList<>();
        GestionarEstudiantes gestionarEstudiantes = new GestionarEstudiantes(listaEstudiantes);

        int opcion = 0;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Añadir Estudiante");
            System.out.println("2. Mostrar Estudiantes");
            System.out.println("3. Modificar Estudiante");
            System.out.println("4. Eliminar Estudiante");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Nombre del estudiante: ");
                    nombre = scanner.nextLine();
                    System.out.print("Primera calificación: ");
                    calificacion1 = scanner.nextDouble();
                    System.out.print("Segunda calificación: ");
                    calificacion2 = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("ID del estudiante: ");
                    id = scanner.nextLine();

                    Estudiante estudiante = new Estudiante(nombre, calificacion1, calificacion2, id);
                    gestionarEstudiantes.agregarEstudiante(estudiante);

                    System.out.println("Estudiante añadido.\n");
                    break;
                case 2:
                    LinkedList<Estudiante> estudiantes = gestionarEstudiantes.obtenerEstudiantes(estudiantes);
                    for (Estudiante est : estudiantes) {
                        System.out.println(est);
                    }
                    break;
                case 3:
                    System.out.println("ID del estudiante a modificar:");
                    id = scanner.nextLine();

                    boolean encontrado = false;

                    for (Estudiante est : gestionarEstudiantes.obtenerEstudiantes(estudiantes)) {
                        if (est.getId().equals(id)) {
                            encontrado = true;
                            System.out.println("Campo a modificar:");
                            System.out.println("1. Nombre");
                            System.out.println("2. Calificación 1");
                            System.out.println("3. Calificación 2");
                            int seleccion = scanner.nextInt();
                            scanner.nextLine();
                            switch (seleccion) {
                                case 1:
                                    System.out.print("Nuevo nombre: ");
                                    nombre = scanner.nextLine();
                                    est.setNombre(nombre);
                                    break;
                                case 2:
                                    System.out.print("Nueva calificación 1: ");
                                    calificacion1 = scanner.nextDouble();
                                    scanner.nextLine();
                                    est.setCalificacion1(calificacion1);
                                    break;
                                case 3:
                                    System.out.print("Nueva calificación 2: ");
                                    calificacion2 = scanner.nextDouble();
                                    scanner.nextLine();
                                    est.setCalificacion2(calificacion2);
                                    break;
                                default:
                                    System.out.println("Opción inválida.");
                                    break;
                            }
                            gestionarEstudiantes.modificarEstudiante(est);
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("ID del estudiante a eliminar:");
                    id = scanner.nextLine();

                    gestionarEstudiantes.eliminarEstudiante(id);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 5);
    }
}
