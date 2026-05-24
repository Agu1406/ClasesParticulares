# Bili Store (Java + SQLite)

Proyecto de consola para practicar:

- Login y registro
- Roles `CLIENTE` y `ADMIN`
- Carrito y total de compra
- Importacion de productos desde API

## Requisitos

- Java 17+
- Maven 3.9+

## Ejecutar

```bash
mvn compile exec:java
```

## Usuario admin inicial

- usuario: `admin`
- pass: `admin123`

## Funcionalidades implementadas

### Cliente

- Ver datos personales
- Modificar password
- Ver productos
- Agregar producto al carrito
- Ver carrito (join con productos)
- Ver total compra

### Admin

- Crear usuarios (incluyendo admins)
- Modificar usuarios
- Importar productos desde `https://fakestoreapi.com/products` (solo si la tabla esta vacia)
- Vaciar tablas `carrito` y `productos`
