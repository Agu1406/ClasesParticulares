/**
 * Lección 10 — Inicio rápido completo: títulos, párrafos y snippets van aquí (copiados / pegados);
 * el componente vivo de cada tema se importa desde su carpeta (`01` … `09`).
 *
 * @see https://es.react.dev/learn
 */
import type { ReactElement } from 'react';
import { useState } from 'react';

import MyButton01 from '../01-crear-componentes/MyButton';
import MyButton03 from '../03-importar-estilos/MyButton';
import LoginForm05 from '../05-renderizado-condicional/LoginForm';
import AdminPanel05 from '../05-renderizado-condicional/AdminPanel';
import MyButton07 from '../07-responder-eventos/MyButton';
import MyButton08 from '../08-actualizar-pagina/MyButton';
import LoginForm08 from '../08-actualizar-pagina/LoginForm';
import AdminPanel08 from '../08-actualizar-pagina/AdminPanel';
import MyButton2 from '../09-utilizacion-hooks/MyButton2';

const user = {
    name: 'Agustín Antonio Márquez Piña',
    imgURL: 'https://avatars.githubusercontent.com/u/158044061?v=4',
    imgSize: '90',
};

const products = [
    { title: "Col", id: 1 },
    { title: "Ajo", id: 2 },
    { title: "Uva", id: 3 },
];

// Mapeamos todos los productos en forma de elementos "<li>" usando su ID.
const listItems = products.map(product => (
    <li key={product.id}>
        {product.title}
    </li>
));

let contentLeccion05: ReactElement;
const isLoggedInLeccion05 = false;
if (isLoggedInLeccion05) {
    contentLeccion05 = <AdminPanel05 />;
} else {
    contentLeccion05 = <LoginForm05 />;
}

/** Snippets en <pre className="learn-code"> (cadenas literales). */

const introSnippet = `// Guía oficial: https://es.react.dev/learn`;

const jsxExtensionSnippet = `// Mismo componente; cambia solo la extensión del archivo:
MiApp.jsx   // JavaScript + JSX
MiApp.tsx   // TypeScript + JSX`;

const myButtonSnippet = `
    export default function MyButton() {
        return (
        <button>Soy un botón</button>
        );
    }`;

const imgSnippet = `
    <img src={user.imgURL}
    alt={"Imagen de perfil de " + user.name}
    width={user.imgSize}
    height={user.imgSize} />`;

const conditionalSnippet = `
    let isLoggedIn = false;

    if (isLoggedIn) {
        content = <AdminPanel />;
    } else {
        content = <LoginForm />;
    }`;

const listSnippet = `
const products = [
    { title: "Col", id: 1 },
    { title: "Ajo", id: 2 },
    { title: "Uva", id: 3 },
];

const listItems = products.map(product => (
    <li key={product.id}>
        {product.title}
    </li>
));
`;

const eventSnippet = `
export default function MyButton() {
    function handleClick () {
        alert("¡Haz hecho click en el botón");
    }

    return (
        <div className="learn-react">
            <button type="button" onClick={handleClick}>
                Soy un botón
                </button>
        </div>
    );
}
`;

const updatePageSnippet = `
import { useState } from 'react';

export default function MyButton() {
    const [count, setCount] = useState(0);

    function handleClick() {
        // ACTUALIZAR PAGINA.
        setCount(count + 1);
    }

    return (
        <div className="learn-react">
            <button type="button" onClick={handleClick}>
                Soy un botón
            </button>
            <p>Valor actual {count}</p>
        </div>
    );
}
`;

const hooksSnippet = `
// CÓDIGO EMPLEADO EN EL COMPONENTE PADRE MyApp.tsx FUERA DE LA FUNCIÓN.
import { useState } from 'react';

import MyButton2 from './MyButton2';

// CÓDIGO EMPLEADO EN EL COMPONENTE PADRE MyApp.tsx DENTRO DE LA FUNCIÓN.
const [count, setCount] = useState(0);

function handleClick () {
    setCount(count + 1);
}
    
// CÓDIGO EMPLEADO EN EL COMPONENTE HIJO MyButton2.tsx
type Props = {count: number, onClick: () => void};


export default function MyButton({count, onClick}: Props) {
    return (
        <div className="learn-react">
            <button type="button" onClick={onClick}>
                Soy un botón
            </button>
            <p>Valor actual {count}</p>
        </div>
    );
}
`;

const importarEstilosComponenteSnippet = `
// Global (en App.tsx)
import './App.css';

// Hoja junto al componente (carpeta 03-importar-estilos)
import './styles.css';

export default function MyButton() {
  return (
    <button type="button" className="boton-tutorial boton-leccion-importar-estilos">
      Soy un botón
    </button>
  );
}`;

const estadoCondicionalSnippet = `
const [isLoggedIn, setIsLoggedIn] = useState(false);

// En JSX: formulario ficticio o panel según el booleano
isLoggedIn ? (
  <AdminPanel onBackToForm={() => setIsLoggedIn(false)} />
) : (
  <LoginForm onContinueDemo={() => setIsLoggedIn(true)} />
);`;

const dosContadoresSnippet = `// Dos <MyButton /> del mismo archivo = dos useState internos distintos
<MyButton />
<MyButton />`;

export default function MyAPP() {
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    // Creamos con useState la función modificadora y la variable contador.
    const [count, setCount] = useState(0);

    /**
     * Función que en caso de detectar un click incrementa en uno el valor del
     * contador asociado a useState.
     */
    function handleClick () {
        setCount(count + 1);
    }

    return (
        <main className="inicio-rapido-completo">
            <article className="leccion-bloque">
                <h2 className="learn-title">Inicio e introducción a REACT</h2>
                <p className="learn-info">
                    A través del sitio oficial de react, especificamente{' '}
                    <a href="https://es.react.dev/learn">learn react</a> estare aprendiendo las nociones basicas del
                    ecosistema para posteriormente añadir el mismo a mi repertorio de tecnologías, lenguajes, frameworks y
                    herramientas en mis servicios de profesor de clases particulares.
                </p>
                <pre className="learn-code">
                    <code>{introSnippet}</code>
                </pre>
                <div className="learn-react">
                    {/**
                     * Sin componente de lección: solo contexto antes del inicio rápido.
                     */}
                </div>
            </article>

            <article className="leccion-bloque">
                <h2 className="learn-title">01 — Crear y anidar componentes</h2>
                <p className="learn-info">
                    La pagina que puedes ver en este preciso momento es la combinación de varios componentes, desde App.tsx se
                    cargan, por ejemplo, MyApp.tsx y MyButton.tsx en el directorio llamado &quot;components&quot; los cuales
                    se renderizan justo después de este parrafo, ejemplo:
                </p>
                <pre className="learn-code">
                    <code>{myButtonSnippet}</code>
                </pre>
                <div className="learn-react">
                    <MyButton01 />
                </div>
            </article>

            <article className="leccion-bloque">
                <h2 className="learn-title">02 — Escribir en marcado JSX</h2>
                <p className="learn-info">
                    Se puede utilizar dos formatos para la escritura de código en React: archivos &quot;.jsx&quot;
                    (JavaScript) y &quot;.tsx&quot; (TypeScript). &quot;.jsx&quot; no tiene tipado estático; &quot;.tsx&quot;
                    permite detectar errores de tipos en compilación. En esta lección no hay un componente nuevo: el cambio
                    es la extensión del archivo y el entorno de tipos.
                </p>
                <pre className="learn-code">
                    <code>{jsxExtensionSnippet}</code>
                </pre>
                <div className="learn-react">
                    {/**
                     * Sin componente importado: la demo es conceptual (.jsx vs .tsx).
                     */}
                </div>
            </article>

            <article className="leccion-bloque">
                <h2 className="learn-title">03 — Añadir estilos</h2>
                <p className="learn-info">
                    Hoja global en <code>App.tsx</code> más hoja local junto al botón en <code>03-importar-estilos</code>.
                    El componente vivo es <code>MyButton</code> de esa carpeta.
                </p>
                <pre className="learn-code">
                    <code>{importarEstilosComponenteSnippet}</code>
                </pre>
                <div className="learn-react">
                    <MyButton03 />
                </div>
            </article>

            <article className="leccion-bloque">
                <h2 className="learn-title">04 — Mostrar datos</h2>
                <p className="learn-info">
                    Los datos mostrados a continuación se cargan dinamicamente usando las llaves de escape de react para
                    cargar los mismos desde, en este caso, una constante o fuente de datos procedente de otro sitio, ejemplo
                    son <code>&lt;h2&gt;Mi nombre es &#123;user.name&#125;&lt;/h2&gt;</code>{' '}
                    permitirian renderizar dinamicamente el nombre de un usuario proviniento de una variable llamada
                    &quot;user&quot;.
                </p>
                <p className="learn-info">
                    Lo mismo pasa con la imagen donde controlamos la fuente de la misma (src) así como sus dimensiones
                    permitiendo la carga dinamica de dichos valores, ejemplo:
                </p>
                <pre className="learn-code">
                    <code>{imgSnippet}</code>
                </pre>
                <div className="learn-react">
                    <h2>Mi nombre es {user.name}</h2>
                    <img
                        src={user.imgURL}
                        alt={'Imagen de perfil de ' + user.name}
                        width={user.imgSize}
                        height={user.imgSize}
                    />
                </div>
            </article>

            <article className="leccion-bloque">
                <h2 className="learn-title">05 — Renderizado condicional (estático)</h2>
                <p className="learn-info">
                    Según un booleano fijo elegimos qué componente mostrar. La demo simula un acceso ficticio (usuario,
                    contraseña y botón <code>type=&quot;button&quot;</code>, sin envío real) y el panel de la carpeta{' '}
                    <code>05-renderizado-condicional</code>.
                </p>
                <pre className="learn-code">
                    <code>{conditionalSnippet}</code>
                </pre>
                <div className="learn-react">
                    {contentLeccion05}
                    <br />
                    {isLoggedInLeccion05 ? (
                        <h3>Vista: panel de demostración</h3>
                    ) : (
                        <h3>Vista: formulario de demostración</h3>
                    )}
                    <br />
                    {isLoggedInLeccion05 && <h3>Hola, {user.name} (demo)</h3>}
                </div>
            </article>

            <article className="leccion-bloque">
                <h2 className="learn-title">06 — Renderizado de listas</h2>
                <p className="learn-info">
                    React nos enseña que a través de bucles for y la función map podremos utilizar arreglos de datos para
                    mostrarlos en forma de lista en nuestros componentes (o mostrar los propios componentes en forma de lista,
                    veamos el siguiente ejemplo con un conjunto de datos de frutas y/o vegetales:
                </p>
                <pre className="learn-code">
                    <code>{listSnippet}</code>
                </pre>
                <div className="learn-react">
                    <ul className="learn-info">{listItems}</ul>
                </div>
            </article>

            <article className="leccion-bloque">
                <h2 className="learn-title">07 — Responder a eventos</h2>
                <p className="learn-info">
                    El siguiente paso involucra responder / manejar eventos que ocurren o son
                    invocados desde nuestros componentes, para ello podemos crear directamente
                    en los componentes funciones que en caso de ocurrir ciertos eventos, por
                    ejemplo un &quot;click&quot; se ejecuten cambiando el estado y/o comportamiento de
                    nuestros componentes, en el siguiente ejemplo creamos una función en el
                    ya existente componente &quot;MyButton&quot; y desde los atributos del botón la
                    llamamos en el caso de ocurrir un evento del tipo click:
                </p>
                <pre className="learn-code">
                    <code>{eventSnippet}</code>
                </pre>
                <div className="learn-react">
                    <MyButton07 />
                </div>
            </article>

            <article className="leccion-bloque">
                <h2 className="learn-title">08 — Actualizar la pantalla (useState)</h2>
                <p className="learn-info">
                    Con <code>useState</code> dentro del botón, cada click actualiza el contador en ese componente (mismo
                    patrón que en el tutorial oficial).
                </p>
                <pre className="learn-code">
                    <code>{updatePageSnippet}</code>
                </pre>
                <div className="learn-react">
                    <MyButton08 />
                </div>
                <p className="learn-info">
                    Opcionalmente, el mismo hook sirve para alternar dos vistas: formulario de acceso ficticio (usuario y
                    contraseña, botón <code>type=&quot;button&quot;</code>) y panel, con props desde{' '}
                    <code>08-actualizar-pagina</code> — igual que en la 05, pero el booleano vive en el padre.
                </p>
                <pre className="learn-code">
                    <code>{estadoCondicionalSnippet}</code>
                </pre>
                <div className="learn-react">
                    {isLoggedIn ? (
                        <AdminPanel08 onBackToForm={() => setIsLoggedIn(false)} />
                    ) : (
                        <LoginForm08 onContinueDemo={() => setIsLoggedIn(true)} />
                    )}
                    <br />
                    {isLoggedIn ? (
                        <h3>Vista: panel de demostración</h3>
                    ) : (
                        <h3>Vista: acceso (demo)</h3>
                    )}
                    <br />
                    {isLoggedIn && <h3>Sesión de demostración activa</h3>}
                </div>
            </article>

            <article className="leccion-bloque">
                <h2 className="learn-title">09 — Utilización de hooks en React</h2>
                <p className="learn-info">
                    Dos instancias del mismo componente con su propio <code>useState</code> interno: contadores
                    independientes.
                </p>
                <pre className="learn-code">
                    <code>{dosContadoresSnippet}</code>
                </pre>
                <div className="learn-react">
                    <MyButton08 />
                    <MyButton08 />
                </div>
                <p className="learn-info">
                    Si el estado vive en el padre, ambos botones comparten el mismo contador mediante props; el componente
                    de la lección 09 es <code>MyButton2</code>.
                </p>
                <pre className="learn-code">
                    <code>{hooksSnippet}</code>
                </pre>
                <div className="learn-react">
                    <MyButton2 count={count} onClick={handleClick} />
                    <MyButton2 count={count} onClick={handleClick} />
                </div>
            </article>
        </main>
    );
}
