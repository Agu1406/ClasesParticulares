# ClasesJavaSwing

Ejercicios de Swing con dos variantes: código manual y versión estilo "Form" (GroupLayout) compatible con NetBeans.

## Cómo ejecutar

- Ejercicio 1 (manual): `com.agu1406.clasesjavaswing.ej1.VentanaPrincipal`
- Ejercicio 2 (manual): `com.agu1406.clasesjavaswing.ej2.PantallaPrincipal`
- Ejercicio 1 (Form): `com.agu1406.clasesjavaswing.ej1form.VentanaPrincipalForm`
- Ejercicio 2 (Form): `com.agu1406.clasesjavaswing.ej2form.PantallaPrincipalForm`

En NetBeans: botón derecho sobre la clase > Run File. En IntelliJ: click en el `main` de la clase y Run.

## Paso de datos entre ventanas

`PantallaSecundaria`/`PantallaSecundariaForm` son diálogos modales que reciben como owner a la principal. Al pulsar "Volver" llaman a `actualizarSaludo(nombre)` en la principal y luego `dispose()`.


