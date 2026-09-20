/*
U02 — Asignacion compuesta e incremento/decremento.

OBJETIVO:
  - Usar operadores compuestos: +=, -=, *=, /=, %=.
  - Entender ++ y -- en modo postfix (despues) y prefix (antes).
  - Ver como modifican una variable sin escribir la expresion completa.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - Asignacion compuesta.
  x += n  es atajo de  x = x + n  (igual con -= *= /= %=)
*/
Console.WriteLine("¡ASIGNACION COMPUESTA!\n");

int saldo = 100;
Console.WriteLine($"Saldo inicial: {saldo}");
saldo += 50;
Console.WriteLine($"Tras cobrar 50 (+=): {saldo}");
saldo -= 30;
Console.WriteLine($"Tras pagar 30 (-=): {saldo}");

int puntos = 10;
puntos *= 3;
Console.WriteLine($"Puntos x3 (*=): {puntos}");

int total = 20;
total /= 4;
Console.WriteLine($"Total /4 (/=): {total}");

int segundos = 125;
segundos %= 60;
Console.WriteLine($"125 seg % 60 (resto minutos): {segundos}\n");

/*
SEGUNDA PARTE - Incremento postfix (x++).
  Usa el valor actual y DESPUES suma 1.
*/
Console.WriteLine("¡INCREMENTO POSTFIX (x++)!\n");

int contador = 5;
Console.WriteLine($"contador vale {contador}");
Console.WriteLine($"Imprimo contador++: {contador++}  (usa 5, luego pasa a 6)");
Console.WriteLine($"Ahora contador vale: {contador}\n");

/*
TERCERA PARTE - Incremento prefix (++x).
  Suma 1 PRIMERO y luego usa el valor nuevo.
*/
Console.WriteLine("¡INCREMENTO PREFIX (++x)!\n");

int n = 5;
Console.WriteLine($"n vale {n}");
Console.WriteLine($"Imprimo ++n: {++n}  (primero suma, luego imprime 6)");
Console.WriteLine($"n sigue valiendo: {n}\n");

/*
CUARTA PARTE - Decremento y bucle tipico.
  En un for, i++ es el patron mas comun para avanzar de uno en uno.
*/
Console.WriteLine("¡DECREMENTO Y BUCLE TIPICO!\n");

int vidas = 3;
Console.Write("Vidas restantes: ");
while (vidas > 0)
{
    Console.Write($"{vidas} ");
    vidas--;  // postfix: resta 1 despues de usar el valor en la condicion del while
}
Console.WriteLine("(game over)\n");

int suma = 0;
for (int i = 1; i <= 5; i++)  // i++ al final de cada vuelta
{
    suma += i;
}
Console.WriteLine($"Suma del 1 al 5 con for e i++: {suma}");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
