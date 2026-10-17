#ifndef BALLOON_H
#define BALLOON_H

#include "rectangle.h"
#include "vector2D.h"

class Texture;

/**
 * Globo que sube por la pantalla a velocidad constante.
 * La fila de la textura es el color (0..6). La columna 0 es el globo
 * entero; las siguientes son la animacion de explosion.
 */
class Balloon
{
	static constexpr float WIDTH = 80.f;
	static constexpr float HEIGHT = 80.f;
	static constexpr float EXPLOSION_FRAME_MS = 80.f;

	Texture* texture;
	Rectangle rect;
	Vector2D<> velocity;
	int color;
	bool exploding;
	int frameCol;
	float animTimer;

public:
	Balloon(Point2D<> position, Vector2D<> velocity, int color, Texture* texture);

	void render() const;
	bool update(float delta);
	bool hit(const Rectangle& obj);
};

#endif // BALLOON_H
