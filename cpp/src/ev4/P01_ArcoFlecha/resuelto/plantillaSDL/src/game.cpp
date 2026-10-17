#include "game.h"

#include <string>

#include <SDL3_image/SDL_image.h>

#include "balloon.h"
#include "texture.h"

using namespace std;

// Constantes
constexpr const char* const WINDOW_TITLE = "Bow & Arrow 1.0";
constexpr const char* IMAGE_ROOT = "../assets/images/";

// Estructura para especificar las texturas que hay que
// cargar y el tamaño de su matriz de frames
struct TextureSpec
{
	const char* name;
	int nrows = 1;
	int ncols = 1;
};

constexpr array<TextureSpec, Game::NUM_TEXTURES> textureList{
	TextureSpec{"bow.png", 1, 2},
	{"arrow.png"},
	{"balloons.png", 7, 6},
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
	// Carga SDL y crea la ventana con su renderizador
	if (!SDL_Init(SDL_INIT_VIDEO))
		throw "SDL_Init: "s + SDL_GetError();

	if (!SDL_CreateWindowAndRenderer(WINDOW_TITLE,
	                                 WINDOW_WIDTH, WINDOW_HEIGHT,
	                                 0, &window, &renderer))
		throw "window or renderer: "s + SDL_GetError();

	// Carga las texturas al inicio
	try {
		textures.fill(nullptr);
		string imgRoot = IMAGE_ROOT;

		for (size_t i = 0; i < textures.size(); i++) {
			auto [name, nrows, ncols] = textureList[i];
			textures[i] = new Texture(renderer, (imgRoot + name).c_str(), nrows, ncols);
		}
	}
	catch (...) {
		for (Texture* texture : textures)
			delete texture;
		SDL_DestroyRenderer(renderer);
		SDL_DestroyWindow(window);
		SDL_Quit();
		throw;
	}

	// Globos de prueba: distintos colores, posiciones y velocidades
	Texture* balloonTex = getTexture(BALLOONS);
	balloons.push_back(new Balloon({100.f, float(WINDOW_HEIGHT)}, {0.f, -90.f}, 0, balloonTex));
	balloons.push_back(new Balloon({280.f, float(WINDOW_HEIGHT + 40)}, {0.f, -130.f}, 2, balloonTex));
	balloons.push_back(new Balloon({460.f, float(WINDOW_HEIGHT + 80)}, {0.f, -70.f}, 4, balloonTex));
	balloons.push_back(new Balloon({640.f, float(WINDOW_HEIGHT + 20)}, {0.f, -160.f}, 6, balloonTex));
}

Game::~Game()
{
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
	SDL_SetRenderDrawColor(renderer, 135, 206, 235, 255);
	SDL_RenderClear(renderer);

	for (const Balloon* balloon : balloons)
		balloon->render();

	SDL_RenderPresent(renderer);
}

void
Game::update()
{
	const float delta = static_cast<float>(FRAME_PERIOD);

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
	// Alternativa 1bis del tema 3: delta fijo + SDL_Delay
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

	while (SDL_PollEvent(&event) && !exit) {
		if (event.type == SDL_EVENT_QUIT)
			exit = true;
	}
}
