import java.util.ArrayList;


public class SistemaBiblioteca {
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Prestamo> prestamos;

    public SistemaBiblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        prestamos = new ArrayList<>();
    }


    // Metodo agregar libro al sistema
    public void agregarLibro(Libro libro) {
        if (libro == null) {        // Valida que el argumeno no sea nulo
            System.out.println("Error: El libro no puede ser nulo\n"); 
            return;
        }
        if (!stringValido(libro.getAutor()) || !stringValido(libro.getTitulo()) || !stringValido(libro.getISBN())) {        // Valida que los atributos no sean nulos
            System.out.println("Error: Autor, Titulo o Codigo no puede ser nulo/vacio\n");
            return;
        }
        if (buscaLibro(libro.getISBN())!=null) {      // Verifica si ya existe el codigo
            System.out.println("Error: Codigo ya registrado, no se hicieron cambios\n");
            return;
        }
        
        libros.add(libro);
        System.out.println("====== SISTEMA ======");
        System.out.println("Libro registrado: " + libro.getTitulo());
    }

    // Validaciones para registrar Libro
    private Libro buscaLibro(String codigo) {
        for (Libro libro : libros) {        
            if (libro.getISBN().equalsIgnoreCase(codigo)) {
                return libro;
            }
        }
        return null;
    }

    // Metodo para agregar usuarios al sistema
    public void agregarUsuario(Usuario usuario) {
        if (usuario == null) {      // Verifica que el argumento no sea null
            System.out.println("Error: Usuario no puede ser nulo\n");
            return;
        }
        if (!stringValido(usuario.getNombre()) || !stringValido(usuario.getCodigo())) {        // Verifica que el nombre de usuario no este vacio o no sea null
            System.out.println("Error: Nombre o Codigo no puede estar vacio\n");
            return;
        }
        if (buscaUsuario(usuario.getCodigo()) != null) {        // Verifica si existe un objeto con el mismo codigo
            System.out.println("Error: Codigo ya registrado, no se hicieron cambios\n");
            return;
        }
        usuarios.add(usuario);
        System.out.println("====== SISTEMA ======");
        System.out.println("Usuario registrado: " + usuario.getNombre());
    }

    private Usuario buscaUsuario(String codigo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCodigo().equalsIgnoreCase(codigo)) {
                return usuario;
            }
        }
        return null;
    }

    private boolean stringValido(String cadena) {
        return cadena != null && !cadena.trim().isEmpty();
    }


    // Metodo para registrar un prestamo
    public void registrarPrestamo(String codigoPrestamo, String codigoUsuario, String ISBN) {
        if (!stringValido(codigoUsuario) || !stringValido(ISBN) || !stringValido(codigoPrestamo)) {
            System.out.println("Error: Codigo de usuario, libro o codigoPrestamo no deben ser nulos, no se hicieron cambios\n");
            return;
        }

        Usuario usuariop = buscaUsuario(codigoUsuario);
        Libro libro = buscaLibro(ISBN);

        if (usuariop == null) {
            System.out.println("Error: Usuario no registrado en el sistema, no se hicieron cambios");
            return;
        }
        if (libro == null) {
            System.out.println("Error: Libro no registrado en el sistema, no se hicieron cambios");
            return;
        }
        if (buscarPrestamo(codigoPrestamo)!=null) {
            System.out.println("Error: El codigo de prestamo ya existe, no se hicieron cambios\n");
            return;
        }
        if (!libro.estaDisponible()) {
            System.out.println("El libro '" + libro.getTitulo() + "' no está disponible.\nNo se realizo el prestamo\n");
            return;
        }

        libro.setDisponible(false);
        usuariop.agregarLibroPrestado(libro);
        Prestamo prestamo = new Prestamo(codigoPrestamo, usuariop, libro);
        prestamos.add(prestamo);

        System.out.println("====== PRESTAMO REGISTRADO ======");
        System.out.println(prestamo);
        System.out.println();
    }

    // Verifica si existe el codigo dado por el argumento
    private Prestamo buscarPrestamo(String codigo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equalsIgnoreCase(codigo)) {
                return prestamo;
            }
        }
        return null;
    }

    // Metodo para realizar la devolucion de un libro
    public void registrarDevolucion(String codigoPrestamo) {
        if (!stringValido(codigoPrestamo)) {
            System.out.println("Error: Codigo no puede ser nulo/vacio");
            return;
        }
        Prestamo prestamo = buscarPrestamo(codigoPrestamo);
        if (prestamo==null) {
            System.out.println("No se encontró el préstamo activo con código: " + codigoPrestamo);
            return;
        }
        prestamo.registrarDevolucion();
        prestamos.remove(prestamo);
        System.out.println("====== DEVOLUCION ======");
        System.out.println(prestamo);
        System.out.println();
        
    }

    public void listarLibros() {
        System.out.println("===== LIBROS REGISTRADOS =====");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public void listarUsuarios() {
        System.out.println("===== USUARIOS REGISTRADOS =====");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public void listarPrestamos() {
        System.out.println("===== HISTORIAL DE PRÉSTAMOS =====");
        for (Prestamo p : prestamos) {
            System.out.println(p);
        }
    }
}
