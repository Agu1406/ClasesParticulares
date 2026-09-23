class Figura { calcularArea(){ throw new Error("abstract"); } mostrarDatos(){ console.log(`Area = ${this.calcularArea()}`); } }
class Circulo extends Figura { constructor(radio){ super(); this.radio=radio; } calcularDiametro(){ return 2*this.radio; } calcularArea(){ return Math.PI*this.radio*this.radio; }
  mostrarDatos(){ console.log("Tipo = Circulo"); console.log(`Radio = ${this.radio}`); console.log(`Diametro = ${this.calcularDiametro()}`); super.mostrarDatos(); } }
class Rectangulo extends Figura { constructor(base,altura){ super(); this.base=base; this.altura=altura; } calcularPerimetro(){ return 2*(this.base+this.altura); } calcularArea(){ return this.base*this.altura; }
  mostrarDatos(){ console.log("Tipo = Rectangulo"); console.log(`Base = ${this.base}`); console.log(`Altura = ${this.altura}`); console.log(`Perimetro = ${this.calcularPerimetro()}`); super.mostrarDatos(); } }
class Triangulo extends Figura { constructor(base,altura){ super(); this.base=base; this.altura=altura; } calcularArea(){ return (this.base*this.altura)/2; }
  mostrarDatos(){ console.log("Tipo = Triangulo"); console.log(`Base = ${this.base}`); console.log(`Altura = ${this.altura}`); super.mostrarDatos(); } }
const figuras = [new Circulo(3), new Rectangulo(2,4), new Triangulo(3,6)];
figuras.forEach(f => f.mostrarDatos());
console.log(`Area total = ${figuras.reduce((a,f)=>a+f.calcularArea(),0)}`);
