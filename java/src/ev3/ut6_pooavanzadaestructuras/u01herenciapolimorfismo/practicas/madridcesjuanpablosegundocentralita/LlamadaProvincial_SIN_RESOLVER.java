package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundocentralita;

public class LlamadaProvincial_SIN_RESOLVER extends Llamada_SIN_RESOLVER {
    public LlamadaProvincial_SIN_RESOLVER(String nOrigen, String nDestino, int duracion) {
        super(nOrigen, nDestino, duracion);
    }

    @Override
    public double calcularCoste() {
        // TODO: duracion * 0.15
        return 0;
    }
}
