#include <iostream>
#include <string>
using namespace std;

/*
U02 — cout sin salto y cout con endl.

OBJETIVO:
  - Diferenciar cout sin endl (sin salto de linea) y cout con endl (con salto de linea).
  - Usar secuencias de escape \n (salto) y \t (tabulador) dentro de cadenas.
  - Concatenar textos con el operador + (entre string) o encadenar con <<.
  - Formatear mensajes encadenando variables con cout << ... << ...

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - cout sin endl vs cout con endl.
      cout << "x";              escribe en la misma linea, NO salta al final.
      cout << "x" << endl;      escribe y luego pasa a la linea siguiente.
    */
    cout << "--- PRIMERA PARTE: cout sin endl vs cout con endl ---\n" << endl;

    cout << "Hola ";
    cout << "desde ";
    cout << "cout";
    cout << endl; // endl fuerza el salto de linea final.

    cout << "Esta linea empieza en una fila nueva." << endl;

    cout << "A";
    cout << "B";
    cout << "C";
    cout << " -> ABC en la misma linea, luego salto." << endl;

    /*
    SEGUNDA PARTE - Secuencias de escape \n y \t.
      \n = nueva linea (como pulsar Enter).
      \t = tabulador (espaciado horizontal, util para alinear columnas).
      \\ = backslash literal (hay que escaparlo con otro backslash).
    */
    cout << "\n--- SEGUNDA PARTE: Secuencias de escape ---\n" << endl;

    cout << "Linea 1\nLinea 2\nLinea 3  (todo en un solo cout)" << endl;

    cout << "Nombre\tEdad\tNota" << endl;
    cout << "Ana\t20\t8.5" << endl;
    cout << "Luis\t22\t7.0" << endl;
    cout << "Maria\t19\t9.2" << endl;

    cout << "Ruta: C:\\Users\\Alumno\\Documentos" << endl;

    /*
    TERCERA PARTE - Concatenacion con el operador + y encadenado con <<.
      Entre string se pueden unir cadenas con +.
      Los numeros NO se concatenan solos con un literal "texto" + 25;
      para mezclar texto y numeros se encadena con << (forma habitual en C++).
    */
    cout << "\n--- TERCERA PARTE: Concatenacion con + y << ---\n" << endl;

    string nombre = "Carlos";
    int edad = 25;
    double nota = 8.75;

    cout << "Me llamo " << nombre << " y tengo " << edad << " años." << endl;
    cout << "Mi nota es " << nota << " sobre 10." << endl;
    cout << "Saludo: " << string("Hola") + " " + "mundo" + "!" << endl;

    // Concatenacion encadenada de string: se evalua de izquierda a derecha.
    string mensaje = string("FP") + " " + "DAM" + " " + "2025";
    cout << "Curso: " << mensaje << endl;

    /*
    CUARTA PARTE - Encadenar variables con << (equivalente a la interpolacion $"..." de otros lenguajes).
      En C++ no existe $"Hola {nombre}". Se escribe:
        cout << "Hola " << nombre;
      Permite expresiones: << (edad + 1), << (nota >= 5), etc.
    */
    cout << "\n--- CUARTA PARTE: Encadenar con << ---\n" << endl;

    cout << "Alumno: " << nombre << ", edad: " << edad << ", nota: " << nota << endl;
    cout << "El proximo año tendra " << (edad + 1) << " años." << endl;
    cout << "¿Aprobado? " << (nota >= 5 ? "Si" : "No") << endl;

    // Se puede mezclar texto fijo con variables de forma natural.
    string ciudad = "Sevilla";
    cout << "Vivo en " << ciudad << " y estudio " << mensaje << "." << endl;

    /*
    QUINTA PARTE - Comparativa rapida: + vs <<.
      Ambas formas pueden producir el mismo resultado en pantalla.
      Encadenar con << suele ser mas claro cuando hay numeros y varias variables.
    */
    cout << "\n--- QUINTA PARTE: + vs << (mismo resultado) ---\n" << endl;

    string resultadoMas = string("Hola, ") + nombre + "! Tienes " + to_string(edad) + " años.";
    string resultadoCout = string("Hola, ") + nombre + "! Tienes " + to_string(edad) + " años.";

    cout << "Con +:  " << resultadoMas << endl;
    cout << "Con <<: Hola, " << nombre << "! Tienes " << edad << " años." << endl;

    if (resultadoMas == resultadoCout) {
        cout << "Ambos mensajes son identicos." << endl;
    }

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
