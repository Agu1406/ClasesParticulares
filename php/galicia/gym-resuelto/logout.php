<?php

// Cerrar sesión y volver al login

session_start();

session_unset();   // borra variables de sesión
session_destroy(); // destruye la sesión

header("Location: login.html");
exit;

?>
