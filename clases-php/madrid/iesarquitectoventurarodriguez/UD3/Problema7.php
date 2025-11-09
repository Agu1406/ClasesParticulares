<?php 
    /*
     * Ejercicio 7: Asociación bidireccional entre Alumno y Módulo
     * 
     * Aquí vamos a ver cómo relacionar dos clases de forma que se conozcan entre sí.
     * Un alumno puede estar en varios módulos, y un módulo puede tener varios alumnos.
     * Es como en la vida real: tú estás en varias clases, y cada clase tiene varios estudiantes.
     */

    // Clase Alumno: representa a un estudiante
    class Alumno { 
        
        // Datos personales del alumno
        private string $dni;        // Su DNI
        private int $nia;           // Número de identificación del alumno
        private string $nombre;     // Su nombre
        private string $apellido1; // Primer apellido
        private string $apellido2; // Segundo apellido
        private string $telefono;   // Teléfono
        private string $email;      // Email
        
        // Aquí viene lo importante: un array para guardar los módulos en los que está matriculado
        // Al principio está vacío, porque cuando creamos el alumno todavía no está en ningún módulo
        private array $modulos; 

        // Constructor: cuando creamos un alumno, le pasamos sus datos
        public function __construct(string $dni = "", 
                                    int $nia = 0, 
                                    string $nombre = "", 
                                    string $apellido1 = "", 
                                    string $apellido2 = "", 
                                    string $telefono = "", 
                                    string $email = "" ) { 
            // Guardamos todos los datos que nos pasan
            $this->dni = $dni; 
            $this->nia = $nia; 
            $this->nombre = $nombre; 
            $this->apellido1 = $apellido1; 
            $this->apellido2 = $apellido2; 
            $this->telefono = $telefono; 
            $this->email = $email; 
            
            // Inicializamos el array vacío, porque todavía no tiene módulos
            $this->modulos = []; 
        } 

        // Setters: métodos para cambiar los valores después de crear el objeto
        public function setDni(string $dni): void { $this->dni = $dni; } 
        public function setNia(int $nia): void { $this->nia = $nia; } 
        public function setNombre(string $nombre): void { $this->nombre = $nombre; } 
        public function setApellido1(string $apellido1): void { $this->apellido1 = $apellido1; } 
        public function setApellido2(string $apellido2): void { $this->apellido2 = $apellido2; } 
        public function setTelefono(string $telefono): void { $this->telefono = $telefono; } 
        public function setEmail(string $email): void { $this->email = $email; } 

        // Getters: métodos para leer los valores (como son privados, necesitamos estos métodos)
        public function getDni(): string { return $this->dni; } 
        public function getNia(): int { return $this->nia; } 
        public function getNombre(): string { return $this->nombre; } 
        public function getApellido1(): string { return $this->apellido1; } 
        public function getApellido2(): string { return $this->apellido2; } 
        public function getTelefono(): string { return $this->telefono; } 
        public function getEmail(): string { return $this->email; } 

        /*
         * agregarModulo(): este es el método clave para la relación bidireccional
         * 
         * Cuando un alumno se matricula en un módulo, tenemos que hacer dos cosas:
         * 1. Agregar el módulo a la lista de módulos del alumno
         * 2. Agregar el alumno a la lista de alumnos del módulo
         * 
         * Así ambos se conocen entre sí. Es bidireccional porque funciona en ambas direcciones.
         */
        public function agregarModulo(Modulo $modulo): void { 
            // Primero verificamos que el módulo no esté ya en la lista (evitamos duplicados)
            if (!in_array($modulo, $this->modulos, true)) { 
                // Agregamos el módulo a la lista del alumno
                $this->modulos[] = $modulo; 
                 
                // Y aquí está la magia: también le decimos al módulo que agregue a este alumno
                // Así el módulo también sabe que este alumno está matriculado
                $modulo->agregarAlumno($this); 
            } 
        } 

        // mostrarDetalle(): muestra la información del alumno
        public function mostrarDetalle(): void { 
            echo "Alumno: {$this->nombre} {$this->apellido1} {$this->apellido2} (NIA: {$this->nia}, DNI: {$this->dni})<br>"; 
            echo "Teléfono: {$this->telefono}, Email: {$this->email}<br>"; 
        } 

        // obtenerModulos(): devuelve la lista de módulos del alumno
        // En un sistema real, esto consultaría una base de datos
        public function obtenerModulos(): array { 
            return $this->modulos; 
        } 

        // mostrarModulos(): recorre todos los módulos y muestra su información
        public function mostrarModulos(): void { 
            echo "Módulos matriculados por {$this->nombre}<br>"; 
            
            // Recorremos cada módulo en el array
            foreach ($this->modulos as $modulo) { 
                // Y mostramos su información
                $modulo->mostrarDetalle(); 
            } 
            echo "<br>"; 
        } 
    } 

    // Clase Modulo: representa una asignatura o materia
    class Modulo { 
        
        // Datos del módulo
        private int $codigo_modulo;    // Código único del módulo
        private string $nombre;        // Nombre del módulo (ej: "Programación")
        private int $cantidad_horas;   // Cuántas horas tiene
        private int $curso;            // En qué curso se da
        private int $codigo_ciclo;     // A qué ciclo pertenece
        
        // Array para guardar los alumnos que están en este módulo
        private array $alumnos; 

        // Constructor: creamos un módulo con sus datos
        public function __construct(int $codigo_modulo = 0, 
                                    string $nombre = "", 
                                    int $cantidad_horas = 0, 
                                    int $curso = 0, 
                                    int $codigo_ciclo = 0 ) { 
            $this->codigo_modulo = $codigo_modulo; 
            $this->nombre = $nombre; 
            $this->cantidad_horas = $cantidad_horas; 
            $this->curso = $curso; 
            $this->codigo_ciclo = $codigo_ciclo; 
            
            // Inicializamos el array vacío
            $this->alumnos = []; 
        } 

        // Setters
        public function setCodigoModulo(int $codigo_modulo): void { $this->codigo_modulo = $codigo_modulo; } 
        public function setNombre(string $nombre): void { $this->nombre = $nombre; } 
        public function setCantidadHoras(int $cantidad_horas): void { $this->cantidad_horas = $cantidad_horas; } 
        public function setCurso(int $curso): void { $this->curso = $curso; } 
        public function setCodigoCiclo(int $codigo_ciclo): void { $this->codigo_ciclo = $codigo_ciclo; } 

        // Getters
        public function getCodigoModulo(): int { return $this->codigo_modulo; } 
        public function getNombre(): string { return $this->nombre; } 
        public function getCantidadHoras(): int { return $this->cantidad_horas; } 
        public function getCurso(): int { return $this->curso; } 
        public function getCodigoCiclo(): int { return $this->codigo_ciclo; } 

        /*
         * agregarAlumno(): igual que en Alumno, pero al revés
         * 
         * Cuando agregamos un alumno al módulo, también le decimos al alumno
         * que se agregue a sí mismo en su lista de módulos.
         * 
         * Esto es lo que hace la relación bidireccional: ambos se conocen.
         */
        public function agregarAlumno(Alumno $alumno): void { 
            // Verificamos que no esté ya en la lista
            if (!in_array($alumno, $this->alumnos, true)) { 
                // Agregamos el alumno a la lista del módulo
                $this->alumnos[] = $alumno; 

                // Y le decimos al alumno que también nos agregue a nosotros
                $alumno->agregarModulo($this); 
            } 
        } 

        // mostrarDetalle(): muestra la información del módulo
        public function mostrarDetalle(): void { 
            echo "Módulo: {$this->nombre} (Código: {$this->codigo_modulo})<br>"; 
            echo "Horas: {$this->cantidad_horas}, Curso: {$this->curso}, Ciclo: {$this->codigo_ciclo}<br>"; 
        } 

        // obtenerAlumnos(): devuelve la lista de alumnos
        public function obtenerAlumnos(): array { 
            return $this->alumnos; 
        } 

        // mostrarAlumnos(): recorre todos los alumnos y muestra su información
        public function mostrarAlumnos(): void { 
            echo "Alumnos matriculados en {$this->nombre}<br>"; 
            
            // Recorremos cada alumno
            foreach ($this->alumnos as $alumno) { 
                // Y mostramos su información
                $alumno->mostrarDetalle(); 
            } 
            echo "<br>"; 
        } 
    } 

    /*
     * Ahora vamos a probar todo esto
     * 
     * Vamos a crear algunos alumnos y módulos, y luego los relacionaremos
     */
    
    // Creamos dos alumnos
    $alumno1 = new Alumno("12345678A", 1001, "María", "López", "Pérez", "600111222", "maria@example.com"); 
    $alumno2 = new Alumno("98765432B", 1002, "Juan", "Martín", "García", "600333444", "juan@example.com"); 

    // Creamos dos módulos
    $mod1 = new Modulo(101, "Programación", 120, 1, 2001); 
    $mod2 = new Modulo(102, "Bases de Datos", 100, 1, 2001); 

    /*
     * Ahora relacionamos todo
     * 
     * Cuando llamamos a agregarModulo(), automáticamente se establece
     * la relación en ambas direcciones gracias a la bidireccionalidad
     */
    
    // María se matricula en Programación (esto también añade a María en la lista de alumnos de Programación)
    $alumno1->agregarModulo($mod1); 
    
    // María también se matricula en Bases de Datos
    $alumno1->agregarModulo($mod2); 
    
    // Juan se matricula en Programación
    $alumno2->agregarModulo($mod1); 

    // También podemos hacerlo al revés: desde el módulo agregar un alumno
    // Esto también funciona gracias a la bidireccionalidad
    $mod2->agregarAlumno($alumno2); 

    // Ahora mostramos todo para ver cómo quedó
    echo "ALUMNO 1 ". "<br>"; 
    $alumno1->mostrarDetalle(); 
    echo " ". "<br>"; 
    $alumno1->mostrarModulos(); 

    echo "ALUMNO 2 ". "<br>"; 
    $alumno2->mostrarDetalle(); 
    echo " ". "<br>"; 
    $alumno2->mostrarModulos(); 

    echo "MÓDULO 1: ". "<br>"; 
    $mod1->mostrarDetalle(); 
    echo "  ". "<br>"; 
    $mod1->mostrarAlumnos(); 

    echo "MÓDULO 2: ". "<br>"; 
    $mod2->mostrarDetalle(); 
    echo " ". "<br>"; 
    $mod2->mostrarAlumnos(); 
?>
