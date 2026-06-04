package ev3.ut6.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundoext7;

public class BicicletaPaseo_RESUELTO extends Bicicleta_SIN_RESOLVER {
    private String tipo;

    public BicicletaPaseo_RESUELTO(int velocidades, int pulgadas, int peso, String tamanio, boolean estado, int precio, String tipo) {
        super(velocidades, pulgadas, peso, tamanio, estado, precio);
        this.tipo = tipo;
    }

    public void ponerCesta() {
        System.out.println("Se ha colocado una cesta en la bici de paseo");
        setVelocidades(getVelocidades() - 1);
        int nuevoPeso = (int) (getPeso() * 1.25);
        setPeso(nuevoPeso);
    }

    @Override
    public double reparar() {
        int minimo = 50;
        int maximo = 100;
        return (int) (Math.random() * (maximo - minimo + 1)) + minimo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

