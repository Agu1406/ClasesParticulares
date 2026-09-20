package ev2.ut5_pooexcepcionesio.u01poobasica.practicas.internoconcesionario;

/**
 * <p><b>OBJETIVO:</b> Practica interna de clase — POO multi-clase (Coche + Concesionario):
 * alta, listado, busqueda por ID y venta. Usa encapsulacion, {@code static} contador,
 * {@code ArrayList} y {@code toString}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/09/2026
 * @see Coche
 * @see Concesionario
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class ConcesionarioMain {

    public static void main(String[] args) {
        System.out.println("\n¡Creando el concesionario de prueba!");
        Concesionario concesionarioDaniel = new Concesionario("Cochazos Daniel");

        System.out.println("\n¡Creando vehiculos de prueba!");
        Coche coche1 = new Coche("ABC123", "Ford", "Fiesta", 15000);
        Coche coche2 = new Coche("DFG579", "Seat", "Ibiza", 12000);
        Coche coche3 = new Coche("THJ532", "Peugeot", "206", 10000);

        System.out.println("\n¡Dando de alta vehiculos!");
        concesionarioDaniel.agregarCoche(coche1);
        concesionarioDaniel.agregarCoche(coche2);
        concesionarioDaniel.agregarCoche(coche3);

        System.out.println("\n¡Inventario!\n");
        concesionarioDaniel.mostrarInventario();

        System.out.println("\n¡Buscando por ID!");
        System.out.println(concesionarioDaniel.buscarCoche(coche1.getId()));
        System.out.println(concesionarioDaniel.buscarCoche("ID009"));

        concesionarioDaniel.venderCoche("ID009");
        concesionarioDaniel.venderCoche(coche1.getId());
        concesionarioDaniel.venderCoche(coche1.getId());

        System.out.println("\n¡Inventario final!\n");
        concesionarioDaniel.mostrarInventario();
    }
}
