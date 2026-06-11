package ev3.ut9_programacionfuncional.pf.u05repaso.practicas.internotpppsalesanalytics.resuelto;

/**
 * Nivel de fidelizacion del cliente. Se usa en filtros con {@code filter(...)}
 * y en predicados del examen para segmentar pedidos por tipo de cliente.
 */
public enum Tier {

	/** Cliente estandar, sin ventajas especiales. */
	STANDARD,

	/** Cliente premium, nivel intermedio. */
	PREMIUM,

	/** Cliente VIP, nivel mas alto. */
	VIP
}
