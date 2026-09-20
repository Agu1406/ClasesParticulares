/*
U04 — Sobrecarga de metodos (overload): mismo nombre, distintos parametros.

OBJETIVO:
  - Definir varios metodos con el mismo nombre y diferente firma.
  - Diferenciar por numero o tipo de parametros.
  - Dejar que el compilador elija la version correcta al llamar.

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
        PRIMERA PARTE - Sumar con int y con double.
          El compilador elige segun el tipo de los argumentos.
        */
        Console.WriteLine("¡DEMO 1: SUMAR INT Y DOUBLE!\n");
        Console.WriteLine($"Sumar(2, 3)       = {Sumar(2, 3)}");
        Console.WriteLine($"Sumar(1.5, 2.5)   = {Sumar(1.5, 2.5)}");

        /*
        SEGUNDA PARTE - Tres parametros vs dos.
        */
        Console.WriteLine("\n¡DEMO 2: SUMAR DOS O TRES NUMEROS!\n");
        Console.WriteLine($"Sumar(1, 2, 3)    = {Sumar(1, 2, 3)}");
        Console.WriteLine($"Sumar(10, 20)     = {Sumar(10, 20)}");

        /*
        TERCERA PARTE - Mostrar con distintos tipos.
        */
        Console.WriteLine("\n¡DEMO 3: MOSTRAR SOBRECARGADO!\n");
        Mostrar("Hola mundo");
        Mostrar(42);
        Mostrar(3.14, 2);  // double con decimales a mostrar

        /*
        CUARTA PARTE - Area: cuadrado (1 param) vs rectangulo (2 params).
        */
        Console.WriteLine("\n¡DEMO 4: AREA SOBRECARGADA!\n");
        Console.WriteLine($"Area cuadrado (5)      = {Area(5)}");
        Console.WriteLine($"Area rectangulo (4, 6) = {Area(4, 6)}");

        Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
    }

    static int Sumar(int a, int b) => a + b;
    static double Sumar(double a, double b) => a + b;
    static int Sumar(int a, int b, int c) => a + b + c;

    static void Mostrar(string texto)
    {
        Console.WriteLine($"  [texto] {texto}");
    }

    static void Mostrar(int numero)
    {
        Console.WriteLine($"  [entero] {numero}");
    }

    static void Mostrar(double valor, int decimales)
    {
        Console.WriteLine($"  [decimal] {valor.ToString($"F{decimales}")}");
    }

    static int Area(int lado) => lado * lado;
    static int Area(int baseRect, int altura) => baseRect * altura;
}
