package diagnostico.ejercicios.pendientes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Transferencia transaccional en memoria
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa que transfiera dinero entre cuentas en memoria con integridad.</li>
 * <li>Define CuentaDao con crear, transferir y consultar.</li>
 * <li>transferir debe devolver false si no hay saldo suficiente (sin modificar saldos en ese caso).</li>
 * <li>En el main, lee ids, saldos iniciales e importe con Scanner teclado. Ejecuta la transferencia e imprime saldos.</li>
 * </ul>
 *
 * <p>Diagnostico 38 — EV3 · ut7_persistenciajdbcapi · RA9.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico38_TransaccionMemoria_SIN_RESOLVER {

    // TODO: CuentaDao con transferir(origen, destino, importe); rollback si saldo insuficiente

    static class CuentaDao {
        // TODO
    }
    public static void main(String[] args) {
        Scanner teclado;
        CuentaDao dao;
        int idOrigen;
        int idDestino;
        double saldoOrigen;
        double saldoDestino;
        double importe;
        boolean exito;
        teclado = new Scanner(System.in);
        System.out.print("Id cuenta origen: ");
        idOrigen = teclado.nextInt();
        System.out.print("Saldo inicial origen: ");
        saldoOrigen = teclado.nextDouble();
        System.out.print("Id cuenta destino: ");
        idDestino = teclado.nextInt();
        System.out.print("Saldo inicial destino: ");
        saldoDestino = teclado.nextDouble();
        System.out.print("Importe a transferir: ");
        importe = teclado.nextDouble();
        // TODO: crear cuentas, transferir y mostrar saldos
        dao = new CuentaDao();
        dao.crear(idOrigen, saldoOrigen);
        dao.crear(idDestino, saldoDestino);
        exito = dao.transferir(idOrigen, idDestino, importe);
        System.out.println("Transferencia: " + exito);
        System.out.println("Saldo origen: " + dao.consultar(idOrigen));
        System.out.println("Saldo destino: " + dao.consultar(idDestino));
        teclado.close();
    }
}
