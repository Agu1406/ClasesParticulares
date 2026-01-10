export default class Soldado {
  #_nombre;
  #_edad;
  #_tipo;
  #_provincia;

  static #TIPOS_VALIDOS = ["centurio", "velite", "equite"];
  static #MAX_EDAD = 84;
  static #MIN_EDAD = 13;

  //Implementamos el constructor de la clase
  constructor(nombre, edad, tipo) {
    this.nombre = nombre; //Validamos con los setters
    this.edad = edad; //Validamos con los setters
    this.tipo = tipo; //Validamos con los setters
    this.#_provincia = ""; //Lo incializamos vacío
  }

  /***********
    SETTERS
  **********/
  set nombre(nuevoNombre) {
    //El nombre tiene que ser un String, que no esté vacío y mínimo 5 caracteres
    if (
      typeof nuevoNombre !== "string" ||
      nuevoNombre.trim() === "" ||
      nuevoNombre.trim().length < 5
    ) {
      //si no se cumple se lanza una excepción.
      throw "El nombre debe tener como mínimo 5 caracteres y no debe estar vacio";
      //Si se cumple establecemos el nombre
    } else this.#_nombre = nuevoNombre;
  }

  set edad(nuevaEdad) {
    // Comprobar que sea un número positivo entero
    //comprobamos que sea superior a 12 y menor a 85
    if (
      isNaN(nuevaEdad) ||
      nuevaEdad < Soldado.#MIN_EDAD ||
      nuevaEdad > Soldado.#MAX_EDAD ||
      !Number.isInteger(nuevaEdad)
    ) {
      throw "La edad no es válida.Debe ser superior a 12 e inferior a 85";
    } else this.#_edad = nuevaEdad;
  }

  set tipo(nuevoTipo) {
    // Si el soldado tiene "X" tipo que no existe dentro de los tipos validos, error.
    if (!Soldado.#TIPOS_VALIDOS.includes(nuevoTipo)) {
      throw `El tipo no es valido, debe ser uno de los siguientes: ${Soldado.#TIPOS_VALIDOS.join(
        ", "
      )}`;
    }

    this.#_tipo = nuevoTipo;
  }

  set provincia(nuevaProvincia) {
    //Validamos que sea un string y que no esté vacío
    if (typeof nuevaProvincia !== "string" || nuevaProvincia.trim() === "") {
      throw "La provincia debe ser un string y no debe estar vacío";
    }
    this.#_provincia = nuevaProvincia;
  }

  /**********************
    GETTERS DEL OBJETO
  ***********************/
  get edad() {
    return this.#_edad;
  }

  get nombre() {
    return this.#_nombre;
  }

  get tipo() {
    return this.#_tipo;
  }
  get provincia() {
    return this.#_provincia;
  }

  /**********************
    GETTERS DE LA CLASE
  ***********************/

  static get edadMaxima() {
    return Soldado.#MAX_EDAD;
  }

  static get edadMinima() {
    return Soldado.#MIN_EDAD;
  }

  static get tiposValidos() {
    return Soldado.#TIPOS_VALIDOS;
  }

  /***********
    FUNCIONES
  **********/

  /**
   * Función "toString" personalizada que imprime la información de un saldo
   * y todos sus atributos.
   */
  toString() {
    let informacionSoldado = "";
    informacionSoldado += `<img src="https://www.publicdomainpictures.net/pictures/730000/nahled/roman-man-1759551028I7P.png"/>`;
    informacionSoldado += "¡Información del soldado! <br>";
    informacionSoldado += `Nombre: ${this.#_nombre}<br>`;
    informacionSoldado += `Edad: ${this.#_edad}<br>`;
    informacionSoldado += `Tipo: ${this.#_tipo}<br>`;
    informacionSoldado += `Provincia: ${this.#_provincia}<br>`;

    return informacionSoldado;
  }
}
