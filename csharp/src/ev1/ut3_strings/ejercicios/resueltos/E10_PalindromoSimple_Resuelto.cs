/*
OBJETIVO: Lee una palabra y comprueba si es palindromo ignorando mayusculas y minusculas.
SOLUCION: ver codigo. Se presenta con menu do-while y opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E10 Palindromo simple (resuelto) ===");
    Console.WriteLine("1. Comprobar palabra");
    Console.WriteLine("2. Comprobar palabra y mostrar invertida");
    Console.WriteLine("0. Salir");
    Console.Write("Elige una opcion: ");
    opcion = Console.ReadLine() ?? "0";
    Console.WriteLine();

    switch (opcion)
    {
        case "1":
        case "2":
            Console.Write("Escribe una palabra: ");
            string palabra = Console.ReadLine() ?? "";
            string normalizada = palabra.ToLower();
            string invertida = "";

            for (int i = normalizada.Length - 1; i >= 0; i--)
            {
                invertida += normalizada[i];
            }

            bool esPalindromo = normalizada == invertida;

            if (opcion == "2")
            {
                Console.WriteLine("Invertida: " + invertida);
            }

            Console.WriteLine(esPalindromo ? "Es palindromo." : "No es palindromo.");
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
