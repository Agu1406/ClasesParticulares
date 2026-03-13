// Banco de preguntas teóricas del examen de Programación (Pruebas libres 2021).
// Cada objeto representa una de las 40 preguntas tipo test.

window.bancoExamenes = window.bancoExamenes || {};

window.bancoExamenes.programacion2021 = [
  {
    numero: 1,
    enunciado:
      "¿Qué hace el siguiente programa?\nint x = 0;\nint y = 0;\nwhile (x < 10) {\n  y += x;\n  x++;\n}\nSystem.out.println(y);",
    opciones: [
      "Sumar uno a uno los valores de x hasta llegar a 10.",
      "Suma y acaba obteniendo un 11 en la variable y.",
      "Calcular la suma de los números 0 al 9.",
      "Ninguna de las tres respuestas es correcta."
    ],
    correcta: 2,
    explicacion:
      "Dentro del while se va sumando a y el valor de x desde 0 hasta 9. El resultado es la suma 0+1+...+9 = 45."
  },
  // ... resto de preguntas copiadas desde el script original ...
];

