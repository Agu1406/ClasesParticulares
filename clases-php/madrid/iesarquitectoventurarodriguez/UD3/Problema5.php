<?php 
    /*
     * Ejercicio 5: Clase Coche con métodos setCoche() y getCoche()
     * 
     * Este ejercicio también trabaja con la clase Coche (como el ejercicio 3),
     * pero con un enfoque diferente.
     * 
     * Aquí vamos a ver:
     * - Un método setCoche() que cambia todos los valores a la vez
     *   (en lugar de tener setMarca(), setModelo(), setAño() por separado)
     * - Un método getCoche() que devuelve un NUEVO objeto Coche con los mismos valores
     *   (esto es como hacer una copia del coche)
     * 
     * NOTA: El ejercicio 3 también trabaja con Coche pero con tipado fuerte
     *       y getters/setters individuales. Este ejercicio muestra otra forma
     *       de trabajar con la misma clase.
     */

    class Coche { 
        
        // Atributos privados del coche
        private $marca; 
        private $modelo; 
        private $año; 

        // Constructor: creamos un coche con sus datos iniciales
        public function __construct($marca, $modelo, $año) { 
            $this->marca = $marca; 
            $this->modelo = $modelo; 
            $this->año = $año; 
        } 

        /*
         * setCoche(): método para cambiar todos los valores del coche a la vez
         * 
         * En lugar de tener setMarca(), setModelo(), setAño() por separado,
         * tenemos un solo método que cambia todo de una vez.
         * 
         * Esto es útil cuando quieres cambiar varios valores a la vez.
         */
        public function setCoche($marca, $modelo, $año) { 
            $this->marca = $marca; 
            $this->modelo = $modelo; 
            $this->año = $año; 
        } 

        /*
         * getCoche(): devuelve un NUEVO objeto Coche con los mismos valores
         * 
         * Esto es como hacer una copia del coche actual.
         * Crea un nuevo objeto Coche con los mismos valores que tiene este coche.
         * 
         * Útil cuando quieres tener una copia independiente del coche.
         */
        public function getCoche() { 
            // Creamos un nuevo objeto Coche con los valores actuales
            return new Coche($this->marca, $this->modelo, $this->año); 
        } 

        /*
         * mostrarInfo(): muestra la información del coche
         */
        public function mostrarInfo() { 
            echo "Marca: " . $this->marca . "<br>"; 
            echo "Modelo: " . $this->modelo . "<br>"; 
            echo "Año: " . $this->año . "<br>"; 
        } 
    } 

    /*
     * Vamos a probar la clase
     */
    
    // Creamos un coche
    echo "Coche 1". "<br>"; 
    $coche1 = new Coche("Toyota", "Corolla", 2020); 
    $coche1->mostrarInfo(); 

    echo "<hr>"; 

    // Cambiamos todos los valores del coche usando setCoche()
    echo "Coche 1 modificado". "<br>"; 
    $coche1->setCoche("Ford", "Focus", 2022); 
    $coche1->mostrarInfo(); 

    echo "<hr>"; 

    /*
     * Obtenemos un nuevo objeto Coche a partir de getCoche()
     * 
     * Esto crea un coche nuevo (coche2) con los mismos valores que coche1.
     * Son dos objetos diferentes, así que si cambiamos uno, el otro no se afecta.
     */
    echo "Coche 2 (copia del coche 1)". "<br>"; 
    $coche2 = $coche1->getCoche(); 
    $coche2->mostrarInfo(); 
    
    echo "<hr>"; 
    
    // Demostración: cambiamos el coche2 y vemos que coche1 no se afecta
    echo "Cambiamos el coche 2 a otro modelo:<br>"; 
    $coche2->setCoche("BMW", "Serie 3", 2023); 
    
    echo "Coche 1 (no cambió):<br>"; 
    $coche1->mostrarInfo(); 
    
    echo "Coche 2 (sí cambió):<br>"; 
    $coche2->mostrarInfo(); 
?>

