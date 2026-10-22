/*
OBJETIVO: Clase Libro con constructor (titulo, autor); crea un objeto y muestralo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

class Libro
{
private:
    string titulo;
    string autor;

public:
    Libro(string t, string a)
    {
        titulo = t;
        autor = a;
    }

    string GetTitulo() const
    {
        return titulo;
    }

    string GetAutor() const
    {
        return autor;
    }
};

void ImprimirMenu()
{
    cout << "=== EJERCICIO ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarEjercicio()
{
    Libro libro("El principito", "Antoine de Saint-Exupery");
    cout << libro.GetTitulo() << " - " << libro.GetAutor() << endl;
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
                cout << "Clase Libro con constructor (titulo, autor); crea un objeto y muestralo." << endl;
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
