package madrid.iescalderonbarca.g_ejerciciosConocidos;

import java.util.Scanner;

/**
 * Práctica 3: Generador de contraseñas - RESUELTO
 * 
 * Programa que genera contraseñas débiles o fuertes a petición del usuario.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Practica3_GeneradorContrasenas_RESUELTO {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        
        // Arrays definidos en main según el enunciado
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
                         'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                         'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                         'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
        char[] numeros = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        
        char[] caracteresEspeciales = {'*', '+', '-', '/', '#', '$', '%', '&', '_', '!'};
        
        do {
            mostrarMenu();
            System.out.print("Teclee su opción: ");
            opcion = teclado.nextInt();
            System.out.println();
            
            switch (opcion) {
                case 1:
                    String contrasenaDebil = generarContrasenaDebil(letras, numeros);
                    System.out.println("La contraseña es: " + contrasenaDebil);
                    System.out.println();
                    break;
                    
                case 2:
                    String contrasenaFuerte = generarContrasenaFuerte(letras, numeros, caracteresEspeciales);
                    System.out.println("La contraseña es: " + contrasenaFuerte);
                    System.out.println();
                    break;
                    
                case 3:
                    System.out.println("Gracias por usar el generador de contraseñas.");
                    System.out.println("Programa terminado");
                    break;
                    
                default:
                    System.out.println("Opción incorrecta, vuelva a intentarlo");
                    System.out.println();
                    break;
            }
        } while (opcion != 3);
        
        teclado.close();
    }
    
    /**
     * Muestra el menú del programa
     */
    private static void mostrarMenu() {
        System.out.println("MENÚ");
        System.out.println("1. Generar e imprimir contraseña débil.");
        System.out.println("2. Generar e imprimir contraseña fuerte.");
        System.out.println("3. Salir.");
        System.out.println();
    }
    
    /**
     * Genera una contraseña débil: 5 letras + 3 números
     * Tanto el tipo de carácter como el elemento se obtienen de forma aleatoria
     * 
     * @param letras Array de letras mayúsculas y minúsculas
     * @param numeros Array de números
     * @return Contraseña débil generada
     */
    private static String generarContrasenaDebil(char[] letras, char[] numeros) {
        String contrasena = "";
        int letrasAgregadas = 0;
        int numerosAgregados = 0;
        
        // Generamos 8 caracteres en total (5 letras + 3 números)
        while (letrasAgregadas < 5 || numerosAgregados < 3) {
            // Decidimos aleatoriamente si agregamos letra o número
            int tipoCaracter = (int) (Math.random() * 2); // 0 = letra, 1 = número
            
            if (tipoCaracter == 0 && letrasAgregadas < 5) {
                // Agregamos una letra aleatoria
                int indiceAleatorio = (int) (Math.random() * letras.length);
                contrasena = contrasena + letras[indiceAleatorio];
                letrasAgregadas++;
            } else if (tipoCaracter == 1 && numerosAgregados < 3) {
                // Agregamos un número aleatorio
                int indiceAleatorio = (int) (Math.random() * numeros.length);
                contrasena = contrasena + numeros[indiceAleatorio];
                numerosAgregados++;
            }
        }
        
        return contrasena;
    }
    
    /**
     * Genera una contraseña fuerte: 6 letras + 4 números + 3 caracteres especiales
     * Restricciones:
     * - Primera posición: carácter especial
     * - Primera letra: mayúscula
     * - Resto de letras: minúsculas
     * - No se puede repetir ningún carácter
     * 
     * @param letras Array de letras mayúsculas y minúsculas
     * @param numeros Array de números
     * @param caracteresEspeciales Array de caracteres especiales
     * @return Contraseña fuerte generada
     */
    private static String generarContrasenaFuerte(char[] letras, char[] numeros, char[] caracteresEspeciales) {
        String contrasena = "";
        int letrasAgregadas = 0;
        int numerosAgregados = 0;
        int especialesAgregados = 0;
        boolean primeraLetra = true; // Para controlar que la primera letra sea mayúscula
        
        // Primera posición debe ser un carácter especial
        int indiceAleatorio = (int) (Math.random() * caracteresEspeciales.length);
        contrasena = contrasena + caracteresEspeciales[indiceAleatorio];
        especialesAgregados++;
        
        // Generamos el resto de caracteres (6 letras + 4 números + 2 especiales más)
        while (letrasAgregadas < 6 || numerosAgregados < 4 || especialesAgregados < 3) {
            // Decidimos aleatoriamente qué tipo de carácter agregar
            int tipoCaracter = (int) (Math.random() * 3); // 0 = letra, 1 = número, 2 = especial
            
            if (tipoCaracter == 0 && letrasAgregadas < 6) {
                // Agregamos una letra
                char letra;
                if (primeraLetra) {
                    // Primera letra debe ser mayúscula (índices 0-25)
                    indiceAleatorio = (int) (Math.random() * 26);
                    letra = letras[indiceAleatorio];
                    primeraLetra = false;
                } else {
                    // Resto de letras deben ser minúsculas (índices 26-51)
                    indiceAleatorio = (int) (Math.random() * 26) + 26;
                    letra = letras[indiceAleatorio];
                }
                
                // Verificamos que no se repita el carácter
                if (!contieneCaracter(contrasena, letra)) {
                    contrasena = contrasena + letra;
                    letrasAgregadas++;
                }
                
            } else if (tipoCaracter == 1 && numerosAgregados < 4) {
                // Agregamos un número
                indiceAleatorio = (int) (Math.random() * numeros.length);
                char numero = numeros[indiceAleatorio];
                
                // Verificamos que no se repita el carácter
                if (!contieneCaracter(contrasena, numero)) {
                    contrasena = contrasena + numero;
                    numerosAgregados++;
                }
                
            } else if (tipoCaracter == 2 && especialesAgregados < 3) {
                // Agregamos un carácter especial
                indiceAleatorio = (int) (Math.random() * caracteresEspeciales.length);
                char especial = caracteresEspeciales[indiceAleatorio];
                
                // Verificamos que no se repita el carácter
                if (!contieneCaracter(contrasena, especial)) {
                    contrasena = contrasena + especial;
                    especialesAgregados++;
                }
            }
        }
        
        return contrasena;
    }
    
    /**
     * Verifica si un carácter ya está presente en la contraseña
     * 
     * @param contrasena Contraseña generada hasta el momento
     * @param caracter Carácter a verificar
     * @return true si el carácter ya está en la contraseña, false en caso contrario
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
