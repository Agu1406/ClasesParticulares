# Gestion empresarial — UMBRELLA CORP

IES Arquitecto Ventura Rodriguez (Madrid). UT7 — Herencia y polimorfismo.

## Objetivo

Crear un programa en consola que gestione los empleados de la empresa **UMBRELLA CORP**: alta, busqueda, borrado, subida de sueldo y calculo de nomina mensual.

Debes usar **herencia** (`Persona` → `Empleado`), una **interfaz** (`Contratable`), una **excepcion propia** (`GestionEmpresarialException extends Exception`) y **polimorfismo** (lista de `Persona` tratando empleados como `Contratable`).

## Clases a implementar

| Clase | Descripcion |
|-------|-------------|
| `ClaseDNI` | Validar NIF, calcular letra y formatear DNI |
| `Persona` | Clase abstracta: nombre, apellido, DNI, fecha nacimiento |
| `Contratable` | Interfaz: codigo, departamento, sueldo, nomina, subir salario |
| `Empleado` | Hereda de `Persona` e implementa `Contratable` |
| `GestionEmpresarialException` | Excepcion comprobada de reglas de negocio |
| `MainEmpleado` | Menu principal y carga de datos iniciales |

## Menu (opciones 1 a 8)

1. Mostrar todos los empleados (formato reducido) y nomina mensual total.
2. Dar de alta un empleado (DNI, nombre, apellido, departamento, sueldo, fechas).
3. Buscar empleado por codigo (UMBRE0001, UMBRE0002…).
4. Listar empleados de un departamento.
5. Borrar empleado por codigo.
6. Subir sueldo por DNI (porcentaje entre 0 y 50).
7. Mostrar sueldo mensual de un empleado (sueldo base + bonos).
8. Salir.

## Datos iniciales

Al arrancar, cargar 9 empleados de prueba (DNI, nombre, apellido, departamento, sueldo anual, fecha contrato, fecha nacimiento) con formato `dd/MM/yyyy`.

## Reglas de validacion

- DNI valido segun letra de control.
- Sueldo y porcentajes no negativos; porcentaje de subida maximo 50 %.
- Fecha de nacimiento anterior a fecha de contrato.
- Capturar `GestionEmpresarialException` en alta y subida de sueldo.

## Entrega

Completar las clases `*_SIN_RESOLVER`. Solucion docente en `*_RESUELTO`.
