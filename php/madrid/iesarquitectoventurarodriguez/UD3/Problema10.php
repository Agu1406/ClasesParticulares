<?php 
    /*
     * Ejercicio 10: Herencia con clase abstracta
     * 
     * Aquí vamos a ver herencia de verdad. Vamos a crear una clase "padre" que
     * define lo básico, y luego clases "hijas" que heredan todo eso y añaden
     * sus propias cosas.
     * 
     * También veremos qué es una clase abstracta: es una clase que no puedes
     * usar directamente, solo sirve como plantilla para otras clases.
     */

    // Clase abstracta Empleado: esta es la clase "padre"
    // 
    // abstract significa que NO puedes hacer: new Empleado()
    // Solo puedes crear objetos de las clases hijas (Analista, Programador).
    // 
    // Es como un molde que define qué debe tener un empleado, pero no puedes
    // crear un "empleado genérico", solo tipos específicos.
    abstract class Empleado { 
        
        // Estos son los atributos que TODOS los empleados tienen
        // Las clases hijas los heredarán automáticamente
        private string $nombre;    // Nombre
        private string $apellidos; // Apellidos
        private string $dni;       // DNI

        // Constructor: aunque la clase es abstracta, puede tener constructor
        // Las clases hijas lo llamarán con parent::__construct()
        public function __construct(string $nombre = "", string $apellidos = "", string $dni = "") { 
            $this->nombre = $nombre; 
            $this->apellidos = $apellidos; 
            $this->dni = $dni; 
        } 

        // Setters: métodos para cambiar los valores
        public function setNombre(string $value): void { 
            $this->nombre = $value; 
        } 

        public function setApellidos(string $value): void { 
            $this->apellidos = $value; 
        } 

        public function setDni(string $value): void { 
            $this->dni = $value; 
        } 

        // Getters: métodos para leer los valores
        public function getNombre(): string { 
            return $this->nombre; 
        } 

        public function getApellidos(): string { 
            return $this->apellidos; 
        } 

        public function getDni(): string { 
            return $this->dni; 
        } 

        /*
         * Métodos abstractos: estos métodos NO tienen código aquí
         * 
         * Solo decimos "debe existir un método trabajar() y un método cobrar()",
         * pero no decimos CÓMO hacerlo. Cada clase hija lo implementará a su manera.
         * 
         * Es como decir: "todos los empleados trabajan y cobran, pero cada uno
         * lo hace de forma diferente".
         * 
         * Si una clase hija no implementa estos métodos, dará error.
         */
        abstract public function trabajar(): void; 
        abstract public function cobrar(): void; 
    } 

    // Clase Analista: hereda de Empleado
    // 
    // extends Empleado significa que Analista "hereda" todo lo de Empleado.
    // Tiene nombre, apellidos, dni, getters, setters... todo automáticamente.
    // Pero además puede tener sus propias cosas.
    class Analista extends Empleado { 
        
        // Este atributo solo existe en Analista, no en Empleado
        private string $capa; // La capa en la que trabaja (ej: "Presentación", "Lógica")

        // Constructor: cuando creamos un Analista
        // 
        // IMPORTANTE: llamamos al constructor del padre con parent::__construct()
        // para inicializar los atributos heredados (nombre, apellidos, dni).
        public function __construct(string $nombre = "", string $apellidos = "", string $dni = "", string $capa = "") { 
            // Llamamos al constructor del padre para inicializar nombre, apellidos y dni
            parent::__construct($nombre, $apellidos, $dni); 
            
            // Inicializamos el atributo específico de Analista
            $this->capa = $capa; 
        } 

        // Setters y getters para el atributo específico de Analista
        public function setCapa(string $value): void { 
            $this->capa = $value; 
        } 

        public function getCapa(): string { 
            return $this->capa; 
        } 

        /*
         * Ahora implementamos los métodos abstractos del padre
         * 
         * Estos métodos son OBLIGATORIOS. El padre dijo "debe haber trabajar() y cobrar()",
         * así que aquí los implementamos para Analista.
         */
        
        // trabajar(): cómo trabaja un analista
        public function trabajar(): void { 
            // Usamos getNombre() porque $nombre es privado en la clase padre
            echo "El analista {$this->getNombre()} está analizando requisitos en la capa {$this->capa}.<br>"; 
        } 

        // cobrar(): cómo cobra un analista
        public function cobrar(): void { 
            echo "El analista {$this->getNombre()} está cobrando su salario.<br>"; 
        } 

        // mostrarDetalle(): método propio de Analista (no está en Empleado)
        public function mostrarDetalle(): void { 
            echo "Analista: {$this->getNombre()} {$this->getApellidos()}<br>"; 
            echo "DNI: {$this->getDni()}<br>"; 
            echo "Capa: {$this->capa}<br>"; 
        } 
    } 

    // Clase Programador: también hereda de Empleado
    // 
    // Tiene todo lo de Empleado, pero implementa trabajar() y cobrar() de forma diferente.
    class Programador extends Empleado { 
        
        // Atributo específico de Programador
        private string $lenguaje; // El lenguaje que usa (ej: "PHP", "Java")

        // Constructor: igual que Analista, llamamos al del padre
        public function __construct(string $nombre = "", string $apellidos = "", string $dni = "", string $lenguaje = "") { 
            // Inicializamos los atributos heredados
            parent::__construct($nombre, $apellidos, $dni); 
            
            // Inicializamos el atributo específico
            $this->lenguaje = $lenguaje; 
        } 

        // Setters y getters
        public function setLenguaje(string $value): void { 
            $this->lenguaje = $value; 
        } 

        public function getLenguaje(): string { 
            return $this->lenguaje; 
        } 

        /*
         * Implementamos los métodos abstractos del padre
         * 
         * Mismo método que Analista, pero con comportamiento diferente.
         * Esto es polimorfismo: mismo método, diferente comportamiento.
         */
        
        // trabajar(): cómo trabaja un programador
        public function trabajar(): void { 
            echo "El programador {$this->getNombre()} está programando en {$this->lenguaje}.<br>"; 
        } 

        // cobrar(): cómo cobra un programador
        public function cobrar(): void { 
            echo "El programador {$this->getNombre()} está cobrando su salario.<br>"; 
        } 

        // mostrarDetalle(): método propio de Programador
        public function mostrarDetalle(): void { 
            echo "Programador: {$this->getNombre()} {$this->getApellidos()}<br>"; 
            echo "DNI: {$this->getDni()}<br>"; 
            echo "Lenguaje: {$this->lenguaje}<br>"; 
        } 
    } 

    /*
     * Ahora vamos a probar todo esto
     */
    
    // Creamos un Analista con todos los datos
    $analista1 = new Analista("Ana", "García López", "12345678A", "Presentación"); 
    $analista1->mostrarDetalle(); 
    $analista1->trabajar();  // Cada clase tiene su propia implementación
    $analista1->cobrar(); 
    echo "<br>"; 

    // Creamos un Analista vacío y lo llenamos después
    $analista2 = new Analista(); 
    $analista2->setNombre("Carlos"); 
    $analista2->setApellidos("Martínez Ruiz"); 
    $analista2->setDni("87654321B"); 
    $analista2->setCapa("Lógica de Negocio"); 
    $analista2->mostrarDetalle(); 
    $analista2->trabajar(); 
    echo "<br>"; 

    // Creamos un Programador
    $programador1 = new Programador("Luis", "Fernández Sánchez", "11223344C", "PHP"); 
    $programador1->mostrarDetalle(); 
    $programador1->trabajar();  // Mismo método, pero comportamiento diferente
    $programador1->cobrar(); 
    echo "<br>"; 

    // Creamos otro Programador vacío
    $programador2 = new Programador(); 
    $programador2->setNombre("María"); 
    $programador2->setApellidos("Rodríguez Pérez"); 
    $programador2->setDni("99887766D"); 
    $programador2->setLenguaje("Java"); 
    $programador2->mostrarDetalle(); 
    $programador2->trabajar(); 
    
    /*
     * IMPORTANTE: No podemos hacer esto:
     * $empleado = new Empleado("Juan", "Pérez", "12345678A");
     * 
     * Porque Empleado es abstracta. Solo podemos crear Analista o Programador.
     */
?>
