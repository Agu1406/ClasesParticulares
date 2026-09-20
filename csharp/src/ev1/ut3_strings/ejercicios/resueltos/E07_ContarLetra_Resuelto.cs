/*
OBJETIVO: Lee una cadena y un caracter; cuenta cuantas veces aparece esa letra.
SOLUCION: ver codigo. Se presenta con menu do-while y opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

string opcion;

do
{
    Console.WriteLine("=== E07 Contar letra (resuelto) ===");
    Console.WriteLine("1. Contar coincidencias exactas");
    Console.WriteLine("2. Contar ignorando mayusculas");
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
            Console.Write("Letra a contar: ");
            string entrada = Console.ReadLine() ?? "";

            if (entrada.Length == 0)
            {
                Console.WriteLine("Debes escribir al menos un caracter.");
                break;
            }

            char letra = opcion == "2" ? char.ToLower(entrada[0]) : entrada[0];
            int contador = 0;

            foreach (char caracter in texto)
            {
                char actual = opcion == "2" ? char.ToLower(caracter) : caracter;

                if (actual == letra)
                {
                    contador++;
                }
            }

            Console.WriteLine("Aparece " + contador + " veces.");
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
