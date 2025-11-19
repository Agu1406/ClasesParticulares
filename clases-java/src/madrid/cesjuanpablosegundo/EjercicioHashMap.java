import java.util.HashMap;
import java.util.Scanner;

/**
 * Ejercicio para aprender a usar HashMap
 * 
 * Este programa simula un registro de estudiantes y sus calificaciones donde puedes:
 * - Agregar estudiantes con sus notas
 * - Ver todos los estudiantes y sus notas
 * - Buscar la nota de un estudiante específico
 * - Eliminar estudiantes
 * - Calcular el promedio de todas las notas
 * 
 * HashMap es una estructura de datos que almacena pares clave-valor.
 * - Clave (Key): El nombre del estudiante (String)
 * - Valor (Value): La nota del estudiante (Double)
 * 
 * Es muy útil cuando necesitas buscar información rápidamente usando una clave.
 * 
 * @author Clases Particulares
 * @since 2025
 */
public class EjercicioHashMap {
    
    public static void main(String[] args) {
        // Crear un HashMap donde:
        // - La clave (Key) es un String (nombre del estudiante)
        // - El valor (Value) es un Double (nota del estudiante)
        HashMap<String, Double> estudiantes = new HashMap<String, Double>();
        
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        System.out.println("=== REGISTRO DE ESTUDIANTES Y NOTAS ===");
        System.out.println("Sistema de gestión de calificaciones");
        System.out.println();
        
        do {
            mostrarMenu();
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            switch (opcion) {
                case 1:
                    agregarEstudiante(estudiantes, scanner);
                    break;
                case 2:
                    mostrarTodosEstudiantes(estudiantes);
                    break;
                case 3:
                    buscarNotaEstudiante(estudiantes, scanner);
                    break;
                case 4:
                    eliminarEstudiante(estudiantes, scanner);
                    break;
                case 5:
                    calcularPromedio(estudiantes);
                    break;
                case 6:
                    System.out.println("¡Gracias por usar el sistema de calificaciones!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor elige del 1 al 6.");
            }
            
            System.out.println();
            
        } while (opcion != 6);
        
        scanner.close();
    }
    
    /**
     * Muestra el menú de opciones disponibles
     */
    private static void mostrarMenu() {
        System.out.println("1. Agregar estudiante y nota");
        System.out.println("2. Ver todos los estudiantes y sus notas");
        System.out.println("3. Buscar nota de un estudiante");
        System.out.println("4. Eliminar estudiante");
        System.out.println("5. Calcular promedio de todas las notas");
        System.out.println("6. Salir");
    }
    
    /**
     * Agrega un estudiante con su nota al HashMap
     * 
     * @param estudiantes El HashMap donde se guardará el estudiante
     * @param scanner El Scanner para leer la entrada del usuario
     */
    private static void agregarEstudiante(HashMap<String, Double> estudiantes, Scanner scanner) {
        System.out.print("Nombre del estudiante: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Nota del estudiante (0.0 - 10.0): ");
        double nota = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        
        // Verificar que la nota esté en el rango válido
        if (nota < 0.0 || nota > 10.0) {
            System.out.println("✗ La nota debe estar entre 0.0 y 10.0");
            return;
        }
        
        // Agregar el par clave-valor usando .put()
        // Si el estudiante ya existe, su nota será actualizada
        if (estudiantes.containsKey(nombre)) {
            System.out.println("⚠ El estudiante ya existe. Se actualizará su nota.");
        }
        
        estudiantes.put(nombre, nota);
        System.out.println("✓ Estudiante '" + nombre + "' agregado con nota " + nota);
        System.out.println("Total de estudiantes: " + estudiantes.size());
    }
    
    /**
     * Muestra todos los estudiantes y sus notas
     * 
     * @param estudiantes El HashMap con los estudiantes
     */
    private static void mostrarTodosEstudiantes(HashMap<String, Double> estudiantes) {
        // Verificar si el HashMap está vacío usando .isEmpty()
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        
        System.out.println("=== LISTA DE ESTUDIANTES Y NOTAS ===");
        
        // Recorrer el HashMap usando un bucle for mejorado
        // .entrySet() devuelve todos los pares clave-valor
        // Por cada entrada (par clave-valor) en el HashMap, imprimirlo
        for (HashMap.Entry<String, Double> entrada : estudiantes.entrySet()) {
            String nombre = entrada.getKey();    // Obtener la clave (nombre)
            Double nota = entrada.getValue();    // Obtener el valor (nota)
            
            // Mostrar el resultado con formato
            System.out.printf("Estudiante: %-20s Nota: %.2f%n", nombre, nota);
        }
        
        System.out.println("Total de estudiantes: " + estudiantes.size());
    }
    
    /**
     * Busca la nota de un estudiante específico
     * 
     * @param estudiantes El HashMap donde se buscará el estudiante
     * @param scanner El Scanner para leer la entrada del usuario
     */
    private static void buscarNotaEstudiante(HashMap<String, Double> estudiantes, Scanner scanner) {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        
        System.out.print("Nombre del estudiante a buscar: ");
        String nombreBuscado = scanner.nextLine();
        
        // Verificar si el HashMap contiene la clave usando .containsKey()
        if (estudiantes.containsKey(nombreBuscado)) {
            // Obtener el valor asociado a la clave usando .get()
            Double nota = estudiantes.get(nombreBuscado);
            System.out.println("✓ Estudiante encontrado:");
            System.out.printf("  Nombre: %s%n", nombreBuscado);
            System.out.printf("  Nota: %.2f%n", nota);
        } else {
            System.out.println("✗ Estudiante '" + nombreBuscado + "' no encontrado.");
        }
    }
    
    /**
     * Elimina un estudiante del HashMap
     * 
     * @param estudiantes El HashMap del cual se eliminará el estudiante
     * @param scanner El Scanner para leer la entrada del usuario
     */
    private static void eliminarEstudiante(HashMap<String, Double> estudiantes, Scanner scanner) {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        
        System.out.print("Nombre del estudiante a eliminar: ");
        String nombreEliminar = scanner.nextLine();
        
        // Verificar si el estudiante existe antes de eliminar
        if (estudiantes.containsKey(nombreEliminar)) {
            // Eliminar el par clave-valor usando .remove()
            Double notaEliminada = estudiantes.remove(nombreEliminar);
            System.out.println("✓ Estudiante '" + nombreEliminar + "' eliminado.");
            System.out.println("  Nota eliminada: " + notaEliminada);
            System.out.println("Total de estudiantes restantes: " + estudiantes.size());
        } else {
            System.out.println("✗ Estudiante '" + nombreEliminar + "' no encontrado.");
        }
    }
    
    /**
     * Calcula el promedio de todas las notas
     * 
     * @param estudiantes El HashMap con los estudiantes y sus notas
     */
    private static void calcularPromedio(HashMap<String, Double> estudiantes) {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados para calcular el promedio.");
            return;
        }
        
        // Sumar todas las notas
        double suma = 0.0;
        
        // Recorrer solo los valores (notas) usando .values()
        for (Double nota : estudiantes.values()) {
            suma += nota;
        }
        
        // Calcular el promedio
        double promedio = suma / estudiantes.size();
        
        System.out.println("=== ESTADÍSTICAS ===");
        System.out.println("Total de estudiantes: " + estudiantes.size());
        System.out.printf("Suma de todas las notas: %.2f%n", suma);
        System.out.printf("Promedio de las notas: %.2f%n", promedio);
    }
}

