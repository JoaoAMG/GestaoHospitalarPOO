package gestaohospitalar;


public abstract class EstadosDeAtendimento {
    
    private String estado;

    public EstadosDeAtendimento(String estado) { 
        this.estado = estado;
        
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String Estado) {
        this.estado = Estado;
    }

    
    @Override
    public String toString() {
        return  "\nEstado De Atendimento: " + estado;
    }
    
    
    
    
}



