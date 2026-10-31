package ev1.ut2_controlflujometodos.u01operadoresybasicos.teoria;

/**
 * <p><b>OBJETIVO:</b> usar la asignación compuesta ({@code +=}, {@code -=},
 * {@code *=}, {@code /=}, {@code %=}) y distinguir el incremento prefijo
 * ({@code ++x}) del postfijo ({@code x++}).</p>
 *
 * <p>Como sentencia suelta, {@code x++} y {@code ++x} hacen lo mismo: suman 1.
 * Dentro de otra expresión, el prefijo suma antes de usar el valor y el
 * postfijo usa el valor antiguo y suma después.</p>
 *
 * <p>En Java el orden de evaluación está definido (de izquierda a derecha),
 * pero {@code n = n++} sigue siendo confuso: el incremento se pierde porque
 * la asignación vuelve a guardar el valor antiguo. Una modificación por línea.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U02_AsignacionEIncremento {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("¡INICIO DEL PROGRAMA!");
        System.out.println();

        /*
        PRIMERA PARTE - Asignacion compuesta.
          x += 5   equivale a   x = x + 5
          Lo mismo con  -=  *=  /=  %=
        */
        System.out.println("--- PRIMERA PARTE: Asignacion compuesta ---");
        System.out.println();

        int valor = 20;
        System.out.println("valor inicial: " + valor);
        valor += 5;
        System.out.println("valor += 5  -> " + valor);
        valor -= 3;
        System.out.println("valor -= 3  -> " + valor);
        valor *= 2;
        System.out.println("valor *= 2  -> " + valor);
        valor /= 4;
        System.out.println("valor /= 4  -> " + valor);
        valor %= 4;
        System.out.println("valor %= 4  -> " + valor);

        double saldo = 1000.0;
        saldo *= 1.05;
        System.out.println("saldo con un 5% de interes: " + saldo);

        int segundos = 125;
        segundos %= 60;
        System.out.println("125 segundos, resto al pasar a minutos: " + segundos);
        System.out.println();

        /*
        SEGUNDA PARTE - ++ y -- como sentencia.
          Tres incrementos y un decremento. Prefijo y postfijo coinciden
          cuando la linea no usa el valor para otra cosa.
        */
        System.out.println("--- SEGUNDA PARTE: ++ y -- sueltos ---");
        System.out.println();

        int contador = 0;
        contador++;
        contador++;
        ++contador;
        System.out.println("contador tras tres incrementos: " + contador);
        contador--;
        System.out.println("contador tras un decremento: " + contador);
        System.out.println();

        /*
        TERCERA PARTE - Prefijo frente a postfijo.
          y = x++  -> y recibe el valor antiguo y despues x sube.
          y = ++x  -> x sube primero y y recibe el valor nuevo.
        */
        System.out.println("--- TERCERA PARTE: Prefijo y postfijo ---");
        System.out.println();

        int x = 5;
        int y = x++;
        System.out.println("y = x++  -> y = " + y + ", x = " + x);

        x = 5;
        y = ++x;
        System.out.println("y = ++x  -> y = " + y + ", x = " + x);

        int i = 3;
        System.out.println("println de i++: " + (i++));
        System.out.println("despues i vale: " + i);
        System.out.println("println de ++i: " + (++i));
        System.out.println();

        /*
        CUARTA PARTE - Una modificacion por linea.
          n = n++ guarda el valor de antes del incremento y anula la subida.
          n = ++n si deja el valor nuevo. Escribelo en dos lineas y se lee solo.
        */
        System.out.println("--- CUARTA PARTE: Evitar mezclar ---");
        System.out.println();

        int n = 10;
        n = n++;
        System.out.println("n = n++ deja n en " + n);

        n = 10;
        n = ++n;
        System.out.println("n = ++n deja n en " + n);

        n = 10;
        n++;
        int doble = n * 2;
        System.out.println("tras n++ en su linea: n = " + n + ", doble = " + doble);
        System.out.println();

        /*
        QUINTA PARTE - Contador y acumulador.
          CONTADOR:    cuenta cuantas veces ocurre algo     -> pares++
          ACUMULADOR:  va sumando valores                   -> suma += k
        */
        System.out.println("--- QUINTA PARTE: Contador y acumulador ---");
        System.out.println();

        int pares = 0;
        int sumaPares = 0;
        for (int k = 1; k <= 10; k++) {
            if (k % 2 == 0) {
                pares++;
                sumaPares += k;
            }
        }
        System.out.println("Entre 1 y 10 hay " + pares + " pares y suman " + sumaPares);

        int vidas = 3;
        System.out.print("Vidas restantes: ");
        while (vidas > 0) {
            System.out.print(vidas + " ");
            vidas--;
        }
        System.out.println("(game over)");

        int suma = 0;
        for (int k = 1; k <= 5; k++) {
            suma += k;
        }
        System.out.println("Suma del 1 al 5: " + suma);
        System.out.println();
        System.out.println("¡FIN DEL PROGRAMA!");
        System.out.println();
    }
}
