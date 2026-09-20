#include <iostream>
#include <string>
#include <cmath>
using namespace std;

/*
U06 — Repaso general de u02tiposvariables.

OBJETIVO:
  - Crear variables de distintos tipos.
  - Imprimir con cout encadenando texto y variables.
  - Recordar el tipo de cada variable (int, double, string, bool, char).
  - Practicar operadores aritmeticos, de comparacion y logicos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;
    cout << boolalpha;

    /*
    PRIMERA PARTE - Tipos basicos en C++.
      string  -> texto
      int     -> enteros
      double  -> decimales
      bool    -> true / false
      char    -> un caracter entre comillas simples
    */
    string nombreP = "Agustín";
    string nombreA = "Eduardo";
    int edadP = 26;
    int edadA = 29;
    double alturaP = 1.76;
    double alturaA = 1.74;
    bool soyHumano = true;
    bool hoyMartes = false;
    char inicialP = 'A';

    /*
    SEGUNDA PARTE - Imprimir datos.
    */
    cout << "¡DATOS DEL PROFESOR!\n" << endl;
    cout << "- Nombre: " << nombreP << endl;
    cout << "- Inicial: " << inicialP << endl;
    cout << "- Altura: " << alturaP << endl;
    cout << "- Edad: " << edadP << endl;
    cout << "- Tipo de edadP: int\n" << endl;

    cout << "¡DATOS DEL ALUMNO!\n" << endl;
    cout << "- Nombre: " << nombreA << endl;
    cout << "- Altura: " << alturaA << endl;
    cout << "- Edad: " << edadA << "\n" << endl;

    cout << "¡DATOS EN UNA SOLA LINEA!\n" << endl;
    cout << "Tu profesor se llama " << nombreP << ", tiene " << edadP << " años y mide " << alturaP << "." << endl;
    cout << "Tu te llamas " << nombreA << ", tienes " << edadA << " años y mides " << alturaA << "." << endl;

    /*
    TERCERA PARTE - Operadores aritmeticos.
    */
    cout << "\n¡OPERADORES ARITMETICOS!\n" << endl;
    int num1 = 10;
    int num2 = 3;
    cout << num1 << " + " << num2 << " = " << (num1 + num2) << endl;
    cout << num1 << " - " << num2 << " = " << (num1 - num2) << endl;
    cout << num1 << " * " << num2 << " = " << (num1 * num2) << endl;
    cout << num1 << " / " << num2 << " (entera) = " << (num1 / num2) << endl;
    cout << num1 << " / " << num2 << ".0 (decimal) = " << (num1 / static_cast<double>(num2)) << endl;
    cout << num1 << " % " << num2 << " = " << (num1 % num2) << endl;
    cout << "pow(" << num1 << ", " << num2 << ") = " << pow(num1, num2) << endl;

    /*
    CUARTA PARTE - Comparacion y logica.
    */
    cout << "\n¡COMPARACION Y LOGICA!\n" << endl;
    cout << "¿Alumno mayor que profesor? " << (edadA > edadP) << endl;
    cout << "¿Alturas distintas? " << (alturaA != alturaP) << endl;
    bool puedeMontana = alturaP >= 1.75 && edadP >= 18;
    cout << "¿Profesor puede montaña rusa? " << puedeMontana << endl;
    cout << "¿Es humano y NO es martes? " << (soyHumano && !hoyMartes) << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
