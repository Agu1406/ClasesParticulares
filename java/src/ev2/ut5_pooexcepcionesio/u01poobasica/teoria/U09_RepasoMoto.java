package ev2.ut5_pooexcepcionesio.u01poobasica.teoria;

/**
 * Repaso de clase: modelo {@code Moto} con encapsulacion, {@code toString} y metodo de instancia.
 *
 * <p><b>Objetivo:</b> reunir constructor, getters/setters, {@code toString} y un metodo
 * de comportamiento ({@link #hacerRuido()}). Driver: {@link U09_RepasoMotoDemo}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/09/2026
 * @see U09_RepasoMotoDemo
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U09_RepasoMoto {

    private String matricula;
    private String marca;
    private String titular;
    private int velocidadMax;
    private boolean itv;

    public U09_RepasoMoto(String matricula, String marca, String titular, int velocidadMax) {
        this.matricula = matricula;
        this.marca = marca;
        this.titular = titular;
        this.velocidadMax = velocidadMax;
        this.itv = true;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getTitular() {
        return titular;
    }

    public int getVelocidadMax() {
        return velocidadMax;
    }

    public boolean isItv() {
        return itv;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void hacerRuido() {
        System.out.println("¡Runnnnnn! ¡Runnnnn!");
    }

    @Override
    public String toString() {
        return "¡Datos de la moto!\n"
                + "- Titular: " + this.titular + "\n"
                + "- Matricula: " + this.matricula + "\n"
                + "- Marca: " + this.marca + "\n"
                + "- Velocidad Maxima: " + this.velocidadMax + "\n"
                + "- ITV: " + this.itv + "\n";
    }
}
