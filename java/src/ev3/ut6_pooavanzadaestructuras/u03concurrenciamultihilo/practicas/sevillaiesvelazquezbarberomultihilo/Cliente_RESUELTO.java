package ev3.ut6_pooavanzadaestructuras.u03concurrenciamultihilo.practicas.sevillaiesvelazquezbarberomultihilo;

/**
 * Clase que representa a un cliente. Implementa Runnable para poder ejecutarse en un hilo.
 * Los clientes intentan entrar a la barberia y esperan su turno para ser atendidos.
  *
 * * PLANTILLA DOCENTE: completar solucion docente.
 */
public class Cliente_RESUELTO implements Runnable {
    // Referencia al objeto BarberShop_RESUELTO (monitor) donde el cliente intentara entrar
    private final BarberShop_RESUELTO barberia;
    
    // Identificador unico del cliente (se usa en mensajes de salida y logs)
    private final int idCliente;

    /**
     * Constructor del cliente.
     * @param barberia Referencia a la barberia donde el cliente intentara entrar.
     * @param idCliente Identificador unico del cliente.
     */
    public Cliente_RESUELTO(BarberShop_RESUELTO barberia, int idCliente) {
        // Asignamos la referencia a la barberia donde este cliente intentara entrar
        this.barberia = barberia;
        
        // Asignamos el identificador unico del cliente (se usa en mensajes de salida)
        this.idCliente = idCliente;
    }

    /**
     * Metodo run() que se ejecuta cuando el hilo del cliente se inicia.
     * Este metodo contiene el ciclo de vida del cliente: intentar entrar -> esperar turno -> salir.
     */
    @Override
    public void run() {
        /*
         * Try-catch para manejar excepciones de tipo InterruptedException.
         * Esta excepcion puede ocurrir cuando el hilo es interrumpido mientras esta en wait().
         */
        try {
            // Variable booleana: true si entro y sera atendido, false si se fue (sala llena)
            boolean atendido = barberia.intentarEntrar(idCliente);

            /*
             * Condicion if que verifica si el cliente fue atendido.
             * Solo si atendido == true, el cliente esperara a que el barbero termine y luego saldra.
             * Si atendido == false, significa que la sala estaba llena y el cliente ya se fue.
             */
            if (atendido) {
                /*
                 * El cliente espera hasta que el barbero termine de atenderlo completamente.
                 * El metodo salir() se bloquea hasta que el barbero termine su trabajo (Thread.sleep).
                 * Una vez que el barbero termina, el cliente sale de la barberia.
                 */
                barberia.salir(idCliente);
            }
            // Si no fue atendido (sala llena), el cliente ya se fue y el hilo termina aqui
        } catch (InterruptedException e) {
            /*
             * Si el hilo es interrumpido, capturamos la excepcion, mostramos un mensaje
             * y restablecemos la bandera de interrupcion para que otros metodos puedan detectarla.
             */
            System.out.println("!Error al intentar atender el hilo de clientes!");
            Thread.currentThread().interrupt();
        }
    }
}
