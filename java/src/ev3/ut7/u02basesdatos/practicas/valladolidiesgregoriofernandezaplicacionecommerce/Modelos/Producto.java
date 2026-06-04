package ev3.ut7.u02basesdatos.practicas.valladolidiesgregoriofernandezaplicacionecommerce.Modelos;

// Clase que representa un producto en la tienda
public class Producto {
    private String referencia; // Referencia del producto
    private String descripcion; // Descripcion del producto
    private int precio; // Precio del producto en enteros

    // Constructor que inicializa la referencia, descripcion y precio del producto
    public Producto(String referencia, String descripcion, int precio) {
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Getter para obtener la referencia del producto
    public String getReferencia() {
        return referencia;
    }

    // Setter para establecer la referencia del producto
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    // Getter para obtener la descripcion del producto
    public String getDescripcion() {
        return descripcion;
    }

    // Setter para establecer la descripcion del producto
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter para obtener el precio del producto
    public int getPrecio() {
        return precio;
    }

    // Setter para establecer el precio del producto
    public void setPrecio(int precio) {
        this.precio = precio;
    }
}