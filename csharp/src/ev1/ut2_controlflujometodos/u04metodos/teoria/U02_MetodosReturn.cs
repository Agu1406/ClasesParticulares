/*
U02 — Metodos con return: devolver un valor al llamador.

OBJETIVO:
  - Declarar metodos que devuelven int, double, bool, string, etc.
  - Usar return para entregar el resultado y salir del metodo.
  - Guardar el valor devuelto en variables o usarlo en expresiones.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

class Program
{
    static void Main()
    {
        Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

        /*
        PRIMERA PARTE - Metodo que devuelve int.
        */
        Console.WriteLine("¡DEMO 1: SUMAR!\n");
        int total = Sumar(3, 4);
        Console.WriteLine($"3 + 4 = {total}");
        Console.WriteLine($"10 + 2 = {Sumar(10, 2)}");

        /*
        SEGUNDA PARTE - Metodo que devuelve double.
        */
        Console.WriteLine("\n¡DEMO 2: AREA DE CIRCULO!\n");
        double radio = 5.0;
        double area = AreaCirculo(radio);
        Console.WriteLine($"Radio {radio} -> area = {area:F2}");

        /*
        TERCERA PARTE - Metodo que devuelve bool y string.
        */
        Console.WriteLine("\n¡DEMO 3: ES PAR Y CALIFICACION!\n");
        int numero = 14;
        Console.WriteLine($"¿{numero} es par? {EsPar(numero)}");

        int nota = 8;
        Console.WriteLine($"Nota {nota} -> {ObtenerCalificacion(nota)}");

        /*
        CUARTA PARTE - Usar el return directamente en una expresion.
        */
        Console.WriteLine("\n¡DEMO 4: DOBLE Y TRIPLE!\n");
        int x = 7;
        Console.WriteLine($"Doble de {x} = {Doble(x)}, triple = {Triple(x)}");

        Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
    }

    static int Sumar(int a, int b)
    {
        return a + b;
    }

    static double AreaCirculo(double radio)
    {
        return Math.PI * radio * radio;
    }

    static bool EsPar(int n)
    {
        return n % 2 == 0;
    }

    static string ObtenerCalificacion(int nota)
    {
        if (nota >= 9)
        {
            return "Sobresaliente";
        }
        if (nota >= 7)
        {
            return "Notable";
        }
        if (nota >= 5)
        {
            return "Aprobado";
        }
        return "Suspenso";
    }

    static int Doble(int n) => n * 2;
    static int Triple(int n) => n * 3;
}
