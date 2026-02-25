package andalucia.sevilla.iesvelazquez.barberomultihilo;

/**
 * Clase que representa a un cliente. Implementa Runnable para poder ejecutarse en un hilo.
 * Los clientes intentan entrar a la barbería y esperan su turno para ser atendidos.
 */
public class Cliente implements Runnable {
    // Referencia al objeto BarberShop (monitor) donde el cliente intentará entrar
    private final BarberShop barberia;
    
    // Identificador único del cliente (se usa en mensajes de salida y logs)
    private final int idCliente;

    /**
     * Constructor del cliente.
     * @param barberia Referencia a la barbería donde el cliente intentará entrar.
     * @param idCliente Identificador único del cliente.
     */
    public Cliente(BarberShop barberia, int idCliente) {
        // Asignamos la referencia a la barbería donde este cliente intentará entrar
        this.barberia = barberia;
        
        // Asignamos el identificador único del cliente (se usa en mensajes de salida)
        this.idCliente = idCliente;
    }

    /**
     * Método run() que se ejecuta cuando el hilo del cliente se inicia.
     * Este método contiene el ciclo de vida del cliente: intentar entrar -> esperar turno -> salir.
     */
    @Override
    public void run() {
        /*
         * Try-catch para manejar excepciones de tipo InterruptedException.
         * Esta excepción puede ocurrir cuando el hilo es interrumpido mientras está en wait().
         */
        try {
            // Variable booleana: true si entró y será atendido, false si se fue (sala llena)
            boolean atendido = barberia.intentarEntrar(idCliente);

            /*
             * Condición if que verifica si el cliente fue atendido.
             * Solo si atendido == true, el cliente esperará a que el barbero termine y luego saldrá.
             * Si atendido == false, significa que la sala estaba llena y el cliente ya se fue.
             */
            if (atendido) {
                /*
                 * El cliente espera hasta que el barbero termine de atenderlo completamente.
                 * El método salir() se bloquea hasta que el barbero termine su trabajo (Thread.sleep).
                 * Una vez que el barbero termina, el cliente sale de la barbería.
                 */
                barberia.salir(idCliente);
            }
            // Si no fue atendido (sala llena), el cliente ya se fue y el hilo termina aquí
        } catch (InterruptedException e) {
            /*
             * Si el hilo es interrumpido, capturamos la excepción, mostramos un mensaje
             * y restablecemos la bandera de interrupción para que otros métodos puedan detectarla.
             */
            System.out.println("¡Error al intentar atender el hilo de clientes!");
            Thread.currentThread().interrupt();
        }
    }
}
