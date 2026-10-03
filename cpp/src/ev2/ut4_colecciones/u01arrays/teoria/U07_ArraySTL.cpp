/*
U07 — array de la STL (el contenedor array del PDF).

OBJETIVO:
  - Ver array<int,3> de <array>: tamano FIJO, pero con size() y range-for.
  - Compararlo con int datos[3]: mismo tamano, el clasico NO guarda la longitud.
  - Recorrer con for (i < datos.size()) y con for (int elem : datos).
  - Esto NO es vector: no hay push_back. El tamano va en el tipo: array<int,3>.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <array>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U07 array de la STL ===" << endl;
    cout << "1. Array clasico vs array<int,3>" << endl;
    cout << "2. size() y recorrido" << endl;
    cout << "3. Modificar por indice" << endl;
    cout << "4. El clasico no se puede asignar" << endl;
    cout << "0. Salir" << endl;
}

void DemoComparacion()
{
    cout << "¡DEMO — Clasico vs STL!\n" << endl;

    int clasico[3] = {10, 20, 30};
    array<int, 3> stl = {10, 20, 30};

    cout << "clasico[1] = " << clasico[1] << endl;
    cout << "stl[1]     = " << stl[1] << endl;
    cout << "stl.size() = " << stl.size() << " (el clasico no tiene .size())." << endl;
}

void DemoSizeYRecorrido()
{
    cout << "¡DEMO — size() y range-for!\n" << endl;

    array<int, 3> datos = {10, 20, 30};

    for (int i = 0; i < (int)datos.size(); i++)
    {
        cout << "  datos[" << i << "] = " << datos[i] << endl;
    }

    cout << "Range-for:" << endl;
    for (int elem : datos)
    {
        cout << "  " << elem << endl;
    }
}

void DemoModificar()
{
    cout << "¡DEMO — Modificar!\n" << endl;

    array<int, 3> datos = {10, 20, 30};
    for (int i = 0; i < (int)datos.size(); i++)
    {
        datos[i] = datos[i] + 1;
    }

    for (int elem : datos)
    {
        cout << "  " << elem << endl;
    }
}

void DemoNoAsignarClasico()
{
    cout << "¡DEMO — El array clasico no se asigna!\n" << endl;
    cout << "int unos[] = {1, 1, 1};" << endl;
    cout << "int dos[3];" << endl;
    cout << "dos = unos;  // ERROR de compilacion (el nombre es un puntero constante)." << endl;
    cout << "Hay que copiar celda a celda, o usar array / vector." << endl;
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
                DemoComparacion();
                break;
            case 2:
                DemoSizeYRecorrido();
                break;
            case 3:
                DemoModificar();
                break;
            case 4:
                DemoNoAsignarClasico();
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
