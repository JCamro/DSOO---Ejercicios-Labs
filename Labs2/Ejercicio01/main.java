import java.util.*;

public class main {
    
    public static void main(String[] args) {
        Salon salon1 = new Salon();
        salon1.AgregarAlumno("Martin", 12.1);
        salon1.AgregarAlumno("Pablo", 18);
        salon1.AgregarAlumno("Pedro", 15);
        salon1.AgregarAlumno("Manuela", 21);
        salon1.AgregarAlumno("Jorge", 8.9);
        salon1.AgregarAlumno("Juan", 19.3);
        salon1.AgregarAlumno("Miguel", 10.5);
        salon1.AgregarAlumno("Raul", 10.2);
        salon1.AgregarAlumno("Luciana", 9);
        salon1.AgregarAlumno("Daniela", 10);

        System.out.println(salon1.AlumnoMayorNota());
        System.out.println(salon1.AlumnoMenorNota());

        double notaAlumno1 = salon1.NotaAlumno("pEDRO");
        if (notaAlumno1!=-1) {
            System.out.println("Nota: "+notaAlumno1);
        }
        else {
            System.out.println("Alumno no encontrado\n");
        } 
        
        double notaAlumno2 = salon1.NotaAlumno("irVin");
        if (notaAlumno2!=-1) {
            System.out.println(notaAlumno2);
        } 
        else {
            System.out.println("Alumno no encontrado\n");
        }
    }
}

