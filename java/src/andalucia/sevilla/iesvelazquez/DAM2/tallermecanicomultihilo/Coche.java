package andalucia.sevilla.iesvelazquez.DAM2.tallermecanicomultihilo;

/**
 * Representa un coche. Intenta entrar al taller y espera su turno para ser reparado.
 */
public class Coche implements Runnable {
    // Referencia al taller donde este coche intentará entrar
    private final TallerMecanico taller;
    // Identificador único de este coche
    private final int idCoche;

    public Coche(TallerMecanico taller, int idCoche) {
        this.taller = taller;
        this.idCoche = idCoche;
    }

    @Override
    public void run() {
        // Variable booleana que indica si el coche fue atendido o se marchó
        boolean atendido;
        
        // Try-catch para manejar si el hilo es interrumpido
        try {
            // Intentamos entrar al taller (retorna true si entró, false si se fue)
            atendido = taller.intentarEntrar(idCoche);
            // Condición if para verificar si el coche fue atendido
            if (atendido) {
                // Si fue atendido, esperamos a que el mecánico termine de repararnos
                taller.esperarReparacion(idCoche);
            }
        } catch (InterruptedException e) {
            // Si nos interrumpen, mostramos mensaje y marcamos el hilo como interrumpido
            System.out.println("Coche " + idCoche + ": me interrumpieron");
            Thread.currentThread().interrupt();
        }
    }
}
