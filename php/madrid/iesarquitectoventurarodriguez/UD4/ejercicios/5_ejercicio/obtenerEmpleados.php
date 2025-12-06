<?php
/**
 * Ejercicio 5: Obtener empleados de la base de datos MySQL
 * 
 * Este script se conecta a la base de datos MySQL y obtiene todos los empleados
 * almacenados en la tabla empleados, mostrando el nombre y apellido1 de cada fila.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */

require_once 'MySQLConexion.php';

try {
    // Creamos la conexión (usa el valor por defecto)
    $conexion = new MySQLConexion();
    
    if ($conexion->conectar()) {
        echo "Conexión establecida correctamente.<br><br>";
        
        // Consulta SQL con parámetros seguros (aunque en este caso no hay parámetros)
        $sql = "SELECT * FROM empleados";
        
        // Ejecutamos la consulta
        $empleados = $conexion->ejecutarConsulta($sql);
        
        // Mostramos los resultados
        echo "<h2>Lista de Empleados</h2>";
        echo "<table border='1' cellpadding='5' cellspacing='0'>";
        echo "<tr><th>Nombre</th><th>Apellido 1</th></tr>";
        
        if (count($empleados) > 0) {
            foreach ($empleados as $empleado) {
                echo "<tr>";
                echo "<td>" . htmlspecialchars($empleado['nombre']) . "</td>";
                echo "<td>" . htmlspecialchars($empleado['apellido1']) . "</td>";
                echo "</tr>";
            }
        } else {
            echo "<tr><td colspan='2'>No se encontraron empleados.</td></tr>";
        }
        
        echo "</table>";
        
        // Cerramos la conexión
        $conexion->desconectar();
    }
} catch (PDOException $e) {
    echo "Error de base de datos: " . $e->getMessage();
} catch (Exception $e) {
    echo "Error general: " . $e->getMessage();
}

