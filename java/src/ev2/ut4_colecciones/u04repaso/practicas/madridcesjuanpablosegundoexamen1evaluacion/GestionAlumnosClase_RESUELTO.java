package ev2.ut4_colecciones.u04repaso.practicas.madridcesjuanpablosegundoexamen1evaluacion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Clase para gestionar los alumnos de una clase
 * Permite introducir alumnos, mostrar el mejor y ordenar por nota
  *
 * * PLANTILLA DOCENTE: completar solucion docente.
 */
public class GestionAlumnosClase_RESUELTO {
    
    private static ArrayList<AlumnoClaseResuelto> listaAlumnos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    
    /**
     * Metodo principal que inicia la aplicacion
     */
    public static void main(String[] args) {
        System.out.println("GESTION DE ALUMNOS DE CLASE\n");
        
        // Paso a: Pedir numero de alumnos
        int numeroAlumnos = pedirNumeroAlumnos();
        
        // Paso b: Pedir nombres y notas
        pedirDatosAlumnos(numeroAlumnos);
        
        // Paso c: Mostrar alumno con mejor nota
        mostrarMejorAlumno();
        
        // Paso d: Mostrar todos ordenados por nota
        mostrarAlumnosOrdenados();
    }
    
    /**
     * Pide al usuario el numero de alumnos de la clase
     */
    private static int pedirNumeroAlumnos() {
        System.out.print("Introduce el numero de alumnos de la clase: ");
        int numero = sc.nextInt();
        return numero;
    }
    
    /**
     * Pide los datos (nombre y nota) de cada alumno
     */
    private static void pedirDatosAlumnos(int numeroAlumnos) {
        System.out.println("\nINTRODUCIR DATOS DE ALUMNOS");
        
        for (int indice = 0; indice < numeroAlumnos; indice++) {
            System.out.println("\nAlumno " + (indice + 1) + ":");
            
            // Pedir nombre
            System.out.print("Nombre: ");
            String nombre = sc.next();
            
            // Pedir nota
            System.out.print("Nota (0-10): ");
            double nota = sc.nextDouble();
            
            // Crear y agregar el alumno
            AlumnoClaseResuelto alumno = new AlumnoClaseResuelto(nombre, nota);
            listaAlumnos.add(alumno);
        }
        
        System.out.println("\nTodos los alumnos han sido introducidos correctamente.");
    }
    
    /**
     * Muestra el alumno con la mejor nota
     */
    private static void mostrarMejorAlumno() {
        System.out.println("\nALUMNO CON MEJOR NOTA");
        
        if (listaAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        
        // Buscar el alumno con mejor nota
        AlumnoClaseResuelto mejorAlumno = listaAlumnos.get(0);
        for (AlumnoClaseResuelto alumno : listaAlumnos) {
            if (alumno.getNota() > mejorAlumno.getNota()) {
                mejorAlumno = alumno;
            }
        }
        
        System.out.println("Alumno con mejor nota:");
        System.out.println("Nombre: " + mejorAlumno.getNombre());
        System.out.println("Nota: " + mejorAlumno.getNota());
    }
    
    /**
     * Muestra todos los alumnos ordenados por nota (de mayor a menor)
     */
    private static void mostrarAlumnosOrdenados() {
        System.out.println("\nALUMNOS ORDENADOS POR NOTA");
        
        if (listaAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        
        // Crear una copia para ordenar (no modificar la original)
        ArrayList<AlumnoClaseResuelto> alumnosOrdenados = new ArrayList<>(listaAlumnos);
        
        // Ordenar por nota de mayor a menor usando Comparator
        alumnosOrdenados.sort(new Comparator<AlumnoClaseResuelto>() {
            @Override
            public int compare(AlumnoClaseResuelto a1, AlumnoClaseResuelto a2) {
                // Ordenar de mayor a menor (nota descendente)
                return Double.compare(a2.getNota(), a1.getNota());
            }
        });
        
        // Mostrar los alumnos ordenados
        System.out.println("Listado de alumnos ordenados por nota (de mayor a menor):\n");
        for (int posicion = 0; posicion < alumnosOrdenados.size(); posicion++) {
            AlumnoClaseResuelto alumno = alumnosOrdenados.get(posicion);
            System.out.println((posicion + 1) + ". " + alumno.getNombre() + " - Nota: " + alumno.getNota());
        }
    }
}

/**
 * Clase que representa un Alumno de clase
 * Contiene nombre y nota
 */
class AlumnoClaseResuelto {
    private String nombre;
    private double nota;
    
    /**
     * Constructor de la clase AlumnoClaseResuelto
     */
    public AlumnoClaseResuelto(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public double getNota() {
        return nota;
    }
}

