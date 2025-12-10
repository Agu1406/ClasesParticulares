<?php

/**
 * Pregunta: ¿Cómo se puede averiguar el contenido y el tipo de una variable?
 * 
 * Respuesta:
 * En PHP existen varias funciones para averiguar el contenido y el tipo de una variable.
 */

// Ejemplos de variables
$nombre = "Juan";
$edad = 25;
$activo = true;
$datos = ["ciudad" => "Madrid", "pais" => "España"];

// 1. var_dump() - Muestra el tipo, tamaño y valor de la variable
// Útil para depuración, muestra información detallada
var_dump($nombre);    // string(4) "Juan"

// 2. gettype() - Devuelve solo el tipo de la variable como string
echo gettype($edad) . "\n";        // "integer"

// 3. print_r() - Muestra el contenido de forma legible
// Especialmente útil para arrays y objetos, más limpio que var_dump
print_r($datos);       // Array ( [ciudad] => Madrid [pais] => España )

// 4. var_export() - Muestra una representación válida de PHP de la variable
// Útil para generar código o ver la estructura exacta
var_export($datos);

// 5. Funciones de verificación de tipo específico
// Devuelven true o false según el tipo de la variable
is_string($nombre);  // true
is_int($edad);       // true
is_bool($activo);    // true
is_array($datos);    // true

