#include <iostream>
#include <vector>
#include <memory>
#include <cmath>
using namespace std;
class Figura { public: virtual ~Figura()=default; virtual double calcularArea()=0;
  virtual void mostrarDatos(){ cout << "Area = " << calcularArea() << "\n"; } };
class Circulo: public Figura { public: double radio; Circulo(double r):radio(r){}
  double diametro(){ return 2*radio; } double calcularArea() override { return M_PI*radio*radio; }
  void mostrarDatos() override { cout << "Tipo = Circulo\nRadio = "<<radio<<"\nDiametro = "<<diametro()<<"\n"; Figura::mostrarDatos(); } };
class Rectangulo: public Figura { public: double base,altura; Rectangulo(double b,double a):base(b),altura(a){}
  double perimetro(){ return 2*(base+altura); } double calcularArea() override { return base*altura; }
  void mostrarDatos() override { cout << "Tipo = Rectangulo\n"; Figura::mostrarDatos(); } };
class Triangulo: public Figura { public: double base,altura; Triangulo(double b,double a):base(b),altura(a){}
  double calcularArea() override { return (base*altura)/2; }
  void mostrarDatos() override { cout << "Tipo = Triangulo\n"; Figura::mostrarDatos(); } };
int main(){ vector<unique_ptr<Figura>> f; f.push_back(make_unique<Circulo>(3)); f.push_back(make_unique<Rectangulo>(2,4)); f.push_back(make_unique<Triangulo>(3,6));
  double t=0; for(auto& x:f){ x->mostrarDatos(); t+=x->calcularArea(); } cout<<"Area total = "<<t<<"\n"; return 0; }
