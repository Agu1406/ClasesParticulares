// Importamos la clase base Disco
import Disco from "./disco.js";

/**
 * Clase Vinilo
 * Representa un disco de vinilo que hereda de la clase Disco
 * Incluye información sobre las revoluciones por minuto
 */

export default class Vinilo extends Disco {
  #_revolucionesPorMinuto;

  // Constantes estáticas privadas para los límites de revoluciones por minuto
  static #MIN_REVOLUCION = 33;
  static #MAX_REVOLUCION = 45;

  /**
   * Constructor de la clase Vinilo
   * @param {string} titulo - Título del disco
   * @param {string} artista - Nombre del artista
   * @param {number} revolucionesPorMinuto - Revoluciones por minuto (típicamente 33 o 45)
   */
  constructor(titulo, artista, revolucionesPorMinuto) {
    super(titulo, artista);
    this.revolucionesPorMinuto = revolucionesPorMinuto;
  }

  /***********
    SETTERS
  **********/

  set revolucionesPorMinuto(nuevasRPM) {
    // Validar que sea un número
    if (isNaN(nuevasRPM)) {
      throw "Las revoluciones por minuto deben ser un número";
    }
    // Validar que sea un número entero
    else if (!Number.isInteger(nuevasRPM)) {
      throw "Las revoluciones por minuto deben ser un número entero";
    }
    // Validar que esté dentro del rango permitido
    else if (
      nuevasRPM < Vinilo.#MIN_REVOLUCION ||
      nuevasRPM > Vinilo.#MAX_REVOLUCION
    ) {
      throw `Las revoluciones por minuto deben estar entre ${Vinilo.#MIN_REVOLUCION} y ${Vinilo.#MAX_REVOLUCION}`;
    }
    this.#_revolucionesPorMinuto = nuevasRPM;
  }

  /***********
    GETTERS
  **********/

  get revolucionesPorMinuto() {
    return this.#_revolucionesPorMinuto;
  }

  /***********
    RESTO METODOS
  **********/

  /**
   * Implementación específica del método obtenerSonido para vinilos
   * @returns {string} Descripción del sonido característico del vinilo
   */
  obtenerSonido() {
    return `Sonido cálido y analógico del vinilo a ${this.#_revolucionesPorMinuto} RPM`;
  }

  /**
   * Método toString
   * Retorna una representación en cadena de texto del vinilo
   * Reutiliza el toString del padre y agrega información específica del vinilo
   * @returns {string} Información del vinilo
   */
  toString() {
    let cadenaVinilo = super.toString();
    cadenaVinilo = cadenaVinilo.replace("Disco:", "Vinilo:");
    cadenaVinilo += ` - RPM: ${this.#_revolucionesPorMinuto}`;
    return cadenaVinilo;
  }
}
