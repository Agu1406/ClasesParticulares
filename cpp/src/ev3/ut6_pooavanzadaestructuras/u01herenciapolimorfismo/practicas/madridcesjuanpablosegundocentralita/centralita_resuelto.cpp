#include <iostream>
#include <vector>
#include <string>
#include <memory>
using namespace std;

class Llamada {
public:
    string nOrigen, nDestino; int duracion; double coste;
    Llamada(string o, string d, int dur): nOrigen(o), nDestino(d), duracion(dur), coste(0) {}
    virtual ~Llamada() = default;
    virtual double calcularCoste() = 0;
    virtual void mostrarDatos() {
        cout << "Origen = " << nOrigen << "\nDestino = " << nDestino
             << "\nDuracion = " << duracion << "\nCoste = " << coste << "\n";
    }
};
class LlamadaLocal: public Llamada {
public:
    LlamadaLocal(string o,string d,int dur): Llamada(o,d,dur){ coste=calcularCoste(); }
    double calcularCoste() override { return 0; }
    void mostrarDatos() override { cout << "Tipo = Local\n"; Llamada::mostrarDatos(); }
};
class LlamadaProvincial: public Llamada {
public:
    LlamadaProvincial(string o,string d,int dur): Llamada(o,d,dur){ coste=calcularCoste(); }
    double calcularCoste() override { return duracion * 0.15; }
    void mostrarDatos() override { cout << "Tipo = Provincial\n"; Llamada::mostrarDatos(); }
};
class LlamadaNacional: public Llamada {
public:
    int franja;
    LlamadaNacional(string o,string d,int dur,int f): Llamada(o,d,dur), franja(f){ coste=calcularCoste(); }
    double calcularCoste() override {
        double p = 0.20; if(franja==2) p=0.25; else if(franja==3) p=0.30; return duracion*p;
    }
    void mostrarDatos() override { cout << "Tipo = Nacional\nFranja = " << franja << "\n"; Llamada::mostrarDatos(); }
};

int main() {
    vector<unique_ptr<Llamada>> llamadas;
    llamadas.push_back(make_unique<LlamadaLocal>("600","601",60));
    llamadas.push_back(make_unique<LlamadaProvincial>("600","602",100));
    llamadas.push_back(make_unique<LlamadaNacional>("600","603",100,2));
    double total=0;
    for (auto& l : llamadas) { l->mostrarDatos(); total += l->coste; }
    cout << "Coste total = " << total << "\n";
    return 0;
}
