import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("<<<Bienvenido al Programa>>>");
        //Se crea un array con los productos
        Producto[] productos = new Producto[4];
        productos[0] = new Producto(1, "arroz", 3.5, 12);
        productos[1] = new Producto(2, "azucar", 4, 7);
        productos[2] = new Producto(3, "aceite", 8, 30);
        productos[3] = new Producto(4, "mermelada", 2, 10);

        //Se crea un array con las ventas realizadas
        Venta[] ventas = {
            new Venta(1, 2, 10),
            new Venta(1, 1, 1)
        };

        //Usuario ingresa el codigo de venta y se calcula el precio total
        System.out.print("Ingrese codigo de venta para saber el monto total: ");
        int codigoDeVenta = scan.nextInt();
        double suma = 0;
        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i].getCodigoVenta()==codigoDeVenta) {
                suma+=ventas[i].precioDeVenta(productos);
            }
        }
        
        System.out.println("Total: s/."+suma);
        System.out.println();
        
        System.out.println("<<<PRODUCTOS>>>");
        //Bubble sort para ordenar productos por sus precios
        for (int i = 0; i < productos.length-1; i++) {
            for (int j = 0; j < productos.length-1; j++) {
                if (productos[j].getPrecio()<productos[j+1].getPrecio()) {
                    Producto temp = productos[j+1];
                    productos[j+1] = productos[j];
                    productos[j] = temp;
                }
            }
        }
        //Imprime los productos
        for (int i = 0; i < productos.length; i++) {
            System.out.println(productos[i]);
        }
    }
}
