package ev3.ut6.u03concurrenciamultihilo.practicas.sevillaiesvelazqueztallermecanicomultihilo;

/**
 * Representa al mecanico. Duerme cuando no hay coches y repara cuando llegan.
 */
public class Mecanico_SIN_RESOLVER implements Runnable {
    // Referencia al taller donde trabaja este mecanico
    private final TallerMecanico_SIN_RESOLVER taller;
    // Tiempo minimo que tarda en reparar un coche (milisegundos)
    private final int tiempoMinimoReparacion;
    // Tiempo maximo que tarda en reparar un coche (milisegundos)
    private final int tiempoMaximoReparacion;

    public Mecanico_SIN_RESOLVER(TallerMecanico_SIN_RESOLVER taller, int tiempoMinimoReparacion, int tiempoMaximoReparacion) {
        this.taller = taller;
        this.tiempoMinimoReparacion = tiempoMinimoReparacion;
        this.tiempoMaximoReparacion = tiempoMaximoReparacion;
    }

    @Override
    public void run() {
        // Variables que se usaran en el metodo run
        int idCoche;
        int tiempoReparacion;
        
        // Try-catch para manejar si el hilo es interrumpido
        try {
            // Bucle infinito que hace que el mecanico trabaje continuamente
            while (true) {
                // Esperamos a que llegue un coche (se duerme si no hay)
                idCoche = taller.esperarCoche();

                // Calculamos un tiempo aleatorio de reparacion entre el minimo y maximo
                tiempoReparacion = tiempoMinimoReparacion + 
                    (int)(Math.random() * (tiempoMaximoReparacion - tiempoMinimoReparacion + 1));
                
                System.out.println("Mecanico_SIN_RESOLVER: reparando coche " + idCoche + " (tardare " + tiempoReparacion + " ms)");
                // Simulamos el tiempo que tarda en reparar durmiendo el hilo
                Thread.sleep(tiempoReparacion);

                // Indicamos al taller que terminamos de reparar este coche
                taller.terminarReparacion(idCoche);
            }
        } catch (InterruptedException e) {
            // Si nos interrumpen, mostramos mensaje y marcamos el hilo como interrumpido
            System.out.println("Mecanico_SIN_RESOLVER: me interrumpieron, dejo de trabajar");
            Thread.currentThread().interrupt();
        }
    }
}
