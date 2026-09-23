package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundocentralita;

public class LlamadaLocal_SIN_RESOLVER extends Llamada_SIN_RESOLVER {
    public LlamadaLocal_SIN_RESOLVER(String nOrigen, String nDestino, int duracion) {
        super(nOrigen, nDestino, duracion);
    }

    @Override
    public double calcularCoste() {
        // TODO: coste 0
        return 0;
    }
}
