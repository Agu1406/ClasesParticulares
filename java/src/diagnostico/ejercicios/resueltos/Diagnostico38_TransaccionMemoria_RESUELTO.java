package diagnostico.ejercicios.resueltos;

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
public class Diagnostico38_TransaccionMemoria_RESUELTO {

    static class CuentaDao {
        private final Map<Integer, Double> saldos;

        public CuentaDao() {
            saldos = new HashMap<>();
        }

        public void crear(int id, double saldo) {
            saldos.put(id, saldo);
        }

        public boolean transferir(int origen, int destino, double importe) {
            double saldoOrigen;
            saldoOrigen = saldos.getOrDefault(origen, 0.0);
            if (saldoOrigen < importe) {
                return false;
            }
            saldos.put(origen, saldoOrigen - importe);
            saldos.put(destino, saldos.getOrDefault(destino, 0.0) + importe);
            return true;
        }

        public double consultar(int id) {
            return saldos.getOrDefault(id, 0.0);
        }
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
