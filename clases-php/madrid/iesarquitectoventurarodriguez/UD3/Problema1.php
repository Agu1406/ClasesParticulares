<?php 
    /*
     * Ejercicio 1: Nuestra primera clase - Persona
     * 
     * Aquí vamos a aprender lo básico de POO:
     * - Cómo crear una clase (es como un molde para crear objetos)
     * - Qué son los atributos (las características, como nombre, edad)
     * - Qué son los métodos (las acciones que puede hacer, como saludar)
     * - El constructor (se ejecuta cuando creamos un objeto)
     * - Atributos privados vs públicos (protección de datos)
     * - Getters y setters (métodos para leer y cambiar valores privados)
     * 
     * NOTA: Esta clase evoluciona en los ejercicios 2 y 4
     */

    // Aquí definimos la clase Persona
    // Piensa en una clase como un molde: con este molde podemos crear muchas personas
    class Persona { 
        
        // Estos son los atributos: las características que tiene cada persona
        // private significa que solo se puede acceder desde dentro de la clase
        // Es como poner un candado para proteger los datos
        private $nombre;  // El nombre de la persona
        
        private $edad;    // La edad
        
        // public significa que se puede acceder directamente desde fuera
        // Es como dejar algo sin candado, accesible para todos
        public $familia; // La familia (público, se puede ver y cambiar directamente)

        // Constructor: este método se ejecuta automáticamente cuando creamos una persona
        // Le pasamos los datos iniciales (nombre, edad, familia)
        public function __construct($nombre, $edad, $familia) { 
            // $this se refiere al objeto que estamos creando
            // Aquí guardamos los valores que nos pasan
            $this->nombre = $nombre;   // Guardamos el nombre
            $this->edad = $edad;       // Guardamos la edad
            $this->familia = $familia; // Guardamos la familia
        } 

        // Getter: método para leer el nombre (que es privado)
        // Como $nombre es privado, no podemos hacer $p->nombre directamente
        // Necesitamos este método para leerlo
        public function getNombre() { 
            return $this->nombre; 
        } 

        // Setter: método para cambiar la edad (que es privada)
        // Como $edad es privado, no podemos hacer $p->edad = 26 directamente
        // Necesitamos este método para cambiarla
        public function setEdad($edad) { 
            $this->edad = $edad; 
        } 

        // Método personalizado: saludar
        // Este método muestra un mensaje con la información de la persona
        public function saludar() { 
            // Mostramos un mensaje usando los valores que tiene la persona
            echo "Hola, soy {$this->nombre}, tengo {$this->edad} años y". 
                 " soy de la familia {$this->familia}."; 
        } 
    } 

    /*
     * Ahora vamos a probar nuestra clase
     * Vamos a crear una persona y ver cómo funciona
     */
    
    // Creamos una persona nueva
    // "new Persona()" crea el objeto y llama al constructor
    // Le pasamos: nombre="Ana", edad=25, familia="Espabilados"
    $p = new Persona("Ana", 25, "Espabilados"); 
    
    // Llamamos al método saludar para que se presente
    $p->saludar(); 
    echo " "."<br>"; 

    // Cambiamos la edad usando el setter
    // No podemos hacer $p->edad = 26 porque es privado
    // Tenemos que usar el método setEdad()
    $p->setEdad(26); 
    
    // Volvemos a saludar para ver el cambio
    $p->saludar(); 
    echo " "."<br>"; 

    // Como $familia es público, sí podemos acceder directamente
    // No necesitamos métodos para esto
    echo "La famila es: {$p -> familia}"."<br>"; 
    echo " "."<br>"; 
?>

