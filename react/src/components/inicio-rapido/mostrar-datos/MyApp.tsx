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

export default function MyAPP() {
    return (
        <>
            <h1>¡Aprendiendo React desde cero!</h1>
            <br />
            {/**
             * Inserto mi nombre desde la constante con los datos del usuario que
             * he creado previamente.
             */}
            <h2>Mi nombre es {user.name}</h2>
            {/**
             * De la misma forma todos los datos de la imagen los puedo obtener de
             * la constante "user", la ruta de la imagen (src), el ancho y alto de
             * la imagén e incluso general el "alt" combinando un String con el
             * nombre de usuario.
             */}
            <img 
                src={user.imgURL} 
                alt={"Imagen de perfil de " + user.name}
                style={{
                    width: user.imgSize,
                    height: user.imgSize
                }}
                />
            <br />
            {/**
             * El componente "MyButton" se importa desde un archivo TSX diferente y
             * se renderiza aquí, es como usar "legos" para construir nuestras
             * aplicaciones. 
             */}
            <MyButton />
            {/**
             * Una de las peculiaridades de REACT es que algunas etiquetas clasicas
             * de HTML como el salto de linea ("<br>") si se tienen que cerrar si
             * se usan en componentes REACT.
             */}
            <br />
        </>
    );
}