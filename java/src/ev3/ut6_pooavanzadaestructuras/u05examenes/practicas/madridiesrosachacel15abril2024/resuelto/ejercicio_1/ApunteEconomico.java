package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel15abril2024.resuelto.ejercicio_1;

/**
 * Apunte contable base: codigo, importe y concepto.
 */
public abstract class ApunteEconomico {

	private int code;
	private double importe;
	private String concepto;

	protected ApunteEconomico(int code, double importe, String concepto) {
		this.code = code;
		this.importe = importe;
		this.concepto = concepto;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public int getEjercicioActual() {
		return code / 1000;
	}

	public abstract void describe();
}
