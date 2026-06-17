package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacelenunciadov6.resuelto.ejercicio_1;

/**
 * Mago elemental que ademas puede comportarse como aprendiz.
 */
public class MagoEstudiante extends MagoElemental implements Aprendiz {

	public MagoEstudiante(String nombre) {
		super(nombre);
	}

	@Override
	public void estudiar() {
		System.out.println("Shhhh, estoy estudiando");
	}

	@Override
	public void lanzarHechizo() {
		System.out.println("Aun estoy en practicas y no me han dado elemento…");
	}
}
