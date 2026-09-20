/*
OBJETIVO: Lee nombre y nota; muestra un mensaje con interpolacion de cadenas ($).
Este ejercicio ahora se ejecuta desde un menu do-while con opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E08 Interpolacion y nota (pendiente) ===");
    Console.WriteLine("1. Intentar ejercicio");
    Console.WriteLine("2. Ver objetivo");
    Console.WriteLine("0. Salir");
    Console.Write("Elige una opcion: ");
    opcion = Console.ReadLine() ?? "0";
    Console.WriteLine();

    switch (opcion)
    {
        case "1":
            Console.Write("Nombre del alumno: ");
            string nombre = Console.ReadLine() ?? "";
            Console.Write("Nota (0-10): ");
            string entradaNota = Console.ReadLine() ?? "";

            Console.WriteLine("Instrucciones:");
            Console.WriteLine("- Convierte la nota a entero.");
            Console.WriteLine("- Muestra el resultado con una cadena interpolada usando $.");

            int nota = 0;

            // TODO: convierte entradaNota a numero y muestra un mensaje con $"".

            Console.WriteLine("Ejercicio preparado para completar.");
            break;

        case "2":
            Console.WriteLine("Objetivo: practicar la interpolacion de cadenas con nombre y nota.");
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
