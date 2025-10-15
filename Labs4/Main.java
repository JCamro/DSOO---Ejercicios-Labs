public class Main {
    public static void main(String[] args) {
        // Crear sistema principal
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        // ====== REGISTRO DE LIBROS ======
        System.out.println("=== PRUEBA: REGISTRO DE LIBROS ===\n");

        Libro l1 = new Libro("ISBN001", "Cien Años de Soledad", "Gabriel García Márquez");
        Libro l2 = new Libro("ISBN002", "El Principito", "Antoine de Saint-Exupéry");
        Libro l3 = new Libro("ISBN003", "1984", "George Orwell");
        Libro l4 = new Libro("ISBN004", "Fahrenheit 451", "Ray Bradbury");

        sistema.agregarLibro(l1);
        sistema.agregarLibro(l2);
        sistema.agregarLibro(l3);
        sistema.agregarLibro(l4);

        // Intentar registrar libro repetido
        Libro l5 = new Libro("ISBN003", "Duplicado", "Autor Falso");
        sistema.agregarLibro(l5); // Debe mostrar error

        System.out.println();
        sistema.listarLibros();
        System.out.println("\n\n");


        // ====== REGISTRO DE USUARIOS ======
        System.out.println("=== PRUEBA: REGISTRO DE USUARIOS ===\n");

        Usuario u1 = new Usuario("U001", "Ana Torres");
        Usuario u2 = new Usuario("U002", "Luis Gómez");
        Usuario u3 = new Usuario("U003", "Carla Rojas");

        sistema.agregarUsuario(u1);
        sistema.agregarUsuario(u2);
        sistema.agregarUsuario(u3);

        // Usuario duplicado
        Usuario u4 = new Usuario("U002", "Usuario Repetido");
        sistema.agregarUsuario(u4); // Debe mostrar error

        System.out.println();
        sistema.listarUsuarios();
        System.out.println("\n\n");


        // ====== REGISTRO DE PRÉSTAMOS ======
        System.out.println("=== PRUEBA: REGISTRO DE PRÉSTAMOS ===\n");

        sistema.registrarPrestamo("P001", "U001", "ISBN001");
        sistema.registrarPrestamo("P002", "U002", "ISBN002");
        sistema.registrarPrestamo("P003", "U001", "ISBN003");

        // Intentar prestar libro no disponible
        sistema.registrarPrestamo("P004", "U003", "ISBN001"); // Debe fallar

        // Intentar prestar con usuario no existente
        sistema.registrarPrestamo("P005", "U999", "ISBN004"); // Debe fallar

        // Intentar prestar libro no existente
        sistema.registrarPrestamo("P006", "U001", "ISBN999"); // Debe fallar

        // Intentar préstamo con código duplicado
        sistema.registrarPrestamo("P002", "U003", "ISBN004"); // Debe fallar

        System.out.println();
        sistema.listarPrestamos();
        System.out.println("\n\n");


        // ====== REGISTRO DE DEVOLUCIONES ======
        System.out.println("=== PRUEBA: DEVOLUCIONES ===\n");

        sistema.registrarDevolucion("P002"); // Devolver "El Principito"
        sistema.registrarDevolucion("P009"); // Código inexistente
        sistema.registrarDevolucion("P001"); // Devolver "Cien Años de Soledad"

        System.out.println();
        sistema.listarPrestamos();
        System.out.println("\n\n");


        // ====== ESTADO FINAL ======
        System.out.println("=== ESTADO FINAL DEL SISTEMA ===\n");
        sistema.listarLibros();
        System.out.println();
        sistema.listarUsuarios();
    }
}
