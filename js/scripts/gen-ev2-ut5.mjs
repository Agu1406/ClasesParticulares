/** Genera ut5-poo-colecciones. Uso: node js/scripts/gen-ev2-ut5.mjs */
import path from "node:path";
import { fileURLToPath } from "node:url";
import { writeSubtopic, writeRepaso, ten } from "./gen-dwec-lib.mjs";

const ut5 = path.join(path.dirname(fileURLToPath(import.meta.url)), "..", "ev2", "ut5-poo-colecciones");

writeSubtopic(ut5, {
  id: "01-funciones",
  theory: [{
    file: "01-funciones-declaracion.js",
    title: "Funciones",
    description: "Declaración, expresión y arrow functions.",
    body: `function suma(a, b) { return a + b; }\nconst resta = (a, b) => a - b;\nconsole.log(suma(2, 3), resta(5, 2));`,
  }],
  exercises: ten("funcion", "Función", [
    ["Función suma dos números.", "return", `// TODO\n`, `function suma(a,b){return a+b;}\nconsole.log(suma(3,4));`],
    ["Arrow duplicar.", "=>", `// TODO\n`, `const duplicar = n => n * 2;\nconsole.log(duplicar(5));`],
    ["Parámetros por defecto.", "default", `// TODO\n`, `function saludar(nombre="invitado"){console.log("Hola",nombre);}\nsaludar();`],
    ["Rest ...nums suma.", "rest", `// TODO\n`, `function total(...nums){return nums.reduce((a,b)=>a+b,0);}\nconsole.log(total(1,2,3));`],
    ["Callback map doble.", "map", `// TODO\n`, `console.log([1,2,3].map(n=>n*2));`],
    ["IIFE log.", "IIFE", `// TODO\n`, `(function(){console.log("IIFE");})();`],
    ["Recursión factorial 5.", "recursión", `// TODO\n`, `function fact(n){return n<=1?1:n*fact(n-1);}\nconsole.log(fact(5));`],
    ["Scope: let dentro de bloque.", "let", `// TODO\n`, `{ let x=1; console.log(x); }`],
    ["Función como valor en array.", "first-class", `// TODO\n`, `const ops=[n=>n+1]; console.log(ops[0](4));`],
    ["Resumen funciones.", "log", `// TODO\n`, `console.log("declaración, flecha, callback");`],
  ]),
});

writeSubtopic(ut5, {
  id: "02-arrays",
  theory: [{
    file: "01-metodos-arrays.js",
    title: "Arrays",
    description: "push, map, filter, reduce.",
    body: `const nums = [1, 2, 3];\nconsole.log(nums.map(n => n * 2));\nconsole.log(nums.filter(n => n > 1));`,
  }],
  exercises: ten("array", "Array", [
    ["push y pop.", "mutación", `// TODO\n`, `const a=[1]; a.push(2); a.pop(); console.log(a);`],
    ["map cuadrados.", "map", `// TODO\n`, `console.log([1,2,3].map(n=>n*n));`],
    ["filter pares.", "filter", `// TODO\n`, `console.log([1,2,3,4].filter(n=>n%2===0));`],
    ["reduce suma.", "reduce", `// TODO\n`, `console.log([1,2,3].reduce((s,n)=>s+n,0));`],
    ["find primer >3.", "find", `// TODO\n`, `console.log([1,5,2].find(n=>n>3));`],
    ["some incluye 3.", "some", `// TODO\n`, `console.log([1,2,3].some(n=>n===3));`],
    ["every positivos.", "every", `// TODO\n`, `console.log([1,2,3].every(n=>n>0));`],
    ["slice copia.", "slice", `// TODO\n`, `const b=[1,2,3]; console.log(b.slice(0,2));`],
    ["sort números.", "sort", `// TODO\n`, `console.log([3,1,2].sort((a,b)=>a-b));`],
    ["join con guión.", "join", `// TODO\n`, `console.log(["a","b"].join("-"));`],
  ]),
});

writeSubtopic(ut5, {
  id: "03-objetos-y-clases",
  theory: [{
    file: "01-clases-es6.js",
    title: "Clases ES6",
    description: "class, constructor y métodos.",
    body: `class Persona {\n  constructor(nombre) { this.nombre = nombre; }\n  saludar() { return "Hola " + this.nombre; }\n}\nconsole.log(new Persona("Ana").saludar());`,
  }],
  exercises: ten("clase", "Clase", [
    ["Clase Rectangulo area.", "class", `// TODO\n`, `class Rectangulo{constructor(a,b){this.a=a;this.b=b;} area(){return this.a*this.b;}}\nconsole.log(new Rectangulo(2,3).area());`],
    ["Objeto literal libro.", "literal", `// TODO\n`, `const libro={titulo:"JS",leer(){return this.titulo}}; console.log(libro.leer());`],
    ["Getter nombre.", "get", `// TODO\n`, `class P{constructor(n){this._n=n;} get nombre(){return this._n;}}\nconsole.log(new P("Luis").nombre);`],
    ["Método estático suma.", "static", `// TODO\n`, `class M{static suma(a,b){return a+b;}}\nconsole.log(M.suma(1,2));`],
    ["Array de instancias.", "array", `// TODO\n`, `class Punto{constructor(x){this.x=x;}}\nconsole.log([new Punto(1),new Punto(2)].map(p=>p.x));`],
    ["Object.keys.", "keys", `// TODO\n`, `console.log(Object.keys({a:1,b:2}));`],
    ["Spread copia objeto.", "spread", `// TODO\n`, `const o={a:1}; console.log({...o,b:2});`],
    ["Destructuring.", "destructuring", `// TODO\n`, `const {x,y}={x:1,y:2}; console.log(x,y);`],
    ["instanceof.", "instanceof", `// TODO\n`, `class A{}; console.log(new A() instanceof A);`],
    ["Resumen POO.", "log", `// TODO\n`, `console.log("clases, objetos, prototipos");`],
  ]),
});

writeSubtopic(ut5, {
  id: "04-herencia",
  theory: [{
    file: "01-herencia-extends.js",
    title: "Herencia",
    description: "extends y super.",
    body: `class Animal {\n  hablar() { return "..."; }\n}\nclass Perro extends Animal {\n  hablar() { return super.hablar() + " guau"; }\n}\nconsole.log(new Perro().hablar());`,
  }],
  exercises: ten("herencia", "Herencia", [
    ["extends Empleado de Persona.", "extends", `// TODO\n`, `class Persona{constructor(n){this.n=n;}}\nclass Empleado extends Persona{dept="IT";}\nconsole.log(new Empleado("Ana").dept);`],
    ["super en constructor.", "super", `// TODO\n`, `class B extends Array{constructor(){super();}}\nconsole.log(new B().length);`],
    ["Override método.", "override", `// TODO\n`, `class A{m(){return 1;}} class B extends A{m(){return super.m()+1;}}\nconsole.log(new B().m());`],
    ["Prototipo manual.", "prototype", `// TODO\n`, `function F(){} F.prototype.x=1; console.log(new F().x);`],
    ["Object.create.", "create", `// TODO\n`, `const base={a:1}; const hijo=Object.create(base); console.log(hijo.a);`],
    ["Cadena prototipos.", "chain", `// TODO\n`, `class X{} class Y extends X{} console.log(new Y() instanceof X);`],
    ["Mixin simple Object.assign.", "assign", `// TODO\n`, `const a={m:()=>1}; const b=Object.assign({},a); console.log(b.m());`],
    ["instanceof cadena.", "instanceof", `// TODO\n`, `class A{} class B extends A{} console.log(new B() instanceof A);`],
    ["Polimorfismo array hablar.", "polimorfismo", `// TODO\n`, `class A{h(){return"a";}} class B extends A{h(){return"b";}}\nconsole.log([new A(),new B()].map(x=>x.h()));`],
    ["Cierre herencia UT5.", "log", `// TODO\n`, `console.log("extends, super, prototipos");`],
  ]),
});

writeRepaso(ut5, "05-repaso", ten("repaso-ut5", "Repaso UT5", [
    ["suma con función.", "función", `// TODO\n`, `const suma=(a,b)=>a+b; console.log(suma(1,2));`],
    ["filter map pipeline.", "arrays", `// TODO\n`, `console.log([1,2,3,4].filter(n=>n%2).map(n=>n*10));`],
    ["Clase y método.", "clase", `// TODO\n`, `class C{m(){return 1;}} console.log(new C().m());`],
    ["Herencia simple.", "extends", `// TODO\n`, `class P{} class H extends P{} console.log(new H() instanceof P);`],
    ["reduce media.", "reduce", `// TODO\n`, `const v=[2,4,6]; console.log(v.reduce((s,n)=>s+n,0)/v.length);`],
    ["Object.entries.", "entries", `// TODO\n`, `console.log(Object.entries({a:1}));`],
    ["Rest en función.", "rest", `// TODO\n`, `const max=(...n)=>Math.max(...n); console.log(max(3,7,2));`],
    ["findIndex.", "findIndex", `// TODO\n`, `console.log([10,20,30].findIndex(n=>n===20));`],
    ["RA3 checklist.", "array", `// TODO\n`, `["funciones","arrays","clases"].forEach((t,i)=>console.log(i+1,t));`],
    ["Cierre UT5.", "log", `// TODO\n`, `console.log("UT5 POO y colecciones repasadas");`],
  ]));

console.log("UT5 generada.");
