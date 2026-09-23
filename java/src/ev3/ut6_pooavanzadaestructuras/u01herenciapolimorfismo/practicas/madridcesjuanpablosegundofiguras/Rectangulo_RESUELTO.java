package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundofiguras;

public class Rectangulo_RESUELTO extends Figura_RESUELTO {
    private double base;
    private double altura;

    public Rectangulo_RESUELTO(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Tipo = Rectangulo");
        System.out.println("Base = " + base);
        System.out.println("Altura = " + altura);
        System.out.println("Perimetro = " + calcularPerimetro());
        super.mostrarDatos();
    }
}
