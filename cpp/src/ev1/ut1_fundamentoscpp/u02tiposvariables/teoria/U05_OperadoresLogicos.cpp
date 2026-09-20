#include <iostream>
#include <string>
using namespace std;

/*
U05 — Operadores logicos.

Permiten combinar condiciones: si "X" cumple varias reglas, el programa
actua de una forma u otra.

OBJETIVO:
  - Usar && (AND), || (OR) y ! (NOT).
  - Encadenar varias condiciones.
  - Relacionar con ejemplos de la vida real (permisos, club, clima).

En C++:
  - and  -> &&
  - or   -> ||
  - not  -> !

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;
    cout << boolalpha;

    // Datos del profesor
    string nombreP = "Agustín";
    int edadP = 26;
    double alturaP = 1.76;

    // Datos del alumno
    string nombreA = "Eduardo";
    int edadA = 29;
    double alturaA = 1.74;

    /*
    OPERADOR && (AND): las DOS (o mas) condiciones deben ser true.
    */
    cout << "¡MONTAÑA RUSA (&&)!\n" << endl;
    bool puedeSubir = alturaP >= 1.75 && edadP >= 18;
    cout << "¿El profesor puede subir? " << puedeSubir << endl;

    puedeSubir = alturaA >= 1.75 && edadA >= 18;
    cout << "¿El alumno puede subir? " << puedeSubir << "\n" << endl;

    cout << "¡CLUB DE EDUARDOS (varios &&)!\n" << endl;
    bool puedeEntrar = edadA >= 18 && alturaA > 1.50 && nombreA == "Eduardo";
    cout << "¿El alumno puede entrar? " << puedeEntrar << endl;

    puedeEntrar = edadP >= 18 && alturaP > 1.50 && nombreP == "Eduardo";
    cout << "¿El profesor puede entrar? " << puedeEntrar << "\n" << endl;

    /*
    OPERADOR || (OR): basta con que UNA condicion sea true.
    */
    cout << "¡TINTO DE VERANO (||)!\n" << endl;
    bool hoyCobre = true;
    bool hoySabado = false;
    bool hoyDomingo = false;
    bool comproTinto = hoyCobre || hoySabado || hoyDomingo;
    cout << "¿Compro tinto de verano? " << comproTinto << "\n" << endl;

    /*
    OPERADOR ! (NOT): invierte el valor booleano.
    */
    cout << "¡PARQUE CON NOT (!)!\n" << endl;
    bool hoyLlueve = false;
    bool vamosParque = !hoyLlueve;
    cout << "¿Hoy llueve? " << hoyLlueve << " | ¿Vamos al parque? " << vamosParque << endl;

    // Combinacion tipica
    bool finDeSemana = hoySabado || hoyDomingo;
    bool diaIdeal = finDeSemana && !hoyLlueve;
    cout << "¿Dia ideal para parque? " << diaIdeal << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
