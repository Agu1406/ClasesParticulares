<?php
/**
 * Clase para gestionar conexiones a MySQL usando PDO con soporte para transacciones
 * 
 * Esta clase permite conectarse a una base de datos MySQL utilizando PDO.
 * Incluye métodos para gestionar transacciones (beginTransaction, commit, rollback).
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
class MySQLConexion
{
    private string $dsn;
    private string $usuario;
    private string $password;
    private ?PDO $conexion = null;

    /**
     * Constructor de la clase
     * Lee los parámetros de conexión desde un archivo de configuración
     */
    public function __construct(string $rutaConfig = '../secure/mysql_config_ej5.php')
    {
        if (!file_exists($rutaConfig)) {
            throw new Exception("No se encontró el archivo de configuración: $rutaConfig");
        }

        // incluimos el archivo y espera que devuelva un array asociativo
        // en realidad, estamos utilizando un array con los parámetros de conexión.
        $config = require $rutaConfig;

        // si no es un array o no están en el array los parámetros que necesesitamos
        if (!is_array($config) ||
            !isset($config['dsn'], $config['usuario'], $config['password'])) {
            throw new Exception("El archivo de configuración no contiene los parámetros esperados.");
        }

        $this->dsn = $config['dsn'];
        $this->usuario = $config['usuario'];
        $this->password = $config['password'];
    }

    /**
     * Establece la conexión con la base de datos MySQL
     */
    public function conectar(): bool
    {
        try {
            $this->conexion = new PDO($this->dsn, $this->usuario, $this->password);
            $this->conexion->setAttribute(PDO::ATTR_ERRMODE,
                PDO::ERRMODE_EXCEPTION);
            return true;
        } catch (PDOException $e) {
            echo "Error de conexión: " . $e->getMessage();
            return false;
        }
    }

    /**
     * Devuelve la conexión PDO
     */
    public function getConexion(): ?PDO
    {
        return $this->conexion;
    }

    /**
     * Cierra la conexión con la base de datos
     */
    public function desconectar(): void
    {
        $this->conexion = null; //Cierra la conexión explícitamente
        echo "Conexión cerrada correctamente" . "<br>";
    }

    /**
     * Ejecuta una sentencia SELECT y devuelve los resultados
     */
    public function ejecutarConsulta(string $sql, array $parametros = []): array
    {
        if ($this->conexion === null) {
            throw new PDOException("No hay conexión activa con la base de datos.");
        }

        $stmt = $this->conexion->prepare($sql);
        $stmt->execute($parametros);
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    /**
     * Ejecuta una sentencia INSERT, UPDATE o DELETE
     */
    public function ejecutarSentencia(string $sql, array $parametros = []): int
    {
        if ($this->conexion === null) {
            throw new PDOException("No hay conexión activa con la base de datos.");
        }

        $stmt = $this->conexion->prepare($sql);
        $stmt->execute($parametros);
        return $stmt->rowCount();
    }

    /**
     * Inicia una transacción
     */
    public function iniciarTransaccion(): bool
    {
        if ($this->conexion === null) {
            throw new PDOException("No hay conexión activa con la base de datos.");
        }
        return $this->conexion->beginTransaction();
    }

    /**
     * Confirma una transacción (COMMIT)
     */
    public function confirmarTransaccion(): bool
    {
        if ($this->conexion === null) {
            throw new PDOException("No hay conexión activa con la base de datos.");
        }
        return $this->conexion->commit();
    }

    /**
     * Revierte una transacción (ROLLBACK)
     */
    public function revertirTransaccion(): bool
    {
        if ($this->conexion === null) {
            throw new PDOException("No hay conexión activa con la base de datos.");
        }
        return $this->conexion->rollBack();
    }
}

/**
 * =====> El bloque de código inferior es para realizar pruebas <======
 * 
 * Este ejemplo demuestra el uso de transacciones:
 * 1. Inicia una transacción con iniciarTransaccion()
 * 2. Ejecuta múltiples operaciones dentro de la transacción
 * 3. Si todo va bien, confirma los cambios con confirmarTransaccion()
 * 4. Si hay un error, revierte todos los cambios con revertirTransaccion()
 * 
 * Las transacciones garantizan que todas las operaciones se ejecuten correctamente
 * o que ninguna se ejecute (principio de atomicidad).
 */
try {
    $conexion = new MySQLConexion("../secure/mysql_config.php");

    if ($conexion->conectar()) {
        echo "Conexión establecida correctamente.<br>";

        // Iniciamos una transacción
        // Todas las operaciones siguientes formarán parte de esta transacción
        if ($conexion->iniciarTransaccion()) {
            echo "Transacción iniciada.<br>";

            try {
                // Primera operación: INSERT
                $stmt1 = "INSERT INTO EMPLEADOS(num_empleado, dni, nombre, apellido1, apellido2, tfno_empresa, sueldo, tfno_personal, transporte, num_jefe)
                         VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
                $parametros1 = [100, '12345678X', 'Nombre6', 'Apellido16', 'Apellido26', 999100, 30000, 555000, 2500, 1];
                
                $filasAfectadas1 = $conexion->ejecutarSentencia($stmt1, $parametros1);
                echo "Primera inserción realizada: $filasAfectadas1 fila(s) afectada(s).<br>";

                // Segunda operación: otro INSERT (ejemplo de múltiples operaciones en la misma transacción)
                // Descomenta las siguientes líneas si quieres probar con múltiples operaciones:
                /*
                $stmt2 = "INSERT INTO EMPLEADOS(num_empleado, dni, nombre, apellido1, apellido2, tfno_empresa, sueldo, tfno_personal, transporte, num_jefe)
                         VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
                $parametros2 = [101, '87654321Y', 'Nombre7', 'Apellido17', 'Apellido27', 999101, 32000, 555001, 2600, 1];
                
                $filasAfectadas2 = $conexion->ejecutarSentencia($stmt2, $parametros2);
                echo "Segunda inserción realizada: $filasAfectadas2 fila(s) afectada(s).<br>";
                */

                // Si llegamos aquí sin errores, confirmamos la transacción
                // Esto hace que todos los cambios se guarden permanentemente en la base de datos
                if ($conexion->confirmarTransaccion()) {
                    echo "Transacción confirmada (COMMIT). Los datos han sido insertados correctamente.<br>";
                } else {
                    echo "Error al confirmar la transacción.<br>";
                }

            } catch (PDOException $e) {
                // Si ocurre un error durante la ejecución, revertimos la transacción
                // Esto deshace todos los cambios realizados dentro de la transacción
                if ($conexion->revertirTransaccion()) {
                    echo "Transacción revertida (ROLLBACK). Todos los cambios han sido deshechos.<br>";
                }
                throw $e; // Re-lanzamos la excepción para que sea capturada por el catch externo
            }
        }

        $conexion->desconectar();
    }
} catch (PDOException $e) {
    echo "Error de base de datos: " . $e->getMessage() . "<br>";
} catch (Exception $e) {
    echo "Error general: " . $e->getMessage() . "<br>";
}
?>
