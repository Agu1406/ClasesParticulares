package ev3.ut6.u01herenciapolimorfismo.ejercicios.resueltos;

public class Animal {
    private String nombre;
    private String genero;
    private String color;

    /**
     * Permite crear nuevos objetos (instanacias) de la clase Animal,
     * recibiendo en forma de argumentos los siguientes datos:
     * @param nombre (String)
     * @param genero (String)
     * @param color (String)
     */
    public Animal (String nombre, String genero, String color) {
        this.nombre = nombre;
        this.genero = genero;
        this.color = color;
    }

    /**
     * Permite ver el color del animal en forma de String.
     * @return (String) color del animal.
     */
    public String getColor() {
        return color;
    }

    /**
     * Permite ver el genero del animal en forma de String.
     * @return (String) genero del animal.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Permite ver el nombre del animal en forma de String.
     * @return (String) nombre del animal.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Permite modificar/actualizar el nombre del animal.
     * @param nombre (String)
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Permite modificar/actualizar el genero del animal
     * @param genero (String)
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Permite modificar/actualizar el color del animal
     * @param color (String)
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Crea un String con la información de un "X" animal en el
     * formato que nosotros elegimos.
     * @return (String).
     */
    @Override
    public String toString() {
        return "¡INFORMACIÓN DEL ANIMAL! \n" +
                "Nombre: " + nombre + "\n" +
                "Genero: " + genero + "\n" +
                "Color: " + color + "\n";
    }

    public void hacerSonido () {
        System.out.println("El animal esta haciendo ruido...");
    }
}
