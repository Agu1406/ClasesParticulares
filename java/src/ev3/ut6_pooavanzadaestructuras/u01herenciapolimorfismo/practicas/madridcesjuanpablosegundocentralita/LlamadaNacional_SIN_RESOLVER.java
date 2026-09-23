package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundocentralita;

public class LlamadaNacional_SIN_RESOLVER extends Llamada_SIN_RESOLVER {
    private int franja;

    public LlamadaNacional_SIN_RESOLVER(String nOrigen, String nDestino, int duracion, int franja) {
        super(nOrigen, nDestino, duracion);
        this.franja = franja;
    }

    @Override
    public double calcularCoste() {
        // TODO: franja 1/2/3 → 0.20 / 0.25 / 0.30
        return 0;
    }
}
