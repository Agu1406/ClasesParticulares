package ev1.ut2_controlflujometodos.u04metodos.practicas.madridiesarquitectoventurarodriguezmetodos;

import java.util.Scanner;

/**
 * UT3 - Ejercicios iniciales con funciones (IES Arquitecto Ventura Rodriguez).
 *
 * <p>Enunciado: {@code madrid-iesarquitectoventurarodriguez-ejercicios-funciones.pdf} (carpeta de la practica).</p>
 *
 * <p><b>Objetivo:</b> practicar metodos estaticos con distintos parametros, retornos y lectura por teclado.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class EjerciciosInicialesFunciones_RESUELTO {

    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    public static boolean esImpar(int numero) {
        return numero % 2 != 0;
    }

    public static int mayor(int primero, int segundo) {
        return primero >= segundo ? primero : segundo;
    }

    public static int menor(int primero, int segundo) {
        return primero <= segundo ? primero : segundo;
    }

    public static int aleatorioEntre(int numeroInicial, int numeroFinal) {
        int rango;
        rango = numeroFinal - numeroInicial + 1;
        return (int) (Math.random() * rango) + numeroInicial;
    }

    public static void mostrarTiempoDesdeSegundos(int segundosTotales) {
        int segundosRestantes;
        int dias;
        int horas;
        int minutos;
        int segundos;
        final int segundosPorMinuto;
        final int segundosPorHora;
        final int segundosPorDia;
        segundosPorMinuto = 60;
        segundosPorHora = 3600;
        segundosPorDia = 86400;
        segundosRestantes = segundosTotales;
        dias = segundosRestantes / segundosPorDia;
        segundosRestantes = segundosRestantes % segundosPorDia;
        horas = segundosRestantes / segundosPorHora;
        segundosRestantes = segundosRestantes % segundosPorHora;
        minutos = segundosRestantes / segundosPorMinuto;
        segundos = segundosRestantes % segundosPorMinuto;
        System.out.println(dias + " dias, " + horas + " horas, " + minutos + " minutos y " + segundos + " segundos");
    }

    public static void mostrarTablaMultiplicar(int numero) {
        int multiplicador;
        System.out.println("Tabla del " + numero + ":");
        for (multiplicador = 1; multiplicador <= 10; multiplicador++) {
            System.out.println(numero + " x " + multiplicador + " = " + (numero * multiplicador));
        }
    }

    public static float dividir(float dividendo, Scanner teclado) {
        float divisor;
        do {
            System.out.print("Introduce el divisor (distinto de 0): ");
            divisor = teclado.nextFloat();
        } while (divisor == 0);
        return dividendo / divisor;
    }

    public static long factorial(int numero) {
        long resultado;
        int factor;
        if (numero < 0) {
            return -1;
        }
        resultado = 1;
        for (factor = 2; factor <= numero; factor++) {
            resultado *= factor;
        }
        return resultado;
    }

    public static long potencia(int base, int exponente) {
        long resultado;
        int contador;
        if (exponente < 0) {
            return -1;
        }
        resultado = 1;
        for (contador = 0; contador < exponente; contador++) {
            resultado *= base;
        }
        return resultado;
    }

    public static void calculadoraAvanzada(Scanner teclado) {
        int opcion;
        double operandoUno;
        double operandoDos;
        int enteroUno;
        int enteroDos;
        float resultadoDivision;
        do {
            System.out.println();
            System.out.println("--- Calculadora avanzada ---");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Factorial");
            System.out.println("6. Potencia");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Primer numero: ");
                    operandoUno = teclado.nextDouble();
                    System.out.print("Segundo numero: ");
                    operandoDos = teclado.nextDouble();
                    System.out.println("Resultado: " + (operandoUno + operandoDos));
                    break;
                case 2:
                    System.out.print("Primer numero: ");
                    operandoUno = teclado.nextDouble();
                    System.out.print("Segundo numero: ");
                    operandoDos = teclado.nextDouble();
                    System.out.println("Resultado: " + (operandoUno - operandoDos));
                    break;
                case 3:
                    System.out.print("Primer numero: ");
                    operandoUno = teclado.nextDouble();
                    System.out.print("Segundo numero: ");
                    operandoDos = teclado.nextDouble();
                    System.out.println("Resultado: " + (operandoUno * operandoDos));
                    break;
                case 4:
                    System.out.print("Dividendo: ");
                    operandoUno = teclado.nextDouble();
                    resultadoDivision = dividir((float) operandoUno, teclado);
                    System.out.println("Resultado: " + resultadoDivision);
                    break;
                case 5:
                    System.out.print("Numero para factorial: ");
                    enteroUno = teclado.nextInt();
                    System.out.println("Factorial: " + factorial(enteroUno));
                    break;
                case 6:
                    System.out.print("Base: ");
                    enteroUno = teclado.nextInt();
                    System.out.print("Exponente: ");
                    enteroDos = teclado.nextInt();
                    System.out.println("Potencia: " + potencia(enteroUno, enteroDos));
                    break;
                case 0:
                    System.out.println("Saliendo de la calculadora.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    public static boolean esBisiesto(int año) {
        if (año % 400 == 0) {
            return true;
        }
        if (año % 100 == 0) {
            return false;
        }
        return año % 4 == 0;
    }

    public static int diasDelMes(int mes, int año) {
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return esBisiesto(año) ? 29 : 28;
            default:
                return 0;
        }
    }

    public static boolean esFechaCorrecta(int dia, int mes, int año) {
        int maximoDias;
        if (mes < 1 || mes > 12 || año <= 0 || dia < 1) {
            return false;
        }
        maximoDias = diasDelMes(mes, año);
        return dia <= maximoDias;
    }

    private static int diasDesdeInicio(int dia, int mes, int año) {
        int total;
        int mesActual;
        int añoActual;
        total = 0;
        for (añoActual = 1; añoActual < año; añoActual++) {
            if (esBisiesto(añoActual)) {
                total += 366;
            } else {
                total += 365;
            }
        }
        for (mesActual = 1; mesActual < mes; mesActual++) {
            total += diasDelMes(mesActual, año);
        }
        total += dia;
        return total;
    }

    public static int diasEntreFechas(int diaUno, int mesUno, int añoUno,
                                      int diaDos, int mesDos, int añoDos) {
        int diasFechaUno;
        int diasFechaDos;
        if (!esFechaCorrecta(diaUno, mesUno, añoUno) || !esFechaCorrecta(diaDos, mesDos, añoDos)) {
            return -1;
        }
        diasFechaUno = diasDesdeInicio(diaUno, mesUno, añoUno);
        diasFechaDos = diasDesdeInicio(diaDos, mesDos, añoDos);
        if (diasFechaUno >= diasFechaDos) {
            return diasFechaUno - diasFechaDos;
        }
        return diasFechaDos - diasFechaUno;
    }

    public static void main(String[] args) {
        Scanner teclado;
        int contador;
        int valorAleatorio;
        teclado = new Scanner(System.in);

        System.out.println("=== UT3 Ejercicios iniciales con funciones ===\n");

        System.out.println("1. esPar / esImpar:");
        System.out.println("   esPar(8) = " + esPar(8));
        System.out.println("   esImpar(7) = " + esImpar(7));
        System.out.println();

        System.out.println("2. mayor / menor:");
        System.out.println("   mayor(12, 5) = " + mayor(12, 5));
        System.out.println("   menor(12, 5) = " + menor(12, 5));
        System.out.println();

        System.out.println("3. aleatorioEntre (100 valores entre 1 y 6):");
        for (contador = 0; contador < 100; contador++) {
            valorAleatorio = aleatorioEntre(1, 6);
            System.out.print(valorAleatorio + " ");
            if ((contador + 1) % 20 == 0) {
                System.out.println();
            }
        }
        System.out.println();

        System.out.println("4. mostrarTiempoDesdeSegundos(90090):");
        mostrarTiempoDesdeSegundos(90090);
        System.out.println();

        System.out.println("5. mostrarTablaMultiplicar(3):");
        mostrarTablaMultiplicar(3);
        System.out.println();

        System.out.println("6. Tablas del 1 al 10:");
        for (contador = 1; contador <= 10; contador++) {
            mostrarTablaMultiplicar(contador);
            System.out.println();
        }

        System.out.println("7. esBisiesto:");
        System.out.println("   2024 -> " + esBisiesto(2024));
        System.out.println("   1900 -> " + esBisiesto(1900));
        System.out.println("   2000 -> " + esBisiesto(2000));
        System.out.println();

        System.out.println("8. diasDelMes:");
        System.out.println("   Febrero 2024 -> " + diasDelMes(2, 2024));
        System.out.println("   Abril 2025 -> " + diasDelMes(4, 2025));
        System.out.println();

        System.out.println("9. esFechaCorrecta:");
        System.out.println("   29/2/2024 -> " + esFechaCorrecta(29, 2, 2024));
        System.out.println("   29/2/2023 -> " + esFechaCorrecta(29, 2, 2023));
        System.out.println();

        System.out.println("10. diasEntreFechas:");
        System.out.println("   1/1/2024 a 31/12/2024 -> " + diasEntreFechas(1, 1, 2024, 31, 12, 2024));
        System.out.println();

        System.out.println("11. dividir (interactivo, descomentar para probar):");
        System.out.println("   // float cociente = dividir(10f, teclado);");
        System.out.println();

        System.out.println("12. calculadoraAvanzada (interactivo, descomentar para probar):");
        System.out.println("   // calculadoraAvanzada(teclado);");

        teclado.close();
        System.out.println("\n=== Fin de pruebas automaticas ===");
    }
}
