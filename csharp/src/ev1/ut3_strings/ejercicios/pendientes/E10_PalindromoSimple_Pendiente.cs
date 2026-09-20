/*
OBJETIVO: Lee una palabra y comprueba si es palindromo ignorando mayusculas y minusculas.
Este ejercicio ahora se ejecuta desde un menu do-while con opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E10 Palindromo simple (pendiente) ===");
    Console.WriteLine("1. Intentar ejercicio");
    Console.WriteLine("2. Ver objetivo");
    Console.WriteLine("0. Salir");
    Console.Write("Elige una opcion: ");
    opcion = Console.ReadLine() ?? "0";
    Console.WriteLine();

    switch (opcion)
    {
        case "1":
            Console.Write("Escribe una palabra: ");
            string palabra = Console.ReadLine() ?? "";

            Console.WriteLine("Instrucciones:");
            Console.WriteLine("- Convierte la palabra a minusculas.");
            Console.WriteLine("- Invierte la cadena con un bucle.");
            Console.WriteLine("- Compara ambas cadenas.");

            string normalizada = palabra.ToLower();
            string invertida = "";
            bool esPalindromo = false;

            // TODO: construye la invertida y compara con la cadena normalizada.

            Console.WriteLine("Es palindromo: " + esPalindromo);
            break;

        case "2":
            Console.WriteLine("Objetivo: comprobar si una palabra se lee igual al derecho y al reves.");
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
