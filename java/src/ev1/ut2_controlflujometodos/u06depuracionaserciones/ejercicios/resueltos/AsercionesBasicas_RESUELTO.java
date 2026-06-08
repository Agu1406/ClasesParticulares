package ev1.ut2_controlflujometodos.u06depuracionaserciones.ejercicios.resueltos;

public class AsercionesBasicas_RESUELTO {
    public static void main(String[] args) {
        int n = 5;
        assert n > 0 : "n debe ser positivo";
        System.out.println("n = " + n);
    }
}
