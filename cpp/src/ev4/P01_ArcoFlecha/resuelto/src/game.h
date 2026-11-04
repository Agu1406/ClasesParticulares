#ifndef GAME_H
#define GAME_H

#include <SDL3/SDL.h>
#include <array>
#include <istream>
#include <vector>

// #include "rectangle.h"

// Declaraciones anticipadas
class Balloon; // paso 5-6: hace falta para el vector de globos
class Texture;

/**
 * Clase principal del juego.
 *
 * Del campus: ventana, renderer, array de texturas, run/update/render/handleEvents.
 * Para el martes: enum de texturas (paso 4), vector de Balloon* (paso 6) y el bucle (paso 3).
 */
class Game
{
public:
	// Número de actualizaciones por segundo
	static constexpr int FRAME_RATE = 30;
	// Periodo entre actualizaciones en milisegundos
	static constexpr int FRAME_PERIOD = 1000 / FRAME_RATE;
	// Tamaño real de la ventana
	static constexpr int WINDOW_WIDTH = 800;
	static constexpr int WINDOW_HEIGHT = 600;

	// PASO 4 — el campus solo tenía BOW y ARROW. El resto (ruta + filas/columnas)
	// va en textureList de game.cpp. NUM_TEXTURES tiene que coincidir con ese array.
	enum TextureName
	{
		BOW = 0,
		ARROW,
		BALLOONS,
		ARCHER,
		ARROW2,
		DIGITS,
		REWARDS,
		NUM_TEXTURES
	};

private:
	SDL_Window* window;
	SDL_Renderer* renderer;
	std::array<Texture*, NUM_TEXTURES> textures;
	std::vector<Balloon*> balloons; // paso 6: "añadir atributos para los objetos del juego"

	void render() const;
	void update();
	void handleEvents();

	bool exit;

public:
	Game();
	~Game();

	// Obtiene una textura por su nombre
	Texture* getTexture(TextureName name) const;

	// Ejecuta el bucle principal del juego
	void run();

	// Del campus; no se implementa el martes (no hay flechas todavía).
	// bool checkCollision(const Rectangle& rect);
};

inline Texture*
Game::getTexture(TextureName name) const
{
	return textures[name];
}

#endif // GAME_H
