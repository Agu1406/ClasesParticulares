package madrid.cesjuanpablosegundo.examen1evaluacion;

import java.util.Scanner;
import java.util.Random;

/**
 * Clase para gestionar operaciones con arrays multidimensionales de 3x3
 * Permite rellenar, rotar filas y rotar columnas
 */
public class GestionArrayMultidimensional {
    
    // Array bidimensional de 3x3
    private static int[][] array = new int[3][3];
    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();
    
    /**
     * Metodo principal que inicia la aplicacion
     */
    public static void main(String[] args) {
        int opcion;
        boolean arrayRellenado = false;
        
        // Bucle principal del menu
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            
            switch(opcion) {
                case 1:
                    rellenarArray();
                    arrayRellenado = true;
                    break;
                case 2:
                    if (arrayRellenado) {
                        rotarFilasAbajo();
                    } else {
                        System.out.println("Primero debes rellenar el array (opcion 1).");
                    }
                    break;
                case 3:
                    if (arrayRellenado) {
                        rotarColumnasIzquierda();
                    } else {
                        System.out.println("Primero debes rellenar el array (opcion 1).");
                    }
                    break;
                case 4:
                    mostrarArray();
                    break;
                case 5:
                    System.out.println("!Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion no valida. Intentalo de nuevo.");
            }
            
        } while(opcion != 5);
    }
    
    /**
     * Muestra el menu principal de opciones
     */
    private static void mostrarMenu() {
        System.out.println("\nGESTION DE ARRAY MULTIDIMENSIONAL 3x3");
        System.out.println("1. Rellenar array");
        System.out.println("2. Rotar filas abajo");
        System.out.println("3. Rotar columnas izquierda");
        System.out.println("4. Mostrar array");
        System.out.println("5. Salir");
        System.out.print("Elige una opcion: ");
    }
    
    /**
     * Rellena el array con numeros aleatorios entre 1 y 10
     */
    private static void rellenarArray() {
        System.out.println("\nRELLENAR ARRAY");
        
        // Rellenar cada posicion con un numero aleatorio entre 1 y 10
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                array[fila][columna] = random.nextInt(10) + 1; // Numeros del 1 al 10
            }
        }
        
        System.out.println("Array rellenado correctamente con numeros aleatorios (1-10).");
        mostrarArray();
    }
    
    /**
     * Rota todas las filas del array una posicion hacia abajo
     * La ultima fila pasa a ser la primera
     */
    private static void rotarFilasAbajo() {
        System.out.println("\nROTAR FILAS ABAJO");
        
        // Guardar la ultima fila
        int[] ultimaFila = new int[3];
        for (int columna = 0; columna < 3; columna++) {
            ultimaFila[columna] = array[2][columna];
        }
        
        // Mover las filas hacia abajo (de abajo hacia arriba para no sobrescribir)
        for (int fila = 2; fila > 0; fila--) {
            for (int columna = 0; columna < 3; columna++) {
                array[fila][columna] = array[fila - 1][columna];
            }
        }
        
        // Poner la ultima fila en la primera posicion
        for (int columna = 0; columna < 3; columna++) {
            array[0][columna] = ultimaFila[columna];
        }
        
        System.out.println("Filas rotadas correctamente hacia abajo.");
        mostrarArray();
    }
    
    /**
     * Rota todas las columnas del array una posicion hacia la izquierda
     * La primera columna pasa a ser la ultima
     */
    private static void rotarColumnasIzquierda() {
        System.out.println("\nROTAR COLUMNAS IZQUIERDA");
        
        // Guardar la primera columna
        int[] primeraColumna = new int[3];
        for (int fila = 0; fila < 3; fila++) {
            primeraColumna[fila] = array[fila][0];
        }
        
        // Mover las columnas hacia la izquierda (de izquierda a derecha para no sobrescribir)
        for (int columna = 0; columna < 2; columna++) {
            for (int fila = 0; fila < 3; fila++) {
                array[fila][columna] = array[fila][columna + 1];
            }
        }
        
        // Poner la primera columna en la ultima posicion
        for (int fila = 0; fila < 3; fila++) {
            array[fila][2] = primeraColumna[fila];
        }
        
        System.out.println("Columnas rotadas correctamente hacia la izquierda.");
        mostrarArray();
    }
    
    /**
     * Muestra el contenido del array en formato tabular
     */
    private static void mostrarArray() {
        System.out.println("\nCONTENIDO DEL ARRAY");
        
        // Mostrar el array de forma legible
        for (int fila = 0; fila < 3; fila++) {
            System.out.print("Fila " + (fila + 1) + ": [ ");
            for (int columna = 0; columna < 3; columna++) {
                System.out.print(array[fila][columna]);
                if (columna < 2) {
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
        System.out.println();
    }
}

