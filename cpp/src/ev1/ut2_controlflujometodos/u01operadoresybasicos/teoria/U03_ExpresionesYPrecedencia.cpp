/*
U03 — Expresiones compuestas y precedencia de operadores.

OBJETIVO:
  - Evaluar expresiones con varios operadores respetando el orden.
  - Usar parentesis para forzar el orden deseado.
  - Recordar la diferencia entre division entera y decimal en expresiones mixtas.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <cmath>
using namespace std;

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - Precedencia basica.
      Orden tipico: parentesis > * / % > + -
      Ejemplo: 2 + 3 * 4  ->  2 + 12  ->  14  (no 20)
    */
    cout << "¡PRECEDENCIA SIN PARENTESIS!\n" << endl;

    int r1 = 2 + 3 * 4;
    cout << "2 + 3 * 4 = " << r1 << "  (primero 3*4, luego +2)" << endl;

    int r2 = 10 - 6 / 2;
    cout << "10 - 6 / 2 = " << r2 << "  (primero 6/2=3, luego 10-3)\n" << endl;

    /*
    SEGUNDA PARTE - Parentesis cambian el resultado.
    */
    cout << "¡PARENTESIS CAMBIAN EL RESULTADO!\n" << endl;

    int sinParentesis = 2 + 3 * 4;
    int conParentesis = (2 + 3) * 4;
    cout << "2 + 3 * 4     = " << sinParentesis << endl;
    cout << "(2 + 3) * 4   = " << conParentesis << endl;

    int media = (8 + 6 + 10) / 3;
    cout << "Media de 8, 6 y 10: (" << 8 << "+" << 6 << "+" << 10 << ")/3 = " << media << "\n" << endl;

    /*
    TERCERA PARTE - Expresion mixta con modulo y asignacion.
    */
    cout << "¡EXPRESION MIXTA!\n" << endl;

    int x = 5;
    int y = 2;
    int resultado = (x + y) * 3 - x % y;
    cout << "x=" << x << ", y=" << y << endl;
    cout << "(x + y) * 3 - x % y = (" << x << "+" << y << ")*3 - " << (x % y) << " = " << resultado << endl;

    int horasTotales = 47;
    int dias = horasTotales / 24;
    int horasSobrantes = horasTotales % 24;
    cout << horasTotales << " horas = " << dias << " dias y " << horasSobrantes << " horas\n" << endl;

    /*
    CUARTA PARTE - Division entera dentro de expresiones.
      7 / 2 con int da 3; con double da 3.5
    */
    cout << "¡INT VS DOUBLE EN EXPRESIONES!\n" << endl;

    cout << "7 / 2 (int)           = " << (7 / 2) << endl;
    cout << "7 / 2.0 (double)      = " << (7 / 2.0) << endl;
    cout << "7.0 / 2 (double)      = " << (7.0 / 2) << endl;
    cout << "(double)(7 / 2)       = " << (double)(7 / 2) << "  (cast despues: sigue 3.0)" << endl;
    cout << "round(7 / 2.0)        = " << round(7 / 2.0) << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
