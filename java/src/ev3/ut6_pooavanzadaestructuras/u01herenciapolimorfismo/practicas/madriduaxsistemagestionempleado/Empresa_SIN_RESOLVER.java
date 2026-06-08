package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madriduaxsistemagestionempleado;

import java.io.Serializable;
import java.util.*;

public class Empresa_SIN_RESOLVER implements Iterable<Empleado_SIN_RESOLVER>, Serializable {
    private Map<String, List<Empleado_SIN_RESOLVER>> departamentos;

    public Empresa_SIN_RESOLVER() {
        this.departamentos = new HashMap<>();
    }

    public void agregarEmpleadoADepartamento(String departamento, Empleado_SIN_RESOLVER empleado) {
        departamentos.computeIfAbsent(departamento, k -> new ArrayList<>()).add(empleado);
    }

    public double calcularSalarioTotalDepartamento(String departamento) {
        return Optional.ofNullable(departamentos.get(departamento))
                .map(empleados -> empleados.stream()
                        .mapToDouble(Empleado_SIN_RESOLVER::calcularSalario)
                        .sum())
                .orElse(0.0);
    }

    public List<Empleado_SIN_RESOLVER> obtenerEmpleadosOrdenadosPorNombre(String departamento) {
        List<Empleado_SIN_RESOLVER> empleados = departamentos.getOrDefault(departamento, new ArrayList<>());
        empleados.sort(Comparator.comparing(Empleado_SIN_RESOLVER::getNombre));
        return empleados;
    }

    @Override
    public Iterator<Empleado_SIN_RESOLVER> iterator() {
        List<Empleado_SIN_RESOLVER> todosLosEmpleados = new ArrayList<>();
        departamentos.values().forEach(todosLosEmpleados::addAll);
        return todosLosEmpleados.iterator();
    }
} 
