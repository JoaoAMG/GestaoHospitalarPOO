package dao;

import gestaohospitalar.Endereco;
import gestaohospitalar.Medico;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DAOMedico {
    
    private List<Medico> databaseMedico = new ArrayList();
    
    public void menuDAOPaciente(){
        System.out.println("Menu de  medicos"
                + "\n1-Inserir Medico no sistema"
                + "\n2- Verificar Medico por ID no sistema"
                + "\n3- Modificar Medico por ID no sistema"
                + "\n4- Mostrar todos os Medicos Inseridos no Sistema"
                + "\n5- Excluir Medico do Sistema por Id"
                + "\n6- Para sair deste Menu");
    
    }
    
    public void create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEscreva o Nome do Medico");
        String nome = sc.nextLine();
        
        System.out.println("\nEscreva a idade do Medico");
        Integer idade = sc.nextInt();
        System.out.println("\nEscreva o CRM do Medico");
        Integer crm = sc.nextInt();
        System.out.println("\nInsira a Senha do Medico no  sistema");
        Integer senha = sc.nextInt();
        System.out.println("\nPreencha seu Endereco: ");
        sc.nextLine(); 
        System.out.println("\nInsira seu Logradouro(rua/avenida): ");
        String logradouro = sc.nextLine();
        System.out.println("\nInsira seu numero: ");
        Integer numero = sc.nextInt();
        sc.nextLine();
        System.out.println("\nInsira seu CEP: ");
        String cep = sc.nextLine();
        System.out.println("\nInsira sua cidade: ");
        String cidade = sc.nextLine();
        System.out.println("\nInsira seu estado: ");
        String estado = sc.nextLine();
        Endereco endereco = new Endereco(logradouro,numero,cep,cidade,estado);
        databaseMedico.add(new Medico(nome,idade,crm,senha,endereco));     
    }
    
    public Medico read() {
         Scanner sc = new Scanner(System.in);
        System.out.println("\nInsira o ID do Medico que deseja ver:");
        int id = sc.nextInt();
        for(Medico p:databaseMedico){
            if(p.getId()==id)
                return p;
            
        }
        return null;
    }
    
     public Medico readconv(int id) {
        for(Medico p:databaseMedico){
            if(p.getId()==id)
                return p;
        }
        return null;
    }
    
     public boolean update(){
          Scanner sc = new Scanner(System.in);
        System.out.println("\nEscreva o id do Medico que deseja atualizar: ");
        int atid = sc.nextInt();
        Medico p = readconv(atid);
        if(p.getId() != null){
        System.out.println("\nDigite a Senha para  atualizar: ");
            int verificarsenha = sc.nextInt();
            sc.nextLine();

            if(p.getSenha() == verificarsenha){
                System.out.println("\nEscreva o Nome do Medico: ");
                String nome = sc.nextLine();

                System.out.println("\nEscreva a idade do Medico: ");
                Integer idade = sc.nextInt();
                System.out.println("\nInsira o CRM do Medico: ");
                Integer crm = sc.nextInt();
                System.out.println("\nInsira a senha do Medico: ");
                Integer senha = sc.nextInt();

                System.out.println("\nPreencha seu Endereço: ");
                sc.nextLine(); 
                System.out.println("\nInsira seu Logradouro(rua/avenida): ");
                String logradouro = sc.nextLine();
                System.out.println("\nInsira seu numero: ");
                Integer numero = sc.nextInt();
                sc.nextLine();
                System.out.println("\nInsira seu CEP: ");
                String cep = sc.nextLine();
                System.out.println("\nInsira sua cidade: ");
                String cidade = sc.nextLine();
                System.out.println("\nInsira seu estado: ");
                String estado = sc.nextLine();
                Endereco endereco = new Endereco(logradouro,numero,cep,cidade,estado);

                p.setNome(nome);
                p.setIdade(idade);
                p.setCrm(crm);
                p.setSenha(senha);
                p.setEndereco(endereco);
                Medico paux=readconv(p.getId());
                if(paux!= null){
                    paux.setNome(p.getNome());
                    paux.setIdade(p.getIdade());
                    paux.setCrm(p.getCrm());
                    paux.setSenha(p.getSenha());
                    paux.setEndereco(p.getEndereco());
                    System.out.println("Atualizado com Sucesso");
                    return true;
                }
                }
            else{
                System.out.println("Senha Incorreta tente novamente!");
            }
        }
        else{ 
            System.out.println("Id inexistente");
        }
         
        return false;
    }
     
    public String listAll(){
        String report="";
        for(Medico p:databaseMedico){
            report+= "Id: "+ p.getId()+"\n";
            report+= "Nome: "+ p.getNome()+"\n";
            report+= "Idade: "+ p.getIdade()+"\n";
            report+= "CRM: "+ p.getCrm()+"\n";
            report+=  p.getEndereco()+"\n\n";
        }
        return report;
    }
    public boolean delete(){
         Scanner sc = new Scanner(System.in);
        System.out.println("\nInsira o ID do Usuario que deseja remover:");
        int atid = sc.nextInt();
        Medico p = readconv(atid);     
        if(p!= null){
            databaseMedico.remove(p);
            System.out.println("Removido com Sucesso");
            return true;
        }
        System.out.println("Id Não existente tente novamente");
        return false;
    }
    
}
