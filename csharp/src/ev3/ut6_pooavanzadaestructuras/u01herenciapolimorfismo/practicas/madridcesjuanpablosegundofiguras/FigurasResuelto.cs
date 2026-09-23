using System; using System.Collections.Generic;
abstract class Figura { public abstract double CalcularArea(); public virtual void MostrarDatos()=>Console.WriteLine($"Area = {CalcularArea()}"); }
class Circulo:Figura{ public double Radio; public Circulo(double r){Radio=r;} public double Diametro()=>2*Radio; public override double CalcularArea()=>Math.PI*Radio*Radio;
  public override void MostrarDatos(){Console.WriteLine("Tipo = Circulo");Console.WriteLine($"Radio = {Radio}");Console.WriteLine($"Diametro = {Diametro()}");base.MostrarDatos();} }
class Rectangulo:Figura{ public double Base,Altura; public Rectangulo(double b,double a){Base=b;Altura=a;} public double Perimetro()=>2*(Base+Altura); public override double CalcularArea()=>Base*Altura;
  public override void MostrarDatos(){Console.WriteLine("Tipo = Rectangulo");Console.WriteLine($"Base = {Base}");Console.WriteLine($"Altura = {Altura}");Console.WriteLine($"Perimetro = {Perimetro()}");base.MostrarDatos();} }
class Triangulo:Figura{ public double Base,Altura; public Triangulo(double b,double a){Base=b;Altura=a;} public override double CalcularArea()=>(Base*Altura)/2;
  public override void MostrarDatos(){Console.WriteLine("Tipo = Triangulo");Console.WriteLine($"Base = {Base}");Console.WriteLine($"Altura = {Altura}");base.MostrarDatos();} }
class FigurasResuelto{ static void Main(){ var list=new List<Figura>(); int op; do{ Console.WriteLine("1 Circulo 2 Rectangulo 3 Triangulo 4 Listar 5 Total 6 Salir"); op=int.Parse(Console.ReadLine()!);
  if(op==1) list.Add(new Circulo(double.Parse(Console.ReadLine()!)));
  else if(op==2) list.Add(new Rectangulo(double.Parse(Console.ReadLine()!), double.Parse(Console.ReadLine()!)));
  else if(op==3) list.Add(new Triangulo(double.Parse(Console.ReadLine()!), double.Parse(Console.ReadLine()!)));
  else if(op==4) foreach(var f in list) f.MostrarDatos();
  else if(op==5){ double t=0; foreach(var f in list) t+=f.CalcularArea(); Console.WriteLine($"Area total = {t}"); }
} while(op!=6);} }
