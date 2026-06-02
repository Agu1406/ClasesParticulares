package pruebaslibres.practica.ruta_real_232425.resueltos;

public class EjercicioRR02_POOYPolimorfismo_RESUELTO {

    static int contador = 0;

    public EjercicioRR02_POOYPolimorfismo_RESUELTO() {
        contador++;
    }

    public static void main(String[] args) {
        new EjercicioRR02_POOYPolimorfismo_RESUELTO();
        new EjercicioRR02_POOYPolimorfismo_RESUELTO();
        System.out.println("contador = " + contador);

        PadreRR2 ref = new HijaRR2();
        System.out.println("instancia -> " + ref.sonido());
        System.out.println("static padre -> " + PadreRR2.tipo());
        System.out.println("static hija -> " + HijaRR2.tipo());
    }
}

class PadreRR2 {
    String sonido() {
        return "Padre";
    }

    static String tipo() {
        return "Tipo Padre";
    }
}

class HijaRR2 extends PadreRR2 {
    @Override
    String sonido() {
        return "Hija";
    }

    static String tipo() {
        return "Tipo Hija";
    }
}
