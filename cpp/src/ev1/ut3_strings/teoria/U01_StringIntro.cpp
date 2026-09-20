/*
U01 — Introduccion a cadenas de texto (string).

OBJETIVO:
  - Conocer size() para obtener la longitud de un string.
  - Acceder a caracteres individuales con el indice [] (base 0).
  - Extraer partes de una cadena con substr(inicio, longitud).
  - Unir cadenas mediante concatenacion con +.
  - Entender que en C++ string ES mutable: puedes cambiar caracteres in-place.
    (En C# y Java string es inmutable; aqui no hace falta StringBuilder).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - Crear cadenas y consultar size().
      size() devuelve el numero de caracteres.
      Los espacios y signos de puntuacion cuentan como caracteres.
      Equivale a Length en C# y a length() en Java.
    */
    cout << "--- PRIMERA PARTE: size() ---\n" << endl;

    string saludo = "Hola mundo";
    cout << "Cadena: \"" << saludo << "\"" << endl;
    cout << "Longitud (size()): " << saludo.size() << endl;

    string conEspacios = "  FP DAM  ";
    cout << "Con espacios: \"" << conEspacios << "\" -> size() = " << conEspacios.size() << endl;

    string vacia = "";
    cout << "Cadena vacia \"\" -> size() = " << vacia.size() << endl;

    /*
    SEGUNDA PARTE - Acceso por indice con [].
      El primer caracter esta en la posicion 0 (no en 1).
      El ultimo caracter esta en size() - 1.
      Indice fuera de rango -> comportamiento indefinido (no uses indices invalidos).
    */
    cout << "\n--- SEGUNDA PARTE: Indice [] ---\n" << endl;

    cout << "Cadena: " << saludo << endl;
    cout << "Primer caracter [0]: " << saludo[0] << endl;
    cout << "Segundo caracter [1]: " << saludo[1] << endl;
    cout << "Quinto caracter [4]: " << saludo[4] << endl; // la 'm' de "mundo" empieza en 5; [4] es el espacio
    cout << "Ultimo caracter [size()-1]: " << saludo[saludo.size() - 1] << endl;

    // Recorrer caracteres con for e indice (estilo junior, sin foreach).
    cout << "Recorrido con for: ";
    for (size_t i = 0; i < saludo.size(); i++) {
        cout << saludo[i] << " ";
    }
    cout << endl;

    /*
    TERCERA PARTE - substr: extraer una porcion.
      substr(inicio, longitud): empieza en inicio y toma longitud caracteres.
      substr(inicio):           desde inicio hasta el final de la cadena.
      Equivalente a Substring en C# y al rebanado [inicio:fin] de Python.
    */
    cout << "\n--- TERCERA PARTE: substr ---\n" << endl;

    string frase = "Aprender C++ en FP";
    cout << "Frase completa: " << frase << endl;

    string primeras4 = frase.substr(0, 4);   // "Apre"
    string desde9 = frase.substr(9);         // "C++ en FP"
    string lenguaje = frase.substr(9, 3);    // "C++"

    cout << "substr(0, 4):  \"" << primeras4 << "\"" << endl;
    cout << "substr(9):     \"" << desde9 << "\"" << endl;
    cout << "substr(9, 3):  \"" << lenguaje << "\"" << endl;

    // Ultimos N caracteres: substr(size() - N)
    int n = 5;
    string ultimos5 = frase.substr(frase.size() - n);
    cout << "Ultimos " << n << " caracteres: \"" << ultimos5 << "\"" << endl;

    /*
    CUARTA PARTE - Concatenacion con +.
      El operador + entre strings las une en orden.
      Tambien puedes usar += para anadir al final (el string se modifica).
      cout imprime numeros sin convertirlos a string; al concatenar con +
      hay que tener cuidado: "DAM " + anyo NO compila (int no es string).
    */
    cout << "\n--- CUARTA PARTE: Concatenacion ---\n" << endl;

    string nombre = "Ana";
    string mensaje = "Hola, " + nombre + "!";
    cout << "Con +: " << mensaje << endl;

    string parte1 = "C++ ";
    string parte2 = "es ";
    string parte3 = "genial";
    cout << "Varias partes: " << parte1 + parte2 + parte3 << endl;

    int anyo = 2025;
    string curso = "DAM";
    cout << "Mezcla string + int (con cout): " << curso << " " << anyo << endl;

    // Repeticion visual con concatenacion en bucle.
    string linea = "";
    for (int i = 0; i < 10; i++) {
        linea = linea + "-";
    }
    cout << "Linea de guiones: " << linea << endl;

    /*
    QUINTA PARTE - Mutabilidad y comparacion lexicografica.
      En C++ string SE PUEDE modificar: s[0] = 'h' cambia el original.
      Concatenar con + crea un string nuevo; += modifica el mismo objeto.
      compare y los operadores < > comparan caracter a caracter (orden alfabetico).
    */
    cout << "\n--- QUINTA PARTE: Mutabilidad y comparacion ---\n" << endl;

    string original = "Hola";
    string modificado = original + " mundo"; // original sigue siendo "Hola"
    cout << "Original: \"" << original << "\"" << endl;
    cout << "Nuevo:    \"" << modificado << "\"" << endl;

    original[0] = 'h'; // en C# esto no se puede; aqui SI
    cout << "Tras cambiar [0]: \"" << original << "\"" << endl;

    string a = "abc";
    string b = "abd";
    if (a.compare(b) < 0) {
        cout << "\"" << a << "\" va antes que \"" << b << "\" (orden lexicografico)." << endl;
    }

    /*
      En C++, == entre string compara el CONTENIDO (igual que en C#).
      En Java, == compara la referencia y hay que usar equals().
    */
    string uno = "Ana";
    string dos = "Ana";
    cout << boolalpha;
    cout << "\"Ana\" == \"Ana\": " << (uno == dos) << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
