#ifndef BALLOON_H
#define BALLOON_H

#include "rectangle.h"
#include "vector2D.h"

class Texture;

/*
 * PASO 5 — notas: "implementar la clase Balloon".
 * No venía en el material. El enunciado pide render() const y update(float)
 * (true = sigue vivo). Color = fila de balloons.png. Sin hit ni explosión:
 * el martes solo hay que verlos pintados y subiendo.
 */
class Balloon
{
	static constexpr float WIDTH = 80.f;
	static constexpr float HEIGHT = 80.f;

	Texture* texture;
	Rectangle rect;          // posición + tamaño (el campus da Rectangle)
	Vector2D<> velocity;     // px/s; Y negativa = sube
	int color;               // fila 0..6

public:
	Balloon(Point2D<> position, Vector2D<> velocity, int color, Texture* texture);

	void render() const;
	bool update(float delta);
};

#endif // BALLOON_H
