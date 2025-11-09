<?php 
    /*
     * Ejercicio 8: Composición
     * 
     * La composición es una relación muy fuerte entre objetos.
     * Es como decir "tiene" pero de forma que el objeto hijo pertenece al padre.
     * 
     * Ejemplo real: una biblioteca tiene libros. Si la biblioteca desaparece,
     * conceptualmente los libros también desaparecen (aunque físicamente sigan existiendo).
     * 
     * La biblioteca puede existir sin libros (vacía), pero los libros pertenecen a la biblioteca.
     */

    // Clase Libro: representa un libro que forma parte de una biblioteca
    class Libro { 
        
        // Datos del libro
        private int $codigo_libro;  // Código único
        private string $titulo;      // Título
        private string $autor;       // Autor

        // Constructor: creamos un libro con sus datos
        public function __construct(int $codigo_libro = 0, string $titulo = "", string $autor = "") { 
            $this->codigo_libro = $codigo_libro; 
            $this->titulo = $titulo; 
            $this->autor = $autor; 
        } 

        
        // Setters: métodos para cambiar los valores
        public function setCodigoLibro(int $codigo_libro): void { 
            $this->codigo_libro = $codigo_libro; 
        } 

        public function setTitulo(string $titulo): void { 
            $this->titulo = $titulo; 
        } 

        public function setAutor(string $autor): void { 
            $this->autor = $autor; 
        } 

        
        // Getters: métodos para leer los valores
        public function getCodigoLibro(): int { 
            return $this->codigo_libro; 
        } 

        public function getTitulo(): string { 
            return $this->titulo; 
        } 

        public function getAutor(): string { 
            return $this->autor; 
        } 

        // mostrarDetalle(): muestra la información del libro
        public function mostrarDetalle(): void { 
            echo "Libro: {$this->titulo} - Autor: {$this->autor} (Código: {$this->codigo_libro})<br>"; 
        } 
    } 

    // Clase Biblioteca: representa una biblioteca que contiene libros
    // 
    // En composición, la biblioteca "tiene" libros de forma que:
    // - La biblioteca puede estar vacía (sin libros)
    // - Pero los libros pertenecen a la biblioteca
    // - Si la biblioteca desaparece, conceptualmente los libros también
    class Biblioteca { 
        
        // Atributos públicos de la biblioteca (según el diagrama)
        public string $nombre;     // Nombre
        public string $direccion;  // Dirección
        public string $localidad;  // Localidad
        
        // Array para guardar los libros que tiene la biblioteca
        // Esto es la composición: los libros pertenecen a la biblioteca
        private array $libros; 

        // Constructor: creamos una biblioteca nueva
        public function __construct(string $nombre = "", string $direccion = "", string $localidad = "") { 
            $this->nombre = $nombre; 
            $this->direccion = $direccion; 
            $this->localidad = $localidad; 
            
            // Inicializamos el array vacío (la biblioteca puede estar sin libros)
            $this->libros = []; 
        } 

        // Setters
        public function setNombre(string $nombre): void { 
            $this->nombre = $nombre; 
        } 

        public function setDireccion(string $direccion): void { 
            $this->direccion = $direccion; 
        } 

        public function setLocalidad(string $localidad): void { 
            $this->localidad = $localidad; 
        } 

        // Getters
        public function getNombre(): string { 
            return $this->nombre; 
        } 

        public function getDireccion(): string { 
            return $this->direccion; 
        } 

        public function getLocalidad(): string { 
            return $this->localidad; 
        } 

        // mostrarDetalle(): muestra la información de la biblioteca
        public function mostrarDetalle(): void { 
            echo "Biblioteca: {$this->nombre}<br>"; 
            echo "Dirección: {$this->direccion}, {$this->localidad}<br>"; 
        } 

        // obtenerLibros(): devuelve la lista de libros
        // En un sistema real, esto consultaría una base de datos
        public function obtenerLibros(): array { 
            return $this->libros; 
        } 

        // agregarLibro(): añade un libro a la biblioteca
        public function agregarLibro(Libro $libro): void { 
            // Evitamos duplicados
            if (!in_array($libro, $this->libros, true)) { 
                // Agregamos el libro al array de la biblioteca
                $this->libros[] = $libro; 
            } 
        } 

        // mostrarLibros(): muestra todos los libros de la biblioteca
        public function mostrarLibros(): void { 
            echo "Libros en la biblioteca {$this->nombre}:<br>"; 
            
            // Verificamos si hay libros
            if (empty($this->libros)) { 
                echo "No hay libros registrados.<br>"; 
            } else { 
                // Recorremos todos los libros
                foreach ($this->libros as $libro) { 
                    // Mostramos cada libro
                    $libro->mostrarDetalle(); 
                } 
            } 
            echo "<br>"; 
        } 
    } 

    /*
     * Ahora vamos a probar todo esto
     * Creamos una biblioteca y algunos libros, y los relacionamos
     */
    
    // Creamos una biblioteca
    $biblioteca = new Biblioteca("Biblioteca Central", "Calle Principal 123", "Madrid"); 
    $biblioteca->mostrarDetalle(); 
    echo "<br>"; 

    // Creamos algunos libros
    $libro1 = new Libro(1, "El Quijote", "Miguel de Cervantes"); 
    $libro2 = new Libro(2, "Cien años de soledad", "Gabriel García Márquez"); 
    $libro3 = new Libro(3, "1984", "George Orwell"); 

    // Agregamos los libros a la biblioteca
    // Ahora los libros pertenecen a la biblioteca
    $biblioteca->agregarLibro($libro1); 
    $biblioteca->agregarLibro($libro2); 
    $biblioteca->agregarLibro($libro3); 

    // Mostramos todos los libros
    $biblioteca->mostrarLibros(); 

    // Probamos obtener la lista de libros
    $libros = $biblioteca->obtenerLibros(); 
    echo "Total de libros: " . count($libros) . "<br>"; 
?>
