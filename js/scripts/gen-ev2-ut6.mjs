/** Genera ut6-eventos-formularios. Uso: node js/scripts/gen-ev2-ut6.mjs */
import path from "node:path";
import { fileURLToPath } from "node:url";
import { writeSubtopic, writeRepaso, ten } from "./gen-dwec-lib.mjs";

const ut6 = path.join(path.dirname(fileURLToPath(import.meta.url)), "..", "ev2", "ut6-eventos-formularios");

writeSubtopic(ut6, {
  id: "01-modelo-eventos",
  theory: [{
    file: "01-burbujeo-captura.js",
    title: "Modelo de eventos",
    description: "Fases captura, objetivo y burbujeo.",
    body: `// addEventListener('click', fn, true) → captura\n// false (defecto) → burbujeo\nconsole.log("captura → target → burbujeo");`,
  }],
  exercises: ten("evento", "Evento", [
    ["Log fases del modelo.", "modelo", `// TODO\n`, `console.log("captura, target, burbujeo");`],
    ["Objeto event simulado type.", "type", `// TODO\n`, `const ev={type:"click",target:{tagName:"BUTTON"}}; console.log(ev.type);`],
    ["preventDefault explicación log.", "preventDefault", `// TODO\n`, `console.log("preventDefault cancela acción por defecto");`],
    ["stopPropagation log.", "stopPropagation", `// TODO\n`, `console.log("stopPropagation corta la propagación");`],
    ["event.target vs currentTarget.", "target", `// TODO\n`, `console.log("target: origen; currentTarget: elemento con listener");`],
    ["Tipos mouse: click, dblclick.", "mouse", `// TODO\n`, `["click","dblclick"].forEach(t=>console.log(t));`],
    ["Tipos teclado keydown.", "keyboard", `// TODO\n`, `console.log("keydown, keyup, keypress");`],
    ["Delegación concepto.", "delegación", `// TODO\n`, `console.log("listener en padre para hijos dinámicos");`],
    ["CustomEvent nombre.", "CustomEvent", `// TODO\n`, `console.log("CustomEvent permite eventos propios");`],
    ["Resumen modelo.", "log", `// TODO\n`, `console.log("DOM Level 2 Events");`],
  ]),
});

writeSubtopic(ut6, {
  id: "02-listeners",
  theory: [{
    file: "01-addeventlistener.js",
    title: "addEventListener",
    description: "Registrar y quitar listeners.",
    body: `const btn = document.querySelector("button");\nif (btn) btn.addEventListener("click", () => console.log("click"));`,
  }],
  exercises: ten("listener", "Listener", [
    ["addEventListener click log (si hay botón).", "click", `// TODO\n`, `document.querySelector("button")?.addEventListener("click",()=>console.log("click"));`],
    ["removeEventListener referencia.", "remove", `// TODO\n`, `function fn(){} console.log("guardar referencia para remove");`],
    ["once: true concepto.", "once", `// TODO\n`, `console.log("opción once ejecuta una vez");`],
    ["passive scroll.", "passive", `// TODO\n`, `console.log("passive mejora scroll en touch");`],
    ["Múltiples listeners mismo evento.", "varios", `// TODO\n`, `console.log("varios listeners en orden de registro");`],
    ["keydown log tecla.", "keydown", `// TODO\n`, `document.addEventListener("keydown",e=>console.log(e.key),{once:true});`],
    ["mouseenter vs mouseover.", "mouse", `// TODO\n`, `console.log("mouseenter no burbujea; mouseover sí");`],
    ["load en window.", "load", `// TODO\n`, `console.log("load: documento y recursos cargados");`],
    ["DOMContentLoaded.", "DOMContentLoaded", `// TODO\n`, `console.log("DOM listo antes que imágenes");`],
    ["Resumen listeners.", "log", `// TODO\n`, `console.log("addEventListener, opciones, remove");`],
  ]),
});

writeSubtopic(ut6, {
  id: "03-formularios",
  theory: [{
    file: "01-formularios-html.js",
    title: "Formularios",
    description: "submit, elements y FormData.",
    body: `// form.addEventListener("submit", e => { e.preventDefault(); });\nconsole.log("FormData lee campos del formulario");`,
  }],
  exercises: ten("formulario", "Formulario", [
    ["preventDefault en submit (log).", "submit", `// TODO\n`, `console.log("e.preventDefault() evita recarga");`],
    ["FormData simulado objeto.", "FormData", `// TODO\n`, `console.log("new FormData(form) lee campos");`],
    ["value de input (si existe).", "value", `// TODO\n`, `const i=document.querySelector("input"); if(i) console.log(i.value);`],
    ["checked checkbox.", "checked", `// TODO\n`, `const c=document.querySelector('input[type=checkbox]'); if(c) console.log(c.checked);`],
    ["select selectedIndex.", "select", `// TODO\n`, `const s=document.querySelector("select"); if(s) console.log(s.selectedIndex);`],
    ["required HTML5.", "required", `// TODO\n`, `console.log("atributo required valida en cliente");`],
    ["type email.", "email", `// TODO\n`, `console.log("type=email validación básica");`],
    ["pattern atributo.", "pattern", `// TODO\n`, `console.log("pattern regex en HTML");`],
    ["reset formulario.", "reset", `// TODO\n`, `console.log("form.reset() limpia campos");`],
    ["Resumen formularios.", "log", `// TODO\n`, `console.log("submit, validación, FormData");`],
  ]),
});

writeSubtopic(ut6, {
  id: "04-regexp-validacion",
  theory: [{
    file: "01-regexp-basico.js",
    title: "Expresiones regulares",
    description: "test, match y validación.",
    body: `const email = /^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$/;\nconsole.log(email.test("a@b.com"));`,
  }],
  exercises: ten("regexp", "Regexp", [
    ["test dígitos solo.", "/^\\d+$/", `// TODO\n`, `console.log(/^\\d+$/.test("123"));`],
    ["match palabras.", "match", `// TODO\n`, `console.log("hola mundo".match(/\\w+/g));`],
    ["replace espacios.", "replace", `// TODO\n`, `console.log("a  b".replace(/\\s+/g," "));`],
    ["Validar DNI simple 8 dígitos + letra.", "DNI", `// TODO\n`, `console.log(/^\\d{8}[A-Z]$/i.test("12345678Z"));`],
    ["Teléfono 9 dígitos.", "tel", `// TODO\n`, `console.log(/^\\d{9}$/.test("612345678"));`],
    ["Código postal 5 dígitos.", "cp", `// TODO\n`, `console.log(/^\\d{5}$/.test("28001"));`],
    ["Nombre solo letras.", "nombre", `// TODO\n`, `console.log(/^[A-Za-záéíóúñ\\s]+$/.test("María"));`],
    ["Contraseña min 8 chars.", "password", `// TODO\n`, `console.log(/^.{8,}$/.test("abcdefgh"));`],
    ["Función validar(cadena, regex).", "función", `// TODO\n`, `function validar(s,r){return r.test(s);}\nconsole.log(validar("abc",/abc/));`],
    ["Resumen regexp UT6.", "log", `// TODO\n`, `console.log("RegExp, test, validación formularios");`],
  ]),
});

writeRepaso(ut6, "05-repaso", ten("repaso-ut6", "Repaso UT6", [
    ["Modelo tres fases.", "eventos", `// TODO\n`, `console.log("captura → target → burbujeo");`],
    ["Listener click.", "listener", `// TODO\n`, `document.body?.addEventListener("click",()=>console.log("body"),{once:true});`],
    ["Form submit prevent.", "form", `// TODO\n`, `console.log("preventDefault en submit");`],
    ["Email regex test.", "regexp", `// TODO\n`, `console.log(/^[^\\s@]+@[^\\s@]+$/.test("a@b.co"));`],
    ["Delegación log.", "delegación", `// TODO\n`, `console.log("listener en ul para li");`],
    ["CustomEvent log.", "custom", `// TODO\n`, `console.log("CustomEvent");`],
    ["Validar teléfono.", "tel", `// TODO\n`, `console.log(/^\\d{9}$/.test("600000000"));`],
    ["keydown una vez.", "key", `// TODO\n`, `console.log("keydown listener");`],
    ["RA3 checklist.", "array", `// TODO\n`, `["eventos","listeners","forms","regexp"].forEach((t,i)=>console.log(i+1,t));`],
    ["Cierre UT6.", "log", `// TODO\n`, `console.log("UT6 eventos y formularios repasados");`],
  ]));

console.log("UT6 generada.");
