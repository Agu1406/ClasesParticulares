#include "balloon.h"

#include "texture.h"

Balloon::Balloon(Point2D<> position, Vector2D<> velocity, int color, Texture* texture)
  : texture(texture)
  , rect(position, WIDTH, HEIGHT)
  , velocity(velocity)
  , color(color)
  , exploding(false)
  , frameCol(0)
  , animTimer(0)
{
}

void
Balloon::render() const
{
	texture->renderFrame(rect.to_sdl(), color, frameCol);
}

bool
Balloon::update(float delta)
{
	if (exploding) {
		animTimer += delta;
		while (animTimer >= EXPLOSION_FRAME_MS) {
			animTimer -= EXPLOSION_FRAME_MS;
			frameCol++;
			if (frameCol >= texture->getNumColumns())
				return false;
		}
		return true;
	}

	rect.move(velocity * (delta / 1000.f));

	if (rect.getTopLeftCorner().getY() + rect.getHeight() < 0)
		return false;

	return true;
}

bool
Balloon::hit(const Rectangle& obj)
{
	if (exploding)
		return false;

	if (!rect.hasIntersection(obj))
		return false;

	exploding = true;
	frameCol = 1;
	animTimer = 0;
	return true;
}
