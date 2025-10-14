import java.util.ArrayList;

public class Gestion {
    private ArrayList<Libro> biblioteca = new ArrayList<>();
    private ArrayList<Usuario> lista_usuarios = new ArrayList<>();

    //AGREGAR LIBRO

    public void agregarLibro(Libro libro) {
        //checks
        if (!validarStrings(libro.getTitulo()) || !validarStrings(libro.getAutor())) {
            System.out.println("Titulo o autor no validos, debes ingresar los datos");
            return;
        }
        if (buscarLibro(libro.getISBN())!=null) {
            System.out.println("El libro ya existe, no se hicieron cambios");
            return;
        }
        if (!validarCodigo(libro.getISBN())) {
            System.out.println("ISBN no valido, no se hicieron cambios");
            return;
        }

        biblioteca.add(libro);
        System.out.println("Se agrego el libro correctamente");
    }

    //CREA UN USUARIO
    public void agregarUsuario(Usuario usuario) {
        if (!validarStrings(usuario.getNombre()) || !validarStrings(usuario.getApellidos())) {
            System.out.println("Nombres o apellidos no validos, debes ingresar los datos");
            return;
        }
        if (!validarCodigo(usuario.getCodigo())) {
            System.out.println("Codigo no valido para usuario, no se hicieron cambios");
            return;
        }
        if (buscarUsuario(usuario.getCodigo())!=null) {
            System.out.println("El usuario ya existe, no se hicieron cambios");
            return;
        }
        lista_usuarios.add(usuario);
        System.out.println("Se agrego al usuario correctamente");
    }

    //PIDE PRESTADO UN LIBRO 
    public void pedirPrestado(int codigoUsuario, int ISBN) {
        Libro libro = buscarLibro(ISBN);
        Usuario usuario = buscarUsuario(codigoUsuario);

        //Verificar que el usuario exista
        if (usuario==null) {
            System.out.println("El usuario no existe, no se realizo el prestamo");
            return;
        }
        //Verificar que el libro exista
        if (libro==null) {
            System.out.println("El libro no existe, no se realizo el prestamo");
            return;
        }
        //Verificar que el libro este disponible
        if (!libro.getDisponible()) {
            System.out.println(libro.getTitulo()+" de "+libro.getAutor()+" no disponible, no se realizo el prestamo");
            return;
        }

        //Prestar
        libro.setDisponible(false);
        usuario.pedirPrestado(libro);
        System.out.println("<<PRESTAMO>>"+"\n---LIBRO---"+"\nISBN: "+libro.getISBN()+"\tTITULO: "+libro.getTitulo()+"\tAUTOR: "+libro.getAutor()+"\n---DESTINATARIO---"+"\nCODIGO: "+usuario.getCodigo()+"\tNOMBRES: "+usuario.getNombre()+"/"+usuario.getApellidos());
        System.out.println();
    }

    //DEVOLVER LIBRO
    public void devolverLibro(int codigoUsuario, int ISBN) {
        Libro libro = buscarLibro(ISBN);
        Usuario usuario = buscarUsuario(codigoUsuario);
        //Verificar que el usuario exista

        if (usuario==null) {
            System.out.println("El usuario no existe, error en el proceso");
            return;
        }
        //Verificar que el libro exista
        if (libro==null) {
            System.out.println("El libro no existe en la base de datos");
            return;
        }

        //Devolver el libro, quita el libro en la lista de prestamos
        if (!usuario.devolverLibro(ISBN)) {
            System.out.println("ERROR! Anteriormente no se realizo un prestamo de este libro CUIDADO");
            return;
        }
        
        
        //Cambiar el atributo disponible a true
        libro.setDisponible(true);
        System.out.println(">>DEVOLUCION<< \nDE: "+usuario.getApellidos()+"/"+usuario.getNombre()+"\tCODIGO DE USUARIO: "+usuario.getCodigo()+"\nISBN: "+libro.getISBN()+"\tLIBRO: "+libro.getTitulo()+"\tAUTOR: "+libro.getAutor());
        System.out.println();
    }

    //MUESATRA EN LISTA TODOS LOS LIBROS EN BIBLIOTECA
    public void mostrarLibros() {
        System.out.println("<<<<LISTA DE LIBROS>>>>");
        for (Libro libro : biblioteca) {
            System.out.println(libro);
        }
        System.out.println();
    }

    //MUESTRA EN LISTA TODOS LOS USUARIOS EN LISTA
    public void mostrarUsuarios() {
        System.out.println("<<<<LISTA DE USUARIOS>>>>");
        for (Usuario usuario : lista_usuarios) {
            System.out.println(usuario);
        }
        System.out.println();
    }

    //MUESTRA LOS LIBROS QUE SE PRESTO UN USUARIO
    public void mostrarUsuarioPrestamos(int codigoUsuario) {
        Usuario usuario = buscarUsuario(codigoUsuario);
        if (usuario==null) {
            System.out.println("El usuario no existe, no se realizo el prestamo");
            return;
        }

        ArrayList<Libro> listaLibrosUsuario = usuario.getLibrosPrestados();
        if (listaLibrosUsuario.isEmpty()) {
            System.out.println("No hay ningun prestamo realizado");
            return;
        }

        System.out.println("<LIBROS PRESTADOS DE USUARIO "+usuario.getCodigo()+">");
        
        for (Libro libro : listaLibrosUsuario) {
            System.out.println(libro);
        }
        System.out.println();
    }


    //VALIDACIONES PARA LIBRO

    //validar ISBN
    public boolean validarCodigo(int codigo) {
        if (codigo<10000000 || codigo>99999999) {
            return false;
        }
        return true;
    }

    //retorna un libro
    public Libro buscarLibro(int ISBN) {
        for (Libro libro : biblioteca) {
            if (libro.getISBN()==ISBN) {
                return libro;
            }
        }
        return null;
    }


    //VALIDACIONES PARA USUARIO
    
    //retorna un usuario
    public Usuario buscarUsuario(int codigo) {
        for (Usuario usuario : lista_usuarios) {
            if (usuario.getCodigo()==codigo) {
                return usuario;
            }
        }
        return null;
    }

    public boolean validarStrings(String palabra) {
        if (palabra==null) {
            return false;
        }
        return true;
    }
}
