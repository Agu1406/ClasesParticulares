/*
CabeceraCpp — Interfaz .h vs implementacion .cpp (PDF POO).

Este fichero es la DECLARACION: que tiene la clase, sin el codigo de los metodos.
El alumno incluye solo #include "Vector2D.h".

#ifndef / #define evitan incluir el .h dos veces.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#ifndef VECTOR2D_H_
#define VECTOR2D_H_

#include <iostream>
using namespace std;

class Vector2D
{
private:
    double x;
    double y;

public:
    Vector2D();
    Vector2D(double x, double y);

    double getX() const;
    double getY() const;

    friend ostream& operator<<(ostream& os, const Vector2D& v);
};

#endif
