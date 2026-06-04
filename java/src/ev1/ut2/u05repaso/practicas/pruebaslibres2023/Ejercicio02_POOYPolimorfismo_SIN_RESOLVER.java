package ev1.ut2.u05repaso.practicas.pruebaslibres2023;

public class Ejercicio02_POOYPolimorfismo_SIN_RESOLVER {

    public static void main(String[] args) {
        // TODO: probar instanceof y polimorfismo.
    }
}

class A2023 {
    public String tipo() {
        return "A";
    }
}

class B2023 extends A2023 {
    @Override
    public String tipo() {
        return "B";
    }

    public String soloB() {
        return "soloB";
    }
}
