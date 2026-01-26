/**
 * Clase Disco
 * Clase base que representa un disco musical
 */

export default class Disco {
  #_titulo;
  #_artista;

  /**
   * Constructor de la clase Disco
   * @param {string} titulo - Título del disco
   * @param {string} artista - Nombre del artista
   */
  constructor(titulo, artista) {
    this.titulo = titulo;
    this.artista = artista;
  }

  /***********
    SETTERS
  **********/

  set titulo(nuevoTitulo) {
    if (typeof nuevoTitulo !== "string" || nuevoTitulo.trim() === "") {
      throw "El título debe ser un string y no debe estar vacío";
    }
    this.#_titulo = nuevoTitulo;
  }

  set artista(nuevoArtista) {
    if (typeof nuevoArtista !== "string" || nuevoArtista.trim() === "") {
      throw "El artista debe ser un string y no debe estar vacío";
    }
    this.#_artista = nuevoArtista;
  }

  /***********
    GETTERS
  **********/

  get titulo() {
    return this.#_titulo;
  }

  get artista() {
    return this.#_artista;
  }

  /***********
    RESTO METODOS
  **********/

  /**
   * Método obtenerSonido
   * Retorna una descripción genérica del sonido
   * Será sobrescrito por las subclases para aplicar polimorfismo
   * @returns {string} Descripción del sonido del disco
   */
  obtenerSonido() {
    return "Sonido genérico del disco";
  }

  /**
   * Método toString
   * Retorna una representación en cadena de texto del disco
   * @returns {string} Información del disco
   */
  toString() {
    return `Disco: ${this.#_titulo} - Artista: ${this.#_artista}`;
  }
}
