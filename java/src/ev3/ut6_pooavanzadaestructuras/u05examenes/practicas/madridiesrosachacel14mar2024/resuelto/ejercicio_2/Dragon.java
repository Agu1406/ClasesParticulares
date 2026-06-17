package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel14mar2024.resuelto.ejercicio_2;

/**
 * Dragon con escamas de fuego.
 */
public class Dragon extends CriaturaMistica {

	private final int escamas;

	public Dragon(String nombre, int edad, int escamas) {
		super(nombre, edad);
		this.escamas = escamas;
	}

	@Override
	public void describirCriatura() {
		System.out.println("Dragon " + getNombre() + ", edad " + getEdad() + ", escamas: " + escamas);
	}

	@Override
	public void activarPoder() {
		System.out.println(getNombre() + " lanza un aliento de fuego.");
	}
}
