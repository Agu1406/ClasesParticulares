package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel15abril2024.pendiente.ejercicio_1;

public class Factura extends ApunteEconomico {

	private int idFactura;
	private String emisor;

	public Factura(int code, double importe, String concepto, int idFactura, String emisor) {
		super(code, importe, concepto);
		this.idFactura = idFactura;
		this.emisor = emisor;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	@Override
	public void describe() {
		// TODO
		throw new UnsupportedOperationException();
	}
}
