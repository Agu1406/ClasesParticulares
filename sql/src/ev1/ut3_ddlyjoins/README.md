# UT3 — DDL, GROUP BY y JOIN (XAMPP)

## Ritual XAMPP

1. Panel XAMPP: Start **MySQL** (Apache opcional para phpMyAdmin).
2. Importar tienda:
   ```text
   C:\xampp\mysql\bin\mysql.exe -u root < _bd\tienda_ut3.sql
   ```
   o phpMyAdmin → Importar.
3. Cliente: CLI, phpMyAdmin (`http://localhost/phpmyadmin`) o extension VS Code/MySQL.

## Orden de clase

1. **u01ddlbasico** — CREATE DATABASE/TABLE, tipos, PK (practica `academia`)
2. **u02restriccionesyclaves** — NOT NULL/UNIQUE/FK/ALTER
3. **u03groupbyhaving** — GROUP BY / HAVING sobre `tienda`
4. **u04innerjoin** — INNER JOIN 2–3 tablas + Galicia INNER
5. **u05outerjoin** — LEFT JOIN + JOIN/GROUP BY + Galicia OUTER

## Extras

- `practicas/madridaccess/` — Access Neptuno (no MySQL)
- Galicia JOIN en u04/u05 `practicas/galicia*`

## Checklist

- [ ] MySQL XAMPP en verde
- [ ] `USE tienda; SHOW TABLES;` OK
- [ ] Academia creada en practicas DDL
- [ ] Alumno hace INNER JOIN de pedidos-clientes-productos
