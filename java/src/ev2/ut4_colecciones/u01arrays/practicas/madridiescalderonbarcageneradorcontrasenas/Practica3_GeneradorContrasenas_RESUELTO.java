package ev2.ut4_colecciones.u01arrays.practicas.madridiescalderonbarcageneradorcontrasenas;

import java.util.Scanner;

/**
 * Practica 3: Generador de contrasenas - RESUELTO
 * 
 * Programa que genera contrasenas debiles o fuertes a peticion del usuario.
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Practica3_GeneradorContrasenas_RESUELTO {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        
        // Arrays definidos en main segun el enunciado
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
                         'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                         'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                         'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
        char[] numeros = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        
        char[] caracteresEspeciales = {'*', '+', '-', '/', '#', '$', '%', '&', '_', '!'};
        
        do {
            mostrarMenu();
            System.out.print("Teclee su opcion: ");
            opcion = teclado.nextInt();
            System.out.println();
            
            switch (opcion) {
                case 1:
                    String contrasenaDebil = generarContrasenaDebil(letras, numeros);
                    System.out.println("La contrasena es: " + contrasenaDebil);
                    System.out.println();
                    break;
                    
                case 2:
                    String contrasenaFuerte = generarContrasenaFuerte(letras, numeros, caracteresEspeciales);
                    System.out.println("La contrasena es: " + contrasenaFuerte);
                    System.out.println();
                    break;
                    
                case 3:
                    System.out.println("Gracias por usar el generador de contrasenas.");
                    System.out.println("Programa terminado");
                    break;
                    
                default:
                    System.out.println("Opcion incorrecta, vuelva a intentarlo");
                    System.out.println();
                    break;
            }
        } while (opcion != 3);
        
        teclado.close();
    }
    
    /**
     * Muestra el menu del programa
     */
    private static void mostrarMenu() {
        System.out.println("MENU");
        System.out.println("1. Generar e imprimir contrasena debil.");
        System.out.println("2. Generar e imprimir contrasena fuerte.");
        System.out.println("3. Salir.");
        System.out.println();
    }
    
    /**
     * Genera una contrasena debil: 5 letras + 3 numeros
     * Tanto el tipo de caracter como el elemento se obtienen de forma aleatoria
     * 
     * @param letras Array de letras mayusculas y minusculas
     * @param numeros Array de numeros
     * @return Contrasena debil generada
     */
    private static String generarContrasenaDebil(char[] letras, char[] numeros) {
        String contrasena = "";
        int letrasAgregadas = 0;
        int numerosAgregados = 0;
        
        // Generamos 8 caracteres en total (5 letras + 3 numeros)
        while (letrasAgregadas < 5 || numerosAgregados < 3) {
            // Decidimos aleatoriamente si agregamos letra o numero
            int tipoCaracter = (int) (Math.random() * 2); // 0 = letra, 1 = numero
            
            if (tipoCaracter == 0 && letrasAgregadas < 5) {
                // Agregamos una letra aleatoria
                int indiceAleatorio = (int) (Math.random() * letras.length);
                contrasena = contrasena + letras[indiceAleatorio];
                letrasAgregadas++;
            } else if (tipoCaracter == 1 && numerosAgregados < 3) {
                // Agregamos un numero aleatorio
                int indiceAleatorio = (int) (Math.random() * numeros.length);
                contrasena = contrasena + numeros[indiceAleatorio];
                numerosAgregados++;
            }
        }
        
        return contrasena;
    }
    
    /**
     * Genera una contrasena fuerte: 6 letras + 4 numeros + 3 caracteres especiales
     * Restricciones:
     * - Primera posicion: caracter especial
     * - Primera letra: mayuscula
     * - Resto de letras: minusculas
     * - No se puede repetir ningun caracter
     * 
     * @param letras Array de letras mayusculas y minusculas
     * @param numeros Array de numeros
     * @param caracteresEspeciales Array de caracteres especiales
     * @return Contrasena fuerte generada
     */
    private static String generarContrasenaFuerte(char[] letras, char[] numeros, char[] caracteresEspeciales) {
        String contrasena = "";
        int letrasAgregadas = 0;
        int numerosAgregados = 0;
        int especialesAgregados = 0;
        boolean primeraLetra = true; // Para controlar que la primera letra sea mayuscula
        
        // Primera posicion debe ser un caracter especial
        int indiceAleatorio = (int) (Math.random() * caracteresEspeciales.length);
        contrasena = contrasena + caracteresEspeciales[indiceAleatorio];
        especialesAgregados++;
        
        // Generamos el resto de caracteres (6 letras + 4 numeros + 2 especiales mas)
        while (letrasAgregadas < 6 || numerosAgregados < 4 || especialesAgregados < 3) {
            // Decidimos aleatoriamente que tipo de caracter agregar
            int tipoCaracter = (int) (Math.random() * 3); // 0 = letra, 1 = numero, 2 = especial
            
            if (tipoCaracter == 0 && letrasAgregadas < 6) {
                // Agregamos una letra
                char letra;
                if (primeraLetra) {
                    // Primera letra debe ser mayuscula (indices 0-25)
                    indiceAleatorio = (int) (Math.random() * 26);
                    letra = letras[indiceAleatorio];
                    primeraLetra = false;
                } else {
                    // Resto de letras deben ser minusculas (indices 26-51)
                    indiceAleatorio = (int) (Math.random() * 26) + 26;
                    letra = letras[indiceAleatorio];
                }
                
                // Verificamos que no se repita el caracter
                if (!contieneCaracter(contrasena, letra)) {
                    contrasena = contrasena + letra;
                    letrasAgregadas++;
                }
                
            } else if (tipoCaracter == 1 && numerosAgregados < 4) {
                // Agregamos un numero
                indiceAleatorio = (int) (Math.random() * numeros.length);
                char numero = numeros[indiceAleatorio];
                
                // Verificamos que no se repita el caracter
                if (!contieneCaracter(contrasena, numero)) {
                    contrasena = contrasena + numero;
                    numerosAgregados++;
                }
                
            } else if (tipoCaracter == 2 && especialesAgregados < 3) {
                // Agregamos un caracter especial
                indiceAleatorio = (int) (Math.random() * caracteresEspeciales.length);
                char especial = caracteresEspeciales[indiceAleatorio];
                
                // Verificamos que no se repita el caracter
                if (!contieneCaracter(contrasena, especial)) {
                    contrasena = contrasena + especial;
                    especialesAgregados++;
                }
            }
        }
        
        return contrasena;
    }
    
    /**
     * Verifica si un caracter ya esta presente en la contrasena
     * 
     * @param contrasena Contrasena generada hasta el momento
     * @param caracter Caracter a verificar
     * @return true si el caracter ya esta en la contrasena, false en caso contrario
     */
    private static boolean contieneCaracter(String contrasena, char caracter) {
        for (int i = 0; i < contrasena.length(); i++) {
            if (contrasena.charAt(i) == caracter) {
                return true;
            }
        }
        return false;
    }
}
