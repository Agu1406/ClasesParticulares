package andalucia.sevilla.iesvelazquez.DAM1.alquiler.fase1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler {
    private static final double PRECIO_DIA = 50.0;

    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaAlquiler;
    private int dias;

    public Alquiler(Cliente cliente, Vehiculo vehiculo) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaAlquiler = LocalDate.now();
        this.dias = 0;
        this.vehiculo.setDisponible(false);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public int getDias() {
        return dias;
    }

    private int diferenciaDias(LocalDate inicio, LocalDate fin) {
        long diff = ChronoUnit.DAYS.between(inicio, fin);
        if (diff <= 0) {
            return 1;
        } else {
            return (int) diff;
        }
    }

    public void cerrar() {
        LocalDate hoy = LocalDate.now();
        this.dias = diferenciaDias(fechaAlquiler, hoy);
        this.vehiculo.setDisponible(true);
    }

    public double precioAlquiler() {
        return PRECIO_DIA * dias + (vehiculo.getCilindrada() / 100.0);
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "cliente=" + cliente +
                ", vehiculo=" + vehiculo +
                ", fechaAlquiler=" + fechaAlquiler +
                ", dias=" + dias +
                ", precio=" + precioAlquiler() +
                '}';
    }
}

