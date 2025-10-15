import java.time.LocalTime;
import java.util.*;

import javax.print.Doc;

public class GestorCitas {
    private ArrayList<Cita> agendaCitas;
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Doctor> listaDoctores;

    public GestorCitas() {
        agendaCitas = new ArrayList<>();
        listaDoctores = new ArrayList<>();
        listaPacientes = new ArrayList<>();
    }
    
    //Metodo agregar Doctor a la Base
    public void agregarDoctor(Doctor doctor) {
        //Validaciones
        if (doctor==null) {
            System.out.println("Error: Doctor es nulo\n");
            return;
        }
        if (!stringValido(doctor.getNombre()) || !stringValido(doctor.getEspecialidad()) || !stringValido(doctor.getCodigo())) {
            System.out.println("Error: Nombre, especialidad o codigo no debe ser vacio/nulo");
            return;
        }
        if (buscarDoctor(doctor.getCodigo())!=null) {
            System.out.println("Error: Codigo ya existente, no se hicieron cambios");
            return;
        }
        if (!edadValida(doctor.getEdad())) {
            System.out.println("Error: Edad invalida, no se hicieron cambios\n");
            return;
        }
        if (doctor.getHoraEntrada()==null || doctor.getHoraSalida()==null ) {
            System.out.println("Error: Horario de atencion nulo, no se hicieron cambios\n");
            return;
        }
        if (!horarioValido(doctor.getHoraEntrada(), doctor.getHoraSalida())) {
            System.out.println("Error: Los horarios no corresponden logica, no se hicieron cambios\n");
            return;
        }

        System.out.println("====== SISTEMA ======");
        System.out.println("Se agrego a: "+doctor+"\n");

        listaDoctores.add(doctor);
    }


    private Doctor buscarDoctor(String codigo) {
        for (Doctor doctor : listaDoctores) {
            if (doctor.getCodigo().equalsIgnoreCase(codigo)) {
                return doctor;
            }
        }
        return null;
    }
    
    private Paciente buscarPaciente(String codigo) {
        for (Paciente paciente : listaPacientes) {
            if (paciente.getCodigo().equalsIgnoreCase(codigo)) {
                return paciente;
            }
        }
        return null;
    }
    
    private Cita buscarCita(String codigo) {
        for (Cita cita : agendaCitas) {
            if (cita.getCodigoCita().equalsIgnoreCase(codigo)) {
                return cita;
            }
        }
        return null;
    }
    
    

    //Metodo que evalua si un String esta vacio
    private boolean stringValido(String cadena){
        return cadena!=null && cadena.trim().isEmpty();
    }

    //Metodo Agregar Paciente a la Base
    public void agregarPaciente(Paciente paciente) {
        //Validaciones
        if (paciente==null) {
            System.out.println("Error: Paciente nulo, no se hicieron cambios\n");
            return;
        }
        
        if (esCadenaVacia(paciente.getCodigo())) {
            System.out.println("Error: Codigo vacio, llene los datos, no se hicieron cambios\n");
            return;
        }

        if (!codigoNoRepetido(listaPacientes, paciente.getDNI())) {
            System.out.println("Error: DNI ya registrado, no se hicieron cambios\n");
            return;
        }
        
        if (!codigoNoRepetido(listaPacientes, paciente.getCodigo())) {
            System.out.println("Error: Codigo ya existe, no se hicieron cambios\n");
            return;
        }

        if (!edadValida(paciente.getEdad())) {
            System.out.println("Error: Edad invalida, no se hicieron cambios\n");
            return;
        }
        
        System.out.println("====== SISTEMA ======");
        System.out.println("Se agrego Paciente:"+paciente+"\n");
        listaPacientes.put(paciente.getCodigo(), paciente);
    }

    //Metodo que verifica si la edad es valida
    private boolean edadValida(int edad) {
        if (edad<0) {
            return false;
        }
        return true;
    }

    //Metodo que evalua el correcto formato de un horario (Hora de entrada - Hora de salida)
    private boolean horarioValido (LocalTime horaE, LocalTime horaS) {
        if (horaE.isAfter(horaS)) {
            return false;
        }
        return true;
    }

    public void agregarCita(Cita cita) {
        Doctor doctorAsignado = listaDoctores.get(cita.getCodigoDoctor());
        Paciente paciente = listaPacientes.get(cita.getCodigoPaciente());
        
        if (doctorAsignado==null) {
            System.out.println("Error: Doctor asignado no registrado, no se hicieron cambios\n");
            return;
        }
        
        ArrayList<Cita> citasDoctor = doctorAsignado.getCitasAgendadas();

        if (paciente==null) {
            System.out.println("Error: Paciente no registrado, no se hicieron cambios\n");
            return;
        }

        if (buscarCita(cita.getCodigoCita())!=null) {
            System.out.println("Codigo de Cita ya registrado, no se hicieron cambios\n");
        }
        if (!citasDoctor.isEmpty()) {
            if (!horarioLibre(citasDoctor, cita.getHora())) {
                System.out.println(">>>>>>Cita ya programada para las "+cita.getHora()+" con el Dr. "+doctorAsignado.getNombre()+"<<<<<<<<\n");
                return;
            }
        }

        agendaCitas.add(cita);
        doctorAsignado.agregarCita(cita);
        System.out.println("====== SISTEMA ======");
        System.out.println("Cita programada: "+cita);
        
    }

    


    private boolean horarioLibre(ArrayList<Cita> citasDoctor, LocalTime hora) {
        for (Cita cita : citasDoctor) {
            if (cita.getHora().equals(hora)) {
                return false;
            }
        }
        return true;
    }
    
}
