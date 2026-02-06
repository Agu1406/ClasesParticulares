package madrid.cesjuanpablosegundo.EX_T7;

public class BicicletaMTB extends Bicicleta {
    private String tipo;

    public BicicletaMTB(int velocidades, int pulgadas, int peso, String tamanio, boolean estado, int precio, String tipo) {
        super(velocidades, pulgadas, peso, tamanio, estado, precio);
        this.tipo = tipo;
    }

    public void hacerCaballito() {
        System.out.println("La MTB esta haciendo el caballito");
    }

    @Override
    public double reparar() {
        setVelocidades(getVelocidades() + 2);
        return 100 + (Math.random() * 100);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

