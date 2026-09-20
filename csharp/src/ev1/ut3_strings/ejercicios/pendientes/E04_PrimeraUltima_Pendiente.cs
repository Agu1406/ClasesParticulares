/*
OBJETIVO: Lee una cadena no vacia y muestra su primer y ultimo caracter.
Este ejercicio ahora se ejecuta desde un menu do-while con opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E04 Primera y ultima letra (pendiente) ===");
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
            Console.WriteLine("- Comprueba primero que la cadena no este vacia.");
            Console.WriteLine("- Usa texto[0] para el primer caracter.");
            Console.WriteLine("- Usa texto[texto.Length - 1] para el ultimo.");

            // TODO: muestra el primer y el ultimo caracter solo si hay texto.

            Console.WriteLine("Ejercicio preparado para completar.");
            break;

        case "2":
            Console.WriteLine("Objetivo: acceder al primer y ultimo caracter de una cadena no vacia.");
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
