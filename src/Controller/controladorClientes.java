package Controller;

import Model.Cliente;
import Model.ClienteDAO;
import java.util.ArrayList;

public class controladorClientes {

    private static controladorClientes instancia;
    private ArrayList<Cliente> clientes;
    private int quantidadeClientes;

    private controladorClientes() {
        clientes=ClienteDAO.getInstance().retornarTodos();
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
    
    public boolean inserirCliente(Cliente cliente){
        String nome=cliente.getNome();
        String cpf=cliente.getCpf();
        String telefoneum=cliente.getTelefoneum();      
        String telefonedois=cliente.getTelefonedois();
        String email=cliente.getEmail();
        String rua=cliente.getRua();
        int numero=cliente.getNumero();
        String bairro=cliente.getBairro();
        String complemento=cliente.getComplemento();
        
        if(verificarCpfExistente(cliente.getCpf())==false){           
            try{                 
                ClienteDAO.getInstance().inserirClientenoBanco(nome,cpf,telefoneum,telefonedois,email,rua,numero,bairro,complemento);         
                clientes.add(cliente);               
                return true;
            } catch(Exception e){
                return false;
            }     
        }
        return false;
    }

  

    public int gerarCodigoCliente() {
        return ClienteDAO.getInstance().quantidadeClientes()+1;
    }
    
    
    
    
    
    
    
    
}