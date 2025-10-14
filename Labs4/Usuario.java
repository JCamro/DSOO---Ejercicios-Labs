import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String apellidos;
    private int codigo;
    private ArrayList<Libro> librosPrestados = new ArrayList<>();

    public Usuario(String nombre, String apellidos, int codigo) {
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.codigo=codigo;
    }

    //SETS
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //GETS
    public String getApellidos() {
        return apellidos;
    }
    public int getCodigo() {
        return codigo;
    }

    //Devuelve la lista de los libros prestados
    public ArrayList<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public String getNombre() {
        return nombre;
    }

    //METODO PEDIR PRESTADO
    public void pedirPrestado(Libro libroPrestado) {
        librosPrestados.add(libroPrestado);
    }

    //METODO DEVOLVER

    public boolean devolverLibro(int ISBN) {
        
        for (Libro libro : librosPrestados) { //verifica en la lista de libros prestados si en verdad se presto este libro
            
            if (libro.getISBN()==ISBN) { //si lo encuentra, lo elimina de la lista y retorna true comprobando que se devolvio
                librosPrestados.remove(libro); //NO CAMBIA EL ESTADO DEL LIBRO
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "CODIGO: "+codigo+"\tNOMBRES: "+nombre+"\tAPELLIDOS: "+apellidos+"\tLIBROS PRESTADOS: "+librosPrestados.size();
    }
}
