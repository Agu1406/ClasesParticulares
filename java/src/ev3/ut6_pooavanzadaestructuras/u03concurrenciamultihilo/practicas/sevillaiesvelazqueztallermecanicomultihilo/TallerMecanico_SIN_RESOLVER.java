package ev3.ut6_pooavanzadaestructuras.u03concurrenciamultihilo.practicas.sevillaiesvelazqueztallermecanicomultihilo;

/**
 * Monitor que coordina la sincronizacion entre el mecanico y los coches.
 * Usa synchronized, wait(), notify() y notifyAll().
 * Implementa un aparcamiento con capacidad limitada usando un arreglo circular.
 */
public class TallerMecanico_SIN_RESOLVER {
    // Numero maximo de plazas en el aparcamiento de espera
    private final int capacidadAparcamiento;
    // Array circular que guarda los IDs de los coches esperando en orden FIFO
    private final int[] colaAparcamiento;
    // Indice que apunta al primer coche de la cola (el proximo en ser reparado)
    private int cabeza;
    // Indice que apunta al ultimo lugar libre de la cola (donde se anade el siguiente coche)
    private int cola;
    // Contador de cuantos coches hay esperando actualmente en el aparcamiento
    private int cochesEsperando;
    // ID del coche que esta siendo reparado ahora mismo (0 significa que no hay ninguno)
    private int cocheEnReparacion;
    // Contador que genera IDs unicos para cada coche nuevo
    private int siguienteIdCoche;

    public TallerMecanico_SIN_RESOLVER(int capacidadAparcamiento) {
        this.capacidadAparcamiento = capacidadAparcamiento;
        this.colaAparcamiento = new int[capacidadAparcamiento];
        this.cabeza = 0;
        this.cola = 0;
        this.cochesEsperando = 0;
        this.cocheEnReparacion = 0;
        this.siguienteIdCoche = 1;
    }

    public synchronized int esperarCoche() throws InterruptedException {
        // Bucle while que espera hasta que haya al menos un coche en el aparcamiento
        while (cochesEsperando == 0) {
            // Si no hay coches, el mecanico se duerme
            System.out.println("Mecanico_SIN_RESOLVER: me duermo, no hay coches");
            // Esperamos hasta que alguien nos despierte con notify()
            wait();
        }
        
        System.out.println("Mecanico_SIN_RESOLVER: me despierto, hay trabajo");
        
        // Variable local que guarda el ID del coche que vamos a reparar
        int cocheId;
        // Sacamos el primer coche de la cola (FIFO)
        cocheId = colaAparcamiento[cabeza];
        // Marcamos que este coche esta siendo reparado ahora
        cocheEnReparacion = cocheId;
        // Avanzamos la cabeza de la cola (siguiente posicion con arreglo circular)
        cabeza = (cabeza + 1) % capacidadAparcamiento;
        // Disminuimos el contador de coches esperando porque uno ya esta siendo atendido
        cochesEsperando--;
        
        System.out.println("Mecanico_SIN_RESOLVER: reparando coche " + cocheId + " (quedan " + cochesEsperando + " esperando)");
        // Despertamos a todos los hilos que estan esperando para que revisen sus condiciones
        notifyAll();
        
        return cocheId;
    }

    public synchronized boolean intentarEntrar(int idCoche) throws InterruptedException {
        // Condicion if para verificar si el aparcamiento esta lleno
        if (cochesEsperando >= capacidadAparcamiento) {
            System.out.println("Coche_SIN_RESOLVER " + idCoche + ": me voy, el aparcamiento esta lleno");
            return false;
        }

        // Anadimos este coche al final de la cola
        colaAparcamiento[cola] = idCoche;
        // Avanzamos la cola al siguiente lugar libre (con arreglo circular)
        cola = (cola + 1) % capacidadAparcamiento;
        // Aumentamos el contador de coches esperando
        cochesEsperando++;

        System.out.println("Coche_SIN_RESOLVER " + idCoche + ": entro al aparcamiento (hay " + cochesEsperando + " esperando)");

        // Condicion if para verificar si este es el primer coche que llega
        if (cochesEsperando == 1) {
            // Si es el primero, despertamos al mecanico que esta dormido
            notify();
        }

        // Bucle while que espera hasta que sea el turno de este coche de ser reparado
        while (cocheEnReparacion != idCoche) {
            // Esperamos hasta que el mecanico nos avise con notifyAll()
            wait();
        }

        System.out.println("Coche_SIN_RESOLVER " + idCoche + ": ya me estan reparando");
        return true;
    }

    public synchronized void esperarReparacion(int idCoche) throws InterruptedException {
        // Bucle while que espera hasta que el mecanico termine de reparar este coche
        while (cocheEnReparacion == idCoche) {
            // Esperamos hasta que el mecanico nos avise que termino
            wait();
        }
        
        System.out.println("Coche_SIN_RESOLVER " + idCoche + ": reparacion terminada, me voy");
        // Despertamos a otros hilos que puedan estar esperando
        notifyAll();
    }

    public synchronized void terminarReparacion(int idCoche) {
        // Marcamos que ya no hay ningun coche siendo reparado
        cocheEnReparacion = 0;
        System.out.println("Mecanico_SIN_RESOLVER: termine con el coche " + idCoche + " (quedan " + cochesEsperando + " esperando)");
        // Despertamos a todos los hilos que estan esperando (el coche reparado y otros esperando)
        notifyAll();
    }

    public synchronized int obtenerNuevoIdCoche() {
        // Retornamos el siguiente ID y lo incrementamos para el proximo coche
        return siguienteIdCoche++;
    }
}
