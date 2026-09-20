#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

/*
U04 — Repaso: comentarios, entrada, conversion y salida.

OBJETIVO:
  - Integrar comentarios, cin, calculos y cout en un mini programa.
  - Repasar el flujo completo: pedir datos -> leer -> calcular -> mostrar.
  - Aplicar buenas practicas de comentarios y formato de salida.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - Suma de dos numeros enteros.
      Demo clasica que une entrada por teclado con cin.
    */
    cout << "--- PRIMERA PARTE: Suma de dos enteros ---\n" << endl;

    // Pedimos el primer operando al usuario.
    cout << "Primer numero: ";
    int a;
    cin >> a;

    // Pedimos el segundo operando.
    cout << "Segundo numero: ";
    int b;
    cin >> b;

    int suma = a + b; // calculamos la suma
    cout << "La suma es: " << suma << endl;

    /*
    SEGUNDA PARTE - Calculo de media con decimales.
      Leemos doubles, calculamos media aritmetica y formateamos con setprecision.
    */
    cout << "\n--- SEGUNDA PARTE: Media de dos notas ---\n" << endl;

    cout << "Nota del primer examen: ";
    double nota1;
    cin >> nota1;

    cout << "Nota del segundo examen: ";
    double nota2;
    cin >> nota2;

    double media = (nota1 + nota2) / 2.0; // 2.0 fuerza division decimal
    cout << fixed << setprecision(2);
    cout << "Media: " << media << endl; // dos decimales fijos

    if (media >= 5) {
        cout << "Resultado: APROBADO." << endl;
    } else {
        cout << "Resultado: SUSPENSO." << endl;
    }

    /*
    TERCERA PARTE - Saludo personalizado con nombre y edad.
      Mezcla string (una palabra con cin) e int.
    */
    cout << "\n--- TERCERA PARTE: Saludo personalizado ---\n" << endl;

    cout << "Tu nombre: ";
    string nombre;
    cin >> nombre;

    cout << "Tu edad: ";
    int edad;
    cin >> edad;

    // Encadenar con <<: forma clara de combinar texto y variables.
    cout << "Hola " << nombre << ", tienes " << edad << " años." << endl;
    cout << "El año que viene tendras " << (edad + 1) << " años." << endl;

    /*
    CUARTA PARTE - Conversion de temperatura Celsius -> Fahrenheit.
      Formula: F = C * 9/5 + 32
      Demuestra cin + calculo + salida formateada en un solo flujo.
    */
    cout << "\n--- CUARTA PARTE: Celsius a Fahrenheit ---\n" << endl;

    cout << "Temperatura en Celsius: ";
    double celsius;
    cin >> celsius;

    double fahrenheit = celsius * 9.0 / 5.0 + 32.0;
    cout << setprecision(1);
    cout << celsius << "°C = " << fahrenheit << "°F" << endl;

    /*
    QUINTA PARTE - Precio con IVA.
      Lee un precio base, aplica IVA del 21 % y muestra desglose.
      Comentarios inline explican cada paso del calculo.
    */
    cout << "\n--- QUINTA PARTE: Precio con IVA ---\n" << endl;

    cout << "Precio sin IVA (euros): ";
    double precioBase;
    cin >> precioBase;

    const double IVA = 0.21;                  // tipo impositivo fijo
    double importeIva = precioBase * IVA;     // cantidad de IVA
    double precioFinal = precioBase + importeIva;

    cout << setprecision(2);
    cout << "Base imponible: " << precioBase << " €" << endl;
    cout << "IVA (21 %):     " << importeIva << " €" << endl;
    cout << "Total:          " << precioFinal << " €" << endl;

    /*
    SEXTA PARTE - Resumen del flujo aprendido.
      Patron repetido en todos los mini programas anteriores.
    */
    cout << "\n--- SEXTA PARTE: Flujo completo repasado ---\n" << endl;

    cout << "1) cout         -> mostrar pregunta (sin salto)." << endl;
    cout << "2) cin          -> leer respuesta del usuario." << endl;
    cout << "3) (opcional)   -> static_cast / stoi si hace falta convertir." << endl;
    cout << "4) Calculo      -> operar con las variables." << endl;
    cout << "5) cout << endl -> mostrar el resultado." << endl;
    cout << "6) Comentarios  -> explicar cada paso al lector." << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
