<?php
/**
 * Archivo de prueba para la clase ConexionPDO_Mysql
 * 
 * Este script prueba todas las funcionalidades de la clase ConexionPDO_Mysql:
 * constructor con valores, conexión desde archivo, conexión con valores directos,
 * y verificación de implementación de interfaz.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */

require_once 'ConexionPDO_Mysql.php';

echo "<h2>Prueba de ConexionPDO_Mysql</h2>";

try {
    // Prueba 1: Constructor con valores iniciales
    echo "<h3>Prueba 1: Constructor con valores iniciales</h3>";
    $conexion1 = new ConexionPDO_Mysql(
        'mysql:host=localhost;dbname=referencia;charset=utf8mb4',
        'c1bd_admin',
        'BDA1'
    );
    
    echo "DSN: " . $conexion1->getDsn() . "<br>";
    echo "Usuario: " . $conexion1->getUsuario() . "<br>";
    echo "PWD: " . $conexion1->getPwd() . "<br><br>";

    // Prueba 2: Conexión desde archivo de configuración
    echo "<h3>Prueba 2: Conexión desde archivo de configuración (conectarBD)</h3>";
    $conexion2 = new ConexionPDO_Mysql();
    
    if ($conexion2->conectarBD('../secure/mysql_config_ej5.php')) {
        echo "Conexión establecida correctamente desde archivo de configuración.<br>";
        echo "Conexión PDO obtenida: " . (($conexion2->getConexion() !== null) ? "Sí" : "No") . "<br>";
        $conexion2->desconectarBD();
    }
    echo "<br>";

    // Prueba 3: Conexión pasando valores directamente
    echo "<h3>Prueba 3: Conexión pasando valores directamente (conectarBD_Valores)</h3>";
    $conexion3 = new ConexionPDO_Mysql();
    
    if ($conexion3->conectarBD_Valores(
        'mysql:host=localhost;dbname=referencia;charset=utf8mb4',
        'c1bd_admin',
        'BDA1'
    )) {
        echo "Conexión establecida correctamente con valores directos.<br>";
        echo "Conexión PDO obtenida: " . (($conexion3->getConexion() !== null) ? "Sí" : "No") . "<br>";
        $conexion3->desconectarBD();
    }
    echo "<br>";

    // Prueba 4: setParametros y luego conectarBD_Valores
    echo "<h3>Prueba 4: setParametros y luego conectarBD_Valores</h3>";
    $conexion4 = new ConexionPDO_Mysql();
    $conexion4->setParametros(
        'mysql:host=localhost;dbname=referencia;charset=utf8mb4',
        'c1bd_admin',
        'BDA1'
    );
    
    echo "Parámetros establecidos:<br>";
    echo "DSN: " . $conexion4->getDsn() . "<br>";
    echo "Usuario: " . $conexion4->getUsuario() . "<br>";
    echo "PWD: " . $conexion4->getPwd() . "<br>";
    
    if ($conexion4->conectarBD_Valores(
        $conexion4->getDsn(),
        $conexion4->getUsuario(),
        $conexion4->getPwd()
    )) {
        echo "Conexión establecida correctamente después de setParametros.<br>";
        $conexion4->desconectarBD();
    }
    echo "<br>";

    // Prueba 5: Verificar que implementa la interfaz
    echo "<h3>Prueba 5: Verificar implementación de interfaz</h3>";
    if ($conexion4 instanceof ConexionBD) {
        echo "✓ La clase ConexionPDO_Mysql implementa correctamente la interfaz ConexionBD.<br>";
    } else {
        echo "✗ Error: La clase no implementa la interfaz.<br>";
    }

} catch (PDOException $e) {
    echo "Error de base de datos: " . $e->getMessage() . "<br>";
} catch (Exception $e) {
    echo "Error general: " . $e->getMessage() . "<br>";
}

