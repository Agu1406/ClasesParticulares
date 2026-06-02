package general.poobasico;

/**
 * Teoría: clase y objeto en Java.
 *
 * <p><b>Objetivo:</b> distinguir la <em>clase</em> (plantilla con atributos) del
 * <em>objeto</em> (instancia concreta creada con {@code new}).</p>
 *
 * <pre>{@code
 * class Coche {
 *     String marca;
 *     int velocidad;
 * }
 * Coche c = new Coche();
 * c.marca = "Toyota";
 * }</pre>
 *
 * <p>Practica en {@code ejercicios/clases/pendientes} y {@code resueltos}.</p>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 02/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class ClasesIntro {

    static class Coche {
        String marca;
        int velocidad;
    }

    public static void main(String[] args) {
        Coche coche = new Coche();
        coche.marca = "Toyota";
        coche.velocidad = 90;
        System.out.println(coche.marca + " a " + coche.velocidad + " km/h");
    }
}
