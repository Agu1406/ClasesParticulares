/*
U01 — Operadores aritmeticos y vision general.

OBJETIVO:
  - Repasar los cinco operadores aritmeticos basicos (+, -, *, /, %).
  - Diferenciar division entera (int) y division decimal (double).
  - Conocer el modulo (%) para restos y paridad.
  - Anticipar asignacion compuesta, incremento y precedencia (clases siguientes).

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
    PRIMERA PARTE - Operadores aritmeticos con enteros.
      + suma    - resta    * producto    / cociente    % resto (modulo)
    */
    cout << "¡OPERADORES ARITMETICOS (int)!\n" << endl;

    int a = 17;
    int b = 5;

    cout << "a = " << a << ", b = " << b << endl;
    cout << "Suma:       " << a << " + " << b << " = " << (a + b) << endl;
    cout << "Resta:      " << a << " - " << b << " = " << (a - b) << endl;
    cout << "Producto:   " << a << " * " << b << " = " << (a * b) << endl;
    cout << "Division:   " << a << " / " << b << " = " << (a / b) << "  (entera: descarta decimales)" << endl;
    cout << "Modulo:     " << a << " % " << b << " = " << (a % b) << "  (resto de la division)\n" << endl;

    /*
    SEGUNDA PARTE - Division entera vs decimal.
      Si ambos operandos son int, / es entera.
      Si al menos uno es double, el resultado es decimal.
    */
    cout << "¡DIVISION ENTERA VS DECIMAL!\n" << endl;

    int total = 10;
    int personas = 3;
    cout << "Repartir " << total << " galletas entre " << personas << " personas:" << endl;
    cout << "  Entera:  " << total << " / " << personas << " = " << (total / personas) << " galletas por persona" << endl;
    cout << "  Decimal: " << total << " / " << personas << ".0 = " << (total / (double)personas) << " galletas por persona\n" << endl;

    double precio = 7.50;
    int unidades = 4;
    cout << "Precio unitario " << precio << " x " << unidades << " = " << (precio * unidades) << " euros\n" << endl;

    /*
    TERCERA PARTE - Modulo en situaciones reales.
      % devuelve el resto. Sirve para saber si un numero es par o multiplo.
    */
    cout << "¡MODULO EN LA PRACTICA!\n" << endl;

    int minutos = 127;
    int horas = minutos / 60;
    int minutosRestantes = minutos % 60;
    cout << minutos << " minutos = " << horas << " h y " << minutosRestantes << " min" << endl;

    int numero = 14;
    cout << boolalpha;
    cout << "¿" << numero << " es par? " << (numero % 2 == 0) << endl;
    numero = 7;
    cout << "¿" << numero << " es par? " << (numero % 2 == 0) << "\n" << endl;

    /*
    CUARTA PARTE - Vision general de la unidad.
      En las siguientes clases veremos += -= ++ -- y precedencia de operadores.
    */
    cout << "¡VISTA PREVIA DE LA UNIDAD!\n" << endl;
    cout << "Asignacion compuesta:  x += 3  equivale a  x = x + 3" << endl;
    cout << "Incremento:            contador++  suma 1 al valor" << endl;
    cout << "Precedencia:           (2 + 3) * 4  no es lo mismo que  2 + 3 * 4" << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
