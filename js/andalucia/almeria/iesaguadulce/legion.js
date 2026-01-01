// Importamos el código centuria.js
import Centuria from "./centuria.js";

/**
 * Clase Legion
 * Representa una legión romana con sus centurias, velites y caballería
 */

class Legion {
  #_numero;
  #_legatus;
  #_comentarioHistorico;
  #_centurias = []; // Array de centurias normales (tipo centurio)
  #_velites = new Set(); // Conjunto de centurias tipo velite
  #_equite; // Centuria tipo equite (máximo una por legión)

  // Tamaño minimno y maximo de una legión.
  static #MIN_NUMERO = 1;
  static #MAX_NUMERO = 30;
  static #TIPO_CENTURIA = "centurio";
  static #TIPO_VELITE = "velite";
  static #TIPO_EQUITE = "equite";
  static #MAX_CENTURIAS = 10;

  constructor(numero, legatus, comentarioHistorico) {
    this.numero = numero;
    this.legatus = legatus;
    this.comentarioHistorico = comentarioHistorico;
  }

  /***********
    SETTERS
  **********/

  // Comprobar que sea un número positivo entero y entre 1 y 30
  set numero(nuevoNumero) {
    if (
      isNaN(nuevoNumero) ||
      !Number.isInteger(nuevoNumero) ||
      nuevoNumero < Legion.#MIN_NUMERO ||
      nuevoNumero > Legion.#MAX_NUMERO
    ) {
      throw `El número debe ser un entero entre ${Legion.#MIN_NUMERO} y ${
        Legion.#MAX_NUMERO
      }`;
    }
    this.#_numero = nuevoNumero;
  }

  //Comprobamos que no sea una cadena y no esté vacía
  set legatus(nuevoLegatus) {
    if (typeof nuevoLegatus !== "string" || nuevoLegatus.trim() === "") {
      throw "El legatus debe ser un string y no debe estar vacío";
    }
    this.#_legatus = nuevoLegatus;
  }

  //Comprobamos que no sea una cadena y no esté vacía
  set comentarioHistorico(nuevoComentarioHistorico) {
    if (
      typeof nuevoComentarioHistorico !== "string" ||
      nuevoComentarioHistorico.trim() === ""
    ) {
      throw "El comentario Historico debe ser un string y no debe estar vacío";
    }
    this.#_comentarioHistorico = nuevoComentarioHistorico;
  }

  //Método asignar centurión
  set equite(centuria) {
    //Verificamos si hay un centurión jefe
    if (
      !(centuria instanceof Centuria) ||
      centuria.tipo !== Legion.#TIPO_EQUITE
    ) {
      throw "Parece ser equite hace falta ser una centuria";
    }

    // Define un equite, si ya existia uno previamente lo remplaza con el nuevo.
    this.#_equite = centuria;
  }

  /***********
    GETTERS
  **********/
  get numero() {
    return this.#_numero;
  }

  get legatus() {
    return this.#_legatus;
  }

  get comentarioHistorico() {
    return this.#_comentarioHistorico;
  }

  get centurias() {
    return this.#_centurias;
  }

  get velites() {
    return [...this.#_velites]; // lo convertimos en array para mostrarlo
  }

  get equite() {
    return this.#_equite;
  }

  /***********
    RESTO METODOS
  **********/

  //Método para añadir una centuria
  addCenturia(centuria) {
    let esCenturia = false;
    //Verificamos si lo que se agrega es una centuria y es del tipo centruio
    if (
      centuria instanceof Centuria &&
      centuria.tipo === Legion.#TIPO_CENTURIA &&
      this.#_centurias.length < Legion.#MAX_CENTURIAS
    ) {
      this.#_centurias.push(centuria);
      esCenturia = true;
    }
    return esCenturia;
  }

  //Método para eliminar una centuria
  delCenturia(codigo_centuria) {
    let esCenturia = false;
    // Comprobamos que es un numero, integer y mayor que 0
    if (
      !isNaN(codigo_centuria) &&
      Number.isInteger(codigo_centuria) &&
      codigo_centuria > 0
    ) {
      //Recoreremos el array de centurias
      for (let i = 0; i < this.#_centurias.length; i++) {
        if (this.#_centurias[i].codigo === codigo_centuria) {
          //Si encontramos el código se elemina la centuria
          this.#_centurias.splice(i, 1);
          esCenturia = true;
        }
      }
    }
    return esCenturia;
  }

  //Método para añadir un velites
  addVelite(velite) {
    let esVelite = false;
    let maxVelites = Math.floor(this.#_centurias.length / 2);
    //Verificamos si lo que se agrega es una centturia y es del tipo velite
    if (
      velite instanceof Centuria &&
      velite.tipo === Legion.#TIPO_VELITE &&
      this.#_velites.size < maxVelites
    ) {
      this.#_velites.add(velite);
      esVelite = true;
    }
    return esVelite;
  }

  //Método para eliminar una velite
  delVelite(codigo_centuria) {
    let esCenturia = false;
    // Comprobamos que es un numero, integer y mayor que 0
    if (
      !isNaN(codigo_centuria) &&
      Number.isInteger(codigo_centuria) &&
      codigo_centuria > 0
    ) {
      //Recoreremos el array de centurias
      for (let velite of this.#_velites) {
        if (velite.codigo === codigo_centuria) {
          //Si encontramos el código se elemina la centuria
          this.#_velites.delete(velite);
          esCenturia = true;
        }
      }
    }
    return esCenturia;
  }

  toString() {
    let informacionLegion = "";

    informacionLegion += "¡Legion romana! <br>";
    informacionLegion += `Número: ${this.#_numero}<br>`;
    informacionLegion += `Legatus: ${this.#_legatus}<br>`;
    informacionLegion += `Comentario historico: ${
      this.#_comentarioHistorico
    }<br>`;

    /**************************************************************************
     Si hay centurias, añado su información, si no, mensaje de que no hay.
    **************************************************************************/
    informacionLegion += `Centurias: ${this.#_centurias.length}<br>`;
    if (this.#_centurias.length === 0) {
      informacionLegion += "¡No hay centurias normales asignadas!";
    } else {
      for (let i = 0; i < this.#_centurias.length; i++) {
        // Encabezado que me dica cual de las centurias estoy viendo la información.
        informacionLegion += `Centuria N.º${i + 1}: <br>`;
        // Imprimo/muestro la información de esa "X" centuria usando el toString heredado.
        informacionLegion += `${this.#_centurias[i].toString()}<br>`;
      }
    }

    /**************************************************************************
     Si hay velites, añado su información, si no, mensaje de que no hay.
    **************************************************************************/
    informacionLegion += `Velites: ${this.#_velites.size}<br>`;
    if (this.#_velites.size === 0) {
      informacionLegion += "¡No hay velites asignadas!";
    } else {
      // Variable utilizada para los encabezados.
      let contador = 1;

      for (let velite of this.#_velites) {
        // Encabezado que me dica cual de las velites estoy viendo la información.
        informacionLegion += `Velite N.º${contador}: <br>`;
        // Imprimo/muestro la información de esa "X" centuria usando el toString heredado.
        informacionLegion += `${velite.toString()}<br>`;
        // Incremento la variable usada para los encabezados.
        contador++;
      }
    }
    /**************************************************************************
     Si hay equite, añado su información, si no, mensaje de que no hay.
    **************************************************************************/
    informacionLegion += `Equite: <br>`;
    if (this.#_equite) {
      informacionLegion += `${this.#_equite.toString()} <br>`;
    } else {
      informacionLegion += `No hay caballería de elite asignada a esta legión.`;
    }
    return informacionLegion;
  }
}

export default Legion;
