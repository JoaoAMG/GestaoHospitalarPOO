package gestaohospitalar;

import dao.DAOPaciente;
import estados.Entrada;


public class GestaoHospitalar {

 
    public static void main(String[] args) {
//        EstadosDeAtendimento entrada = new Entrada();
//       System.out.println(entrada.toString());
        DAOPaciente daopaciente = new DAOPaciente();
        daopaciente.create();
       
        System.out.println(daopaciente.read());
        daopaciente.update(); 
        daopaciente.delete();
        System.out.println(daopaciente.listAll());
        
    }
    
}
