package andalucia.sevilla.iesvelazquez.barberomultihilo;

/**
 * Clase que representa al barbero. Implementa Runnable para poder ejecutarse en un hilo.
 * El barbero duerme cuando no hay clientes y atiende clientes cuando llegan.
 */
public class Barbero implements Runnable {
    // Referencia al objeto BarberShop (monitor) donde el barbero trabaja
    private final BarberShop barberia;
    
    // Tiempo en milisegundos que tarda el barbero en atender a cada cliente
    private final int tiempoAtencion;

    /**
     * Constructor que nos deja crear un nuevo barbero permitiendonos elegir
     * en que barberia va a trabajar y cuanto tiempo tarda en atender a los
     * clientes.
     * @param barberia (Clase BarberShop) barberia donde trabaja.
     * @param tiempoAtencion (int) tiempo en milisegundos que tarda en atender.
     */
    public Barbero(BarberShop barberia, int tiempoAtencion) {
        // Asignamos la referencia a la barberia donde este barbero trabajara
        this.barberia = barberia;
        
        // Asignamos el tiempo que tarda el barbero en atender a cada cliente (se usa en Thread.sleep)
        this.tiempoAtencion = tiempoAtencion;
    }

    /**
     * Metodo run() que se ejecuta cuando el hilo del barbero se inicia.
     * Este metodo contiene el ciclo de vida del barbero: esperar clientes, atenderlos, repetir.
     */
    @Override
    public void run() {
        /*
         * Try-catch para manejar excepciones de tipo InterruptedException.
         * Esta excepcion puede ocurrir cuando el hilo es interrumpido mientras esta en wait() o sleep().
         */
        try {
            /*
             * Bucle infinito que hace que el barbero trabaje indefinidamente.
             * El barbero repetira este ciclo: esperar cliente -> atender -> repetir.
             * Solo se detendra cuando el hilo sea interrumpido desde fuera (interrupt()).
             */
            while (true) {

                /*
                 * Utilizando "barberia" controlamos que el hilo de "Barbero" se duerma
                 * (wait) cuando no haya clientes y deje de dormir cuando si los haya y
                 * actualice las variables del programa que son:
                 *
                 * - Cuantos clientes quedan esperando.
                 * - Cual es el siguiente turno.
                 *
                 * Avisa de esto a todos los hilos con NotifyAll.
                 */
                barberia.esperarCliente();

                /*
                 * Simulamos el tiempo que tarda el barbero en atender a un cliente.
                 * Thread.sleep() hace que el hilo del barbero duerma durante tiempoAtencion milisegundos.
                 * Durante este tiempo, el barbero esta "cortando el pelo" del cliente.
                 */
                Thread.sleep(tiempoAtencion);

                /*
                 * Llamamos a terminarAtender() para indicar que el barbero termino de atender al cliente.
                 * Este metodo actualiza las variables compartidas (turnoActual, siguienteTurnoAAtender)
                 * y notifica a todos los hilos esperando usando notifyAll().
                 */
                barberia.terminarAtender();
            }
        } catch (InterruptedException e) {
            /*
             * Si el hilo es interrumpido (por ejemplo, cuando todos los clientes terminaron),
             * capturamos la excepcion, mostramos un mensaje y restablecemos la bandera de interrupcion.
             */
            System.out.println("!El barbero fue interrumpido!");
            Thread.currentThread().interrupt();
        }
    }
}
