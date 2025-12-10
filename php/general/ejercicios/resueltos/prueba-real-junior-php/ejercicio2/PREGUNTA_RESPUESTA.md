# Pregunta

Explica la diferencia entre include, require, include_once y require_once en PHP. ¿Cuándo usarías cada uno?

# Respuesta

Antes de la respuesta me gustaría explicar que una de las diferencias principales entre ellos es el tipo de error nativo de PHP que ocasionan (no son excepciones, son errores), siendo estos los siguientes en la tabla:

| MÉTODO | ERRORES DE PHP | COMPORTAMIENTO |
|--------|----------------|----------------|
| include / include_once | E_WARNING | Advertencia de "error", pero continúa |
| require / require_once | E_ERROR | Detiene el script en seco |

Sabiendo esto enlisto la respuesta de las diferencias entre cada uno:

**include:** Permite incluir una o varias veces un archivo en el código, ¿En que escenarios es deseable poder incluir algo más de una vez? Por ejemplo, cuando el fichero sufre cambios o modificaciones durante el uso de la aplicación y se debe poder recargar/cargar otra vez con estos cambios, EJEMPLO DE USO REAL: Con mis alumnos diseño normalmente aplicaciones pequeñas con MVC como parte de sus asignaturas y es muy común usar include cuando por ejemplo mostramos una información inicial de un pedido, la aplicación modifica el estado del pedido y el include incluye otra vez el mismo archivo reflejando los cambios, sin embargo, hay otras formas de hacer esto y normalmente no lo suelo utilizar, para logs lo he utilizado alguna vez, pero de nuevo, hay otras formas.

**require:** Aquí la diferencia es el comportamiento cuando aquel archivo que se intenta cargar/renderizar no exista, no nos lanza una advertencia cómo include con E_WARNING y sigue ejecutando los scripts de todas formas si no que "mata el script" acabando con el flujo de la aplicación en seco, crítico para la carga de archivos esenciales, como conexiones a base de datos, archivos de configuración críticos, más allá de eso, tiene una serie de usos algo limitados porque son pocos los escenarios donde requieres más de una vez un archivo.

**include_once:** El comportamiento es idéntico al del include normal previamente explicado pero no permite incluir/cargar/renderizar varias veces el mismo archivo/script, como se utiliza para la carga de componentes/script no esenciales es común verlo sobretodo en la carga de temas personalizados, header, footer, EJEMPLO REAL DE USO: En aquellos proyectos que he realizado estudiando o con mis alumnos cuando hacemos aplicaciones MVC suelo explicar su funcionamiento al intentar cargar un banner publicitario que si existe, se carga y si no, aunque nos arroja un error del tipo E_WARNING el script no se tiene y renderiza todo lo demás.

**require_once:** El contexto de las explicaciones anteriores sirve para entender que hace lo mismo que el require pero solo incluye/renderiza una vez, este se usa en aquellos escenarios donde nos planteamos la pregunta de "¿Esto existe y ha sido cargado? Si la respuesta es no, deten todo, es crítico que esté disponible para el funcionamiento de la aplicación", EJEMPLO REAL DE USO: Para aquellos scripts donde es obligatorio, crítico y fundamental importar DTO o conexiones a bases de datos.

Como valor añadido dejo una pequeña tabla que explica el tipo de retorno (si es que tiene) de los 4 casos de uso anteriormente explicados:

| MÉTODO | ESCENARIO | RETORNO EN FALLO | RETORNO EN ÉXITO |
|--------|-----------|------------------|------------------|
| include | Función con return | FALSE | El valor del return |
| include | Función sin return | FALSE | Código de éxito (int) "1" |
| include_once | Función con return | FALSE | El valor del return |
| include_once | Función sin return | FALSE | Código de éxito (int) "1" |
| require | Función con return | NADA (detiene el script) | El valor del return |
| require | Función sin return | NADA (detiene el script) | Código de éxito (int) "1" |
| require_once | Función con return | NADA (detiene el script) | El valor del return |
| require_once | Función sin return | NADA (detiene el script) | Código de éxito (int) "1" |

