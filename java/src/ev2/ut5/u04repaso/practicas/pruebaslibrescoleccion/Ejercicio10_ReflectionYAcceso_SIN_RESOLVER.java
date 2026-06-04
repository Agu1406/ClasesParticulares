package ev2.ut5.u04repaso.practicas.pruebaslibrescoleccion;

import java.lang.reflect.Method;

/**
 * Ejercicio 10 - Reflection y modificadores de acceso.
 */
public class Ejercicio10_ReflectionYAcceso_SIN_RESOLVER {

    public static void main(String[] args) {
        // TODO: mostrar metodos declarados de ClaseEjemplo con reflection.
        // TODO: mostrar superclase de SubclaseEjemplo.
    }
}

class ClaseEjemplo {
    public void publico() {}
    private void privado() {}
    static void paquete() {}
}

class SubclaseEjemplo extends ClaseEjemplo {
}
