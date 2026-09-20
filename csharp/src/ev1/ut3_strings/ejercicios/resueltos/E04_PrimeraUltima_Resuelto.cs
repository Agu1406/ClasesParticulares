/*
OBJETIVO: Lee una cadena no vacia y muestra su primer y ultimo caracter.
SOLUCION: ver codigo. Se presenta con menu do-while y opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E04 Primera y ultima letra (resuelto) ===");
    Console.WriteLine("1. Mostrar extremos");
    Console.WriteLine("2. Mostrar extremos y longitud");
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

            if (texto.Length > 0)
            {
                Console.WriteLine("Primero: " + texto[0]);
                Console.WriteLine("Ultimo: " + texto[texto.Length - 1]);

                if (opcion == "2")
                {
                    Console.WriteLine("Longitud: " + texto.Length);
                }
            }
            else
            {
                Console.WriteLine("La cadena esta vacia.");
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
