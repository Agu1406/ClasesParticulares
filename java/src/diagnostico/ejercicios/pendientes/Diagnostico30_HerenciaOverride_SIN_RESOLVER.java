package diagnostico.ejercicios.pendientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Override de metodos en jerarquia de empleados
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa con empleados: clase abstracta Empleado y subclases Vendedor y Tecnico.</li>
 * <li>Cada subclase calcula su salario de forma distinta (override de calcularSalario).</li>
 * <li>En el main, lee datos de un vendedor y un tecnico con Scanner teclado.</li>
 * <li>Crea los objetos, guardalos en una lista de Empleado e imprime nombre y salario de cada uno.</li>
 * </ul>
 *
 * <p>Diagnostico 30 — EV3 · ut6_pooavanzadaestructuras · RA7.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico30_HerenciaOverride_SIN_RESOLVER {

    // TODO: Empleado (nombre, salarioBase) y subclases Vendedor (+comision) y Tecnico (+plus)

    static abstract class Empleado {
        // TODO
    }

    static class Vendedor extends Empleado {
        // TODO
    }

    static class Tecnico extends Empleado {
        // TODO
    }
    public static void main(String[] args) {
        Scanner teclado;
        String nombreVendedor;
        double baseVendedor;
        double comision;
        String nombreTecnico;
        double baseTecnico;
        double plus;
        List<Empleado> equipo;
        Empleado empleado;
        teclado = new Scanner(System.in);
        System.out.print("Nombre vendedor: ");
        nombreVendedor = teclado.nextLine();
        System.out.print("Salario base vendedor: ");
        baseVendedor = teclado.nextDouble();
        System.out.print("Comision vendedor: ");
        comision = teclado.nextDouble();
        System.out.print("Nombre tecnico: ");
        nombreTecnico = teclado.nextLine();
        System.out.print("Salario base tecnico: ");
        baseTecnico = teclado.nextDouble();
        System.out.print("Plus tecnico: ");
        plus = teclado.nextDouble();
        // TODO: crear empleados y mostrar salarios
        equipo = new ArrayList<>();
        equipo.add(new Vendedor(nombreVendedor, baseVendedor, comision));
        equipo.add(new Tecnico(nombreTecnico, baseTecnico, plus));
        for (Empleado miembro : equipo) {
            System.out.println(miembro.nombre + ": " + miembro.calcularSalario());
        }
        teclado.close();
    }
}
