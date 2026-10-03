/*
U04 — Tiempo del juego (ticks, delay, frame).

OBJETIVO:
  - SDL_GetTicks() = ms desde el init.
  - SDL_Delay(ms) duerme (el PDF lo usa; aqui no dormimos al alumno).
  - Alternativa 1: update + delay del resto del FRAME_PERIOD.
  - Alternativa 2: render siempre, update solo si paso el periodo.
  - 1bis: update(delta) para no atar la velocidad al periodo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U04 Tiempo ===" << endl;
    cout << "1. Bucle handle / update / render" << endl;
    cout << "2. Las tres alternativas del PDF" << endl;
    cout << "0. Salir" << endl;
}

void DemoBucle()
{
    cout << "¡DEMO — Un frame (simulacion)!\n" << endl;
    cout << "handleEvents()" << endl;
    cout << "update()" << endl;
    cout << "render()" << endl;
    cout << "frameTime = ahora - start" << endl;
    cout << "si frameTime < FRAME_PERIOD -> Delay(resto)" << endl;
}

void DemoAlts()
{
    cout << "¡DEMO — Alternativas!\n" << endl;
    cout << "1: Delay. Ahorra CPU. Puede ir a tirones." << endl;
    cout << "2: Render siempre, update a veces. Mas preciso, mas CPU." << endl;
    cout << "1bis: update(FRAME_PERIOD) = delta time. Cambias el periodo" << endl;
    cout << "      y el juego no va mas rapido." << endl;
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
                DemoBucle();
                break;
            case 2:
                DemoAlts();
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
