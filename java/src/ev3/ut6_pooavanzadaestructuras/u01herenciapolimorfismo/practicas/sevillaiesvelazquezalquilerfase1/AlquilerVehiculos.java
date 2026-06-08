package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.sevillaiesvelazquezalquilerfase1;

/**
 * Sistema de alquiler de vehiculos - fase 1 (IES Velazquez).
 *
 * <p>Enunciado: {@code sevilla-iesvelazquez-alquileres-coches.pdf} (carpeta de la practica).</p>
 *
 * <p><b>Objetivo:</b> gestionar clientes, vehiculos y alquileres con arrays y clases asociadas.</p>
 *
 * <p>Para ello, el programa debe:</p>
 * <ul>
 *   <li>Registrar y buscar clientes y vehiculos.</li>
 *   <li>Crear alquileres y calcular importes segun el enunciado.</li>
 *   <li>Ofrecer menu de operaciones sobre las estructuras en memoria.</li>
 * </ul>
 *
 * <p>Utiliza POO, arrays y utilidades ({@link Utilidades}, {@link ES}). Fases 2 y 3 amplian el modelo.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class AlquilerVehiculos {
    private static final int MAX = 50;

    private Cliente[] clientes;
    private Vehiculo[] vehiculos;
    private Alquiler[] alquileres;
    private int numClientes;
    private int numVehiculos;
    private int numAlquileres;

    public AlquilerVehiculos() {
        clientes = new Cliente[MAX];
        vehiculos = new Vehiculo[MAX];
        alquileres = new Alquiler[MAX];
        numClientes = 0;
        numVehiculos = 0;
        numAlquileres = 0;
    }

    public Cliente getCliente(String dni) {
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i].getDni().equals(dni)) {
                return clientes[i];
            }
        }
        return null;
    }

    public void anadirCliente(Cliente cliente) {
        if (numClientes >= MAX) {
            System.out.println("No caben mas clientes");
            return;
        }
        if (getCliente(cliente.getDni()) != null) {
            System.out.println("Ya existe un cliente con ese DNI");
            return;
        }
        clientes[numClientes] = cliente;
        numClientes++;
    }

    public void borrarCliente(String dni) {
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i].getDni().equals(dni)) {
                for (int j = i; j < numClientes - 1; j++) {
                    clientes[j] = clientes[j + 1];
                }
                clientes[numClientes - 1] = null;
                numClientes--;
                System.out.println("Cliente borrado");
                return;
            }
        }
        System.out.println("No se ha encontrado el cliente");
    }

    public Vehiculo getVehiculo(String matricula) {
        for (int i = 0; i < numVehiculos; i++) {
            if (vehiculos[i].getMatricula().equals(matricula)) {
                return vehiculos[i];
            }
        }
        return null;
    }

    public void anadirVehiculo(Vehiculo vehiculo) {
        if (numVehiculos >= MAX) {
            System.out.println("No caben mas vehiculos");
            return;
        }
        if (getVehiculo(vehiculo.getMatricula()) != null) {
            System.out.println("Ya existe un vehiculo con esa matricula");
            return;
        }
        vehiculos[numVehiculos] = vehiculo;
        numVehiculos++;
    }

    public void borrarVehiculo(String matricula) {
        for (int i = 0; i < numVehiculos; i++) {
            if (vehiculos[i].getMatricula().equals(matricula)) {
                for (int j = i; j < numVehiculos - 1; j++) {
                    vehiculos[j] = vehiculos[j + 1];
                }
                vehiculos[numVehiculos - 1] = null;
                numVehiculos--;
                System.out.println("Vehiculo borrado");
                return;
            }
        }
        System.out.println("No se ha encontrado el vehiculo");
    }

    public void nuevoAlquiler(Cliente cliente, Vehiculo vehiculo) {
        if (numAlquileres >= MAX) {
            System.out.println("No caben mas alquileres");
            return;
        }
        if (!vehiculo.isDisponible()) {
            System.out.println("El vehiculo no esta disponible");
            return;
        }
        Alquiler alquiler = new Alquiler(cliente, vehiculo);
        alquileres[numAlquileres] = alquiler;
        numAlquileres++;
        System.out.println("Alquiler creado");
    }

    public void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo) {
        for (int i = 0; i < numAlquileres; i++) {
            if (alquileres[i].getCliente().equals(cliente) && alquileres[i].getVehiculo().equals(vehiculo)) {
                alquileres[i].cerrar();
                System.out.println("Alquiler cerrado. Precio: " + alquileres[i].precioAlquiler());
                return;
            }
        }
        System.out.println("No se ha encontrado el alquiler");
    }

    public void listarClientes() {
        for (int i = 0; i < numClientes; i++) {
            System.out.println(clientes[i]);
        }
    }

    public void listarVehiculos() {
        for (int i = 0; i < numVehiculos; i++) {
            System.out.println(vehiculos[i]);
        }
    }

    public void listarAlquileres() {
        for (int i = 0; i < numAlquileres; i++) {
            System.out.println(alquileres[i]);
        }
    }

    private static void mostrarMenu() {
        System.out.println("1. Anadir cliente");
        System.out.println("2. Borrar cliente");
        System.out.println("3. Listar clientes");
        System.out.println("4. Anadir vehiculo");
        System.out.println("5. Borrar vehiculo");
        System.out.println("6. Listar vehiculos");
        System.out.println("7. Abrir alquiler");
        System.out.println("8. Cerrar alquiler");
        System.out.println("9. Listar alquileres");
        System.out.println("0. Salir");
    }

    public static void main(String[] args) {
        AlquilerVehiculos app = new AlquilerVehiculos();
        int opcion;
        do {
            mostrarMenu();
            opcion = ES.leerEntero("Elija una opcion: ", 0);
            if (opcion == 1) {
                String dni = ES.leerCadena("DNI: ");
                if (!Utilidades.validarDni(dni)) {
                    System.out.println("DNI no valido");
                } else {
                    String nombre = ES.leerCadena("Nombre: ");
                    String direccion = ES.leerCadena("Direccion: ");
                    String localidad = ES.leerCadena("Localidad: ");
                    String cp = ES.leerCadena("Codigo postal: ");
                    if (!Utilidades.validarCodigoPostal(cp)) {
                        System.out.println("Codigo postal no valido");
                    } else {
                        Cliente cliente = new Cliente(nombre, direccion, localidad, cp, dni);
                        app.anadirCliente(cliente);
                    }
                }
            } else if (opcion == 2) {
                String dni = ES.leerCadena("DNI del cliente a borrar: ");
                app.borrarCliente(dni);
            } else if (opcion == 3) {
                app.listarClientes();
            } else if (opcion == 4) {
                String matricula = ES.leerCadena("Matricula: ");
                if (!Utilidades.validarMatricula(matricula)) {
                    System.out.println("Matricula no valida");
                } else {
                    String marca = ES.leerCadena("Marca: ");
                    String modelo = ES.leerCadena("Modelo: ");
                    int cilindrada = ES.leerEntero("Cilindrada: ", 0);
                    Vehiculo vehiculo = new Vehiculo(matricula, marca, modelo, cilindrada);
                    app.anadirVehiculo(vehiculo);
                }
            } else if (opcion == 5) {
                String matricula = ES.leerCadena("Matricula del vehiculo a borrar: ");
                app.borrarVehiculo(matricula);
            } else if (opcion == 6) {
                app.listarVehiculos();
            } else if (opcion == 7) {
                String dni = ES.leerCadena("DNI del cliente: ");
                Cliente cliente = app.getCliente(dni);
                if (cliente == null) {
                    System.out.println("Cliente no encontrado");
                } else {
                    String matricula = ES.leerCadena("Matricula del vehiculo: ");
                    Vehiculo vehiculo = app.getVehiculo(matricula);
                    if (vehiculo == null) {
                        System.out.println("Vehiculo no encontrado");
                    } else {
                        app.nuevoAlquiler(cliente, vehiculo);
                    }
                }
            } else if (opcion == 8) {
                String dni = ES.leerCadena("DNI del cliente: ");
                Cliente cliente = app.getCliente(dni);
                if (cliente == null) {
                    System.out.println("Cliente no encontrado");
                } else {
                    String matricula = ES.leerCadena("Matricula del vehiculo: ");
                    Vehiculo vehiculo = app.getVehiculo(matricula);
                    if (vehiculo == null) {
                        System.out.println("Vehiculo no encontrado");
                    } else {
                        app.cerrarAlquiler(cliente, vehiculo);
                    }
                }
            } else if (opcion == 9) {
                app.listarAlquileres();
            }
        } while (opcion != 0);
    }
}

