/*
U01 — try/catch basico.

Cuando una operacion puede fallar en tiempo de ejecucion (parse invalido,
acceso nulo, division...), el bloque try ejecuta el codigo "riesgoso" y
catch captura la excepcion para que el programa no se cierre abruptamente.

OBJETIVO:
  - Envolver codigo peligroso en try { }.
  - Capturar Exception generica en catch y mostrar ex.Message.
  - Ver que el programa continua despues del catch.
  - Contrastar un caso que falla con otro que funciona dentro del mismo try/catch.

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

void DemoParseInvalido();

void DemoParseValido();

void DemoArrayIndice();



void ImprimirMenu()
    {
        cout << "=== U01 try/catch basico ===" << endl;
        cout << "1. Parse invalido" << endl;
        cout << "2. Parse valido" << endl;
        cout << "3. Indice fuera de rango" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Parse que falla: int.Parse("abc") lanza excepcion.
      Sin catch el programa terminaria; con catch mostramos el error y seguimos.
    */
void DemoParseInvalido()
    {
        cout << "¡DEMO — try/catch con parse invalido!\n" << endl;

        try
        {
            int numero = int.Parse("abc");
            cout << "Numero convertido: " << (numero) << endl;
        }
        catch (exception& ex)
        {
            cout << "Error capturado: " << (ex.Message) << endl;
            cout << "Tipo de excepcion: " << (ex"clase") << endl;
        }

        cout << "El programa sigue ejecutandose tras el catch." << endl;
    }

/*
    SEGUNDA PARTE — Mismo patron con entrada valida: no entra en catch.
    */
void DemoParseValido()
    {
        cout << "¡DEMO — try/catch con parse valido!\n" << endl;

        try
        {
            int edad = int.Parse("25");
            cout << "Edad leida correctamente: " << (edad) << endl;
        }
        catch (exception& ex)
        {
            cout << "Error capturado: " << (ex.Message) << endl;
        }
    }

/*
    TERCERA PARTE — Otra operacion riesgosa: indice fuera de rango en array.
      exception es la clase base: atrapa casi cualquier fallo.
    */
void DemoArrayIndice()
    {
        cout << "¡DEMO — try/catch con array!\n" << endl;

        try
        {
            vector<int> valores = { 10, 20, 30 };
            cout << valores[5] << endl;
        }
        catch (exception& ex)
        {
            cout << "Error capturado: " << (ex.Message) << endl;
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
                    DemoParseInvalido();
                    break;
                case 2:
                    DemoParseValido();
                    break;
                case 3:
                    DemoArrayIndice();
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
