package gestaohospitalar;

public class Medico {
    private static Integer inc = 1;
    private Integer id;
    private String nome;
    private Integer idade;
    private Integer crm;
    private Integer senha;
    private Endereco endereco; 

    public Medico(String nome, Integer idade, Integer crm, Integer senha, Endereco endereco) {
        this.id = inc++;
        this.nome = nome;
        this.idade = idade;
        this.crm = crm;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getCrm() {
        return crm;
    }

    public void setCrm(Integer crm) {
        this.crm = crm;
    }

    public Integer getSenha() {
        return senha;
    }

    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Medico:\nId: " + id + "\nNome: " + nome + "\nIdade: " + idade + "\nCRM: " + crm + "\nendereco: " + endereco;
    }
    
    
    
    
    
}
