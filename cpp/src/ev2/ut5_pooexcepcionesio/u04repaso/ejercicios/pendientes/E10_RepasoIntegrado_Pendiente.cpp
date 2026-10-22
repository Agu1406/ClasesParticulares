/*
OBJETIVO: Repaso integrado: clase Contacto, guardar en "contacto.txt" con try/catch.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <fstream>
#include <stdexcept>
using namespace std;

class Contacto
{
public:
    // TODO: nombre y email (string)
    // TODO: constructor Contacto(string n, string e)
    // TODO: metodo ToLinea() que devuelva nombre + ";" + email
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
    // TODO: crea Contacto "Laura" / "laura@mail.com"
    // TODO: try: ofstream a contacto.txt; si !f throw runtime_error
    // TODO: escribe ToLinea(); catch y muestra error o confirmacion
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
                cout << "Repaso integrado: clase Contacto, guardar en contacto.txt con try/catch." << endl;
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
