/*
U00 — Indice: herencia, polimorfismo, abstraccion e interfaces (UT6 u01).

OBJETIVO:
  - Ver el orden de estudio del subtema.
  - Saber que archivo abrir en cada paso.
  - Relacionar cada bloque con el equivalente C# / Java.

Orden pedagogico (como el indice Java, no el numero de carpeta Java):
  1. Herencia        -> U01_HerenciaIntro.cpp
  2. Polimorfismo    -> U02_PolimorfismoIntro.cpp
  3. Abstraccion     -> U03_AbstraccionIntro.cpp
  4. Interfaces      -> U04_InterfacesIntro.cpp

Ejercicios: E01-E10 en ejercicios/pendientes y ejercicios/resueltos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U00 Indice herencia / polimorfismo ===" << endl;
    cout << "1. Ver orden de estudio" << endl;
    cout << "2. Que archivo abrir en cada paso" << endl;
    cout << "3. Mapa C++ vs C# / Java" << endl;
    cout << "0. Salir" << endl;
}

void DemoOrdenEstudio()
{
    cout << "¡DEMO — Orden de estudio!\n" << endl;
    cout << "  1. Herencia       (: public, Base(...), virtual/override, protected)" << endl;
    cout << "  2. Polimorfismo   (puntero/referencia de base, dynamic_cast)" << endl;
    cout << "  3. Abstraccion    (metodos = 0; no se instancia la base)" << endl;
    cout << "  4. Interfaces     (clase con metodos virtuales puros + implementacion)" << endl;
    cout << "\nLuego practica con E01-E10." << endl;
}

void DemoQueAbrir()
{
    cout << "¡DEMO — Que archivo abrir!\n" << endl;
    cout << "  U01_HerenciaIntro.cpp      -> Animal / Perro / Gato" << endl;
    cout << "  U02_PolimorfismoIntro.cpp  -> Figura / Circulo / Rectangulo" << endl;
    cout << "  U03_AbstraccionIntro.cpp   -> Cuenta / CuentaAhorro / CuentaCredito" << endl;
    cout << "  U04_InterfacesIntro.cpp    -> IVolable / Pajaro / Avion" << endl;
    cout << "\nCompila cada archivo con:" << endl;
    cout << "  g++ -std=c++17 archivo.cpp -o demo" << endl;
    cout << "  ./demo   (o demo.exe en Windows)" << endl;
}

void DemoMapaCpp()
{
    cout << "¡DEMO — Mapa C++ vs C# / Java!\n" << endl;
    cout << "  Java extends / C# :          -> C++ class Hija : public Base" << endl;
    cout << "  Java super() / C# base()     -> C++ Hija(...) : Base(...) { }" << endl;
    cout << "  Java @Override / C# override -> C++ virtual en base + override en hija" << endl;
    cout << "  Java instanceof / C# is/as   -> C++ dynamic_cast<Hija*>(ptr)" << endl;
    cout << "  Java implements / C# : IXxx  -> C++ class Hija : public IXxx" << endl;
    cout << "  abstract metodo              -> C++ virtual tipo metodo() = 0;" << endl;
    cout << "  interface IVolable           -> C++ class IVolable { virtual ... = 0; }" << endl;
    cout << "  List<T> / array polimorfico  -> C++ vector<Base*> (o referencias)" << endl;
    cout << "  Console.WriteLine            -> C++ cout << ... << endl;" << endl;
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
                DemoOrdenEstudio();
                break;
            case 2:
                DemoQueAbrir();
                break;
            case 3:
                DemoMapaCpp();
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
