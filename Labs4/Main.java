public class Main {
    public static void main(String[] args) {
        
        Gestion gestion1 = new Gestion();

        gestion1.agregarUsuario(new Usuario("Pedro", "Perez", 10000001));
        gestion1.agregarUsuario(new Usuario(null, null, 0));
        gestion1.agregarUsuario(new Usuario("Pedro", "Perez", 10000001));
        gestion1.agregarUsuario(new Usuario("Marta", "Quispe", 10000002));
        gestion1.agregarUsuario(new Usuario("Flavio", "Quispe", 10000002));
        gestion1.agregarUsuario(new Usuario("Emanuel", "Cusipanta", 10000003));
        gestion1.agregarUsuario(new Usuario("Emanuel", "Cusipanta", 10000003));

        gestion1.agregarLibro(new Libro("Pedirotp de la mancha", "Desconocido", 10000001));
        gestion1.agregarLibro(new Libro("Calculo en una", "Jams", 10000001));
        gestion1.agregarLibro(new Libro("Calculo en una", "Jams", 10000002));
        gestion1.agregarLibro(new Libro("Pablo Paramo", "Uug", 10000002));
        gestion1.agregarLibro(new Libro("Pablo Paramo", "Uug", 10000003));

        gestion1.mostrarUsuarios();
        gestion1.mostrarLibros();

        gestion1.pedirPrestado(10000001,10000001);
        gestion1.pedirPrestado(10000001,10000002);
        gestion1.pedirPrestado(10000001,10000003);

        gestion1.mostrarUsuarioPrestamos(10000001);

        gestion1.mostrarUsuarios();
        gestion1.mostrarLibros();

        gestion1.devolverLibro(10000001, 10000001);
    }
}
