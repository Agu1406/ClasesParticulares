#include "balloon.h"

#include "texture.h"

Balloon::Balloon(Point2D<> position, Vector2D<> velocity, int color, Texture* texture)
  : texture(texture)
  , rect(position, WIDTH, HEIGHT)
  , velocity(velocity)
  , color(color)
{
}

void
Balloon::render() const
{
	// Fila = color, columna 0 = globo entero (las otras columnas son la explosión, más adelante).
	texture->renderFrame(rect.to_sdl(), color, 0);
}

bool
Balloon::update(float delta)
{
	// Enunciado: aplicar velocidad * tiempo (delta viene en ms → se pasa a segundos).
	rect.move(velocity * (delta / 1000.f));

	// Sale por arriba → false para que Game lo borre.
	if (rect.getTopLeftCorner().getY() + rect.getHeight() < 0)
		return false;

	return true;
}
