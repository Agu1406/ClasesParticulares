using System; using System.Collections.Generic; using System.Linq;
abstract class Trabajador{ public string Nombre,Apellido,Dni; public double Sueldo;
  public Trabajador(string n,string a,string d,double s){Nombre=n;Apellido=a;Dni=d;Sueldo=s;}
  public abstract double CalcularSalarioMensual();
  public virtual void MostrarDatos(){ Console.WriteLine($"nombre = {Nombre}"); Console.WriteLine($"dni = {Dni}"); Console.WriteLine($"salario mensual = {CalcularSalarioMensual()}"); } }
class Asalariado:Trabajador{ public int Pagas; public double Cuota; public Asalariado(string n,string a,string d,double s,int p,double c):base(n,a,d,s){Pagas=p;Cuota=c;}
  public override double CalcularSalarioMensual()=>(Sueldo*0.79)/Pagas; public override void MostrarDatos(){Console.WriteLine("Tipo = Asalariado"); base.MostrarDatos();} }
class Autonomo:Trabajador{ public double Cuota; public Autonomo(string n,string a,string d,double s,double c):base(n,a,d,s){Cuota=c;}
  public override double CalcularSalarioMensual()=>(Sueldo-12*Cuota)/12; public override void MostrarDatos(){Console.WriteLine("Tipo = Autonomo"); base.MostrarDatos();} }
class Jefe:Trabajador{ public int Acciones; public double Beneficio; public Jefe(string n,string a,string d,double s,int ac,double b):base(n,a,d,s){Acciones=ac;Beneficio=b;}
  public override double CalcularSalarioMensual()=>Sueldo/12; public override void MostrarDatos(){Console.WriteLine("Tipo = Jefe"); base.MostrarDatos();} }
class TrabajadoresResuelto{ static void Main(){ var lista=new List<Trabajador>(); int op; do{
  Console.WriteLine("1 Asalariado 2 Autonomo 3 Jefe 4 Listar 5 DNI 6 Despedir 7 Salir"); op=int.Parse(Console.ReadLine()!);
  if(op==1) lista.Add(new Asalariado(Console.ReadLine()!,Console.ReadLine()!,Console.ReadLine()!,double.Parse(Console.ReadLine()!),int.Parse(Console.ReadLine()!),double.Parse(Console.ReadLine()!)));
  else if(op==2) lista.Add(new Autonomo(Console.ReadLine()!,Console.ReadLine()!,Console.ReadLine()!,double.Parse(Console.ReadLine()!),double.Parse(Console.ReadLine()!)));
  else if(op==3) lista.Add(new Jefe(Console.ReadLine()!,Console.ReadLine()!,Console.ReadLine()!,double.Parse(Console.ReadLine()!),int.Parse(Console.ReadLine()!),double.Parse(Console.ReadLine()!)));
  else if(op==4) foreach(var t in lista) t.MostrarDatos();
  else if(op==5){ var dni=Console.ReadLine()!; foreach(var t in lista) if(t.Dni.Equals(dni,StringComparison.OrdinalIgnoreCase)) t.MostrarDatos(); }
  else if(op==6){ var dj=Console.ReadLine()!; var dt=Console.ReadLine()!;
    if(!lista.Any(t=>t is Jefe && t.Dni.Equals(dj,StringComparison.OrdinalIgnoreCase))) Console.WriteLine("El DNI del jefe no es correcto");
    else { lista.RemoveAll(t=>t.Dni.Equals(dt,StringComparison.OrdinalIgnoreCase) && t is not Jefe); Console.WriteLine("Trabajador despedido"); } }
} while(op!=7);} }
