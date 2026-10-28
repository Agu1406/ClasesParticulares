# Tests interactivos

Mismo sistema que los tests de Java y JavaFX (modo **Examen** sin feedback y modo **Estudio** con feedback al momento). El motor está en `js/test.js` y `js/test-estudio.js`. El catálogo de esta rama empieza por el examen de C.

Abrir `index.html` en el navegador, o servir la raíz del repositorio y entrar en `tests/`.

## C — de cero a bucles

- Banco: `js/questions/c-basico-hasta-bucles.js` (24 preguntas).
- Examen: `tests/c/test-c-basico-bucles.html`
- Estudio: `tests/c/test-c-basico-bucles-estudio.html`
- Temario: `c/src/ev1` hasta `ut2_controlflujometodos/u03bucles`. No entran funciones, cadenas ni struct.
- El mismo banco se hace dentro del portal, en `/examen/c-basico-bucles`.

Las preguntas se barajan en cada intento (Fisher-Yates). Cancelar vuelve a `tests/index.html`.

## Añadir otro test

No copies el motor. Crea el banco y dos HTML que lo carguen. El contrato está en `.cursor/rules/tests-interactivos.mdc`.
