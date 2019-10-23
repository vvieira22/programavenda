package Controller;

import Model.Cliente;
import Model.ClienteDAO;
import Model.Venda;
import Model.VendaDAO;
import java.util.ArrayList;

public class controladorClientes {

    private static controladorClientes instancia;
    private ArrayList<Cliente> clientes;
    private ArrayList<Venda> vendas;
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
        for(int i=0;i<quantidadeClientes;i++){
            if(clientes.get(i).getCpf().equals(cpf))    
            return true;
        }
        return false;
    }

    
    public void excluirCliente(String cpf){
        for(int i=0;i<quantidadeClientes;i++){
            if(clientes.get(i).getCpf().equals(cpf))
                ClienteDAO.getInstance().removerClientedoBanco("teste");       
        }       
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
        int codigo=gerarCodigoCliente();
        if(verificarCpfExistente(cliente.getCpf())==false){           
            try{                 
                ClienteDAO.getInstance().inserirClientenoBanco(cpf,nome,codigo,telefoneum,telefonedois,email,rua,numero,bairro,complemento);         
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