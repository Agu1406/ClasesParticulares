//
// Tecnología de la Programación de Videojuegos 1
// Facultad de Informática UCM
//
// Plantilla de proyecto con SDL
//

/*
 * PASO 2 — arrancar el juego (después de Vector2D y de añadir los .cpp al .vcxproj).
 * El material ya llamaba a Game().run(). El TODO era capturar excepciones string:
 * si falta una PNG o falla SDL, el mensaje sale en consola en vez de petar.
 */

#include <iostream>
#include <string>

#include "game.h"

int main(int argc, char* argv[])
{
	try {
		Game().run(); // crea Game (ventana + texturas + globos) y entra al bucle
	}
	catch (const std::string& error) {
		std::cerr << error << std::endl;
		return 1;
	}

	return 0;
}
