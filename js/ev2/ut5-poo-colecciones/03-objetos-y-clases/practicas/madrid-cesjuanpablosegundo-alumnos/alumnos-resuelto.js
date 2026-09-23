class Alumno {
  constructor(id, nombre, apellido, telefono=null, correo=null) {
    this.id=id; this.nombre=nombre; this.apellido=apellido; this.telefono=telefono; this.correo=correo;
    this.calificacion=0; this.matriculado=true;
  }
  mostrarDatos(){
    console.log(`id = ${this.id}`); console.log(`nombre = ${this.nombre}`);
    console.log(`telefono = ${this.telefono ?? "dato no disponible"}`);
    console.log(`correo = ${this.correo ?? "dato no disponible"}`);
    console.log(`calificacion = ${this.calificacion}`); console.log(`matriculado = ${this.matriculado}`);
  }
  desmatricular(){ this.matriculado=false; }
  calificar(n){ this.calificacion=n; }
}
const alumnos = [new Alumno(1,"Ada","Lovelace",null,"ada@mail.com")];
alumnos[0].calificar(9.5); alumnos[0].mostrarDatos();
