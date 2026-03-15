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

export default function MyAPP () {
    return (
        <>
            <h1>Mi primera aplicación</h1>
            <MyButton />
        </>
    );
}