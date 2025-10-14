import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Libro[] Biblioteca = {
            new Libro(1, "Don Quijote", "Desconocido", 10,5),
            new Libro(2, "Caperucita", "Desconocido", 2,5),
            new Libro(3, "Calculo 9na Edicion", "James Stewart", 1,20),
            new Libro(4, "Fisica I", "Desconocido", 3,20)
        };

        Prestamo[] prestamos = {
            new Prestamo(1, 1, 11),
            new Prestamo(2, 3, 1),
            new Prestamo(3, 3, 1),
            new Prestamo(1, 2, 2)
        };

        int numero = 1;
        double precio = 0;
        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i].getCodigoPrestamo()==numero) {
                if (prestamos[i].realizarPrestamo(Biblioteca)) {
                    System.out.println("Prestamo aceptado");
                    precio+=prestamos[i].precioDePrestamo(Biblioteca);
                }
            }
        }

        System.out.println("Precio por prestamos: "+precio);
    }
}
