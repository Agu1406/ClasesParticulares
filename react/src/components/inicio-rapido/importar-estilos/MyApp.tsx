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

export default function MyAPP() {
    return (
        <>
            <h1>Mi primera aplicación</h1>
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