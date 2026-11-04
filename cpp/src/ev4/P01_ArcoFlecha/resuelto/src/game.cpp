#include "game.h"

#include <string>

#include <SDL3_image/SDL_image.h>

#include "balloon.h"
#include "texture.h"

using namespace std;

// Constantes
constexpr const char* const WINDOW_TITLE = "Bow & Arrow 1.0";
constexpr const char* IMAGE_ROOT = "../assets/images/";
constexpr const char* LEVEL_ROOT = "../assets/levels/"; // del campus; loadLevel no es del martes

// Estructura para especificar las texturas que hay que
// cargar y el tamaño de su matriz de frames
struct TextureSpec
{
	const char* name;
	int nrows = 1;
	int ncols = 1;
};

// PASO 4 — notas: completar TextureName + filas/columnas.
// El ctor recorre este array y hace new Texture(...). El martes solo se pinta BALLOONS;
// el resto se carga ya para no tocar esto después.
constexpr array<TextureSpec, Game::NUM_TEXTURES> textureList{
	TextureSpec{"bow.png", 1, 2},      // campus
	{"arrow.png"},                     // campus
	{"balloons.png", 7, 6},            // 7 colores (filas), col 0 = globo
	{"archer.png", 1, 2},
	{"arrow2.png", 1, 3},
	{"digits.png", 1, 11},
	{"rewards.png", 7, 11},
};

Game::Game()
  : window(nullptr)
  , renderer(nullptr)
  , exit(false)
{
	// Carga SDL y crea la ventana con su renderizador (campus)
	if (!SDL_Init(SDL_INIT_VIDEO))
		throw "SDL_Init: "s + SDL_GetError();

	if (!SDL_CreateWindowAndRenderer(WINDOW_TITLE,
	                                 WINDOW_WIDTH, WINDOW_HEIGHT,
	                                 0, &window, &renderer))
		throw "window or renderer: "s + SDL_GetError();

	// Carga las texturas al inicio (campus; ahora son 7 por el paso 4)
	try {
		textures.fill(nullptr);
		string imgRoot = IMAGE_ROOT;

		for (size_t i = 0; i < textures.size(); i++) {
			auto [name, nrows, ncols] = textureList[i];
			textures[i] = new Texture(renderer, (imgRoot + name).c_str(), nrows, ncols);
		}
	}
	catch (...) {
		// TODO del campus: si falla una PNG, no dejar texturas/SDL a medias.
		for (Texture* texture : textures)
			delete texture;
		SDL_DestroyRenderer(renderer);
		SDL_DestroyWindow(window);
		SDL_Quit();
		throw;
	}

	/*
	 * PASO 6 — notas: "añadir manualmente uno o varios Balloon a la escena".
	 * Y debajo del borde inferior, velocidad en Y negativa (suben), colores = filas 0/2/4/6.
	 * Más adelante esto será aleatorio; el martes basta con ver que se pintan y mueven.
	 */
	Texture* balloonTex = getTexture(BALLOONS);
	balloons.push_back(new Balloon({100.f, float(WINDOW_HEIGHT)}, {0.f, -90.f}, 0, balloonTex));
	balloons.push_back(new Balloon({280.f, float(WINDOW_HEIGHT + 40)}, {0.f, -130.f}, 2, balloonTex));
	balloons.push_back(new Balloon({460.f, float(WINDOW_HEIGHT + 80)}, {0.f, -70.f}, 4, balloonTex));
	balloons.push_back(new Balloon({640.f, float(WINDOW_HEIGHT + 20)}, {0.f, -160.f}, 6, balloonTex));
}

Game::~Game()
{
	// TODO del campus: liberar lo reservado con new + cerrar SDL (checkML en Debug).
	for (Balloon* balloon : balloons)
		delete balloon;

	for (Texture* texture : textures)
		delete texture;

	SDL_DestroyRenderer(renderer);
	SDL_DestroyWindow(window);
	SDL_Quit();
}

void
Game::render() const
{
	// Tema 5: clear → cada objeto render() → Present.
	SDL_SetRenderDrawColor(renderer, 135, 206, 235, 255); // cielo (bgcolor del nivel 2)
	SDL_RenderClear(renderer);

	for (const Balloon* balloon : balloons)
		balloon->render();

	SDL_RenderPresent(renderer);
}

void
Game::update()
{
	const float delta = static_cast<float>(FRAME_PERIOD);

	// Enunciado: update del objeto false → delete y quitar del vector (sale por arriba).
	for (auto it = balloons.begin(); it != balloons.end(); ) {
		if (!(*it)->update(delta)) {
			delete *it;
			it = balloons.erase(it);
		}
		else {
			++it;
		}
	}
}

void
Game::run()
{
	/*
	 * PASO 3 — notas: la ventana no responde hasta el bucle del tema 3.
	 * Alternativa 1bis: eventos → update → render, y Delay si el frame fue corto.
	 * FRAME_PERIOD ya venía en el esqueleto (30 FPS).
	 */
	while (!exit) {
		const Uint64 startTime = SDL_GetTicks();

		handleEvents();
		update();
		render();

		const Uint64 frameTime = SDL_GetTicks() - startTime;
		if (frameTime < FRAME_PERIOD)
			SDL_Delay(static_cast<Uint32>(FRAME_PERIOD - frameTime));
	}
}

void
Game::handleEvents()
{
	SDL_Event event;

	// Campus ya hacía PollEvent + QUIT. El paso 3 es llamarlo desde run() cada frame.
	// Sin este bucle Windows marca la ventana como "no responde".
	while (SDL_PollEvent(&event) && !exit) {
		if (event.type == SDL_EVENT_QUIT)
			exit = true;
	}
}

// bool
// Game::checkCollision(const Rectangle& rect)
// {
//	// TODO — no es del martes (hace falta Arrow)
//	return false;
// }
