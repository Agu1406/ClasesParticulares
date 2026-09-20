#include <iostream>
#include <cmath>
using namespace std;

/*
U03 — Operadores aritmeticos.

OBJETIVO:
  - Operar con + - * / %
  - Conocer pow de <cmath> para potencias (en C++ no existe **).
  - Distinguir division entera (int/int) de division decimal (double).
  - Guardar el resultado en una variable o usarlo solo al imprimir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    int a = 10;
    int b = 3;

    int resultadoS = a + b;
    int resultadoR = a - b;
    int resultadoM = a * b;
    int resultadoDr = a % b;                         // resto
    int resultadoDe = a / b;                         // division entera (int): 10/3 = 3
    double resultadoDc = static_cast<double>(a) / b; // division con decimales
    double resultadoPo = pow(a, b);                  // potencia

    cout << "¡IMPRIMIENDO OPERACIONES ARITMETICAS!\n" << endl;
    cout << "Suma: " << a << " + " << b << " = " << resultadoS << endl;
    cout << "Resta: " << a << " - " << b << " = " << resultadoR << endl;
    cout << "Multiplicacion: " << a << " x " << b << " = " << resultadoM << endl;
    cout << "Division entera (int): " << a << " / " << b << " = " << resultadoDe << endl;
    cout << "Division decimal: " << a << " / " << b << " = " << resultadoDc << endl;
    cout << "Modulo (resto): " << a << " % " << b << " = " << resultadoDr << endl;
    cout << "Potencia pow(" << a << ", " << b << ") = " << resultadoPo << endl;

    /*
    Dos escenarios habituales:
      1) Guardar el resultado para usarlo despues.
      2) Calcular solo al mostrar (sin variable intermedia).
    */
    cout << "\n¡GUARDAR vs IMPRIMIR DIRECTO!\n" << endl;
    int resultado = a + b;
    cout << "La suma de " << a << " y " << b << " da " << resultado << endl;
    cout << "La resta de " << a << " y " << b << " da " << (a - b) << endl;

    /*
    CUIDADO: int / int trunca. Si quieres decimales, convierte al menos un operando.
    */
    cout << "\n¡CUIDADO CON LA DIVISION ENTERA!\n" << endl;
    cout << "Sin cast: 10 / 3 = " << (10 / 3) << endl;
    cout << "Con 3.0: 10 / 3.0 = " << (10 / 3.0) << endl;
    cout << "Con static_cast<double>: " << (static_cast<double>(10) / 3) << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
