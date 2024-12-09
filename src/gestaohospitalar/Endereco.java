package gestaohospitalar;

public class Endereco {
        private String logadouro;
        private Integer numero;
        private String cep;
        private String cidade;
        private String estado;

    public Endereco(String logadouro, Integer numero, String cep, String cidade, String estado) {
        this.logadouro = logadouro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "\nEndereco:\nlogadouro: " + logadouro + "\nnumero: " + numero + "\ncep: " + cep + "\ncidade: " + cidade + "\nestado: " + estado ;
    }
        
        
        
       
}


