/*
U02 — Arrays y bucles.

OBJETIVO:
  - Recorrer un array con for clasico usando el indice i y una constante de tamano.
  - Recorrer un array con for (int nota : notas) sin manejar indices (range-for).
  - Comparar cuando conviene cada bucle.
  - Usar siempre llaves { } en los bucles.
  - Practicar funciones + main + menu do-while (EV1).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U02 Arrays y bucles ===" << endl;
    cout << "1. Recorrido con for" << endl;
    cout << "2. Recorrido con range-for" << endl;
    cout << "3. Contar aprobados con for" << endl;
    cout << "4. range-for con string[]" << endl;
    cout << "0. Salir" << endl;
}

/*
PRIMERA PARTE — Recorrido con for.
  const int N = 5; sustituye a .Length de C#/Java.
  for (int i = 0; i < N; i++) recorre de 0 hasta N - 1.
  Util cuando necesitas la posicion (indice) de cada elemento.
*/
void DemoFor()
{
    cout << "¡DEMO — Recorrido con for!\n" << endl;
    const int N = 5;
    int notas[N] = {7, 8, 6, 9, 5};

    for (int i = 0; i < N; i++)
    {
        cout << "  Posicion " << i << ": nota = " << notas[i] << endl;
    }
}

/*
SEGUNDA PARTE — Recorrido con range-for (el "foreach" de C++).
  for (int nota : notas) lee cada valor directamente.
  Mas legible cuando solo necesitas el contenido, no el indice.
*/
void DemoForeach()
{
    cout << "¡DEMO — Recorrido con range-for!\n" << endl;
    int notas[] = {7, 8, 6, 9, 5};

    for (int nota : notas)
    {
        cout << "  Nota: " << nota << endl;
    }
}

/*
TERCERA PARTE — for con logica extra (contar aprobados).
  El for permite usar el indice para condiciones adicionales.
*/
void DemoContarAprobados()
{
    cout << "¡DEMO — Contar aprobados con for!\n" << endl;
    const int N = 5;
    int notas[N] = {7, 8, 6, 9, 5};

    int aprobados = 0;
    for (int i = 0; i < N; i++)
    {
        if (notas[i] >= 5)
        {
            aprobados++;
            cout << "  Aprobado en posicion " << i << ": " << notas[i] << endl;
        }
    }

    cout << "Total aprobados: " << aprobados << endl;
}

/*
CUARTA PARTE — range-for sobre array de string.
*/
void DemoForeachString()
{
    cout << "¡DEMO — range-for con string[]!\n" << endl;
    string alumnos[] = {"Ana", "Luis", "Eva"};

    for (string nombre : alumnos)
    {
        cout << "  Alumno: " << nombre << endl;
    }
}

int main()
{
    int opcion;
    do
    {
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        cout << endl;

        switch (opcion)
        {
            case 1:
                DemoFor();
                break;
            case 2:
                DemoForeach();
                break;
            case 3:
                DemoContarAprobados();
                break;
            case 4:
                DemoForeachString();
                break;
            case 0:
                cout << "Saliendo..." << endl;
                break;
            default:
                cout << "Opcion no valida." << endl;
                break;
        }

        cout << endl;
    } while (opcion != 0);
    return 0;
}
