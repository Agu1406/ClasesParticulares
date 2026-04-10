/**
 * Lección 01 — Crear y anidar componentes (TSX, equivalente al flujo original en JSX).
 *
 * @see https://es.react.dev/learn
 */
import MyButton from './MyButton';

const myButtonSnippet = `
export default function MyButton() {
    return (
        <button>Soy un botón</button>
    );
}`;

export default function MyApp() {
    return (
        <section className="leccion-cuerpo" aria-label="Lección 01 — Crear componentes">
            <h2 className="learn-title">Inicio e introducción a REACT</h2>
            <p className="learn-info">
                A través del sitio oficial de React, específicamente{' '}
                <a href="https://es.react.dev/learn">learn react</a>, vamos cubriendo las nociones
                básicas del ecosistema.
            </p>

            <h2 className="learn-title">Crear y anidar componentes</h2>
            <p className="learn-info">
                La página combina varios componentes: desde <code>App.tsx</code> se monta{' '}
                <code>MyApp</code> y este importa <code>MyButton</code> desde otro archivo. Ejemplo
                del hijo:
            </p>
            <pre className="learn-code">
                <code>{myButtonSnippet}</code>
            </pre>

            <div className="learn-react">
                <h1>Mi primera aplicación</h1>
                <MyButton />
                <br />
            </div>
        </section>
    );
}
