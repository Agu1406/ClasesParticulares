package ev3.ut6.u03concurrenciamultihilo.practicas.sevillaiesvelazqueztallermecanicomultihilo;

import java.util.Random;

/**
 * Simulacion de taller mecanico con cola de coches (IES Velazquez).
 *
 * <p>Enunciado: {@code taller-mecanico--sevilla-iesvelazquez.pdf} (carpeta de la practica).</p>
 *
 * <p><b>Objetivo:</b> coordinar un mecanico y varios coches con hilos y aparcamiento limitado.</p>
 *
 * <p>Para ello, el programa debe:</p>
 * <ul>
 *   <li>Modelar el taller ({@link TallerMecanico_SIN_RESOLVER}) y el hilo del {@link Mecanico_SIN_RESOLVER}.</li>
 *   <li>Lanzar coches ({@link Coche_SIN_RESOLVER}) que esperan o son atendidos segun capacidad.</li>
 *   <li>Simular tiempos de reparacion y llegadas aleatorias.</li>
 * </ul>
 *
 * <p>Utiliza {@link Thread}, sincronizacion y {@link Random}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Main_SIN_RESOLVER {
    // Numero maximo de coches que caben en el aparcamiento de espera
    private static final int CAPACIDAD_APARCAMIENTO = 5;
    // Total de coches que van a llegar al taller durante la simulacion
    private static final int NUMERO_COCHES = 10;
    // Tiempo minimo que tarda el mecanico en reparar un coche (milisegundos)
    private static final int TIEMPO_MINIMO_REPARACION = 1000;
    // Tiempo maximo que tarda el mecanico en reparar un coche (milisegundos)
    private static final int TIEMPO_MAXIMO_REPARACION = 3000;
    // Tiempo minimo de espera entre que llega un coche y el siguiente (milisegundos)
    private static final int TIEMPO_MINIMO_ENTRE_LLEGADAS = 500;
    // Tiempo maximo de espera entre que llega un coche y el siguiente (milisegundos)
    private static final int TIEMPO_MAXIMO_ENTRE_LLEGADAS = 2000;

    public static void main(String[] args) {
        // Objeto para generar numeros aleatorios, usado para simular llegadas aleatorias
        Random random = new Random();
        
        // Variables que se usaran en el metodo main
        TallerMecanico_SIN_RESOLVER taller;
        Mecanico_SIN_RESOLVER mecanico;
        Thread hiloMecanico;
        Thread[] hilosCoches;
        int tiempoEspera;
        int idCoche;
        Coche_SIN_RESOLVER coche;
        Thread hiloCoche;
        
        System.out.println("=== Taller Mecanico_SIN_RESOLVER - Simulacion Multihilo ===");
        System.out.println();
        System.out.println("Configuracion:");
        System.out.println("  Capacidad del aparcamiento: " + CAPACIDAD_APARCAMIENTO + " plazas");
        System.out.println("  Numero de coches: " + NUMERO_COCHES);
        System.out.println("  Tiempo de reparacion: " + TIEMPO_MINIMO_REPARACION + "-" + 
                         TIEMPO_MAXIMO_REPARACION + " ms");
        System.out.println("  Tiempo entre llegadas: " + TIEMPO_MINIMO_ENTRE_LLEGADAS + "-" + 
                         TIEMPO_MAXIMO_ENTRE_LLEGADAS + " ms");
        System.out.println();

        // Creamos el taller que coordinara todo
        taller = new TallerMecanico_SIN_RESOLVER(CAPACIDAD_APARCAMIENTO);
        // Creamos el mecanico que trabajara en el taller
        mecanico = new Mecanico_SIN_RESOLVER(taller, TIEMPO_MINIMO_REPARACION, TIEMPO_MAXIMO_REPARACION);
        // Creamos el hilo donde correra el mecanico
        hiloMecanico = new Thread(mecanico, "Mecanico_SIN_RESOLVER");
        // Iniciamos el hilo del mecanico para que empiece a trabajar
        hiloMecanico.start();

        // Array para guardar todos los hilos de los coches
        hilosCoches = new Thread[NUMERO_COCHES];

        // Bucle que crea y lanza cada coche con un tiempo aleatorio entre llegadas
        for (int i = 0; i < NUMERO_COCHES; i++) {
            // Calculamos un tiempo aleatorio entre el minimo y maximo para simular llegadas reales
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
            
            // Obtenemos un ID unico para este coche
            idCoche = taller.obtenerNuevoIdCoche();
            // Creamos el objeto coche
            coche = new Coche_SIN_RESOLVER(taller, idCoche);
            // Creamos el hilo donde correra este coche
            hiloCoche = new Thread(coche, "Coche_SIN_RESOLVER-" + idCoche);
            // Guardamos el hilo en el array para poder esperar a que termine despues
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
                // Esperamos a que este coche termine completamente su ejecucion
                hiloCocheTemp.join();
            } catch (InterruptedException e) {
                // Si nos interrumpen, marcamos el hilo como interrumpido
                Thread.currentThread().interrupt();
            }
        }

        // Try-catch para manejar si nos interrumpen mientras esperamos
        try {
            // Esperamos un poco mas para que el mecanico termine de reparar los ultimos coches
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Si nos interrumpen, marcamos el hilo como interrumpido
            Thread.currentThread().interrupt();
        }

        // Condicion if para verificar si el mecanico aun esta trabajando
        if (hiloMecanico.isAlive()) {
            System.out.println();
            System.out.println("Deteniendo al mecanico...");
            // Interrumpimos el hilo del mecanico para que termine
            hiloMecanico.interrupt();
            
            // Try-catch para manejar si nos interrumpen mientras esperamos
            try {
                // Esperamos a que el mecanico termine completamente
                hiloMecanico.join();
            } catch (InterruptedException e) {
                // Si nos interrumpen, marcamos el hilo como interrumpido
                Thread.currentThread().interrupt();
            }
        }

        System.out.println();
        System.out.println("Simulacion terminada");
    }
}
