/*
OBJETIVO: Lee una cadena y muestrala en mayusculas y en minusculas.
SOLUCION: ver codigo. Se presenta con menu do-while y opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E02 Mayusculas y minusculas (resuelto) ===");
    Console.WriteLine("1. Convertir texto");
    Console.WriteLine("2. Convertir y mostrar longitud");
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
            Console.WriteLine("Mayusculas: " + texto.ToUpper());
            Console.WriteLine("Minusculas: " + texto.ToLower());

            if (opcion == "2")
            {
                Console.WriteLine("Longitud: " + texto.Length);
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
