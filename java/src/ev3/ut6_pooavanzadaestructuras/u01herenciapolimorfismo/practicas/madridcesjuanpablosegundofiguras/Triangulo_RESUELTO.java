package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundofiguras;

public class Triangulo_RESUELTO extends Figura_RESUELTO {
    private double base;
    private double altura;

    public Triangulo_RESUELTO(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Tipo = Triangulo");
        System.out.println("Base = " + base);
        System.out.println("Altura = " + altura);
        super.mostrarDatos();
    }
}
