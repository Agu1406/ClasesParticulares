/*
U03 — Constructores con parametros.

El constructor es un metodo especial con el mismo nombre que la clase.
Se ejecuta automaticamente al hacer new y permite inicializar el objeto
con valores desde el principio, sin asignar propiedad por propiedad.

OBJETIVO:
  - Usar constructores con parametros para inicializar objetos al crearlos.
  - Evitar objetos "vacios" cuando ya conoces los datos minimos.
  - Crear varias instancias pasando argumentos distintos.
  - Entender que new Libro(...) llama al constructor antes de usar el objeto.

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

void DemoConstructor();

void DemoSegundoLibro();

void DemoCambiosTrasConstruccion();



class Libro {
public:

    string Titulo;
    string Autor;

    Libro(string titulo, string autor)
    {
        Titulo = titulo;
        Autor = autor;
    };
}



void ImprimirMenu()
    {
        cout << "=== U03 Constructores ===" << endl;
        cout << "1. Constructor con parametros" << endl;
        cout << "2. Segundo libro" << endl;
        cout << "3. Cambios tras la construccion" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Constructor con dos parametros.
      El objeto nace ya con Titulo y Autor asignados.
    */
void DemoConstructor()
    {
        cout << "¡DEMO — Constructor con parametros!\n" << endl;

        Libro libro1 = new Libro("C# basico", "Agustin Marquez");
        cout << "Titulo: " << (libro1.Titulo) << endl;
        cout << "Autor: " << (libro1.Autor) << endl;
    }

/*
    SEGUNDA PARTE — Otra instancia con otros argumentos.
      Cada new ejecuta el constructor otra vez con valores nuevos.
    */
void DemoSegundoLibro()
    {
        cout << "¡DEMO — Segundo libro!\n" << endl;

        Libro libro2 = new Libro("POO en C#", "Equipo editorial");
        cout << (libro2.Titulo) << " de " << (libro2.Autor) << endl;
    }

/*
    TERCERA PARTE — Modificar propiedades despues de construir (si tienen set).
      El constructor da el estado inicial; luego puedes cambiar lo permitido.
    */
void DemoCambiosTrasConstruccion()
    {
        cout << "¡DEMO — Cambios tras la construccion!\n" << endl;

        Libro libro1 = new Libro("C# basico", "Agustin Marquez");
        libro1.Titulo = "C# basico (2ª edicion)";
        cout << "Titulo actualizado: " << (libro1.Titulo) << endl;
        cout << "Autor sin cambios: " << (libro1.Autor) << endl;
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
                    DemoConstructor();
                    break;
                case 2:
                    DemoSegundoLibro();
                    break;
                case 3:
                    DemoCambiosTrasConstruccion();
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
