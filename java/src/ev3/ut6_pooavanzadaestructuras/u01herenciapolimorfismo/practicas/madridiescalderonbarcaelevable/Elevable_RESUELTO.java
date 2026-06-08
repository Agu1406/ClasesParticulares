package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridiescalderonbarcaelevable;

/**
 * Autor: NOMBRE_DEL_ALUMNO
 * Curso: 1? Bachillerato / Programacion
 * Fecha: AAAA-MM-DD
 *
 * Interfaz que define el comportamiento minimo de un ascensor (Elevable_RESUELTO).
 */
public interface Elevable_RESUELTO {

    // =========================
    // ESTADO GENERAL / CONSULTAS
    // =========================

    /**
     * Devuelve la planta actual en la que se encuentra la cabina.
     *
     * @return numero de planta actual.
     */
    int getPlantaActual();

    /**
     * Devuelve la planta objetivo a la que se esta desplazando el ascensor,
     * o la misma planta actual si esta parado.
     *
     * @return planta objetivo.
     */
    int getPlantaObjetivo();

    /**
     * Indica si el ascensor se encuentra en movimiento.
     *
     * @return true si esta en movimiento, false en caso contrario.
     */
    boolean estaEnMovimiento();

    /**
     * Indica si la cabina esta sobrecargada segun el detector de sobrepeso.
     *
     * @return true si hay sobrepeso, false en caso contrario.
     */
    boolean haySobrepeso();

    /**
     * Indica si hay presencia de personas/objetos en la puerta
     * (detector de presencia).
     *
     * @return true si se detecta presencia en la puerta, false si no.
     */
    boolean hayPresenciaEnPuerta();

    // =========================
    // CONTROL DE PUERTAS
    // =========================

    /**
     * Abre la puerta interior de la cabina si se dan las condiciones de seguridad
     * (ascensor parado y nivelado con la planta).
     */
    void abrirPuertaInterior();

    /**
     * Cierra la puerta interior de la cabina, normalmente antes de iniciar
     * un desplazamiento entre plantas.
     */
    void cerrarPuertaInterior();

    /**
     * Abre la puerta exterior de la planta indicada si se dan las condiciones
     * de seguridad (cabina presente en esa planta y parada).
     *
     * @param planta planta cuyas puertas exteriores se desean abrir.
     */
    void abrirPuertaExterior(int planta);

    /**
     * Cierra la puerta exterior de la planta indicada.
     *
     * @param planta planta cuyas puertas exteriores se desean cerrar.
     */
    void cerrarPuertaExterior(int planta);

    // =========================
    // ILUMINACION Y ENERGIA
    // =========================

    /**
     * Enciende la luz interior de la cabina.
     */
    void encenderLuzCabina();

    /**
     * Apaga la luz interior de la cabina (por ejemplo, tras un tiempo sin uso).
     */
    void apagarLuzCabina();

    /**
     * Activa un modo de ahorro energetico (por ejemplo, apagando luces
     * o deteniendo el ascensor en una planta neutra).
     */
    void activarModoAhorroEnergia();

    /**
     * Desactiva el modo de ahorro energetico y devuelve el ascensor
     * al funcionamiento normal.
     */
    void desactivarModoAhorroEnergia();

    // =========================
    // BOTONERA INTERIOR
    // =========================

    /**
     * Registra la pulsacion de un boton de planta en la botonera interior
     * de la cabina.
     *
     * @param planta planta solicitada desde el interior.
     */
    void pulsarBotonInteriorPlanta(int planta);

    /**
     * Cancela todas las peticiones de planta realizadas desde el interior.
     * Util en situaciones de emergencia o reinicio.
     */
    void cancelarPeticionesInteriores();

    // =========================
    // BOTONERA EXTERIOR
    // =========================

    /**
     * Registra la peticion de llamada al ascensor desde una planta concreta
     * indicando la direccion deseada (subir o bajar).
     *
     * @param planta    planta desde la que se llama al ascensor.
     * @param subirTrue true si se desea subir, false si se desea bajar.
     */
    void pulsarBotonExterior(int planta, boolean subirTrue);

    /**
     * Cancela todas las llamadas externas pendientes (por ejemplo,
     * en caso de mantenimiento).
     */
    void cancelarPeticionesExternas();

    // =========================
    // MOVIMIENTO / MAQUINARIA
    // =========================

    /**
     * Ordena al ascensor desplazarse hasta la planta indicada, respetando
     * la normativa de seguridad (puertas cerradas, sin sobrepeso, etc.).
     *
     * @param plantaDestino planta a la que se desea mover el ascensor.
     */
    void moverACiertaPlanta(int plantaDestino);

    /**
     * Inicia el movimiento de la cabina en la direccion adecuada segun
     * la planta objetivo actual.
     */
    void iniciarMovimiento();

    /**
     * Detiene el movimiento de la cabina, aplicando el freno de forma segura.
     */
    void detenerMovimiento();

    /**
     * Activa el freno de seguridad del ascensor.
     */
    void activarFreno();

    /**
     * Desactiva el freno de seguridad del ascensor (normalmente antes
     * de poner el motor en marcha).
     */
    void desactivarFreno();

    /**
     * Arranca el motor del ascensor para permitir el movimiento de la cabina.
     */
    void arrancarMotor();

    /**
     * Detiene el motor del ascensor, normalmente cuando la cabina
     * llega a una planta o en caso de emergencia.
     */
    void detenerMotor();

    /**
     * Ajusta finamente la posicion de la cabina para que quede perfectamente
     * nivelada con el suelo de la planta (detector de nivel).
     */
    void nivelarCabinaEnPlanta();

    // =========================
    // SEGURIDAD Y EMERGENCIAS
    // =========================

    /**
     * Activa la alarma de emergencia del ascensor.
     */
    void activarAlarma();

    /**
     * Desactiva la alarma de emergencia del ascensor.
     */
    void desactivarAlarma();

    /**
     * Bloquea por completo el funcionamiento del ascensor (modo fuera de servicio),
     * impidiendo nuevas peticiones de movimiento.
     */
    void bloquearAscensor();

    /**
     * Desbloquea el ascensor tras una revision o incidencia,
     * permitiendo volver a usarlo con normalidad.
     */
    void desbloquearAscensor();

    /**
     * Detiene el ascensor de inmediato ante una situacion de emergencia,
     * activando los sistemas de seguridad necesarios.
     */
    void paradaDeEmergencia();

    // =========================
    // COMUNICACION CON EL EXTERIOR
    // =========================

    /**
     * Inicia la comunicacion con el exterior (por ejemplo, con el servicio
     * tecnico o con un centro de emergencias).
     */
    void iniciarComunicacionExterna();

    /**
     * Finaliza la comunicacion con el exterior.
     */
    void finalizarComunicacionExterna();
}

