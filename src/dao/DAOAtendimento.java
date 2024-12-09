package dao;

import estados.Alta;
import estados.Cirurgia;
import estados.ClinicoGeral;
import estados.Entrada;
import estados.PosCirurgia;
import estados.PreCirurgia;
import gestaohospitalar.Atendimento;
import gestaohospitalar.EstadosDeAtendimento;
import gestaohospitalar.Medico;
import gestaohospitalar.Paciente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DAOAtendimento {
    private List<Atendimento> databaseAtendimento = new ArrayList();
    DAOMedico daomedico = new DAOMedico();
    DAOPaciente daopaciente = new DAOPaciente();

    public DAOMedico getDaomedico() {
        return daomedico;
    }

    public void setDaomedico(DAOMedico daomedico) {
        this.daomedico = daomedico;
    }

    public DAOPaciente getDaopaciente() {
        return daopaciente;
    }

    public void setDaopaciente(DAOPaciente daopaciente) {
        this.daopaciente = daopaciente;
    }
    
    
    
    public void menuInicial(){
     System.out.println("\nBem vindos ao Sistema de Gestão Hospitalar");
    }
    
    public void menuOpcoes(){
         System.out.println("\n\nSelecione uma das opcoes"
                + "\n1- Menu de Pacientes"
                + "\n2- Menu de Medicos"
                + "\n3- Menu de Atendimentos"
                + "\n4- Sair do Sistema");
    }
    
    public void menuDAOAtendimento(){
        System.out.println("\nMenu de Atendimentos"
                + "\n1-Inserir Atendimento no sistema"
                + "\n2- Verificar Atendimento por ID no sistema"
                + "\n3- Modificar Atendimento por ID no sistema"
                + "\n4- Modificar Estado de Atendimento, de Atendimento especifico no sistema"
                + "\n5- Mostrar todos os Atendimentos Inseridos no Sistema"
                + "\n6- Excluir Atendimento do Sistema por Id"
                + "\n7- Para sair deste Menu");
    
    }
    public void create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEscreva o id do Medico");
        Integer  idmedico = sc.nextInt();
        
        System.out.println("\nEscreva a id do Paciente");
        Integer idpaciente = sc.nextInt();
        Medico medico = daomedico.readconv(idmedico);
        Paciente paciente = daopaciente.readconv(idpaciente);
        
        System.out.println("\n Insira o numero do  Estado de Atendimento"
                        + "\n(1)Entrada"
                        + "\n(2)Clinico Geral"
                        + "\n(3)Pre-Cirurgia"
                        + "\n(4)Cirurgia"
                        + "\n(5)Pos-Cirurgia"
                        + "\n(6)Alta");
        Integer estado = sc.nextInt();
        switch(estado){
            case 1:
                EstadosDeAtendimento entrada = new Entrada();
                databaseAtendimento.add(new Atendimento(medico,paciente,entrada)); 
                break;
            case 2:
                EstadosDeAtendimento clinicogeral = new ClinicoGeral();
                databaseAtendimento.add(new Atendimento(medico,paciente,clinicogeral)); 
                break;
            case 3:
                EstadosDeAtendimento precirurgia = new PreCirurgia();
                databaseAtendimento.add(new Atendimento(medico,paciente,precirurgia)); 
                break;
            case 4:
                EstadosDeAtendimento cirurgia = new Cirurgia();
                databaseAtendimento.add(new Atendimento(medico,paciente,cirurgia)); 
                break;
            case 5:
                EstadosDeAtendimento poscirurgia = new PosCirurgia();
                databaseAtendimento.add(new Atendimento(medico,paciente,poscirurgia)); 
                break;
            case 6:
                EstadosDeAtendimento alta = new Alta();
                databaseAtendimento.add(new Atendimento(medico,paciente,alta)); 
                break;
        
        }
    }
        
         public Atendimento read() {
         Scanner sc = new Scanner(System.in);
        System.out.println("\nInsira o ID do Atendimento que deseja ver:");
        int id = sc.nextInt();
        for(Atendimento p:databaseAtendimento){
            if(p.getId()==id)
                return p;
            
        }
        return null;
    }
    
     public Atendimento readconv(int id) {
        for(Atendimento p:databaseAtendimento){
            if(p.getId()==id)
                return p;
        }
        return null;
    }
       
     public boolean update(){
          Scanner sc = new Scanner(System.in);
        System.out.println("\nEscreva o id do novo Medico que ira assumir essa consulta: ");
        int atid = sc.nextInt();
        Medico p = daomedico.readconv(atid);
        if(p.getId() != null){
        System.out.println("\nDigite a Senha para  atualizar: ");
            int verificarsenha = sc.nextInt();
            sc.nextLine();

            if(p.getSenha() == verificarsenha){
                System.out.println("\nEscreva o id do Paciente: ");
                Integer idpaciente = sc.nextInt();
                 Paciente e = daopaciente.readconv(idpaciente);
                System.out.println("\nSelecione o id do Atendimento: ");
                Integer idatendimento = sc.nextInt();
                Atendimento a = readconv(idatendimento);
                
                System.out.println("\n Insira o numero do  Estado de Atendimento"
                        + "\n(1)Entrada"
                        + "\n(2)Clinico Geral"
                        + "\n(3)Pre-Cirurgia"
                        + "\n(4)Cirurgia"
                        + "\n(5)Pos-Cirurgia"
                        + "\n(6)Alta");
                Integer estado = sc.nextInt();
                switch(estado){
                    case 1:
                        EstadosDeAtendimento entrada = new Entrada();
                        a.setMedico(p);
                        a.setPaciente(e);
                        a.setEstadosdeatendimento(entrada);
                        break;
                    case 2:
                        EstadosDeAtendimento clinicogeral = new ClinicoGeral();
                        a.setMedico(p);
                        a.setPaciente(e);
                        a.setEstadosdeatendimento(clinicogeral);
                        break;
                    case 3:
                        EstadosDeAtendimento precirurgia = new PreCirurgia();
                        a.setMedico(p);
                        a.setPaciente(e);
                        a.setEstadosdeatendimento(precirurgia);
                        break;
                    case 4:
                        EstadosDeAtendimento cirurgia = new Cirurgia();
                        a.setMedico(p);
                        a.setPaciente(e);
                        a.setEstadosdeatendimento(cirurgia);
                        break;
                    case 5:
                        EstadosDeAtendimento poscirurgia = new PosCirurgia();
                        a.setMedico(p);
                        a.setPaciente(e);
                        a.setEstadosdeatendimento(poscirurgia);
                        break;
                    case 6:
                        EstadosDeAtendimento alta = new Alta();
                        a.setMedico(p);
                        a.setPaciente(e);
                        a.setEstadosdeatendimento(alta);
                        break;
        
        }

               
                Atendimento paux= readconv(a.getId());
                if(paux!= null){
                    paux.setMedico(a.getMedico());
                    paux.setPaciente(a.getPaciente());
                    paux.setEstadosdeatendimento(a.getEstadosdeatendimento());
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
     
    public boolean updateEstadoDeAtendimento(){
          Scanner sc = new Scanner(System.in);
        
        System.out.println("\nSelecione o id do Atendimento: ");
                Integer idatendimento = sc.nextInt();
                Atendimento a = readconv(idatendimento);
                Medico m = a.getMedico();
        if(a.getId() != null){
        System.out.println("\nDigite a Senha do medico: ");
            int verificarsenha = sc.nextInt();
            sc.nextLine();

            if(m.getSenha() == verificarsenha){
               
                
                System.out.println("\n Insira o numero do  Estado de Atendimento"
                        + "\n(1)Entrada"
                        + "\n(2)Clinico Geral"
                        + "\n(3)Pre-Cirurgia"
                        + "\n(4)Cirurgia"
                        + "\n(5)Pos-Cirurgia"
                        + "\n(6)Alta");
                Integer estado = sc.nextInt();
                switch(estado){
                    case 1:
                        EstadosDeAtendimento entrada = new Entrada();


                        a.setEstadosdeatendimento(entrada);
                        break;
                    case 2:
                        EstadosDeAtendimento clinicogeral = new ClinicoGeral();

                        a.setEstadosdeatendimento(clinicogeral);
                        break;
                    case 3:
                        EstadosDeAtendimento precirurgia = new PreCirurgia();

                        a.setEstadosdeatendimento(precirurgia);
                        break;
                    case 4:
                        EstadosDeAtendimento cirurgia = new Cirurgia();

                        a.setEstadosdeatendimento(cirurgia);
                        break;
                    case 5:
                        EstadosDeAtendimento poscirurgia = new PosCirurgia();

                        a.setEstadosdeatendimento(poscirurgia);
                        break;
                    case 6:
                        EstadosDeAtendimento alta = new Alta();
                        
                        a.setEstadosdeatendimento(alta);
                        break;
        
        }

               
                Atendimento paux= readconv(a.getId());
                if(paux!= null){

                    paux.setEstadosdeatendimento(a.getEstadosdeatendimento());
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
        for(Atendimento p:databaseAtendimento){
            report+= "Id do Atendimento: "+ p.getId()+"\n";
            report+= ""+ p.getMedico()+"\n";
            report+= ""+ p.getPaciente()+"\n";
            report+= ""+ p.getEstadosdeatendimento()+"\n\n";

        }
        return report;
    }
     
    
     
    
    public boolean delete(){
         Scanner sc = new Scanner(System.in);
        System.out.println("\nInsira o ID do Atendimento que deseja remover do Sistema :");
        int atid = sc.nextInt();
        Atendimento p = readconv(atid);     
        if(p!= null){
            databaseAtendimento.remove(p);
            System.out.println("Removido com Sucesso");
            return true;
        }
        System.out.println("Id Não existente tente novamente");
        return false;
    }
     
     
     
        
            
    }
    

