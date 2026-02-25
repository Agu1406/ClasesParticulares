// Importamos la clase CD
import CD from "./cd.js";

/**
 * Clase ReproductorCDs
 * Representa un reproductor específico para discos compactos (CDs)
 */

export default class ReproductorCDs {
  /**
   * Constructor de la clase ReproductorCDs
   */
  constructor() {
    // No requiere propiedades iniciales
  }

  /***********
    RESTO METODOS
  **********/

  /**
   * Método para reproducir un CD
   * Muestra la información del CD y ejecuta su método obtenerSonido()
   * @param {CD} cd - Objeto CD a reproducir
   */
  reproducir(cd) {
    // Verificar que el parámetro sea un objeto CD
    if (!(cd instanceof CD)) {
      throw "El parámetro debe ser un objeto CD válido";
    }

    // Mostrar información del CD
    console.log("=== Reproduciendo CD ===");
    console.log(`Título: ${cd.titulo}`);
    console.log(`Artista: ${cd.artista}`);

    // Ejecutar el método obtenerSonido() del CD
    const sonido = cd.obtenerSonido();
    console.log(`Sonido: ${sonido}`);
    console.log("========================\n");
  }
}
