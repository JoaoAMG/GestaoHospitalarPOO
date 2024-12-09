
package gestaohospitalar;


public class Paciente {
    private static Integer inc = 1;
    private Integer id;
    private String nome;
    private Integer idade;
    private Endereco endereco; 

    public Paciente(String nome, Integer idade, Endereco endereco) {
        this.id = inc++;
        this.nome = nome;
        this.idade = idade;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Paciente\nid: " + id + "\nnome: " + nome + "\nidade: " + idade + "\n" + endereco;
    }
    
    
    
    
}


