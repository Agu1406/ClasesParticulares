// Centralita CES — espejo Kotlin
using System;
using System.Collections.Generic;

abstract class Llamada {
    public string NOrigen, NDestino; public int Duracion; public double Coste;
    public Llamada(string o, string d, int dur) { NOrigen=o; NDestino=d; Duracion=dur; Coste=CalcularCoste(); }
    public abstract double CalcularCoste();
    public virtual void MostrarDatos() {
        Console.WriteLine($"Origen = {NOrigen}"); Console.WriteLine($"Destino = {NDestino}");
        Console.WriteLine($"Duracion = {Duracion}"); Console.WriteLine($"Coste = {Coste}");
    }
}
class LlamadaLocal : Llamada {
    public LlamadaLocal(string o,string d,int dur):base(o,d,dur){}
    public override double CalcularCoste() => 0;
    public override void MostrarDatos(){ Console.WriteLine("Tipo = Local"); base.MostrarDatos(); }
}
class LlamadaProvincial : Llamada {
    public LlamadaProvincial(string o,string d,int dur):base(o,d,dur){}
    public override double CalcularCoste() => Duracion * 0.15;
    public override void MostrarDatos(){ Console.WriteLine("Tipo = Provincial"); base.MostrarDatos(); }
}
class LlamadaNacional : Llamada {
    public int Franja;
    public LlamadaNacional(string o,string d,int dur,int f):base(o,d,dur){ Franja=f; Coste=CalcularCoste(); }
    public override double CalcularCoste() => Duracion * (Franja==2?0.25:Franja==3?0.30:0.20);
    public override void MostrarDatos(){ Console.WriteLine("Tipo = Nacional"); Console.WriteLine($"Franja = {Franja}"); base.MostrarDatos(); }
}
class Centralita {
    public List<Llamada> Llamadas = new();
    public void Registrar(Llamada l){ Llamadas.Add(l); Console.WriteLine("Llamada registrada"); l.MostrarDatos(); }
    public void Mostrar(){ foreach(var l in Llamadas) l.MostrarDatos(); }
    public void Costes(){ double t=0; foreach(var l in Llamadas) t+=l.Coste; Console.WriteLine($"Coste total = {t}"); }
}
class CentralitaResuelto {
    static void Main() {
        var c = new Centralita(); int op;
        do {
            Console.WriteLine("1 Local 2 Provincial 3 Nacional 4 Mostrar 5 Costes 6 Salir");
            op = int.Parse(Console.ReadLine()!);
            if (op==1) c.Registrar(new LlamadaLocal(Console.ReadLine()!, Console.ReadLine()!, int.Parse(Console.ReadLine()!)));
            else if (op==2) c.Registrar(new LlamadaProvincial(Console.ReadLine()!, Console.ReadLine()!, int.Parse(Console.ReadLine()!)));
            else if (op==3) c.Registrar(new LlamadaNacional(Console.ReadLine()!, Console.ReadLine()!, int.Parse(Console.ReadLine()!), int.Parse(Console.ReadLine()!)));
            else if (op==4) c.Mostrar();
            else if (op==5) c.Costes();
        } while(op!=6);
    }
}
