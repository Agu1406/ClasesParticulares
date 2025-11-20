<?php


class conexionMySQL {

    /**
     * ¿Que esel "DSN"? Sus siglas vienen del inglés "Data Source Name" (Nombre de Fuente de Datos).
     * y es una mezcla de varios datos necesarios para la conexión a una base de datos, esos son:
     * - El tipo de base de datos (MySQL, PostgreSQL, SQLite, etc).
     * - La dirección del servidor (host=localhost).
     * - El nombre de la base de datos (dbname=nombre_basedatos).
     * - Otros campos no obligatorios como el puerto o el conjunto de caracteres.
     * .
     * Nosotros tenemos el siguiente dsn:
     * mysql:host=localhost;dbname=servidor;charset=utf8mb4
     */
    private string $dsn;
    private string $usuario;
    private string $password;

    /**
     * PDO (PHP Data Objects) es la clase nativa de PHP que se encarga
     * de conectar PHP con la base de datos.
     */
    private ? PDO $conexion = null;

    /**
     * Constructor de la clase "conexionMySQL", su unico objetivo es buscar
     * y leer el archivo donde están los datos de conexión a la base de datos.
     * y extraerlos y guardarlos.
     */
    public function __construct(string $rutaConfiguracion = "./mysql_config.php") {
        
        // Leo el archivo y guardo sus datos de forma array.
        $arrayDatos = include($rutaConfiguracion);

        // Extraigo del Array de datos los datos de la conexión.
        $this->dsn = $arrayDatos['dsn'];
        $this->usuario = $arrayDatos['usuario'];
        $this->password = $arrayDatos['password'];
    }


    public function conectar(): bool {
        try {

            // La variable "Conexión" se convierte en "PDO" con los datos de la base de datos.
            $this -> conexion = new PDO($this->dsn, $this->usuario, $this->password);

            /**
             * - ATTR_ERRMODE: Significa "Atributo Modo de Error", sirve para definir
             *   como queremos que PDO gestione los errores.
             *.
             * - ERRMODE_EXCEPTION: Significa que si ocurre un error, se lanzará una excepción
             *   de tipo "PDOException", que podemos capturar y manejar en nuestro código.
             */
            $this -> conexion -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

            return true;

        } catch (PDOException $excepcion) {
            // Si ocurre una excepción mostramos un mensaje de error completo.
            echo "¡Error de conexion! " . $excepcion->getMessage();
            // Devuelve "false" porque la conexión ha fallado.
            return false;
        }
    }

    /**
     * Devuelve la conexión PDO
     * @return PDO|null
     */
    public function getConexion(): ?PDO
    {
        return $this->conexion;
    }

    // SELECT => Devuelve un array con los resultados de la consulta.
    function selectEmpleados() {

        // Consulta para ver todos los empleados de la tabla empleados y sus columnas.
        $consulta = "SELECT * FROM empleados;";

        // "Conexion" lee la consulta y la prepara para ejecutarla.
        $respuesta = $this -> conexion -> prepare($consulta);

        // Execute abre la base de datos, ejecuta la consulta y guarda el resultado.
        $respuesta -> execute();

        /**
         * Ejemplo de resultado de la consulta en formato JSON:
         * [
        *       { "num_empleado": 1, "nombre": "Juan", "apellido": "Pérez", "email": ejemplo"}
        *       { "num_empleado": 2, "nombre": "María", "apellido": "García", "email": ejemplo2"}
        *       { "num_empleado": 3, "nombre": "Luis", "apellido": "Martínez", "email": ejemplo3"}
         * ]
         * .
         * Ejemplo de resultado convertido a array asociativo de PHP:
         * [
         * Fila0    [ "num_empleado" => 1, "nombre" => "Juan", "apellido" => "Pérez", "email" => ejemplo"],
         * Fila1    [ "num_empleado" => 2, "nombre" => "María", "apellido" => "García", "email" => ejemplo2"],
         * Fila2    [ "num_empleado" => 3, "nombre" => "Luis", "apellido" => "Martínez", "email" => ejemplo3"],
         * ]
         */

        echo "<h2>Lista de empleados (Ejercicio de consulta SELECT)</h2>";
        echo "<table border='1'>";
        echo "<tr><th>Número Empleado</th><th>Nombre</th></tr>";

        // Convertimos el resultado en un array asociativo de PHP y leemos una por una las filas.
        while ($fila = $respuesta -> fetch(PDO::FETCH_ASSOC)) {
            // Extraigo de la fila los datos que quiero mostrar.
            $numeroEmpleado = $fila["num_empleado"];
            $nombre = $fila["nombre"];

            
            echo "<tr>";
            echo "<td>" . $numeroEmpleado . "</td>";
            echo "<td>" . $nombre . "</td>";
            echo "</tr>";

            echo "Numero de empleado: " . $numeroEmpleado . " - nombre: " . $nombre . "<br>";
        }

        echo "</table>";
    }
}


?>
