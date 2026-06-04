package ev3.ut6.u03concurrenciamultihilo.practicas.sevillaiesvelazquezbarberomultihilo;

/**
 * Clase monitor que coordina la sincronizacion entre el barbero y los clientes.
 * Utiliza unicamente synchronized, wait(), notify() y notifyAll() para la sincronizacion.
 */
public class BarberShop_SIN_RESOLVER {
    // Cantidad actual de clientes esperando en la sala de espera
    private int clientesEsperando;
    
    // Capacidad maxima de la sala de espera (numero de sillas)
    private int capacidadSalaEspera;
    
    // Turno del cliente que esta siendo atendido actualmente (0 = nadie)
    private int turnoActual;
    
    // Contador que se incrementa cada vez que entra un cliente (asigna turnos unicos)
    private int siguienteTurnoCliente;
    
    // Contador del siguiente turno que el barbero debe atender (asegura orden FIFO)
    private int siguienteTurnoAAtender;

    /**
     * Constructor: crea una barberia vacia con la configuracion inicial.
     * @param capacidadSalaEspera Numero de sillas disponibles en la sala de espera.
     */
    public BarberShop_SIN_RESOLVER(int capacidadSalaEspera) {
        // Inicializamos el contador de clientes esperando en 0 (barberia vacia)
        this.clientesEsperando = 0;
        
        // Asignamos la capacidad maxima de la sala de espera
        this.capacidadSalaEspera = capacidadSalaEspera;
        
        // Inicializamos turnoActual en 0 (nadie siendo atendido)
        this.turnoActual = 0;
        
        // Inicializamos siguienteTurnoCliente en 1 (primer cliente obtendra turno 1)
        this.siguienteTurnoCliente = 1;
        
        // Inicializamos siguienteTurnoAAtender en 1 (primer turno a atender sera el 1)
        this.siguienteTurnoAAtender = 1;
    }

    /**
     * El barbero espera a que llegue un cliente.
     * Si no hay clientes, se duerme. Cuando llega uno, se despierta y lo atiende.
     */
    public synchronized void esperarCliente() throws InterruptedException {
        /*
         * Si no hay clientes esperando, el barbero se duerme.
         * Esto ocurre cuando termina de atender a todos los clientes y la barberia esta vacia.
         */
        System.out.println("El barbero se duerme (no hay clientes)");
        
        /*
         * Bucle while que espera hasta que haya al menos un cliente en la sala de espera.
         * El bucle es necesario porque wait() puede despertarse por otras razones (spurious wakeup),
         * asi que siempre debemos verificar la condicion. Mientras clientesEsperando == 0,
         * el barbero seguira esperando.
         */
        while (clientesEsperando == 0) {
            /*
             * WAIT: El hilo del barbero se detiene aqui y espera hasta que otro hilo lo despierte.
             * Mientras esta en wait(), el barbero libera el "candado" (synchronized) para que otros
             * hilos puedan entrar a metodos sincronizados de esta clase.
             * Cuando un cliente llama notify() o notifyAll(), este hilo se despertara y continuara.
             */
            wait();
        }
        
        /*
         * El barbero se desperto porque llego un cliente.
         * Un cliente llamo a notify() desde intentarEntrar() cuando era el primer cliente.
         */
        System.out.println("El barbero se despierta");
        
        /*
         * Atender al siguiente cliente en orden FIFO (First In First Out).
         * El turno actual se establece con el siguiente turno que debe ser atendido.
         * Luego decrementamos el contador de clientes esperando porque uno ya esta siendo atendido.
         */
        turnoActual = siguienteTurnoAAtender;
        clientesEsperando--;
        
        System.out.println("El barbero atiende al turno " + turnoActual + ". Clientes esperando: " + clientesEsperando);
        
        /*
         * NOTIFYALL: Despierta a TODOS los hilos que estan esperando (wait) en esta clase.
         * En este caso, avisa a todos los clientes que estan esperando su turno para que revisen
         * si ya es su momento de ser atendidos. Cada cliente verifica si turnoActual == su turno.
         */
        notifyAll();
    }

    /**
     * Un cliente intenta entrar a la barberia.
     * @param idCliente Identificador unico del cliente.
     * @return true si entro y sera atendido, false si se fue (sala llena)
     */
    public synchronized boolean intentarEntrar(int idCliente) throws InterruptedException {
        /*
         * Condicion if que verifica si la sala de espera esta llena.
         * Si clientesEsperando >= capacidadSalaEspera, el cliente no puede entrar
         * y se va sin ser atendido. Esto cumple con el requisito:
         * "Si la sala de espera esta llena, el cliente se va sin esperar".
         */
        if (clientesEsperando >= capacidadSalaEspera) {
            System.out.println("Cliente_SIN_RESOLVER " + idCliente + " se va (sala llena: " + clientesEsperando + "/" + capacidadSalaEspera + ")");
            return false;
        }

        // Variable local que almacena el turno asignado a este cliente especifico (orden FIFO)
        int miTurno = siguienteTurnoCliente;
        
        // Incrementamos el contador de turnos para que el siguiente cliente obtenga un turno diferente
        siguienteTurnoCliente++;
        
        // Incrementamos el contador de clientes esperando porque este cliente acaba de entrar
        clientesEsperando++;
        
        System.out.println("Cliente_SIN_RESOLVER " + idCliente + " entra (turno " + miTurno + "). Clientes esperando: " + clientesEsperando);

        /*
         * Condicion if que verifica si este es el primer cliente que entra.
         * Si clientesEsperando == 1, significa que este es el primer cliente y el barbero
         * esta dormido porque no habia clientes. Debemos despertarlo usando notify().
         */
        if (clientesEsperando == 1) {
            /*
             * NOTIFY: Despierta a UN SOLO hilo que esta esperando (wait) en esta clase.
             * Como solo hay un barbero esperando, notify() es suficiente para despertarlo.
             * Si hubiera varios hilos esperando, solo uno se despertaria (no sabemos cual).
             * Por eso usamos notify() aqui: solo necesitamos despertar al barbero.
             */
            notify();
        }

        /*
         * Bucle while que hace que el cliente espere hasta que sea su turno de ser atendido.
         * El cliente espera mientras su turno (miTurno) no coincida con el turno que el barbero
         * esta atendiendo actualmente (turnoActual). Usamos un bucle porque wait() puede
         * despertarse por otras razones (spurious wakeup), asi que siempre debemos verificar
         * si realmente es su turno.
         */
        while (turnoActual != miTurno) {
            /*
             * WAIT: El hilo del cliente se detiene aqui y espera hasta que otro hilo lo despierte.
             * El cliente espera porque su turno (miTurno) no coincide con el turno que el barbero
             * esta atendiendo actualmente (turnoActual). Cuando el barbero termine y cambie turnoActual,
             * llamara a notifyAll() para despertar a todos los clientes, y este cliente revisara de nuevo.
             */
            wait();
        }

        System.out.println("Cliente_SIN_RESOLVER " + idCliente + " esta siendo atendido");
        return true;
    }

    /**
     * El cliente sale despues de ser atendido.
     * Espera hasta que el barbero termine de atenderlo.
     * @param idCliente Identificador del cliente que esta saliendo.
     */
    public synchronized void salir(int idCliente) throws InterruptedException {
        /*
         * Bucle while que espera hasta que el barbero termine completamente de atender al cliente.
         * El cliente ya fue atendido (paso la verificacion en intentarEntrar), pero debe esperar
         * a que el barbero termine el proceso completo. El barbero esta durmiendo (Thread.sleep)
         * simulando el tiempo de atencion. Cuando termine, llamara a terminarAtender() que pondra
         * turnoActual = 0. Solo entonces este cliente puede salir de la barberia.
         * El bucle es necesario porque wait() puede despertarse por otras razones.
         */
        while (turnoActual != 0) {
            /*
             * WAIT: El hilo del cliente se detiene aqui esperando a que el barbero termine de atenderlo.
             * El cliente ya fue atendido, pero debe esperar a que el barbero termine el proceso completo
             * (el barbero esta durmiendo Thread.sleep). Cuando el barbero llama terminarAtender() y pone
             * turnoActual = 0, entonces llama notifyAll() para despertar a este cliente.
             */
            wait();
        }
        
        System.out.println("Cliente_SIN_RESOLVER " + idCliente + " sale de la barberia");
        
        /*
         * NOTIFYALL: Despierta a TODOS los hilos que estan esperando.
         * Aunque en este caso solo hay un cliente esperando en salir(), usamos notifyAll() por seguridad
         * y para mantener consistencia. Esto asegura que cualquier otro hilo que pueda estar esperando
         * tambien se despierte.
         */
        notifyAll();
    }

    /**
     * El barbero indica que termino de atender a un cliente.
     */
    public synchronized void terminarAtender() {
        // Ponemos turnoActual = 0 para indicar que ya no esta atendiendo a nadie (permite que el cliente salga)
        turnoActual = 0;
        
        // Incrementamos el siguiente turno que debe ser atendido (asegura orden FIFO)
        siguienteTurnoAAtender++;
        
        System.out.println("El barbero termino. Clientes esperando: " + clientesEsperando);
        
        /*
         * NOTIFYALL: Despierta a TODOS los hilos que estan esperando (wait) en esta clase.
         * En este momento, puede haber:
         * 1. Clientes esperando su turno en intentarEntrar() (esperando que turnoActual == miTurno)
         * 2. El cliente que esta siendo atendido esperando en salir() (esperando que turnoActual == 0)
         * Al llamar notifyAll(), todos estos hilos se despertaran y revisaran sus condiciones.
         * Solo el cliente correcto podra continuar (el que tiene el turno correspondiente).
         */
        notifyAll();
    }
}
