package ev2.ut4.poobasico.objetos;

public class Inventario {
    public String objeto;
    public int cantidad;
    public double pesoTotal;

    public Inventario(String objeto, int cantidad, double pesoTotal) {
        this.objeto = objeto;
        this.cantidad = cantidad;
        this.pesoTotal = pesoTotal;
    }
}
