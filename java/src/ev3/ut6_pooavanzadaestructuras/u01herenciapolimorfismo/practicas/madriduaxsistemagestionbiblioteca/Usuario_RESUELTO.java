package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madriduaxsistemagestionbiblioteca;

import java.util.Date;

public class Usuario_RESUELTO implements Clonable_RESUELTO, Imprimible_RESUELTO {
    private String nombre;
    private Date fechaInicioReserva;
    private Date fechaFinReserva;

    public Usuario_RESUELTO(String nombre) {
        this.nombre = nombre;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Date getFechaInicioReserva() { return fechaInicioReserva; }
    public void setFechaInicioReserva(Date fecha) { this.fechaInicioReserva = fecha; }

    public Date getFechaFinReserva() { return fechaFinReserva; }
    public void setFechaFinReserva(Date fecha) { this.fechaFinReserva = fecha; }

    @Override
    public Usuario_RESUELTO clonar() {
        Usuario_RESUELTO clon = new Usuario_RESUELTO(this.nombre);
        clon.fechaInicioReserva = this.fechaInicioReserva;
        clon.fechaFinReserva = this.fechaFinReserva;
        return clon;
    }

    @Override
    public void imprimir() {
        System.out.printf("sistema_gestion_biblioteca.Usuario_RESUELTO: %s%n", nombre);
        if (fechaInicioReserva != null && fechaFinReserva != null) {
            System.out.printf("sistema_gestion_biblioteca.Reserva_RESUELTO: desde %s hasta %s%n",
                fechaInicioReserva, fechaFinReserva);
        }
    }
} 
