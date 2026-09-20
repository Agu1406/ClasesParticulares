/*
U04 — Operadores de comparacion.

Los comparadores devuelven bool: true si la relacion se cumple, false si no.

OBJETIVO:
  - Usar == != < > <= >=
  - Guardar el resultado en un bool o imprimirlo directamente.
  - Comparar numeros y tambien strings (igualdad de contenido).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

double ingresosMesAnterior = 1400.56;
double ingresosMesActual = 2345.12;
double valorPiAyer = 3.1416;
double valorPiHoy = 3.1416;

// == igualdad
Console.WriteLine("¡PRUEBA IGUALDAD (==)!\n");
bool respuesta = ingresosMesActual == ingresosMesAnterior;
Console.WriteLine($"¿Ingresos mes actual == mes anterior? {respuesta}");
respuesta = valorPiAyer == valorPiHoy;
Console.WriteLine($"¿PI de ayer == PI de hoy? {respuesta}\n");

// != desigualdad
Console.WriteLine("¡PRUEBA DESIGUALDAD (!=)!\n");
Console.WriteLine($"¿Ingresos distintos? {ingresosMesActual != ingresosMesAnterior}");
Console.WriteLine($"¿PI distinto? {valorPiAyer != valorPiHoy}\n");

// >
Console.WriteLine("¡PRUEBA MAYOR (>)!\n");
Console.WriteLine($"¿Ingresos actuales > anteriores? {ingresosMesActual > ingresosMesAnterior}");
Console.WriteLine($"¿PI ayer > PI hoy? {valorPiAyer > valorPiHoy}\n");

// <
Console.WriteLine("¡PRUEBA MENOR (<)!\n");
Console.WriteLine($"¿Ingresos actuales < anteriores? {ingresosMesActual < ingresosMesAnterior}");
Console.WriteLine($"¿PI ayer < PI hoy? {valorPiAyer < valorPiHoy}\n");

// >= y <=
Console.WriteLine("¡PRUEBA MAYOR O IGUAL (>=) Y MENOR O IGUAL (<=)!\n");
int nota = 5;
Console.WriteLine($"nota ({nota}) >= 5 ? {nota >= 5}");
Console.WriteLine($"nota ({nota}) <= 4 ? {nota <= 4}");
Console.WriteLine($"nota ({nota}) >= 10 ? {nota >= 10}\n");

// Comparacion de strings
Console.WriteLine("¡COMPARAR STRINGS!\n");
string ciudadA = "Sevilla";
string ciudadB = "Sevilla";
string ciudadC = "Madrid";
Console.WriteLine($"\"{ciudadA}\" == \"{ciudadB}\" ? {ciudadA == ciudadB}");
Console.WriteLine($"\"{ciudadA}\" == \"{ciudadC}\" ? {ciudadA == ciudadC}");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
