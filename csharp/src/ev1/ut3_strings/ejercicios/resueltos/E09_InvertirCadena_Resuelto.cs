/*
OBJETIVO: Lee una cadena e imprime la misma cadena invertida con un bucle.
SOLUCION: ver codigo. Se presenta con menu do-while y opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E09 Invertir cadena (resuelto) ===");
    Console.WriteLine("1. Invertir cadena");
    Console.WriteLine("2. Invertir y comparar con original");
    Console.WriteLine("0. Salir");
    Console.Write("Elige una opcion: ");
    opcion = Console.ReadLine() ?? "0";
    Console.WriteLine();

    switch (opcion)
    {
        case "1":
        case "2":
            Console.Write("Escribe una cadena: ");
            string texto = Console.ReadLine() ?? "";
            string invertida = "";

            for (int i = texto.Length - 1; i >= 0; i--)
            {
                invertida += texto[i];
            }

            Console.WriteLine("Invertida: " + invertida);

            if (opcion == "2")
            {
                Console.WriteLine(texto == invertida ? "Coincide con la original." : "No coincide con la original.");
            }
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
