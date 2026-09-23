package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundotrabajadores;

public class Asalariado_RESUELTO extends Trabajador_RESUELTO {
    private int numeroPagas;
    private boolean contratado;
    private double cuotaSS;

    public Asalariado_RESUELTO(String nombre, String apellido, String dni, double sueldo,
                               int numeroPagas, boolean contratado, double cuotaSS) {
        super(nombre, apellido, dni, sueldo);
        this.numeroPagas = numeroPagas;
        this.contratado = contratado;
        this.cuotaSS = cuotaSS;
    }

    @Override
    public double calcularSalarioMensual() {
        return (sueldo * 0.79) / numeroPagas;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Tipo = Asalariado");
        super.mostrarDatos();
        System.out.println("numeroPagas = " + numeroPagas);
        System.out.println("contratado = " + contratado);
        System.out.println("cuotaSS = " + cuotaSS);
    }
}
