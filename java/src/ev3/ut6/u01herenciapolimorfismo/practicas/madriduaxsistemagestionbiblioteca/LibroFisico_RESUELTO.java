package ev3.ut6.u01herenciapolimorfismo.practicas.madriduaxsistemagestionbiblioteca;

public class LibroFisico_RESUELTO extends Libro_SIN_RESOLVER {
    private String ubicacion;

    public LibroFisico_RESUELTO(String titulo, String autor, String ubicacion) {
        super(titulo, autor);
        this.ubicacion = ubicacion;
    }

    // Getters y setters
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    @Override
    public void imprimir() {
        System.out.printf("sistema_gestion_biblioteca.Libro_SIN_RESOLVER Fisico - Titulo: %s, Autor: %s, Ubicacion: %s%n",
            getTitulo(), getAutor(), ubicacion);
    }
} 
