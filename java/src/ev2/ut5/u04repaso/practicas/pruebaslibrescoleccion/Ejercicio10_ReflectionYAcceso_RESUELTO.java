package ev2.ut5.u04repaso.practicas.pruebaslibrescoleccion;

import java.lang.reflect.Method;

public class Ejercicio10_ReflectionYAcceso_RESUELTO {

    public static void main(String[] args) {
        Method[] metodos = ClaseEjemploResuelto.class.getDeclaredMethods();
        System.out.println("Metodos declarados en ClaseEjemploResuelto:");
        for (Method m : metodos) {
            System.out.println("- " + m.getName());
        }

        Class<?> superClase = SubclaseEjemploResuelto.class.getSuperclass();
        System.out.println("Superclase de SubclaseEjemploResuelto: " + superClase.getSimpleName());
    }
}

class ClaseEjemploResuelto {
    public void publico() {}
    private void privado() {}
    static void paquete() {}
}

class SubclaseEjemploResuelto extends ClaseEjemploResuelto {
}
