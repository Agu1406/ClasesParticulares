<?php
/**
 * Ejercicio 9: Modificar empleado en MySQL con transacciones
 * 
 * Este script se conecta a la base de datos MySQL y modifica un empleado
 * en la tabla empleados utilizando transacciones. Los datos se modifican en mayúscula.
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

        // Realizamos el procesamiento con transacción
        // Los datos en mayúscula según el ejercicio
        $stmt = "UPDATE empleados 
                SET nombre = ?, 
                    apellido1 = ?, 
                    apellido2 = ? 
                WHERE num_empleado = ?";

        $parametros = [
            'JOSE',
            'GARCIA',
            'GARCIA',
            100
        ];

        $filasAfectadas = $mysql->ejecutarSentenciaT($stmt, $parametros);

        echo "Los datos han sido modificados correctamente con transacción. Filas afectadas: " . $filasAfectadas . "<br>";

        $mysql->desconectar();
    }
} catch (PDOException $e) {
    echo "Error de base de datos: " . $e->getMessage();
} catch (Exception $e) {
    echo "Error general: " . $e->getMessage();
}

