/**
 * Banco de preguntas sobre ArrayList en Java
 * Basado en e_ejerciciosarraylist
 * Cada pregunta tiene:
 * - id: identificador unico
 * - question: texto de la pregunta
 * - options: array con las 4 opciones de respuesta
 * - correct: indice de la respuesta correcta (0-3)
 * - explanation: explicacion de por que esa es la respuesta correcta
 * - code: (opcional) codigo de ejemplo si la pregunta lo requiere
 */
const questions = [
    {
        id: 1,
        question: "¿Cuál es la forma correcta de crear un ArrayList de números enteros en Java?",
        options: [
            "ArrayList<Integer> lista = new ArrayList<>();",
            "ArrayList<int> lista = new ArrayList<>();",
            "ArrayList lista = new ArrayList();",
            "ArrayList<Integer> lista = new ArrayList<Integer>();"
        ],
        correct: 0,
        explanation: "ArrayList requiere usar tipos genéricos. Para enteros usamos Integer (no int, porque ArrayList no acepta tipos primitivos). El operador <> (diamond) permite omitir el tipo en el constructor.",
        code: "import java.util.ArrayList;\nArrayList<Integer> lista = new ArrayList<>();"
    },
    {
        id: 2,
        question: "¿Cómo agregamos un elemento a un ArrayList?",
        options: [
            "lista.add(elemento);",
            "lista.addElement(elemento);",
            "lista.insert(elemento);",
            "lista[0] = elemento;"
        ],
        correct: 0,
        explanation: "El método add() agrega un elemento al final del ArrayList. A diferencia de los arrays, no necesitamos especificar el índice, el ArrayList crece automáticamente.",
        code: "ArrayList<Integer> lista = new ArrayList<>();\nlista.add(5);\nlista.add(10);\nlista.add(15);"
    },
    {
        id: 3,
        question: "Si queremos mostrar todos los elementos de un ArrayList usando un bucle for, ¿qué condición usamos?",
        options: [
            "for (int i = 0; i < lista.size(); i++)",
            "for (int i = 1; i <= lista.size(); i++)",
            "for (int i = 0; i < lista.length(); i++)",
            "for (int i = 0; i < lista.length; i++)"
        ],
        correct: 0,
        explanation: "ArrayList usa size() (no length) para obtener el número de elementos. Los índices empiezan en 0, así que el bucle va de 0 a size() - 1.",
        code: "for (int i = 0; i < lista.size(); i++) {\n    System.out.println(lista.get(i));\n}"
    },
    {
        id: 4,
        question: "¿Cómo obtenemos un elemento de un ArrayList en una posición específica?",
        options: [
            "lista.get(indice);",
            "lista[indice];",
            "lista.elementAt(indice);",
            "lista.obtener(indice);"
        ],
        correct: 0,
        explanation: "El método get(indice) devuelve el elemento en la posición especificada. A diferencia de los arrays, no podemos usar corchetes [], debemos usar get().",
        code: "ArrayList<Integer> lista = new ArrayList<>();\nlista.add(5);\nlista.add(10);\nint elemento = lista.get(0); // elemento = 5"
    },
    {
        id: 5,
        question: "Si queremos mostrar solo los números mayores que 5 en un ArrayList, ¿qué condición usamos?",
        options: [
            "if (lista.get(i) > 5)",
            "if (i > 5)",
            "if (lista.size() > 5)",
            "if (lista.get(i) < 5)"
        ],
        correct: 0,
        explanation: "Usamos lista.get(i) para obtener el elemento en la posición i, y lo comparamos con 5. Si es mayor, lo mostramos. No confundir con la posición i.",
        code: "for (int i = 0; i < lista.size(); i++) {\n    if (lista.get(i) > 5) {\n        System.out.println(lista.get(i));\n    }\n}"
    },
    {
        id: 6,
        question: "Si queremos sumar todos los elementos de un ArrayList, ¿qué hacemos dentro del bucle?",
        options: [
            "suma += lista.get(i);",
            "suma = lista.get(i);",
            "suma = suma + i;",
            "suma = lista.size();"
        ],
        correct: 0,
        explanation: "Usamos lista.get(i) para obtener cada elemento y lo acumulamos en suma con el operador +=. La variable suma debe iniciar en 0 antes del bucle.",
        code: "int suma = 0;\nfor (int i = 0; i < lista.size(); i++) {\n    suma += lista.get(i);\n}"
    },
    {
        id: 7,
        question: "Si queremos buscar el mayor elemento en un ArrayList, ¿qué estructura usamos?",
        options: [
            "Una variable mayor que inicia con lista.get(0), luego comparamos con if en un bucle",
            "Solo un bucle for",
            "Solo un if",
            "Un switch"
        ],
        correct: 0,
        explanation: "Iniciamos 'mayor' con el primer elemento (lista.get(0)). Luego, en un bucle, comparamos cada elemento con 'mayor' usando if. Si encontramos uno mayor, actualizamos 'mayor'.",
        code: "int mayor = lista.get(0);\nfor (int i = 1; i < lista.size(); i++) {\n    if (lista.get(i) > mayor) {\n        mayor = lista.get(i);\n    }\n}"
    },
    {
        id: 8,
        question: "Si queremos contar cuántos números pares hay en un ArrayList, ¿qué hacemos?",
        options: [
            "Un bucle for con un if que verifica lista.get(i) % 2 == 0",
            "Solo un bucle for",
            "Solo un if",
            "Un switch"
        ],
        correct: 0,
        explanation: "Creamos un contador que inicia en 0. En el bucle, verificamos si cada elemento es par usando lista.get(i) % 2 == 0. Si es par, incrementamos el contador.",
        code: "int contador = 0;\nfor (int i = 0; i < lista.size(); i++) {\n    if (lista.get(i) % 2 == 0) {\n        contador++;\n    }\n}"
    },
    {
        id: 9,
        question: "¿Cómo eliminamos un elemento de un ArrayList en una posición específica?",
        options: [
            "lista.remove(indice);",
            "lista.delete(indice);",
            "lista.eliminar(indice);",
            "lista[indice] = null;"
        ],
        correct: 0,
        explanation: "El método remove(indice) elimina el elemento en la posición especificada y desplaza los elementos siguientes. El ArrayList se reduce automáticamente de tamaño.",
        code: "ArrayList<Integer> lista = new ArrayList<>();\nlista.add(5);\nlista.add(10);\nlista.add(15);\nlista.remove(1); // Elimina el elemento en posición 1 (10)"
    },
    {
        id: 10,
        question: "¿Cuál es la diferencia principal entre un array y un ArrayList?",
        options: [
            "ArrayList puede crecer y reducirse dinámicamente, los arrays tienen tamaño fijo",
            "No hay diferencia",
            "ArrayList es más rápido",
            "Los arrays pueden crecer dinámicamente"
        ],
        correct: 0,
        explanation: "Los arrays tienen un tamaño fijo que se define al crearlos. ArrayList puede crecer y reducirse automáticamente cuando agregamos o eliminamos elementos. Es más flexible pero un poco más lento.",
        code: "// Array: tamaño fijo\nint[] array = new int[5];\n\n// ArrayList: tamaño dinámico\nArrayList<Integer> lista = new ArrayList<>();\nlista.add(5); // Crece automáticamente"
    },
    {
        id: 11,
        question: "¿Qué representa lista.size() en un ArrayList?",
        options: [
            "El número de elementos en el ArrayList",
            "El último índice del ArrayList",
            "El tamaño en bytes",
            "El primer elemento"
        ],
        correct: 0,
        explanation: "lista.size() devuelve el número de elementos que contiene el ArrayList. Si tiene 5 elementos, size() es 5. El último índice es size() - 1 (porque los índices empiezan en 0).",
        code: "ArrayList<Integer> lista = new ArrayList<>();\nlista.add(1);\nlista.add(2);\nlista.add(3);\n// lista.size() = 3\n// Último índice = 2"
    },
    {
        id: 12,
        question: "Si tenemos un ArrayList vacío, ¿qué valor devuelve lista.size()?",
        options: [
            "0",
            "1",
            "-1",
            "null"
        ],
        correct: 0,
        explanation: "Un ArrayList vacío tiene 0 elementos, así que size() devuelve 0. No hay elementos, por lo tanto el tamaño es 0.",
        code: "ArrayList<Integer> lista = new ArrayList<>();\n// lista.size() = 0 (vacío)"
    },
    {
        id: 13,
        question: "¿Qué sucede si intentamos hacer lista.get(lista.size())?",
        options: [
            "Error IndexOutOfBoundsException",
            "Obtiene el último elemento",
            "Obtiene el primer elemento",
            "Devuelve null"
        ],
        correct: 0,
        explanation: "lista.get(lista.size()) intenta acceder a un índice fuera del rango válido. Si size() es 5, los índices válidos son 0-4, así que el índice 5 está fuera de rango y lanza IndexOutOfBoundsException.",
        code: "ArrayList<Integer> lista = new ArrayList<>();\nlista.add(1);\nlista.add(2);\n// lista.size() = 2\n// lista.get(2) → ERROR: IndexOutOfBoundsException"
    },
    {
        id: 14,
        question: "Si queremos verificar si un ArrayList está vacío, ¿qué método usamos?",
        options: [
            "lista.isEmpty()",
            "lista.size() == 0",
            "Ambas opciones son válidas",
            "lista.empty()"
        ],
        correct: 2,
        explanation: "Ambas formas son válidas. lista.isEmpty() es más legible y expresivo, pero lista.size() == 0 también funciona. isEmpty() es el método recomendado por ser más claro.",
        code: "ArrayList<Integer> lista = new ArrayList<>();\nif (lista.isEmpty()) { // o lista.size() == 0\n    System.out.println(\"Lista vacía\");\n}"
    },
    {
        id: 15,
        question: "¿Cuál es la ventaja de usar ArrayList sobre arrays primitivos?",
        options: [
            "Tamaño dinámico, métodos útiles (add, remove, etc.), más flexible",
            "Es más rápido",
            "Ocupa menos memoria",
            "No hay ventajas"
        ],
        correct: 0,
        explanation: "ArrayList ofrece tamaño dinámico (puede crecer y reducirse), métodos útiles como add(), remove(), get(), size(), y es más flexible. Los arrays son más rápidos y ocupan menos memoria, pero tienen tamaño fijo.",
        code: "// ArrayList: flexible pero más lento\nArrayList<Integer> lista = new ArrayList<>();\nlista.add(5); // Crece automáticamente\nlista.remove(0); // Se reduce automáticamente\n\n// Array: rápido pero tamaño fijo\nint[] array = new int[10]; // Tamaño fijo"
    },
    {
        id: 16,
        question: "Si queremos agregar un elemento en una posición específica de un ArrayList, ¿qué método usamos?",
        options: [
            "lista.add(indice, elemento);",
            "lista.insert(indice, elemento);",
            "lista.set(indice, elemento);",
            "lista[indice] = elemento;"
        ],
        correct: 0,
        explanation: "El método add(indice, elemento) agrega un elemento en la posición especificada, desplazando los elementos existentes. set() reemplaza un elemento existente, no agrega uno nuevo.",
        code: "ArrayList<Integer> lista = new ArrayList<>();\nlista.add(10);\nlista.add(20);\nlista.add(1, 15); // Inserta 15 en la posición 1\n// Resultado: [10, 15, 20]"
    },
    {
        id: 17,
        question: "Si queremos reemplazar un elemento en una posición específica de un ArrayList, ¿qué método usamos?",
        options: [
            "lista.set(indice, elemento);",
            "lista.add(indice, elemento);",
            "lista.replace(indice, elemento);",
            "lista[indice] = elemento;"
        ],
        correct: 0,
        explanation: "El método set(indice, elemento) reemplaza el elemento en la posición especificada con el nuevo valor. No desplaza elementos, solo cambia el valor existente.",
        code: "ArrayList<Integer> lista = new ArrayList<>();\nlista.add(10);\nlista.add(20);\nlista.set(0, 5); // Reemplaza 10 con 5\n// Resultado: [5, 20]"
    },
    {
        id: 18,
        question: "Si queremos verificar si un ArrayList contiene un valor específico, ¿qué método usamos?",
        options: [
            "lista.contains(valor);",
            "lista.has(valor);",
            "lista.find(valor);",
            "lista.search(valor);"
        ],
        correct: 0,
        explanation: "El método contains(valor) devuelve true si el ArrayList contiene el valor especificado, false en caso contrario. Es muy útil para verificar si un elemento existe antes de hacer operaciones.",
        code: "ArrayList<Integer> lista = new ArrayList<>();\nlista.add(5);\nlista.add(10);\nboolean existe = lista.contains(10); // existe = true"
    },
    {
        id: 19,
        question: "Si queremos obtener el índice de la primera ocurrencia de un elemento en un ArrayList, ¿qué método usamos?",
        options: [
            "lista.indexOf(elemento);",
            "lista.findIndex(elemento);",
            "lista.search(elemento);",
            "lista.getIndex(elemento);"
        ],
        correct: 0,
        explanation: "El método indexOf(elemento) devuelve el índice de la primera ocurrencia del elemento. Si no lo encuentra, devuelve -1.",
        code: "ArrayList<Integer> lista = new ArrayList<>();\nlista.add(5);\nlista.add(10);\nlista.add(5);\nint indice = lista.indexOf(10); // indice = 1"
    },
    {
        id: 20,
        question: "Si queremos limpiar todos los elementos de un ArrayList, ¿qué método usamos?",
        options: [
            "lista.clear();",
            "lista.removeAll();",
            "lista.deleteAll();",
            "lista = new ArrayList<>();"
        ],
        correct: 0,
        explanation: "El método clear() elimina todos los elementos del ArrayList, dejándolo vacío. También podrías crear un nuevo ArrayList, pero clear() es más eficiente si quieres reutilizar el mismo objeto.",
        code: "ArrayList<Integer> lista = new ArrayList<>();\nlista.add(5);\nlista.add(10);\nlista.clear(); // Lista ahora está vacía\n// lista.size() = 0"
    },
    {
        id: 21,
        question: "Si queremos convertir un ArrayList a un array normal, ¿qué método usamos?",
        options: [
            "lista.toArray(new Integer[lista.size()]);",
            "lista.toArray();",
            "lista.array();",
            "No se puede hacer"
        ],
        correct: 0,
        explanation: "El método toArray() convierte el ArrayList a un array. Necesitamos pasar un array del tamaño correcto como parámetro para especificar el tipo.",
        code: "ArrayList<Integer> lista = new ArrayList<>();\nlista.add(5);\nlista.add(10);\nInteger[] array = lista.toArray(new Integer[lista.size()]);"
    },
    {
        id: 22,
        question: "Si queremos obtener una sublista de un ArrayList (por ejemplo, del índice 2 al 5), ¿qué método usamos?",
        options: [
            "lista.subList(2, 6);",
            "lista.getSubList(2, 5);",
            "lista.slice(2, 5);",
            "No se puede hacer"
        ],
        correct: 0,
        explanation: "El método subList(inicio, fin) devuelve una vista de la porción del ArrayList desde el índice inicio (inclusive) hasta fin (exclusivo). Nota: fin es exclusivo, así que para obtener hasta el índice 5, usamos 6.",
        code: "ArrayList<Integer> lista = new ArrayList<>();\n// ... llenar lista ...\nList<Integer> sublista = lista.subList(2, 6); // Índices 2, 3, 4, 5"
    },
    {
        id: 23,
        question: "Si queremos verificar si dos ArrayLists tienen los mismos elementos, ¿qué método usamos?",
        options: [
            "lista1.equals(lista2);",
            "lista1 == lista2;",
            "lista1.compare(lista2);",
            "lista1.same(lista2);"
        ],
        correct: 0,
        explanation: "El método equals() compara si dos ArrayLists tienen los mismos elementos en el mismo orden. El operador == solo compara si son el mismo objeto, no si tienen el mismo contenido.",
        code: "ArrayList<Integer> lista1 = new ArrayList<>();\nlista1.add(5);\nArrayList<Integer> lista2 = new ArrayList<>();\nlista2.add(5);\nboolean iguales = lista1.equals(lista2); // iguales = true"
    },
    {
        id: 24,
        question: "Si queremos copiar todos los elementos de un ArrayList a otro, ¿qué método usamos?",
        options: [
            "lista2.addAll(lista1); o lista2 = new ArrayList<>(lista1);",
            "lista2 = lista1;",
            "lista2.copy(lista1);",
            "No se puede hacer"
        ],
        correct: 0,
        explanation: "Podemos usar addAll() para agregar todos los elementos de lista1 a lista2, o crear un nuevo ArrayList pasando lista1 al constructor. lista2 = lista1 solo copia la referencia, no los elementos.",
        code: "ArrayList<Integer> lista1 = new ArrayList<>();\nlista1.add(5);\nlista1.add(10);\n// Opción 1:\nArrayList<Integer> lista2 = new ArrayList<>(lista1);\n// Opción 2:\nArrayList<Integer> lista3 = new ArrayList<>();\nlista3.addAll(lista1);"
    },
    {
        id: 25,
        question: "Si queremos eliminar todos los elementos que cumplan una condición específica de un ArrayList, ¿qué estructura usamos?",
        options: [
            "Un bucle que recorre el ArrayList y usa remove() para los elementos que cumplan la condición",
            "Solo un if",
            "Solo un bucle for",
            "No se puede hacer"
        ],
        correct: 0,
        explanation: "Recorremos el ArrayList con un bucle (preferiblemente desde el final hacia el inicio para evitar problemas de índices). Verificamos cada elemento con if, y si cumple la condición, lo eliminamos con remove().",
        code: "// Recorrer desde el final hacia el inicio evita problemas\nfor (int i = lista.size() - 1; i >= 0; i--) {\n    if (lista.get(i) < 5) { // Condición\n        lista.remove(i);\n    }\n}"
    }
];

