package ev2.ut4_colecciones.u03repaso.practicas.madridcesjuanpablosegundoexamen1evaluacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase para realizar el sorteo del mundial
 * Permite introducir selecciones de dos bombos y hacer emparejamientos
  *
 * * PLANTILLA DOCENTE: completar solucion docente.
 */
public class SorteoMundial_RESUELTO {
    
    private static ArrayList<String> bombo1 = new ArrayList<>();
    private static ArrayList<String> bombo2 = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();
    
    /**
     * Metodo principal que inicia la aplicacion
     */
    public static void main(String[] args) {
        System.out.println("SORTEO DEL MUNDIAL\n");
        
        // Pedir selecciones del bombo 1
        System.out.println("BOMBO 1");
        pedirSelecciones(bombo1, 1);
        
        // Pedir selecciones del bombo 2
        System.out.println("\nBOMBO 2");
        pedirSelecciones(bombo2, 2);
        
        // Mostrar los emparejamientos
        mostrarEmparejamientos();
    }
    
    /**
     * Pide las selecciones de un bombo
     */
    private static void pedirSelecciones(ArrayList<String> bombo, int numeroBombo) {
        System.out.println("Introduce las 5 selecciones del bombo " + numeroBombo + ":");
        
        for (int indice = 0; indice < 5; indice++) {
            System.out.print("Seleccion " + (indice + 1) + ": ");
            String seleccion = sc.next();
            
            // Verificar que no este vacia
            if (seleccion.isEmpty()) {
                System.out.println("El nombre no puede estar vacio. Intentalo de nuevo.");
                indice--; // Repetir esta iteracion
                continue;
            }
            
            // Verificar que no este duplicada en el mismo bombo
            if (bombo.contains(seleccion)) {
                System.out.println("Esta seleccion ya esta en el bombo. Intentalo de nuevo.");
                indice--; // Repetir esta iteracion
                continue;
            }
            
            bombo.add(seleccion);
        }
        
        System.out.println("Bombo " + numeroBombo + " completado.");
    }
    
    /**
     * Realiza y muestra los emparejamientos entre los dos bombos
     * Cada equipo del bombo 1 se empareja con uno del bombo 2 de forma aleatoria
     */
    private static void mostrarEmparejamientos() {
        System.out.println("\nEMPAREJAMIENTOS DEL SORTEO\n");
        
        // Crear una copia del bombo 2 para no modificar el original
        ArrayList<String> bombo2Copia = new ArrayList<>(bombo2);
        
        // Mezclar aleatoriamente el bombo 2 para hacer el sorteo
        Collections.shuffle(bombo2Copia, random);
        
        // Mostrar los emparejamientos
        System.out.println("Los emparejamientos son:\n");
        for (int indice = 0; indice < 5; indice++) {
            String equipo1 = bombo1.get(indice);
            String equipo2 = bombo2Copia.get(indice);
            System.out.println("Partido " + (indice + 1) + ": " + equipo1 + " vs " + equipo2);
        }
        
        System.out.println("\nSorteo completado. !Buena suerte a todos los equipos!");
    }
}

