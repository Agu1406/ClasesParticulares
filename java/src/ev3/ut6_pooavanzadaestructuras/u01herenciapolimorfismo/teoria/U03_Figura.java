package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria;

/**
 * Clase base (abstracta) para el ejercicio de figuras.
 *
 * Desde aqui se definen las operaciones comunes, como calcularArea().
 * U03_Circulo y U03_Rectangulo heredaran de esta clase.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public abstract class U03_Figura {

    private int lados;
    private int area;
    private String color;
    private String nombre;

    protected U03_Figura(String nombre, String color, int lados) {
        this.nombre = nombre;
        this.color = color;
        this.lados = lados;
    }

    public abstract double calcularArea();

    protected void setArea(int area) {
        this.area = area;
    }

    public int getLados() {
        return lados;
    }

    public int getArea() {
        return area;
    }

    public String getColor() {
        return color;
    }

    public String getNombre() {
        return nombre;
    }
}
