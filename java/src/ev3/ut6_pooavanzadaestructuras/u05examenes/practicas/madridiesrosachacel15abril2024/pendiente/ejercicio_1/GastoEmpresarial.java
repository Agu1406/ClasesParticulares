package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel15abril2024.pendiente.ejercicio_1;

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
		// TODO
		throw new UnsupportedOperationException();
	}
}
