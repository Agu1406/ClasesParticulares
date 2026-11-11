package ev4.E08_ExamenRA246.E03_InventarioTienda;

import java.util.Locale;
import java.util.Scanner;

/**
 * <p>Enunciado: {@code enunciado.md}.</p>
 *
 * <p><b>OBJETIVO:</b> RA4.3 + RA6.1 — clase {@code Producto}, array de productos,
 * ventas/reposiciones hasta {@code FIN}.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code vender} solo resta si hay stock; al listar se usa
 * {@code printf} con dos decimales y el valor total se acumula con {@code valor()}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    public static void main(String[] args) {
        /* --- Variables al principio del metodo --- */
        Scanner teclado;
        Producto[] productos;
        Producto producto;
        int n, indiceProducto, stock, unidades;
        String codigo, op;
        double precio, total, valorProducto;

        teclado = new Scanner(System.in);
        /*
         * Locale.US: el enunciado usa punto decimal (2.50).
         * Sin esto, en un PC en espanol nextDouble esperaria coma.
         */
        teclado.useLocale(Locale.US);

        System.out.print("Introduce el numero de productos => ");
        n = teclado.nextInt();
        productos = new Producto[n];

        // Carga inicial del almacen
        for (indiceProducto = 0; indiceProducto < n; indiceProducto++) {
            System.out.print("Introduce el codigo => ");
            codigo = teclado.next();
            System.out.print("Introduce el precio => ");
            precio = teclado.nextDouble();
            System.out.print("Introduce el stock => ");
            stock = teclado.nextInt();
            productos[indiceProducto] = new Producto(codigo, precio, stock);
        }

        /*
         * do-while: leemos la operacion dentro del bucle.
         * Centinela FIN: no se procesa y el bucle termina.
         */
        do {
            System.out.print("Introduce una operacion (V/R/FIN) => ");
            op = teclado.next();
            if (!op.equals("FIN")) {
                System.out.print("Introduce el codigo => ");
                codigo = teclado.next();
                System.out.print("Introduce las unidades => ");
                unidades = teclado.nextInt();
                producto = buscar(productos, codigo);

                if (producto == null) {
                    System.out.println("No existe el producto " + codigo);
                } else if (op.equals("V")) {
                    // vender devuelve false si no hay bastantes unidades
                    if (!producto.vender(unidades)) {
                        System.out.println("Stock insuficiente de " + codigo
                                + " (quedan " + producto.getStock() + ")");
                    }
                } else if (op.equals("R")) {
                    producto.reponer(unidades);
                }
            }
        } while (!op.equals("FIN"));

        // Resumen final
        total = 0;
        for (indiceProducto = 0; indiceProducto < productos.length; indiceProducto++) {
            producto = productos[indiceProducto];
            valorProducto = producto.valor();
            System.out.printf(Locale.US, "%s: %d unidades · %.2f €%n",
                    producto.getCodigo(), producto.getStock(), valorProducto);
            total = total + valorProducto;
        }
        System.out.printf(Locale.US, "Valor total: %.2f €%n", total);
        teclado.close();
    }

    /**
     * Busca un producto por codigo. Si no esta, devuelve null.
     */
    static Producto buscar(Producto[] productos, String codigo) {
        Producto encontrado;
        int indiceProducto;

        encontrado = null;
        for (indiceProducto = 0; indiceProducto < productos.length; indiceProducto++) {
            if (productos[indiceProducto].getCodigo().equals(codigo)) {
                encontrado = productos[indiceProducto];
                // Ya lo tenemos; no hace falta seguir mirando
                break;
            }
        }
        return encontrado;
    }
}

class Producto {
    private String codigo;
    private double precio;
    private int stock;

    Producto(String codigo, double precio, int stock) {
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
    }

    String getCodigo() {
        return codigo;
    }

    int getStock() {
        return stock;
    }

    /**
     * Intenta vender. Solo resta stock si hay unidades suficientes.
     *
     * @return true si se pudo vender; false si faltaba stock
     */
    boolean vender(int unidades) {
        boolean ok;

        ok = false;
        if (unidades <= stock) {
            stock = stock - unidades;
            ok = true;
        }
        return ok;
    }

    void reponer(int unidades) {
        stock = stock + unidades;
    }

    // Valor en euros del stock actual
    double valor() {
        return stock * precio;
    }
}
