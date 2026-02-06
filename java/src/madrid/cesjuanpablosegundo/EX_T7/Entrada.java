package madrid.cesjuanpablosegundo.EX_T7;

import java.util.Random;

public class Entrada {
    public static void main(String[] args) {
        Almacen almacen = new Almacen(4);
        Tienda tienda = new Tienda(almacen);

        BicicletaMTB bici1 = new BicicletaMTB(21, 27, 15, "M", true, 500, "MTB");
        BicicletaPaseo bici2 = new BicicletaPaseo(3, 26, 12, "S", true, 300, "paseo");
        BicicletaCarretera bici3 = new BicicletaCarretera(10, 28, 9, "L", true, 700, "carretera");
        BicicletaMTB bici4 = new BicicletaMTB(18, 26, 14, "S", true, 450, "MTB");
        BicicletaPaseo bici5 = new BicicletaPaseo(5, 24, 11, "M", true, 320, "paseo");

        try {
            tienda.agregarBici(bici1);
        } catch (SinPlazasException e) {
            System.out.println(e.getMessage());
        }

        try {
            tienda.agregarBici(bici2);
        } catch (SinPlazasException e) {
            System.out.println(e.getMessage());
        }

        try {
            tienda.agregarBici(bici3);
        } catch (SinPlazasException e) {
            System.out.println(e.getMessage());
        }

        try {
            tienda.agregarBici(bici4);
        } catch (SinPlazasException e) {
            System.out.println(e.getMessage());
        }

        try {
            tienda.agregarBici(bici5);
        } catch (SinPlazasException e) {
            System.out.println(e.getMessage());
        }

        BicicletaMTB mtbReparar = new BicicletaMTB(27, 29, 16, "L", false, 800, "MTB");
        BicicletaPaseo paseoReparar = new BicicletaPaseo(2, 27, 13, "M", false, 350, "paseo");
        BicicletaCarretera carreteraReparar = new BicicletaCarretera(8, 24, 8, "S", false, 650, "carretera");

        try {
            tienda.agregarBicicletaReparar(mtbReparar);
        } catch (SinPlazasException e) {
            System.out.println(e.getMessage());
        }

        try {
            tienda.agregarBicicletaReparar(paseoReparar);
        } catch (SinPlazasException e) {
            System.out.println(e.getMessage());
        }

        try {
            tienda.agregarBicicletaReparar(carreteraReparar);
        } catch (SinPlazasException e) {
            System.out.println(e.getMessage());
        }

        for (Bicicleta bici : tienda.getBicicletasStock()) {
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

