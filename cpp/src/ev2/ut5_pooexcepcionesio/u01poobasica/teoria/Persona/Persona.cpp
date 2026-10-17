/*
Persona — Introduccion a clases y objetos.

Una clase es la plantilla (el molde). Un objeto es una instancia concreta.
En C++ junior el objeto vive en la pila: Persona alumno; sin new.

OBJETIVO:
  - Distinguir clase (plantilla) de objeto (instancia).
  - Crear objetos y acceder a sus miembros publicos.
  - Ver que varios objetos de la misma clase son independientes.
  - Entender que la clase define QUE datos tiene; el objeto guarda VALORES concretos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

class Persona
{
public:
    string nombre;
    int edad;
};

void ImprimirMenu()
{
    cout << "=== Persona: clase vs objeto ===" << endl;
    cout << "1. Clase vs objeto" << endl;
    cout << "2. Varios objetos independientes" << endl;
    cout << "3. Crear en la pila (sin new)" << endl;
    cout << "0. Salir" << endl;
}

/*
    PRIMERA PARTE — Clase vs objeto: Persona es el molde;
      cada Persona alumno; crea un objeto distinto.
    */
void DemoClaseVsObjeto()
{
    cout << "¡DEMO — Clase vs objeto!\n" << endl;

    Persona alumno;
    alumno.nombre = "Ana";
    alumno.edad = 25;

    cout << "Objeto 1 -> Nombre: " << alumno.nombre << ", Edad: " << alumno.edad << endl;
    cout << "El tipo del objeto es Persona (la clase)." << endl;
}

/*
    SEGUNDA PARTE — Varios objetos de la misma clase.
      Cambiar uno NO cambia al otro: cada instancia tiene su propio estado.
    */
void DemoVariosObjetos()
{
    cout << "¡DEMO — Varios objetos independientes!\n" << endl;

    Persona alumno;
    alumno.nombre = "Ana";
    alumno.edad = 25;

    Persona profesor;
    profesor.nombre = "Agustin";
    profesor.edad = 30;

    alumno.edad = 26;

    cout << "Alumno: " << alumno.nombre << ", " << alumno.edad << " anios" << endl;
    cout << "Profesor: " << profesor.nombre << ", " << profesor.edad << " anios" << endl;
    cout << "Modificar alumno.edad no afecta a profesor.edad." << endl;
}

/*
    TERCERA PARTE — En C++ junior se crea en la pila.
      Persona invitado; ya es un objeto usable. new se vera con punteros.
    */
void DemoCrearEnPila()
{
    cout << "¡DEMO — Crear en la pila!\n" << endl;

    Persona invitado;
    invitado.nombre = "Luis";
    invitado.edad = 19;
    cout << "Invitado creado: " << invitado.nombre << " (" << invitado.edad << ")" << endl;
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
                DemoClaseVsObjeto();
                break;
            case 2:
                DemoVariosObjetos();
                break;
            case 3:
                DemoCrearEnPila();
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
