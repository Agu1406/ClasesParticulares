/*
U02 — if-else y cadenas else if.

OBJETIVO:
  - Elegir entre dos caminos con if / else.
  - Encadenar varias condiciones con else if.
  - Clasificar valores en rangos (notas, temperatura, etc.).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - if / else basico: par o impar.
    */
    cout << "¡DEMO 1: PAR O IMPAR!\n" << endl;

    int numero = 14;
    if (numero % 2 == 0)
    {
        cout << numero << " es par." << endl;
    }
    else
    {
        cout << numero << " es impar." << endl;
    }

    numero = 7;
    if (numero % 2 == 0)
    {
        cout << numero << " es par." << endl;
    }
    else
    {
        cout << numero << " es impar.\n" << endl;
    }

    /*
    SEGUNDA PARTE - else if: clasificacion de nota.
      Se evalua de arriba abajo; solo entra en UN bloque.
    */
    cout << "¡DEMO 2: CALIFICACION POR NOTA!\n" << endl;

    int nota = 8;
    if (nota >= 9)
    {
        cout << "Nota " << nota << ": Sobresaliente" << endl;
    }
    else if (nota >= 7)
    {
        cout << "Nota " << nota << ": Notable" << endl;
    }
    else if (nota >= 5)
    {
        cout << "Nota " << nota << ": Aprobado" << endl;
    }
    else
    {
        cout << "Nota " << nota << ": Suspenso" << endl;
    }

    nota = 4;
    if (nota >= 9)
    {
        cout << "Sobresaliente" << endl;
    }
    else if (nota >= 7)
    {
        cout << "Notable" << endl;
    }
    else if (nota >= 5)
    {
        cout << "Aprobado" << endl;
    }
    else
    {
        cout << "Nota " << nota << ": Suspenso\n" << endl;
    }

    /*
    TERCERA PARTE - else if con temperatura y descuento.
    */
    cout << "¡DEMO 3: TEMPERATURA Y DESCUENTO!\n" << endl;

    double temp = 32.5;
    if (temp >= 35)
    {
        cout << "Ola de calor: hidratate." << endl;
    }
    else if (temp >= 25)
    {
        cout << "Dia caluroso." << endl;
    }
    else if (temp >= 15)
    {
        cout << "Temperatura agradable." << endl;
    }
    else
    {
        cout << "Hace fresco, abrigate." << endl;
    }

    int edad = 12;
    double precio = 10.0;
    if (edad < 12)
    {
        precio = precio * 0.5;  // 50% descuento infantil
    }
    else if (edad >= 65)
    {
        precio = precio * 0.7;  // 30% descuento senior
    }

    cout << "Edad " << edad << ": precio final = " << precio << " euros" << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
