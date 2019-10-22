package Controller;

import Model.Cliente;
import Model.ClienteDAO;
import java.util.ArrayList;

public class controladorClientes {

    private static controladorClientes instancia;
    private ArrayList<Cliente> clientes;
    private int quantidadeClientes;

    private controladorClientes() {
        clientes=ClienteDAO.getInstance().listarTodos();
        quantidadeClientes=ClienteDAO.getInstance().quantidadeClientes();
    }
     
    public static synchronized controladorClientes getInstance(){
        if(instancia==null)
            instancia=new controladorClientes();
        return instancia;
    }
    
    
    public boolean verificarCpfExistente(String cpf){
        if(ClienteDAO.getInstance().verificarCpf(cpf)==true)
            return true;
        return false;
    }
    

    public void excluirCliente(String cpf){
        if(verificarCpfExistente(cpf)==true)
            ClienteDAO.getInstance().removerClientedoBanco("teste");       
    }
    
    public boolean inserirCliente(String nome, String cpf, String telefoneum, String telefonedois, String email, String rua, int numero, String bairro, String complemento){
        if(verificarCpfExistente(cpf)==false){           
            try{              
                Cliente cliente=new Cliente(nome, cpf, telefoneum, telefonedois, email, rua, numero, bairro, complemento);               
                clientes.add(cliente);
                ClienteDAO.getInstance().inserirClientenoBanco(cliente);                
                return true;
            } catch(Exception e){
                return false;
            }     
        }
        return false;
    }
    
    
    
    
    
    
    
    
}