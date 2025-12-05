# Pregunta

¿Cuál es la diferencia entre git fetch y git pull? ¿Cuándo usarías uno u otro?

# Respuesta

**`git pull`:** Esto es peligroso si no se usa con cuidado, mira la rama remota, descarga todos los cambios y hace merge de los mismos con tu repositorio local, siempre se deben tener los últimos cambios en las ramas al trabajar en ellas para evitar conflictos, pero aprendí (por las malas, pero así es como mejor se aprende) que lo mejor es primero mirar los cambios antes de hacer merge de los mismos en la rama donde se esté trabajando.

**`git fetch`:** Por otra parte, esto es genial, baja los cambios en local pero no hace merge de los mismos si no que es posible verlos antes de integrarlos a nuestro trabajo local.