<?php

// Cerrar sesión y volver al login

session_start();

// Borramos las variables de sesión
session_unset();

// Destruimos la sesión
session_destroy();

// Redirigimos al formulario de acceso
header("Location: login.html");
exit;

?>
