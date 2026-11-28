package ev1.ut2_controlflujometodos.u05repaso.teoria;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p><b>OBJETIVO:</b> repaso rapido UT2 con menu canonico
 * ({@code boolean continuar} + {@code do-while} + {@code switch}).</p>
 *
 * <br>
 *
 * <p><b>SOLUCION:</b> un metodo por tema (tarifas, String/case, parking, switch,
 * tres bucles, break/continue, Scanner, printf, digitos, metodos, arrays).
 * Salir pone {@code continuar = false}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U10_RepasoIntro {

    public static void main(String[] args) {
        /* --- Variables al principio del metodo --- */
        Scanner teclado = new Scanner(System.in);
        boolean continuar;
        int opcion;
        continuar = true;

        do {
            System.out.println(""
                    + "\n¡Opciones del menu!\n"
                    + "[1] - If/else y tarifas cine (T1).\n"
                    + "[2] - String: equals, ignoreCase, upper/lower.\n"
                    + "[3] - Parking en centimos (T1).\n"
                    + "[4] - Switch y bisiesto (T2).\n"
                    + "[5] - Tres bucles: while, do-while, for.\n"
                    + "[6] - Break y continue.\n"
                    + "[7] - Validar Scanner (T3).\n"
                    + "[8] - Printf y duracion (T3).\n"
                    + "[9] - Digitos con while (T4).\n"
                    + "[10] - Metodos: void, return, parametros.\n"
                    + "[11] - Arrays heladas (T7).\n"
                    + "[0] - Salir.\n");
            System.out.print("Opcion: ");

            if (!teclado.hasNextInt()) {
                System.out.println("Escribe un numero de opcion.");
                teclado.next();
                opcion = -1;
            } else {
                opcion = teclado.nextInt();
            }

            switch (opcion) {
                case 1:
                    repasoIfElseYTarifas();
                    break;
                case 2:
                    repasoStringEqualsYCase();
                    break;
                case 3:
                    repasoParkingCentimos();
                    break;
                case 4:
                    repasoSwitchYBisiesto();
                    break;
                case 5:
                    repasoTresBucles();
                    break;
                case 6:
                    repasoBreakContinue();
                    break;
                case 7:
                    repasoValidarScanner(teclado);
                    break;
                case 8:
                    repasoPrintfYDuracion();
                    break;
                case 9:
                    repasoDigitosWhile();
                    break;
                case 10:
                    repasoMetodosFirma();
                    break;
                case 11:
                    repasoArraysHeladas();
                    break;
                case 0:
                    System.out.println("Listo. Suerte en el examen.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (continuar);

        teclado.close();
    }

    /**
     * T1: if/else con rangos de edad (sin String todavia).
     */
    public static void repasoIfElseYTarifas() {
        int edad;
        int precio;

        System.out.println("--- 1. If/else tarifas ---");
        edad = 20;
        if (edad < 0 || edad > 120) {
            precio = -1;
        } else if (edad < 4) {
            precio = 0;
        } else if (edad <= 13) {
            precio = 5;
        } else if (edad >= 65) {
            precio = 4;
        } else {
            precio = 8;
        }
        System.out.println("Edad " + edad + " sin carne -> " + precio);
        System.out.println("TRUCO: ordena de lo mas concreto a lo general.");
        System.out.println("TRUCO: mayores con >= 65 (no solo > 65).");
    }

    /**
     * U2A1 / T1: == vs equals / equalsIgnoreCase; toUpperCase / toLowerCase.
     */
    public static void repasoStringEqualsYCase() {
        String literal;
        String leido;
        String minusculas;
        String mayusculas;

        System.out.println("--- 2. String equals y case ---");
        literal = "XOVE";
        leido = new String("XOVE");
        minusculas = literal.toLowerCase();
        mayusculas = "xove".toUpperCase();

        System.out.println("literal == leido -> " + (literal == leido));
        System.out.println("literal.equals(leido) -> " + literal.equals(leido));
        System.out.println("equalsIgnoreCase(\"xove\") -> "
                + literal.equalsIgnoreCase("xove"));
        System.out.println("toLowerCase -> " + minusculas);
        System.out.println("toUpperCase(\"xove\") -> " + mayusculas);
        System.out.println("TRUCO: Scanner crea objeto nuevo -> no uses ==.");
        System.out.println("TRUCO: carnés -> equalsIgnoreCase, o upper/lower + equals.");
    }

    /**
     * T1: parkingFee en centimos.
     */
    public static void repasoParkingCentimos() {
        int minutos;
        boolean residente;
        int fee;
        int extraHours;

        System.out.println("--- 3. Parking centimos ---");
        minutos = 61;
        residente = false;

        if (minutos < 0 || minutos > 1440) {
            fee = -1;
        } else if (minutos <= 15) {
            fee = 0;
        } else if (minutos <= 60) {
            fee = 150;
        } else {
            extraHours = (minutos - 60 + 59) / 60;
            fee = 150 + 100 * extraHours;
        }
        if (fee > 1200) {
            fee = 1200;
        }
        if (residente && fee >= 0) {
            fee = fee / 2;
        }

        System.out.println("61 min no residente -> " + fee + " (250).");
        System.out.println("TRUCO: (min - 60 + 59) / 60 redondea horas arriba.");
        System.out.println("TRUCO: tope 1200 ANTES de la mitad del residente.");
    }

    /**
     * T2: switch clasico vs expresion; bisiesto.
     */
    public static void repasoSwitchYBisiesto() {
        int mes;
        int anio;
        int diasClasico;
        int diasExpresion;
        boolean bisiesto;

        System.out.println("--- 4. Switch y bisiesto ---");
        mes = 2;
        anio = 2024;
        bisiesto = anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0);

        diasClasico = 0;
        switch (mes) {
            case 2:
                if (bisiesto) {
                    diasClasico = 29;
                } else {
                    diasClasico = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diasClasico = 30;
                break;
            default:
                diasClasico = 31;
        }

        diasExpresion = switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> bisiesto ? 29 : 28;
            default -> -1;
        };

        System.out.println("Clasico feb/" + anio + " -> " + diasClasico);
        System.out.println("Expresion feb/" + anio + " -> " + diasExpresion);
        System.out.println("TRUCO clasico: sin break caes al case siguiente.");
        System.out.println("TRUCO expresion: default -> -1 si el mes no vale.");
    }

    /**
     * U2A4 / U2A5: while, do-while y for.
     */
    public static void repasoTresBucles() {
        int posicion;
        int n;

        System.out.println("--- 5. Tres bucles ---");

        System.out.print("while (0..2): ");
        posicion = 0;
        while (posicion < 3) {
            System.out.print(posicion + " ");
            posicion++;
        }
        System.out.println("| TRUCO: 0 veces si la condicion ya es falsa.");

        System.out.print("do-while (menu): ");
        n = 0;
        do {
            System.out.print("vuelta ");
            n++;
        } while (n < 1);
        System.out.println("| TRUCO: siempre 1 vez; ideal para menus.");

        System.out.print("for (indice): ");
        for (posicion = 0; posicion < 3; posicion++) {
            System.out.print(posicion + " ");
        }
        System.out.println("| TRUCO: init + condicion + paso en una linea.");
    }

    /**
     * U2A5: break vs continue.
     */
    public static void repasoBreakContinue() {
        int posicion;

        System.out.println("--- 6. Break y continue ---");
        System.out.print("continue (salta el 2): ");
        for (posicion = 0; posicion < 5; posicion++) {
            if (posicion == 2) {
                continue;
            }
            System.out.print(posicion + " ");
        }
        System.out.println();

        System.out.print("break (para en el 2): ");
        for (posicion = 0; posicion < 5; posicion++) {
            if (posicion == 2) {
                break;
            }
            System.out.print(posicion + " ");
        }
        System.out.println();
        System.out.println("TRUCO: continue = saltar esta vuelta; break = salir del bucle.");
    }

    /**
     * T3: hasNext* y nextLine tras numero.
     */
    public static void repasoValidarScanner(Scanner teclado) {
        int numero;
        String texto;

        System.out.println("--- 7. Validar Scanner ---");
        System.out.println("TRUCO: if (!hasNextInt()) { mensaje; return; }");
        System.out.print("Escribe un entero de prueba: ");
        if (!teclado.hasNextInt()) {
            System.out.println("No era un entero (asi evitas la excepcion).");
            teclado.next();
            return;
        }
        numero = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Ahora una linea de texto: ");
        texto = teclado.nextLine();
        System.out.println("Leido: " + numero + " | \"" + texto + "\"");
        System.out.println("TRUCO: tras nextInt() haz nextLine() antes del destino.");
    }

    /**
     * T3: printf y durationText.
     */
    public static void repasoPrintfYDuracion() {
        int minutos;
        String texto;

        System.out.println("--- 8. Printf y duracion ---");
        minutos = 125;
        texto = String.format("%d h %02d min", minutos / 60, minutos % 60);
        System.out.println(minutos + " -> " + texto);
        System.out.printf("printf demo: %s vale %d%n", "edad", 20);
        System.out.println("TRUCO: %02d pone cero (05); %d no.");
        System.out.println("TRUCO: %n = salto de linea portable.");
    }

    /**
     * T4: digitos con % 10 y / 10.
     */
    public static void repasoDigitosWhile() {
        long codigo;
        long resto;
        int suma;
        int posicion;
        int digito;

        System.out.println("--- 9. Digitos con while ---");
        codigo = 185L;
        suma = 0;
        posicion = 0;
        resto = codigo;
        while (resto > 0) {
            digito = (int) (resto % 10);
            if (posicion % 2 == 0) {
                suma = suma + digito * 2;
            } else {
                suma = suma + digito;
            }
            System.out.println("  pos " + posicion + " digito " + digito);
            resto = resto / 10;
            posicion++;
        }
        System.out.println("Suma=" + suma + " multiplo de 10? " + (suma % 10 == 0));
        System.out.println("TRUCO: % 10 ultimo digito; / 10 lo quita.");
    }

    /**
     * Metodos: void vs return y parametros.
     */
    public static void repasoMetodosFirma() {
        int resultado;

        System.out.println("--- 10. Metodos ---");
        System.out.println("void -> hace algo (imprimir); no devuelve valor.");
        System.out.println("int/boolean/String -> return valor; lo guardas o usas.");
        mostrarSaludo("alumna");
        resultado = duplicar(7);
        System.out.println("duplicar(7) -> " + resultado);
        System.out.println("TRUCO: parametros = datos de entrada; return = salida.");
    }

    /**
     * Demo void: solo imprime.
     *
     * @param nombre texto a saludar
     */
    public static void mostrarSaludo(String nombre) {
        System.out.println("Hola, " + nombre);
    }

    /**
     * Demo return: multiplica por 2.
     *
     * @param n valor de entrada
     * @return el doble de n
     */
    public static int duplicar(int n) {
        return n * 2;
    }

    /**
     * T7: arrays, heladas, dia mas frio, calibrar.
     */
    public static void repasoArraysHeladas() {
        int[] temps;
        int desvio;
        int heladas;
        int diaFrio;
        int minimo;
        int posicion;

        System.out.println("--- 11. Arrays heladas ---");
        temps = new int[] {2, -1, 0, -3};
        desvio = 1;
        System.out.println("length -> " + temps.length);

        for (posicion = 0; posicion < temps.length; posicion++) {
            temps[posicion] = temps[posicion] - desvio;
        }
        System.out.println("Tras calibrar: " + Arrays.toString(temps));

        heladas = 0;
        for (posicion = 0; posicion < temps.length; posicion++) {
            if (temps[posicion] < 0) {
                heladas++;
            }
        }

        minimo = temps[0];
        diaFrio = 1;
        for (posicion = 1; posicion < temps.length; posicion++) {
            if (temps[posicion] < minimo) {
                minimo = temps[posicion];
                diaFrio = posicion + 1;
            }
        }

        System.out.println("Heladas (<0): " + heladas);
        System.out.println("Dia mas frio (1-based): " + diaFrio);
        System.out.println("TRUCO: for (t : temps) t -= x NO modifica el array.");
        System.out.println("TRUCO: array vacio -> comprueba length antes de [0].");
    }
}
