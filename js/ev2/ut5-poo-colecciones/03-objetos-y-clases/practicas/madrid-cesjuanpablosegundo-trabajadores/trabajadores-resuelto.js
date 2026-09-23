class Trabajador { constructor(nombre,apellido,dni,sueldo){ this.nombre=nombre; this.apellido=apellido; this.dni=dni; this.sueldo=sueldo; }
  calcularSalarioMensual(){ throw new Error("abstract"); }
  mostrarDatos(){ console.log(`nombre = ${this.nombre}`); console.log(`dni = ${this.dni}`); console.log(`salario mensual = ${this.calcularSalarioMensual()}`); } }
class Asalariado extends Trabajador { constructor(n,a,d,s,pagas,cuota){ super(n,a,d,s); this.pagas=pagas; this.cuota=cuota; }
  calcularSalarioMensual(){ return (this.sueldo*0.79)/this.pagas; } mostrarDatos(){ console.log("Tipo = Asalariado"); super.mostrarDatos(); } }
class Autonomo extends Trabajador { constructor(n,a,d,s,cuota){ super(n,a,d,s); this.cuota=cuota; }
  calcularSalarioMensual(){ return (this.sueldo-12*this.cuota)/12; } mostrarDatos(){ console.log("Tipo = Autonomo"); super.mostrarDatos(); } }
class Jefe extends Trabajador { constructor(n,a,d,s,acciones,beneficio){ super(n,a,d,s); this.acciones=acciones; this.beneficio=beneficio; }
  calcularSalarioMensual(){ return this.sueldo/12; } mostrarDatos(){ console.log("Tipo = Jefe"); super.mostrarDatos(); } }
const lista = [new Asalariado("Ana","G","1A",24000,14,100), new Autonomo("Luis","P","2B",30000,200), new Jefe("Eva","R","3C",60000,10,1000)];
lista.forEach(t => t.mostrarDatos());
