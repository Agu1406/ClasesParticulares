package madrid.iescalderonbarca.ejercicios.hipodromo;

public class Caballo {
    /*
     * Todos los caballos tienen nombre y dorsal (posición) dentro de una
     * carrera, ejemplo:
     *
     *  Rosado con el número 5 (670m)
     *  Babieca con el número 2 (660m)
     *  Rufio con el número 3 (640m)
     *  Rocinante con el número 1 (580m)
     */
    public String nombre;
    public int posicion;
    // Variable que uso para saber cuantos metros ha recorrido el caballo en la carrera.
    private int distanciaRecorrida;
    // Variable que uso para saber si un caballo se ha caido o no.
    private boolean caballoCaido;

    /**
     * Constructor que permite crear objetos del tipo "Caballo" usando un
     * nombre y un dorsal (posición).
     *
     * @param nombre (String) nombre del caballo.
     * @param posicion (int) dorsal del caballo.
     */
    public Caballo(String nombre,int posicion){
        // Atributos que necesito decirle al programa sobre los caballos.
        this.nombre = nombre;
        this.posicion = posicion;
        // Atributos que vienen por defecto en todos los caballos.
        this.distanciaRecorrida = 0;
        this.caballoCaido = false;
    }

    /*========================================================================
    * GETTERS Y SETTERS DE LA CLASE
    * ======================================================================*/
    public String getNombre() {
        return nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public boolean isCaballoCaido() {
        return caballoCaido;
    }
    /*========================================================================
     * OTRAS FUNCIONES ESENCIALES DE LA CLASE
     * ======================================================================*/
    /**
     * Función que permite al caballo correr SOLO SI NO se ha caido, debemos
     * indicar la cantidad de metros que corrio.
     * @param metros (int) metros recorridos.
     */
    public void correr (int metros) {
        if (!caballoCaido) {
            this.distanciaRecorrida += metros;
        }
    }

    /**
     * Si un caballo usa la función "caerse" si booleano pasara de "false" a
     * "true" indicando que se ha caido.
     */
    public void caerse () {
        this.caballoCaido = true;
    }

    /**
     * Función que crea un String con el nombre del caballo, su posición y la
     * distancia que ha recorrido en la carrera, ejemplo:
     *
     *  Rosado con el número 5 (670m)
     *  Babieca con el número 2 (660m)
     *  Rufio con el número 3 (640m)
     *  Rocinante con el número 1 (580m)
     */
    @Override
    public String toString() {
        return nombre + " con el número " + posicion + " (" + distanciaRecorrida +")";
    }

    /**
     * Función que hace lo mismo que la función de toString pero sin crear un String,
     * solo imprime y ya, ejemplo:
     *
     *  Rosado con el número 5 (670m)
     */
    public void imprimirInformacion () {
        System.out.println(nombre + " con el número " + posicion + " (" + distanciaRecorrida +"m)");
    }
}
