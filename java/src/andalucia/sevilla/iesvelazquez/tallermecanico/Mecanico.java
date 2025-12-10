package andalucia.sevilla.iesvelazquez.tallermecanico;

/**
 * Representa al mecánico. Duerme cuando no hay coches y repara cuando llegan.
 */
public class Mecanico implements Runnable {
    // Referencia al taller donde trabaja este mecánico
    private final TallerMecanico taller;
    // Tiempo mínimo que tarda en reparar un coche (milisegundos)
    private final int tiempoMinimoReparacion;
    // Tiempo máximo que tarda en reparar un coche (milisegundos)
    private final int tiempoMaximoReparacion;

    public Mecanico(TallerMecanico taller, int tiempoMinimoReparacion, int tiempoMaximoReparacion) {
        this.taller = taller;
        this.tiempoMinimoReparacion = tiempoMinimoReparacion;
        this.tiempoMaximoReparacion = tiempoMaximoReparacion;
    }

    @Override
    public void run() {
        // Variables que se usarán en el método run
        int idCoche;
        int tiempoReparacion;
        
        // Try-catch para manejar si el hilo es interrumpido
        try {
            // Bucle infinito que hace que el mecánico trabaje continuamente
            while (true) {
                // Esperamos a que llegue un coche (se duerme si no hay)
                idCoche = taller.esperarCoche();

                // Calculamos un tiempo aleatorio de reparación entre el mínimo y máximo
                tiempoReparacion = tiempoMinimoReparacion + 
                    (int)(Math.random() * (tiempoMaximoReparacion - tiempoMinimoReparacion + 1));
                
                System.out.println("Mecánico: reparando coche " + idCoche + " (tardaré " + tiempoReparacion + " ms)");
                // Simulamos el tiempo que tarda en reparar durmiendo el hilo
                Thread.sleep(tiempoReparacion);

                // Indicamos al taller que terminamos de reparar este coche
                taller.terminarReparacion(idCoche);
            }
        } catch (InterruptedException e) {
            // Si nos interrumpen, mostramos mensaje y marcamos el hilo como interrumpido
            System.out.println("Mecánico: me interrumpieron, dejo de trabajar");
            Thread.currentThread().interrupt();
        }
    }
}
