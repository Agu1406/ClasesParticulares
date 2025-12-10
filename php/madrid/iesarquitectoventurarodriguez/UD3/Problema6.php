<?php 
    /*
     * Ejercicio 6: Atributos estáticos (static)
     * 
     * Los atributos estáticos son especiales porque:
     * - Pertenecen a la CLASE, no a cada objeto
     * - Todos los objetos comparten el mismo valor
     * - Se acceden con el nombre de la clase, no con $this
     * 
     * En este ejercicio, usamos un contador estático para saber
     * cuántas cuentas bancarias se han creado en total.
     */

    class CuentaBancaria { 
        
        // Atributo de instancia: cada cuenta tiene su propio saldo
        private $saldo; 
        
        /*
         * Atributo estático: es compartido por TODAS las cuentas
         * 
         * static significa que este valor es el mismo para todas las cuentas.
         * Si creamos 3 cuentas, todas comparten el mismo $numCuentas.
         * 
         * Lo inicializamos en 0 porque al principio no hay cuentas.
         */
        private static $numCuentas = 0; 

        /*
         * Constructor: crea una nueva cuenta con un saldo inicial
         * 
         * Cada vez que creamos una cuenta, incrementamos el contador estático.
         * Como es estático, todas las cuentas comparten este contador.
         */
        public function __construct($saldoInicial) { 
            // Asignamos el saldo inicial a esta cuenta
            $this->saldo = $saldoInicial; 
            
            // Incrementamos el contador estático
            // self:: se usa para acceder a atributos y métodos estáticos
            self::$numCuentas++; 
        } 

        /*
         * depositar(): añade dinero a la cuenta
         */
        public function depositar($cantidad) { 
            $this->saldo += $cantidad; 
        } 

        /*
         * retirar(): quita dinero de la cuenta
         * 
         * Verificamos que no nos quedemos con saldo negativo.
         * Si intentamos retirar más de lo que tenemos, dejamos el saldo en 0.
         */
        public function retirar($cantidad) { 
            // Si tenemos suficiente dinero
            if (($this->saldo - $cantidad) >= 0){ 
                $this->saldo -= $cantidad; 
            } else { 
                // Si no tenemos suficiente, dejamos el saldo en 0
                $this->saldo = 0; 
            } 
        } 

        /*
         * getSaldo(): devuelve el saldo de esta cuenta
         */
        public function getSaldo() { 
            return $this->saldo; 
        } 

        /*
         * getNumCuentas(): método estático para obtener el número total de cuentas
         * 
         * Es estático porque el número de cuentas es algo de la clase,
         * no de una cuenta específica.
         * 
         * Se llama así: CuentaBancaria::getNumCuentas()
         * No necesitas tener un objeto para llamarlo.
         */
        public static function getNumCuentas() { 
            // self:: se usa para acceder a atributos estáticos
            return self::$numCuentas; 
        } 
    } 

    /*
     * Vamos a probar la clase
     * 
     * Observa cómo el contador estático va aumentando cada vez
     * que creamos una nueva cuenta.
     */
    
    // Al principio no hay cuentas
    echo "Número de cuentas: " . CuentaBancaria::getNumCuentas()."<br>"; 

    // Creamos la primera cuenta con 100 euros
    $c1 = new CuentaBancaria(100); 
    echo "Saldo de la cuenta 1: " . $c1->getSaldo(). "<br>"; 
    echo "Número de cuentas: " . CuentaBancaria::getNumCuentas()."<br>"; 

    // Creamos la segunda cuenta con 200 euros
    $c2 = new CuentaBancaria(200); 
    echo "Saldo de la cuenta 2: " . $c2->getSaldo(). "<br>"; 
    echo "Número de cuentas: " . CuentaBancaria::getNumCuentas()."<br>"; 

    // Creamos la tercera cuenta con 300 euros
    $c3 = new CuentaBancaria(300); 
    echo "Saldo de la cuenta 3: " . $c3->getSaldo(). "<br>"; 
    echo "Número de cuentas: " . CuentaBancaria::getNumCuentas()."<br>"; 

    echo "<hr>"; 
    
    /*
     * Probamos las operaciones de depósito y retiro
     */
    echo "Operaciones con la cuenta 1:<br>"; 
    echo "Saldo inicial: " . $c1->getSaldo() . "<br>"; 
    
    $c1->depositar(50); 
    echo "Después de depositar 50: " . $c1->getSaldo() . "<br>"; 
    
    $c1->retirar(30); 
    echo "Después de retirar 30: " . $c1->getSaldo() . "<br>"; 
    
    // Intentamos retirar más de lo que tenemos
    $c1->retirar(200); 
    echo "Después de intentar retirar 200 (solo tenía " . ($c1->getSaldo() + 200) . "): " . $c1->getSaldo() . "<br>"; 
?>

