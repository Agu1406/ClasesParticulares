package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundofiguras;

public class Triangulo_SIN_RESOLVER extends Figura_SIN_RESOLVER {
    private double base;
    private double altura;

    public Triangulo_SIN_RESOLVER(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() { return 0; /* TODO (base*altura)/2 */ }
}
