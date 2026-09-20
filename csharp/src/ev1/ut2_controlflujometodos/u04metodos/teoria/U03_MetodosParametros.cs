/*
U03 — Parametros: pasar datos a un metodo.

OBJETIVO:
  - Definir metodos con uno o varios parametros tipados.
  - Pasar valores concretos al llamar (argumentos).
  - Reutilizar la misma logica con distintos datos de entrada.

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
        PRIMERA PARTE - Parametros en metodo void.
        */
        Console.WriteLine("¡DEMO 1: REPETIR MENSAJE!\n");
        MostrarMensaje("C# es genial", 3);
        MostrarMensaje("Fin de demo", 1);

        /*
        SEGUNDA PARTE - Parametros en metodo con return.
        */
        Console.WriteLine("\n¡DEMO 2: AREA Y PERIMETRO!\n");
        Console.WriteLine($"Rectangulo 5x3 -> area = {AreaRectangulo(5, 3)}");
        Console.WriteLine($"Cuadrado lado 4 -> perimetro = {PerimetroCuadrado(4)}");

        /*
        TERCERA PARTE - Varios parametros de distinto tipo.
        */
        Console.WriteLine("\n¡DEMO 3: PRESENTAR PERSONA!\n");
        PresentarPersona("Agustin", 26, 1.76);
        PresentarPersona("Eduardo", 29, 1.74);

        /*
        CUARTA PARTE - Parametros usados en calculos compuestos.
        */
        Console.WriteLine("\n¡DEMO 4: PRECIO CON IVA!\n");
        double precio1 = CalcularPrecioConIva(100, 21);
        double precio2 = CalcularPrecioConIva(49.99, 10);
        Console.WriteLine($"100 + 21% IVA = {precio1:F2} euros");
        Console.WriteLine($"49,99 + 10% IVA = {precio2:F2} euros");

        Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
    }

    static void MostrarMensaje(string texto, int veces)
    {
        for (int i = 0; i < veces; i++)
        {
            Console.WriteLine($"  [{i + 1}] {texto}");
        }
    }

    static int AreaRectangulo(int baseRect, int altura)
    {
        return baseRect * altura;
    }

    static int PerimetroCuadrado(int lado)
    {
        return 4 * lado;
    }

    static void PresentarPersona(string nombre, int edad, double altura)
    {
        Console.WriteLine($"  {nombre}: {edad} años, {altura} m");
    }

    static double CalcularPrecioConIva(double baseImponible, double porcentajeIva)
    {
        return baseImponible * (1 + porcentajeIva / 100.0);
    }
}
