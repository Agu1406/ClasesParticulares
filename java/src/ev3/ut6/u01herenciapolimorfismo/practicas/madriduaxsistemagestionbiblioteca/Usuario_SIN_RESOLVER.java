package ev3.ut6.u01herenciapolimorfismo.practicas.madriduaxsistemagestionbiblioteca;

import java.util.Date;

public class Usuario_SIN_RESOLVER implements Clonable_SIN_RESOLVER, Imprimible_SIN_RESOLVER {
    private String nombre;
    private Date fechaInicioReserva;
    private Date fechaFinReserva;

    public Usuario_SIN_RESOLVER(String nombre) {
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
    public Usuario_SIN_RESOLVER clonar() {
        Usuario_SIN_RESOLVER clon = new Usuario_SIN_RESOLVER(this.nombre);
        clon.fechaInicioReserva = this.fechaInicioReserva;
        clon.fechaFinReserva = this.fechaFinReserva;
        return clon;
    }

    @Override
    public void imprimir() {
        System.out.printf("sistema_gestion_biblioteca.Usuario_SIN_RESOLVER: %s%n", nombre);
        if (fechaInicioReserva != null && fechaFinReserva != null) {
            System.out.printf("sistema_gestion_biblioteca.Reserva_SIN_RESOLVER: desde %s hasta %s%n",
                fechaInicioReserva, fechaFinReserva);
        }
    }
} 
