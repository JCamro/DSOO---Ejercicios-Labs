import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // Crear gestor de citas
        GestorCitas gestor = new GestorCitas();

        // =======================
        // CREAR Y AGREGAR DOCTORES
        // =======================
        Doctor d1 = new Doctor("D001", "Dr. Juan Pérez", "Cardiología", 45, "08:00", "14:00");
        Doctor d2 = new Doctor("D002", "Dra. María López", "Pediatría", 38, "09:00", "15:00");
        Doctor d3 = new Doctor("D003", "Dr. Luis Torres", "Neurología", 50, "14:00", "20:00");
        Doctor d4 = new Doctor("D004", "Dr. Luis Torres", "Neurología", -1, "14:00", "20:00");

        gestor.agregarDoctor(d1);
        gestor.agregarDoctor(d2);
        gestor.agregarDoctor(d3);
        gestor.agregarDoctor(d4);

        // =======================
        // CREAR Y AGREGAR PACIENTES
        // =======================
        Paciente p1 = new Paciente("P001", "Luis Gómez", 30, "DNI001");
        Paciente p2 = new Paciente("P002", "Ana Rojas", 25, "DNI002");
        Paciente p3 = new Paciente("P003", "Carlos Ruiz", 40, "DNI003");

        gestor.agregarPaciente(p1);
        gestor.agregarPaciente(p2);
        gestor.agregarPaciente(p3);

        // =======================
        // CREAR Y PROGRAMAR CITAS
        // =======================

        Cita c1 = new Cita("C001", "D001", "P001", LocalDate.of(2025, 10, 13), LocalTime.of(9, 0), "p");
        Cita c2 = new Cita("C002", "D002", "P002", LocalDate.of(2025, 10, 13), LocalTime.of(22, 30), "a");
        Cita c3 = new Cita("C003", "D003", "P003", LocalDate.of(2023, 1, 1), LocalTime.of(8, 0), "c");

        gestor.agregarCita(c1);
        gestor.agregarCita(c2);
        gestor.agregarCita(c3);
    

        System.out.println("\n===== FIN DE PRUEBA =====");

        
    }
}
