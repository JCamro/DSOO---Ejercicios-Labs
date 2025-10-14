public class Prestamo {
    private int codigoPrestamo;
    private int codigoLibro;
    private int cantidad;

    public Prestamo(int codigoPrestamo, int codigoLibro, int cantidad) {
        this.codigoLibro=codigoLibro;
        this.codigoPrestamo=codigoPrestamo;
        this.cantidad=cantidad;
    }

    public int getCodigoPrestamo() {
        return codigoPrestamo;
    }

    public boolean realizarPrestamo(Libro[] Biblioteca) {
        for (int i = 0; i < Biblioteca.length; i++) {
            if (codigoLibro==Biblioteca[i].getCodigo()) {
                if (cantidad<=Biblioteca[i].getStock()) {
                    Biblioteca[i].restarStock(cantidad);
                    return true;
                }
                else {
                    System.out.println("Prestamo "+codigoPrestamo+" no incluido"+"\nEROR! No se pudo incluir a "+Biblioteca[i].getNombre()+" Stock disponible "+Biblioteca[i].getStock());
                }
            }
        }
        return false;
    }

    public double precioDePrestamo(Libro[] Biblioteca) {
        for (int i = 0; i < Biblioteca.length; i++) {
            if (codigoLibro==Biblioteca[i].getCodigo()) {
                return Biblioteca[i].getPrecioPrestamo()*cantidad;
            }
        }
        return 0;
    }
}
