package ev2.ut5_pooexcepcionesio.u05repaso.practicas.pruebaslibrescoleccion;

/**
 * Preguntas relacionadas (orientativo):
 * - 2025: Q4, Q5, Q6, Q11, Q15, Q26, Q36, Q40
 * - 2021-2024: static, constructores, herencia y enlace dinamico.
 */
public class Ejercicio16_POOStaticYConstructores_SIN_RESOLVER {

    static int contador = 0;

    public Ejercicio16_POOStaticYConstructores_SIN_RESOLVER() {
        // TODO: incrementar contador en cada construccion.
    }

    public static void main(String[] args) {
        // TODO: crear dos objetos y mostrar contador.
        // TODO: crear una referencia de tipo Padre a objeto Hija y probar:
        // - metodo() sobreescrito
        // - metodoStatic() de clase
        // Explica por consola que el dynamic dispatch aplica a metodos de instancia,
        // no a static.
    }
}

class Padre16 {
    String metodo() {
        return "Padre";
    }

    static String metodoStatic() {
        return "Static Padre";
    }
}

class Hija16 extends Padre16 {
    @Override
    String metodo() {
        return "Hija";
    }

    static String metodoStatic() {
        return "Static Hija";
    }
}
