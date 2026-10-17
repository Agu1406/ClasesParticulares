Guía de implementación de la práctica 1

Comienzo con la práctica

Como vimos en el laboratorio del martes 6 de octubre, tras mezclar la plantilla proyecto Visual Studio con SDL con el material para la práctica 1, hay que añadir los archivos.cpp al proyecto y completar algunos métodos en Vector2D para que el proyecto compile:

1. Definir el alias de tipo Point2D donde indica el archivo vector2D.h
template<std:: floating_point T>
using Point2D Vector2D<T>:

2. Definir el método I gety () const de Vector2D.

3. Definir el método Vector2D& operator+=(const Vector2D& otro). El operador (que conoceréis de expresiones como x + 2) suma el segundo vector sobre el primero. 

El resultado de v += w debe ser el mismo que el dev = v + w (y se podría implementar como *this *this + otro, aunque no es la mejor forma).
Una vez hecho esto el programa debería compilar y debería aparecer una ventana con el título Bow & Arrow 1.0. 

Sin embargo, esa ventana no responderá hasta que se implemente el bucle principal del juego (como se explica en las diapositivas del tema 3) y se capturen los eventos de la SDL.

A continuación se puede implementar la funcionalidad descrita en el enunciado de la práctica. Por ejemplo,

1. Añadir el resto de texturas con su nombre (en el enumerado TextureName de Game. h), ruta y número de filas y columnas (en el array textureSpec de Game.cpp).

2. Implementar la clase Balloon. Añadir manualmente uno o varios objetos de ese tipo a la escena (cambiando lo que haga falta en Game) para ver que se pintan y mueven como se espera.