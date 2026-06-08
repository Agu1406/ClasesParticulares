package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundoext7;

public class BicicletaMTB_SIN_RESOLVER extends Bicicleta_SIN_RESOLVER {
    private String tipo;

    public BicicletaMTB_SIN_RESOLVER(int velocidades, int pulgadas, int peso, String tamanio, boolean estado, int precio, String tipo) {
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

