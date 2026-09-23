package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundofiguras;

public class Circulo_RESUELTO extends Figura_RESUELTO {
    private double radio;

    public Circulo_RESUELTO(double radio) {
        this.radio = radio;
    }

    public double calcularDiametro() {
        return 2 * radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Tipo = Circulo");
        System.out.println("Radio = " + radio);
        System.out.println("Diametro = " + calcularDiametro());
        super.mostrarDatos();
    }
}
