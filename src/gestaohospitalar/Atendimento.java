package gestaohospitalar;


public class Atendimento {
    private static Integer inc = 1;
    private Integer id;
    private Medico medico;
    private Paciente paciente;
    private EstadosDeAtendimento estadosdeatendimento;

    public Atendimento(Medico medico, Paciente paciente, EstadosDeAtendimento estadosdeatendimento) {
        this.id = inc++;
        this.medico = medico;
        this.paciente = paciente;
        this.estadosdeatendimento = estadosdeatendimento;
    }

    public Integer getId() {
        return id;
    }

    

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public EstadosDeAtendimento getEstadosdeatendimento() {
        return estadosdeatendimento;
    }

    public void setEstadosdeatendimento(EstadosDeAtendimento estadosdeatendimento) {
        this.estadosdeatendimento = estadosdeatendimento;
    }

    @Override
    public String toString() {
        return  "id do atendimento: " + id + "\nmedico do atendimento: " + medico + "\npaciente do atendimento: " + paciente + "\nestado de atendimento: " + estadosdeatendimento;
    }
    
    
    
}


