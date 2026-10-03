/*
U07 — Interfaz .h vs implementacion .cpp (PDF POO).

OBJETIVO:
  - El alumno ve Vector2D.h + Vector2D.cpp. Aqui todo va en UN .cpp
    (regla junior del repo), pero se explica la separacion.
  - #ifndef / #define evitan incluir el .h dos veces.
  - El usuario solo hace #include "Vector2D.h".

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U07 .h y .cpp ===" << endl;
    cout << "1. Que va en cada fichero" << endl;
    cout << "2. Include guards" << endl;
    cout << "0. Salir" << endl;
}

void DemoFicheros()
{
    cout << "¡DEMO — Separacion!\n" << endl;
    cout << "Vector2D.h  : class Vector2D { declaraciones };" << endl;
    cout << "Vector2D.cpp: #include \"Vector2D.h\" y el codigo de los metodos." << endl;
    cout << "main.cpp    : #include \"Vector2D.h\" y usa la clase." << endl;
    cout << "En estas clases junior compilamos UN solo .cpp con la clase dentro." << endl;
}

void DemoGuards()
{
    cout << "¡DEMO — #ifndef!\n" << endl;
    cout << "#ifndef VECTOR2D_H_" << endl;
    cout << "#define VECTOR2D_H_" << endl;
    cout << "  ... class ..." << endl;
    cout << "#endif" << endl;
    cout << "Si dos .cpp incluyen el mismo .h, el compilador no duplica la clase." << endl;
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
                DemoFicheros();
                break;
            case 2:
                DemoGuards();
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
