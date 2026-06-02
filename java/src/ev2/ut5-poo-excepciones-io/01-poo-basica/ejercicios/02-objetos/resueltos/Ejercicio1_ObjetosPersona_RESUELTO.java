package general.poobasico.objetos;

/**
 * Ejercicio POO Basico - Objetos (Resuelto)
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/05/2026
 */
public class Ejercicio1_ObjetosPersona_RESUELTO {
    public static void main(String[] args) {
        PersonaResuelta persona1 = new PersonaResuelta();
        persona1.nombre = "Ana";
        persona1.edad = 20;

        PersonaResuelta persona2 = new PersonaResuelta();
        persona2.nombre = "Luis";
        persona2.edad = 24;

        System.out.println(persona1.nombre + " - " + persona1.edad);
        System.out.println(persona2.nombre + " - " + persona2.edad);
    }
}

class PersonaResuelta {
    String nombre;
    int edad;
}
