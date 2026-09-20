/*
U01 — Introduccion a arrays.

OBJETIVO:
  - Entender que un array almacena varios valores del mismo tipo en posiciones fijas.
  - Declarar un array con new int[n] y reservar espacio en memoria.
  - Asignar y leer valores usando el indice (base 0).
  - Diferenciar declaracion, creacion y acceso por posicion.
  - Practicar class + Main + menu do-while (EV1).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U01 Introduccion a arrays ===");
        Console.WriteLine("1. Declaracion y creacion (new int[n])");
        Console.WriteLine("2. Asignacion por indice");
        Console.WriteLine("3. Lectura y copia");
        Console.WriteLine("4. Array de string");
        Console.WriteLine("0. Salir");
    }

    static void Main()
    {
        int opcion;
        do
        {
            ImprimirMenu();
            Console.Write("Introduce una opcion -> ");
            opcion = int.Parse(Console.ReadLine()!);
            Console.WriteLine();

            switch (opcion)
            {
                case 1:
                    DemoCreacion();
                    break;
                case 2:
                    DemoAsignacion();
                    break;
                case 3:
                    DemoLectura();
                    break;
                case 4:
                    DemoStringArray();
                    break;
                case 0:
                    Console.WriteLine("Saliendo...");
                    break;
                default:
                    Console.WriteLine("Opcion no valida.");
                    break;
            }

            Console.WriteLine();
        } while (opcion != 0);
    }

    /*
    PRIMERA PARTE — Declarar y crear un array vacio con new int[n].
      int[] nombre = new int[5]; reserva 5 posiciones (indices 0..4).
      Al crear int[n], cada celda vale 0 por defecto.
    */
    static void DemoCreacion()
    {
        Console.WriteLine("¡DEMO — Declaracion y creacion!\n");
        int[] numeros = new int[5];

        Console.WriteLine("Array creado con 5 posiciones.");
        Console.WriteLine("Valor por defecto en numeros[0]: " + numeros[0]);
        Console.WriteLine("Valor por defecto en numeros[4]: " + numeros[4]);
    }

    /*
    SEGUNDA PARTE — Asignar valores por indice.
      numeros[0] = 10; escribe en la primera posicion.
      El indice SIEMPRE empieza en 0, no en 1.
    */
    static void DemoAsignacion()
    {
        Console.WriteLine("¡DEMO — Asignacion por indice!\n");
        int[] numeros = new int[5];
        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;
        numeros[3] = 40;
        numeros[4] = 50;

        Console.WriteLine("Valores asignados:");
        Console.WriteLine("  numeros[0] = " + numeros[0]);
        Console.WriteLine("  numeros[2] = " + numeros[2]);
        Console.WriteLine("  numeros[4] = " + numeros[4]);
    }

    /*
    TERCERA PARTE — Leer valores y copiar a otra variable.
      Leer es igual que escribir: nombre[indice].
    */
    static void DemoLectura()
    {
        Console.WriteLine("¡DEMO — Lectura y copia!\n");
        int[] numeros = { 10, 20, 30, 40, 50 };

        Console.WriteLine("Primer elemento (indice 0): " + numeros[0]);
        Console.WriteLine("Tercer elemento (indice 2): " + numeros[2]);
        Console.WriteLine("Ultimo elemento (indice 4): " + numeros[4]);

        int copiaDelSegundo = numeros[1];
        Console.WriteLine("Copia del segundo elemento: " + copiaDelSegundo);

        int indice = 3;
        Console.WriteLine("Elemento en indice variable (" + indice + "): " + numeros[indice]);
    }

    /*
    CUARTA PARTE — Array de otro tipo (string) con la misma idea.
    */
    static void DemoStringArray()
    {
        Console.WriteLine("¡DEMO — Array de string!\n");
        string[] dias = new string[3];
        dias[0] = "Lunes";
        dias[1] = "Martes";
        dias[2] = "Miercoles";

        for (int i = 0; i < dias.Length; i++)
        {
            Console.WriteLine("  dias[" + i + "] = " + dias[i]);
        }
    }
}

