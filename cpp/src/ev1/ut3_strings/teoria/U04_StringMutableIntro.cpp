/*
U04 — string mutable: append, insert, erase y replace.

OBJETIVO:
  - Entender que en C++ string ES mutable: se modifica el mismo objeto.
  - En C# y Java string es inmutable y se usa StringBuilder; aqui no hace falta.
  - Usar += y append() para anadir texto.
  - Usar insert(), erase() y replace() sobre la misma cadena.

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
    PRIMERA PARTE - append y += sobre el mismo objeto.
      s.append("texto") anade al final.
      s += "texto" hace lo mismo (forma corta, muy usada).
      No se crea un string nuevo: se modifica s.
    */
    cout << "--- PRIMERA PARTE: append y += ---\n" << endl;

    string sb = "";
    sb.append("Hola");
    sb += ' ';
    sb.append("mundo");
    sb += '!';
    cout << "string mutable: " << sb << endl;

    /*
    SEGUNDA PARTE - += en un bucle.
      En C# cada += sobre string crea una cadena nueva (por eso existe StringBuilder).
      En C++ += modifica el mismo string: es la forma normal de ir construyendo texto.
    */
    cout << "\n--- SEGUNDA PARTE: += con string ---\n" << endl;

    string conMas = "";
    for (int i = 1; i <= 5; i++) {
        // to_string convierte el int a texto para poder concatenar
        conMas += to_string(i);
        if (i < 5) {
            conMas += ", ";
        }
    }
    cout << "Con += (string mutable): " << conMas << endl;

    /*
    TERCERA PARTE - El mismo bucle con append().
      append y += son equivalentes; elige el que se lea mejor.
    */
    cout << "\n--- TERCERA PARTE: bucle con append ---\n" << endl;

    string enBucle = "";
    enBucle.append("Numeros: ");
    for (int i = 1; i <= 5; i++) {
        enBucle.append(to_string(i));
        if (i < 5) {
            enBucle.append(", ");
        }
    }
    cout << "Con append: " << enBucle << endl;

    /*
    CUARTA PARTE - insert: mete texto en una posicion.
      insert(posicion, texto) desplaza el resto hacia la derecha.
    */
    cout << "\n--- CUARTA PARTE: insert ---\n" << endl;

    string nombre = "Ana Lopez";
    nombre.insert(4, "Maria ");
    cout << "Tras insert: " << nombre << endl;

    /*
    QUINTA PARTE - erase y replace.
      erase(posicion, cantidad) borra caracteres.
      replace(posicion, cantidad, nuevo) sustituye un trozo por otro texto.
    */
    cout << "\n--- QUINTA PARTE: erase y replace ---\n" << endl;

    string frase = "Hola mundo";
    cout << "Original: " << frase << endl;

    frase.erase(4, 1); // quita el espacio -> "Holamundo"
    cout << "Tras erase(4, 1): " << frase << endl;

    string saludo = "Hola mundo";
    saludo.replace(5, 5, "C++"); // desde el indice 5, 5 chars ("mundo") -> "C++"
    cout << "Tras replace(5, 5, \"C++\"): " << saludo << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
