/*
OBJETIVO: Lee una cadena y un caracter; cuenta cuantas veces aparece esa letra.
Este ejercicio ahora se ejecuta desde un menu do-while con opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E07 Contar letra (pendiente) ===");
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
            Console.Write("Letra a contar: ");
            string entrada = Console.ReadLine() ?? "";

            Console.WriteLine("Instrucciones:");
            Console.WriteLine("- Toma la primera posicion de la entrada si existe.");
            Console.WriteLine("- Recorre el texto letra a letra.");
            Console.WriteLine("- Suma 1 cada vez que coincidan.");

            char letra = ' ';
            int contador = 0;

            // TODO: inicializa la letra y cuenta cuantas veces aparece.

            Console.WriteLine("Aparece " + contador + " veces.");
            break;

        case "2":
            Console.WriteLine("Objetivo: contar cuantas veces aparece una letra en un texto.");
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
