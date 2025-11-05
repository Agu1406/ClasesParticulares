package org.example;

/**
 * Clase monitor que coordina la sincronización entre el barbero y los clientes.
 * Utiliza únicamente synchronized, wait(), notify() y notifyAll() para la sincronización.
 */
public class BarberShop {
    // Cantidad actual de clientes esperando en la sala de espera
    private int clientesEsperando;
    
    // Capacidad máxima de la sala de espera (número de sillas)
    private int capacidadSalaEspera;
    
    // Turno del cliente que está siendo atendido actualmente (0 = nadie)
    private int turnoActual;
    
    // Contador que se incrementa cada vez que entra un cliente (asigna turnos únicos)
    private int siguienteTurnoCliente;
    
    // Contador del siguiente turno que el barbero debe atender (asegura orden FIFO)
    private int siguienteTurnoAAtender;

    /**
     * Constructor: crea una barbería vacía con la configuración inicial.
     * @param capacidadSalaEspera Número de sillas disponibles en la sala de espera.
     */
    public BarberShop(int capacidadSalaEspera) {
        // Inicializamos el contador de clientes esperando en 0 (barbería vacía)
        this.clientesEsperando = 0;
        
        // Asignamos la capacidad máxima de la sala de espera
        this.capacidadSalaEspera = capacidadSalaEspera;
        
        // Inicializamos turnoActual en 0 (nadie siendo atendido)
        this.turnoActual = 0;
        
        // Inicializamos siguienteTurnoCliente en 1 (primer cliente obtendrá turno 1)
        this.siguienteTurnoCliente = 1;
        
        // Inicializamos siguienteTurnoAAtender en 1 (primer turno a atender será el 1)
        this.siguienteTurnoAAtender = 1;
    }

    /**
     * El barbero espera a que llegue un cliente.
     * Si no hay clientes, se duerme. Cuando llega uno, se despierta y lo atiende.
     */
    public synchronized void esperarCliente() throws InterruptedException {
        /*
         * Si no hay clientes esperando, el barbero se duerme.
         * Esto ocurre cuando termina de atender a todos los clientes y la barbería está vacía.
         */
        System.out.println("El barbero se duerme (no hay clientes)");
        
        /*
         * Bucle while que espera hasta que haya al menos un cliente en la sala de espera.
         * El bucle es necesario porque wait() puede despertarse por otras razones (spurious wakeup),
         * así que siempre debemos verificar la condición. Mientras clientesEsperando == 0,
         * el barbero seguirá esperando.
         */
        while (clientesEsperando == 0) {
            /*
             * WAIT: El hilo del barbero se detiene aquí y espera hasta que otro hilo lo despierte.
             * Mientras está en wait(), el barbero libera el "candado" (synchronized) para que otros
             * hilos puedan entrar a métodos sincronizados de esta clase.
             * Cuando un cliente llama notify() o notifyAll(), este hilo se despertará y continuará.
             */
            wait();
        }
        
        /*
         * El barbero se despertó porque llegó un cliente.
         * Un cliente llamó a notify() desde intentarEntrar() cuando era el primer cliente.
         */
        System.out.println("El barbero se despierta");
        
        /*
         * Atender al siguiente cliente en orden FIFO (First In First Out).
         * El turno actual se establece con el siguiente turno que debe ser atendido.
         * Luego decrementamos el contador de clientes esperando porque uno ya está siendo atendido.
         */
        turnoActual = siguienteTurnoAAtender;
        clientesEsperando--;
        
        System.out.println("El barbero atiende al turno " + turnoActual + ". Clientes esperando: " + clientesEsperando);
        
        /*
         * NOTIFYALL: Despierta a TODOS los hilos que están esperando (wait) en esta clase.
         * En este caso, avisa a todos los clientes que están esperando su turno para que revisen
         * si ya es su momento de ser atendidos. Cada cliente verifica si turnoActual == su turno.
         */
        notifyAll();
    }

    /**
     * Un cliente intenta entrar a la barbería.
     * @param idCliente Identificador único del cliente.
     * @return true si entró y será atendido, false si se fue (sala llena)
     */
    public synchronized boolean intentarEntrar(int idCliente) throws InterruptedException {
        /*
         * Condición if que verifica si la sala de espera está llena.
         * Si clientesEsperando >= capacidadSalaEspera, el cliente no puede entrar
         * y se va sin ser atendido. Esto cumple con el requisito:
         * "Si la sala de espera está llena, el cliente se va sin esperar".
         */
        if (clientesEsperando >= capacidadSalaEspera) {
            System.out.println("Cliente " + idCliente + " se va (sala llena: " + clientesEsperando + "/" + capacidadSalaEspera + ")");
            return false;
        }

        // Variable local que almacena el turno asignado a este cliente específico (orden FIFO)
        int miTurno = siguienteTurnoCliente;
        
        // Incrementamos el contador de turnos para que el siguiente cliente obtenga un turno diferente
        siguienteTurnoCliente++;
        
        // Incrementamos el contador de clientes esperando porque este cliente acaba de entrar
        clientesEsperando++;
        
        System.out.println("Cliente " + idCliente + " entra (turno " + miTurno + "). Clientes esperando: " + clientesEsperando);

        /*
         * Condición if que verifica si este es el primer cliente que entra.
         * Si clientesEsperando == 1, significa que este es el primer cliente y el barbero
         * está dormido porque no había clientes. Debemos despertarlo usando notify().
         */
        if (clientesEsperando == 1) {
            /*
             * NOTIFY: Despierta a UN SOLO hilo que está esperando (wait) en esta clase.
             * Como solo hay un barbero esperando, notify() es suficiente para despertarlo.
             * Si hubiera varios hilos esperando, solo uno se despertaría (no sabemos cuál).
             * Por eso usamos notify() aquí: solo necesitamos despertar al barbero.
             */
            notify();
        }

        /*
         * Bucle while que hace que el cliente espere hasta que sea su turno de ser atendido.
         * El cliente espera mientras su turno (miTurno) no coincida con el turno que el barbero
         * está atendiendo actualmente (turnoActual). Usamos un bucle porque wait() puede
         * despertarse por otras razones (spurious wakeup), así que siempre debemos verificar
         * si realmente es su turno.
         */
        while (turnoActual != miTurno) {
            /*
             * WAIT: El hilo del cliente se detiene aquí y espera hasta que otro hilo lo despierte.
             * El cliente espera porque su turno (miTurno) no coincide con el turno que el barbero
             * está atendiendo actualmente (turnoActual). Cuando el barbero termine y cambie turnoActual,
             * llamará a notifyAll() para despertar a todos los clientes, y este cliente revisará de nuevo.
             */
            wait();
        }

        System.out.println("Cliente " + idCliente + " está siendo atendido");
        return true;
    }

    /**
     * El cliente sale después de ser atendido.
     * Espera hasta que el barbero termine de atenderlo.
     * @param idCliente Identificador del cliente que está saliendo.
     */
    public synchronized void salir(int idCliente) throws InterruptedException {
        /*
         * Bucle while que espera hasta que el barbero termine completamente de atender al cliente.
         * El cliente ya fue atendido (pasó la verificación en intentarEntrar), pero debe esperar
         * a que el barbero termine el proceso completo. El barbero está durmiendo (Thread.sleep)
         * simulando el tiempo de atención. Cuando termine, llamará a terminarAtender() que pondrá
         * turnoActual = 0. Solo entonces este cliente puede salir de la barbería.
         * El bucle es necesario porque wait() puede despertarse por otras razones.
         */
        while (turnoActual != 0) {
            /*
             * WAIT: El hilo del cliente se detiene aquí esperando a que el barbero termine de atenderlo.
             * El cliente ya fue atendido, pero debe esperar a que el barbero termine el proceso completo
             * (el barbero está durmiendo Thread.sleep). Cuando el barbero llama terminarAtender() y pone
             * turnoActual = 0, entonces llama notifyAll() para despertar a este cliente.
             */
            wait();
        }
        
        System.out.println("Cliente " + idCliente + " sale de la barbería");
        
        /*
         * NOTIFYALL: Despierta a TODOS los hilos que están esperando.
         * Aunque en este caso solo hay un cliente esperando en salir(), usamos notifyAll() por seguridad
         * y para mantener consistencia. Esto asegura que cualquier otro hilo que pueda estar esperando
         * también se despierte.
         */
        notifyAll();
    }

    /**
     * El barbero indica que terminó de atender a un cliente.
     */
    public synchronized void terminarAtender() {
        // Ponemos turnoActual = 0 para indicar que ya no está atendiendo a nadie (permite que el cliente salga)
        turnoActual = 0;
        
        // Incrementamos el siguiente turno que debe ser atendido (asegura orden FIFO)
        siguienteTurnoAAtender++;
        
        System.out.println("El barbero terminó. Clientes esperando: " + clientesEsperando);
        
        /*
         * NOTIFYALL: Despierta a TODOS los hilos que están esperando (wait) en esta clase.
         * En este momento, puede haber:
         * 1. Clientes esperando su turno en intentarEntrar() (esperando que turnoActual == miTurno)
         * 2. El cliente que está siendo atendido esperando en salir() (esperando que turnoActual == 0)
         * Al llamar notifyAll(), todos estos hilos se despertarán y revisarán sus condiciones.
         * Solo el cliente correcto podrá continuar (el que tiene el turno correspondiente).
         */
        notifyAll();
    }
}
