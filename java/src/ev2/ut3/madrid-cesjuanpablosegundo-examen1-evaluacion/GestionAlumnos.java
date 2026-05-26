package madrid.cesjuanpablosegundo.examen1evaluacion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal para gestionar alumnos mediante ArrayList
 * Permite agregar, listar, buscar, expulsar y consultar alumnos
 */
public class GestionAlumnos {
    
    // ArrayList para almacenar los alumnos
    private static ArrayList<Alumno> listaAlumnos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    
    /**
     * Método principal que inicia la aplicación
     */
    public static void main(String[] args) {
        int opcion;
        
        // Bucle principal del menú
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            
            switch(opcion) {
                case 1:
                    agregarAlumno();
                    break;
                case 2:
                    listarAlumnos();
                    break;
                case 3:
                    buscarAlumno();
                    break;
                case 4:
                    mostrarAlumnoMejorNota();
                    break;
                case 5:
                    expulsarAlumno();
                    break;
                case 6:
                    mostrarAlumnosNotaMinima();
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
            
        } while(opcion != 7);
    }
    
    /**
     * Muestra el menú principal de opciones
     */
    private static void mostrarMenu() {
        System.out.println("\nGESTIÓN DE ALUMNOS");
        System.out.println("1. Agregar alumno");
        System.out.println("2. Listar alumnos");
        System.out.println("3. Buscar alumno");
        System.out.println("4. Mostrar alumno con mejor nota");
        System.out.println("5. Expulsar alumno");
        System.out.println("6. Mostrar alumnos con nota mínima");
        System.out.println("7. Salir");
        System.out.print("Elige una opción: ");
    }
    
    /**
     * Agrega un nuevo alumno a la lista
     * Solicita número de matrícula, nombre, apellido y nota media
     */
    private static void agregarAlumno() {
        System.out.println("\nAGREGAR ALUMNO");
        
        // Pedir número de matrícula
        System.out.print("Número de matrícula: ");
        String matricula = sc.next();
        
        // Verificar si la matrícula ya existe
        if (existeMatricula(matricula)) {
            System.out.println("ERROR: Ya existe un alumno con esa matrícula.");
            return;
        }
        
        // Pedir nombre
        System.out.print("Nombre: ");
        String nombre = sc.next();
        
        // Pedir apellido
        System.out.print("Apellido: ");
        String apellido = sc.next();
        
        // Pedir nota media
        System.out.print("Nota media (0-10): ");
        double notaMedia = sc.nextDouble();
        
        // Crear y agregar el alumno
        Alumno alumno = new Alumno(matricula, nombre, apellido, notaMedia);
        listaAlumnos.add(alumno);
        
        System.out.println("Alumno agregado correctamente.");
    }
    
    /**
     * Lista todos los alumnos almacenados
     */
    private static void listarAlumnos() {
        System.out.println("\nLISTADO DE ALUMNOS");
        
        if (listaAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        
        // Mostrar cada alumno
        for (Alumno alumno : listaAlumnos) {
            System.out.println(alumno);
        }
        
        System.out.println("\nTotal de alumnos: " + listaAlumnos.size());
    }
    
    /**
     * Busca un alumno por su número de matrícula
     */
    private static void buscarAlumno() {
        System.out.println("\nBUSCAR ALUMNO");
        
        if (listaAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        
        System.out.print("Introduce el número de matrícula: ");
        String matricula = sc.next();
        
        // Buscar el alumno
        Alumno alumnoEncontrado = buscarPorMatricula(matricula);
        
        if (alumnoEncontrado != null) {
            System.out.println("Alumno encontrado:");
            System.out.println(alumnoEncontrado);
        } else {
            System.out.println("No se encontró ningún alumno con esa matrícula.");
        }
    }
    
    /**
     * Muestra el alumno con la nota media más alta
     */
    private static void mostrarAlumnoMejorNota() {
        System.out.println("\nALUMNO CON MEJOR NOTA");
        
        if (listaAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        
        // Buscar el alumno con mejor nota
        Alumno mejorAlumno = listaAlumnos.get(0);
        for (Alumno alumno : listaAlumnos) {
            if (alumno.getNotaMedia() > mejorAlumno.getNotaMedia()) {
                mejorAlumno = alumno;
            }
        }
        
        System.out.println("Alumno con mejor nota:");
        System.out.println(mejorAlumno);
    }
    
    /**
     * Expulsa un alumno de la lista usando su matrícula
     */
    private static void expulsarAlumno() {
        System.out.println("\nEXPULSAR ALUMNO");
        
        if (listaAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        
        System.out.print("Introduce el número de matrícula del alumno a expulsar: ");
        String matricula = sc.next();
        
        // Buscar y eliminar el alumno
        Alumno alumnoAEliminar = buscarPorMatricula(matricula);
        
        if (alumnoAEliminar != null) {
            listaAlumnos.remove(alumnoAEliminar);
            System.out.println("Alumno expulsado correctamente.");
        } else {
            System.out.println("No se encontró ningún alumno con esa matrícula.");
        }
    }
    
    /**
     * Muestra todos los alumnos con una nota media superior a la mínima indicada
     */
    private static void mostrarAlumnosNotaMinima() {
        System.out.println("\nALUMNOS CON NOTA MÍNIMA");
        
        if (listaAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        
        // Pedir nota mínima
        System.out.print("Introduce la nota mínima (0-10): ");
        double notaMinima = sc.nextDouble();
        
        // Buscar y mostrar alumnos con nota superior
        boolean encontrados = false;
        System.out.println("\nAlumnos con nota superior a " + notaMinima + ":");
        
        for (Alumno alumno : listaAlumnos) {
            if (alumno.getNotaMedia() >= notaMinima) {
                System.out.println(alumno);
                encontrados = true;
            }
        }
        
        if (!encontrados) {
            System.out.println("No se encontraron alumnos con nota superior a " + notaMinima);
        } else {
            System.out.println("Búsqueda completada.");
        }
    }
    
    /**
     * Verifica si existe un alumno con la matrícula indicada
     */
    private static boolean existeMatricula(String matricula) {
        return buscarPorMatricula(matricula) != null;
    }
    
    /**
     * Busca un alumno por su matrícula
     */
    private static Alumno buscarPorMatricula(String matricula) {
        for (Alumno alumno : listaAlumnos) {
            if (alumno.getMatricula().equals(matricula)) {
                return alumno;
            }
        }
        return null;
    }
}

/**
 * Clase que representa un Alumno
 * Contiene matrícula, nombre, apellido y nota media
 */
class Alumno {
    private String matricula;
    private String nombre;
    private String apellido;
    private double notaMedia;
    
    /**
     * Constructor de la clase Alumno
     */
    public Alumno(String matricula, String nombre, String apellido, double notaMedia) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.notaMedia = notaMedia;
    }
    
    // Getters
    public String getMatricula() {
        return matricula;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public double getNotaMedia() {
        return notaMedia;
    }
    
    /**
     * Devuelve una representación en String del alumno
     */
    @Override
    public String toString() {
        return String.format("Matrícula: %s | Nombre: %s %s | Nota Media: %.2f", 
                           matricula, nombre, apellido, notaMedia);
    }
}

