/**
 * Lección 02 — Escribir marcado JSX (.jsx frente a .tsx).
 *
 * @see https://es.react.dev/learn
 */
import MyButton from './MyButton';

const jsxVsTsxSnippet = `// Mismo componente; el archivo puede ser .jsx (JS) o .tsx (TS)
export default function MyButton() {
  return <button className="boton-tutorial">Soy un botón</button>;
}`;

export default function MyApp() {
    return (
        <section className="leccion-cuerpo" aria-label="Lección 02 — Marcado JSX">
            <h2 className="learn-title">Escribir en marcado JSX</h2>
            <p className="learn-info">
                React usa JSX para mezclar marcado con JavaScript. Puedes usar archivos{' '}
                <code>.jsx</code> (JavaScript) o <code>.tsx</code> (TypeScript con tipos en tiempo
                de compilación).
            </p>
            <ul className="learn-info">
                <li>
                    <strong>.jsx</strong>: sin tipado estático; el análisis de tipos depende de
                    linters u otras herramientas.
                </li>
                <li>
                    <strong>.tsx</strong>: TypeScript + JSX; errores de tipos antes de ejecutar.
                </li>
            </ul>
            <pre className="learn-code">
                <code>{jsxVsTsxSnippet}</code>
            </pre>

            <div className="learn-react">
                <h1>Mi primera aplicación</h1>
                <MyButton />
                <br />
            </div>
        </section>
    );
}
