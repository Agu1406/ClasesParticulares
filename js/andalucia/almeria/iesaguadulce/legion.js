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

  static #MAX_NUMERO = 30; // Número máximo de legión
  static #TIPO_CENTURIA = "centurio"; // Tipo de centuria normal
  static #TIPO_VELITE = "velite"; // Tipo de centuria velite
  static #TIPO_EQUITE = "equite"; // Tipo de centuria equite
  static #MAX_CENTURIAS = 10; // Máximo de centurias por legión

  /**
   * Constructor de la clase Legion
   * @param {Number} numero - Número de la legión (entre 1 y 30)
   * @param {String} legatus - Nombre del legado/senador al mando
   * @param {String} comentarioHistorico - Comentario histórico sobre la legión
   */
  constructor(numero, legatus, comentarioHistorico) {
    this.numero = numero;
    this.legatus = legatus;
    this.comentarioHistorico = comentarioHistorico;
  }

  /***********
    SETTERS
  **********/

  /**
   * Setter para el número de la legión
   * @param {Number} nuevoNumero - Nuevo número (entre 1 y 30)
   */
  set numero(nuevoNumero) {
    if (!Number.isInteger(nuevoNumero) || nuevoNumero < 1 || nuevoNumero > Legion.#MAX_NUMERO) {
      throw `El número de legión debe ser un entero entre 1 y ${Legion.#MAX_NUMERO}. Valor proporcionado: ${nuevoNumero}`;
    }
    this.#_numero = nuevoNumero;
  }

  /**
   * Setter para el legado
   * @param {String} nuevoLegatus - Nuevo nombre del legado
   */
  set legatus(nuevoLegatus) {
    if (typeof nuevoLegatus !== "string" || nuevoLegatus.trim() === "") {
      throw "El nombre del legado no puede estar vacío";
    }
    this.#_legatus = nuevoLegatus;
  }

  /**
   * Setter para el comentario histórico
   * @param {String} nuevoComentario - Nuevo comentario histórico
   */
  set comentarioHistorico(nuevoComentario) {
    this.#_comentarioHistorico = nuevoComentario;
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
    return this.#_velites;
  }

  get equite() {
    return this.#_equite;
  }

  /***********
    MÉTODOS
  **********/

  /**
   * Añade una centuria normal al array de centurias
   * @param {Centuria} centuria - Centuria a añadir (debe ser tipo centurio)
   * @returns {Boolean} - true si se añadió, false si falló
   */
  addCenturia(centuria) {
    let resultado = false;
    // Verificamos que sea una instancia de Centuria
    if (!(centuria instanceof Centuria)) {
      return resultado;
    }
    // Verificamos que sea tipo centurio (normal)
    if (centuria.tipo !== Legion.#TIPO_CENTURIA) {
      return resultado;
    }
    // Verificamos que no se haya alcanzado el máximo
    if (this.#_centurias.length >= Legion.#MAX_CENTURIAS) {
      return resultado;
    }
    // Añadimos la centuria
    this.#_centurias.push(centuria);
    resultado = true;
    return resultado;
  }

  /**
   * Elimina una centuria normal por su código
   * @param {Number} codigo_centuria - Código de la centuria a eliminar
   * @returns {Boolean} - true si se eliminó, false si no se encontró
   */
  delCenturia(codigo_centuria) {
    let resultado = false;
    let indice = -1;
    // Buscamos la centuria por su código
    for (let i = 0; i < this.#_centurias.length; i++) {
      if (this.#_centurias[i].codigo === codigo_centuria) {
        indice = i;
        resultado = true;
        break;
      }
    }
    // Si la encontramos, la eliminamos
    if (resultado) {
      this.#_centurias.splice(indice, 1);
    }
    return resultado;
  }

  /**
   * Añade una centuria velite al conjunto de velites
   * @param {Centuria} velite - Centuria velite a añadir
   * @returns {Boolean} - true si se añadió, false si falló
   */
  addVelite(velite) {
    let resultado = false;
    // Verificamos que sea una instancia de Centuria
    if (!(velite instanceof Centuria)) {
      return resultado;
    }
    // Verificamos que sea tipo velite
    if (velite.tipo !== Legion.#TIPO_VELITE) {
      return resultado;
    }
    // Verificamos que no se haya alcanzado el máximo (mitad de centurias normales)
    let maxVelites = Math.floor(this.#_centurias.length / 2);
    if (this.#_velites.size >= maxVelites) {
      return resultado;
    }
    // Añadimos el velite
    this.#_velites.add(velite);
    resultado = true;
    return resultado;
  }

  /**
   * Elimina una centuria velite por su código
   * @param {Number} codigo_centuria - Código de la centuria velite a eliminar
   * @returns {Boolean} - true si se eliminó, false si no se encontró
   */
  delVelite(codigo_centuria) {
    let resultado = false;
    for (let velite of this.#_velites) {
      if (velite.codigo === codigo_centuria) {
        this.#_velites.delete(velite);
        resultado = true;
        break;
      }
    }
    return resultado;
  }

  /**
   * Setter para asignar una centuria equite (caballería) a la legión
   * Solo puede haber una, y al asignar se elimina la anterior
   * @param {Centuria} equite - Centuria equite a asignar
   */
  set equite(equite) {
    // Verificamos que sea una instancia de Centuria
    if (!(equite instanceof Centuria)) {
      throw "El objeto debe ser una instancia de Centuria";
    }
    // Verificamos que sea tipo equite
    if (equite.tipo !== Legion.#TIPO_EQUITE) {
      throw "La centuria debe ser de tipo equite";
    }
    // Asignamos (reemplaza la anterior si existe)
    this.#_equite = equite;
  }

  /**
   * Método toString que muestra todos los atributos de la legión
   * @returns {String} - Representación en cadena de la legión
   */
  toString() {
    let resultado = "Legión Romana\n";
    resultado += `Número: ${this.#_numero}\n`;
    resultado += `Legado: ${this.#_legatus}\n`;
    resultado += `Comentario Histórico: ${this.#_comentarioHistorico}\n`;
    resultado += `Centurias Normales: ${this.#_centurias.length}\n`;
    
    if (this.#_centurias.length === 0) {
      resultado += "No hay centurias normales asignadas\n";
    } else {
      for (let i = 0; i < this.#_centurias.length; i++) {
        resultado += `Centuria ${i + 1}:\n${this.#_centurias[i].toString()}\n`;
      }
    }
    
    resultado += `Velites: ${this.#_velites.size}\n`;
    if (this.#_velites.size === 0) {
      resultado += "No hay velites asignados\n";
    } else {
      let contador = 1;
      for (let velite of this.#_velites) {
        resultado += `Velite ${contador}:\n${velite.toString()}\n`;
        contador++;
      }
    }
    
    resultado += "Caballería (Equite):\n";
    if (this.#_equite) {
      resultado += `${this.#_equite.toString()}\n`;
    } else {
      resultado += "No hay caballería asignada\n";
    }
    
    return resultado;
  }
}

export default Legion;
