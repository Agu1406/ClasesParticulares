/*
U01 — Introduccion a la herencia.

Una subclase "es un" tipo de la superclase: Perro es un Animal.
En C++: extends de Java / ":" de C# se escribe "class Hija : public Base",
el constructor de la base se llama en la lista de inicializacion,
y para sobrescribir hace falta virtual en la base + override en la hija.

OBJETIVO:
  - Usar herencia con : public (Perro : public Animal).
  - Llamar al constructor de la base con : Base(...).
  - Sobrescribir metodos con virtual / override.
  - Usar protected para compartir estado con las subclases.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

class Animal
{
protected:
    string nombre;

public:
    Animal(string nombre)
    {
        this->nombre = nombre;
    }

    virtual ~Animal() {}

    string GetNombre()
    {
        return nombre;
    }

    virtual void HacerSonido()
    {
        cout << nombre << " hace un sonido generico..." << endl;
    }

    virtual string ToString()
    {
        return "Animal{nombre='" + nombre + "'}";
    }
};

class Perro : public Animal
{
private:
    string raza;

public:
    // Constructor delegado (equivalente a this(nombre, "mestizo") en C#)
    Perro(string nombre) : Perro(nombre, "mestizo")
    {
    }

    Perro(string nombre, string raza) : Animal(nombre)
    {
        this->raza = raza;
    }

    void HacerSonido() override
    {
        cout << nombre << " dice: ¡Guau!" << endl;
    }

    string GetRaza()
    {
        return raza;
    }

    string ToString() override
    {
        return "Perro{nombre='" + nombre + "', raza='" + raza + "'}";
    }
};

class Gato : public Animal
{
public:
    Gato(string nombre) : Animal(nombre)
    {
    }

    void HacerSonido() override
    {
        cout << nombre << " dice: ¡Miau!" << endl;
    }
};

void ImprimirMenu()
{
    cout << "=== U01 Herencia: Animal / Perro / Gato ===" << endl;
    cout << "1. Crear Animal, Perro y Gato" << endl;
    cout << "2. override de hacerSonido" << endl;
    cout << "3. Base(...) en el constructor" << endl;
    cout << "4. Upcasting (Animal* / Animal& = Perro)" << endl;
    cout << "0. Salir" << endl;
}

/*
PRIMERA PARTE — Tres objetos en stack: el generico usa Animal;
  Perro y Gato heredan nombre y anaden comportamiento propio.
*/
void DemoCrearJerarquia()
{
    cout << "¡DEMO — Crear jerarquia!\n" << endl;

    Animal generico("Criatura");
    Perro perro("Rex", "Pastor aleman");
    Gato gato("Michi");

    cout << generico.ToString() << endl;
    cout << perro.ToString() << endl;
    cout << "Raza del perro: " << perro.GetRaza() << endl;
    cout << gato.ToString() << endl;
}

/*
SEGUNDA PARTE — virtual en Animal + override en Perro/Gato:
  cada llamada ejecuta la version de la clase real.
*/
void DemoOverrideSonido()
{
    cout << "¡DEMO — override de hacerSonido!\n" << endl;

    Animal generico("Criatura");
    Perro perro("Rex", "Pastor aleman");
    Gato gato("Michi");

    generico.HacerSonido();
    perro.HacerSonido();
    gato.HacerSonido();
}

/*
TERCERA PARTE — : Animal(nombre) llama al constructor de Animal
  antes de inicializar raza en Perro.
*/
void DemoBaseConstructor()
{
    cout << "¡DEMO — Base(...) en el constructor!\n" << endl;

    Perro perro("Luna", "Labrador");
    cout << "Nombre heredado: " << perro.GetNombre() << endl;
    cout << "Raza propia: " << perro.GetRaza() << endl;
    cout << "Perro llama a Animal(nombre) y luego guarda la raza." << endl;
}

/*
CUARTA PARTE — Upcasting: referencia Animal, objeto Perro.
  Al llamar HacerSonido se ejecuta la version de Perro (enlace dinamico).
*/
void DemoUpcasting()
{
    cout << "¡DEMO — Upcasting!\n" << endl;

    Perro luna("Luna");
    Animal& referencia = luna;
    referencia.HacerSonido();
    cout << "Nombre: " << referencia.GetNombre() << endl;
    cout << "Tipo declarado: Animal& | Tipo real: Perro" << endl;
}

int main()
{
    int opcion;
    do
    {
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        cout << endl;

        switch (opcion)
        {
            case 1:
                DemoCrearJerarquia();
                break;
            case 2:
                DemoOverrideSonido();
                break;
            case 3:
                DemoBaseConstructor();
                break;
            case 4:
                DemoUpcasting();
                break;
            case 0:
                cout << "Saliendo..." << endl;
                break;
            default:
                cout << "Opcion no valida." << endl;
                break;
        }

        cout << endl;
    } while (opcion != 0);

    return 0;
}
