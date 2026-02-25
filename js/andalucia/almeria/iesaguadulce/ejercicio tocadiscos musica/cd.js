// Importamos la clase base Disco
import Disco from "./disco.js";

/**
 * Clase CD
 * Representa un disco compacto (CD) que hereda de la clase Disco
 */

export default class CD extends Disco {
  /**
   * Constructor de la clase CD
   * @param {string} titulo - Título del disco
   * @param {string} artista - Nombre del artista
   */
  constructor(titulo, artista) {
    super(titulo, artista);
  }

  /***********
    RESTO METODOS
  **********/

  /**
   * Implementación específica del método obtenerSonido para CDs
   * @returns {string} Descripción del sonido característico del CD
   */
  obtenerSonido() {
    return "Sonido digital y cristalino del CD";
  }

  /**
   * Método toString
   * Retorna una representación en cadena de texto del CD
   * Reutiliza el toString del padre y adapta el formato
   * @returns {string} Información del CD
   */
  toString() {
    let cadenaCD = super.toString();
    cadenaCD = cadenaCD.replace("Disco:", "CD:");
    return cadenaCD;
  }
}
