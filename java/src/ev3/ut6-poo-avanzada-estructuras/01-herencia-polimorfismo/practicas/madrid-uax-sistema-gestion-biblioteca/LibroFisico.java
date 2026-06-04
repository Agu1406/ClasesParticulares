package madrid.uax.tecnicasprogramacion.sistema_gestion_biblioteca;

public class LibroFisico extends Libro {
    private String ubicacion;

    public LibroFisico(String titulo, String autor, String ubicacion) {
        super(titulo, autor);
        this.ubicacion = ubicacion;
    }

    // Getters y setters
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    @Override
    public void imprimir() {
        System.out.printf("sistema_gestion_biblioteca.Libro Fisico - Titulo: %s, Autor: %s, Ubicacion: %s%n",
            getTitulo(), getAutor(), ubicacion);
    }
} 
