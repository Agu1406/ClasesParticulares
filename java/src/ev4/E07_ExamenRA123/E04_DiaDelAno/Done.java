package ev4.E07_ExamenRA123.E04_DiaDelAno;

import java.util.Scanner;

/**
 * Calcula el dia del anio (1-365/366) con validacion y bisiestos.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 24/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int dia = teclado.nextInt();
        int mes = teclado.nextInt();
        int anio = teclado.nextInt();

        if (!fechaValida(dia, mes, anio)) {
            System.out.println("Fecha no valida");
            return;
        }

        int diaDelAnio = 0;
        for (int m = 1; m < mes; m++) {
            diaDelAnio = diaDelAnio + diasDelMes(m, anio);
        }
        diaDelAnio = diaDelAnio + dia;

        System.out.println("Dia del anio: " + diaDelAnio);
    }

    public static boolean esBisiesto(int anio) {
        if (anio % 400 == 0) {
            return true;
        }
        if (anio % 100 == 0) {
            return false;
        }
        return anio % 4 == 0;
    }

    public static int diasDelMes(int mes, int anio) {
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            return 31;
        }
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return 30;
        }
        // febrero
        if (esBisiesto(anio)) {
            return 29;
        }
        return 28;
    }

    public static boolean fechaValida(int dia, int mes, int anio) {
        if (anio <= 0) {
            return false;
        }
        if (mes < 1 || mes > 12) {
            return false;
        }
        if (dia < 1) {
            return false;
        }
        return dia <= diasDelMes(mes, anio);
    }
}
