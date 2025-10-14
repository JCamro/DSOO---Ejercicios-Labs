import java.util.ArrayList;
import java.util.Scanner;

public class Matricula {
    private Alumno alumno;
    private Cursos curso;
    private ArrayList<Double> notas = new ArrayList<>();
    private int indice = 0;

    public Matricula(Alumno alumno, Cursos curso) {
        this.alumno=alumno;
        this.curso=curso;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Cursos getCurso() {
        return curso;
    }

    public void agregarNota(double nota) {
        if (nota>=0 && nota<=20) {
            notas.add(nota);
            System.out.println("Se agrego la nota correctamente");
            return;
        }
        System.out.println("Nota no valida, no se agrego");
    }

    public double calcularPromedio(){
        double promedio = 0;
        for (Double double1 : notas) {
            promedio+=double1;
        }
        return (promedio/notas.size());
    }
    
    
}