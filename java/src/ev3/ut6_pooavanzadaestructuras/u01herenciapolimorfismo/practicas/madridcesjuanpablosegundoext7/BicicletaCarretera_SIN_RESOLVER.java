package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundoext7;

public class BicicletaCarretera_SIN_RESOLVER extends Bicicleta_SIN_RESOLVER {
    private String tipo;

    public BicicletaCarretera_SIN_RESOLVER(int velocidades, int pulgadas, int peso, String tamanio, boolean estado, int precio, String tipo) {
        super(velocidades, pulgadas, peso, tamanio, estado, precio);
        this.tipo = tipo;
    }

    public void ponerModoSprint() {
        System.out.println("La bici de carretera entra en modo sprint");
        setVelocidades(getVelocidades() + 1);
        int nuevoPeso = (int) (getPeso() * 0.75);
        setPeso(nuevoPeso);
    }

    @Override
    public double reparar() {
        setVelocidades(getVelocidades() + 1);
        setPulgadas(getPulgadas() + 2);
        int minimo = 50;
        int maximo = 100;
        int coste = (int) (Math.random() * (maximo - minimo + 1)) + minimo;
        return coste;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

