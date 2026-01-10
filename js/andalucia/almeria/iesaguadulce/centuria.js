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

  static #MAX_SOLDADOS = 10; //Numero soldados máximo que forma una centuria
  static #TIPOS_VALIDOS = ["centurio", "velite", "equite"]; //Array inmutable tipos permitidos

  /**
   * Constructor de la clase Centuria
   */
  constructor(codigo, tipo) {
    this.codigo = codigo;
    this.tipo = tipo;
  }

  /***********
    SETTERS
  **********/

  set codigo(nuevoCodigo) {
    // Comprobar que sea un número positivo entero y superior a 0.
    if (
      isNaN(nuevoCodigo) ||
      nuevoCodigo <= 0 ||
      !Number.isInteger(nuevoCodigo)
    ) {
      throw "el código debe ser un número y superior a 0";
    } else this.#_codigo = nuevoCodigo;
  }

  set tipo(nuevoTipo) {
    //validamos que el tipo sea uno de los 3 permitidos
    if (!Centuria.#TIPOS_VALIDOS.includes(nuevoTipo)) {
      throw `El tipo debe ser uno de: ${Centuria.#TIPOS_VALIDOS.join(
        ", "
      )}. Tipo proporcionado: ${nuevoTipo}`;
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
    RESTO METODOS
  **********/
  //Método para añadir nuevos soldados a la enturia
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
    if (
      !Number.isInteger(soldado.edad) ||
      soldado.edad < 13 ||
      soldado.edad > 84
    ) {
      throw `El soldado ${soldado.nombre} tiene ${soldado.edad} años. La edad debe ser un número entero mayor de 12 e inferior a 85.`;
    }
    this.#_tropa.add(soldado);
  }

  //Método para eliminar soldados de la centuria
  delSoldado(nombre, provincia) {
    let esSoldado = false;
    for (let soldado of this.#_tropa) {
      //Recorremos toda la centuria buscando un soldado cuyo nombre y provincia coincidan
      if (soldado.nombre === nombre && soldado.provincia === provincia) {
        this.#_tropa.delete(soldado); //Si lo encontramos lo borramos
        esSoldado = true;
      }
    }
    //Si no se encuentra lanzamos una excepción
    if (!esSoldado) {
      throw `No hay ningún soldado con el nombre: ${nombre} y de la provincia: ${provincia}.`;
    }

    return esSoldado;
  }

  //Método asignar centurión
  asignaCenturion(soldado) {
    //Verificamos si hay un centurión jefe
    if (!(soldado instanceof Soldado)) {
      throw "Parece ser centurión hace falta ser un soldado";
    }
    // Si ya existe un centurión, lo remplazo con el nuevo jefe, si no, lo asigno.
    this.#_centurion = soldado;
  }

  toString() {
    let informacionCenturia = "";
    // Información básica que tienen todas las centurias romanas.
    informacionCenturia += `<img src="https://www.publicdomainpictures.net/pictures/730000/nahled/roman-man-1759551028I7P.png"/>`;
    informacionCenturia += "¡Centuria Romana! <br>";
    informacionCenturia += `Código: ${this.#_codigo}.<br>`;
    informacionCenturia += `Tipo: ${this.#_tipo}.<br>`;
    // Si tiene un centurion (jefe) lo imprimo, si no, aviso que no tiene.
    if (this.#_centurion) {
      informacionCenturia += `Centurión jefe: ${this.#_centurion}.<br>`;
    } else {
      informacionCenturia += `Centurión jefe: centurión aún no asignado. <br>`;
    }

    /**
     * Bucle que recorre uno por uno todos los soldados imprimiendo la información
     * de ellos con el método "toString()" creado en la clase soldado (soldado.js)
     * junto a un "codigoSoldado" para pdoer difeferneicar si es el soldado 1, 2,
     * 3, 4, etc, de la centuria.
     */
    let codigoSoldado = 1;
    for (let soldado of this.#_tropa) {
      // "Soldado: 1 - ¡Información del soldado!
      informacionCenturia += `Soldado: ${codigoSoldado} - ${soldado.toString()}`;
      codigoSoldado++;
    }

    return informacionCenturia;
  }
}

export default Centuria;
