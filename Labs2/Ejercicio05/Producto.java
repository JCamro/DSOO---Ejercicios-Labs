public class Producto {
    //Atributos
    private int codigoProducto;
    private double precioProducto;
    private String nombreProducto;
    private int stockProducto; 

    //Inicializa datos
    public Producto(int codigo, String nombre, double precio, int stock) {
        codigoProducto = codigo;
        nombreProducto = nombre;
        precioProducto = precio;
        stockProducto = stock;
    }

    //Gets para los atributos del producto
    public int getCodigo() {
        return codigoProducto;
    }
    public int getStock() {
        return stockProducto;
    }
    public String getNombre() {
        return nombreProducto;
    }
    public double getPrecio() {
        return precioProducto;
    }

    //Si hay una compra el stock se reduce
    public void reducirStock(int cantidad) {
        stockProducto-=cantidad;
    }
    public String toString() {
        return "Codigo: "+codigoProducto+"\t"+nombreProducto+": s/."+precioProducto;
    }
}
