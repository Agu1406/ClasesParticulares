/*
OBJETIVO: Leer nombre con espacios y mostrarlo sin espacios extra (Trim).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.Write("Nombre: ");
string? nombre = Console.ReadLine();
Console.WriteLine("Hola, " + nombre!.Trim());
