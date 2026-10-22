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
    string nombre;
    double nota;

public:
    void SetNombre(string n)
    {
        nombre = n;
    }

    void SetNota(double n)
    {
        nota = n;
    }

    string GetNombre() const
    {
        return nombre;
    }

    double GetNota() const
    {
        return nota;
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
    Alumno alumno;
    alumno.SetNombre("Luis");
    alumno.SetNota(8.5);
    cout << alumno.GetNombre() << ": " << alumno.GetNota() << endl;
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
