package andalucia.sevilla.iesvelazquez.DAM2.tallermecanicomultihilo;

import java.util.Random;

/**
 * Simulación del taller mecánico con un mecánico y varios coches.
 */
public class Main {
    // Número máximo de coches que caben en el aparcamiento de espera
    private static final int CAPACIDAD_APARCAMIENTO = 5;
    // Total de coches que van a llegar al taller durante la simulación
    private static final int NUMERO_COCHES = 10;
    // Tiempo mínimo que tarda el mecánico en reparar un coche (milisegundos)
    private static final int TIEMPO_MINIMO_REPARACION = 1000;
    // Tiempo máximo que tarda el mecánico en reparar un coche (milisegundos)
    private static final int TIEMPO_MAXIMO_REPARACION = 3000;
    // Tiempo mínimo de espera entre que llega un coche y el siguiente (milisegundos)
    private static final int TIEMPO_MINIMO_ENTRE_LLEGADAS = 500;
    // Tiempo máximo de espera entre que llega un coche y el siguiente (milisegundos)
    private static final int TIEMPO_MAXIMO_ENTRE_LLEGADAS = 2000;

    public static void main(String[] args) {
        // Objeto para generar números aleatorios, usado para simular llegadas aleatorias
        Random random = new Random();
        
        // Variables que se usarán en el método main
        TallerMecanico taller;
        Mecanico mecanico;
        Thread hiloMecanico;
        Thread[] hilosCoches;
        int tiempoEspera;
        int idCoche;
        Coche coche;
        Thread hiloCoche;
        
        System.out.println("=== Taller Mecánico - Simulación Multihilo ===");
        System.out.println();
        System.out.println("Configuración:");
        System.out.println("  Capacidad del aparcamiento: " + CAPACIDAD_APARCAMIENTO + " plazas");
        System.out.println("  Número de coches: " + NUMERO_COCHES);
        System.out.println("  Tiempo de reparación: " + TIEMPO_MINIMO_REPARACION + "-" + 
                         TIEMPO_MAXIMO_REPARACION + " ms");
        System.out.println("  Tiempo entre llegadas: " + TIEMPO_MINIMO_ENTRE_LLEGADAS + "-" + 
                         TIEMPO_MAXIMO_ENTRE_LLEGADAS + " ms");
        System.out.println();

        // Creamos el taller que coordinará todo
        taller = new TallerMecanico(CAPACIDAD_APARCAMIENTO);
        // Creamos el mecánico que trabajará en el taller
        mecanico = new Mecanico(taller, TIEMPO_MINIMO_REPARACION, TIEMPO_MAXIMO_REPARACION);
        // Creamos el hilo donde correrá el mecánico
        hiloMecanico = new Thread(mecanico, "Mecánico");
        // Iniciamos el hilo del mecánico para que empiece a trabajar
        hiloMecanico.start();

        // Array para guardar todos los hilos de los coches
        hilosCoches = new Thread[NUMERO_COCHES];

        // Bucle que crea y lanza cada coche con un tiempo aleatorio entre llegadas
        for (int i = 0; i < NUMERO_COCHES; i++) {
            // Calculamos un tiempo aleatorio entre el mínimo y máximo para simular llegadas reales
            tiempoEspera = TIEMPO_MINIMO_ENTRE_LLEGADAS + 
                random.nextInt(TIEMPO_MAXIMO_ENTRE_LLEGADAS - TIEMPO_MINIMO_ENTRE_LLEGADAS + 1);
            
            // Try-catch para manejar si el hilo principal es interrumpido mientras duerme
            try {
                // Esperamos el tiempo calculado antes de crear el siguiente coche
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                // Si nos interrumpen, marcamos el hilo como interrumpido y salimos
                Thread.currentThread().interrupt();
                return;
            }
            
            // Obtenemos un ID único para este coche
            idCoche = taller.obtenerNuevoIdCoche();
            // Creamos el objeto coche
            coche = new Coche(taller, idCoche);
            // Creamos el hilo donde correrá este coche
            hiloCoche = new Thread(coche, "Coche-" + idCoche);
            // Guardamos el hilo en el array para poder esperar a que termine después
            hilosCoches[i] = hiloCoche;
            // Iniciamos el hilo del coche para que empiece a ejecutarse
            hiloCoche.start();
            
            System.out.println("Llega el coche " + idCoche + " al taller");
        }

        System.out.println();
        System.out.println("Todos los coches han llegado. Esperando a que terminen...");
        
        // Bucle que recorre todos los hilos de los coches esperando a que terminen
        for (Thread hiloCocheTemp : hilosCoches) {
            // Try-catch para manejar si nos interrumpen mientras esperamos
            try {
                // Esperamos a que este coche termine completamente su ejecución
                hiloCocheTemp.join();
            } catch (InterruptedException e) {
                // Si nos interrumpen, marcamos el hilo como interrumpido
                Thread.currentThread().interrupt();
            }
        }

        // Try-catch para manejar si nos interrumpen mientras esperamos
        try {
            // Esperamos un poco más para que el mecánico termine de reparar los últimos coches
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Si nos interrumpen, marcamos el hilo como interrumpido
            Thread.currentThread().interrupt();
        }

        // Condición if para verificar si el mecánico aún está trabajando
        if (hiloMecanico.isAlive()) {
            System.out.println();
            System.out.println("Deteniendo al mecánico...");
            // Interrumpimos el hilo del mecánico para que termine
            hiloMecanico.interrupt();
            
            // Try-catch para manejar si nos interrumpen mientras esperamos
            try {
                // Esperamos a que el mecánico termine completamente
                hiloMecanico.join();
            } catch (InterruptedException e) {
                // Si nos interrumpen, marcamos el hilo como interrumpido
                Thread.currentThread().interrupt();
            }
        }

        System.out.println();
        System.out.println("Simulación terminada");
    }
}
