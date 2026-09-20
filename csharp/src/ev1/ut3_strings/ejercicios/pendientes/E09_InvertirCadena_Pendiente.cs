/*
OBJETIVO: Lee una cadena e imprime la misma cadena invertida con un bucle.
Este ejercicio ahora se ejecuta desde un menu do-while con opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E09 Invertir cadena (pendiente) ===");
    Console.WriteLine("1. Intentar ejercicio");
    Console.WriteLine("2. Ver objetivo");
    Console.WriteLine("0. Salir");
    Console.Write("Elige una opcion: ");
    opcion = Console.ReadLine() ?? "0";
    Console.WriteLine();

    switch (opcion)
    {
        case "1":
            Console.Write("Escribe una cadena: ");
            string texto = Console.ReadLine() ?? "";

            Console.WriteLine("Instrucciones:");
            Console.WriteLine("- Recorre la cadena desde el final hasta el principio.");
            Console.WriteLine("- Ve concatenando cada caracter en otra variable.");
            Console.WriteLine("- En EV1 evita arrays.");

            string invertida = "";

            // TODO: construye la cadena invertida con un for descendente.

            Console.WriteLine("Invertida: " + invertida);
            break;

        case "2":
            Console.WriteLine("Objetivo: invertir una cadena usando un bucle simple y sin arrays.");
            break;

        case "0":
            Console.WriteLine("Saliendo del ejercicio.");
            break;

        default:
            Console.WriteLine("Opcion no valida.");
            break;
    }

    Console.WriteLine();
} while (opcion != "0");
