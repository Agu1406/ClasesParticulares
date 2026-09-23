package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundocentralita;

public abstract class Llamada_RESUELTO {
    protected String nOrigen;
    protected String nDestino;
    protected int duracion;
    protected double coste;

    public Llamada_RESUELTO(String nOrigen, String nDestino, int duracion) {
        this.nOrigen = nOrigen;
        this.nDestino = nDestino;
        this.duracion = duracion;
        this.coste = calcularCoste();
    }

    public abstract double calcularCoste();

    public void mostrarDatos() {
        System.out.println("Origen = " + nOrigen);
        System.out.println("Destino = " + nDestino);
        System.out.println("Duracion = " + duracion);
        System.out.println("Coste = " + coste);
    }

    public double getCoste() { return coste; }
}
