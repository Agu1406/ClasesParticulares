/**
 * Aprendizaje de REACT desde cero siguiendo los ejemplos y tutoriales encontrados
 * en el sitio web oficial de REACT.
 *
 * La unica diferencia es que a diferencia del tutorial / ejemplo proporcionado por
 * el sitio web yo aprendí directamente a importar componentes desde diferentes
 * archivos, la sintaxis es import NombreLocal from StringConLaRuta.
 * @see https://es.react.dev/learn
 * @returns Botón de ejemplo.
 */
/**
 * CREAR Y ANIDAR COMPONENTES.
 */
import MyButton from "./MyButton";

/**
 * AÑADIR ESTILOS.
 */
import '../../styles.css';

/**
 * MOSTRAR DATOS.
 *
 * React puede leer datos de diversas fuentes, entre ellas, por ejemplo, JSON
 * o directamente desde una API o backend, ahora aprenderemos a mostrar datos
 * en los componentes provinientes de otras fuentes, vamos a simular un JSON
 * con datos ficticios de un usuario.
 */
const user = {
    name: "Agustín Antonio Márquez Piña",
    imgURL: "https://avatars.githubusercontent.com/u/158044061?v=4",
    imgSize: "90",
};

/**
 * RENDERIZADO CONDICIONAL.
 *
 * React puede cargar según que condiciones unos componentes u otros dependiendo
 * del valor / estado de dichas condiciones, por ejemplo, dependiendo de si un
 * booleano es "true" o "false" podemos mostrar una cosa u otra.
 *
 * También se puede usar el operador "?" directamente en JSX / TSX para el
 * condicionado de contenido, para ello busca y observa la demostración de
 * esta sección en el TSX de MyApp.
 */
import type { ReactElement } from "react";
import AdminPanel from "./AdminPanel";
import LoginForm from "./LoginForm";

let content: ReactElement;

const isLoggedIn = false;

if (isLoggedIn) {
    content = <AdminPanel />;
} else {
    content = <LoginForm />;
}

/**
 * RENDERIZADO DE LISTAS.
 *
 * Para cargar / mostrar listas en react dependemos de bucles "for" y de
 * la función "map()" para manejar los arreglos de datos, lo vamos a
 * probar con el siguiente arreglo de datos.
 */
const products = [
    { title: "Col", id: 1 },
    { title: "Ajo", id: 2 },
    { title: "Uva", id: 3 },
];

// Mapeamos todos los productos en forma de elementos "<li>" usando su ID.
const listItems = products.map((product) => (
    <li key={product.id}>{product.title}</li>
));

/**
 * RESPONDER A EVENTOS.
 *
 * Esto es algo que se controla directamente desde aquellos componentes que
 * encuentran necesario realizar dichas acciones, por ejemplo, durante un
 * click, mira MyButton para entender mejor como funciona.
 */

/**
 * Con los Snippets puedo evitar usar cada 5 minutos los escapes de HTML
 * para simbolos y carácteres especiales como &gt; y &lt; o &#123; y &#125;
 *
 * Paso directamente las cadenas de "código" como Strings de la misma forma
 * que aprendí a estás alturas ya a "mostrar datos".
 */
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

export default function MyAPP() {
    return (
        <main>
            {/**
             * INICIO E INTRODUCCIÓN A REACT
             */}
            <h2 className="learn-title">Inicio e introducción a REACT</h2>
            <p className="learn-info">
                A través del sitio oficial de react, especificamente{" "}
                <a href="https://es.react.dev/learn">learn react</a> estare aprendiendo
                las nociones basicas del ecosistema para posteriormente añadir el mismo
                a mi repertorio de tecnologías, lenguajes, frameworks y herramientas en
                mis servicios de profesor de clases particulares.
            </p>

            {/**
             * CREAR Y ANIDAR COMPONENTES.
             */}
            <h2 className="learn-title">Crear y anidar componentes</h2>
            <p className="learn-info">
                La pagina que puedes ver en este preciso momento es la combinación de
                varios componentes, desde App.tsx se cargan, por ejemplo, MyApp.tsx y
                MyButton.tsx en el directorio llamado &quot;components&quot; los cuales
                se renderizan justo después de este parrafo, ejemplo:
            </p>
            <pre className="learn-code">
                <code>{myButtonSnippet}</code>
            </pre>
            <MyButton />

            {/**
             * ESCRIBIR MARCADO JSX.
             */}
            <h2 className="learn-title">Escribir en marcado JSX</h2>
            <p className="learn-info">
                Se puede utilizar dos formatos para la escritura de código en React los
                cuales son los archivos &quot;.jsx&quot; (JavaScript) y los archivos
                &quot;.tsx&quot; (TypeScript), sus principales diferencias son:
            </p>
            <ul className="learn-info">
                <li>
                    &quot;.jsx&quot;: JavaScript, React con JSX, No tiene tipado estático;
                    el chequeo de tipos depende de linters o herramientas externas.
                </li>
                <li>
                    &quot;.tsx&quot;: TypeScript, React con JSX, Incluye tipado estático
                    de TypeScript, lo que permite detectar errores de tipos en tiempo de
                    compilación.
                </li>
            </ul>

            {/**
             * AÑADIR ESTILOS (IMPORTARLOS)
             */}
            <h2 className="learn-title">Añadir estilos (importar)</h2>
            <p className="learn-info">
                Desde react existen varias formas de añadir estilos a nuestro
                componentes y elementos, la mejor de ellas a mi criterio es crear hojas
                de estilo CSS e importar las mismas con la siguiente sintaxis (misma
                usada en el componente MyApp.tsx que permite que todos estos elementos
                tengan estilos):
            </p>
            <pre className="learn-code">
                <code>import &apos;./styles.css&apos;;</code>
            </pre>

            {/**
             * MOSTRAR DATOS.
             */}
            <h2 className="learn-title">Mostrar datos</h2>
            <p className="learn-info">
                Los datos mostrados a continuación se cargan dinamicamente usando las
                llaves de escape de react para cargar los mismos desde, en este caso,
                una constante o fuente de datos procedente de otro sitio, ejemplo son{" "}
                <code>&lt;h2&gt;Mi nombre es &#123;user.name&#125;&lt;/h2&gt;</code>{" "}
                permitirian renderizar dinamicamente el nombre de un usuario proviniento
                de una variable llamada &quot;user&quot;.
            </p>
            <p className="learn-info">
                Lo mismo pasa con la imagen donde controlamos la fuente de la misma
                (src) así como sus dimensiones permitiendo la carga dinamica de dichos
                valores, ejemplo:
            </p>
            <pre className="learn-code">
                <code>{imgSnippet}</code>
            </pre>
            <div className="learn-react">
                <h2>Mi nombre es {user.name}</h2>
                <img
                    src={user.imgURL}
                    alt={"Imagen de perfil de " + user.name}
                    width={user.imgSize}
                    height={user.imgSize}
                />
            </div>

            {/**
             * RENDERIZADO CONDICIONAL.
             *
             * Aquí se pueden apreciar las tres variadades las cuales son:
             *
             * - Usando if-else fuera de la función que devuelvo el elemento MyApp.
             * - Directamente sobre el TSX / JSX usando el operador "?".
             * - Directamente sobre el TSX / JSX usando la sintaxis "&&".
             *
             * Usando "?" tiene que haber dos respuestas siempre, aunque sean vacias,
             * una para el "true" y otra para el "false".
             *
             * Con "&&" podemos omitir el "else" para ser directos solo con el "true".
             */}
            <h2 className="learn-title">Renderizado condicional</h2>
            <p className="learn-info">
                A partir de nuestro entendimiento de que es posible el renderizado
                dinamico de datos desde variables en react podemos hacer lo mismo con la
                carga de un contenido u otro basandonos, por ejemplo, en un booleano,
                como es el siguiente ejemplo:
            </p>
            <pre className="learn-code">
                <code>{conditionalSnippet}</code>
            </pre>
            <div className="learn-react">
                {content}
                <br />
                {
                    /**
                     * Aquí por ejemplo usamos las llaves de "escape" para escribir dentro del TSX
                     * el condicional con el operador "?".
                     */
                    isLoggedIn ? (
                        <h3>Vista: panel de demostración</h3>
                    ) : (
                        <h3>Vista: formulario de demostración</h3>
                    )
                }
                <br />
                {
                    /**
                     * Por ultimo, en esos escenarios podemos usar el operador logico "&&" en aquellos
                     * escenarios donde no hace falta un "else" y solo la carga de "X" elementos si la
                     * condición es "true".
                     */
                    isLoggedIn && <h3>Hola, {user.name} (demo)</h3>
                }
            </div>


            {/**
             * RENDERIZADO DE LISTAS.
             * 
             * La forma correcta de renderizar listas en react es iterando sobre una colección de elementos usando por
             * ejemplo un mapa (map) usando el atributo "key" en cada elementos de la lista para que este asocaido a
             * un ID diferente, esto se puede apreciar en la linea de declaración de "listItems".
             */}
            <h2 className="learn-title">Renderizado de listas</h2>
            <p className="learn-info">
                React nos enseña que a través de bucles for y la función map podremos
                utilizar arreglos de datos para mostrarlos en forma de lista en nuestros
                componentes (o mostrar los propios componentes en forma de lista, veamos
                el siguiente ejemplo con un conjunto de datos de frutas y/o vegetales:
            </p>
            <pre className="learn-code">
                <code>{listSnippet}</code>
            </pre>
            <div className="learn-react">
                <ul className="learn-info">{listItems}</ul>
            </div>

            {/**
             * RESPONDER A EVENTOS.
             * 
             * Si vienes de estudiar JavaScript a secas sabrás que existen diferentes tipos
             * de eventos que se pueden detectar cuando el usuario interactua con nuestras
             * aplicaciones, entre ellos, por ejemplo cuando se hace "click" en algún lugar
             * como un componente.
             * 
             * Responder a los eventos nos permite definir que hará nuestra aplicación o el
             * propio componente al detectar estos, en el siguiente ejemplo haremos que en
             * caso de detectar un click se active un "alert" (pop-up) con un mensaje que
             * avisa de la acción realizada (click). 
             */}
            <h2 className="learn-title">Responder a eventos</h2>
            <p className="learn-info">
                El siguiente paso involucra responder / manejar eventos que ocurren o son
                invocados desde nuestros componentes, para ello podemos crear directamente
                en los componentes funciones que en caso de ocurrir ciertos eventos, por
                ejemplo un "click" se ejecuten cambiando el estado y/o comportamiento de
                nuestros componentes, en el siguiente ejemplo creamos una función en el
                ya existente componente "MyButton" y desde los atributos del botón la
                llamamos en el caso de ocurrir un evento del tipo click:
            </p>
            <pre className="learn-code">
                <code>{eventSnippet}</code>
            </pre>
            <div className="learn-react">
                <MyButton />
            </div>
        </main>
    );
}
