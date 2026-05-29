package general.poo_basico.resueltos;

/**
 * Ejercicio 4: Clase Producto (RESUELTO)
 * 
 * Demuestra:
 *  - Gestión de estado (stock)
 *  - Funciones con lógica condicional
 *  - Encapsulación de atributos
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio4_Producto {

    static class Producto {
        private String nombre;
        private double precio;
        private int stock;

        public Producto(String nombre, double precio, int stock) {
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }

        public void vender(int cantidad) {
            if (cantidad <= 0) {
                System.out.println("La cantidad a vender debe ser positiva.");
                return;
            }
            if (cantidad > stock) {
                System.out.println("No hay suficiente stock para vender " + cantidad + " unidades.");
                return;
            }
            stock -= cantidad;
            System.out.println("Venta realizada: " + cantidad + " unidades.");
        }

        public void reponer(int cantidad) {
            if (cantidad <= 0) {
                System.out.println("La cantidad a reponer debe ser positiva.");
                return;
            }
            stock += cantidad;
            System.out.println("Stock repuesto en " + cantidad + " unidades.");
        }

        public void mostrarInformacion() {
            System.out.println("Producto: " + nombre);
            System.out.println("Precio: " + precio + " €");
            System.out.println("Stock: " + stock + " unidades");
        }
    }

    public static void main(String[] args) {
        Producto p = new Producto("Ratón inalámbrico", 19.99, 10);

        p.mostrarInformacion();
        p.vender(3);
        p.mostrarInformacion();
        p.reponer(5);
        p.mostrarInformacion();
        p.vender(20); // ejemplo de stock insuficiente
    }
}

