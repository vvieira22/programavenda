package Controladores.ControladoresDAO;

import Model.Cliente;
import Model.DAO.ClienteDAO;
import java.util.ArrayList;


public class controladorClientesDAO {
       
    ArrayList<Cliente> listaDeCLientes;

    public controladorClientesDAO() {
        listaDeCLientes=new ArrayList<>();
    }
    
    
    public void inserirCliente(Cliente cliente){
       ClienteDAO.getInstance().inserirClientenoBanco(cliente.getNome(), 
               cliente.getCpf(), 
               cliente.getCodigo(), 
               cliente.getTelefoneum(), 
               cliente.getTelefonedois(), 
               cliente.getEmail(),
               cliente.getRua(), 
               cliente.getNumero(),
               cliente.getBairro(),
               cliente.getComplemento());
    }
    
    public void removerCLiente(String cpf){
        ClienteDAO.getInstance().removerClientedoBanco(cpf);
    }
    
    public void atualizarCLiente(Cliente cliente){
        ClienteDAO.getInstance().atualizarCliente(cliente.getCpf(),
                cliente.getTelefoneum(),
                cliente.getTelefonedois(), 
                cliente.getEmail(), 
                cliente.getRua(), 
                cliente.getNumero(), 
                cliente.getBairro(), 
                cliente.getComplemento());
    }
    
    public ArrayList<Cliente> retornarCLientes(){
        return ClienteDAO.getInstance().retornarTodos();
    }
    
    public Cliente retornarClienteCpf(String cpf){
       this.listaDeCLientes=ClienteDAO.getInstance().retornarTodos();
       
       for(int i=0;i<listaDeCLientes.size();i++){
           if(listaDeCLientes.get(i).getCpf().equals(cpf))
               return listaDeCLientes.get(i);
       }
       return null;
    }
    
    
    
}
