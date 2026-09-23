package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundofiguras;

public abstract class Figura_RESUELTO {
    public abstract double calcularArea();

    public void mostrarDatos() {
        System.out.println("Area = " + calcularArea());
    }
}
