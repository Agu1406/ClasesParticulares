package ev3.ut6.u01herenciapolimorfismo.practicas.salamancacolegiosalesianocontrolhabitantesedificio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Control de habitantes en un edificio (Colegio Salesiano, Salamanca).
 *
 * <p>Enunciado: {@code control-habitantes-edificio--salamanca-colegiosalesiano.pdf}
 * (carpeta de la practica).</p>
 *
 * <p><b>Objetivo:</b> registrar y consultar habitantes por piso y puerta mediante menu.</p>
 *
 * <p>Para ello, el programa debe:</p>
 * <ul>
 *   <li>Almacenar habitantes en una matriz 6?4 (pisos y puertas A-D).</li>
 *   <li>Pedir datos iniciales y ofrecer opciones de consulta y modificacion.</li>
 *   <li>Mostrar totales y desgloses segun el enunciado.</li>
 * </ul>
 *
 * <p>Utiliza matrices bidimensionales, {@link java.io.BufferedReader} y menu por consola.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class ControlHabitantesEdificio_RESUELTO {
    
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
            
            // Mostrar menu y procesar opciones
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
                        System.out.println("\nSaliendo del programa. !Hasta luego!");
                        break;
                    default:
                        System.out.println("\nOpcion no valida. Por favor, elija una opcion del 1 al 5.");
                }
                
                if (opcion != 5) {
                    System.out.println("\nPresione Enter para volver al menu...");
                    lector.readLine();
                }
            } while (opcion != 5);
            
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: debe introducir un numero valido.");
        }
    }
    
    /**
     * Pide al usuario que introduzca el numero de habitantes de cada puerta
     */
    private static void pedirDatosHabitantes() throws IOException {
        System.out.println("Introduzca el numero de habitantes para cada puerta del edificio:\n");
        
        for (int piso = 0; piso < NUM_PISOS; piso++) {
            for (int puerta = 0; puerta < NUM_PUERTAS; puerta++) {
                System.out.print("Piso " + (piso + 1) + ", Puerta " + LETRAS_PUERTAS[puerta] + ": ");
                habitantes[piso][puerta] = Integer.parseInt(lector.readLine());
                
                // Validar que no sea negativo
                while (habitantes[piso][puerta] < 0) {
                    System.out.print("El numero de habitantes no puede ser negativo. Intentelo de nuevo: ");
                    habitantes[piso][puerta] = Integer.parseInt(lector.readLine());
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Muestra el menu de opciones
     */
    private static void mostrarMenu() {
        System.out.println("\nMenu de opciones:");
        System.out.println("1. Obtener el numero maximo y minimo de habitantes");
        System.out.println("2. Calcular la media de habitantes por letra");
        System.out.println("3. Calcular la media de habitantes por piso");
        System.out.println("4. Mostrar los datos en forma de tabla");
        System.out.println("5. Salir del programa");
        System.out.print("\nSeleccione una opcion (1-5): ");
    }
    
    /**
     * Opcion A: Obtener el numero maximo y minimo de habitantes
     */
    private static void opcionA_MaximoMinimo() {
        int maximo = habitantes[0][0];
        int minimo = habitantes[0][0];
        
        // Encontrar maximo y minimo
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
        
        // Mostrar todas las posiciones con el maximo
        System.out.println("\nEl numero maximo de habitantes pertenece al piso " + 
                          obtenerPrimerPisoConValor(maximo) + ", letra " + 
                          obtenerPrimeraLetraConValor(maximo) + ".");
        mostrarTodasLasPosicionesConValor(maximo);
        
        // Mostrar todas las posiciones con el minimo
        System.out.println("El numero minimo pertenece al piso " + 
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
     * Opcion B: Calcular la media de habitantes por letra
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
     * Opcion C: Calcular la media de habitantes por piso
     */
    private static void opcionC_MediaPorPiso() {
        double[] mediasPisos = new double[NUM_PISOS];
        
        // Calcular la media de cada piso
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
        
        // Determinar cuantas puertas superan la media en cada piso
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
     * Opcion D: Mostrar los datos en forma de tabla
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

