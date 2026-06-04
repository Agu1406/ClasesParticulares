package ev1.ut2.u05repaso.practicas.pruebaslibres2023;

public class Ejercicio02_POOYPolimorfismo_RESUELTO {

    public static void main(String[] args) {
        Object o1 = new A2023R();
        Object o2 = new B2023R();
        System.out.println(o1 instanceof A2023R);
        System.out.println(o1 instanceof B2023R);
        System.out.println(o2 instanceof A2023R);
        System.out.println(o2 instanceof B2023R);

        A2023R ref = new B2023R();
        System.out.println(ref.tipo());
        if (ref instanceof B2023R) {
            System.out.println(((B2023R) ref).soloB());
        }
    }
}

class A2023R {
    public String tipo() {
        return "A";
    }
}

class B2023R extends A2023R {
    @Override
    public String tipo() {
        return "B";
    }

    public String soloB() {
        return "soloB";
    }
}
