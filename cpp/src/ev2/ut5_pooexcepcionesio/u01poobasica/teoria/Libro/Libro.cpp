/*
Libro — Constructores con parametros.

El constructor es un metodo especial con el mismo nombre que la clase.
Se ejecuta al crear el objeto y permite inicializarlo de golpe,
sin asignar campo por campo.

OBJETIVO:
  - Usar constructores con parametros para inicializar objetos al crearlos.
  - Evitar objetos "vacios" cuando ya conoces los datos minimos.
  - Crear varias instancias pasando argumentos distintos.

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
public:
    string titulo;
    string autor;

    Libro(string titulo, string autor)
    {
        this->titulo = titulo;
        this->autor = autor;
    }
};

void ImprimirMenu()
{
    cout << "=== Libro: constructores ===" << endl;
    cout << "1. Constructor con parametros" << endl;
    cout << "2. Segundo libro" << endl;
    cout << "3. Cambios tras la construccion" << endl;
    cout << "0. Salir" << endl;
}

/*
    PRIMERA PARTE — Constructor con dos parametros.
      El objeto nace ya con titulo y autor asignados.
    */
void DemoConstructor()
{
    cout << "¡DEMO — Constructor con parametros!\n" << endl;

    Libro libro1("C++ basico", "Agustin Marquez");
    cout << "Titulo: " << libro1.titulo << endl;
    cout << "Autor: " << libro1.autor << endl;
}

/*
    SEGUNDA PARTE — Otra instancia con otros argumentos.
      Cada creacion ejecuta el constructor otra vez con valores nuevos.
    */
void DemoSegundoLibro()
{
    cout << "¡DEMO — Segundo libro!\n" << endl;

    Libro libro2("POO en C++", "Equipo editorial");
    cout << libro2.titulo << " de " << libro2.autor << endl;
}

/*
    TERCERA PARTE — Modificar campos despues de construir.
      El constructor da el estado inicial; luego puedes cambiar lo publico.
    */
void DemoCambiosTrasConstruccion()
{
    cout << "¡DEMO — Cambios tras la construccion!\n" << endl;

    Libro libro1("C++ basico", "Agustin Marquez");
    libro1.titulo = "C++ basico (2a edicion)";
    cout << "Titulo actualizado: " << libro1.titulo << endl;
    cout << "Autor sin cambios: " << libro1.autor << endl;
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
