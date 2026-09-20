/*
OBJETIVO: Leer precio y calcular total con IVA (x 1.21).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.Write("Precio: ");
double precio = double.Parse(Console.ReadLine()!);
Console.WriteLine("Total con IVA: " + (precio * 1.21));
