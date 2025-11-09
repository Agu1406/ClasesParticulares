<?php 
    /*
     * Ejercicio 11: Interfaces
     * 
     * Una interfaz es como un "contrato" que define qué métodos debe tener una clase.
     * No dice CÓMO hacerlo, solo QUÉ debe hacer.
     * 
     * En este ejercicio:
     * - La interfaz ConexionBD define que debe haber métodos para conectar y desconectar
     * - Las clases ConexionJDBC y ConexionODBC implementan esa interfaz
     * - Cada una lo hace a su manera (JDBC vs ODBC), pero cumplen el mismo contrato
     * 
     * Esto permite usar diferentes tipos de conexión de forma intercambiable (polimorfismo).
     */

    // Interfaz ConexionBD: define el "contrato" que deben cumplir las clases
    // 
    // Una interfaz solo define métodos, no los implementa.
    // Las clases que implementen esta interfaz DEBEN tener estos métodos.
    interface ConexionBD { 
        public function conectarBD(): void; 
        public function desconectarBD(): void; 
    } 

    // Clase ConexionJDBC: implementa la interfaz ConexionBD usando JDBC
    // 
    // implements ConexionBD = esta clase debe tener los métodos de la interfaz
    class ConexionJDBC implements ConexionBD { 
        
        // Datos de conexión
        private string $host;     // Dirección del servidor
        private int $puerto;       // Puerto de conexión
        private string $servicio; // Nombre del servicio/base de datos
        private string $usuario; // Usuario
        private string $pwd;      // Contraseña

        // Constructor: creamos una conexión JDBC con sus datos
        public function __construct(string $host = "", int $puerto = 0, string $servicio = "", string $usuario = "", string $pwd = "") { 
            $this->host = $host; 
            $this->puerto = $puerto; 
            $this->servicio = $servicio; 
            $this->usuario = $usuario; 
            $this->pwd = $pwd; 
        } 

        // Setters: métodos para cambiar los valores
        public function setHost(string $value): void { 
            $this->host = $value; 
        } 

        public function setPuerto(int $value): void { 
            $this->puerto = $value; 
        } 

        public function setServicio(string $value): void { 
            $this->servicio = $value; 
        } 

        public function setUsuario(string $value): void { 
            $this->usuario = $value; 
        } 

        public function setPwd(string $value): void { 
            $this->pwd = $value; 
        } 

        // Getters: métodos para leer los valores
        public function getHost(): string { 
            return $this->host; 
        } 

        public function getPuerto(): int { 
            return $this->puerto; 
        } 

        public function getServicio(): string { 
            return $this->servicio; 
        } 

        public function getUsuario(): string { 
            return $this->usuario; 
        } 

        public function getPwd(): string { 
            return $this->pwd; 
        } 

        // setParametrosConexion(): establece todos los parámetros de una vez
        public function setParametrosConexion(string $host, int $puerto, string $servicio, string $usuario, string $pwd): void { 
            $this->host = $host; 
            $this->puerto = $puerto; 
            $this->servicio = $servicio; 
            $this->usuario = $usuario; 
            $this->pwd = $pwd; 
        } 

        // conectarBD(): implementa el método de la interfaz
        // 
        // Este método es OBLIGATORIO porque la interfaz lo requiere.
        // Aquí implementamos cómo conectar usando JDBC.
        public function conectarBD(): void { 
            echo "Conectando a BD mediante JDBC...<br>"; 
            echo "Host: {$this->host}, Puerto: {$this->puerto}, Servicio: {$this->servicio}<br>"; 
            echo "Usuario: {$this->usuario}<br>"; 
            echo "Conexión JDBC establecida correctamente.<br>"; 
        } 

        // desconectarBD(): implementa el método de la interfaz
        // 
        // Este método también es OBLIGATORIO.
        // Aquí implementamos cómo desconectar usando JDBC.
        public function desconectarBD(): void { 
            echo "Desconectando de BD mediante JDBC...<br>"; 
            echo "Conexión JDBC cerrada.<br>"; 
        } 

        // mostrarDetalle(): muestra la información de la conexión
        public function mostrarDetalle(): void { 
            echo "Conexión JDBC:<br>"; 
            echo "Host: {$this->host}<br>"; 
            echo "Puerto: {$this->puerto}<br>"; 
            echo "Servicio: {$this->servicio}<br>"; 
            echo "Usuario: {$this->usuario}<br>"; 
        } 
    } 

    // Clase ConexionODBC: implementa la interfaz ConexionBD usando ODBC
    // 
    // También implementa la misma interfaz, pero de forma diferente.
    // Esto es polimorfismo: mismo contrato, diferente implementación.
    class ConexionODBC implements ConexionBD { 
        
        // Mismos datos de conexión que JDBC
        private string $host; 
        private int $puerto; 
        private string $servicio; 
        private string $usuario; 
        private string $pwd; 

        // Constructor: creamos una conexión ODBC
        public function __construct(string $host = "", int $puerto = 0, string $servicio = "", string $usuario = "", string $pwd = "") { 
            $this->host = $host; 
            $this->puerto = $puerto; 
            $this->servicio = $servicio; 
            $this->usuario = $usuario; 
            $this->pwd = $pwd; 
        } 

        // Setters
        public function setHost(string $value): void { 
            $this->host = $value; 
        } 

        public function setPuerto(int $value): void { 
            $this->puerto = $value; 
        } 

        public function setServicio(string $value): void { 
            $this->servicio = $value; 
        } 

        public function setUsuario(string $value): void { 
            $this->usuario = $value; 
        } 

        public function setPwd(string $value): void { 
            $this->pwd = $value; 
        } 

        // Getters
        public function getHost(): string { 
            return $this->host; 
        } 

        public function getPuerto(): int { 
            return $this->puerto; 
        } 

        public function getServicio(): string { 
            return $this->servicio; 
        } 

        public function getUsuario(): string { 
            return $this->usuario; 
        } 

        public function getPwd(): string { 
            return $this->pwd; 
        } 

        // setParametrosConexion(): establece todos los parámetros
        public function setParametrosConexion(string $host, int $puerto, string $servicio, string $usuario, string $pwd): void { 
            $this->host = $host; 
            $this->puerto = $puerto; 
            $this->servicio = $servicio; 
            $this->usuario = $usuario; 
            $this->pwd = $pwd; 
        } 

        // conectarBD(): implementa el método de la interfaz
        // 
        // Mismo método que JDBC, pero implementado de forma diferente (usando ODBC).
        public function conectarBD(): void { 
            echo "Conectando a BD mediante ODBC...<br>"; 
            echo "Host: {$this->host}, Puerto: {$this->puerto}, Servicio: {$this->servicio}<br>"; 
            echo "Usuario: {$this->usuario}<br>"; 
            echo "Conexión ODBC establecida correctamente.<br>"; 
        } 

        // desconectarBD(): implementa el método de la interfaz
        public function desconectarBD(): void { 
            echo "Desconectando de BD mediante ODBC...<br>"; 
            echo "Conexión ODBC cerrada.<br>"; 
        } 

        // mostrarDetalle(): muestra la información de la conexión
        public function mostrarDetalle(): void { 
            echo "Conexión ODBC:<br>"; 
            echo "Host: {$this->host}<br>"; 
            echo "Puerto: {$this->puerto}<br>"; 
            echo "Servicio: {$this->servicio}<br>"; 
            echo "Usuario: {$this->usuario}<br>"; 
        } 
    } 

    /*
     * Ahora vamos a probar todo esto
     */
    
    // Probamos la conexión JDBC
    echo "Conexión JDBC:<br>"; 
    $conexionJDBC = new ConexionJDBC("localhost", 3306, "mysql", "root", "password123"); 
    $conexionJDBC->mostrarDetalle(); 
    echo "<br>"; 
    $conexionJDBC->conectarBD(); 
    echo "<br>"; 
    $conexionJDBC->desconectarBD(); 
    echo "<br><br>"; 

    // Probamos la conexión ODBC
    echo "Conexión ODBC:<br>"; 
    $conexionODBC = new ConexionODBC(); 
    $conexionODBC->setParametrosConexion("192.168.1.100", 1433, "SQLServer", "admin", "secret456"); 
    $conexionODBC->mostrarDetalle(); 
    echo "<br>"; 
    $conexionODBC->conectarBD(); 
    echo "<br>"; 
    $conexionODBC->desconectarBD(); 
    echo "<br><br>"; 

    /*
     * POLIMORFISMO: usar la interfaz
     * 
     * Como ambas clases implementan la misma interfaz, podemos tratarlas
     * de la misma forma. Podemos ponerlas en un array y llamar a los mismos
     * métodos sin importar si es JDBC o ODBC.
     * 
     * Esto es muy útil: podemos cambiar el tipo de conexión sin cambiar
     * el código que las usa.
     */
    echo "Polimorfismo con interfaz:<br>"; 
    $conexiones = [ 
        new ConexionJDBC("db.example.com", 5432, "postgres", "user1", "pass1"), 
        new ConexionODBC("db2.example.com", 1521, "oracle", "user2", "pass2") 
    ]; 

    // Recorremos todas las conexiones y las usamos de la misma forma
    foreach ($conexiones as $conexion) { 
        $conexion->conectarBD(); 
        $conexion->desconectarBD(); 
        echo "<br>"; 
    } 
?>
