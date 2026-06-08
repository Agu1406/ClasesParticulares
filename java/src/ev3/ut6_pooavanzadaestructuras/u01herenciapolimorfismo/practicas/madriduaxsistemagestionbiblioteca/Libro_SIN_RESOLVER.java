package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madriduaxsistemagestionbiblioteca;

public abstract class Libro_SIN_RESOLVER implements Imprimible_SIN_RESOLVER {
    private String titulo;
    private String autor;

    public Libro_SIN_RESOLVER(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    // Getters y setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    @Override
    public abstract void imprimir();
}
