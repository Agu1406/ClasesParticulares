package ev2.ut5_pooexcepcionesio.u01poobasica.practicas.internoconcesionario;

/**
 * Vehiculo del concesionario: ID autoincremental, encapsulacion y {@code toString}.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/09/2026
 * @see Concesionario
 * @see ConcesionarioMain
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Coche {

    private static int contador = 0;

    private String id;
    private String matricula;
    private String marca;
    private String modelo;
    private double precio;
    private boolean disponible;

    public Coche(String matricula, String marca, String modelo, double precio) {
        contador++;
        this.id = "ID00" + contador;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.disponible = true;
    }

    public String getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    /** Alterna disponibilidad (alta / vendido). */
    public void setDisponible() {
        this.disponible = !this.disponible;
    }

    @Override
    public String toString() {
        String disponibilidad = this.disponible ? "Disponible" : "No disponible";
        return "¡DATOS DEL COCHE!\n"
                + "- ID " + this.id + ".\n"
                + "- Matricula: " + this.matricula + ".\n"
                + "- Marca: " + this.marca + ".\n"
                + "- Modelo: " + this.modelo + ".\n"
                + "- Precio: " + this.precio + ".\n"
                + "- Disponibilidad: " + disponibilidad + ".\n";
    }
}
