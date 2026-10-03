/*
U01 — SDL: init, ventana, renderer (PDF tema 3).

Compila SIN SDL. Las llamadas reales van en comentarios.

OBJETIVO:
  - SDL_Init, CreateWindow, CreateRenderer.
  - Si window o renderer son nullptr: error (luego excepcion).
  - Al salir: DestroyRenderer, DestroyWindow, SDL_Quit.

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
    cout << "=== U01 SDL init ===" << endl;
    cout << "1. Secuencia de arranque" << endl;
    cout << "2. Llamadas reales (para pegar con SDL3)" << endl;
    cout << "0. Salir" << endl;
}

void DemoSecuencia()
{
    cout << "¡DEMO — Arranque (simulacion)!\n" << endl;
    cout << "1. SDL_Init(VIDEO)" << endl;
    cout << "2. Crear ventana 800x600" << endl;
    cout << "3. Crear renderer" << endl;
    cout << "4. Si algo es nullptr -> error" << endl;
    cout << "5. Al terminar: Destroy + SDL_Quit" << endl;
}

void DemoCodigo()
{
    cout << "¡DEMO — Codigo del PDF!\n" << endl;
    cout << "#include <SDL3/SDL.h>" << endl;
    cout << "SDL_Init(SDL_INIT_VIDEO);" << endl;
    cout << "window = SDL_CreateWindow(\"First test\", 800, 600, 0);" << endl;
    cout << "renderer = SDL_CreateRenderer(window, nullptr);" << endl;
    cout << "SDL_DestroyRenderer(renderer);" << endl;
    cout << "SDL_DestroyWindow(window);" << endl;
    cout << "SDL_Quit();" << endl;
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
                DemoSecuencia();
                break;
            case 2:
                DemoCodigo();
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
