// Centralita CES — Node / navegador consola simplificada
class Llamada {
  constructor(nOrigen, nDestino, duracion) {
    this.nOrigen = nOrigen; this.nDestino = nDestino; this.duracion = duracion;
    this.coste = this.calcularCoste();
  }
  calcularCoste() { throw new Error("abstract"); }
  mostrarDatos() {
    console.log(`Origen = ${this.nOrigen}`); console.log(`Destino = ${this.nDestino}`);
    console.log(`Duracion = ${this.duracion}`); console.log(`Coste = ${this.coste}`);
  }
}
class LlamadaLocal extends Llamada {
  calcularCoste() { return 0; }
  mostrarDatos() { console.log("Tipo = Local"); super.mostrarDatos(); }
}
class LlamadaProvincial extends Llamada {
  calcularCoste() { return this.duracion * 0.15; }
  mostrarDatos() { console.log("Tipo = Provincial"); super.mostrarDatos(); }
}
class LlamadaNacional extends Llamada {
  constructor(o, d, dur, franja) { super(o, d, dur); this.franja = franja; this.coste = this.calcularCoste(); }
  calcularCoste() {
    const p = this.franja === 2 ? 0.25 : this.franja === 3 ? 0.30 : 0.20;
    return this.duracion * p;
  }
  mostrarDatos() { console.log("Tipo = Nacional"); console.log(`Franja = ${this.franja}`); super.mostrarDatos(); }
}
class Centralita {
  constructor() { this.llamadas = []; }
  registrar(l) { this.llamadas.push(l); console.log("Llamada registrada"); l.mostrarDatos(); }
  mostrar() { this.llamadas.forEach(l => l.mostrarDatos()); }
  costes() { console.log(`Coste total = ${this.llamadas.reduce((a, l) => a + l.coste, 0)}`); }
}
// Demo
const c = new Centralita();
c.registrar(new LlamadaLocal("600","601",60));
c.registrar(new LlamadaProvincial("600","602",100));
c.registrar(new LlamadaNacional("600","603",100,2));
c.mostrar(); c.costes();
