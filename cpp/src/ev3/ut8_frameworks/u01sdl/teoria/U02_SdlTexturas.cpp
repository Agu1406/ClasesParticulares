/*
U02 — Superficie, textura y SDL_FRect.

OBJETIVO:
  - Surface = pixeles en CPU. Texture = GPU (la que se usa).
  - LoadBMP -> CreateTextureFromSurface -> DestroySurface.
  - RenderClear, RenderTexture(&src, &dest), RenderPresent.
  - SDL_FRect { x, y, w, h }. nullptr = toda la textura/ventana.
  - vector<SDL_Texture*> para varias texturas (PDF).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U02 Texturas ===" << endl;
    cout << "1. Ciclo de vida" << endl;
    cout << "2. srcRect y destRect" << endl;
    cout << "0. Salir" << endl;
}

void DemoCiclo()
{
    cout << "¡DEMO — Ciclo!\n" << endl;
    cout << "Crear:  SDL_LoadBMP + CreateTextureFromSurface" << endl;
    cout << "Bucle:  Clear -> RenderTexture -> Present" << endl;
    cout << "Fin:    DestroyTexture de cada una" << endl;
    cout << "PNG:    IMG_LoadTexture (paquete SDL_image)" << endl;
}

void DemoRect()
{
    cout << "¡DEMO — SDL_FRect!\n" << endl;
    cout << "src  = recorte de la textura (sprite)." << endl;
    cout << "dest = donde se pinta en la ventana." << endl;
    cout << "dest.w = dest.h = 50; dest.x = dest.y = 0;" << endl;
    cout << "SDL_RenderTexture(renderer, tex, nullptr, &destRect);" << endl;
    cout << "Se pasa &rect porque SDL es C (quiere puntero)." << endl;
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
                DemoCiclo();
                break;
            case 2:
                DemoRect();
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
