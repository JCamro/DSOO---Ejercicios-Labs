public class Libro {
    private int codigoLibro;
    private String tituloLibro;
    private String autorLibro;
    private int stockLibro;
    private double precioPrestamo;

    public Libro(int codigo, String nombre, String autor, int stock, double precio) {
        codigoLibro=codigo;
        tituloLibro=nombre;
        autorLibro=autor;
        stockLibro=stock;
        precioPrestamo=precio;
    }

    public int getCodigo() {
        return codigoLibro;
    }
    public String getNombre() {
        return tituloLibro;
    }
    public String getAutor() {
        return autorLibro;
    }
    public int getStock() {
        return stockLibro;
    }
    public double getPrecioPrestamo() {
        return precioPrestamo;
    }

    public void aumentarStock(int cantidad) {
        stockLibro+=cantidad;
    }
    public void restarStock(int cantidad) {
        if (cantidad<=stockLibro) {
            stockLibro-=cantidad;
        }
        else {
            System.out.println("EROR! Stock disponible "+stockLibro);
        }
    }

    public String toString() {
        return codigoLibro+"\t"+tituloLibro+" Autor: "+autorLibro;
    }

}
