package pruebaslibres.practica.resueltos;

public class Ejercicio04_MetodosYPasoPorValor_RESUELTO {

    public static void main(String[] args) {
        System.out.println("Prueba annadirCincoIgualQueEnElExamen():");
        annadirCincoIgualQueEnElExamen();

        System.out.println("\nPrueba probarMetodoConVariableEstatica():");
        probarMetodoConVariableEstatica();

        System.out.println("\nPrueba constructores Padre / Hija:");
        new ClaseHija(2);
        System.out.println("**FIN");
    }

    public static void annadirCincoIgualQueEnElExamen() {
        Integer i = new Integer(0);
        annadirCinco(i);
        System.out.println(i.intValue());
    }

    public static void annadirCinco(Integer i) {
        int val = i.intValue();
        val += 5;
        i = new Integer(val);
    }

    static int j = 20;

    public static void probarMetodoConVariableEstatica() {
        int i = 10;
        metodo(i);
        System.out.println(i);
        System.out.println(j);
    }

    public static void metodo(int x) {
        x = x * 2;
        j = j * 2;
    }
}

class ClasePadre {
    public ClasePadre(int x) {
        System.out.print("**ClasePadre-" + x);
    }
}

class ClaseHija extends ClasePadre {
    public ClaseHija(int x) {
        super(x);
        System.out.print("**ClaseHija-" + x * x);
    }
}

