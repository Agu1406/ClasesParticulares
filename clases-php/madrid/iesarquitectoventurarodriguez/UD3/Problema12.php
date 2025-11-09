<?php 
    /*
     * Ejercicio 12: Herencia con Sitio, Abierto y Sala
     * 
     * Este ejercicio muestra herencia en un caso real de gestión de espacios.
     * 
     * Tenemos una clase base "Sitio" que representa cualquier espacio de trabajo.
     * Luego tenemos dos clases especializadas:
     * - Abierto: puestos de trabajo individuales o compartidos
     * - Sala: espacios para reuniones
     * 
     * Ambas heredan de Sitio, así que tienen todos sus atributos y métodos,
     * pero además tienen sus propios atributos específicos.
     */

    // Clase Sitio: clase base que representa cualquier espacio de trabajo
    class Sitio { 
        
        // Atributos comunes a todos los sitios
        private int $identificador;    // ID único del sitio
        private string $nombre;        // Nombre del sitio
        private string $planta;        // En qué planta está
        private string $descripcion;   // Descripción del sitio
        private string $esVentana;     // Si tiene ventana (S/N)
        private string $tipo;          // Tipo de sitio (A=Abierto, S=Sala)

        // Constructor: creamos un sitio con sus datos básicos
        public function __construct(int $identificador, string $nombre, string $planta, string $descripcion, string $esVentana = "S", string $tipo = "A") { 
            $this->identificador = $identificador; 
            $this->nombre = $nombre; 
            $this->planta = $planta; 
            $this->descripcion = $descripcion; 
            $this->esVentana = $esVentana; 
            $this->tipo = $tipo; 
        } 

        // Setters
        public function setIdentificador(int $identificador): void { 
            $this->identificador = $identificador; 
        } 

        public function setNombre(string $nombre): void { 
            $this->nombre = $nombre; 
        } 

        public function setPlanta(string $planta): void { 
            $this->planta = $planta; 
        } 

        public function setDescripcion(string $descripcion): void { 
            $this->descripcion = $descripcion; 
        } 

        public function setEsVentana(string $esVentana): void { 
            $this->esVentana = $esVentana; 
        } 

        public function setTipo(string $tipo): void { 
            $this->tipo = $tipo; 
        } 

        // Getters
        public function getIdentificador(): int { 
            return $this->identificador; 
        } 

        public function getNombre(): string { 
            return $this->nombre; 
        } 

        public function getPlanta(): string { 
            return $this->planta; 
        } 

        public function getDescripcion(): string { 
            return $this->descripcion; 
        } 

        public function getEsVentana(): string { 
            return $this->esVentana; 
        } 

        public function getTipo(): string { 
            return $this->tipo; 
        } 

        // mostrarInfo(): muestra la información común del sitio
        public function mostrarInfo(): void { 
            echo "Sitio ID: {$this->identificador}<br>"; 
            echo "Nombre: {$this->nombre}<br>"; 
            echo "Planta: {$this->planta}<br>"; 
            echo "Descripción: {$this->descripcion}<br>"; 
            echo "Tiene ventana: " . ($this->esVentana == "S" ? "Sí" : "No") . "<br>"; 
            echo "Tipo: {$this->tipo}<br>"; 
        } 
    } 

    // Clase Abierto: hereda de Sitio
    // 
    // Representa puestos de trabajo individuales o compartidos.
    // Tiene todos los atributos de Sitio, más algunos específicos.
    class Abierto extends Sitio { 
        
        // Atributos específicos de sitios abiertos
        private string $tipoMesa;      // Tipo de mesa (R=Rectangular, L=L, etc.)
        private string $tieneCajonera; // Si tiene cajonera (S/N)
        private ?int $numEmpleado;     // Número del empleado asignado (puede ser null)

        // Constructor: creamos un sitio abierto
        // 
        // IMPORTANTE: Llamamos al constructor del padre con parent::__construct()
        // para inicializar los atributos heredados.
        public function __construct(int $identificador, string $nombre, string $planta, string $descripcion, string $esVentana = "S", string $tipoMesa = "R", string $tieneCajonera = "S", ?int $numEmpleado = null) { 
            // Llamamos al constructor del padre para inicializar los atributos heredados
            // Le pasamos "A" como tipo porque es un sitio abierto
            parent::__construct($identificador, $nombre, $planta, $descripcion, $esVentana, "A"); 
            
            // Inicializamos los atributos específicos de Abierto
            $this->tipoMesa = $tipoMesa; 
            $this->tieneCajonera = $tieneCajonera; 
            $this->numEmpleado = $numEmpleado; 
        } 

        // Setters
        public function setTipoMesa(string $tipoMesa): void { 
            $this->tipoMesa = $tipoMesa; 
        } 

        public function setTieneCajonera(string $tieneCajonera): void { 
            $this->tieneCajonera = $tieneCajonera; 
        } 

        public function setNumEmpleado(?int $numEmpleado): void { 
            $this->numEmpleado = $numEmpleado; 
        } 

        // Getters
        public function getTipoMesa(): string { 
            return $this->tipoMesa; 
        } 

        public function getTieneCajonera(): string { 
            return $this->tieneCajonera; 
        } 

        public function getNumEmpleado(): ?int { 
            return $this->numEmpleado; 
        } 

        // mostrarInfo(): sobrescribe el método del padre
        // 
        // Primero mostramos la información heredada (llamando al método del padre),
        // y luego añadimos la información específica de Abierto.
        public function mostrarInfo(): void { 
            // Mostramos la información común (del padre)
            parent::mostrarInfo(); 
            
            // Añadimos la información específica de Abierto
            echo "Tipo de mesa: {$this->tipoMesa}<br>"; 
            echo "Tiene cajonera: " . ($this->tieneCajonera == "S" ? "Sí" : "No") . "<br>"; 
            
            // Si tiene empleado asignado, lo mostramos
            if ($this->numEmpleado !== null) { 
                echo "Número de empleado: {$this->numEmpleado}<br>"; 
            } else { 
                echo "Número de empleado: No asignado<br>"; 
            } 
        } 
    } 

    // Clase Sala: hereda de Sitio
    // 
    // Representa espacios para reuniones, formación o trabajo colaborativo.
    // También tiene todos los atributos de Sitio, más algunos específicos.
    class Sala extends Sitio { 
        
        // Atributos específicos de salas
        private int $cantidadPuestos;  // Cuántos puestos tiene
        private string $tienePizarra;  // Si tiene pizarra (S/N)
        private string $tieneProyector; // Si tiene proyector (S/N)

        // Constructor: creamos una sala
        // 
        // También llamamos al constructor del padre para inicializar los atributos heredados.
        public function __construct(int $identificador, string $nombre, string $planta, string $descripcion, string $esVentana = "S", int $cantidadPuestos = 0, string $tienePizarra = "S", string $tieneProyector = "S") { 
            // Llamamos al constructor del padre
            // Le pasamos "S" como tipo porque es una sala
            parent::__construct($identificador, $nombre, $planta, $descripcion, $esVentana, "S"); 
            
            // Inicializamos los atributos específicos de Sala
            $this->cantidadPuestos = $cantidadPuestos; 
            $this->tienePizarra = $tienePizarra; 
            $this->tieneProyector = $tieneProyector; 
        } 

        // Setters
        public function setCantidadPuestos(int $cantidadPuestos): void { 
            $this->cantidadPuestos = $cantidadPuestos; 
        } 

        public function setTienePizarra(string $tienePizarra): void { 
            $this->tienePizarra = $tienePizarra; 
        } 

        public function setTieneProyector(string $tieneProyector): void { 
            $this->tieneProyector = $tieneProyector; 
        } 

        // Getters
        public function getCantidadPuestos(): int { 
            return $this->cantidadPuestos; 
        } 

        public function getTienePizarra(): string { 
            return $this->tienePizarra; 
        } 

        public function getTieneProyector(): string { 
            return $this->tieneProyector; 
        } 

        // mostrarInfo(): sobrescribe el método del padre
        // 
        // Igual que en Abierto: mostramos la información heredada y luego la específica.
        public function mostrarInfo(): void { 
            // Mostramos la información común (del padre)
            parent::mostrarInfo(); 
            
            // Añadimos la información específica de Sala
            echo "Cantidad de puestos: {$this->cantidadPuestos}<br>"; 
            echo "Tiene pizarra: " . ($this->tienePizarra == "S" ? "Sí" : "No") . "<br>"; 
            echo "Tiene proyector: " . ($this->tieneProyector == "S" ? "Sí" : "No") . "<br>"; 
        } 
    } 

    /*
     * Ahora vamos a probar todas las clases
     */
    
    // Probamos la clase base Sitio
    echo "Sitio base:<br>"; 
    $sitio1 = new Sitio(1, "Sitio General", "Planta 1", "Sitio de trabajo general"); 
    $sitio1->mostrarInfo(); 
    echo "<br>"; 

    // Probamos la clase Abierto (hereda de Sitio)
    echo "Sitio abierto:<br>"; 
    $abierto1 = new Abierto(2, "Puesto Individual 1", "Planta 2", "Puesto de trabajo individual", "S", "R", "S", 1001); 
    $abierto1->mostrarInfo(); 
    echo "<br>"; 

    $abierto2 = new Abierto(3, "Puesto Compartido", "Planta 1", "Puesto compartido", "N", "L", "N"); 
    $abierto2->mostrarInfo(); 
    echo "<br>"; 

    // Probamos la clase Sala (también hereda de Sitio)
    echo "Sala:<br>"; 
    $sala1 = new Sala(4, "Sala de Reuniones A", "Planta 3", "Sala para reuniones de equipo", "S", 10, "S", "S"); 
    $sala1->mostrarInfo(); 
    echo "<br>"; 

    $sala2 = new Sala(5, "Aula de Formación", "Planta 2", "Aula para formación", "N", 25, "S", "S"); 
    $sala2->mostrarInfo(); 
    echo "<br>"; 

    // Probamos los getters y setters
    echo "Prueba de getters/setters:<br>"; 
    $abierto1->setNumEmpleado(2005); 
    echo "Nuevo número de empleado: " . $abierto1->getNumEmpleado() . "<br>"; 
    $sala1->setCantidadPuestos(15); 
    echo "Nueva cantidad de puestos: " . $sala1->getCantidadPuestos() . "<br>"; 
?>
