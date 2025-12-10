<?php 
    /*
     * Ejercicio 3: Clase Coche con tipado fuerte
     * 
     * Este ejercicio nos enseña:
     * - Tipado fuerte: especificar el tipo de dato en parámetros y retornos
     * - Tipos básicos: string (texto), int (número entero)
     * - Tipo void: cuando un método no devuelve nada
     * - Getters y Setters completos para todos los atributos
     * - Constructor con valores por defecto
     * 
     * NOTA: El ejercicio 5 también trabaja con la clase Coche pero con
     *       un enfoque diferente (setCoche() y getCoche()).
     */

    // Definimos la clase Coche
    class Coche { 
        
        // Atributos con tipado fuerte
        // En PHP 7+ podemos especificar el tipo de dato que almacenará cada atributo
        // Esto ayuda a evitar errores y hace el código más claro
        private string $marca;  // string = texto (ej: "Toyota", "Ford")
        private string $modelo; // string = texto (ej: "Corolla", "Focus")
        private int $año;       // int = número entero (ej: 2023, 2022)

        // Constructor con tipado y valores por defecto
        // string $marca = el parámetro debe ser texto
        // int $año = el parámetro debe ser un número entero
        // = "" = valores por defecto (si no pasamos nada, será cadena vacía o 0)
        public function __construct(string $marca = "", string $modelo = "", int $año = 0) { 
            // Asignamos los valores recibidos a los atributos
            $this->marca = $marca; 
            $this->modelo = $modelo; 
            $this->año = $año; 
        } 

        // Setters: métodos para cambiar los valores
        // : void significa que el método no devuelve nada
        public function setMarca(string $marca): void { 
            $this->marca = $marca; 
        } 

        // Setter para cambiar el modelo
        public function setModelo(string $modelo): void { 
            $this->modelo = $modelo; 
        } 

        // Setter para cambiar el año
        public function setAño(int $año): void { 
            $this->año = $año; 
        } 

        // Getters: métodos para leer los valores
        // El tipo después de : indica qué tipo de dato devuelve
        public function getMarca(): string { 
            return $this->marca; 
        } 

        // Getter para leer el modelo (devuelve un string)
        public function getModelo(): string { 
            return $this->modelo; 
        } 

        // Getter para leer el año (devuelve un int)
        public function getAño(): int { 
            return $this->año; 
        } 

        // mostrarInfo(): muestra la información del coche
        // : void significa que no devuelve nada, solo muestra información
        public function mostrarInfo(): void { 
            // Mostramos la información formateada
            echo "Coche: {$this->marca} {$this->modelo} ({$this->año})<br>"; 
        } 
    } 

    /*
     * Ahora vamos a probar nuestra clase
     */
    
    // Creamos un coche con todos los datos desde el principio
    $coche1 = new Coche("Toyota", "Corolla", 2023); 
    $coche1->mostrarInfo(); 
    echo "<br>"; 

    // Creamos un coche vacío y lo llenamos después
    $coche2 = new Coche(); 
    
    // Llenamos los datos usando los setters
    $coche2->setMarca("Ford"); 
    $coche2->setModelo("Focus"); 
    $coche2->setAño(2022); 
    
    $coche2->mostrarInfo(); 
    echo "<br>"; 

    // Probamos los getters para leer información individual
    echo "Marca del coche 1: " . $coche1->getMarca() . "<br>"; 
    echo "Modelo del coche 1: " . $coche1->getModelo() . "<br>"; 
    echo "Año del coche 1: " . $coche1->getAño() . "<br>"; 
?>

