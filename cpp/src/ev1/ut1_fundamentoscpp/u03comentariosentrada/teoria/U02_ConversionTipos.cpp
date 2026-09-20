#include <iostream>
#include <string>
#include <cmath>
using namespace std;

/*
U02 — Conversion de tipos en C++.

OBJETIVO:
  - Convertir entre tipos numericos con static_cast<int>(x), static_cast<double>(x), etc.
  - Convertir texto a numero con stoi y stod (equivalente a Parse / Convert de C#).
  - Entender cuando se pierde precision (double -> int trunca decimales).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;
    cout << boolalpha;

    /*
    PRIMERA PARTE - Cast explicito entre tipos numericos.
      static_cast<tipo>(valor) fuerza la conversion cuando tu sabes que es seguro.
      double -> int: se TRUNCA la parte decimal (no redondea).
      int -> double: no pierde informacion (conversion implicita tambien vale).
    */
    cout << "--- PRIMERA PARTE: Cast explicito ---\n" << endl;

    double pi = 3.99;
    int enteroDesdeDouble = static_cast<int>(pi); // trunca -> 3, no 4
    cout << "static_cast<int>(3.99) -> " << enteroDesdeDouble << endl;

    double otro = 3.14;
    int truncado = static_cast<int>(otro);
    cout << "static_cast<int>(3.14) -> " << truncado << endl;

    int cantidad = 42;
    double cantidadDouble = static_cast<double>(cantidad); // 42.0
    cout << "static_cast<double>(42) -> " << cantidadDouble << endl;

    // Conversion implicita int -> double (sin cast) tambien funciona:
    double implicito = cantidad;
    cout << "Asignacion implicita int->double: " << implicito << endl;

    /*
    SEGUNDA PARTE - stoi y stod (texto -> numero).
      En C++ no existe la clase Convert de C#.
      stoi("42")   equivale a Convert.ToInt32 / int.Parse.
      stod("3.14") equivale a Convert.ToDouble / double.Parse.
    */
    cout << "\n--- SEGUNDA PARTE: stoi y stod ---\n" << endl;

    string textoEntero = "42";
    int desdeStoi = stoi(textoEntero);
    cout << "stoi(\"42\") -> " << desdeStoi << endl;

    string textoDecimal = "3.14";
    double desdeStod = stod(textoDecimal);
    cout << "stod(\"3.14\") -> " << desdeStod << endl;

    // static_cast tambien trunca al pasar double a int:
    double valor = 9.99;
    int convertido = static_cast<int>(valor);
    cout << "static_cast<int>(9.99) -> " << convertido << endl;

    // Un bool a partir de texto se compara con la cadena "true".
    string textoBool = "true";
    bool activo = (textoBool == "true");
    cout << "textoBool == \"true\" -> " << activo << endl;

    /*
    TERCERA PARTE - Parse de cadenas: stoi y stod.
      Solo aceptan string. Si el texto NO es un numero valido, el programa falla.
    */
    cout << "\n--- TERCERA PARTE: stoi / stod ---\n" << endl;

    string edadTexto = "18";
    int edad = stoi(edadTexto);
    cout << "stoi(\"18\") -> " << edad << endl;

    string notaTexto = "8.75";
    double nota = stod(notaTexto);
    cout << "stod(\"8.75\") -> " << nota << endl;

    // stoi ignora espacios al inicio y al final del numero.
    string conEspacios = "  100  ";
    int limpio = stoi(conEspacios);
    cout << "stoi(\"  100  \") -> " << limpio << endl;

    /*
    CUARTA PARTE - Comparativa: static_cast vs stoi/stod.
      - static_cast: entre tipos numericos compatibles (rapido, en compilacion).
      - stoi/stod:   string -> tipo numerico (falla si el texto es invalido).
    */
    cout << "\n--- CUARTA PARTE: Resumen comparativo ---\n" << endl;

    string numeroStr = "75";
    int conCast = static_cast<int>(stod(numeroStr)); // string->double, luego cast->int
    int conStoi = stoi(numeroStr);

    cout << "Desde \"75\": static_cast=" << conCast << ", stoi=" << conStoi << endl;

    /*
    QUINTA PARTE - Perdida de precision y buenas practicas.
      Al pasar de double a int SIEMPRE se pierden decimales.
      Para redondear: static_cast<int>(round(valor)) en lugar de cast directo.
    */
    cout << "\n--- QUINTA PARTE: Precision y redondeo ---\n" << endl;

    double precio = 19.99;
    int precioTruncado = static_cast<int>(precio);
    int precioRedondeado = static_cast<int>(round(precio));

    cout << "Precio original: " << precio << endl;
    cout << "Cast static_cast<int>: " << precioTruncado << "  (trunca decimales)" << endl;
    cout << "round: " << precioRedondeado << "  (redondea al entero mas cercano)" << endl;

    // Demo con condicion: comprobar si la conversion tiene sentido.
    double temperatura = 36.7;
    if (temperatura > 0) {
        int tempEntera = static_cast<int>(temperatura);
        cout << "Temperatura " << temperatura << "°C -> parte entera: " << tempEntera << "°C" << endl;
    }

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
