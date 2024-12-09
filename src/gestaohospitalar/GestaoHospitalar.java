package gestaohospitalar;

import dao.DAOAtendimento;
import dao.DAOMedico;
import dao.DAOPaciente;
import java.util.Scanner;

public class GestaoHospitalar {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        DAOAtendimento daoatendimento = new DAOAtendimento();
        DAOPaciente daopaciente = new DAOPaciente();
        DAOMedico daomedico = new DAOMedico();
        daoatendimento.setDaomedico(daomedico);
        daoatendimento.setDaopaciente(daopaciente);
        
        daoatendimento.menuInicial();
        Integer menuinicial = 0;
        while(menuinicial != 4){
           daoatendimento.menuOpcoes();
            menuinicial = sc.nextInt();
           switch(menuinicial){ 
               case 1:
                   daopaciente.menuDAOPaciente();
                   Integer opcpaciente = sc.nextInt();
                   switch(opcpaciente){
                       case 1:
                           daopaciente.create();
                       break;
                       case 2:
                           System.out.println(daopaciente.read());
                       break;
                       case 3:
                           daopaciente.update();
                       break;
                       case 4: 
                           System.out.println(daopaciente.listAll());
                       break;
                       case 5:
                           daopaciente.delete();
                       default:
                           System.out.println("Saindo do menu...");
                   }
                   break;
               case 2:
                   daomedico.menuDAOMedico();
                   Integer opcmedico = sc.nextInt();
                   switch(opcmedico){
                       case 1:
                           daomedico.create();
                       break;
                       case 2:
                           System.out.println(daomedico.read());
                       break;
                       case 3:
                           daomedico.update();
                       break;
                       case 4: 
                           System.out.println(daomedico.listAll());
                       break;
                       case 5:
                           daomedico.delete();
                       break;
                       default:
                           System.out.println("Saindo do menu...");
                       break;                
                   }
               break;
               case 3:
                   daoatendimento.menuDAOAtendimento();
                   Integer opcatendimento = sc.nextInt();
                   switch(opcatendimento){
                       case 1:
                           daoatendimento.create();
                       break;
                       case 2:
                           System.out.println(daoatendimento.read());
                       break;
                       case 3:
                           daoatendimento.update();
                       break;
                       case 4:
                           daoatendimento.updateEstadoDeAtendimento();
                       break;
                        case 5: 
                           System.out.println(daoatendimento.listAll());
                       break;
                       case 6:
                           daoatendimento.delete();
                       break;
                       default:
                           System.out.println("Saindo do menu...");                
                   }
               break;
               case 4:
                   System.out.println("Obrigado por utilizar o Sistema tenha um otimo dia");
               break;
               default:
                   System.out.println("Opcao inexistente tente novamente");
           }
        }
    }    
}
