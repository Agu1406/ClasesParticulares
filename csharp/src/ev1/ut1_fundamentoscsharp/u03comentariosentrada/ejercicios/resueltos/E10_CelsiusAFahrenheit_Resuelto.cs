/*
OBJETIVO: Leer grados Celsius y convertir a Fahrenheit (F = C * 9/5 + 32).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.Write("Grados Celsius: ");
double c = double.Parse(Console.ReadLine()!);
double f = c * 9 / 5 + 32;
Console.WriteLine("Fahrenheit: " + f);
