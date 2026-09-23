/*
U01 — Introduccion a clases y objetos.

Una clase es la plantilla (el molde). Un objeto es una instancia concreta
creada con new. Cada objeto tiene su propio estado en memoria.

OBJETIVO:
  - Distinguir clase (plantilla) de objeto (instancia).
  - Crear objetos con new y acceder a sus miembros publicos.
  - Ver que varios objetos de la misma clase son independientes.
  - Entender que la clase define QUE datos tiene; el objeto guarda VALORES concretos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/



#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <set>
#include <fstream>
#include <sstream>
#include <regex>
#include <stdexcept>
#include <limits>
using namespace std;



void ImprimirMenu();

void DemoClaseVsObjeto();

void DemoVariosObjetos();

void DemoCrearConNew();



class Persona {
public:

    string Nombre;
    int Edad;
};



void ImprimirMenu()
    {
        cout << "=== U01 Introduccion a clases y objetos ===" << endl;
        cout << "1. Clase vs objeto" << endl;
        cout << "2. Varios objetos independientes" << endl;
        cout << "3. Crear con new" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Clase vs objeto: la clase Persona es el molde;
      cada new Persona() crea un objeto distinto en memoria.
    */
void DemoClaseVsObjeto()
    {
        cout << "¡DEMO — Clase vs objeto!\n" << endl;

        Persona alumno;
        alumno.Nombre = "Ana";
        alumno.Edad = 25;

        cout << "Objeto 1 -> Nombre: " << (alumno.Nombre) << ", Edad: " << (alumno.Edad) << endl;
        cout << "Tipo del objeto: " << (alumno"clase") << endl;
    }

/*
    SEGUNDA PARTE — Varios objetos de la misma clase.
      Cambiar uno NO cambia al otro: cada instancia tiene su propio estado.
    */
void DemoVariosObjetos()
    {
        cout << "¡DEMO — Varios objetos independientes!\n" << endl;

        Persona alumno;
        alumno.Nombre = "Ana";
        alumno.Edad = 25;

        Persona profesor;
        profesor.Nombre = "Agustin";
        profesor.Edad = 30;

        alumno.Edad = 26;

        cout << "Alumno: " << (alumno.Nombre) << ", " << (alumno.Edad) << " años" << endl;
        cout << "Profesor: " << (profesor.Nombre) << ", " << (profesor.Edad) << " años" << endl;
        cout << "Modificar alumno.Edad no afecta a profesor.Edad." << endl;
    }

/*
    TERCERA PARTE — new obligatorio para instanciar clases de referencia.
      Sin new solo tendrias la referencia vacia (nullptr), no un objeto usable.
    */
void DemoCrearConNew()
    {
        cout << "¡DEMO — Crear con new!\n" << endl;

        Persona invitado;
        invitado.Nombre = "Luis";
        invitado.Edad = 19;
        cout << "Invitado creado: " << (invitado.Nombre) << " (" << (invitado.Edad) << ")" << endl;
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
                    DemoCrearConNew();
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
