/**
 * Clase Soldado
 * Representa un soldado romano con sus características básicas
 */
class Soldado {
  #_nombre;
  #_edad;
  #_tipo;
  #_provincia;

  static #TIPOS_VALIDOS = ["centurio", "velite", "equite"]; // Array inmutable de tipos permitidos

  /**
   * Constructor de la clase Soldado
   * @param {String} nombre - Nombre del soldado (mínimo 5 caracteres)
   * @param {Number} edad - Edad del soldado (entre 12 y 85 años)
   * @param {String} tipo - Tipo de soldado (centurio, velite o equite)
   */
  constructor(nombre, edad, tipo) {
    this.nombre = nombre;
    this.edad = edad;
    this.tipo = tipo;
    this.provincia = ""; // Inicializamos vacío
  }

  /***********
    SETTERS
  **********/

  /**
   * Setter para el nombre del soldado
   * @param {String} nuevoNombre - Nuevo nombre (mínimo 5 caracteres)
   */
  set nombre(nuevoNombre) {
    if (typeof nuevoNombre !== "string" || nuevoNombre.length < 5) {
      throw `El nombre debe tener al menos 5 caracteres. Nombre proporcionado: ${nuevoNombre}`;
    }
    this.#_nombre = nuevoNombre;
  }

  /**
   * Setter para la edad del soldado
   * @param {Number} nuevaEdad - Nueva edad (entre 12 y 85 años)
   */
  set edad(nuevaEdad) {
    if (!Number.isInteger(nuevaEdad) || nuevaEdad <= 12 || nuevaEdad >= 85) {
      throw `El soldado ${this.#_nombre || "sin nombre"} tiene ${nuevaEdad} años. La edad debe ser un número entero mayor de 12 e inferior a 85.`;
    }
    this.#_edad = nuevaEdad;
  }

  /**
   * Setter para el tipo de soldado
   * @param {String} nuevoTipo - Nuevo tipo (centurio, velite o equite)
   */
  set tipo(nuevoTipo) {
    if (!Soldado.#TIPOS_VALIDOS.includes(nuevoTipo)) {
      throw `El tipo debe ser uno de: ${Soldado.#TIPOS_VALIDOS.join(", ")}. Tipo proporcionado: ${nuevoTipo}`;
    }
    this.#_tipo = nuevoTipo;
  }

  /**
   * Setter para la provincia de origen
   * @param {String} nuevaProvincia - Nueva provincia
   */
  set provincia(nuevaProvincia) {
    this.#_provincia = nuevaProvincia;
  }

  /***********
    GETTERS
  **********/

  get nombre() {
    return this.#_nombre;
  }

  get edad() {
    return this.#_edad;
  }

  get tipo() {
    return this.#_tipo;
  }

  get provincia() {
    return this.#_provincia;
  }

  /***********
    MÉTODOS
  **********/

  /**
   * Método toString que muestra todos los atributos del soldado
   * @returns {String} - Representación en cadena del soldado
   */
  toString() {
    let resultado = "Soldado Romano\n";
    resultado += `Nombre: ${this.#_nombre}\n`;
    resultado += `Edad: ${this.#_edad} años\n`;
    resultado += `Tipo: ${this.#_tipo}\n`;
    resultado += `Provincia: ${this.#_provincia || "No asignada"}\n`;
    return resultado;
  }
}

export default Soldado;

