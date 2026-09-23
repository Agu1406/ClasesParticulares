package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundocentralita;

public class LlamadaNacional_RESUELTO extends Llamada_RESUELTO {
    private final int franja;
    public LlamadaNacional_RESUELTO(String nOrigen, String nDestino, int duracion, int franja) {
        super(nOrigen, nDestino, duracion);
        this.franja = franja;
        this.coste = calcularCoste();
    }
    @Override public double calcularCoste() {
        double p = switch (franja) {
            case 2 -> 0.25;
            case 3 -> 0.30;
            default -> 0.20;
        };
        return duracion * p;
    }
    @Override public void mostrarDatos() {
        System.out.println("Tipo = Nacional");
        System.out.println("Franja = " + franja);
        super.mostrarDatos();
    }
}
