package general.poobasico;

/**
 * Teoría: varios objetos de la misma clase.
 *
 * <p><b>Objetivo:</b> crear varias instancias independientes; cada objeto tiene sus
 * propios valores de atributo.</p>
 *
 * <p>Demo ampliado con varias clases relacionadas:
 * {@link general.poobasico.objetos.EjemploObjetosJuego} (en esta carpeta {@code teoria/}).</p>
 *
 * <p>Practica en {@code ejercicios/02-objetos/pendientes} y {@code resueltos}.</p>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 02/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class ObjetosIntro {

    static class Persona {
        String nombre;
        int edad;
    }

    public static void main(String[] args) {
        Persona ana = new Persona();
        ana.nombre = "Ana";
        ana.edad = 20;

        Persona luis = new Persona();
        luis.nombre = "Luis";
        luis.edad = 24;

        System.out.println(ana.nombre + ", " + ana.edad);
        System.out.println(luis.nombre + ", " + luis.edad);
    }
}
