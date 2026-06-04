package ev3.ut6.u02coleccionesestructuras.practicas.madriduaxsistemagrafoarista;
public class Grafo_SIN_RESOLVER {
    private Nodo_SIN_RESOLVER[] nodos;
    private Arista_SIN_RESOLVER[] aristas;
    private int numNodos;
    private int numAristas;

    public Grafo_SIN_RESOLVER(int numNodos) {
        this.nodos = new Nodo_SIN_RESOLVER[numNodos];
        this.aristas = new Arista_SIN_RESOLVER[numNodos * numNodos]; // Maximo numero posible de aristas
        this.numNodos = 0;
        this.numAristas = 0;
    }

    public boolean anadirArista(Arista_SIN_RESOLVER arista) {
        if (numAristas < aristas.length) {
            aristas[numAristas++] = arista;
            return true;
        }
        return false;
    }

    public boolean anadirNodo(Nodo_SIN_RESOLVER nodo) {
        if (numNodos < nodos.length) {
            nodos[numNodos++] = nodo;
            return true;
        }
        return false;
    }

    public boolean eliminarArista(Arista_SIN_RESOLVER arista) {
        for (int i = 0; i < numAristas; i++) {
            if (aristas[i].getV1().igual(arista.getV1()) && 
                aristas[i].getV2().igual(arista.getV2())) {
                // Mover la ultima arista a esta posicion
                aristas[i] = aristas[numAristas - 1];
                numAristas--;
                return true;
            }
        }
        return false;
    }

    public boolean eliminarNodo(Nodo_SIN_RESOLVER nodo) {
        int pos = posicionNodo(nodo);
        if (pos != -1) {
            // Eliminar todas las aristas conectadas a este nodo
            for (int i = 0; i < numAristas; i++) {
                if (aristas[i].getV1().igual(nodo) || aristas[i].getV2().igual(nodo)) {
                    eliminarArista(aristas[i]);
                    i--; // Ajustar el indice ya que eliminamos una arista
                }
            }
            // Mover el ultimo nodo a esta posicion
            nodos[pos] = nodos[numNodos - 1];
            numNodos--;
            return true;
        }
        return false;
    }

    private int posicionNodo(Nodo_SIN_RESOLVER nodo) {
        for (int i = 0; i < numNodos; i++) {
            if (nodos[i].igual(nodo)) {
                return i;
            }
        }
        return -1;
    }

    public Nodo_SIN_RESOLVER[] listaNodos() {
        Nodo_SIN_RESOLVER[] resultado = new Nodo_SIN_RESOLVER[numNodos];
        System.arraycopy(nodos, 0, resultado, 0, numNodos);
        return resultado;
    }

    public Arista_SIN_RESOLVER[] listaAristas() {
        Arista_SIN_RESOLVER[] resultado = new Arista_SIN_RESOLVER[numAristas];
        System.arraycopy(aristas, 0, resultado, 0, numAristas);
        return resultado;
    }

    private int numeroDeAristas() {
        return numAristas;
    }

    private int numeroDeNodos() {
        return numNodos;
    }

    public Grafo_SIN_RESOLVER limpieza() {
        // Crear un nuevo grafo con el mismo numero maximo de nodos
        Grafo_SIN_RESOLVER grafoLimpio = new Grafo_SIN_RESOLVER(this.nodos.length);
        
        // 1. Copiar todos los nodos al nuevo grafo
        for (int i = 0; i < numNodos; i++) {
            grafoLimpio.anadirNodo(this.nodos[i]);
        }
        
        // 2. Copiar las aristas, cambiando el signo de las negativas
        for (int i = 0; i < numAristas; i++) {
            Arista_SIN_RESOLVER arista = this.aristas[i];
            int nuevoPeso = arista.getPeso() < 0 ? -arista.getPeso() : arista.getPeso();
            Arista_SIN_RESOLVER nuevaArista = new Arista_SIN_RESOLVER(arista.getV1(), arista.getV2(), nuevoPeso);
            grafoLimpio.anadirArista(nuevaArista);
        }
        
        // 3. Eliminar nodos de grado 0
        boolean hayCambios;
        do {
            hayCambios = false;
            Nodo_SIN_RESOLVER[] nodosActuales = grafoLimpio.listaNodos();
            for (Nodo_SIN_RESOLVER nodo : nodosActuales) {
                boolean tieneAristas = false;
                Arista_SIN_RESOLVER[] aristasActuales = grafoLimpio.listaAristas();
                for (Arista_SIN_RESOLVER arista : aristasActuales) {
                    if (arista.getV1().igual(nodo) || arista.getV2().igual(nodo)) {
                        tieneAristas = true;
                        break;
                    }
                }
                if (!tieneAristas) {
                    grafoLimpio.eliminarNodo(nodo);
                    hayCambios = true;
                }
            }
        } while (hayCambios);
        
        return grafoLimpio;
    }
} 
