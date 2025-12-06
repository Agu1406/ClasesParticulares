@echo off
echo ========================================
echo Organizador de Capturas para Practica 2
echo ========================================
echo.

REM Crear estructura de carpetas para capturas
if not exist "capturas" mkdir capturas
if not exist "capturas\punto1" mkdir capturas\punto1
if not exist "capturas\punto2" mkdir capturas\punto2
if not exist "capturas\punto3" mkdir capturas\punto3
if not exist "capturas\punto4" mkdir capturas\punto4

echo Estructura de carpetas creada:
echo   capturas\punto1\
echo   capturas\punto2\
echo   capturas\punto3\
echo   capturas\punto4\
echo.
echo Ahora puedes copiar tus capturas de pantalla en las carpetas correspondientes.
echo.
echo Nombres sugeridos para las capturas:
echo.
echo PUNTO 1:
echo   - alta_producto.png
echo   - listado_productos.png
echo   - gestion_stock.png
echo.
echo PUNTO 2:
echo   - busqueda_productos.png
echo   - listado_paginado.png
echo   - detalle_producto.png
echo   - busqueda_ajax.png
echo.
echo PUNTO 3:
echo   - carrito_compra.png
echo   - modificar_cantidad.png
echo   - checkout.png
echo   - gestion_pedidos.png
echo   - detalle_pedido.png
echo.
echo PUNTO 4:
echo   - modulo_paypal.png
echo   - configuracion_paypal.png
echo   - credenciales_api.png
echo   - modulo_recargo.png
echo.
pause

