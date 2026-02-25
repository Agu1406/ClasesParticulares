// Importamos las clases necesarias
import TocaDiscos from "./tocadiscos.js";
import ReproductorCDs from "./reproductorcds.js";
import Vinilo from "./vinilo.js";
import CD from "./cd.js";
import Disco from "./disco.js";

/*======================================================
CREACIÓN DE TODAS LAS INSTANCIAS
======================================================*/

export default function uso() {
  try {
    let tocadisc01 = new TocaDiscos();
    let reproductorcds01 = new ReproductorCDs();
    let disco01 = new Disco("Álbum Genérico", "Artista Desconocido");
    let vinilo01 = new Vinilo("Abbey Road", "The Beatles", 33);
    let cd01 = new CD("Thriller", "Michael Jackson");

    let imprimirMusica = "";

    /*======================================================
    PROBAR EL toString() DE TODAS LAS INSTANCIAS POSIBLES
    ======================================================*/
    
    imprimirMusica += disco01.toString() + "<br>";
    console.log(disco01.toString());

    imprimirMusica += vinilo01.toString() + "<br>";
    console.log(vinilo01.toString());

    imprimirMusica += cd01.toString() + "<br>";
    console.log(cd01.toString());

    /*======================================================
    PROBAR EL REPRODUCTOR TocaDiscos con TODAS LAS INSTANCIAS
    ======================================================*/
    
    imprimirMusica += "<br>--- Reproduciendo con TocaDiscos ---<br>";
    
    // Reproducir disco base
    try {
      tocadisc01.reproducir(disco01);
      imprimirMusica += "✅ Disco base reproducido correctamente<br>";
    } catch (ex) {
      imprimirMusica += "❌ Error: " + ex + "<br>";
      console.log(ex);
    }

    // Reproducir vinilo
    try {
      tocadisc01.reproducir(vinilo01);
      imprimirMusica += "✅ Vinilo reproducido correctamente<br>";
    } catch (ex) {
      imprimirMusica += "❌ Error: " + ex + "<br>";
      console.log(ex);
    }

    // Intentar reproducir CD (debe fallar)
    try {
      tocadisc01.reproducir(cd01);
      imprimirMusica += "✅ CD reproducido<br>";
    } catch (ex) {
      imprimirMusica += "❌ Error esperado: " + ex + "<br>";
      console.log(ex);
    }

    /*======================================================
    PROBAR EL REPRODUCTOR ReproductorCDs
    ======================================================*/
    
    imprimirMusica += "<br>--- Reproduciendo con ReproductorCDs ---<br>";
    
    // Reproducir CD
    try {
      reproductorcds01.reproducir(cd01);
      imprimirMusica += "✅ CD reproducido correctamente<br>";
    } catch (ex) {
      imprimirMusica += "❌ Error: " + ex + "<br>";
      console.log(ex);
    }

    // Intentar reproducir vinilo (debe fallar)
    try {
      reproductorcds01.reproducir(vinilo01);
      imprimirMusica += "✅ Vinilo reproducido<br>";
    } catch (ex) {
      imprimirMusica += "❌ Error esperado: " + ex + "<br>";
      console.log(ex);
    }

    document.getElementById("mensaje").innerHTML = imprimirMusica;

  } catch (ex) {
    console.log(ex);
    if (document.getElementById("mensaje")) {
      document.getElementById("mensaje").innerHTML = "Error: " + ex;
    }
  }
}
