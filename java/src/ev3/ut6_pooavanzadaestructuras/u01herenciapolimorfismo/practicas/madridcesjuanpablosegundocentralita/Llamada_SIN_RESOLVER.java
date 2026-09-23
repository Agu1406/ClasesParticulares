package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundocentralita;

public abstract class Llamada_SIN_RESOLVER {
    protected String nOrigen;
    protected String nDestino;
    protected int duracion;
    protected double coste;

    public Llamada_SIN_RESOLVER(String nOrigen, String nDestino, int duracion) {
        this.nOrigen = nOrigen;
        this.nDestino = nDestino;
        this.duracion = duracion;
        // TODO: inicializar coste con calcularCoste()
    }

    public abstract double calcularCoste();

    public void mostrarDatos() {
        // TODO: mostrar origen, destino, duracion y coste
    }
}
