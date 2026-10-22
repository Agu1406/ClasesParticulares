/*
OBJETIVO: Clase Libro con metodo ToString() que devuelve "Libro: titulo (autor)".

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
    string titulo;
    string autor;

public:
    Libro(string tituloInicial, string autorInicial)
    {
        titulo = tituloInicial;
        autor = autorInicial;
    }

    string getTitulo() const
    {
        return titulo;
    }

    string getAutor() const
    {
        return autor;
    }

    void setTitulo(string nuevoTitulo)
    {
        titulo = nuevoTitulo;
    }

    void setAutor(string nuevoAutor)
    {
        autor = nuevoAutor;
    }

    string ToString() const
    {
        return "Libro: " + titulo + " (" + autor + ")";
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
    Libro libro("1984", "George Orwell");
    cout << libro.ToString() << endl;
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
                cout << "Libro: ToString() debe devolver \"Libro: titulo (autor)\"." << endl;
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
