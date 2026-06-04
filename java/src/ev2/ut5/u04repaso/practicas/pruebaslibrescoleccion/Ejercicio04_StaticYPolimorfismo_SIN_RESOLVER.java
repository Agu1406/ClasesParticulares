package ev2.ut5.u04repaso.practicas.pruebaslibrescoleccion;

/**
 * Ejercicio 04 - static, constructores y polimorfismo.
 */
public class Ejercicio04_StaticYPolimorfismo_SIN_RESOLVER {

    public static void main(String[] args) {
        // TODO: probar PreguntaStaticSimple y referencias polimorficas.
    }
}

class PreguntaStaticSimple {
    static int contador;
    static {
        // TODO: inicializar contador a 5 con un bucle.
    }
    public PreguntaStaticSimple() {
        // TODO: reiniciar contador a 0.
    }
}

class PersonaBase {
    public void saludar() {
        System.out.println("Hola desde PersonaBase");
    }
}

class AlumnoHijo extends PersonaBase {
    public void saludar() {
        System.out.println("Hola desde AlumnoHijo");
    }
    public void pasarCurso() {
        System.out.println("Pasa de curso");
    }
}
