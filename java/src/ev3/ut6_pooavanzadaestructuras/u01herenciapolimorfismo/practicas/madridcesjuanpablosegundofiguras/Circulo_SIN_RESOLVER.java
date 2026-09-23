package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundofiguras;

public class Circulo_SIN_RESOLVER extends Figura_SIN_RESOLVER {
    private double radio;

    public Circulo_SIN_RESOLVER(double radio) {
        this.radio = radio;
    }

    public double calcularDiametro() {
        // TODO: 2 * radio
        return 0;
    }

    @Override
    public double calcularArea() {
        // TODO: Math.PI * radio * radio
        return 0;
    }
}
