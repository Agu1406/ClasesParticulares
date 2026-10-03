/*
U03 — Eventos y estado del teclado.

OBJETIVO:
  - Cola de eventos. SDL_PollEvent(&event) saca uno.
  - type: QUIT, KEY_DOWN, MOUSE_BUTTON_UP...
  - Alternativa: SDL_GetKeyboardState / GetMouseState.
  - Hay que consumir eventos para que el estado se actualice.

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
    cout << "=== U03 Eventos ===" << endl;
    cout << "1. PollEvent (simulacion)" << endl;
    cout << "2. Tipos del PDF" << endl;
    cout << "0. Salir" << endl;
}

void DemoPoll()
{
    cout << "¡DEMO — Cola (consola)!\n" << endl;
    cout << "Escribe q para QUIT, w para KEY_UP, s para KEY_DOWN." << endl;
    bool exitLoop = false;
    while (!exitLoop)
    {
        cout << "evento => ";
        string ev;
        cin >> ev;
        if (ev == "q")
        {
            cout << "SDL_EVENT_QUIT" << endl;
            exitLoop = true;
        }
        else if (ev == "w")
        {
            cout << "SDL_EVENT_KEY_DOWN  SDLK_UP" << endl;
        }
        else if (ev == "s")
        {
            cout << "SDL_EVENT_KEY_DOWN  SDLK_DOWN" << endl;
        }
        else
        {
            cout << "(otro evento, se ignora)" << endl;
        }
    }
}

void DemoTipos()
{
    cout << "¡DEMO — API!\n" << endl;
    cout << "while (SDL_PollEvent(&event)) {" << endl;
    cout << "  switch (event.type) {" << endl;
    cout << "    case SDL_EVENT_QUIT: exit = true;" << endl;
    cout << "    case SDL_EVENT_KEY_DOWN: event.key.key == SDLK_DOWN" << endl;
    cout << "  }" << endl;
    cout << "}" << endl;
    cout << "const bool* keys = SDL_GetKeyboardState(nullptr);" << endl;
    cout << "if (keys[SDL_SCANCODE_SPACE]) { ... }" << endl;
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
                DemoPoll();
                break;
            case 2:
                DemoTipos();
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
