package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridiesventurarodriguezgestionempresarial;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Menu de gestion de empleados — UMBRELLA CORP (IES Ventura Rodriguez, Madrid).
 *
 * <p>Enunciado: {@code madrid-iesventurarodriguez-gestion-empresarial.md}.
 * Solucion de referencia en {@code MainEmpleado_RESUELTO.java}.</p>
 *
 * @author Paula Diaz (codigo original)
 * @author Agustin. A. Marquez. Pina (adaptacion al repo)
 * @since 03/06/2026
 */
public class MainEmpleado_SIN_RESOLVER {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int opcionMenu;
		ArrayList<Persona_SIN_RESOLVER> empleados = new ArrayList<>();

		String[] primerosEmpleados = {
				"11111111A Aitor Tilla Informatica 60000 01/03/2022 15/04/1985",
				"22222222B Ester Colero Logistica 34000 15/05/2021 22/08/1980",
				"33333333C Andres Trozado Informatica 56000 10/06/2020 03/11/1982",
				"44444444D Armando Ruido Logistica 39000 20/07/2019 09/02/1979",
				"55555555E Dolores Fuertes Comercial 45000 25/08/2018 17/05/1990",
				"66666666F Enrique Cide Comercial 48000 30/09/2022 28/07/1988",
				"77777777F Estela Gartija Logistica 52000 05/10/2021 04/12/1984",
				"88888888G Josechu Leton Informatica 49000 11/11/2020 15/03/1987",
				"99999999H Lola Mento Informatica 51000 16/12/2019 06/01/1983"
		};

		try {
			cargarDatosIniciales(empleados, primerosEmpleados);
		} catch (GestionEmpresarialException e) {
			System.out.println("Error al cargar datos iniciales: " + e.getMessage());
			return;
		}

		do {
			mostrarMenu();
			opcionMenu = pedirOperacionMenu(teclado);
			switch (opcionMenu) {
				case 1:
					mostrarTodosLosEmpleados(empleados);
					break;
				case 2:
					darDeAltaEmpleado(empleados, teclado);
					break;
				case 3:
					buscarEmpleadoPorCodigo(empleados, teclado);
					break;
				case 4:
					mostrarEmpleadosPorDepartamento(empleados, teclado);
					break;
				case 5:
					borrarEmpleadoPorCodigo(empleados, teclado);
					break;
				case 6:
					subirSueldoEmpleado(empleados, teclado);
					break;
				case 7:
					mostrarSalarioActualEmpleado(empleados, teclado);
					break;
				case 8:
					System.out.println("Hasta luego. Gracias por usar nuestro programa.");
					break;
				default:
					System.out.println("Opcion no valida. Intentalo de nuevo.");
					break;
			}
		} while (opcionMenu != 8);
	}

	public static void cargarDatosIniciales(ArrayList<Persona_SIN_RESOLVER> empleados, String[] primerosEmpleados)
			throws GestionEmpresarialException {
		// TODO: parsear cada linea y crear Empleado_SIN_RESOLVER
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (String datosEmpleado : primerosEmpleados) {
			String[] partes = datosEmpleado.split(" ");
			String dni = partes[0];
			String nombre = partes[1];
			String apellido = partes[2];
			String departamento = partes[3];
			float sueldo = Float.parseFloat(partes[4]);
			LocalDate fechaContrato = LocalDate.parse(partes[5], formatter);
			LocalDate fechaNacimiento = LocalDate.parse(partes[6], formatter);
			empleados.add(new Empleado_SIN_RESOLVER(dni, nombre, apellido, departamento, sueldo, fechaContrato,
					fechaNacimiento));
		}
	}

	private static void mostrarMenu() {
		System.out.println("Elige una opcion del menu:");
		System.out.println("1- Mostrar todos los empleados.");
		System.out.println("2- Dar de alta un nuevo empleado.");
		System.out.println("3- Buscar un empleado por su codigo.");
		System.out.println("4- Buscar todos los empleados de un departamento.");
		System.out.println("5- Borrar un empleado por su codigo.");
		System.out.println("6- Subir el sueldo a un empleado.");
		System.out.println("7- Mostrar el salario del mes actual de un empleado.");
		System.out.println("8- Salir del programa.");
	}

	public static int pedirOperacionMenu(Scanner teclado) {
		int opcionMenu = 0;
		do {
			try {
				opcionMenu = teclado.nextInt();
				if (opcionMenu < 1 || opcionMenu > 8) {
					System.out.println("Opcion no valida. Elige una opcion entre 1 y 8.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Error. Debes ingresar un numero. Intentalo de nuevo.");
				teclado.next();
			}
		} while (opcionMenu < 1 || opcionMenu > 8);
		return opcionMenu;
	}

	public static void mostrarTodosLosEmpleados(ArrayList<Persona_SIN_RESOLVER> empleados) {
		// TODO: listar descripcion corta y nomina mensual total (polimorfismo con Contratable)
	}

	public static void darDeAltaEmpleado(ArrayList<Persona_SIN_RESOLVER> empleados, Scanner teclado) {
		// TODO: pedir datos y anadir Empleado_SIN_RESOLVER; capturar GestionEmpresarialException
	}

	public static void buscarEmpleadoPorCodigo(ArrayList<Persona_SIN_RESOLVER> empleados, Scanner teclado) {
		// TODO
	}

	public static void mostrarEmpleadosPorDepartamento(ArrayList<Persona_SIN_RESOLVER> empleados, Scanner teclado) {
		// TODO
	}

	public static void borrarEmpleadoPorCodigo(ArrayList<Persona_SIN_RESOLVER> empleados, Scanner teclado) {
		// TODO
	}

	public static void subirSueldoEmpleado(ArrayList<Persona_SIN_RESOLVER> empleados, Scanner teclado) {
		// TODO: buscar por DNI y llamar a subirSalario de Contratable
	}

	public static void mostrarSalarioActualEmpleado(ArrayList<Persona_SIN_RESOLVER> empleados, Scanner teclado) {
		// TODO: buscar por codigo y mostrar calcularSueldoMensual()
	}
}
