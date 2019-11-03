package Controladores;

import Controladores.ControladoresDAO.controladorClientesDAO;
import View.View_Cliente;


public class ControladorClientes {

    ControladorClientes controladorclientes;
    View_Cliente viewcliente;
    controladorClientesDAO controladorclientesdao;
    
    public ControladorClientes() {
        controladorclientes=new ControladorClientes();
        controladorclientesdao=new controladorClientesDAO();
        viewcliente=new View_Cliente(controladorclientesdao);
    }
    
    
    public void abrirJanela(){
        viewcliente.setVisible(true);
    }
    
     
    public void fecharJanela(){
        viewcliente.dispose();
    }
    
    
    
    
    
    
    
    
}
