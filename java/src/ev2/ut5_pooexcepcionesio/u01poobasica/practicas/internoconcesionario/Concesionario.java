package ev2.ut5_pooexcepcionesio.u01poobasica.practicas.internoconcesionario;

import java.util.ArrayList;

/**
 * Concesionario con inventario {@code ArrayList} de {@link Coche} (alta, listado, busqueda, venta).
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/09/2026
 * @see Coche
 * @see ConcesionarioMain
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Concesionario {

    private String nombre;
    private ArrayList<Coche> inventario;

    public Concesionario(String nombre) {
        this.nombre = nombre;
        this.inventario = new ArrayList<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    /** Create: alta de coche en el inventario. */
    public void agregarCoche(Coche nuevoCoche) {
        inventario.add(nuevoCoche);
    }

    /** Read: listar inventario. */
    public void mostrarInventario() {
        for (Coche coche : inventario) {
            System.out.println(coche);
        }
    }

    /** Read: buscar por ID. */
    public Coche buscarCoche(String id) {
        for (Coche coche : inventario) {
            if (coche.getId().equals(id)) {
                return coche;
            }
        }
        return null;
    }

    /** Update: marcar coche como no disponible (vendido). */
    public void venderCoche(String id) {
        Coche cocheVendido = buscarCoche(id);
        if (cocheVendido == null) {
            System.out.println("¡Error! El coche con el ID " + id + " no existe.");
        } else if (!cocheVendido.isDisponible()) {
            System.out.println("Error! El coche con el ID " + id + " no esta disponible.");
        } else {
            cocheVendido.setDisponible();
            System.out.println("¡El coche con el ID " + id + " ha sido vendido!");
        }
    }
}
