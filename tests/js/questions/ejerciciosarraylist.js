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
    }
];

