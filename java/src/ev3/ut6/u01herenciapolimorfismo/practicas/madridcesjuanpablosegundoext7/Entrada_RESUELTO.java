package ev3.ut6.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundoext7;

import java.util.Random;

public class Entrada_RESUELTO {
    public static void main(String[] args) {
        Almacen_RESUELTO almacen = new Almacen_RESUELTO(4);
        Tienda_RESUELTO tienda = new Tienda_RESUELTO(almacen);

        BicicletaMTB_RESUELTO bici1 = new BicicletaMTB_RESUELTO(21, 27, 15, "M", true, 500, "MTB");
        BicicletaPaseo_RESUELTO bici2 = new BicicletaPaseo_RESUELTO(3, 26, 12, "S", true, 300, "paseo");
        BicicletaCarretera_RESUELTO bici3 = new BicicletaCarretera_RESUELTO(10, 28, 9, "L", true, 700, "carretera");
        BicicletaMTB_RESUELTO bici4 = new BicicletaMTB_RESUELTO(18, 26, 14, "S", true, 450, "MTB");
        BicicletaPaseo_RESUELTO bici5 = new BicicletaPaseo_RESUELTO(5, 24, 11, "M", true, 320, "paseo");

        try {
            tienda.agregarBici(bici1);
        } catch (SinPlazasException_RESUELTO e) {
            System.out.println(e.getMessage());
        }

        try {
            tienda.agregarBici(bici2);
        } catch (SinPlazasException_RESUELTO e) {
            System.out.println(e.getMessage());
        }

        try {
            tienda.agregarBici(bici3);
        } catch (SinPlazasException_RESUELTO e) {
            System.out.println(e.getMessage());
        }

        try {
            tienda.agregarBici(bici4);
        } catch (SinPlazasException_RESUELTO e) {
            System.out.println(e.getMessage());
        }

        try {
            tienda.agregarBici(bici5);
        } catch (SinPlazasException_RESUELTO e) {
            System.out.println(e.getMessage());
        }

        BicicletaMTB_RESUELTO mtbReparar = new BicicletaMTB_RESUELTO(27, 29, 16, "L", false, 800, "MTB");
        BicicletaPaseo_RESUELTO paseoReparar = new BicicletaPaseo_RESUELTO(2, 27, 13, "M", false, 350, "paseo");
        BicicletaCarretera_RESUELTO carreteraReparar = new BicicletaCarretera_RESUELTO(8, 24, 8, "S", false, 650, "carretera");

        try {
            tienda.agregarBicicletaReparar(mtbReparar);
        } catch (SinPlazasException_RESUELTO e) {
            System.out.println(e.getMessage());
        }

        try {
            tienda.agregarBicicletaReparar(paseoReparar);
        } catch (SinPlazasException_RESUELTO e) {
            System.out.println(e.getMessage());
        }

        try {
            tienda.agregarBicicletaReparar(carreteraReparar);
        } catch (SinPlazasException_RESUELTO e) {
            System.out.println(e.getMessage());
        }

        for (Bicicleta_SIN_RESOLVER bici : tienda.getBicicletasStock()) {
            bici.mostrarDatos();
        }

        tienda.repararBicis();

        Random random = new Random();
        int posicionAleatoria = random.nextInt(20) + 1;
        System.out.println("Intentando vender la bici en la posicion " + posicionAleatoria);

        try {
            tienda.venderBicicleta(posicionAleatoria - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No existe una bicicleta en esa posicion del stock");
        }

        System.out.println("Caja final de la tienda: " + tienda.getCaja());
    }
}

