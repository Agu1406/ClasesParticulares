# Repositorio de Clases Particulares - Java

## Objetivo del Proyecto

Este repositorio contiene una amplia colección de ejercicios, ejemplos y proyectos de Java desarrollados durante mis clases particulares. Es una "win-win situation": gano dinero, refuerzo mis conocimientos, aprendo cosas nuevas, ayudo a otros, contribuyo a una amplia comunidad de desarrolladores, hago networking con ellos quienes luego gracias a las buenas impresiones dejadas me recomiendan para puestos de trabajo interesantes y sigo alimentando mi sueño de crear una amplia biblioteca de recursos reutilizables para que otros profesores y estudiantes puedan usar.

### Agradecimientos Especiales

Tengo que darle un agradecimiento muy especial a mis dos profesores más importantes en el desarrollo y diseño de software, los cuales son **Jaime García Martin Cuerva** y **Mercedes Urios de las Heras**, ellos me enseñaron a querer y amar esto que hago, buenas prácticas, arquitecturas, patrones, buenas prácticas, etc. Siempre les recordaré con mucho cariño.

---

## Índice

### Estructura del Proyecto
- [Andalucía](#andalucía)
  - [Almería](#almería)
  - [Sevilla](#sevilla)
- [Castilla y León](#castilla-y-león)
  - [Salamanca](#salamanca)
  - [Valladolid](#valladolid)
- [Galicia](#galicia)
  - [Santiago de Compostela](#santiago-de-compostela)
- [Madrid](#madrid)
  - [CES Juan Pablo Segundo](#ces-juan-pablo-segundo)
  - [IES Calderón Barca](#ies-calderón-barca)
  - [IES Canaveral](#ies-canaveral)
  - [UAX](#uax)
- [Valencia](#valencia)
  - [Alicante - UA](#alicante---ua)
- [General](#general)

### Información Adicional
- [Tecnologías y Conceptos Cubiertos](#tecnologías-y-conceptos-cubiertos)
- [Convenciones de Nomenclatura](#convenciones-de-nomenclatura)
- [Cómo Usar Este Repositorio](#cómo-usar-este-repositorio)
- [Requisitos y Dependencias](#requisitos-y-dependencias)
- [Contacto](#contacto)
- [Licencia](#licencia)

---

## Estructura del Proyecto

El proyecto está organizado por **regiones geográficas** y **centros educativos**, facilitando la navegación y localización de ejercicios específicos.

### Andalucía

#### Almería
- **IES Aguadulce**
  - `calculadorajavafx/` - Calculadora con JavaFX
    - `Calculadora.java` - Aplicación de calculadora con interfaz gráfica que permite realizar operaciones aritméticas básicas y expresiones combinadas
    - `calculadora.css` - Estilos CSS para la interfaz
    - `logoCalcu.png` - Logo de la calculadora
    - **Requisitos**: JavaFX SDK, exp4j library

#### Sevilla
- **IES Velázquez**
  - `barberomultihilo/` - Problema del barbero dormilón (multihilo)
    - Implementación del clásico problema de sincronización con Threads
    - `Barbero.java`, `BarberShop.java`, `Cliente.java`, `Main.java`
    - **Conceptos**: Threads, synchronized, wait/notify, sincronización
  - `colegiojdbc/` - Proyecto JDBC con MySQL
    - `src/` - Clases principales
      - `Alumno.java` - Modelo POJO
      - `AlumnosDAO.java` - Data Access Object con operaciones CRUD completas
      - `ColegioConnection.java` - Gestión de conexiones a base de datos
      - `ColegioDemo.java` - Demostración CRUD y transacciones
      - `ColegioFactoryForServer.java` - Factory para conexiones sin base de datos
      - `ColegioSetup.java` - Configuración de BD y tablas
      - `SqlExceptionUtil.java` - Utilidades para excepciones SQL
    - `sql/colegio.sql` - Script SQL para crear la base de datos
    - `README.md` - Documentación específica del proyecto
    - **Requisitos**: MySQL Connector/J, MySQL Server o XAMPP
  - `tallermecanico/` - Simulación de taller mecánico multihilo
    - Simulación de un taller con mecánico y múltiples coches usando programación concurrente
    - `Coche.java`, `Main.java`, `Mecanico.java`, `TallerMecanico.java`
    - **Conceptos**: Multihilo, sincronización, colas

---

### Castilla y León

#### Salamanca
- **Colegio Salesiano**
  - `ControlHabitantesEdificio.java` - Sistema de control de habitantes de un edificio

#### Valladolid
- **IES Gregorio Fernández**
  - `aplicacion_bancaria/` - Aplicación web bancaria (JSP/Servlets)
    - Aplicación web completa con gestión de clientes, cuentas y préstamos
    - `Controladores/` - Servlets
      - `ClienteServlet.java` - Gestión de clientes y autenticación
      - `CuentaServlet.java` - Gestión de cuentas bancarias
      - `PrestamoServlet.java` - Gestión de préstamos
    - `Modelos/` - Modelos de datos
      - `Cliente.java`, `Cuenta.java`, `Prestamo.java`
    - `webapp/` - Archivos JSP
      - `Acceso.jsp`, `Cuentas.jsp`, `index.jsp`, `Mensaje.jsp`, `Prestamo.jsp`, `Registro.jsp`
    - **Requisitos**: Servidor de aplicaciones (Tomcat), Jakarta EE o Java EE
  - `aplicacion_ecommerce/` - Aplicación e-commerce (JSP/Servlets)
    - Sistema de compra online con gestión de productos y cesta
    - `Controladores/ServletController.java` - Controlador principal con múltiples acciones
    - `Modelos/Producto.java` - Modelo de producto
    - **Requisitos**: Servidor de aplicaciones (Tomcat), Jakarta EE o Java EE

---

### Galicia

#### Santiago de Compostela
- **USC (Universidad de Santiago de Compostela)**
  - `documentos/` - Material teórico en PDF
    - `1Encapsulacion.pdf`, `2ClasesTiposDatos.pdf`, `3ConjuntosDatos.pdf`
    - `4Herencia.pdf`, `5Polimorfismo.pdf`, `6Interfaces.pdf`, `7.Excepciones.pdf`
    - `EJEMPLOEXAMEN.pdf`

---

### Madrid

#### CES Juan Pablo Segundo
- `Bingo.java`, `BingoSimple.java` - Juegos de bingo con arrays bidimensionales
- `EjercicioArrayList.java`, `EjercicioHashMap.java` - Ejercicios prácticos con colecciones
- `EX_T5/` - Examen tipo 5: Sistema de restaurante
  - `Cliente.java`, `Main.java`, `Pedido.java`, `Producto.java`, `Restaurante.java`
- `examen1evaluacion/` - Ejercicios de examen de primera evaluación
  - `GestionAlmacen.java`, `GestionAlumnos.java`, `GestionAlumnosClase.java`
  - `GestionArrayMultidimensional.java`, `SorteoMundial.java`
- `documentos/` - PDFs de exámenes

#### IES Calderón Barca
- `documentos/` - Material de ejercicios en PDF
  - Ejercicios de arrays, funciones, strings, etc.

#### IES Canaveral
- `ejercicios/convocatoria2022/` - Ejercicios de convocatoria 2022
  - **Ejercicios base** (16 archivos):
    - `Ejercicio1_DoWhileInicializacion.java` - Inicialización de variables en do-while
    - `Ejercicio2_HerenciaYPolimorfismo.java` - Herencia y polimorfismo
    - `Ejercicio3_InicializacionVariables.java` - Inicialización de variables
    - `Ejercicio4_BloquesStatic.java` - Bloques estáticos
    - `Ejercicio5_EnumBasico.java` - Enumeraciones básicas
    - `Ejercicio6_BuclesAnidados.java` - Bucles anidados
    - `Ejercicio7_AsignacionVsComparacion.java` - Diferencia entre = y ==
    - `Ejercicio8_ComparacionObjetos.java` - Comparación de objetos
    - `Ejercicio9_HerenciaConstructores.java` - Constructores en herencia
    - `Ejercicio10_ArraysBoolean.java` - Arrays de booleanos
    - `Ejercicio11_VariablesEstaticas.java` - Variables estáticas
    - `Ejercicio12_OperadoresIncremento.java` - Operadores de incremento
    - `Ejercicio13_Recursion.java` - Recursión
    - `Ejercicio14_ManejoExcepciones.java` - Manejo de excepciones
    - `Ejercicio15_PasoParametros.java` - Paso de parámetros
    - `Ejercicio16_HerenciaPolimorfismo.java` - Herencia y polimorfismo avanzado
  - `resueltos/` - Soluciones de los ejercicios (16 archivos)
  - `documentos/` - PDFs de exámenes

#### UAX (Universidad Alfonso X el Sabio)
- `estructuradatos/` - Estructuras de datos
  - `feedback_final_estructura_datos/Soluciones.java` - Soluciones del feedback final
    - Incluye análisis de complejidad, ordenación, comparadores, TreeSet, listas enlazadas y árboles
  - `sistema_grafo_arista/` - Sistema de grafos
    - `Arista.java`, `Grafo.java`, `Nodo.java`
    - Implementación de grafo con operaciones de limpieza
  - `sistema_tabla_hash/TablaHash.java` - Implementación de tabla hash
  - `documentos/` - PDFs de feedbacks y teoría
- `tecnicasprogramacion/` - Técnicas de programación
  - `sistema_gestion_banco/` - Sistema de gestión bancaria
    - `CuentaBancaria.java`, `Main.java`, `SaldoInsufienteException.java`
    - Gestión de cuentas bancarias con excepciones personalizadas
  - `sistema_gestion_biblioteca/` - Sistema de gestión de biblioteca
    - Sistema completo con libros físicos y digitales, usuarios y reservas
    - `Biblioteca.java`, `Clonable.java`, `Imprimible.java`
    - `Libro.java`, `LibroDigital.java`, `LibroFisico.java`
    - `Main.java`, `Reserva.java`, `SistemaBiblioteca.java`, `Usuario.java`
    - **Conceptos**: Interfaces, herencia, clonación
  - `sistema_gestion_empleado/` - Sistema de gestión de empleados
    - Sistema con diferentes tipos de empleados y patrón Factory
    - `Calculable.java`, `Empleado.java`
    - `EmpleadoAsalariado.java`, `EmpleadoAsalariadoFactory.java`
    - `EmpleadoFactory.java`, `EmpleadoPorHoras.java`, `EmpleadoPorHorasFactory.java`
    - `Empresa.java`, `Main.java`, `PersistenciaEmpleados.java`
    - `SalarioInvalidoException.java`, `TarifaExcesivaException.java`
    - **Conceptos**: Patrón Factory, herencia, interfaces, excepciones personalizadas
  - `sistema_juego_ajedrez/` - Sistema de juego de ajedrez
    - `Main.java` - Menú principal interactivo
    - `ejercicio1/` - Ejercicio 1: Implementación de Pila
      - `Pila.java`, `PruebaPila.java`
    - `ejercicio3/` - Ejercicio 3: Piezas de ajedrez
      - `PartidaAjedrez.java`, `Peon.java`, `Pieza.java`
      - `PiezaSimulada.java`, `PruebaAjedrez.java`, `Torre.java`
      - **Conceptos**: Herencia, polimorfismo, estructuras de datos
  - `documentos/` - PDFs de teoría

---

### Valencia

#### Alicante - UA (Universidad de Alicante)
- `visorimagenesl04/` - Visor de imágenes (Proyecto L04)
  - Aplicación completa de procesamiento de imágenes con múltiples filtros
  - `filtros/` - Filtros de imagen (12 clases)
    - `DarkerFilter.java`, `EdgeFilter.java`, `Filter.java`
    - `FishEyeFilter.java`, `GrayScaleFilter.java`, `InvertFilter.java`
    - `LighterFilter.java`, `MirrorFilter.java`, `PixelizeFilter.java`
    - `SmoothFilter.java`, `SolarizeFilter.java`, `ThresholdFilter.java`
  - `imagen/` - Gestión de imágenes
    - `ImageFileManager.java`, `OFImage.java`
  - `interfaz/` - Interfaz gráfica
    - `ImagePanel.java`, `ImageViewer.java`
  - `menuFicheros/Demo.java` - Demo del visor
  - `documentos/` - PDFs de teoría (L02, L03, L04)
  - **Requisitos**: Java Swing

---

### General

Carpeta con ejercicios generales organizados por temas:

- `01-basicos/` - Ejercicios básicos (10 ejercicios)
  - Operaciones aritméticas, variables, tipos de datos
- `02-bucles-y-condicionales/` - Bucles y condicionales (10 ejercicios)
  - For, while, do-while, if-else, switch
- `04-strings/` - Manejo de strings (11 ejercicios + resueltos)
  - Concatenación, métodos de String, StringBuilder
- `05-funciones/` - Funciones y métodos (10 ejercicios)
  - Definición de métodos, parámetros, retorno
- `06-arrays/` - Arrays unidimensionales y bidimensionales (13 ejercicios + resueltos)
  - Declaración, inicialización, recorrido, búsqueda
- `07-arraylist/` - ArrayList (10 ejercicios)
  - Operaciones con ArrayList, métodos principales
- `08-ejercicios-conocidos/` - Ejercicios clásicos (12 ejercicios)
  - Fibonacci, factorial, números primos, etc.
- `documentos/` - Material teórico en PDF (19 archivos)

---

## Tecnologías y Conceptos Cubiertos

### Fundamentos de Java
- Variables, tipos de datos, operadores
- Bucles (for, while, do-while)
- Condicionales (if, else, switch)
- Funciones y métodos
- Arrays y ArrayList
- Strings y StringBuilder

### Programación Orientada a Objetos (POO)
- Clases y objetos
- Encapsulación
- Herencia
- Polimorfismo
- Interfaces
- Excepciones

### Estructuras de Datos
- Arrays unidimensionales y bidimensionales
- ArrayList, HashMap, TreeSet
- Pilas (Stack)
- Grafos
- Tablas hash

### Programación Avanzada
- Multihilo (Threads, Runnable, synchronized)
- JDBC y bases de datos (MySQL)
- Servlets y JSP (Java EE / Jakarta EE)
- JavaFX (interfaz gráfica)
- Patrones de diseño (Factory, DAO)

### Algoritmos
- Ordenación (Inserción Directa, Quicksort)
- Búsqueda
- Recursión
- Complejidad algorítmica (Big O)

---

## Convenciones de Nomenclatura

- **Packages**: Siguen la estructura de directorios (ej: `madrid.uax.tecnicasprogramacion.sistema_gestion_biblioteca`)
- **Clases**: PascalCase (ej: `Ejercicio1_DoWhileInicializacion`)
- **Métodos y variables**: camelCase (ej: `obtenerPorId`)
- **Constantes**: UPPER_SNAKE_CASE (ej: `CAPACIDAD_APARCAMIENTO`)

---

## Cómo Usar Este Repositorio

1. **Navegar por regiones**: Busca ejercicios por región geográfica y centro educativo
2. **Buscar por tema**: Usa la estructura de `general/` para encontrar ejercicios por concepto específico
3. **Estudiar soluciones**: Muchos ejercicios tienen versiones resueltas en carpetas `resueltos/` para comparar tu solución
4. **Revisar documentación**: Cada proyecto puede tener su propio README o documentación en PDF en la carpeta `documentos/`
5. **Compilar y ejecutar**: La mayoría de ejercicios son independientes y pueden compilarse directamente con `javac` y ejecutarse con `java`

---

## Requisitos y Dependencias

### Para la mayoría de ejercicios
- **Java JDK 8 o superior**
- Editor de código o IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Para proyectos específicos
- **JavaFX**: Requerido para `calculadorajavafx/`
  - JavaFX SDK o dependencia Maven/Gradle
- **MySQL**: Requerido para `colegiojdbc/`
  - MySQL Server o XAMPP
  - MySQL Connector/J
- **Servidor de aplicaciones**: Requerido para proyectos JSP/Servlets
  - Apache Tomcat 9+ (para Jakarta EE)
  - Apache Tomcat 8 (para Java EE)
  - Dependencias: `javax.servlet` o `jakarta.servlet`
- **exp4j**: Requerido para la calculadora JavaFX
  - Biblioteca para evaluación de expresiones matemáticas

---

## Contacto

- **Email**: agu1406@outlook.es
- **GitHub**: [Agu1406/ClasesParticulares](https://github.com/Agu1406/ClasesParticulares)
- **GitHub Pages**: [agu1406.github.io/ClasesParticulares](https://agu1406.github.io/ClasesParticulares)

---

## Licencia

Este repositorio está destinado a fines educativos. Siéntete libre de usar, modificar y compartir estos recursos para aprender y enseñar.

---

**Última actualización**: Enero 2026
