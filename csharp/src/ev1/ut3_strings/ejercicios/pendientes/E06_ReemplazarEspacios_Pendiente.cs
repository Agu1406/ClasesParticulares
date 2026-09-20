/*
OBJETIVO: Lee una cadena y reemplaza todos los espacios por guiones bajos (Replace).
Este ejercicio ahora se ejecuta desde un menu do-while con opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E06 Reemplazar espacios (pendiente) ===");
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
            Console.WriteLine("- Usa Replace(\" \", \"_\").");
            Console.WriteLine("- Guarda el resultado en otra variable.");

            string resultado = "";

            // TODO: reemplaza los espacios del texto por guiones bajos.

            Console.WriteLine("Resultado: " + resultado);
            break;

        case "2":
            Console.WriteLine("Objetivo: sustituir espacios por guiones bajos usando Replace().");
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
