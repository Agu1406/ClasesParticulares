/*
OBJETIVO: Mini-repaso integrado: menu con 2-3 demos de jerarquia
  (herencia animales, figuras, o volables). Menu do-while.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
#include <cmath>
using namespace std;

void ImprimirMenu()
{
    cout << "=== E10 Mini-repaso integrado ===" << endl;
    cout << "1. Trabajar ejercicio" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "Integra al menos DOS de estas demos en el mismo archivo:" << endl;
    cout << "  A) Animal/Perro/Gato + HacerSonido" << endl;
    cout << "  B) vector<Figura*> + CalcularArea" << endl;
    cout << "  C) vector<IVolable*> + Despegar/Aterrizar" << endl;
    cout << "Opcion 1 del menu puede lanzar un submenu 1/2/3 de demos, o ejecutar las tres." << endl;
}

void EjecutarEjercicio()
{
    // TODO: Implementar 2-3 demos de jerarquia (submenu o secuencia).
}

// TODO: Clases de dominio necesarias para tus demos.

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
