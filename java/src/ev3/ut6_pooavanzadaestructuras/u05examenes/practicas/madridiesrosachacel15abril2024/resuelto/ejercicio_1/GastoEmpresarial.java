package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel15abril2024.resuelto.ejercicio_1;

/**
 * Apunte economico de tipo gasto empresarial.
 */
public class GastoEmpresarial extends ApunteEconomico {

	private String fecha;
	private String dniResponsable;

	public GastoEmpresarial(int code, double importe, String concepto, String fecha, String dniResponsable) {
		super(code, importe, concepto);
		this.fecha = fecha;
		this.dniResponsable = dniResponsable;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDniResponsable() {
		return dniResponsable;
	}

	public void setDniResponsable(String dniResponsable) {
		this.dniResponsable = dniResponsable;
	}

	@Override
	public void describe() {
		System.out.println("GastoEmpresarial [code=" + getCode() + ", ejercicio=" + getEjercicioActual()
				+ ", importe=" + getImporte() + ", concepto=" + getConcepto()
				+ ", fecha=" + fecha + ", DNIResponsable=" + dniResponsable + "]");
	}
}
