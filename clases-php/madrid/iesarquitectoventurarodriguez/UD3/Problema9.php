<?php 
    /*
     * Ejercicio 9: Agregación
     * 
     * La agregación es una relación más débil que la composición.
     * Es como decir "tiene" pero los objetos hijos pueden existir por su cuenta.
     * 
     * Ejemplo real: una universidad tiene profesores, pero los profesores
     * pueden existir sin la universidad. Pueden trabajar en otra universidad
     * o ser independientes. Si la universidad desaparece, los profesores siguen existiendo.
     */

    // Clase Profesor: representa un profesor que puede trabajar en una universidad
    // 
    // En agregación, el profesor puede existir sin la universidad.
    // Puede trabajar en otra universidad o ser independiente.
    class Profesor { 
        
        // Datos del profesor
        private string $nombre;       // Nombre
        private int $edad;             // Edad
        private string $departamento;  // Departamento donde trabaja

        // Constructor: creamos un profesor
        // El profesor se crea independientemente, no necesita una universidad
        public function __construct(string $nombre = "", int $edad = 0, string $departamento = "") { 
            $this->nombre = $nombre; 
            $this->edad = $edad; 
            $this->departamento = $departamento; 
        } 

        // Setters
        public function setNombre(string $nombre): void { 
            $this->nombre = $nombre; 
        } 

        public function setEdad(int $edad): void { 
            $this->edad = $edad; 
        } 

        public function setDepartamento(string $departamento): void { 
            $this->departamento = $departamento; 
        } 

        // Getters
        public function getNombre(): string { 
            return $this->nombre; 
        } 

        public function getEdad(): int { 
            return $this->edad; 
        } 

        public function getDepartamento(): string { 
            return $this->departamento; 
        } 

        // enseñar(): muestra que el profesor está enseñando
        // El profesor puede enseñar sin estar en una universidad
        public function enseñar(): void { 
            echo "El profesor {$this->nombre} está enseñando en el departamento de {$this->departamento}.<br>"; 
        } 

        // obtenerDetalle(): devuelve un string con la información del profesor
        // 
        // Devuelve un string en lugar de mostrarlo directamente.
        // Esto nos permite usarlo de diferentes formas (mostrarlo, guardarlo, etc.)
        public function obtenerDetalle(): string { 
            return "Profesor: {$this->nombre}, {$this->edad} años, Departamento: {$this->departamento}"; 
        } 
    } 

    // Clase Universidad: representa una universidad que tiene profesores
    // 
    // En agregación, la universidad "tiene" profesores, pero:
    // - Los profesores pueden existir sin la universidad
    // - Un profesor puede trabajar en varias universidades
    // - Si la universidad desaparece, los profesores siguen existiendo
    class Universidad { 
        
        // Datos de la universidad
        private string $nombre;  // Nombre
        
        // Array para guardar los profesores que trabajan en la universidad
        // Esto es agregación: los profesores "trabajan para" la universidad
        // pero pueden existir independientemente
        private array $profesores; 

        // Constructor: creamos una universidad nueva
        public function __construct(string $nombre = "") { 
            $this->nombre = $nombre; 
            // Inicializamos el array vacío
            $this->profesores = []; 
        } 

        // Setters
        public function setNombre(string $nombre): void { 
            $this->nombre = $nombre; 
        } 

        // Getters
        public function getNombre(): string { 
            return $this->nombre; 
        } 

        // agregarProfesor(): añade un profesor a la universidad
        // 
        // IMPORTANTE: En agregación, el profesor ya existe antes de ser agregado.
        // No lo creamos aquí, solo lo "contratamos".
        public function agregarProfesor(Profesor $profesor): void { 
            // Evitamos duplicados
            if (!in_array($profesor, $this->profesores, true)) { 
                // Agregamos el profesor al array de la universidad
                $this->profesores[] = $profesor; 
            } 
        } 

        // mostrarProfesores(): muestra todos los profesores de la universidad
        public function mostrarProfesores(): void { 
            echo "Profesores de la Universidad {$this->nombre}:<br>"; 
            
            // Verificamos si hay profesores
            if (empty($this->profesores)) { 
                echo "No hay profesores registrados.<br>"; 
            } else { 
                // Recorremos todos los profesores
                foreach ($this->profesores as $profesor) { 
                    // Mostramos la información de cada profesor
                    echo $profesor->obtenerDetalle() . "<br>"; 
                } 
            } 
            echo "<br>"; 
        } 
    } 

    /*
     * Ahora vamos a probar todo esto
     * 
     * Lo importante aquí es demostrar que los profesores pueden existir
     * independientemente de la universidad.
     */
    
    // Creamos una universidad
    $universidad = new Universidad("Universidad Complutense de Madrid"); 
    echo "Universidad: " . $universidad->getNombre() . "<br><br>"; 

    /*
     * DEMOSTRACIÓN DE AGREGACIÓN
     * 
     * Creamos los profesores ANTES de agregarlos a la universidad.
     * Esto demuestra que los profesores pueden existir independientemente.
     */
    $profesor1 = new Profesor("Dr. García", 45, "Informática"); 
    $profesor2 = new Profesor("Dra. Martínez", 38, "Matemáticas"); 
    $profesor3 = new Profesor("Dr. López", 52, "Física"); 

    /*
     * DEMOSTRACIÓN: Los profesores pueden funcionar sin la universidad
     * 
     * El profesor puede enseñar y mostrar su información
     * sin estar asociado a ninguna universidad.
     */
    $profesor1->enseñar(); 
    echo $profesor1->obtenerDetalle() . "<br><br>"; 

    /*
     * Ahora agregamos los profesores a la universidad
     * 
     * En agregación, esto es como "contratar" a los profesores.
     * Los profesores siguen existiendo independientemente.
     */
    $universidad->agregarProfesor($profesor1); 
    $universidad->agregarProfesor($profesor2); 
    $universidad->agregarProfesor($profesor3); 

    // Mostramos todos los profesores de la universidad
    $universidad->mostrarProfesores(); 

    /*
     * DEMOSTRACIÓN FINAL: El profesor sigue existiendo independientemente
     * 
     * Aunque el profesor está en la universidad, sigue siendo un objeto independiente.
     * Puede seguir funcionando por su cuenta.
     */
    echo "El profesor sigue existiendo fuera de la universidad:<br>"; 
    echo $profesor2->obtenerDetalle() . "<br>"; 
?>
