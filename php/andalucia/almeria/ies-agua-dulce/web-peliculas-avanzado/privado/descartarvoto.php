<?php
require_once "accesoareaprivada.php";

$descartado = isset($_SESSION['voto_en_curso']);
unset($_SESSION['voto_en_curso']);
unset($_SESSION['voto_form']);

?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=100%, initial-scale=1.0">
    <title>Proceso de votación</title>
</head>

<body>
    <h1>DWES 03. AUTOR: RAFAEL MORONES BURGOS.</h1>
    <h1>Proceso de votación</h1>
    <?php if ($descartado): ?>
        <p>Votación descartada.</p>
    <?php else: ?>
        <p>No había votación en curso.</p>
    <?php endif; ?>
    <p><a href="../index/index.php">Volver al listado</a></p>
</body>

</html>