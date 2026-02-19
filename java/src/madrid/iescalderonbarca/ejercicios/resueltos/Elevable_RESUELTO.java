/**
 * Autor: NOMBRE_DEL_ALUMNO
 * Curso: 1º Bachillerato / Programación
 * Fecha: AAAA-MM-DD
 *
 * Interfaz que define el comportamiento mínimo de un ascensor (Elevable).
 */
public interface Elevable {

    // =========================
    // ESTADO GENERAL / CONSULTAS
    // =========================

    /**
     * Devuelve la planta actual en la que se encuentra la cabina.
     *
     * @return número de planta actual.
     */
    int getPlantaActual();

    /**
     * Devuelve la planta objetivo a la que se está desplazando el ascensor,
     * o la misma planta actual si está parado.
     *
     * @return planta objetivo.
     */
    int getPlantaObjetivo();

    /**
     * Indica si el ascensor se encuentra en movimiento.
     *
     * @return true si está en movimiento, false en caso contrario.
     */
    boolean estaEnMovimiento();

    /**
     * Indica si la cabina está sobrecargada según el detector de sobrepeso.
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
    // ILUMINACIÓN Y ENERGÍA
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
     * Activa un modo de ahorro energético (por ejemplo, apagando luces
     * o deteniendo el ascensor en una planta neutra).
     */
    void activarModoAhorroEnergia();

    /**
     * Desactiva el modo de ahorro energético y devuelve el ascensor
     * al funcionamiento normal.
     */
    void desactivarModoAhorroEnergia();

    // =========================
    // BOTONERA INTERIOR
    // =========================

    /**
     * Registra la pulsación de un botón de planta en la botonera interior
     * de la cabina.
     *
     * @param planta planta solicitada desde el interior.
     */
    void pulsarBotonInteriorPlanta(int planta);

    /**
     * Cancela todas las peticiones de planta realizadas desde el interior.
     * Útil en situaciones de emergencia o reinicio.
     */
    void cancelarPeticionesInteriores();

    // =========================
    // BOTONERA EXTERIOR
    // =========================

    /**
     * Registra la petición de llamada al ascensor desde una planta concreta
     * indicando la dirección deseada (subir o bajar).
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
     * Inicia el movimiento de la cabina en la dirección adecuada según
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
     * Ajusta finamente la posición de la cabina para que quede perfectamente
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
     * Desbloquea el ascensor tras una revisión o incidencia,
     * permitiendo volver a usarlo con normalidad.
     */
    void desbloquearAscensor();

    /**
     * Detiene el ascensor de inmediato ante una situación de emergencia,
     * activando los sistemas de seguridad necesarios.
     */
    void paradaDeEmergencia();

    // =========================
    // COMUNICACIÓN CON EL EXTERIOR
    // =========================

    /**
     * Inicia la comunicación con el exterior (por ejemplo, con el servicio
     * técnico o con un centro de emergencias).
     */
    void iniciarComunicacionExterna();

    /**
     * Finaliza la comunicación con el exterior.
     */
    void finalizarComunicacionExterna();
}

