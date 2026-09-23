using System; using System.Collections.Generic;
class Alumno{ public int Id; public string Nombre,Apellido; public string? Telefono,Correo; public double Calificacion; public bool Matriculado=true;
  public Alumno(int id,string n,string a,string? t,string? c){Id=id;Nombre=n;Apellido=a;Telefono=t;Correo=c;}
  public void MostrarDatos(){ Console.WriteLine($"id = {Id}"); Console.WriteLine($"nombre = {Nombre}"); Console.WriteLine($"telefono = {Telefono??"dato no disponible"}"); Console.WriteLine($"correo = {Correo??"dato no disponible"}"); Console.WriteLine($"calificacion = {Calificacion}"); Console.WriteLine($"matriculado = {Matriculado}"); }
  public void Desmatricular(){ Matriculado=false; } public void Calificar(double n){ Calificacion=n; } }
class AlumnosResuelto{ static void Main(){ var alumnos=new List<Alumno>(); int next=1,op; do{
  Console.WriteLine("1 Matricular 2 Listar 3 Mostrar 4 Desmatricular 5 Calificar 6 Salir"); op=int.Parse(Console.ReadLine()!);
  if(op==1){ var n=Console.ReadLine()!; var a=Console.ReadLine()!; var t=Console.ReadLine(); if(string.IsNullOrWhiteSpace(t)) t=null; var c=Console.ReadLine(); if(string.IsNullOrWhiteSpace(c)) c=null;
    var al=new Alumno(next++,n,a,t,c); alumnos.Add(al); al.MostrarDatos(); }
  else if(op==2) foreach(var al in alumnos) al.MostrarDatos();
  else if(op==3){ var id=int.Parse(Console.ReadLine()!); foreach(var al in alumnos) if(al.Id==id) al.MostrarDatos(); }
  else if(op==4){ var id=int.Parse(Console.ReadLine()!); foreach(var al in alumnos) if(al.Id==id) al.Desmatricular(); }
  else if(op==5){ var id=int.Parse(Console.ReadLine()!); var nota=double.Parse(Console.ReadLine()!); foreach(var al in alumnos) if(al.Id==id) al.Calificar(nota); }
} while(op!=6);} }
