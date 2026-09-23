package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundotrabajadores;

public class Autonomo_RESUELTO extends Trabajador_RESUELTO {
    private boolean contratado;
    private double cuotaSS;

    public Autonomo_RESUELTO(String nombre, String apellido, String dni, double sueldo,
                             boolean contratado, double cuotaSS) {
        super(nombre, apellido, dni, sueldo);
        this.contratado = contratado;
        this.cuotaSS = cuotaSS;
    }

    @Override
    public double calcularSalarioMensual() {
        return (sueldo - 12 * cuotaSS) / 12;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Tipo = Autonomo");
        super.mostrarDatos();
        System.out.println("contratado = " + contratado);
        System.out.println("cuotaSS = " + cuotaSS);
    }
}
