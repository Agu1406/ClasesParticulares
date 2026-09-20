/*
OBJETIVO: Leer base y altura; calcular area del rectangulo.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.Write("Base: ");
double baseRect = double.Parse(Console.ReadLine()!);
Console.Write("Altura: ");
double altura = double.Parse(Console.ReadLine()!);
Console.WriteLine("Area: " + (baseRect * altura));
