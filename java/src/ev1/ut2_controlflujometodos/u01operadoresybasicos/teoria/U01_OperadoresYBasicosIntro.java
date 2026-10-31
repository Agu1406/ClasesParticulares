package ev1.ut2_controlflujometodos.u01operadoresybasicos.teoria;

/**
 * <p><b>OBJETIVO:</b> recorrer los operadores que vas a usar antes de los
 * condicionales: aritméticos, comparación, lógicos y ternario.</p>
 *
 * <p>Una expresión es cualquier trozo de código que produce un valor
 * ({@code 3 + 4}, {@code a > b}, {@code a = 5}). Una sentencia termina en
 * {@code ;} y ejecuta algo. Por eso se puede escribir {@code a = b = 7}:
 * la asignación también es una expresión y vale lo que acaba de guardar.</p>
 *
 * <p>Java no tiene operador {@code sizeof}: cada primitivo ocupa un tamaño fijo
 * ({@code int} 32 bits, {@code double} 64 bits). La coma como operador general
 * tampoco existe; solo puedes usarla en la cabecera de un {@code for}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U01_OperadoresYBasicosIntro {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("¡INICIO DEL PROGRAMA!");
        System.out.println();

        /*
        PRIMERA PARTE - Operadores aritmeticos con enteros.
          + suma    - resta    * producto    / cociente    % resto (modulo)
          Si los dos operandos son int, / descarta los decimales.
        */
        System.out.println("--- PRIMERA PARTE: Aritmeticos (int) ---");
        System.out.println();

        int a = 17;
        int b = 5;
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Suma:     " + a + " + " + b + " = " + (a + b));
        System.out.println("Resta:    " + a + " - " + b + " = " + (a - b));
        System.out.println("Producto: " + a + " * " + b + " = " + (a * b));
        System.out.println("Division: " + a + " / " + b + " = " + (a / b) + "  (entera)");
        System.out.println("Modulo:   " + a + " % " + b + " = " + (a % b) + "  (resto)");
        System.out.println();

        /*
        SEGUNDA PARTE - Division entera y division decimal.
          Basta con que un operando sea double para que / conserve los decimales.
          El + con un String concatena: "2" + 3 da el texto "23".
        */
        System.out.println("--- SEGUNDA PARTE: Entera frente a decimal ---");
        System.out.println();

        int total = 10;
        int personas = 3;
        System.out.println("Repartir " + total + " galletas entre " + personas + " personas:");
        System.out.println("  Entera:  " + (total / personas) + " galletas por persona");
        System.out.println("  Decimal: " + (total / (double) personas) + " galletas por persona");

        double precio = 7.50;
        int unidades = 4;
        System.out.println("Precio " + precio + " x " + unidades + " = " + (precio * unidades) + " euros");
        System.out.println("\"2\" + 3 concatena y da " + ("2" + 3));
        System.out.println("2 + 3 suma y da " + (2 + 3));
        System.out.println();

        /*
        TERCERA PARTE - Modulo en situaciones reales.
          % devuelve el resto. Sirve para paridad, multiplos y partir cantidades.
          En Java el signo del resto es el del dividendo: -7 % 4 vale -3.
        */
        System.out.println("--- TERCERA PARTE: Modulo ---");
        System.out.println();

        int minutos = 127;
        int horas = minutos / 60;
        int minutosRestantes = minutos % 60;
        System.out.println(minutos + " minutos = " + horas + " h y " + minutosRestantes + " min");

        int numero = 14;
        System.out.println(numero + " es par? " + (numero % 2 == 0));
        numero = 7;
        System.out.println(numero + " es par? " + (numero % 2 == 0));
        System.out.println("-7 % 4 = " + (-7 % 4));
        System.out.println();

        /*
        CUARTA PARTE - Comparacion.
          ==  !=  <  >  <=  >=  producen un boolean (true o false).
          == compara valores. Para textos, == compara referencias; equals()
          compara el contenido (lo veras con String).
        */
        System.out.println("--- CUARTA PARTE: Comparacion ---");
        System.out.println();

        int nota = 7;
        System.out.println("nota >= 5  -> " + (nota >= 5));
        System.out.println("nota == 10 -> " + (nota == 10));
        System.out.println("nota != 0  -> " + (nota != 0));
        System.out.println("3 > 2      -> " + (3 > 2));
        System.out.println();

        /*
        QUINTA PARTE - Logicos y cortocircuito.
          &&  AND: true solo si las dos partes lo son. Si la izquierda es false, no evalua la derecha.
          ||  OR:  true si alguna parte lo es. Si la izquierda es true, no evalua la derecha.
          !   NOT: invierte el boolean.
        */
        System.out.println("--- QUINTA PARTE: Logicos ---");
        System.out.println();

        boolean mayorDeEdad = true;
        boolean tieneEntrada = false;
        System.out.println("entra al concierto? " + (mayorDeEdad && tieneEntrada));
        System.out.println("puede pasar alguien? " + (mayorDeEdad || tieneEntrada));
        System.out.println("sin entrada? " + (!tieneEntrada));

        System.out.println("false && ... no llama a la derecha:");
        System.out.println("  resultado = " + (traza("izquierda", false) && traza("derecha", true)));
        System.out.println("true || ... tampoco llama a la derecha:");
        System.out.println("  resultado = " + (traza("izquierda", true) || traza("derecha", false)));
        System.out.println();

        /*
        SEXTA PARTE - Ternario: un if-else que elige entre dos VALORES.
          condicion ? valorSiTrue : valorSiFalse
          Encadenarlo mucho lo hace dificil de leer.
        */
        System.out.println("--- SEXTA PARTE: Ternario ---");
        System.out.println();

        System.out.println("Nota " + nota + ": " + (nota >= 5 ? "Aprobado" : "Suspenso"));
        int x = 12;
        int y = 20;
        int mayor = x > y ? x : y;
        int menor = x < y ? x : y;
        System.out.println("Entre " + x + " y " + y + " el mayor es " + mayor + " y el menor es " + menor);
        System.out.println();

        /*
        SEPTIMA PARTE - La asignacion es una expresion.
          a = b = 7  guarda 7 en b y ese mismo 7 en a.
        */
        System.out.println("--- SEPTIMA PARTE: Expresiones ---");
        System.out.println();

        int p;
        int q;
        p = q = 7;
        System.out.println("p = " + p + ", q = " + q);
        System.out.println("(p = 10) vale " + (p = 10));
        System.out.println();

        /*
        OCTAVA PARTE - La coma solo en el for.
          Aqui i sube de 3 en 3 y j baja de 3 en 3 hasta cruzarse.
        */
        System.out.println("--- OCTAVA PARTE: Coma en el for ---");
        System.out.println();

        for (int i = 0, j = 10; i < j; i += 3, j -= 3) {
            System.out.println("i = " + i + ", j = " + j);
        }
        System.out.println();
        System.out.println("Siguiente: asignacion compuesta e incremento (U02), precedencia (U03).");
        System.out.println();
        System.out.println("¡FIN DEL PROGRAMA!");
        System.out.println();
    }

    /** Imprime el nombre y devuelve el boolean. Sirve para ver el cortocircuito. */
    private static boolean traza(String nombre, boolean valor) {
        System.out.println("  se evalua " + nombre);
        return valor;
    }
}
