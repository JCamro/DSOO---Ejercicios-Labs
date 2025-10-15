import java.time.LocalDate;

public class Prestamo {
    private String codigo;
    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private boolean devuelto;

    public Prestamo(String codigo, Usuario usuario, Libro libro) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.devuelto = false;
    }

    public String getCodigo() {return codigo;}
    public Usuario getUsuario() {return usuario;}
    public Libro getLibro() {return libro;}
    public LocalDate getFechaPrestamo() {return fechaPrestamo;}

    
    public boolean isDevuelto() {
        return devuelto;
    }

    public void registrarDevolucion() {
        this.devuelto = true;
        libro.setDisponible(true);
        usuario.devolverLibro(libro);
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
               " | Usuario: " + usuario.getNombre() +
               " | Libro: " + libro.getTitulo() +
               " | Fecha préstamo: " + fechaPrestamo;
    }
}