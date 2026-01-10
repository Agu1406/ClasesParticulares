import Soldado from "./soldado.js";
import Centuria from "./centuria.js";
import Legion from "./legion.js";

function uso() {
  // Arrays de nombres y provincias romanas
  let nombresRomanos = [
    "Marcus",
    "Lucius",
    "Gaius",
    "Tiberius",
    "Aulus",
    "Quintus",
    "Publius",
    "Decimus",
    "Servius",
    "Gnaeus",
  ];
  let apellidosRomanos = [
    "Aemilius",
    "Cornelius",
    "Claudius",
    "Julius",
    "Valerius",
    "Fabius",
    "Antonius",
    "Cassius",
    "Sergius",
    "Tullius",
  ];
  let provinciasRomanas = [
    "Hispania",
    "Gallia",
    "Italia",
    "Africa",
    "Asia",
    "Macedonia",
    "Aegyptus",
    "Germania",
    "Britannia",
    "Numidia",
  ];

  /********************
    VARIABLES GENERALES
  *********************/
  let soldados = [];
  let centurias = [];
  let legiones = [];

  /*************************
    VARIABLES CLASE SOLDADO
  *************************/
  let nombreAleatorio,
    apellidoAleatorio,
    provinciaAleatoria,
    edadAleatoria,
    tipoSoldado;

  // Variables para controlar la cantidad de soldados de cada tipo
  let numCenturias = 0,
    numVelite = 0,
    numEquite = 0;

  // Arrays de soldados divididos por tipo
  let soldadosCenturio = [];
  let soldadosVelite = [];
  let soldadosEquite = [];

  // Índices para no repetir soldados al asignar a centurias
  let idxCenturio = 0,
    idxVelite = 0,
    idxEquite = 0;

  //Variables para las legiones
  let legion01, legion02;

  /*************************
    VARIABLES CLASE CENTURIA
  *************************/
  let codigo = 0;

  /************************
         PROCESAMIENTO
    ***********************/

  /*************************
    CREACIÓN DE SOLDADOS
  *************************/
  // Creación de 20 soldados repartidos en:
  // -- 12 soldados tipo centurios (3 centurias de 4 soldados cada una)
  // -- 6 soldados tipo velite (2 centurias de 3 soldados cada una)
  // -- 2 soldados de tipo equite (1 centuria de 2 soldados)

  for (let i = 0; i < 20; i++) {
    try {
      //Usamos variables aleatorias para obtener los atributos del constructor Soldado
      nombreAleatorio = Math.floor(Math.random() * nombresRomanos.length);
      apellidoAleatorio = Math.floor(Math.random() * apellidosRomanos.length);
      provinciaAleatoria = Math.floor(Math.random() * provinciasRomanas.length);
      edadAleatoria = Math.floor(Math.random() * (84 - 13 + 1)) + 13;

      //concatenamos apellido y nombre del soldado romano
      let nombreCompleto =
        nombresRomanos[nombreAleatorio] +
        " " +
        apellidosRomanos[apellidoAleatorio];

      // Controlamos la cantidad de soldados de cada tipo
      if (numCenturias < 12) {
        tipoSoldado = "centurio";
        numCenturias++;
      } else if (numVelite < 6) {
        tipoSoldado = "velite";
        numVelite++;
      } else if (numEquite < 2) {
        tipoSoldado = "equite";
        numEquite++;
      }

      //Instanciamos un objeto de tipo soldado usando los datos eleatorios.
      let soldado = new Soldado(nombreCompleto, edadAleatoria, tipoSoldado);
      //Añadimos la provincia
      soldado.provincia = provinciasRomanas[provinciaAleatoria];

      //Unimos el solado al array de soldados
      soldados.push(soldado);
    } catch (error) {
      console.error("Error creando soldado:", error);
    }
  }

  // Separamos los soldados por tipo
  for (let soldado of soldados) {
    if (soldado.tipo === "centurio") {
      soldadosCenturio.push(soldado);
    } else if (soldado.tipo === "velite") {
      soldadosVelite.push(soldado);
    } else if (soldado.tipo === "equite") {
      soldadosEquite.push(soldado);
    }
  }

  /*************************
    CREACIÓN DE CENTURIAS
  *************************/

  //**************************************************************
  // Centurias de tipo "centurio" (3 centurias de 4 soldados cada una)
  //**************************************************************
  for (let i = 0; i < 3; i++) {
    //Usamos un try-catch para controlar los posibles errores
    try {
      //Instancismo un objeto de tipo centuria
      codigo++;
      let centuria = new Centuria(codigo, "centurio");

      //A cada centuria añadimos 4 soldados de tipo centurio
      for (let j = 0; j < 4; j++) {
        centuria.addSoldado(soldadosCenturio[idxCenturio]); //Usamos un index para recorrer el array de soldados centurios
        if (j === 0) {
          // Primer soldado añadido es el centurión
          centuria.asignaCenturion(soldadosCenturio[idxCenturio]);
        }
        //Incrementamos el índice en cada vuelta para no repetir soldados
        idxCenturio++;
      }

      //Hacemos uso del método delSoldado
      let soldadoBorrado = soldadosCenturio[idxCenturio - 1]; //Guardamos el último soldado
      //Lo borramos
      centuria.delSoldado(soldadoBorrado.nombre, soldadoBorrado.provincia);
      //Lo añadimos de nuevo
      centuria.addSoldado(soldadoBorrado);

      //añadimos la centuria completa al array de centurias.
      centurias.push(centuria);
    } catch (error) {
      console.error("Error creando centuria de tipo centurio:", error);
    }
  }
  //**************************************************************
  // Centurias de tipo "velite" (2 centurias de 3 soldados cada una)
  //**************************************************************
  for (let i = 0; i < 2; i++) {
    try {
      codigo++;
      let centuria = new Centuria(codigo, "velite");

      for (let j = 0; j < 3; j++) {
        centuria.addSoldado(soldadosVelite[idxVelite]);
        if (j === 0) {
          centuria.asignaCenturion(soldadosVelite[idxVelite]);
        }
        idxVelite++;
      }

      centurias.push(centuria);
    } catch (error) {
      console.error("Error al crear una centuria de tipo velite:", error);
    }
  }
  //**************************************************************
  // Centuria de tipo "equite" (1 centuria de 2 soldados)
  //**************************************************************
  try {
    codigo++;
    let centuriaEquite = new Centuria(codigo, "equite");

    // Añadir los 2 soldados equite a la misma centuria
    for (let i = 0; i < 2; i++) {
      centuriaEquite.addSoldado(soldadosEquite[idxEquite]);
      if (i === 0) {
        centuriaEquite.asignaCenturion(soldadosEquite[idxEquite]);
      }
      idxEquite++;
    }

    centurias.push(centuriaEquite);
  } catch (error) {
    console.error("Error al crear una centuria de tipo equite:", error);
  }

  /********************
     CREACIÓN DE LEGIÓN
 ************************/
  //Dada la simplicidad, se crean a manos las 2 legiones

  try {
    //Instanciamos objeto de tipo legion y lo añadimos al array Legiones
    legion01 = new Legion(1, "Julio César", "Legio VII Gemina");
    legiones.push(legion01);
    legion02 = new Legion(9, "Pompeyo", "Legio IX Hispana");
    legiones.push(legion02);
  } catch (error) {
    console.error("Error creando legiones:", error);
  }

  /****************************************
     REPARTICIÓN DE CENTURIAS
 ******************************************/
  // LEGION01--> añadimos 2 centurias normales
  for (let i = 0; i < 2; i++) {
    if (centurias[i] && centurias[i].tipo === "centurio") {
      let añadido = legion01.addCenturia(centurias[i]);
      console.log("Centuria añadida a legion01:", añadido);
    }
  }

  //Hacemos uso del método delCenturia
  if (centurias[0]) {
    let centuriaBorrada = centurias[0].codigo; //Guardamos la centuria en una variable
    legion01.delCenturia(centuriaBorrada); //La borramos
    legion01.addCenturia(centurias[0]); //La volvemos a añadir
  }

  //LEGION01--> añadimos 1 centuria VELITE (índice 3 - primera velite)
  if (centurias[3] && centurias[3].tipo === "velite") {
    let añadido = legion01.addVelite(centurias[3]);
    console.log("Velite añadido a legion01:", añadido);
  }

  //Hacemos uso del método delVelite
  if (centurias[3]) {
    let vEliteBorrada = centurias[3].codigo; //Guardamos la vELITE en una variable
    legion01.delVelite(vEliteBorrada);
    legion01.addVelite(centurias[3]); //La volvemos a añadir
  }

  //LEGION01--> añadimos el equite (índice 5 - la primer y única equite)
  if (centurias[5] && centurias[5].tipo === "equite") {
    let añadido = (legion01.equite = centurias[5]);
    console.log("Equite asignado a legion01", añadido);
  }

  // LEGIO02-->añadimos tercera y ulitma centuria normal (índice 2)
  if (centurias[2] && centurias[2].tipo === "centurio") {
    let añadido = legion02.addCenturia(centurias[2]);
    console.log("Centuria añadida a legion02:", añadido);
  }

  // LEGIO02-->añadimos la segunda y ulitma centuria velite (índice 4)
  if (centurias[4] && centurias[4].tipo === "velite") {
    let añadido = legion02.addVelite(centurias[4]);
    console.log("Velite añadido a legion02:", añadido);
  }

  //**************************************************************
  // PROBAMOS LOS MÉTODOS DEL.
  //**************************************************************

  // Mostramos la información en la página
  let salida = document.getElementById("salida");
  if (salida) {
    salida.innerHTML = "<h2>Información del ejercito romano</h2>";
    salida.innerHTML += "<h3>Soldados creados: " + soldados.length + "</h3>";
    salida.innerHTML += "<h3>Centurias creadas: " + centurias.length + "</h3>";
    salida.innerHTML += "<h3>Legiones creadas: " + legiones.length + "</h3>";

    salida.innerHTML += "<h3>Información de la primera legión</h3>";
    salida.innerHTML += legiones[0].toString();

    salida.innerHTML += "<h3>Información de la segunda legión</h3>";
    salida.innerHTML += legiones[1].toString();
  }
}

export default uso;
