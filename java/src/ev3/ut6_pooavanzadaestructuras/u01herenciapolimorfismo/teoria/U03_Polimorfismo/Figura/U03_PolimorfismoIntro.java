package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U03_Polimorfismo;

/**
 * Teoria: polimorfismo (misma llamada, distinto comportamiento).
 *
 * <p><b>Objetivo:</b> usar una referencia de supertipo ({@link Figura}) que apunta a
 * objetos de subtipos ({@link Circulo}, {@link Rectangulo}). El metodo que se ejecuta
 * es el de la clase real del objeto (enlace dinamico). Utilizar {@code instanceof}
 * cuando haga falta bajar al tipo concreto.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/09/2026
 * @see Figura
 * @see Circulo
 * @see Rectangulo
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U03_PolimorfismoIntro {

    public static void main(String[] args) {
        System.out.println("=== POLIMORFISMO: array de Figura ===\n");

        Figura[] figuras = new Figura[4];
        figuras[0] = new Circulo(2.5);
        figuras[1] = new Rectangulo(3, 4);
        figuras[2] = new Circulo(1.0, "rojo");
        figuras[3] = new Rectangulo(2, 5, "azul");

        double sumaAreas = 0;
        for (Figura f : figuras) {
            System.out.println(f);
            sumaAreas += f.calcularArea();
        }
        System.out.println("\nSuma de areas: " + sumaAreas);

        System.out.println("\n=== instanceof + downcast ===");
        for (Figura f : figuras) {
            if (f instanceof Circulo) {
                Circulo c = (Circulo) f;
                System.out.println(c.getNombre() + " radio=" + c.getRadio());
            } else if (f instanceof Rectangulo) {
                Rectangulo r = (Rectangulo) f;
                System.out.println(r.getNombre() + " base=" + r.getBase()
                        + " altura=" + r.getAltura());
            }
        }
    }
}
