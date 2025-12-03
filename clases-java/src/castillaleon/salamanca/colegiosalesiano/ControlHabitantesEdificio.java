import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Ejercicio: Control de Habitantes en un Edificio
 * 
 * Se desea controlar el número de habitantes en un edificio de 6 pisos 
 * y 4 puertas por piso (A, B, C y D).
 */
public class ControlHabitantesEdificio {
    
    // Constantes para las dimensiones del edificio
    private static final int NUM_PISOS = 6;
    private static final int NUM_PUERTAS = 4;
    private static final char[] LETRAS_PUERTAS = {'A', 'B', 'C', 'D'};
    
    // Matriz para almacenar los habitantes: [piso][puerta]
    // piso: 0-5 (representa pisos 1-6)
    // puerta: 0=A, 1=B, 2=C, 3=D
    private static int[][] habitantes;
    private static BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) {
        try {
            habitantes = new int[NUM_PISOS][NUM_PUERTAS];
            
            // Pedir los datos de habitantes
            pedirDatosHabitantes();
            
            // Mostrar menú y procesar opciones
            int opcion;
            
            do {
                mostrarMenu();
                opcion = Integer.parseInt(lector.readLine());
                
                switch (opcion) {
                    case 1:
                        opcionA_MaximoMinimo();
                        break;
                    case 2:
                        opcionB_MediaPorLetra();
                        break;
                    case 3:
                        opcionC_MediaPorPiso();
                        break;
                    case 4:
                        opcionD_MostrarTabla();
                        break;
                    case 5:
                        System.out.println("\nSaliendo del programa. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("\nOpción no válida. Por favor, elija una opción del 1 al 5.");
                }
                
                if (opcion != 5) {
                    System.out.println("\nPresione Enter para volver al menú...");
                    lector.readLine();
                }
            } while (opcion != 5);
            
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: debe introducir un número válido.");
        }
    }
    
    /**
     * Pide al usuario que introduzca el número de habitantes de cada puerta
     */
    private static void pedirDatosHabitantes() throws IOException {
        System.out.println("Introduzca el número de habitantes para cada puerta del edificio:\n");
        
        for (int piso = 0; piso < NUM_PISOS; piso++) {
            for (int puerta = 0; puerta < NUM_PUERTAS; puerta++) {
                System.out.print("Piso " + (piso + 1) + ", Puerta " + LETRAS_PUERTAS[puerta] + ": ");
                habitantes[piso][puerta] = Integer.parseInt(lector.readLine());
                
                // Validar que no sea negativo
                while (habitantes[piso][puerta] < 0) {
                    System.out.print("El número de habitantes no puede ser negativo. Inténtelo de nuevo: ");
                    habitantes[piso][puerta] = Integer.parseInt(lector.readLine());
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Muestra el menú de opciones
     */
    private static void mostrarMenu() {
        System.out.println("\nMenú de opciones:");
        System.out.println("1. Obtener el número máximo y mínimo de habitantes");
        System.out.println("2. Calcular la media de habitantes por letra");
        System.out.println("3. Calcular la media de habitantes por piso");
        System.out.println("4. Mostrar los datos en forma de tabla");
        System.out.println("5. Salir del programa");
        System.out.print("\nSeleccione una opción (1-5): ");
    }
    
    /**
     * Opción A: Obtener el número máximo y mínimo de habitantes
     */
    private static void opcionA_MaximoMinimo() {
        int maximo = habitantes[0][0];
        int minimo = habitantes[0][0];
        
        // Encontrar máximo y mínimo
        for (int piso = 0; piso < NUM_PISOS; piso++) {
            for (int puerta = 0; puerta < NUM_PUERTAS; puerta++) {
                if (habitantes[piso][puerta] > maximo) {
                    maximo = habitantes[piso][puerta];
                }
                if (habitantes[piso][puerta] < minimo) {
                    minimo = habitantes[piso][puerta];
                }
            }
        }
        
        // Mostrar todas las posiciones con el máximo
        System.out.println("\nEl número máximo de habitantes pertenece al piso " + 
                          obtenerPrimerPisoConValor(maximo) + ", letra " + 
                          obtenerPrimeraLetraConValor(maximo) + ".");
        mostrarTodasLasPosicionesConValor(maximo);
        
        // Mostrar todas las posiciones con el mínimo
        System.out.println("El número mínimo pertenece al piso " + 
                          obtenerPrimerPisoConValor(minimo) + ", letra " + 
                          obtenerPrimeraLetraConValor(minimo) + ".");
        mostrarTodasLasPosicionesConValor(minimo);
    }
    
    private static int obtenerPrimerPisoConValor(int valor) {
        for (int piso = 0; piso < NUM_PISOS; piso++) {
            for (int puerta = 0; puerta < NUM_PUERTAS; puerta++) {
                if (habitantes[piso][puerta] == valor) {
                    return piso + 1;
                }
            }
        }
        return 0;
    }
    
    private static char obtenerPrimeraLetraConValor(int valor) {
        for (int piso = 0; piso < NUM_PISOS; piso++) {
            for (int puerta = 0; puerta < NUM_PUERTAS; puerta++) {
                if (habitantes[piso][puerta] == valor) {
                    return LETRAS_PUERTAS[puerta];
                }
            }
        }
        return 'A';
    }
    
    private static void mostrarTodasLasPosicionesConValor(int valor) {
        int cantidadCoincidencias = 0;
        for (int piso = 0; piso < NUM_PISOS; piso++) {
            for (int puerta = 0; puerta < NUM_PUERTAS; puerta++) {
                if (habitantes[piso][puerta] == valor) {
                    cantidadCoincidencias++;
                }
            }
        }
        
        if (cantidadCoincidencias > 1) {
            for (int piso = 0; piso < NUM_PISOS; piso++) {
                for (int puerta = 0; puerta < NUM_PUERTAS; puerta++) {
                    if (habitantes[piso][puerta] == valor) {
                        System.out.println("  - Piso " + (piso + 1) + ", letra " + LETRAS_PUERTAS[puerta]);
                    }
                }
            }
        }
    }
    
    /**
     * Opción B: Calcular la media de habitantes por letra
     */
    private static void opcionB_MediaPorLetra() {
        for (int puerta = 0; puerta < NUM_PUERTAS; puerta++) {
            int suma = 0;
            for (int piso = 0; piso < NUM_PISOS; piso++) {
                suma += habitantes[piso][puerta];
            }
            double media = (double) suma / NUM_PISOS;
            System.out.printf("\nMedia de la letra %c = %.2f", LETRAS_PUERTAS[puerta], media);
        }
        System.out.println();
    }
    
    /**
     * Opción C: Calcular la media de habitantes por piso
     */
    private static void opcionC_MediaPorPiso() {
        double[] mediasPisos = new double[NUM_PISOS];
        
  en      // Calcular la media de cada piso
        for (int piso = 0; piso < NUM_PISOS; piso++) {
            int suma = 0;
            for (int puerta = 0; puerta < NUM_PUERTAS; puerta++) {
                suma += habitantes[piso][puerta];
            }
            mediasPisos[piso] = (double) suma / NUM_PUERTAS;
        }
        
        // Encontrar la menor media
        double menorMedia = mediasPisos[0];
        int pisoMenorMedia = 0;
        for (int piso = 1; piso < NUM_PISOS; piso++) {
            if (mediasPisos[piso] < menorMedia) {
                menorMedia = mediasPisos[piso];
                pisoMenorMedia = piso;
            }
        }
        
        System.out.printf("\nLa menor media de habitantes por piso es %.2f y corresponde al piso %d.%n", 
                         menorMedia, pisoMenorMedia + 1);
        
        // Determinar cuántas puertas superan la media en cada piso
        System.out.println("\nPuertas que superan la media en cada piso:");
        for (int piso = 0; piso < NUM_PISOS; piso++) {
            int contadorPuertasSuperanMedia = 0;
            for (int puerta = 0; puerta < NUM_PUERTAS; puerta++) {
                if (habitantes[piso][puerta] > mediasPisos[piso]) {
                    contadorPuertasSuperanMedia++;
                }
            }
            System.out.println("Piso " + (piso + 1) + ": " + contadorPuertasSuperanMedia + " puerta(s) superan la media");
        }
    }
    
    /**
     * Opción D: Mostrar los datos en forma de tabla
     */
    private static void opcionD_MostrarTabla() {
        System.out.println();
        
        // Encabezado
        System.out.printf("%-15s", "");
        for (int puerta = 0; puerta < NUM_PUERTAS; puerta++) {
            System.out.printf("%-15s", "Puerta " + LETRAS_PUERTAS[puerta]);
        }
        System.out.println();
        
        // Datos de cada piso
        for (int piso = 0; piso < NUM_PISOS; piso++) {
            System.out.printf("%-15s", "PISO " + (piso + 1));
            for (int puerta = 0; puerta < NUM_PUERTAS; puerta++) {
                System.out.printf("%-15d", habitantes[piso][puerta]);
            }
            System.out.println();
        }
    }
}

