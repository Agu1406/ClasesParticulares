/*
OBJETIVO: Do-while: menu numerico; repite hasta que el usuario elija 0.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

int op;
do
{
    Console.Write("Menu (0=salir): ");
    op = int.Parse(Console.ReadLine()!);
    if (op != 0)
    {
        Console.WriteLine($"Opcion {op}");
    }
} while (op != 0);
