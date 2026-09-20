/*
OBJETIVO: Lee nombre y nota; muestra un mensaje con interpolacion de cadenas ($).
SOLUCION: ver codigo. Se presenta con menu do-while y opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E08 Interpolacion y nota (resuelto) ===");
    Console.WriteLine("1. Mostrar nota");
    Console.WriteLine("2. Mostrar nota y valoracion");
    Console.WriteLine("0. Salir");
    Console.Write("Elige una opcion: ");
    opcion = Console.ReadLine() ?? "0";
    Console.WriteLine();

    switch (opcion)
    {
        case "1":
        case "2":
            Console.Write("Nombre del alumno: ");
            string nombre = Console.ReadLine() ?? "";
            Console.Write("Nota (0-10): ");
            string entradaNota = Console.ReadLine() ?? "";

            if (!int.TryParse(entradaNota, out int nota))
            {
                Console.WriteLine("La nota debe ser un numero entero.");
                break;
            }

            Console.WriteLine($"{nombre} ha obtenido una nota de {nota}.");

            if (opcion == "2")
            {
                string valoracion = nota >= 5 ? "apto" : "no apto";
                Console.WriteLine($"{nombre} esta {valoracion}.");
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
