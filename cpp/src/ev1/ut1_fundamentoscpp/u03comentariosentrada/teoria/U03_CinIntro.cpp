#include <iostream>
#include <string>
using namespace std;

/*
U03 — Entrada con cin.

OBJETIVO:
  - Leer valores del teclado con cin >>.
  - Mostrar mensajes previos con cout (sin salto de linea).
  - Leer enteros y decimales directamente (sin Parse).
  - Entender el flujo: preguntar -> leer -> calcular -> mostrar.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - Leer un string con cin.
      cin >> nombre lee UNA palabra (hasta el primer espacio).
      Patron tipico: cout (pregunta) + cin (respuesta).
    */
    cout << "--- PRIMERA PARTE: Leer texto ---\n" << endl;

    cout << "Escribe tu nombre: ";
    string nombre;
    cin >> nombre;
    cout << "Hola, " << nombre << "!" << endl;

    cout << "Escribe tu ciudad: ";
    string ciudad;
    cin >> ciudad;
    cout << "Vives en " << ciudad << "." << endl;

    /*
    SEGUNDA PARTE - Leer un entero con cin.
      En C++ no hace falta int.Parse: cin >> numero guarda el entero directo.
      Si el usuario no escribe un numero, la lectura falla (en este curso
      asumimos que el dato es correcto).
    */
    cout << "\n--- SEGUNDA PARTE: Leer entero ---\n" << endl;

    cout << "Escribe un numero entero: ";
    int numero;
    cin >> numero;
    cout << "El doble es: " << (numero * 2) << endl;
    cout << "El cuadrado es: " << (numero * numero) << endl;

    /*
    TERCERA PARTE - Leer un double.
      cin >> decimalLeido acepta decimales con punto: 3.14
    */
    cout << "\n--- TERCERA PARTE: Leer decimal ---\n" << endl;

    cout << "Escribe un numero decimal (ej: 3.5): ";
    double decimalLeido;
    cin >> decimalLeido;
    cout << "Valor leido: " << decimalLeido << endl;
    cout << "Mitad: " << (decimalLeido / 2) << endl;

    cout << "Otro decimal: ";
    double otroDecimal;
    cin >> otroDecimal;
    cout << "cin >> double -> " << otroDecimal << endl;

    /*
    CUARTA PARTE - Patron compacto: declarar, preguntar y leer.
      Forma habitual en ejercicios cortos del curso.
    */
    cout << "\n--- CUARTA PARTE: Leer en pocas lineas ---\n" << endl;

    cout << "Edad: ";
    int edad;
    cin >> edad;
    cout << "El proximo año tendras " << (edad + 1) << " años." << endl;

    cout << "Nota (0-10): ";
    double nota;
    cin >> nota;
    if (nota >= 5) {
        cout << "Nota " << nota << ": APROBADO." << endl;
    } else {
        cout << "Nota " << nota << ": SUSPENSO." << endl;
    }

    /*
    QUINTA PARTE - Leer varios datos y calcular un resultado.
      Secuencia: pedir -> leer -> procesar -> mostrar.
    */
    cout << "\n--- QUINTA PARTE: Mini calculadora ---\n" << endl;

    cout << "Primer numero: ";
    int a;
    cin >> a;

    cout << "Segundo numero: ";
    int b;
    cin >> b;

    cout << "Suma:      " << (a + b) << endl;
    cout << "Resta:     " << (a - b) << endl;
    cout << "Producto:  " << (a * b) << endl;

    if (b != 0) {
        cout << "Division:  " << (static_cast<double>(a) / b) << endl;
    } else {
        cout << "Division:  no se puede dividir entre cero." << endl;
    }

    /*
    SEXTA PARTE - Resumen de patrones de entrada.
      En C++ cin escribe el valor en la variable; no devuelve un string nullable.
    */
    cout << "\n--- SEXTA PARTE: Resumen de patrones ---\n" << endl;

    cout << "Patron 1: string x; cin >> x;" << endl;
    cout << "Patron 2: int n; cin >> n;" << endl;
    cout << "Patron 3: double d; cin >> d;" << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
