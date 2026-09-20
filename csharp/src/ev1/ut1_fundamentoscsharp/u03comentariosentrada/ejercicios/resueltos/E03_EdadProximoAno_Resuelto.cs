/*
OBJETIVO: Leer edad actual y mostrar edad del proximo ano.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.Write("Edad: ");
int edad = int.Parse(Console.ReadLine()!);
Console.WriteLine("El próximo año tendrás " + (edad + 1) + " años");
