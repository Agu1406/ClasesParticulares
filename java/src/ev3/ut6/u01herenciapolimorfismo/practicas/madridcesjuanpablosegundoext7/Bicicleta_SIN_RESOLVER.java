package ev3.ut6.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundoext7;

public abstract class Bicicleta_SIN_RESOLVER {
    private int velocidades;
    private int pulgadas;
    private int peso;
    private String tamanio;
    private boolean estado;
    private int precio;

    public Bicicleta_SIN_RESOLVER() {
    }

    public Bicicleta_SIN_RESOLVER(int velocidades, int pulgadas, int peso, String tamanio, boolean estado, int precio) {
        this.velocidades = velocidades;
        this.pulgadas = pulgadas;
        this.peso = peso;
        this.tamanio = tamanio;
        this.estado = estado;
        this.precio = precio;
    }

    public void mostrarDatos() {
        System.out.println("Bicicleta_SIN_RESOLVER");
        System.out.println("Velocidades: " + velocidades);
        System.out.println("Pulgadas: " + pulgadas);
        System.out.println("Peso: " + peso);
        System.out.println("Tamanio: " + tamanio);
        System.out.println("Estado: " + estado);
        System.out.println("Precio: " + precio);
    }

    public abstract double reparar();

    public int getVelocidades() {
        return velocidades;
    }

    public void setVelocidades(int velocidades) {
        this.velocidades = velocidades;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}

