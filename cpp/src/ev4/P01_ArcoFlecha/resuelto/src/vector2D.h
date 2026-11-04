#ifndef VECTOR2D_H
#define VECTOR2D_H

/*
 * PASO 1 (notas del martes) — lo primero para que el proyecto compile.
 * El campus traía getX, operator+ y <<. Faltaba getY, += y el alias Point2D.
 * Rectangle pide también operator- ; Balloon se mueve con velocity * tiempo
 * (operator* por escalar). Sin esto no se puede ni abrir la ventana.
 */
#include <concepts>
#include <iostream>

/**
 * Vector bidimensional genérico.
 */
template<std::floating_point T = float>
class Vector2D
{
	T x, y;

public:
	Vector2D(T x, T y) : x(x), y(y) { }
	Vector2D() : Vector2D(0, 0) { }

	// Coordenadas del vector
	T getX() const { return x; } // ya venía del campus
	T getY() const { return y; } // notas: "definir getY() const"

	// Operadores
	Vector2D operator+(const Vector2D& otro) const { // ya venía del campus
		return {x + otro.x, y + otro.y};
	}

	// Rectangle.h lo exige (resta de esquinas). No estaba en las notas, pero sin él no enlaza.
	Vector2D operator-(const Vector2D& otro) const {
		return {x - otro.x, y - otro.y};
	}

	// Para update del globo: velocity * (delta / 1000). El enunciado también pide * escalar.
	Vector2D operator*(T escalar) const {
		return {x * escalar, y * escalar};
	}

	// Notas: v += w debe quedar igual que v = v + w. Se suma sobre *this y se devuelve.
	Vector2D& operator+=(const Vector2D& otro) {
		x += otro.x;
		y += otro.y;
		return *this;
	}

	// Operadores de entrada/salida
	friend std::ostream& operator<<(std::ostream& out, const Vector2D& v) {
		return out << '{' << v.x << ", " << v.y << '}';
	}
};

// Notas: alias Point2D = Vector2D. Se usa cuando es una posición, no una dirección.
template<std::floating_point T = float>
using Point2D = Vector2D<T>;

#endif // VECTOR2D_H
