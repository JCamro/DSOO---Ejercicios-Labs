import java.time.*;
public class Cita {
    private String codigoCita;
    private String codigoDoctor;
    private String codigoPaciente;
    private LocalDate fecha;
    private LocalTime hora;
    private String estado;

    // Constructor
    public Cita(String codigoCita, String codigoDoctor, String codigoPaciente, LocalDate fecha, LocalTime hora, String estado) {
        this.codigoCita = codigoCita;
        this.codigoDoctor = codigoDoctor;
        this.codigoPaciente = codigoPaciente;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = convertirEstado(estado);
    }

    // ====== CONVERSIÓN DE ESTADO ======
    private String convertirEstado(String estado) {
        if (estado == null) return "sin condición";
        switch (estado.trim().toLowerCase()) {
            case "p": return "pendiente";
            case "a": return "atendida";
            case "c": return "cancelada";
            default:  return "sin condición";
        }
    }

    // ====== GETTERS ======
    public String getCodigoCita() { return codigoCita; }
    public String getCodigoDoctor() { return codigoDoctor; }
    public String getCodigoPaciente() { return codigoPaciente; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHora() { return hora; }
    public String getEstado() { return estado; }

    // ====== TO STRING ======
    @Override
    public String toString() {
        return "\nCITA: " + codigoCita +
               "\nFECHA: " + fecha +
               "\nHORA: " + hora +
               "\nPACIENTE: " + codigoPaciente +
               "\nDOCTOR: " + codigoDoctor +
               "\nESTADO: " + estado;
    }
}

