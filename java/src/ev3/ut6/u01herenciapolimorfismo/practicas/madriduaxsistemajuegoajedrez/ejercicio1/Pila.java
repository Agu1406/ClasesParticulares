package ev3.ut6.u01herenciapolimorfismo.practicas.madriduaxsistemajuegoajedrez.ejercicio1;

public class Pila {
    private static final int TAMANO_POR_DEFECTO = 10;
    private int[] elementos;
    private int tope;

    // Constructor con tamano determinado
    public Pila(int tamano) {
        if (tamano <= 0) {
            throw new IllegalArgumentException("El tamano debe ser mayor que 0");
        }
        this.elementos = new int[tamano];
        this.tope = -1;
    }

    // Constructor con tamano por defecto
    public Pila() {
        this(TAMANO_POR_DEFECTO);
    }

    // Metodo para obtener el tamano de la pila
    public int getTamano() {
        return elementos.length;
    }

    // Metodo para verificar si la pila esta vacia
    public boolean estaVacia() {
        return tope == -1;
    }

    // Metodo para obtener el elemento en la cima de la pila
    public int getCima() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila esta vacia");
        }
        return elementos[tope];
    }

    // Metodo para insertar un elemento en la cima de la pila
    public void push(int elemento) {
        if (tope == elementos.length - 1) {
            throw new IllegalStateException("La pila esta llena");
        }
        elementos[++tope] = elemento;
    }

    // Metodo para eliminar el elemento en la cima de la pila
    public int pop() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila esta vacia");
        }
        return elementos[tope--];
    }

    /***
     * Funcion que verifica si la pila esta vacia, si no lo esta, muestra por consola
     * uno por uno todos los elementos de la pila.
     */
    public void mostrar() {
        // Verifica si la pila esta vacia, si lo esta, no se pueden sacar elementos, lanza una excepcion.
        if(estaVacia()) {
            throw new IllegalArgumentException("!Error! La pila esta vacia, no se puede sacar mas elementos de ella.");
        }

        System.out.println("Mostrando los elementos de la pila");
        for (int posicion = tope; posicion >= 0; posicion--) {
            System.out.println(elementos[posicion]);
        }
    }
} 
