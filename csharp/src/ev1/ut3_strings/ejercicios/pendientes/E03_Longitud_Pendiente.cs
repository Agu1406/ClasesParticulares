/*
OBJETIVO: Quita espacios con Trim a una cadena leida y muestra Length
          (paridad con Python E03 StripLen). Menu do-while, 0 = salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E03 Trim y longitud (pendiente) ===");
    Console.WriteLine("1. Intentar ejercicio");
    Console.WriteLine("2. Ver objetivo");
    Console.WriteLine("0. Salir");
    Console.Write("Elige una opcion: ");
    opcion = Console.ReadLine() ?? "0";
    Console.WriteLine();

    switch (opcion)
    {
        case "1":
            Console.Write("Escribe una cadena (puedes dejar espacios): ");
            string texto = Console.ReadLine() ?? "";

            Console.WriteLine("Instrucciones:");
            Console.WriteLine("- Muestra Length del texto original.");
            Console.WriteLine("- Aplica Trim() y muestra Length del resultado.");

            int longitudOriginal = 0;
            string limpio = "";
            int longitudLimpio = 0;

            // TODO: asigna longitudOriginal, limpio (Trim) y longitudLimpio.

            Console.WriteLine("Original: \"" + texto + "\" Length=" + longitudOriginal);
            Console.WriteLine("Trim:     \"" + limpio + "\" Length=" + longitudLimpio);
            break;

        case "2":
            Console.WriteLine("Objetivo: usar Trim y Length, como strip() y len() en Python.");
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
