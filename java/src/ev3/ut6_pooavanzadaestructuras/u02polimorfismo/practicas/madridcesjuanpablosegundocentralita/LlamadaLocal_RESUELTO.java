package ev3.ut6_pooavanzadaestructuras.u02polimorfismo.practicas.madridcesjuanpablosegundocentralita;

public class LlamadaLocal_RESUELTO extends Llamada_RESUELTO {
    public LlamadaLocal_RESUELTO(String nOrigen, String nDestino, int duracion) {
        super(nOrigen, nDestino, duracion);
    }
    @Override public double calcularCoste() { return 0.0; }
    @Override public void mostrarDatos() {
        System.out.println("Tipo = Local");
        super.mostrarDatos();
    }
}
