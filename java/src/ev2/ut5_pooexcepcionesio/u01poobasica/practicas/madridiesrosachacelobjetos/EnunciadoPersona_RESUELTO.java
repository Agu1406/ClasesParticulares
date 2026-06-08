package ev2.ut5_pooexcepcionesio.u01poobasica.practicas.madridiesrosachacelobjetos;

/**
 * Ejercicios de objetos 1 - clase Persona (IES Rosa Chacel, Madrid).
 *
 * <p>Enunciado: {@code madrid-iesrosachacel-objetos-ejercicios-1.docx} y {@code madrid-iesrosachacel-objetos-persona.docx}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class EnunciadoPersona_RESUELTO {

    public static void main(String[] args) {
        Persona pepe;
        Persona ana;
        Persona auxiliar;

        pepe = new Persona();
        pepe.saludar("Marta");
        pepe.despedir();
        pepe.imprimir();

        pepe.nombre = "Pepe";
        pepe.edad = 20;
        pepe.imprimir();
        pepe.saludar("Marta");
        pepe.despedir();

        ana = new Persona("Ana", 18);
        ana.saludar("");

        auxiliar = pepe;
        System.out.println("--- auxiliar apunta al mismo objeto que pepe ---");
        auxiliar.saludar("");

        ana = auxiliar;
        System.out.println("--- ana ahora apunta al objeto de pepe; el objeto Ana original ya no tiene referencia ---");
        ana.saludar("");
    }

    static class Persona {
        String nombre;
        int edad;

        public Persona() {
        }

        public Persona(String nombrePersona, int edadPersona) {
            nombre = nombrePersona;
            edad = edadPersona;
        }

        public void saludar(String nombreOtro) {
            System.out.println("Hola, soy " + nombre + " y tengo " + edad + " anos. Que tal " + nombreOtro + "?");
        }

        public void despedir() {
            System.out.println("Adios");
        }

        public void imprimir() {
            System.out.println("Nombre: " + nombre + ", edad: " + edad);
        }
    }
}
