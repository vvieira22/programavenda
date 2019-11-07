package Controladores;

import Controladores.ControladoresDAO.controladorClientesDAO;
import Model.Cliente;
import View.View_Cliente;


public class ControladorClientes {

    ControladorClientes controladorclientes;
    View_Cliente viewcliente;
    controladorClientesDAO controladorclientesdao;
    
    public ControladorClientes() {
        controladorclientes=new ControladorClientes();
        controladorclientesdao=new controladorClientesDAO();
        viewcliente=new View_Cliente();
    }
    public void alterarCliente(Cliente cliente,String nome, String telefoneum, String telefonedois,
                                String email,
                                String rua,
                                int numero,
                                String Bairro,
                                String complemento){
            
    }
        
    
    
    public void abrirJanela(){
        viewcliente.setVisible(true);
    }
    
     
    public void fecharJanela(){
        viewcliente.dispose();
    }
    
    
    
    
    
    
    
    
}
