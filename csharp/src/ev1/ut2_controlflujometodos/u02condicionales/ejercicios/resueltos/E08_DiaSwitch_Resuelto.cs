/*
OBJETIVO: Entero dia 1-7; switch muestra nombre del dia (1=Lunes ... 7=Domingo).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

int dia = 4;
switch (dia)
{
    case 1: Console.WriteLine("Lunes"); break;
    case 2: Console.WriteLine("Martes"); break;
    case 3: Console.WriteLine("Miercoles"); break;
    case 4: Console.WriteLine("Jueves"); break;
    case 5: Console.WriteLine("Viernes"); break;
    case 6: Console.WriteLine("Sabado"); break;
    case 7: Console.WriteLine("Domingo"); break;
    default: Console.WriteLine("Invalido"); break;
}
