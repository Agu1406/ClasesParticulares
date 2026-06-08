package ev3.ut6_pooavanzadaestructuras.u02coleccionesestructuras.practicas.madriduaxsistemagrafoarista;
public class Arista_SIN_RESOLVER {
    private Nodo_SIN_RESOLVER v1;
    private Nodo_SIN_RESOLVER v2;
    private int peso;

    public Arista_SIN_RESOLVER(Nodo_SIN_RESOLVER v1, Nodo_SIN_RESOLVER v2, int peso) {
        this.v1 = v1;
        this.v2 = v2;
        this.peso = peso;
    }

    public Nodo_SIN_RESOLVER getV1() {
        return v1;
    }

    public Nodo_SIN_RESOLVER getV2() {
        return v2;
    }

    public int getPeso() {
        return peso;
    }
} 
