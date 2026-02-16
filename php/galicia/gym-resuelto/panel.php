<?php

// PANEL MUY SENCILLO: muestra clases y reservas del usuario

session_start();

// Si no está logueado, fuera
if (!isset($_SESSION['usuario_id'])) {
    header("Location: login.html");
    exit;
}

require_once 'db.php';

$usuario_id     = $_SESSION['usuario_id'];
$usuario_nombre = $_SESSION['usuario_nombre'];

// 1. Listar todas las clases (sin cálculos de aforo para simplificar)
$sql_clases = "SELECT * FROM clases";
$resultado_clases = mysqli_query($conexion, $sql_clases);

// 2. Listar las reservas del usuario
$sql_mis_reservas = "
    SELECT clases.actividad, clases.dia_semana, clases.hora, reservas.id
    FROM reservas
    INNER JOIN clases ON reservas.clase_id = clases.id
    WHERE reservas.usuario_id = $usuario_id
";
$resultado_mis_reservas = mysqli_query($conexion, $sql_mis_reservas);

?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Panel GymFit</title>
    <link rel="stylesheet" href="estilos.css">
    <style>
        body { display: block; background: #f4f7f6; padding: 40px; }
        .container { max-width: 900px; margin: 0 auto; background: white; padding: 20px; border-radius: 10px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { padding: 8px; border-bottom: 1px solid #ddd; text-align: left; }
        th { background-color: #f0f0f0; }
    </style>
</head>
<body>
    <div class="container">
        <header style="display: flex; justify-content: space-between; align-items: center;">
            <h1>Hola, <?php echo $usuario_nombre; ?></h1>
            <a href="logout.php" style="color: red;">Cerrar Sesión</a>
        </header>

        <h2>Clases Disponibles</h2>
        <table>
            <thead>
                <tr>
                    <th>Actividad</th>
                    <th>Día</th>
                    <th>Hora</th>
                    <th>Cupo máximo</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <tbody>
            <?php while ($fila = mysqli_fetch_assoc($resultado_clases)) : ?>
                <tr>
                    <td><?php echo $fila['actividad']; ?></td>
                    <td><?php echo $fila['dia_semana']; ?></td>
                    <td><?php echo $fila['hora']; ?></td>
                    <td><?php echo $fila['cupo_maximo']; ?></td>
                    <td>
                        <a href="reserva.php?clase_id=<?php echo $fila['id']; ?>" style="color: green; font-weight: bold;">Reservar</a>
                    </td>
                </tr>
            <?php endwhile; ?>
            </tbody>
        </table>

        <h2>Mis Próximas Reservas</h2>
        <ul>
            <?php if ($resultado_mis_reservas && mysqli_num_rows($resultado_mis_reservas) > 0) : ?>
                <?php while ($res = mysqli_fetch_assoc($resultado_mis_reservas)) : ?>
                    <li>
                        <?php
                            echo $res['actividad'] . " - " .
                                 $res['dia_semana'] . " a las " .
                                 $res['hora'];
                        ?>
                        <a href="reserva.php?reserva_id=<?php echo $res['id']; ?>" style="color:gray; font-size: 0.8rem;">(Cancelar)</a>
                    </li>
                <?php endwhile; ?>
            <?php else: ?>
                <li>No tienes reservas todavía.</li>
            <?php endif; ?>
        </ul>
    </div>
</body>
</html>
