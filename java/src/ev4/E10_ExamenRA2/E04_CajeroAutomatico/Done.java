package ev4.E10_ExamenRA2.E04_CajeroAutomatico;

import java.util.Scanner;

/**
 * <p>Enunciado: {@code enunciado.md}.</p>
 *
 * <p><b>OBJETIVO:</b> desglose de billetes 50/20/10 con stock limitado de 50
 * y metodo {@code mostrar}.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> validaciones en orden; {@code Math.min} para los de 50;
 * resto con division y modulo; {@code mostrar} omite cantidad 0.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 15/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    static void mostrar(int cantidad, int valor) {
        if (cantidad == 1) {
            System.out.println("1 billete de " + valor + " €");
        } else if (cantidad > 1) {
            System.out.println(cantidad + " billetes de " + valor + " €");
        }
    }

    public static void main(String[] args) {
        /* --- Variables al principio del metodo --- */
        Scanner teclado;
        int cantidad, quedan50, de50, resto, de20, de10;

        teclado = new Scanner(System.in);
        cantidad = teclado.nextInt();
        quedan50 = teclado.nextInt();

        if (cantidad <= 0) {
            System.out.println("Cantidad no válida");
        } else if (cantidad % 10 != 0) {
            System.out.println("El cajero solo entrega múltiplos de 10 €");
        } else if (cantidad > 600) {
            System.out.println("Supera el límite diario de 600 €");
        } else {
            de50 = Math.min(cantidad / 50, quedan50);
            resto = cantidad - de50 * 50;
            de20 = resto / 20;
            de10 = (resto % 20) / 10;
            mostrar(de50, 50);
            mostrar(de20, 20);
            mostrar(de10, 10);
            System.out.println("Total de billetes: " + (de50 + de20 + de10));
        }

        teclado.close();
    }
}
