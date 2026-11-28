package ev4.E09_ExamenRA246.E04_NominasEmpresa;

import java.util.Locale;
import java.util.Scanner;

/**
 * <p>Enunciado: {@code enunciado.md}.</p>
 *
 * <p><b>OBJETIVO:</b> {@code Empleado} abstracta y subclases fijo / por horas /
 * comercial; array polimorfico, total y mayor salario.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> fijo = base; por horas = 160 a precio y el resto a 1,5;
 * comercial = base + 5 % ventas; empate en mayor → el primero.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 15/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    public static void main(String[] args) {
        /* --- Variables al principio del metodo --- */
        Scanner teclado = new Scanner(System.in);
        Empleado[] empleados;
        Empleado mayor, actual;
        int n, indiceEmpleado, horas;
        String tipo, nombre;
        double total, salario, salarioMayor, sueldoBase, precioHora, ventas;
        teclado.useLocale(Locale.US);

        n = teclado.nextInt();
        empleados = new Empleado[n];

        for (indiceEmpleado = 0; indiceEmpleado < n; indiceEmpleado++) {
            tipo = teclado.next();
            nombre = teclado.next();
            if (tipo.equals("F")) {
                sueldoBase = teclado.nextDouble();
                empleados[indiceEmpleado] = new EmpleadoFijo(nombre, sueldoBase);
            } else if (tipo.equals("H")) {
                horas = teclado.nextInt();
                precioHora = teclado.nextDouble();
                empleados[indiceEmpleado] = new EmpleadoPorHoras(nombre, horas, precioHora);
            } else {
                sueldoBase = teclado.nextDouble();
                ventas = teclado.nextDouble();
                empleados[indiceEmpleado] = new EmpleadoComercial(nombre, sueldoBase, ventas);
            }
        }

        total = 0;
        mayor = empleados[0];
        salarioMayor = mayor.salario();

        for (indiceEmpleado = 0; indiceEmpleado < empleados.length; indiceEmpleado++) {
            actual = empleados[indiceEmpleado];
            salario = actual.salario();
            System.out.printf(Locale.US, "%s (%s): %.2f €%n",
                    actual.getNombre(), actual.tipo(), salario);
            total = total + salario;

            // Empate: nos quedamos con el primero
            if (salario > salarioMayor) {
                mayor = actual;
                salarioMayor = salario;
            }
        }

        System.out.printf(Locale.US, "Total: %.2f €%n", total);
        System.out.println("Mayor salario: " + mayor.getNombre());
        teclado.close();
    }
}

abstract class Empleado {
    private String nombre;

    Empleado(String nombre) {
        this.nombre = nombre;
    }

    String getNombre() {
        return nombre;
    }

    abstract double salario();

    abstract String tipo();
}

class EmpleadoFijo extends Empleado {
    private double sueldoBase;

    EmpleadoFijo(String nombre, double sueldoBase) {
        super(nombre);
        this.sueldoBase = sueldoBase;
    }

    @Override
    double salario() {
        return sueldoBase;
    }

    @Override
    String tipo() {
        return "fijo";
    }
}

class EmpleadoPorHoras extends Empleado {
    private int horas;
    private double precioHora;

    EmpleadoPorHoras(String nombre, int horas, double precioHora) {
        super(nombre);
        this.horas = horas;
        this.precioHora = precioHora;
    }

    @Override
    double salario() {
        int horasNormales, horasExtra;
        double resultado;

        /*
         * Hasta 160 horas al precio normal.
         * Lo que pase de 160, a 1,5 veces el precio.
         */
        if (horas <= 160) {
            horasNormales = horas;
            horasExtra = 0;
        } else {
            horasNormales = 160;
            horasExtra = horas - 160;
        }
        resultado = horasNormales * precioHora + horasExtra * precioHora * 1.5;
        return resultado;
    }

    @Override
    String tipo() {
        return "por horas";
    }
}

class EmpleadoComercial extends Empleado {
    private double sueldoBase;
    private double ventas;

    EmpleadoComercial(String nombre, double sueldoBase, double ventas) {
        super(nombre);
        this.sueldoBase = sueldoBase;
        this.ventas = ventas;
    }

    @Override
    double salario() {
        // Base + 5 % de las ventas
        return sueldoBase + ventas * 0.05;
    }

    @Override
    String tipo() {
        return "comercial";
    }
}
