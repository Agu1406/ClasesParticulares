<!--
OBJETIVO: Definir SGBD y situar sus funciones basicas (sin administrar motores).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Que es un SGBD

**SGBD** = Sistema Gestor de Bases de Datos (MySQL, MariaDB, PostgreSQL, Oracle...).

## Funciones (vista de pajaro)

| Funcion | En clase lo veras como... |
|---------|---------------------------|
| Almacenar / recuperar | `SELECT` / `INSERT` |
| Integridad | PK, FK, NOT NULL |
| Concurrencia | varios usuarios a la vez |
| Seguridad | usuarios y permisos (mas adelante) |
| Recuperacion | backups (centro / admin) |

## Arquitectura mental ANSI/SPARC (muy breve)

- **Externo:** lo que ve cada usuario/aplicacion (vistas).
- **Conceptual:** el modelo logico global (tablas y relaciones).
- **Interno:** como se guarda en disco (indices, ficheros).

No hace falta administrar Oracle hoy: basta saber que el SGBD separa **que datos hay** de **como se guardan**.

## Prueba tu

Con `tienda` abierta: quien decide que `id_cliente` en `pedidos` debe existir en `clientes`? (Respuesta: el SGBD si hay FK.)
