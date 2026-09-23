/*
OBJETIVO: Crear Animal (base) y Perro (subclase) con HacerSonido virtual/override.
  Demo: un Perro dice Guau. Menu do-while: completar desde un menu interactivo con opcion 0 para salir.

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
    cout << "=== E01 Herencia Animal / Perro ===" << endl;
    cout << "1. Trabajar ejercicio" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "Clase Animal con nombre (protected) y HacerSonido virtual." << endl;
    cout << "Subclase Perro : public Animal que hace override y dice Guau." << endl;
    cout << "Crea un Perro y llama a HacerSonido()." << endl;
}

void EjecutarEjercicio()
{
    // TODO: Crear un Perro y llamar a HacerSonido().
}

// TODO: class Animal { protected: string nombre; virtual void HacerSonido(); };
// TODO: class Perro : public Animal { void HacerSonido() override; };

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
                MostrarObjetivo();
                break;
            case 0:
                cout << "Saliendo..." << endl;
                break;
            default:
                cout << "Opcion no valida. Intenta de nuevo." << endl;
                break;
        }

        cout << endl;
    } while (opcion != 0);

    return 0;
}
