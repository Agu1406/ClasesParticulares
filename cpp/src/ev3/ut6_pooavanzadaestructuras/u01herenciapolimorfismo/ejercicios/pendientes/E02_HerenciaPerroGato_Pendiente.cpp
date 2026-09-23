/*
OBJETIVO: Anadir Gato a la jerarquia Animal y demostrar Base(...) + dos sonidos distintos.
  Menu do-while: completar desde un menu interactivo con opcion 0 para salir.

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
    cout << "=== E02 Herencia Perro y Gato ===" << endl;
    cout << "1. Trabajar ejercicio" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "Jerarquia Animal <- Perro, Gato." << endl;
    cout << "Ambas llaman Animal(nombre) en el constructor (: Animal(nombre))." << endl;
    cout << "Crea un Perro y un Gato; llama a HacerSonido() en cada uno." << endl;
}

void EjecutarEjercicio()
{
    // TODO: Crear Perro y Gato; llamar HacerSonido() en ambos.
}

// TODO: Animal, Perro, Gato con virtual/override y : Animal(nombre).

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
