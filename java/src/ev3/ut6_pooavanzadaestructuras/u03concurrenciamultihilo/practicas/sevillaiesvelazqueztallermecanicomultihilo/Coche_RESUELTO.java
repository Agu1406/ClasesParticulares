package ev3.ut6_pooavanzadaestructuras.u03concurrenciamultihilo.practicas.sevillaiesvelazqueztallermecanicomultihilo;

/**
 * Representa un coche. Intenta entrar al taller y espera su turno para ser reparado.
 */
public class Coche_RESUELTO implements Runnable {
    // Referencia al taller donde este coche intentara entrar
    private final TallerMecanico_RESUELTO taller;
    // Identificador unico de este coche
    private final int idCoche;

    public Coche_RESUELTO(TallerMecanico_RESUELTO taller, int idCoche) {
        this.taller = taller;
        this.idCoche = idCoche;
    }

    @Override
    public void run() {
        // Variable booleana que indica si el coche fue atendido o se marcho
        boolean atendido;
        
        // Try-catch para manejar si el hilo es interrumpido
        try {
            // Intentamos entrar al taller (retorna true si entro, false si se fue)
            atendido = taller.intentarEntrar(idCoche);
            // Condicion if para verificar si el coche fue atendido
            if (atendido) {
                // Si fue atendido, esperamos a que el mecanico termine de repararnos
                taller.esperarReparacion(idCoche);
            }
        } catch (InterruptedException e) {
            // Si nos interrumpen, mostramos mensaje y marcamos el hilo como interrumpido
            System.out.println("Coche_RESUELTO " + idCoche + ": me interrumpieron");
            Thread.currentThread().interrupt();
        }
    }
}
