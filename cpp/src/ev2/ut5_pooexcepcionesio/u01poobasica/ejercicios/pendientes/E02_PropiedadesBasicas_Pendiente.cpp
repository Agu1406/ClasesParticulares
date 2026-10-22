/*
OBJETIVO: Clase Alumno con atributos nombre y nota; getters/setters; crea un objeto y muestralo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

class Alumno
{
private:
    // TODO: atributo privado nombre (string)
    // TODO: atributo privado nota (double)
public:
    // TODO: setters SetNombre y SetNota
    // TODO: getters GetNombre y GetNota
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
    // TODO: crea un Alumno en la pila (sin new)
    // TODO: asigna nombre "Luis" y nota 8.5 con los setters
    // TODO: muestra ambos valores con los getters y cout
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
                cout << "Clase Alumno con atributos nombre y nota; getters y setters; crea un objeto y muestralo." << endl;
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
