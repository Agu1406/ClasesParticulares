/*
OBJETIVO: Quita espacios con Trim a una cadena leida y muestra Length
          (paridad con Python E03 StripLen). Menu do-while, 0 = salir.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E03 Trim y longitud (resuelto) ===");
    Console.WriteLine("1. Trim y Length de una cadena tuya");
    Console.WriteLine("2. Ejemplo fijo \"  hola  \" (como Python)");
    Console.WriteLine("0. Salir");
    Console.Write("Elige una opcion: ");
    opcion = Console.ReadLine() ?? "0";
    Console.WriteLine();

    switch (opcion)
    {
        case "1":
        case "2":
            string texto;
            if (opcion == "2")
            {
                texto = "  hola  ";
                Console.WriteLine("Usando ejemplo: \"" + texto + "\"");
            }
            else
            {
                Console.Write("Escribe una cadena (puedes dejar espacios): ");
                texto = Console.ReadLine() ?? "";
            }

            string limpio = texto.Trim();
            Console.WriteLine("Original: \"" + texto + "\" Length=" + texto.Length);
            Console.WriteLine("Trim:     \"" + limpio + "\" Length=" + limpio.Length);
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
