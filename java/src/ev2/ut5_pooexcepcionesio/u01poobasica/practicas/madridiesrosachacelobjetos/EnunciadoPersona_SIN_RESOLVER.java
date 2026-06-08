package ev2.ut5_pooexcepcionesio.u01poobasica.practicas.madridiesrosachacelobjetos;

/**
 * Ejercicios de objetos 1 - clase Persona (IES Rosa Chacel, Madrid).
 *
 * <p>Enunciado: {@code madrid-iesrosachacel-objetos-ejercicios-1.docx} y {@code madrid-iesrosachacel-objetos-persona.docx}.</p>
 *
 * <p><b>Objetivo:</b> crear objetos, invocar metodos, leer atributos y entender referencias.</p>
 *
 * <p>Para ello, en {@code main}:</p>
 * <ol>
 *   <li>Crear {@code Persona pepe} y pedirle saludar y despedirse.</li>
 *   <li>Mostrar nombre y edad; cambiar a "Pepe" y 20; volver a mostrarlos.</li>
 *   <li>Modificar {@code saludar()} para incluir nombre y edad en el mensaje.</li>
 *   <li>Crear {@code Persona ana} ("Ana", 18) y hacer que saluden ambos.</li>
 *   <li>Probar {@code Persona aux = pepe; aux.saludar();} y razonar cuantos objetos hay.</li>
 *   <li>Probar {@code ana = aux; ana.saludar();} y explicar que pasa con el objeto original de Ana.</li>
 * </ol>
 *
 * <p>Referencia resuelta del centro en {@code Objetos (1).zip} (paquete {@code ejer}).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class EnunciadoPersona_SIN_RESOLVER {

    public static void main(String[] args) {
        Persona pepe;
        Persona ana;
        Persona auxiliar;

        // TODO: crear pepe, saludar, despedir, mostrar atributos, cambiar datos
        // TODO: crear ana y hacer saludar a pepe y ana
        // TODO: probar auxiliar = pepe y ana = auxiliar; comentar en consola el resultado
    }

    static class Persona {
        String nombre;
        int edad;

        public Persona() {
            // TODO
        }

        public Persona(String nombre, int edad) {
            // TODO
        }

        public void saludar(String nombreOtro) {
            // TODO: "Hola, soy <nombre> y tengo <edad> anos. Que tal <nombreOtro>?"
        }

        public void despedir() {
            // TODO
        }

        public void imprimir() {
            // TODO: mostrar nombre y edad
        }
    }
}
