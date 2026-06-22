package recuperacionordinaria.internorecuperacionordinaria.resuelto.ejercicio_03_detectives;

import java.io.Serializable;

/**
 * Expediente de la agencia de detectives (Apartado entregado).
 */
public class CasoDetective implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codigoCaso;
	private String nombreSospechoso;
	private boolean estaResuelto;

	public CasoDetective(String codigoCaso, String nombreSospechoso, boolean estaResuelto) {
		this.codigoCaso = codigoCaso;
		this.nombreSospechoso = nombreSospechoso;
		this.estaResuelto = estaResuelto;
	}

	public String getCodigoCaso() {
		return codigoCaso;
	}

	public void setCodigoCaso(String codigoCaso) {
		this.codigoCaso = codigoCaso;
	}

	public String getNombreSospechoso() {
		return nombreSospechoso;
	}

	public void setNombreSospechoso(String nombreSospechoso) {
		this.nombreSospechoso = nombreSospechoso;
	}

	public boolean isEstaResuelto() {
		return estaResuelto;
	}

	public void setEstaResuelto(boolean estaResuelto) {
		this.estaResuelto = estaResuelto;
	}

	@Override
	public String toString() {
		return codigoCaso + " - " + nombreSospechoso + (estaResuelto ? " (resuelto)" : " (cerrado)");
	}
}
