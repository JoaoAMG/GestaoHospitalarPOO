package dao;

import gestaohospitalar.Endereco;
import gestaohospitalar.Paciente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DAOPaciente {
    private List<Paciente> databasePaciente = new ArrayList();
    
    public void menuDAOPaciente(){
        System.out.println("Menu de  Pacientes"
                + "\n1-Inserir Paciente no sistema"
                + "\n2- Verificar Paciente por ID no sistema"
                + "\n3- Modificar Paciente por ID no sistema"
                + "\n4- Mostrar todos os Pacientes Inseridos no Sistema"
                + "\n5- Excluir Paciente do Sistema por Id"
                + "\n6- Para sair deste Menu");
    
    }
    
    public void create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEscreva o Nome do Paciente");
        String nome = sc.nextLine();
        
        System.out.println("\nEscreva a idade do Paciente");
        Integer idade = sc.nextInt();
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
        databasePaciente.add(new Paciente(nome,idade,endereco));     
    }
    
    public Paciente read() {
         Scanner sc = new Scanner(System.in);
        System.out.println("\nInsira o ID do Paciente que deseja ver:");
        int id = sc.nextInt();
        for(Paciente p:databasePaciente){
            if(p.getId()==id)
                return p;
            
        }
        return null;
    }
    
     public Paciente readconv(int id) {
        for(Paciente p:databasePaciente){
            if(p.getId()==id)
                return p;
            
        }
        
        return null;
    }
    
     public boolean update(){
          Scanner sc = new Scanner(System.in);
        System.out.println("\nEscreva o id do paciente que deseja atualizar: ");
        int atid = sc.nextInt();
        Paciente p = readconv(atid);
        if( p == null){
         System.out.println("\nid inexistente tente novamente");
        }
        else{
        sc.nextLine();
        System.out.println("\nEscreva o Nome do Paciente: ");
        String nome = sc.nextLine();
        
        System.out.println("\nEscreva a idade do Paciente: ");
        Integer idade = sc.nextInt();
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
        p.setEndereco(endereco);
        Paciente paux=readconv(p.getId());
        if(paux!= null){
            paux.setNome(p.getNome());
            paux.setIdade(p.getIdade());
            paux.setEndereco(p.getEndereco());
            return true;
        }
        }
        return false;
    }
     
    public String listAll(){
        String report="";
        for(Paciente p:databasePaciente){
            report+= "Id: "+ p.getId()+"\n";
            report+= "Nome: "+ p.getNome()+"\n";
            report+= "Idade: "+ p.getIdade()+"\n";
            report+= p.getEndereco()+"\n\n";
        }
        return report;
    }
    public boolean delete(){
         Scanner sc = new Scanner(System.in);
        System.out.println("\nInsira o ID do Usuario que deseja remover:");
        int atid = sc.nextInt();
        Paciente p = readconv(atid);     
        if(p!= null){
            databasePaciente.remove(p);
            System.out.println("Removido com Sucesso");
            return true;
        }
        System.out.println("Id Não existente tente novamente");
        return false;
    }
    
    
}
