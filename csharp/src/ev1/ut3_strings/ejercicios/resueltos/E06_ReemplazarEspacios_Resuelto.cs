/*
OBJETIVO: Lee una cadena y reemplaza todos los espacios por guiones bajos (Replace).
SOLUCION: ver codigo. Se presenta con menu do-while y opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E06 Reemplazar espacios (resuelto) ===");
    Console.WriteLine("1. Reemplazar por guiones bajos");
    Console.WriteLine("2. Reemplazar y mostrar original");
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
            string resultado = texto.Replace(" ", "_");

            if (opcion == "2")
            {
                Console.WriteLine("Original: " + texto);
            }

            Console.WriteLine("Resultado: " + resultado);
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
