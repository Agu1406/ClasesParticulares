/*
U02 — catch especifico (excepciones nativas de C++).

Puedes encadenar varios catch. Se ejecuta el PRIMERO cuyo tipo coincide.
Lo mas concreto va antes; exception (base) al final.

Jerarquia basica de <stdexcept>:
  exception
    logic_error
      invalid_argument   <- stoi("doce")
      out_of_range       <- stoi("999...999") o vector.at(i)
      domain_error       <- hay que lanzarla (ej. raiz de negativo)
    runtime_error
      overflow_error     <- hay que lanzarla (el * de int NO lanza)

Division por 0 NO lanza sola: se comprueba y se hace throw runtime_error.
El mensaje se lee con e.what().

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
#include <stdexcept>
using namespace std;

int Dividir(int a, int b)
{
    if (b == 0)
    {
        throw runtime_error("No se puede dividir entre cero.");
    }
    return a / b;
}

double RaizNoNegativa(double x)
{
    if (x < 0)
    {
        throw domain_error("No hay raiz real de un numero negativo.");
    }
    return x;
}

int MultiplicarSinDesborde(int a, int b)
{
    if (a != 0 && b > 1000000000 / a)
    {
        throw overflow_error("El producto no cabe en un int.");
    }
    return a * b;
}

void ImprimirMenu()
{
    cout << "=== U02 catch especifico ===" << endl;
    cout << "1. invalid_argument (stoi texto raro)" << endl;
    cout << "2. out_of_range (stoi numero enorme)" << endl;
    cout << "3. out_of_range (vector.at)" << endl;
    cout << "4. runtime_error (division entre cero)" << endl;
    cout << "5. domain_error (raiz negativa)" << endl;
    cout << "6. overflow_error (producto enorme)" << endl;
    cout << "7. Varios catch en cadena" << endl;
    cout << "8. Sin errores" << endl;
    cout << "0. Salir" << endl;
}

void DemoInvalidArgument()
{
    cout << "¡DEMO — invalid_argument!\n" << endl;

    try
    {
        int valor = stoi("doce");
        cout << "Valor: " << valor << endl;
    }
    catch (const invalid_argument& e)
    {
        cout << "invalid_argument: el texto no es un entero. " << e.what() << endl;
    }
    catch (const exception& e)
    {
        cout << "Otro error: " << e.what() << endl;
    }
}

void DemoOutOfRangeStoi()
{
    cout << "¡DEMO — out_of_range con stoi!\n" << endl;

    try
    {
        int valor = stoi("99999999999999999999");
        cout << "Valor: " << valor << endl;
    }
    catch (const invalid_argument& e)
    {
        cout << "invalid_argument: " << e.what() << endl;
    }
    catch (const out_of_range& e)
    {
        cout << "out_of_range: el numero no cabe en un int. " << e.what() << endl;
    }
    catch (const exception& e)
    {
        cout << "Otro error: " << e.what() << endl;
    }
}

void DemoOutOfRangeAt()
{
    cout << "¡DEMO — out_of_range con vector.at!\n" << endl;

    try
    {
        vector<int> valores = { 10, 20, 30 };
        cout << valores.at(5) << endl;
    }
    catch (const out_of_range& e)
    {
        cout << "out_of_range: el indice no existe. " << e.what() << endl;
    }
    catch (const exception& e)
    {
        cout << "Otro error: " << e.what() << endl;
    }
}

void DemoRuntimeError()
{
    cout << "¡DEMO — runtime_error (division entre cero)!\n" << endl;

    try
    {
        cout << "Resultado: " << Dividir(12, 0) << endl;
    }
    catch (const runtime_error& e)
    {
        cout << "runtime_error: " << e.what() << endl;
    }
    catch (const exception& e)
    {
        cout << "Otro error: " << e.what() << endl;
    }
}

void DemoDomainError()
{
    cout << "¡DEMO — domain_error!\n" << endl;

    try
    {
        cout << "Raiz: " << RaizNoNegativa(-9) << endl;
    }
    catch (const domain_error& e)
    {
        cout << "domain_error: " << e.what() << endl;
    }
    catch (const exception& e)
    {
        cout << "Otro error: " << e.what() << endl;
    }
}

void DemoOverflowError()
{
    cout << "¡DEMO — overflow_error!\n" << endl;

    try
    {
        cout << "Producto: " << MultiplicarSinDesborde(1000000, 1000000) << endl;
    }
    catch (const overflow_error& e)
    {
        cout << "overflow_error: " << e.what() << endl;
    }
    catch (const exception& e)
    {
        cout << "Otro error: " << e.what() << endl;
    }
}

void DemoVariosCatch()
{
    cout << "¡DEMO — varios catch: el primero que coincida gana!\n" << endl;
    cout << "Orden: invalid_argument, out_of_range, domain_error," << endl;
    cout << "       overflow_error, runtime_error, exception.\n" << endl;

    try
    {
        vector<int> valores = { 1, 2 };
        cout << valores.at(9) << endl;
    }
    catch (const invalid_argument& e)
    {
        cout << "catch invalid_argument: " << e.what() << endl;
    }
    catch (const out_of_range& e)
    {
        cout << "catch out_of_range: " << e.what() << endl;
    }
    catch (const domain_error& e)
    {
        cout << "catch domain_error: " << e.what() << endl;
    }
    catch (const overflow_error& e)
    {
        cout << "catch overflow_error: " << e.what() << endl;
    }
    catch (const runtime_error& e)
    {
        cout << "catch runtime_error: " << e.what() << endl;
    }
    catch (const exception& e)
    {
        cout << "catch exception: " << e.what() << endl;
    }
}

void DemoSinErrores()
{
    cout << "¡DEMO — Sin errores!\n" << endl;

    try
    {
        int x = stoi("8");
        cout << "stoi ok: " << x << endl;
        cout << "Division: " << Dividir(x, 2) << endl;
        cout << "Raiz (dominio ok): " << RaizNoNegativa(9) << endl;
        cout << "Producto: " << MultiplicarSinDesborde(6, 7) << endl;
    }
    catch (const exception& e)
    {
        cout << "Error: " << e.what() << endl;
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
                DemoInvalidArgument();
                break;
            case 2:
                DemoOutOfRangeStoi();
                break;
            case 3:
                DemoOutOfRangeAt();
                break;
            case 4:
                DemoRuntimeError();
                break;
            case 5:
                DemoDomainError();
                break;
            case 6:
                DemoOverflowError();
                break;
            case 7:
                DemoVariosCatch();
                break;
            case 8:
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
