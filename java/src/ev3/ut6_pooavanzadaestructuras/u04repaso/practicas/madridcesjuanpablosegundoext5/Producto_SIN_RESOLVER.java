package ev3.ut6_pooavanzadaestructuras.u04repaso.practicas.madridcesjuanpablosegundoext5;

/**
 * Clase que representa un producto del restaurante
 */
public class Producto_SIN_RESOLVER {
    private String nombre;
    private int precio;

    /**
     * Constructor de la clase Producto_SIN_RESOLVER
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     */
    public Producto_SIN_RESOLVER(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Obtiene el nombre del producto
     * @return Nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto
     * @param nombre Nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto
     * @return Precio del producto
     */
    public int getPrecio() {
        return (int) precio;
    }

    /**
     * Establece el precio del producto
     * @param precio Precio del producto
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Muestra toda la informacion del producto
     */
    public void mostrarDatos() {
        System.out.println("Producto_SIN_RESOLVER: " + nombre + " - Precio: " + precio + " ?");
    }

    @Override
    public String toString() {
        return "Producto_SIN_RESOLVER{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}

