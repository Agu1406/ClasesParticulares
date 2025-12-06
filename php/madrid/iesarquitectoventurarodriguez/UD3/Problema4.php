<?php 
    /*
     * Ejercicio 4: Evolución de la clase Persona (del ejercicio 1 y 2)
     * 
     * Este ejercicio mejora la clase Persona que vimos en los ejercicios anteriores.
     * Aquí vamos a aprender otra forma de hacer sobrecarga de constructores.
     * 
     * En lugar de usar valores por defecto (como en el ejercicio 2), vamos a usar
     * funciones especiales que nos dicen cuántos argumentos se pasaron realmente.
     * 
     * También veremos el destructor: un método que se ejecuta cuando el objeto
     * se destruye (al final del script o cuando ya no se usa).
     * 
     * Evolución:
     * - Ejercicio 1: Persona básica con constructor simple
     * - Ejercicio 2: Persona con sobrecarga usando valores por defecto
     * - Ejercicio 4: Persona con sobrecarga usando func_num_args() + destructor
     */

    class Persona { 
        
        // Atributos de la persona
        private $nombre; 
        private $edad; 
        public $familia; 

        /*
         * Constructor con sobrecarga usando func_num_args()
         * 
         * func_num_args() nos dice cuántos argumentos se pasaron
         * func_get_args() nos devuelve un array con todos los argumentos
         * 
         * Dependiendo de cuántos argumentos recibamos, asignamos valores diferentes:
         * - 0 argumentos: todo por defecto
         * - 1 argumento: solo el nombre
         * - 2 argumentos: nombre y edad
         * - 3 argumentos: nombre, edad y familia
         */
        public function __construct($nombre=null, $edad=null, $familia=null) { 
            // Obtenemos cuántos argumentos se pasaron realmente
            $numArgs = func_num_args(); 
            
            // Obtenemos un array con todos los argumentos que se pasaron
            $args = func_get_args(); 

            // Si solo pasaron 1 argumento (el nombre)
            if ($numArgs == 1) { 
                $this->nombre = $args[0]; 
                $this->edad = 0; 
                $this->familia = "Sin familia"; 
                
            // Si pasaron 2 argumentos (nombre y edad)
            } elseif ($numArgs == 2) { 
                $this->nombre = $args[0]; 
                $this->edad = $args[1]; 
                $this->familia = "Sin familia"; 
                
            // Si pasaron 3 argumentos (nombre, edad y familia)
            } elseif ($numArgs == 3) { 
                $this->nombre = $args[0]; 
                $this->edad = $args[1]; 
                $this->familia = $args[2]; 
                
            // Si no pasaron ningún argumento
            } else { 
                $this->nombre = "Sin nombre"; 
                $this->edad = 0; 
                $this->familia = "Sin familia"; 
            }             
        } 
         
        // Setters
        public function setNombre($nombre) { 
            $this->nombre = $nombre; 
        } 

        public function getNombre() { 
            return $this->nombre; 
        } 

        public function setEdad($edad) { 
            $this->edad = $edad; 
        } 

        public function getEdad() { 
            return $this->edad; 
        } 

        // Método saludar
        public function saludar() { 
            echo "Hola, soy {$this->nombre}, tengo {$this->edad} años y". 
                 " soy de la familia {$this->familia}."; 
        } 

        /*
         * Destructor: se ejecuta automáticamente cuando el objeto se destruye
         * 
         * Se ejecuta cuando:
         * - El script termina
         * - Ya no hay referencias al objeto
         * - Se llama explícitamente unset()
         * 
         * Es útil para limpiar recursos o mostrar mensajes de despedida
         */
        public function __destruct() { 
            echo "El objeto correspondiente a la persona {$this->nombre} ha sido destruido"."<br>"; 
        } 
    } 

    /*
     * Ahora vamos a probar todas las formas de crear una persona
     */
    
    // Prueba 1: Crear persona con todos los valores
    echo "Persona 1 (con todos los valores):<br>"; 
    $p1 = new Persona("Ana", 25, "Espabilados"); 
    $p1->saludar(); 
    echo " "."<br>"; 

    $p1->setEdad(26); 
    $p1->saludar(); 
    echo " "."<br>"; 

    echo "La famila es: {$p1 -> familia}"."<br>"; 
    echo " "."<br>"; 

    // Prueba 2: Crear persona sin valores
    echo "Persona 2 (sin valores):<br>"; 
    $p2 = new Persona(); 
    $p2->saludar(); 
    echo " "."<br>"; 

    $p2->setNombre("Antonio"); 
    $p2->setEdad(30); 
    $p2->familia = "Normales"; 
    $p2->saludar(); 
    echo " "."<br>"; 

    echo "La famila es: {$p2 -> familia}"."<br>"; 

    // Prueba 3: Crear persona solo con el nombre
    echo "Persona 3 (solo con nombre):<br>"; 
    $p3 = new Persona("María"); 
    $p3->saludar(); 
    echo " "."<br>"; 

    $p3->setEdad(30); 
    $p3->familia = "Parcial"; 
    $p3->saludar(); 
    echo " "."<br>"; 

    echo "La famila es: {$p3 -> familia}"."<br>"; 

    echo "Fin del script "."<br>"; 
    
    /*
     * Cuando el script termina, se ejecutarán los destructores
     * de todas las personas en orden inverso a como se crearon
     * (primero se destruye p3, luego p2, luego p1)
     */
?>

