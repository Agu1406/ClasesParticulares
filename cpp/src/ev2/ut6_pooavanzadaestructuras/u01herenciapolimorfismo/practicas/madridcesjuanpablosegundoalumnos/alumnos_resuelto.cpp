#include <iostream>
#include <vector>
#include <string>
using namespace std;
class Alumno {
public:
  int id; string nombre, apellido; string telefono; string correo; bool hasTel=false, hasCorreo=false;
  double calificacion=0; bool matriculado=true;
  Alumno(int id, string n, string a): id(id), nombre(n), apellido(a) {}
  void mostrarDatos(){
    cout<<"id = "<<id<<"\nnombre = "<<nombre<<"\napellido = "<<apellido<<"\n";
    cout<<"telefono = "<<(hasTel?telefono:"dato no disponible")<<"\n";
    cout<<"correo = "<<(hasCorreo?correo:"dato no disponible")<<"\n";
    cout<<"calificacion = "<<calificacion<<"\nmatriculado = "<<matriculado<<"\n";
  }
  void desmatricular(){ matriculado=false; }
  void calificar(double n){ calificacion=n; }
};
int main(){ vector<Alumno> alumnos; Alumno a(1,"Ada","Lovelace"); a.hasCorreo=true; a.correo="ada@mail.com"; a.calificar(9.5); a.mostrarDatos(); return 0; }
