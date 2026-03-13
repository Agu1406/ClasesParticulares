package pruebaslibres.practica.resueltos;

public class Ejercicio06_HerenciaEInterfaces_RESUELTO {

    public static void main(String[] args) {
        Producto producto = new Producto("Cuaderno");
        Componente componente = new Componente("Tornillo", 10);
        Printable printable = new Componente("Resistencia", 5);

        producto.imprimir();
        componente.imprimir();
        printable.imprimir();

        ClaseFinal claseFinal = new ClaseFinal("No heredable");
        claseFinal.imprimir();
    }
}

interface Printable {
    void imprimir();
}

class Producto implements Printable {
    private String nombre;

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void imprimir() {
        System.out.println("Producto: " + nombre);
    }
}

class Componente extends Producto implements Printable {
    private int cantidad;

    public Componente(String nombre, int cantidad) {
        super(nombre);
        this.cantidad = cantidad;
    }

    @Override
    public void imprimir() {
        System.out.println("Componente (extends Producto) con cantidad " + cantidad);
    }
}

final class ClaseFinal implements Printable {
    private String descripcion;

    public ClaseFinal(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void imprimir() {
        System.out.println("ClaseFinal: " + descripcion);
    }
}

