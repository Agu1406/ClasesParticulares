/*
U02 — Arrays y bucles.

OBJETIVO:
  - Recorrer un array con for clasico usando el indice i.
  - Recorrer un array con foreach sin manejar indices.
  - Comparar cuando conviene cada bucle.
  - Usar siempre llaves { } en for y foreach.
  - Practicar class + Main + menu do-while (EV1).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/



#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <set>
#include <fstream>
#include <sstream>
#include <regex>
#include <stdexcept>
#include <limits>
using namespace std;



void ImprimirMenu();

void DemoFor();

void DemoForeach();

void DemoContarAprobados();

void DemoForeachString();



void ImprimirMenu()
    {
        cout << "=== U02 Arrays y bucles ===" << endl;
        cout << "1. Recorrido con for" << endl;
        cout << "2. Recorrido con foreach" << endl;
        cout << "3. Contar aprobados con for" << endl;
        cout << "4. foreach con vector<string>" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Recorrido con for.
      for (int i = 0; i < notas.size(); i++) recorre de 0 hasta Length - 1.
      Util cuando necesitas la posicion (indice) de cada elemento.
    */
void DemoFor()
    {
        cout << "¡DEMO — Recorrido con for!\n" << endl;
        vector<int> notas = { 7, 8, 6, 9, 5 };

        for (int i = 0; i < notas.size(); i++)
        {
            cout << "  Posicion " << i << ": nota = " << notas[i] << endl;
        }
    }

/*
    SEGUNDA PARTE — Recorrido con foreach.
      for (int nota : notas) lee cada valor directamente.
      Mas legible cuando solo necesitas el contenido, no el indice.
    */
void DemoForeach()
    {
        cout << "¡DEMO — Recorrido con foreach!\n" << endl;
        vector<int> notas = { 7, 8, 6, 9, 5 };

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
        vector<int> notas = { 7, 8, 6, 9, 5 };

        int aprobados = 0;
        for (int i = 0; i < notas.size(); i++)
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
    CUARTA PARTE — foreach sobre array de string.
    */
void DemoForeachString()
    {
        cout << "¡DEMO — foreach con vector<string>!\n" << endl;
        vector<string> alumnos = { "Ana", "Luis", "Eva" };

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
