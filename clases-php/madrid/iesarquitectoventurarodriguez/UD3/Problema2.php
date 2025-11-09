<?php 
    /*
     * Ejercicio 2: Evolución de la clase Persona (del ejercicio 1)
     * 
     * Este ejercicio mejora la clase Persona que vimos en el ejercicio 1.
     * Aquí vamos a aprender:
     * - Cómo hacer que un constructor sea opcional (sobrecarga)
     * - Valores por defecto en los parámetros
     * - Crear objetos con o sin valores iniciales
     * - Getters y Setters completos para todos los atributos
     * 
     * Evolución:
     * - Ejercicio 1: Persona básica con constructor simple
     * - Ejercicio 2: Persona con sobrecarga usando valores por defecto (este ejercicio)
     * - Ejercicio 4: Persona con sobrecarga usando func_num_args() + destructor
     */

    // Definimos la clase Persona (mejorada desde el ejercicio 1)
    class Persona { 
        
        // Atributos: iguales que en el ejercicio 1
        private $nombre;   // Nombre de la persona
        private $edad;     // Edad de la persona
        public $familia;   // Familia de la persona (público, accesible directamente)

        // Constructor con valores por defecto (sobrecarga)
        // 
        // En PHP no podemos tener múltiples constructores como en otros lenguajes,
        // pero podemos simularlo usando valores por defecto (null).
        // 
        // Si no pasamos valores, todos serán null.
        // Si pasamos valores, se usarán esos valores.
        // 
        // Esto nos permite crear objetos de dos formas:
        // 1. new Persona("Ana", 25, "Espabilados") - con valores
        // 2. new Persona() - sin valores (todos serán null)
        public function __construct($nombre=null, $edad=null, $familia=null) { 
            // Asignamos los valores recibidos (pueden ser null si no se pasaron)
            $this->nombre = $nombre; 
            $this->edad = $edad; 
            $this->familia = $familia; 
        } 
         
        // Setters: métodos para cambiar los valores después de crear el objeto
        public function setNombre($nombre) { 
            $this->nombre = $nombre; 
        } 

        // Getters: métodos para leer los valores (como son privados, necesitamos estos métodos)
        public function getNombre() { 
            return $this->nombre; 
        } 

        public function setEdad($edad) { 
            $this->edad = $edad; 
        } 

        public function getEdad() { 
            return $this->edad; 
        } 

        // Método saludar: muestra la información de la persona
        public function saludar() { 
            echo "Hola, soy {$this->nombre}, tengo {$this->edad} años y". 
                 " soy de la familia {$this->familia}."; 
        } 
    } 

    /*
     * Ahora vamos a probar nuestra clase mejorada
     */
    
    // Prueba 1: Crear persona con todos los valores
    // Esto es igual que en el ejercicio 1
    $p1 = new Persona("Ana", 25, "Espabilados"); 
    
    $p1->saludar(); 
    echo " "."<br>"; 

    $p1->setEdad(26); 
    $p1->saludar(); 
    echo " "."<br>"; 

    echo "La famila es: {$p1 -> familia}"."<br>"; 
    echo " "."<br>"; 

    // Prueba 2: Crear persona sin valores
    // Esta es la diferencia con el ejercicio 1: ahora podemos crear un objeto vacío
    $p2 = new Persona(); 
    
    // Si intentamos saludar ahora, veremos valores vacíos/null
    $p2->saludar(); 
    echo " "."<br>"; 

    // Ahora llenamos los datos usando los setters
    $p2->setNombre("Antonio"); 
    $p2->setEdad(30); 
    $p2->familia = "Normales"; 
    
    // Ahora sí tiene todos los datos, saludamos de nuevo
    $p2->saludar(); 
?>
