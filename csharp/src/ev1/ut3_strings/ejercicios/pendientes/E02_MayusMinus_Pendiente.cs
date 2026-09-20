/*
OBJETIVO: Lee una cadena y muestrala en mayusculas y en minusculas.
Este ejercicio ahora se ejecuta desde un menu do-while con opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E02 Mayusculas y minusculas (pendiente) ===");
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
            Console.WriteLine("- Guarda la cadena en una variable.");
            Console.WriteLine("- Usa ToUpper() para mostrarla en mayusculas.");
            Console.WriteLine("- Usa ToLower() para mostrarla en minusculas.");

            string mayusculas = "";
            string minusculas = "";

            // TODO: asigna a las variables el resultado de convertir el texto.

            Console.WriteLine("Mayusculas: " + mayusculas);
            Console.WriteLine("Minusculas: " + minusculas);
            break;

        case "2":
            Console.WriteLine("Objetivo: practicar el uso de ToUpper() y ToLower() con una cadena leida por teclado.");
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
