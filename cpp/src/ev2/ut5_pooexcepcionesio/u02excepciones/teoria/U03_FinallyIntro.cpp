/*
U03 — Bloque finally.

finally se ejecuta SIEMPRE: haya excepcion o no, y tambien si catch la manejo.
Sirve para liberar recursos, cerrar ficheros o mostrar mensajes de cierre
que no deben omitirse aunque algo falle en try.

OBJETIVO:
  - Usar try / catch / finally en el mismo flujo.
  - Comprobar que finally corre tras un error capturado.
  - Comprobar que finally corre tambien cuando try termina bien.
  - Entender finally como codigo de "limpieza" garantizado.

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

void DemoFinallyTrasError();

void DemoFinallySinError();

void DemoFinallyComoCierre();



void ImprimirMenu()
    {
        cout << "=== U03 Bloque finally ===" << endl;
        cout << "1. Finally tras error" << endl;
        cout << "2. Finally sin error" << endl;
        cout << "3. Finally como cierre" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Error en try: catch se ejecuta y luego finally.
    */
void DemoFinallyTrasError()
    {
        cout << "¡DEMO — Finally tras error!\n" << endl;

        try
        {
            cout << "Entrando en try..." << endl;
            int a = 10;
            int b = 0;
            int resultado = a / b;
            cout << "Resultado: " << (resultado) << endl;
        }
        catch (DivideByZeroException)
        {
            cout << "Division entre cero detectada en catch." << endl;
        }
        finally
        {
            cout << "Bloque finally: siempre se ejecuta (tras error)." << endl;
        }
    }

/*
    SEGUNDA PARTE — try sin error: finally igualmente se ejecuta al final.
    */
void DemoFinallySinError()
    {
        cout << "¡DEMO — Finally sin error!\n" << endl;

        try
        {
            cout << "Entrando en try sin fallos..." << endl;
            int suma = 5 + 3;
            cout << "Suma correcta: " << (suma) << endl;
        }
        catch (DivideByZeroException)
        {
            cout << "Division entre cero detectada en catch." << endl;
        }
        finally
        {
            cout << "Bloque finally: siempre se ejecuta (sin error)." << endl;
        }
    }

/*
    TERCERA PARTE — Simular "cierre de operacion" en finally.
      En programas reales aqui cerrarias ficheros o conexiones.
    */
void DemoFinallyComoCierre()
    {
        cout << "¡DEMO — Finally como cierre!\n" << endl;

        bool operacionCompletada = false;

        try
        {
            int dato = int.Parse("42");
            operacionCompletada = true;
            cout << "Operacion OK con dato " << (dato) << endl;
        }
        catch (invalid_argument)
        {
            cout << "No se pudo completar la operacion." << endl;
        }
        finally
        {
            if (operacionCompletada)
            {
                cout << "Finally: liberando recursos (demo)." << endl;
            }
            else
            {
                cout << "Finally: limpieza tras fallo (demo)." << endl;
            }
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
                    DemoFinallyTrasError();
                    break;
                case 2:
                    DemoFinallySinError();
                    break;
                case 3:
                    DemoFinallyComoCierre();
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
