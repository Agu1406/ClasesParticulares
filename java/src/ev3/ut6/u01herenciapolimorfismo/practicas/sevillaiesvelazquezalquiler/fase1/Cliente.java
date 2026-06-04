package ev3.ut6.u01herenciapolimorfismo.practicas.sevillaiesvelazquezalquiler.fase1;

public class Cliente {
    private String nombre;
    private String direccion;
    private String localidad;
    private String codigoPostal;
    private String dni;

    public Cliente(String nombre, String direccion, String localidad, String codigoPostal, String dni) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.dni = dni;
    }

    public Cliente(Cliente otro) {
        this.nombre = otro.nombre;
        this.direccion = otro.direccion;
        this.localidad = otro.localidad;
        this.codigoPostal = otro.codigoPostal;
        this.dni = otro.dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}

