/*
OBJETIVO: Clase Circulo con radio y metodo CalcularArea(); muestra el area de r=5.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

class Circulo
{
    // TODO: atributo privado radio (double)
public:
    // TODO: constructor Circulo(double radioInicial)
    // TODO: metodo CalcularArea() que devuelva PI * radio * radio
};

void ImprimirMenu()
{
    cout << "=== EJERCICIO ===" << endl;
    cout << "1. Trabajar ejercicio" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarEjercicio()
{
    // TODO: crea un Circulo con radio 5 (sin new)
    // TODO: muestra el area con cout y CalcularArea()
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
                EjecutarEjercicio();
                break;
            case 2:
                cout << "Clase Circulo con radio y metodo CalcularArea(); muestra el area de r=5." << endl;
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
