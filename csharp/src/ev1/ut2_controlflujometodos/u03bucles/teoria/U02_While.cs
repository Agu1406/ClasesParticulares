/*
U02 — Bucle while: repetir mientras la condicion sea verdadera.

OBJETIVO:
  - Usar while cuando no sabemos cuantas vueltas haran falta.
  - Implementar un contador manual dentro del while.
  - Conocer el patron centinela (valor especial que detiene el bucle).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - while con contador (equivalente a un for simple).
  Importante: modificar la variable de control dentro del bucle (n++).
*/
Console.WriteLine("¡DEMO 1: CONTADOR CON WHILE!\n");

int n = 1;
while (n <= 5)
{
    Console.WriteLine($"  n = {n}");
    n++;
}

/*
SEGUNDA PARTE - Acumular hasta llegar a un objetivo.
  Se repite mientras la suma no supere 100.
*/
Console.WriteLine("\n¡DEMO 2: SUMAR HASTA SUPERAR 100!\n");

int suma = 0;
int termino = 1;
while (suma <= 100)
{
    suma += termino;
    Console.WriteLine($"  +{termino} -> suma parcial = {suma}");
    termino++;
}
Console.WriteLine($"Se detuvo con suma = {suma}\n");

/*
TERCERA PARTE - Patron centinela con datos simulados.
  Un centinela es un valor especial (-1) que marca el final de datos.
  (En ejercicios reales vendria de Console.ReadLine).
*/
Console.WriteLine("¡DEMO 3: CENTINELA -1!\n");

int dato1 = 12;
int dato2 = 45;
int dato3 = 8;
int dato4 = 33;
int dato5 = -1;  // centinela: fin de datos
int paso = 1;
int valor = dato1;

Console.Write("Valores leidos: ");
while (valor != -1)  // centinela: cuando es -1, paramos
{
    Console.Write($"{valor} ");

    paso++;
    if (paso == 2)
    {
        valor = dato2;
    }
    else if (paso == 3)
    {
        valor = dato3;
    }
    else if (paso == 4)
    {
        valor = dato4;
    }
    else
    {
        valor = dato5;
    }
}
Console.WriteLine("(centinela -1 detectado, bucle terminado)");

/*
CUARTA PARTE - Buscar el primer multiplo de 7 mayor que 50.
*/
Console.WriteLine("\n¡DEMO 4: BUSQUEDA CON WHILE!\n");

int candidato = 1;
while (candidato <= 50 || candidato % 7 != 0)
{
    candidato++;
}
Console.WriteLine($"Primer multiplo de 7 despues de 50: {candidato}");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
