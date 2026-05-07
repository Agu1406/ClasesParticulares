package general.poobasico.funciones;

/**
 * Ejercicio POO Basico - Funciones (Resuelto)
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/05/2026
 */
public class Ejercicio1_MetodosBasicos_RESUELTO {
    public static void main(String[] args) {
        RectanguloResuelto rectangulo = new RectanguloResuelto(8, 5);
        System.out.println("Area: " + rectangulo.calcularArea());
        System.out.println("Perimetro: " + rectangulo.calcularPerimetro());
    }
}

class RectanguloResuelto {
    double base;
    double altura;

    RectanguloResuelto(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    double calcularArea() {
        return base * altura;
    }

    double calcularPerimetro() {
        return 2 * (base + altura);
    }
}
