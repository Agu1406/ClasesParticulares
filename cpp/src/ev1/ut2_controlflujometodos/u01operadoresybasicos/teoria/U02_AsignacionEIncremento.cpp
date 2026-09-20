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

#include <iostream>
using namespace std;

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - Asignacion compuesta.
      x += n  es atajo de  x = x + n  (igual con -= *= /= %=)
    */
    cout << "¡ASIGNACION COMPUESTA!\n" << endl;

    int saldo = 100;
    cout << "Saldo inicial: " << saldo << endl;
    saldo += 50;
    cout << "Tras cobrar 50 (+=): " << saldo << endl;
    saldo -= 30;
    cout << "Tras pagar 30 (-=): " << saldo << endl;

    int puntos = 10;
    puntos *= 3;
    cout << "Puntos x3 (*=): " << puntos << endl;

    int total = 20;
    total /= 4;
    cout << "Total /4 (/=): " << total << endl;

    int segundos = 125;
    segundos %= 60;
    cout << "125 seg % 60 (resto minutos): " << segundos << "\n" << endl;

    /*
    SEGUNDA PARTE - Incremento postfix (x++).
      Usa el valor actual y DESPUES suma 1.
    */
    cout << "¡INCREMENTO POSTFIX (x++)!\n" << endl;

    int contador = 5;
    cout << "contador vale " << contador << endl;
    cout << "Imprimo contador++: " << contador++ << "  (usa 5, luego pasa a 6)" << endl;
    cout << "Ahora contador vale: " << contador << "\n" << endl;

    /*
    TERCERA PARTE - Incremento prefix (++x).
      Suma 1 PRIMERO y luego usa el valor nuevo.
    */
    cout << "¡INCREMENTO PREFIX (++x)!\n" << endl;

    int n = 5;
    cout << "n vale " << n << endl;
    cout << "Imprimo ++n: " << ++n << "  (primero suma, luego imprime 6)" << endl;
    cout << "n sigue valiendo: " << n << "\n" << endl;

    /*
    CUARTA PARTE - Decremento y bucle tipico.
      En un for, i++ es el patron mas comun para avanzar de uno en uno.
    */
    cout << "¡DECREMENTO Y BUCLE TIPICO!\n" << endl;

    int vidas = 3;
    cout << "Vidas restantes: ";
    while (vidas > 0)
    {
        cout << vidas << " ";
        vidas--;  // postfix: resta 1 despues de usar el valor en la condicion del while
    }
    cout << "(game over)\n" << endl;

    int suma = 0;
    for (int i = 1; i <= 5; i++)  // i++ al final de cada vuelta
    {
        suma += i;
    }
    cout << "Suma del 1 al 5 con for e i++: " << suma << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
