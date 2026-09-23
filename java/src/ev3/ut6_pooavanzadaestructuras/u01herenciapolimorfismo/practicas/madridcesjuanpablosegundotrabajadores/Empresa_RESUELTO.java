package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundotrabajadores;

import java.util.ArrayList;

public class Empresa_RESUELTO {
    private ArrayList<Trabajador_RESUELTO> trabajadores = new ArrayList<>();

    public void registrarTrabajador(Trabajador_RESUELTO trabajador) {
        for (Trabajador_RESUELTO t : trabajadores) {
            if (t.getDni().equalsIgnoreCase(trabajador.getDni())) {
                System.out.println("Ya existe un trabajador con ese DNI");
                return;
            }
        }
        trabajadores.add(trabajador);
        System.out.println("Trabajador registrado");
        trabajador.mostrarDatos();
    }

    public void listarTodos() {
        if (trabajadores.isEmpty()) {
            System.out.println("No hay trabajadores");
            return;
        }
        for (Trabajador_RESUELTO t : trabajadores) {
            t.mostrarDatos();
        }
    }

    public void listarAsalariados() {
        for (Trabajador_RESUELTO t : trabajadores) {
            if (t instanceof Asalariado_RESUELTO) {
                t.mostrarDatos();
            }
        }
    }

    public void listarAutonomos() {
        for (Trabajador_RESUELTO t : trabajadores) {
            if (t instanceof Autonomo_RESUELTO) {
                t.mostrarDatos();
            }
        }
    }

    public void mostrarPorDni(String dni) {
        for (Trabajador_RESUELTO t : trabajadores) {
            if (t.getDni().equalsIgnoreCase(dni)) {
                t.mostrarDatos();
                return;
            }
        }
        System.out.println("No se ha encontrado el trabajador");
    }

    public void despedirTrabajador(String dniJefe, String dniTrabajador) {
        Jefe_RESUELTO jefe = null;
        for (Trabajador_RESUELTO t : trabajadores) {
            if (t.getDni().equalsIgnoreCase(dniJefe) && t instanceof Jefe_RESUELTO) {
                jefe = (Jefe_RESUELTO) t;
                break;
            }
        }
        if (jefe == null) {
            System.out.println("El DNI del jefe no es correcto");
            return;
        }
        Trabajador_RESUELTO objetivo = null;
        for (Trabajador_RESUELTO t : trabajadores) {
            if (t.getDni().equalsIgnoreCase(dniTrabajador)) {
                objetivo = t;
                break;
            }
        }
        if (objetivo == null) {
            System.out.println("El trabajador no existe");
            return;
        }
        if (objetivo instanceof Jefe_RESUELTO) {
            System.out.println("No se puede despedir a un jefe con esta operacion");
            return;
        }
        trabajadores.remove(objetivo);
        System.out.println("Trabajador despedido por el jefe " + jefe.getNombre());
    }
}
