// Importamos las clases necesarias
import Soldado from "./soldado.js";
import Centuria from "./centuria.js";
import Legion from "./legion.js";

/**
 * Función que demuestra el uso de todas las clases y métodos
 * Crea 20 soldados, varias centurias y un par de legiones
 */
function uso() {
  let soldados = [];
  let centurias = [];
  let legiones = [];
  let soldado;
  let centuria;
  let legion;
  let resultado;

  // Crear 20 soldados de diferentes tipos
  try {
    soldado = new Soldado("Marco Aurelio", 25, "centurio");
    soldado.provincia = "Hispania";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Lucius Maximus", 30, "centurio");
    soldado.provincia = "Italia";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Gaius Brutus", 28, "centurio");
    soldado.provincia = "Galicia";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Publius Scipio", 32, "centurio");
    soldado.provincia = "Africa";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Titus Flavius", 27, "centurio");
    soldado.provincia = "Germania";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Decimus Valerius", 24, "velite");
    soldado.provincia = "Hispania";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Quintus Marius", 26, "velite");
    soldado.provincia = "Italia";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Sextus Pompeius", 23, "velite");
    soldado.provincia = "Galicia";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Aulus Cornelius", 29, "velite");
    soldado.provincia = "Africa";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Marcus Junius", 31, "velite");
    soldado.provincia = "Germania";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Gnaeus Domitius", 22, "equite");
    soldado.provincia = "Hispania";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Lucius Cassius", 33, "equite");
    soldado.provincia = "Italia";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Tiberius Gracchus", 35, "centurio");
    soldado.provincia = "Roma";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Caius Julius", 28, "centurio");
    soldado.provincia = "Hispania";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Marcus Antonius", 30, "velite");
    soldado.provincia = "Egipto";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Publius Crassus", 26, "velite");
    soldado.provincia = "Galicia";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Lucius Sulla", 34, "equite");
    soldado.provincia = "Italia";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Gaius Marius", 29, "centurio");
    soldado.provincia = "Africa";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Titus Livius", 27, "velite");
    soldado.provincia = "Germania";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Decimus Brutus", 31, "equite");
    soldado.provincia = "Hispania";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  try {
    soldado = new Soldado("Quintus Fabius", 25, "centurio");
    soldado.provincia = "Roma";
    soldados.push(soldado);
  } catch (e) {
    console.error("Error creando soldado: " + e);
  }

  // Crear 3 centurias normales (tipo centurio)
  try {
    centuria = new Centuria(1, "centurio");
    centuria.addSoldado(soldados[0]);
    centuria.addSoldado(soldados[1]);
    centuria.addSoldado(soldados[2]);
    centuria.asignaCenturion(soldados[0]);
    centurias.push(centuria);
  } catch (e) {
    console.error("Error creando centuria: " + e);
  }

  try {
    centuria = new Centuria(2, "centurio");
    centuria.addSoldado(soldados[3]);
    centuria.addSoldado(soldados[4]);
    centuria.addSoldado(soldados[12]);
    centuria.asignaCenturion(soldados[3]);
    centurias.push(centuria);
  } catch (e) {
    console.error("Error creando centuria: " + e);
  }

  try {
    centuria = new Centuria(3, "centurio");
    centuria.addSoldado(soldados[13]);
    centuria.addSoldado(soldados[17]);
    centuria.addSoldado(soldados[19]);
    centuria.asignaCenturion(soldados[13]);
    centurias.push(centuria);
  } catch (e) {
    console.error("Error creando centuria: " + e);
  }

  // Crear 2 centurias velites
  try {
    centuria = new Centuria(4, "velite");
    centuria.addSoldado(soldados[5]);
    centuria.addSoldado(soldados[6]);
    centuria.addSoldado(soldados[7]);
    centuria.asignaCenturion(soldados[5]);
    centurias.push(centuria);
  } catch (e) {
    console.error("Error creando centuria: " + e);
  }

  try {
    centuria = new Centuria(5, "velite");
    centuria.addSoldado(soldados[8]);
    centuria.addSoldado(soldados[9]);
    centuria.addSoldado(soldados[14]);
    centuria.asignaCenturion(soldados[8]);
    centurias.push(centuria);
  } catch (e) {
    console.error("Error creando centuria: " + e);
  }

  // Crear 1 centuria equite
  try {
    centuria = new Centuria(6, "equite");
    centuria.addSoldado(soldados[10]);
    centuria.addSoldado(soldados[11]);
    centuria.addSoldado(soldados[15]);
    centuria.asignaCenturion(soldados[10]);
    centurias.push(centuria);
  } catch (e) {
    console.error("Error creando centuria: " + e);
  }

  // Crear primera legión
  try {
    legion = new Legion(7, "Julio César", "Legio VII Gemina. Legión creada durante las guerras de las Galias.");
    resultado = legion.addCenturia(centurias[0]);
    resultado = legion.addCenturia(centurias[1]);
    resultado = legion.addCenturia(centurias[2]);
    resultado = legion.addVelite(centurias[3]);
    resultado = legion.addVelite(centurias[4]);
    legion.equite = centurias[5];
    legiones.push(legion);
  } catch (e) {
    console.error("Error creando legión: " + e);
  }

  // Crear segunda legión
  try {
    legion = new Legion(13, "Marco Aurelio", "Legio XIII Gemina. Legión que participó en las campañas de Germania.");
    resultado = legion.addCenturia(centurias[0]);
    resultado = legion.addCenturia(centurias[1]);
    resultado = legion.addVelite(centurias[3]);
    legiones.push(legion);
  } catch (e) {
    console.error("Error creando legión: " + e);
  }

  // Demostrar uso de métodos de eliminación
  try {
    resultado = legiones[0].delCenturia(2);
    resultado = legiones[0].delVelite(4);
    resultado = centurias[0].delSoldado("Lucius Maximus", "Italia");
  } catch (e) {
    console.error("Error eliminando elementos: " + e);
  }

  // Demostrar uso de setters con try-catch
  try {
    soldados[0].edad = 26;
    soldados[0].provincia = "Nueva Provincia";
  } catch (e) {
    console.error("Error modificando soldado: " + e);
  }

  // Mostrar resultados en el elemento salida
  let salida = document.getElementById("salida");
  if (salida) {
    salida.innerHTML = "<h2>Ejército Romano - Resultados</h2>";
    salida.innerHTML += "<h3>Soldados creados: " + soldados.length + "</h3>";
    salida.innerHTML += "<h3>Centurias creadas: " + centurias.length + "</h3>";
    salida.innerHTML += "<h3>Legiones creadas: " + legiones.length + "</h3>";
    salida.innerHTML += "<hr>";
    
    salida.innerHTML += "<h3>Primera Legión:</h3>";
    salida.innerHTML += "<pre>" + legiones[0].toString() + "</pre>";
    
    salida.innerHTML += "<h3>Segunda Legión:</h3>";
    salida.innerHTML += "<pre>" + legiones[1].toString() + "</pre>";
  }
}

export default uso;

