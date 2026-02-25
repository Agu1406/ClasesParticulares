// Importamos las clases necesarias para validación
import Disco from "./disco.js";
import CD from "./cd.js";

/**
 * Clase TocaDiscos
 * Representa un reproductor de discos de vinilo
 * Solo puede reproducir vinilos y discos base, NO acepta CDs
 */

export default class TocaDiscos {
  /**
   * Constructor de la clase TocaDiscos
   */
  constructor() {
    // No requiere propiedades iniciales
  }

  /***********
    RESTO METODOS
  **********/

  /**
   * Método para reproducir un disco
   * Muestra la información del disco y ejecuta su método obtenerSonido()
   * Solo acepta Vinilo o Disco base, NO acepta CDs
   * @param {Disco|Vinilo} disco - Objeto disco a reproducir (puede ser Disco base o Vinilo, NO CD)
   */
  reproducir(disco) {
    // Verificar que el parámetro sea un objeto Disco
    if (!(disco instanceof Disco)) {
      throw "El parámetro debe ser un objeto Disco válido";
    }

    // Verificar que NO sea un CD (los CDs deben usar ReproductorCDs)
    if (disco instanceof CD) {
      throw "Los CDs no se pueden reproducir en un TocaDiscos. Use ReproductorCDs para reproducir CDs.";
    }

    // Mostrar información del disco
    console.log("=== Reproduciendo disco ===");
    console.log(`Título: ${disco.titulo}`);
    console.log(`Artista: ${disco.artista}`);

    // Ejecutar el método obtenerSonido() del disco (polimorfismo)
    const sonido = disco.obtenerSonido();
    console.log(`Sonido: ${sonido}`);
    console.log("===========================\n");
  }
}
