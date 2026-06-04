package ev3.ut6.u01herenciapolimorfismo.practicas.madriduaxsistemagestionbiblioteca;

public class LibroDigital_RESUELTO extends Libro_SIN_RESOLVER {
    private String formato;

    public LibroDigital_RESUELTO(String titulo, String autor, String formato) {
        super(titulo, autor);
        this.formato = formato;
    }

    // Getters y setters
    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }

    @Override
    public void imprimir() {
        System.out.printf("sistema_gestion_biblioteca.Libro_SIN_RESOLVER Digital - Titulo: %s, Autor: %s, Formato: %s%n",
            getTitulo(), getAutor(), formato);
    }
} 
