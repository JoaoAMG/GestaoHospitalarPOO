
package dao;

import gestaohospitalar.Atendimento;
import gestaohospitalar.Endereco;
import gestaohospitalar.Medico;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DAOAtendimento {
    private List<Atendimento> databaseAtendimento = new ArrayList();
    
    public void menuDAOPaciente(){
        System.out.println("Menu de Atendimentos"
                + "\n1-Inserir Atendimento no sistema"
                + "\n2- Verificar Atendimento por ID no sistema"
                + "\n3- Modificar Atendimento por ID no sistema"
                + "\n4- Mostrar todos os Atendimentos Inseridos no Sistema"
                + "\n5- Excluir Atendimento do Sistema por Id"
                + "\n6- Para sair deste Menu");
    
    }
    public void create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEscreva o id do Medico");
        Integer  idmedico = sc.nextInt();
        
        System.out.println("\nEscreva a id do Paciente");
        Integer idade = sc.nextInt();
        
        System.out.println("\n Insira o numero do  Estado de Atendimento ");
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
        databaseAtendimento.add(new Medico(nome,idade,crm,senha,endereco));     
    }
    
}
