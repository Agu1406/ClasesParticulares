package ev2.ut5_pooexcepcionesio.u04repaso.practicas.pruebaslibrescoleccion;

public class Ejercicio16_POOStaticYConstructores_RESUELTO {

    static int contador = 0;

    public Ejercicio16_POOStaticYConstructores_RESUELTO() {
        contador++;
    }

    public static void main(String[] args) {
        new Ejercicio16_POOStaticYConstructores_RESUELTO();
        new Ejercicio16_POOStaticYConstructores_RESUELTO();
        System.out.println("contador = " + contador);

        Padre16R ref = new Hija16R();
        System.out.println("Instancia -> " + ref.metodo());
        System.out.println("Static por tipo declarado -> " + Padre16R.metodoStatic());
        System.out.println("Static por subclase -> " + Hija16R.metodoStatic());
        System.out.println("Nota: static no usa polimorfismo dinamico.");
    }
}

class Padre16R {
    String metodo() {
        return "Padre";
    }

    static String metodoStatic() {
        return "Static Padre";
    }
}

class Hija16R extends Padre16R {
    @Override
    String metodo() {
        return "Hija";
    }

    static String metodoStatic() {
        return "Static Hija";
    }
}
