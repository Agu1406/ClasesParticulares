package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundofiguras;

import java.util.ArrayList;
import java.util.Scanner;

abstract class FiguraR {
    abstract double calcularArea();
    void mostrarDatos() { System.out.println("Area = " + calcularArea()); }
}
class CirculoR extends FiguraR {
    double radio;
    CirculoR(double radio) { this.radio = radio; }
    double calcularDiametro() { return 2 * radio; }
    double calcularArea() { return Math.PI * radio * radio; }
    void mostrarDatos() {
        System.out.println("Tipo = Circulo"); System.out.println("Radio = " + radio);
        System.out.println("Diametro = " + calcularDiametro()); super.mostrarDatos();
    }
}
class RectanguloR extends FiguraR {
    double base, altura;
    RectanguloR(double base, double altura) { this.base = base; this.altura = altura; }
    double calcularPerimetro() { return 2 * (base + altura); }
    double calcularArea() { return base * altura; }
    void mostrarDatos() {
        System.out.println("Tipo = Rectangulo"); System.out.println("Base = " + base);
        System.out.println("Altura = " + altura); System.out.println("Perimetro = " + calcularPerimetro());
        super.mostrarDatos();
    }
}
class TrianguloR extends FiguraR {
    double base, altura;
    TrianguloR(double base, double altura) { this.base = base; this.altura = altura; }
    double calcularArea() { return (base * altura) / 2; }
    void mostrarDatos() {
        System.out.println("Tipo = Triangulo"); System.out.println("Base = " + base);
        System.out.println("Altura = " + altura); super.mostrarDatos();
    }
}
public class FigurasApp_RESUELTO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<FiguraR> figuras = new ArrayList<>();
        int op;
        do {
            System.out.println("1 Circulo 2 Rectangulo 3 Triangulo 4 Listar 5 AreaTotal 6 Salir");
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1 -> { System.out.println("Radio"); figuras.add(new CirculoR(Double.parseDouble(sc.nextLine()))); }
                case 2 -> {
                    System.out.println("Base"); double b = Double.parseDouble(sc.nextLine());
                    System.out.println("Altura"); double a = Double.parseDouble(sc.nextLine());
                    figuras.add(new RectanguloR(b, a));
                }
                case 3 -> {
                    System.out.println("Base"); double b = Double.parseDouble(sc.nextLine());
                    System.out.println("Altura"); double a = Double.parseDouble(sc.nextLine());
                    figuras.add(new TrianguloR(b, a));
                }
                case 4 -> { for (FiguraR f : figuras) f.mostrarDatos(); }
                case 5 -> {
                    double t = 0; for (FiguraR f : figuras) t += f.calcularArea();
                    System.out.println("Area total = " + t);
                }
                case 6 -> System.out.println("Saliendo");
                default -> System.out.println("Opcion no valida");
            }
        } while (op != 6);
    }
}
