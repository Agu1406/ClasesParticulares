<?php
/**
 * Ejercicio 11: Eliminar empleado en MySQL con transacciones
 * 
 * Este script se conecta a la base de datos MySQL y elimina un empleado
 * de la tabla empleados utilizando transacciones.
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
        $stmt = "DELETE FROM empleados 
                 WHERE num_empleado = ?";

        $parametros = [100];

        $filas = $mysql->ejecutarSentenciaT($stmt, $parametros);

        echo "Los datos han sido eliminados correctamente con transacción, # afectadas: ($filas)" . "<br>";

        $mysql->desconectar();
    }
} catch (PDOException $e) {
    echo "Error de base de datos: " . $e->getMessage();
} catch (Exception $e) {
    echo "Error general: " . $e->getMessage();
}

