<?php
/**
 * Ejercicio 7: Insertar empleado en MySQL con transacciones
 * 
 * Este script se conecta a la base de datos MySQL e inserta un nuevo empleado
 * en la tabla empleados utilizando transacciones (beginTransaction, commit, rollback).
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */

require_once 'MySQLConexion.php';

// Probamos el código
// Creamos la conexión
try {
    $mysql = new MySQLConexion('../secure/mysql_config_ej5.php');

    if ($mysql->conectar()) {
        echo "Conexión establecida correctamente.<br>";

        // Iniciamos una transacción
        $mysql->iniciarTransaccion();
        echo "Transacción iniciada.<br>";

        try {
            // Realizamos el procesamiento CON transacciones
            $stmt = "INSERT INTO empleados 
                    (num_empleado, dni, nombre, apellido1, apellido2, 
                     tfno_empresa, sueldo, tfno_personal, transporte, num_jefe) 
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            $parametros = [
                100,
                '12345678X',
                'Nombre6',
                'Apellido16',
                'Apellido26',
                999100,
                30000,
                555000,
                2500,
                1
            ];

            $filasAfectadas = $mysql->ejecutarSentencia($stmt, $parametros);

            // Si todo va bien, confirmamos la transacción
            $mysql->confirmarTransaccion();
            echo "Los datos han sido insertados correctamente. Filas afectadas: " . $filasAfectadas . "<br>";
            echo "Transacción confirmada (COMMIT).<br>";

        } catch (PDOException $e) {
            // Si hay un error, revertimos la transacción
            $mysql->revertirTransaccion();
            echo "Error durante la inserción: " . $e->getMessage() . "<br>";
            echo "Transacción revertida (ROLLBACK).<br>";
            throw $e; // Re-lanzamos la excepción para que se capture en el catch externo
        }

        $mysql->desconectar();
    }
} catch (PDOException $e) {
    echo "Error de base de datos: " . $e->getMessage();
} catch (Exception $e) {
    echo "Error general: " . $e->getMessage();
}
