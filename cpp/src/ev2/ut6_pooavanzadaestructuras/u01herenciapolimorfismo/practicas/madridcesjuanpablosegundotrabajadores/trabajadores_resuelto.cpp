#include <iostream>
#include <vector>
#include <memory>
#include <string>
using namespace std;
class Trabajador { public: string nombre,apellido,dni; double sueldo;
  Trabajador(string n,string a,string d,double s):nombre(n),apellido(a),dni(d),sueldo(s){}
  virtual ~Trabajador()=default; virtual double calcularSalarioMensual()=0;
  virtual void mostrarDatos(){ cout<<"nombre = "<<nombre<<"\ndni = "<<dni<<"\nsalario mensual = "<<calcularSalarioMensual()<<"\n"; } };
class Asalariado: public Trabajador { public: int pagas; double cuota;
  Asalariado(string n,string a,string d,double s,int p,double c):Trabajador(n,a,d,s),pagas(p),cuota(c){}
  double calcularSalarioMensual() override { return (sueldo*0.79)/pagas; }
  void mostrarDatos() override { cout<<"Tipo = Asalariado\n"; Trabajador::mostrarDatos(); } };
class Autonomo: public Trabajador { public: double cuota;
  Autonomo(string n,string a,string d,double s,double c):Trabajador(n,a,d,s),cuota(c){}
  double calcularSalarioMensual() override { return (sueldo-12*cuota)/12; }
  void mostrarDatos() override { cout<<"Tipo = Autonomo\n"; Trabajador::mostrarDatos(); } };
class Jefe: public Trabajador { public: int acciones; double beneficio;
  Jefe(string n,string a,string d,double s,int ac,double b):Trabajador(n,a,d,s),acciones(ac),beneficio(b){}
  double calcularSalarioMensual() override { return sueldo/12; }
  void mostrarDatos() override { cout<<"Tipo = Jefe\n"; Trabajador::mostrarDatos(); } };
int main(){ vector<unique_ptr<Trabajador>> lista;
  lista.push_back(make_unique<Asalariado>("Ana","G","1A",24000,14,100));
  lista.push_back(make_unique<Autonomo>("Luis","P","2B",30000,200));
  lista.push_back(make_unique<Jefe>("Eva","R","3C",60000,10,1000));
  for(auto& t: lista) t->mostrarDatos(); return 0; }
