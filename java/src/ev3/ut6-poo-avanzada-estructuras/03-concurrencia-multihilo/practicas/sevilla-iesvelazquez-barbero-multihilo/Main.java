package andalucia.sevilla.iesvelazquez.barberomultihilo;

import java.util.Random;

/**
 * Simulacion del problema del barbero dormilon (IES Velazquez).
 *
 * <p>Enunciado: {@code barbero-dormilon--sevilla-iesvelazquez.pdf} y
 * {@code barbero-simulacro--sevilla-iesvelazquez.pdf} (carpeta de la practica).</p>
 *
 * <p><b>Objetivo:</b> coordinar barbero y clientes con hilos, sala de espera limitada y exclusion mutua.</p>
 *
 * <p>Para ello, el programa debe:</p>
 * <ul>
 *   <li>Crear la barberia como monitor y lanzar el hilo del {@link Barbero}.</li>
 *   <li>Generar clientes ({@link Cliente}) que compiten por las sillas disponibles.</li>
 *   <li>Simular tiempos de servicio y llegadas aleatorias.</li>
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
public class Main {
    // Cantidad maxima de sillas de espera en la barberia
    private static final int CANTIDAD_SILLAS_SALA_ESPERA = 5;
    // Cantidad de clientes que seran atendidos "hoy" en la barberia
    private static final int CLIENTES_QUE_SERAN_ATENTIDOS = 15;
    // Cantidad de tiempo (milisegundos) que tarda el barbero en atender clientes
    private static final int TIEMPO_QUE_TARDA_EN_ATENDER = 3000;
    // Cantidad de tiempo (milisegundos) como minimo entre que llegan clientes
    private static final int TIEMPO_MINIMO_ENTRE_CLIENTES = 1000;
    // Cantidad de tiempo (milisegundos) como maximo sin que llegue un cliente
    private static final int TIEMPO_MAXIMO_ENTRE_CLIENTES = 5000;


    public static void main(String[] args) {
        // Objeto Random para generar numeros aleatorios (simula llegadas aleatorias de clientes)
        Random random = new Random();
        
        // Variable que almacenara el tiempo de espera entre la llegada de cada cliente
        int tiempoEspera;

        System.out.println("!Simulacro de barbero, barberia y clientes (multihilo)!");
        System.out.println("Capacidad maxima de la sala de espera: " + CANTIDAD_SILLAS_SALA_ESPERA);
        System.out.println("Numero de clientes que seran atendidos: " +  CLIENTES_QUE_SERAN_ATENTIDOS);
        System.out.println("Tiempo que tarda el barbero en atender: " + TIEMPO_QUE_TARDA_EN_ATENDER);

        /*
         * Creamos la barberia (objeto monitor) donde trabajara el barbero y donde iran los clientes.
         * Este objeto coordina la sincronizacion entre el barbero y los clientes usando metodos
         * sincronizados (synchronized, wait, notify, notifyAll).
         */
        BarberShop barberiaElias = new BarberShop(CANTIDAD_SILLAS_SALA_ESPERA);

        /*
         * Creacion del objeto Barbero que implementa Runnable.
         * Le pasamos la barberia donde trabajara y el tiempo que tarda en atender a cada cliente.
         */
        Barbero barberoElias = new Barbero(barberiaElias, TIEMPO_QUE_TARDA_EN_ATENDER);
        
        /*
         * Creacion del hilo del barbero. El primer parametro es el objeto Runnable (barberoElias)
         * y el segundo es el nombre del hilo que aparecera en los logs y depuracion.
         */
        Thread hiloBarbero = new Thread(barberoElias, "Barbero");
        
        /*
         * Iniciamos el hilo del barbero. Esto hace que el metodo run() del objeto Barbero
         * comience a ejecutarse en un hilo separado. El barbero empezara a trabajar de inmediato.
         */
        hiloBarbero.start();

        /*
         * Creacion de un array de Threads para almacenar todos los hilos de los clientes.
         * El tamano del array es CLIENTES_QUE_SERAN_ATENTIDOS porque crearemos un hilo por cliente.
         * Necesitamos este array para poder hacer join() despues y esperar a que todos terminen.
         */
        Thread[] clientes = new Thread[CLIENTES_QUE_SERAN_ATENTIDOS];

        /*
         * Bucle for que crea e inicia todos los hilos de los clientes.
         * idCliente va de 1 a CLIENTES_QUE_SERAN_ATENTIDOS (inclusive).
         * Cada iteracion crea un cliente, espera un tiempo aleatorio, y luego crea su hilo.
         */
        for (int idCliente = 1; idCliente <= CLIENTES_QUE_SERAN_ATENTIDOS; idCliente++) {
            /*
             * Try-catch para manejar posibles interrupciones mientras esperamos entre clientes.
             * Si el hilo principal es interrumpido, capturamos la excepcion y mostramos un mensaje.
             */
            try {
                /*
                 * Calculo del tiempo de espera aleatorio entre la llegada de este cliente y el siguiente.
                 * Genera un numero aleatorio entre TIEMPO_MINIMO_ENTRE_CLIENTES y TIEMPO_MAXIMO_ENTRE_CLIENTES.
                 * Esto simula que los clientes no llegan todos a la vez, sino de forma espaciada.
                 */
                tiempoEspera = TIEMPO_MINIMO_ENTRE_CLIENTES + random.nextInt(TIEMPO_MAXIMO_ENTRE_CLIENTES - TIEMPO_MINIMO_ENTRE_CLIENTES);
                
                /*
                 * Hacemos que el hilo principal duerma durante tiempoEspera milisegundos.
                 * Esto simula el tiempo que pasa entre la llegada de cada cliente.
                 */
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                System.out.println("!Error al intentar esperar entre clientes!");
            }

            // Creacion de un nuevo objeto Cliente (implementa Runnable)
            Cliente cliente = new Cliente(barberiaElias, idCliente);
            
            // Creacion del hilo asociado a este cliente
            Thread hiloCliente = new Thread(cliente, "Cliente " + idCliente);
            
            // Almacenamos el hilo del cliente en el array (indice idCliente - 1 porque arrays empiezan en 0)
            clientes[idCliente - 1] = hiloCliente;
            
            // Iniciamos el hilo del cliente (ejecuta run() en un hilo separado)
            hiloCliente.start();
        }

        /*
         * Bucle for-each que recorre todos los hilos de clientes almacenados en el array.
         * Este bucle espera a que cada cliente termine su ejecucion usando join().
         * join() bloquea el hilo principal hasta que el hilo del cliente termine.
         */
        for (Thread cliente : clientes) {
            /*
             * Try-catch para manejar posibles interrupciones mientras esperamos a que un cliente termine.
             * Si el hilo principal es interrumpido mientras espera, capturamos la excepcion.
             */
            try  {
                /*
                 * join() hace que el hilo principal espere hasta que este hilo de cliente termine.
                 * Esto asegura que todos los clientes terminen antes de continuar con el resto del programa.
                 */
                cliente.join();
            } catch (InterruptedException e) {
                System.out.println("!Error al recorrer uno por uno todos los clientes!");
            }
        }

        /*
         * Una vez que todos los clientes han terminado, interrumpimos el hilo del barbero.
         * interrupt() envia una senal de interrupcion al hilo, que sera capturada cuando el barbero
         * este en wait() o sleep(). Esto permite que el programa termine correctamente.
         */
        hiloBarbero.interrupt();
    }
}