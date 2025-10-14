public class Venta {
    private int codigoVenta;
    private int codigoProducto;
    private int cantidadAComprar;

    //Constructor que inicializa los datos
    public Venta(int codigo, int codeProducto, int cantidad) {
        codigoVenta = codigo;
        codigoProducto = codeProducto;
        cantidadAComprar = cantidad;
    }

    //Gets de los atributos
    public int getCodigoVenta() {
        return codigoVenta;
    }
    public int getCodigoProducto() {
        return codigoProducto;
    }
    public int getCantidad() {
        return cantidadAComprar;
    }

    public double precioDeVenta(Producto[] productos) {
        //Busca en los productos el codigo del producto
        for (int i = 0; i < productos.length; i++) {
            
            if (codigoProducto==productos[i].getCodigo()) {
                //Verifica si la cantidad a comprar es menor a la que hay en stock
                if (cantidadAComprar<=productos[i].getStock()) {
                    productos[i].reducirStock(cantidadAComprar);
                    return productos[i].getPrecio()*cantidadAComprar; //Retorna el monto de la venta del producto
                }
                else {
                    //Indica que el stock es menor que la cantidad que se pide 
                    System.out.println("No hay stock para "+productos[i].getNombre()+", "+productos[i].getStock()+" productos disponibles");
                }
            }
        }
        //Si no encuentra nada en los productos retorna 0
        return 0;
    }
}
