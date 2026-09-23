package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundofiguras;

import java.util.ArrayList;

public class GestorFiguras_RESUELTO {
    private ArrayList<Figura_RESUELTO> figuras = new ArrayList<>();

    public void registrarFigura(Figura_RESUELTO figura) {
        figuras.add(figura);
        System.out.println("Figura registrada");
        figura.mostrarDatos();
    }

    public void listarFiguras() {
        if (figuras.isEmpty()) {
            System.out.println("No hay figuras registradas");
            return;
        }
        for (Figura_RESUELTO f : figuras) {
            f.mostrarDatos();
        }
    }

    public double areaTotal() {
        double total = 0;
        for (Figura_RESUELTO f : figuras) {
            total += f.calcularArea();
        }
        return total;
    }
}
