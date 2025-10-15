import java.util.ArrayList;

public class Usuario {
    private String codigo;
    private String nombre;
    private ArrayList<Libro> librosPrestados;

    public Usuario(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.librosPrestados = new ArrayList<>();
    }

    // Getters
    public String getCodigo() {return codigo;}
    public String getNombre() {return nombre;}
    public ArrayList<Libro> getLibrosPrestados() {return librosPrestados;}

    // Agrega a la lista personal el libro prestado
    public void agregarLibroPrestado(Libro libro) {librosPrestados.add(libro);}

    // Elimina de la lista personal el libro prestado
    public void devolverLibro(Libro libro) {librosPrestados.remove(libro);}

    public String toString() {
        return "Código: " + codigo + " | Nombre: " + nombre;
    }
}