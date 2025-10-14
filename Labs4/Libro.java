public class Libro {
    private String titulo;
    private String autor;
    private int ISBN;
    private boolean disponible;

    public Libro(String titulo, String autor, int ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.disponible = true;
    }

    //GETS
    public String getAutor() {
        return autor;
    }
    public int getISBN() {
        return ISBN;
    }
    public String getTitulo() {
        return titulo;
    }
    public boolean getDisponible() {
        return disponible;
    }

    

    //SETS
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String toString() {
        return "ISBN: "+ISBN+"\tTITULO: "+titulo+"\tAUTOR: "+autor+"\tDISPONIBLE: "+disponible;
    }
}
