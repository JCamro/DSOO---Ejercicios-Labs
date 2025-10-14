import java.time.*;
import java.util.ArrayList;

public class Doctor {
    private String codigo;
    private String nombre;
    private String especialidad;
    private int edad;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private ArrayList<Cita> citasAgendadas = new ArrayList<>();

    public Doctor(String codigo, String nombre, String especialidad, int edad, String horaEntrada, String horaSalida) {
        this.codigo=codigo;
        this.nombre=nombre;
        this.especialidad=especialidad;
        this.edad=edad;

        this.horaEntrada = LocalTime.parse(horaEntrada);
        this.horaSalida = LocalTime.parse(horaSalida);
    }

    public String getCodigo() {return codigo;}
    public int getEdad() {return edad;}
    public String getNombre() {return nombre;}
    public String getEspecialidad() {return especialidad;}
    public LocalTime getHoraEntrada() {return horaEntrada;}
    public LocalTime getHoraSalida() {return horaSalida;}
    
    //Metodo que retorna las citas agendadas con el doctor
    public ArrayList<Cita> getCitasAgendadas() {return citasAgendadas;}

    public void agregarCita(Cita cita) {
        citasAgendadas.add(cita);
    }

    public String toString() {
        return "\nNOMBRE: "+nombre+
                "\nESPECIALIDAD: "+especialidad+
                "\nEDAD: "+ edad +
                "\nCODE: "+ codigo +
                "\nHORA: "+ horaEntrada +"-"+horaSalida;
    }
}
