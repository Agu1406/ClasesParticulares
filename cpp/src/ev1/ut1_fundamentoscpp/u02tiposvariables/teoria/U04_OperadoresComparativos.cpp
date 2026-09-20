#include <iostream>
#include <string>
using namespace std;

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

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;
    cout << boolalpha;

    double ingresosMesAnterior = 1400.56;
    double ingresosMesActual = 2345.12;
    double valorPiAyer = 3.1416;
    double valorPiHoy = 3.1416;

    // == igualdad
    cout << "¡PRUEBA IGUALDAD (==)!\n" << endl;
    bool respuesta = ingresosMesActual == ingresosMesAnterior;
    cout << "¿Ingresos mes actual == mes anterior? " << respuesta << endl;
    respuesta = valorPiAyer == valorPiHoy;
    cout << "¿PI de ayer == PI de hoy? " << respuesta << "\n" << endl;

    // != desigualdad
    cout << "¡PRUEBA DESIGUALDAD (!=)!\n" << endl;
    cout << "¿Ingresos distintos? " << (ingresosMesActual != ingresosMesAnterior) << endl;
    cout << "¿PI distinto? " << (valorPiAyer != valorPiHoy) << "\n" << endl;

    // >
    cout << "¡PRUEBA MAYOR (>)!\n" << endl;
    cout << "¿Ingresos actuales > anteriores? " << (ingresosMesActual > ingresosMesAnterior) << endl;
    cout << "¿PI ayer > PI hoy? " << (valorPiAyer > valorPiHoy) << "\n" << endl;

    // <
    cout << "¡PRUEBA MENOR (<)!\n" << endl;
    cout << "¿Ingresos actuales < anteriores? " << (ingresosMesActual < ingresosMesAnterior) << endl;
    cout << "¿PI ayer < PI hoy? " << (valorPiAyer < valorPiHoy) << "\n" << endl;

    // >= y <=
    cout << "¡PRUEBA MAYOR O IGUAL (>=) Y MENOR O IGUAL (<=)!\n" << endl;
    int nota = 5;
    cout << "nota (" << nota << ") >= 5 ? " << (nota >= 5) << endl;
    cout << "nota (" << nota << ") <= 4 ? " << (nota <= 4) << endl;
    cout << "nota (" << nota << ") >= 10 ? " << (nota >= 10) << "\n" << endl;

    // Comparacion de strings
    cout << "¡COMPARAR STRINGS!\n" << endl;
    string ciudadA = "Sevilla";
    string ciudadB = "Sevilla";
    string ciudadC = "Madrid";
    cout << "\"" << ciudadA << "\" == \"" << ciudadB << "\" ? " << (ciudadA == ciudadB) << endl;
    cout << "\"" << ciudadA << "\" == \"" << ciudadC << "\" ? " << (ciudadA == ciudadC) << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
