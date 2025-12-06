// Importamos el código soldado.js
import Soldado from "./soldado.js";

/**
 * Clase Centuria
 * Representa una centuria romana con sus soldados y centurión
 */
class Centuria {
  #_codigo;
  #_tipo;
  #_tropa = new Set(); // Conjunto de tipo set que no permite meter 2 veces el mismo valor
  #_centurion;

  static #MAX_SOLDADOS = 10; // Número máximo de soldados que forma una centuria
  static #TIPOS_VALIDOS = ["centurio", "velite", "equite"]; // Array inmutable tipos permitidos

  /**
   * Constructor de la clase Centuria
   * @param {Number} codigo - Código de la centuria (número arábigo)
   * @param {String} tipo - Tipo de centuria (centurio, velite o equite)
   */
  constructor(codigo, tipo) {
    this.codigo = codigo;
    this.tipo = tipo;
  }

  /***********
    SETTERS
  **********/

  /**
   * Setter para el código de la centuria
   * @param {Number} nuevoCodigo - Nuevo código (debe ser un número positivo)
   */
  set codigo(nuevoCodigo) {
    // Comprobar que sea un número positivo entero y superior a 0
    if (isNaN(nuevoCodigo) || nuevoCodigo <= 0 || !Number.isInteger(nuevoCodigo)) {
      throw "El código debe ser un número entero positivo superior a 0";
    }
    this.#_codigo = nuevoCodigo;
  }

  /**
   * Setter para el tipo de centuria
   * @param {String} nuevoTipo - Nuevo tipo (centurio, velite o equite)
   */
  set tipo(nuevoTipo) {
    // Validamos que el tipo sea uno de los 3 permitidos
    if (!Centuria.#TIPOS_VALIDOS.includes(nuevoTipo)) {
      throw `El tipo debe ser uno de: ${Centuria.#TIPOS_VALIDOS.join(", ")}. Tipo proporcionado: ${nuevoTipo}`;
    }
    this.#_tipo = nuevoTipo;
  }

  /***********
    GETTERS
  **********/

  get codigo() {
    return this.#_codigo;
  }

  get tipo() {
    return this.#_tipo;
  }

  get tropa() {
    return this.#_tropa;
  }

  get centurion() {
    return this.#_centurion;
  }

  /***********
    RESTO MÉTODOS
  **********/

  /**
   * Método para añadir nuevos soldados a la centuria
   * @param {Soldado} soldado - Soldado a añadir
   */
  addSoldado(soldado) {
    // Verificamos que no se haya alcanzado el número máximo
    if (this.#_tropa.size >= Centuria.#MAX_SOLDADOS) {
      throw "Se ha alcanzado el máximo número de soldados de la centuria (10)";
    }
    // Verificamos que sea un objeto Soldado
    if (!(soldado instanceof Soldado)) {
      throw "El objeto debe ser una instancia de Soldado";
    }
    // Verificamos que la edad del soldado sea válida (mayor de 12 e inferior a 85)
    if (!Number.isInteger(soldado.edad) || soldado.edad <= 12 || soldado.edad >= 85) {
      throw `El soldado ${soldado.nombre} tiene ${soldado.edad} años. La edad debe ser un número entero mayor de 12 e inferior a 85.`;
    }
    this.#_tropa.add(soldado);
  }

  /**
   * Método para eliminar soldados de la centuria
   * @param {String} nombre_soldado - Nombre del soldado a eliminar
   * @param {String} provincia - Provincia del soldado a eliminar
   * @returns {Boolean} - true si se eliminó, false si no se encontró
   */
  delSoldado(nombre_soldado, provincia) {
    let encontrado = false;
    for (let soldado of this.#_tropa) {
      // Recorremos toda la centuria buscando un soldado cuyo nombre y provincia coincidan
      if (soldado.nombre === nombre_soldado && soldado.provincia === provincia) {
        this.#_tropa.delete(soldado); // Si lo encontramos lo borramos
        encontrado = true;
        break; // Salimos del bucle una vez encontrado
      }
    }
    return encontrado;
  }

  /**
   * Método para asignar el centurión jefe
   * @param {Soldado} soldado - Soldado que será el centurión
   */
  asignaCenturion(soldado) {
    // Verificamos que sea un objeto Soldado
    if (!(soldado instanceof Soldado)) {
      throw "El objeto debe ser una instancia de Soldado";
    }
    // Verificamos que la edad del soldado sea válida (mayor de 12 e inferior a 85)
    if (!Number.isInteger(soldado.edad) || soldado.edad <= 12 || soldado.edad >= 85) {
      throw `El soldado ${soldado.nombre} tiene ${soldado.edad} años. La edad debe ser un número entero mayor de 12 e inferior a 85.`;
    }
    // Si ya hay un centurión, lo reemplazamos (según el enunciado: "Al asignar se elimina el que había antes")
    this.#_centurion = soldado;
  }

  /**
   * Método toString que muestra todos los atributos de la centuria
   * @returns {String} - Representación en cadena de la centuria
   */
  toString() {
    let resultado = "Centuria Romana\n";
    resultado += `Código: ${this.#_codigo}\n`;
    resultado += `Tipo: ${this.#_tipo}\n`;
    resultado += `Número de soldados: ${this.#_tropa.size}\n`;
    
    if (this.#_centurion) {
      resultado += `Centurión Jefe:\n${this.#_centurion.toString()}`;
    } else {
      resultado += "Centurión Jefe: No asignado\n";
    }
    
    resultado += "Soldados de la centuria:\n";
    if (this.#_tropa.size === 0) {
      resultado += "La centuria está vacía\n";
    } else {
      let contador = 1;
      for (let soldado of this.#_tropa) {
        resultado += `${contador}. ${soldado.toString()}`;
        contador++;
      }
    }
    return resultado;
  }
}

export default Centuria;

