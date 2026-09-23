/*
OBJETIVO: Mezcla herencia + dynamic_cast: vector Animal* con Perro/Gato;
  detectar Perro con dynamic_cast y mostrar la raza. Menu do-while.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
using namespace std;

void ImprimirMenu()
{
    cout << "=== E09 Herencia + is/as (dynamic_cast) ===" << endl;
    cout << "1. Trabajar ejercicio" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "vector<Animal*> con Perro y Gato." << endl;
    cout << "Recorre: HacerSonido() en todos." << endl;
    cout << "Si dynamic_cast<Perro*>(a) != nullptr, muestra la raza." << endl;
}

void EjecutarEjercicio()
{
    // TODO: vector<Animal*> con Perro/Gato; HacerSonido; dynamic_cast para raza.
}

// TODO: Animal, Perro (con raza), Gato.

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
