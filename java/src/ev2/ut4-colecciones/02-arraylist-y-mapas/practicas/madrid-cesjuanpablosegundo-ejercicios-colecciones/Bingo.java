package madrid.cesjuanpablosegundo;

import java.util.Random;

/**
 * Programa que simula un juego de Bingo
 * Cada carton es una matriz 5x5 con numeros aleatorios entre 1 y 75
 * El espacio central esta marcado como "libre" (XX)
 */
public class Bingo {
    private static final int FILAS = 5;
    private static final int COLUMNAS = 5;
    private static final int NUMERO_MIN = 1;
    private static final int NUMERO_MAX = 75;
    
    private int[][] carton;
    private boolean[][] cartonMarcado;
    private int[] numerosCantados;  // Array unidimensional para numeros cantados
    private int cantidadNumerosCantados;  // Contador de numeros cantados
    private Random random;
    private boolean lineaCompletada;
    private boolean bingoCompletado;
    
    /**
     * Constructor que inicializa el juego
     */
    public Bingo() {
        this.carton = new int[FILAS][COLUMNAS];
        this.cartonMarcado = new boolean[FILAS][COLUMNAS];
        this.numerosCantados = new int[NUMERO_MAX];  // Array de tamano 75
        this.cantidadNumerosCantados = 0;
        this.random = new Random();
        this.lineaCompletada = false;
        this.bingoCompletado = false;
        
        // Inicializar el espacio central como marcado
        cartonMarcado[2][2] = true;  // Centro de la matriz 5x5
    }
    
    /**
     * Genera un carton de Bingo con numeros aleatorios
     */
    public void generarCarton() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                // El espacio central se deja como 0 (se mostrara como XX)
                if (i == 2 && j == 2) {
                    carton[i][j] = 0;
                } else {
                    // Generar numero aleatorio entre 1 y 75
                    int numero;
                    boolean repetido;
                    do {
                        numero = random.nextInt(NUMERO_MAX) + NUMERO_MIN;
                        repetido = false;
                        // Verificar que no este repetido en el carton
                        for (int k = 0; k < FILAS; k++) {
                            for (int l = 0; l < COLUMNAS; l++) {
                                if (carton[k][l] == numero) {
                                    repetido = true;
                                    break;
                                }
                            }
                            if (repetido) break;
                        }
                    } while (repetido);
                    carton[i][j] = numero;
                }
            }
        }
    }
    
    /**
     * Verifica si un numero ya fue cantado
     */
    private boolean yaFueCantado(int numero) {
        for (int i = 0; i < cantidadNumerosCantados; i++) {
            if (numerosCantados[i] == numero) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Genera un numero aleatorio entre 1 y 75 que no haya sido cantado
     * @return el numero generado, o -1 si ya se cantaron todos
     */
    public int generarNumeroCantado() {
        if (cantidadNumerosCantados >= NUMERO_MAX) {
            return -1; // Ya se cantaron todos los numeros
        }
        
        int numero;
        do {
            numero = random.nextInt(NUMERO_MAX) + NUMERO_MIN;
        } while (yaFueCantado(numero));
        
        numerosCantados[cantidadNumerosCantados] = numero;
        cantidadNumerosCantados++;
        return numero;
    }
    
    /**
     * Marca un numero en el carton si esta presente
     * @param numero el numero a marcar
     * @return true si el numero estaba en el carton y fue marcado
     */
    public boolean marcarNumero(int numero) {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (carton[i][j] == numero) {
                    cartonMarcado[i][j] = true;
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Verifica si hay una linea completa (horizontal, vertical o diagonal)
     * @return true si hay al menos una linea completa
     */
    public boolean verificarLinea() {
        // Verificar lineas horizontales
        for (int i = 0; i < FILAS; i++) {
            boolean lineaCompleta = true;
            for (int j = 0; j < COLUMNAS; j++) {
                if (!cartonMarcado[i][j]) {
                    lineaCompleta = false;
                    break;
                }
            }
            if (lineaCompleta) {
                return true;
            }
        }
        
        // Verificar lineas verticales
        for (int j = 0; j < COLUMNAS; j++) {
            boolean lineaCompleta = true;
            for (int i = 0; i < FILAS; i++) {
                if (!cartonMarcado[i][j]) {
                    lineaCompleta = false;
                    break;
                }
            }
            if (lineaCompleta) {
                return true;
            }
        }
        
        // Verificar diagonal principal (de arriba-izquierda a abajo-derecha)
        boolean diagonalPrincipal = true;
        for (int i = 0; i < FILAS; i++) {
            if (!cartonMarcado[i][i]) {
                diagonalPrincipal = false;
                break;
            }
        }
        if (diagonalPrincipal) {
            return true;
        }
        
        // Verificar diagonal secundaria (de arriba-derecha a abajo-izquierda)
        boolean diagonalSecundaria = true;
        for (int i = 0; i < FILAS; i++) {
            if (!cartonMarcado[i][COLUMNAS - 1 - i]) {
                diagonalSecundaria = false;
                break;
            }
        }
        if (diagonalSecundaria) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Verifica si el carton completo esta marcado (Bingo completo)
     * @return true si todas las casillas estan marcadas
     */
    public boolean verificarBingo() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (!cartonMarcado[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Muestra el carton actualizado en la consola
     */
    public void mostrarCarton() {
        System.out.println("\nCarton de Bingo:\n");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (carton[i][j] == 0) {
                    // Espacio libre (centro)
                    System.out.print("XX   ");
                } else if (cartonMarcado[i][j]) {
                    // Numero marcado
                    System.out.print("[" + carton[i][j] + "]  ");
                } else {
                    // Numero sin marcar
                    if (carton[i][j] < 10) {
                        System.out.print(carton[i][j] + "    ");
                    } else {
                        System.out.print(carton[i][j] + "   ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * Metodo principal que ejecuta el juego
     */
    public void jugar() {
        System.out.println("=== JUEGO DE BINGO ===\n");
        
        // Generar el carton
        generarCarton();
        mostrarCarton();
        
        // Simular el juego hasta que se complete el Bingo
        while (!bingoCompletado) {
            int numeroCantado = generarNumeroCantado();
            
            if (numeroCantado == -1) {
                System.out.println("Se han cantado todos los numeros posibles.");
                break;
            }
            
            System.out.println("Numero cantado: " + numeroCantado);
            
            // Marcar el numero si esta en el carton
            if (marcarNumero(numeroCantado)) {
                System.out.println("!Numero encontrado en tu carton!");
            }
            
            // Mostrar el carton actualizado
            mostrarCarton();
            
            // Verificar si se completo una linea (solo la primera vez)
            if (!lineaCompletada && verificarLinea()) {
                lineaCompletada = true;
                System.out.println("!LINEA! Has completado una linea horizontal, vertical o diagonal.\n");
            }
            
            // Verificar si se completo el Bingo
            if (verificarBingo()) {
                bingoCompletado = true;
                System.out.println("!BINGO! Has completado el carton completo.\n");
                break;
            }
        }
        
        System.out.println("=== FIN DEL JUEGO ===");
        System.out.println("Total de numeros cantados: " + cantidadNumerosCantados);
    }
    
    /**
     * Metodo main para ejecutar el programa
     */
    public static void main(String[] args) {
        Bingo juego = new Bingo();
        juego.jugar();
    }
}

