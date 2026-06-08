package diagnostico.ejercicios.pendientes;

import java.util.Scanner;

/**
 * Clase simple con calculo de IVA
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa con una clase Producto que calcule el precio con IVA.</li>
 * <li>Define la clase Producto con nombre, precio y el metodo calcularPrecioConIva(double porcentaje).</li>
 * <li>En el main, lee nombre, precio y porcentaje de IVA con Scanner teclado.</li>
 * <li>Crea el objeto Producto e imprime el precio final con IVA.</li>
 * </ul>
 *
 * <p>Diagnostico 16 — EV1 · ut3_stringsyenvolventes · RA2.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico16_PooClaseSimple_SIN_RESOLVER {

    // TODO: clase Producto (nombre, precio) con calcularPrecioConIva(double porcentaje)

    static class Producto {
        // TODO: atributos, constructor y calcularPrecioConIva
    }
    public static void main(String[] args) {
        Scanner teclado;
        String nombre;
        double precio;
        double porcentajeIva;
        Producto producto;
        double precioFinal;
        teclado = new Scanner(System.in);
        teclado.nextLine();
        System.out.print("Nombre del producto: ");
        nombre = teclado.nextLine();
        System.out.print("Precio: ");
        precio = teclado.nextDouble();
        System.out.print("Porcentaje IVA: ");
        porcentajeIva = teclado.nextDouble();
        // TODO: crear Producto y mostrar precio con IVA
        producto = new Producto(nombre, precio);
        precioFinal = producto.calcularPrecioConIva(porcentajeIva);
        System.out.println(producto.getNombre() + ": " + precioFinal);
        teclado.close();
    }
}
