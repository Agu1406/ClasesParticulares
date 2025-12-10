package andalucia.sevilla.iesvelazquez.tallermecanico;

/**
 * Monitor que coordina la sincronización entre el mecánico y los coches.
 * Usa synchronized, wait(), notify() y notifyAll().
 * Implementa un aparcamiento con capacidad limitada usando un arreglo circular.
 */
public class TallerMecanico {
    // Número máximo de plazas en el aparcamiento de espera
    private final int capacidadAparcamiento;
    // Array circular que guarda los IDs de los coches esperando en orden FIFO
    private final int[] colaAparcamiento;
    // Índice que apunta al primer coche de la cola (el próximo en ser reparado)
    private int cabeza;
    // Índice que apunta al último lugar libre de la cola (donde se añade el siguiente coche)
    private int cola;
    // Contador de cuántos coches hay esperando actualmente en el aparcamiento
    private int cochesEsperando;
    // ID del coche que está siendo reparado ahora mismo (0 significa que no hay ninguno)
    private int cocheEnReparacion;
    // Contador que genera IDs únicos para cada coche nuevo
    private int siguienteIdCoche;

    public TallerMecanico(int capacidadAparcamiento) {
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
            // Si no hay coches, el mecánico se duerme
            System.out.println("Mecánico: me duermo, no hay coches");
            // Esperamos hasta que alguien nos despierte con notify()
            wait();
        }
        
        System.out.println("Mecánico: me despierto, hay trabajo");
        
        // Variable local que guarda el ID del coche que vamos a reparar
        int cocheId;
        // Sacamos el primer coche de la cola (FIFO)
        cocheId = colaAparcamiento[cabeza];
        // Marcamos que este coche está siendo reparado ahora
        cocheEnReparacion = cocheId;
        // Avanzamos la cabeza de la cola (siguiente posición con arreglo circular)
        cabeza = (cabeza + 1) % capacidadAparcamiento;
        // Disminuimos el contador de coches esperando porque uno ya está siendo atendido
        cochesEsperando--;
        
        System.out.println("Mecánico: reparando coche " + cocheId + " (quedan " + cochesEsperando + " esperando)");
        // Despertamos a todos los hilos que están esperando para que revisen sus condiciones
        notifyAll();
        
        return cocheId;
    }

    public synchronized boolean intentarEntrar(int idCoche) throws InterruptedException {
        // Condición if para verificar si el aparcamiento está lleno
        if (cochesEsperando >= capacidadAparcamiento) {
            System.out.println("Coche " + idCoche + ": me voy, el aparcamiento está lleno");
            return false;
        }

        // Añadimos este coche al final de la cola
        colaAparcamiento[cola] = idCoche;
        // Avanzamos la cola al siguiente lugar libre (con arreglo circular)
        cola = (cola + 1) % capacidadAparcamiento;
        // Aumentamos el contador de coches esperando
        cochesEsperando++;

        System.out.println("Coche " + idCoche + ": entro al aparcamiento (hay " + cochesEsperando + " esperando)");

        // Condición if para verificar si este es el primer coche que llega
        if (cochesEsperando == 1) {
            // Si es el primero, despertamos al mecánico que está dormido
            notify();
        }

        // Bucle while que espera hasta que sea el turno de este coche de ser reparado
        while (cocheEnReparacion != idCoche) {
            // Esperamos hasta que el mecánico nos avise con notifyAll()
            wait();
        }

        System.out.println("Coche " + idCoche + ": ya me están reparando");
        return true;
    }

    public synchronized void esperarReparacion(int idCoche) throws InterruptedException {
        // Bucle while que espera hasta que el mecánico termine de reparar este coche
        while (cocheEnReparacion == idCoche) {
            // Esperamos hasta que el mecánico nos avise que terminó
            wait();
        }
        
        System.out.println("Coche " + idCoche + ": reparación terminada, me voy");
        // Despertamos a otros hilos que puedan estar esperando
        notifyAll();
    }

    public synchronized void terminarReparacion(int idCoche) {
        // Marcamos que ya no hay ningún coche siendo reparado
        cocheEnReparacion = 0;
        System.out.println("Mecánico: terminé con el coche " + idCoche + " (quedan " + cochesEsperando + " esperando)");
        // Despertamos a todos los hilos que están esperando (el coche reparado y otros esperando)
        notifyAll();
    }

    public synchronized int obtenerNuevoIdCoche() {
        // Retornamos el siguiente ID y lo incrementamos para el próximo coche
        return siguienteIdCoche++;
    }
}
