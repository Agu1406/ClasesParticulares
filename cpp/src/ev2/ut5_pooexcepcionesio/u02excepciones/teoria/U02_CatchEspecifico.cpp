/*
U02 — catch especifico (FormatException, DivideByZeroException).

Puedes encadenar varios catch. C# ejecuta el PRIMERO cuyo tipo coincide
con la excepcion lanzada. Lo mas concreto va antes; Exception generica al final.

OBJETIVO:
  - Capturar FormatException cuando el texto no es un numero valido.
  - Capturar DivideByZeroException al dividir entre cero.
  - Ordenar catch de mas especifico a mas general.
  - Probar dos escenarios distintos en demos separadas.

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

void DemoDivisionCero();

void DemoFormatoInvalido();

void DemoSinErrores();



void ImprimirMenu()
    {
        cout << "=== U02 catch especifico ===" << endl;
        cout << "1. Division entre cero" << endl;
        cout << "2. Formato invalido" << endl;
        cout << "3. Sin errores" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Division entre cero: DivideByZeroException.
      int.Parse("12") funciona; el fallo ocurre en a / b con b = 0.
    */
void DemoDivisionCero()
    {
        cout << "¡DEMO — Division entre cero!\n" << endl;

        try
        {
            int a = int.Parse("12");
            int b = 0;
            cout << "Resultado: " << (a / b) << endl;
        }
        catch (invalid_argument)
        {
            cout << "Formato invalido al convertir texto a numero." << endl;
        }
        catch (DivideByZeroException)
        {
            cout << "No se puede dividir entre cero." << endl;
        }
        catch (exception& ex)
        {
            cout << "Otro error: " << (ex.Message) << endl;
        }
    }

/*
    SEGUNDA PARTE — Texto no numerico: invalid_argument.
      El orden importa: si exception fuera primero, atraparia todo y los demas no servirian.
    */
void DemoFormatoInvalido()
    {
        cout << "¡DEMO — Formato invalido!\n" << endl;

        try
        {
            int valor = int.Parse("doce");
            cout << "Valor: " << (valor) << endl;
        }
        catch (invalid_argument)
        {
            cout << "Formato invalido: el texto no representa un entero." << endl;
        }
        catch (DivideByZeroException)
        {
            cout << "No se puede dividir entre cero." << endl;
        }
        catch (exception& ex)
        {
            cout << "Otro error: " << (ex.Message) << endl;
        }
    }

/*
    TERCERA PARTE — Caso correcto: ningun catch se ejecuta.
    */
void DemoSinErrores()
    {
        cout << "¡DEMO — Sin errores!\n" << endl;

        try
        {
            int x = int.Parse("8");
            int y = 2;
            cout << "Division correcta: " << (x / y) << endl;
        }
        catch (invalid_argument)
        {
            cout << "Formato invalido al convertir texto a numero." << endl;
        }
        catch (DivideByZeroException)
        {
            cout << "No se puede dividir entre cero." << endl;
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
                    DemoDivisionCero();
                    break;
                case 2:
                    DemoFormatoInvalido();
                    break;
                case 3:
                    DemoSinErrores();
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
