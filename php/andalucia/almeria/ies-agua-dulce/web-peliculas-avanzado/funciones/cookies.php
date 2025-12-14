<?php
//Cargamos el valor de la constante salteado 
require_once "../conf/cookies-config.php";

/**********************************************************
FUNCIÓN PARA ENVIAR COOKIES CON LAS PREFERENCIAS DE GÉNEROS
 **********************************************************/

// Función para enviar la cookie con las preferencias de géneros
function enviarCookiesGenerosPreferidos(array $generos)
{
    //Declaramos 2 variables con los nombres de las cookies que serán enviadas al navegador
    $nombreCookie = "generos_792"; // cookie con los 3 últimos numeros de mi DNI
    $hashCookie   = "hash_generos_792";

    // Serializamos los datos
    $datos = serialize($generos);

    // Creamos la cookie con 1 hora de expiración
    setcookie($nombreCookie, $datos, time() + 3600, "/");

    // Creamos un hash de seguridad para verificar la integridad 
    //Al hash le concatena el salteado
    $hash = hash('sha256', $datos . COOKIE_SALT);

    //Creamos la cookie de seguridad con 1 hora de expiración
    setcookie($hashCookie, $hash, time() + 3600, "/");
}

/**************************************************************************
FUNCIÓN PARA ELIMINAR COOKIES PREFERENCIAS DE GÉNEROS CUANDO SON CORRUPTAS
 **************************************************************************/

function forzarEliminacionCookies()
{
    //Enviamos cookies vacías y con un tiempo negativo
    setcookie('generos_792', '', time() - 3600, '/');
    setcookie('hash_generos_792', '', time() - 3600, '/');
}

/**********************************************************
FUNCIÓN PARA OBTENER COOKIES CON LAS PREFERENCIAS DE GÉNEROS
 **********************************************************/
function obtenerGenerosPreferidosDeCookies()
{
    $generos = [];
    //Definimos el nombre de las variables a verificar
    $nombreCookie = "generos_792"; // cookie con los 3 últimos numeros de mi DNI
    $hashCookie   = "hash_generos_792";

    //Comprobamos si existe en el array $_COOKIES
    if (!isset($_COOKIE[$nombreCookie]) || !isset($_COOKIE[$hashCookie])) {
        echo ("Las cookies con preferencias de géneros no existen o no son válidas");
        $generos = false;

        //En el caso de que ambas existan
    } else {
        //Calculamos el hash de los datos recibidos
        $datos = $_COOKIE[$nombreCookie];
        $hashDatosRecibidos = $_COOKIE[$hashCookie];
        $hashCalculado = hash('sha256', $datos . COOKIE_SALT);

        if ($hashDatosRecibidos !==  $hashCalculado) {
            echo " Las cookies han sido manipuladas";
            //Destruimos la cookies
            forzarEliminacionCookies();
            $generos = false;
        } //En caso contrario devolvemos la cookie generos deserializada
        $generos = unserialize($datos);
    }
    return $generos;
}
