/**
 * Primera aparición (en TypeScript / TSX) del botón con la clase `.boton-tutorial`.
 *
 * En las lecciones 01–02 el mismo botón estaba en JSX; aquí unimos el patrón del tutorial
 * oficial (importar una hoja CSS y usar una clase). En el tutorial de react.dev suele ser
 * `import './styles.css'` en el mismo componente; en este repo las reglas compartidas del
 * curso están en `src/App.css`, cargadas una vez desde `App.tsx`, para no repetir imports.
 *
 * Las lecciones 04–05 reutilizan este componente sin cambios (re-export desde esta carpeta).
 *
 * @see https://es.react.dev/learn
 */
export default function MyButton() {
    return <button className="boton-tutorial">Soy un botón</button>;
}
