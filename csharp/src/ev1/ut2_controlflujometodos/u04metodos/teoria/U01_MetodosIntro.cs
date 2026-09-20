/*
U01 — Introduccion a metodos void.

OBJETIVO:
  - Definir metodos static void que no devuelven valor.
  - Llamar un metodo varias veces desde Main.
  - Agrupar codigo repetido en un bloque con nombre.

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
        PRIMERA PARTE - Llamar un metodo void varias veces.
          void = no devuelve nada; solo ejecuta acciones (side effects).
        */
        Console.WriteLine("¡DEMO 1: SALUDAR!\n");
        Saludar();
        Saludar();

        /*
        SEGUNDA PARTE - Metodo que imprime una linea separadora.
        */
        Console.WriteLine("\n¡DEMO 2: SEPARADOR!\n");
        ImprimirSeparador();
        Console.WriteLine("Contenido entre separadores");
        ImprimirSeparador();

        /*
        TERCERA PARTE - Metodo con logica interna (bucle).
        */
        Console.WriteLine("\n¡DEMO 3: CONTAR HASTA 5!\n");
        ContarHasta();

        Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
    }

    static void Saludar()
    {
        Console.WriteLine("Hola desde el metodo Saludar()");
    }

    static void ImprimirSeparador()
    {
        Console.WriteLine(new string('-', 30));
    }

    static void ContarHasta()
    {
        Console.Write("Contando hasta 5: ");
        for (int i = 1; i <= 5; i++)
        {
            Console.Write($"{i} ");
        }
        Console.WriteLine();
    }
}
