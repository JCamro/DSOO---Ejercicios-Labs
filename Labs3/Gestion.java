import java.util.ArrayList;

public class Gestion {
    ArrayList<Cursos> lista_cursos = new ArrayList<>();
    ArrayList<Alumno> lista_alumnos = new ArrayList<>();
    ArrayList<Docentes> lista_docentes = new ArrayList<>();


    //AGREGAR CURSO VALIDO---------------------------
    public void agregarCurso(int codigo, String nombre, int DNIDOCENTE) {
        if (validarCurso(codigo, DNIDOCENTE)) {

            lista_cursos.add(new Cursos(codigo, nombre, buscarDocente(DNIDOCENTE)));
            System.out.println("Se agrego correctamente el Curso "+nombre);
        }
    }
    
    //VALIDA AGREGAR CURSO
    public boolean validarCurso(int codigo, int DNIDOCENTE) {
        for (Cursos curso : lista_cursos) {
            if (curso.getCodigo()==codigo) {
                System.out.println("Curso ya existente, no se agrego nada");
                return false;
            }
        }

        if (buscarDocente(DNIDOCENTE)==null) {
            System.out.println("El docente no existe");
            return false;
        }
        return true;
    }
    //-----------------------------------------------------

    //AGREGAR ALUMNO VALIDO--------------------------------
    public void agregarAlumno(String nombres, String apellidos, int codigo) {
        if (validarAlumno(codigo)) {
            lista_alumnos.add(new Alumno(nombres, apellidos, codigo));
            System.out.println("Se agrego correctamente alumno "+nombres);
        }
    }

    //VALIDA AGREGAR CURSO
    public boolean validarAlumno(int codigo) {
        for (Cursos curso : lista_cursos) {
            if (curso.getCodigo()==codigo) {
                return false;
            }
        }
        return true;
    }
    //---------------------------------------------------


    //AGREGAR DOCENTE VALIDO---------------------------------
    public void agregarDocente(int codigo, String nombre, int DNI, String nombres, String apellidos, String especialidad) {
        if (validarDocente(DNI)) {

            lista_docentes.add(new Docentes(nombres, apellidos, DNI, especialidad, DNI));
            System.out.println("Se agrego correctamente Docente: "+nombre);
        }
    }
    
    //VALIDA DOCENTE
    public boolean validarDocente(int DNI) {
        for (Docentes docente : lista_docentes) {
            if (docente.getDNI()==DNI) {
                System.out.println("Docente ya registrado, no se agrego nada");
                return false;
            }
        }
        return true;
    }
    //--------------------------------------------------------

    public void matricularAlumno(int codigoAlumno, int codigoCurso) {
        Cursos curso = buscarCurso(codigoCurso);
        Alumno alumno = buscarAlumno(codigoAlumno);

        if (curso!=null && alumno!=null) {
            curso.matricularAlumno(alumno);
            alumno.agregarCurso(curso);
            System.out.println(alumno.getNombre()+" matriculado exitosamente en " +curso.getNombre());
            return;
        }
        System.out.println("Curso o alumno no existente, no se realiza la matricula");
        
    }



    //BUSQUEDAS

    public Alumno buscarAlumno(int codigo) {
        for (Alumno alumno : lista_alumnos) {
            if (alumno.getCodigo()==codigo) {
                return alumno;
            }
        }
        return null;
    }

    public Docentes buscarDocente(int DNI) {
        for (Docentes docente : lista_docentes) {
            if (docente.getDNI()==DNI) {
                return docente;
            }
        }
        return null;
    }

    public Cursos buscarCurso(int codigo) {
        for (Cursos curso : lista_cursos) {
            if (curso.getCodigo()==codigo) {
                return curso;
            }
        }
        return null;
    }
}
