public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(String ISBN, String titulo, String autor) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    // Getters
    public String getISBN() {return ISBN;}
    public String getTitulo() {return titulo;}
    public String getAutor() {return autor;}

    // Verifica laa disponibilidad del libro
    public boolean estaDisponible() {return disponible;}

    // Modifica la disponibilidad del libro
    public void setDisponible(boolean disponible) {this.disponible = disponible;}

    public String toString() {
        return "ISBN: " + ISBN + " | Título: " + titulo + " | Autor: " + autor + " | Disponible: " + (disponible ? "Sí" : "No");
    }
}