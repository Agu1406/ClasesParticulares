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
import type { ReactElement } from 'react';
import MyButton from './MyButton';

/**
 * React puede leer datos de diversas fuentes, entre ellas, por ejemplo, JSON
 * o directamente desde una API o backend, ahora aprenderemos a mostrar datos
 * en los componentes provinientes de otras fuentes, vamos a simular un JSON
 * con datos ficticios de un usuario.
 */
const user = {
    name: "Agustín Antonio Márquez Piña",
    imgURL: "https://avatars.githubusercontent.com/u/158044061?v=4",
    imgSize: "90"
};

import AdminPanel from './AdminPanel';
import LoginForm from './LoginForm';

/**
 * React puede cargar según que condiciones unos componentes u otros dependiendo
 * del valor / estado de dichas condiciones, por ejemplo, dependiendo de si un
 * booleano es "true" o "false" podemos mostrar una cosa u otra.
 */
let content: ReactElement;

// TODO: Hacer que el primer botón que diseñamos previamente cambie el estado de esto.
let isLoggedIn = false;

if (isLoggedIn) {
    content = <AdminPanel />
} else {
    content = <LoginForm />
}

export default function MyAPP() {
    return (
        <>
            <h1>¡Aprendiendo React desde cero! - Incio e introducción</h1>
            <br />

            {/**
             * CREAR Y ANIDAR COMPONENTES.
             * 
             * El componente "MyButton" se importa desde un archivo TSX diferente y
             * se renderiza aquí, es como usar "legos" para construir nuestras
             * aplicaciones. 
             */}
            <h2>Crear componentes </h2>
            <MyButton />
            <br />

            {/**
             * MOSTRAR DATOS.
             * 
             * Inserto mi nombre desde la constante con los datos del usuario que
             * he creado previamente.
             * 
             * De la misma forma todos los datos de la imagen los puedo obtener de
             * la constante "user", la ruta de la imagen (src), el ancho y alto de
             * la imagén e incluso general el "alt" combinando un String con el
             * nombre de usuario.             */}
            <h2>Mi nombre es {user.name}</h2>
            <img
                src={user.imgURL}
                alt={"Imagen de perfil de " + user.name}
                width={user.imgSize}
                height={user.imgSize}
            />
            <br />

            {/**
             * RENDERIZADO CONDICIONAL.
             * 
             * Podemos cargar un contenido u otro dependiendo de una condición, por
             * ejemplo, un booleano, mira la creación de la variable content.
             */}
            <div>
                {content}
            </div>
            <br />
        </>
    );
}