<?php
// Solo necesitamos cargar una vez las clases para usarlas.
require_once "Vehiculo.php";
require_once "Coche.php";
require_once "Moto.php";
require_once "Camion.php";


// Crear un coche usando el método estático crearVehiculo().
$coche = Vehiculo::crearVehiculo([
    "tipo" => "coche",
    "marca" => "Toyota",
    "modelo" => "Corolla",
    "anyo" => 2023
]);
echo "Coche creado: {$coche->arrancar()} \n";
echo "Coche: {$coche->acelerar()} \n";

// Crear una moto usando el método estático crearVehiculo().
$moto = Vehiculo::crearVehiculo([
    "tipo" => "moto",
    "marca" => "Honda",
    "modelo" => "CBR 600",
    "anyo" => 2022
]);
echo "Moto creada: {$moto->arrancar()} \n";
echo "Moto: {$moto->acelerar()} \n";

// Crear un camión usando el método estático crearVehiculo().
$camion = Vehiculo::crearVehiculo([
    "tipo" => "camion",
    "marca" => "Volvo",
    "modelo" => "FH16",
    "anyo" => 2021,
    "cargaMaxima" => 25000
]);
echo "Camión creado: {$camion->arrancar()} \n";
echo "Camión: {$camion->acelerar()} \n ";
