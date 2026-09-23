package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundocentralita;

public class LlamadaProvincial_RESUELTO extends Llamada_RESUELTO {
    public LlamadaProvincial_RESUELTO(String nOrigen, String nDestino, int duracion) {
        super(nOrigen, nDestino, duracion);
    }
    @Override public double calcularCoste() { return duracion * 0.15; }
    @Override public void mostrarDatos() {
        System.out.println("Tipo = Provincial");
        super.mostrarDatos();
    }
}
