package Controller;

import Model.Cliente;
import java.util.ArrayList;

public class controladorClientes {

    private static controladorClientes instancia;
    private ArrayList<Cliente> clientes;
    private int quantidadeClientes;

    private controladorClientes() {
        clientes=new ArrayList<>();
        quantidadeClientes=0;
    }
    
    public static controladorClientes getInstance(){
        if(instancia==null)
            instancia=new controladorClientes();
        return instancia;
    }
    
    
    public boolean verificarCpfExistente(String cpf){
        for (int i = 0; i < quantidadeClientes; i++) {
            if(clientes.get(i).getCpf().equals(cpf))
                return true;   
        }
        return false;
    }
    

    public void excluirCliente(String nome){
        for (int i = 0; i < quantidadeClientes; i++) {
            if(clientes.get(i).getNome().equals(nome)){
                clientes.remove(i);
                break;
                //dizer que removeu
            }   
        } 
    }
    
    public boolean inserirCliente(String nome, String cpf, String telefoneum, String telefonedois, String email, String rua, int numero, String bairro, String complemento){
        if(verificarCpfExistente(cpf)==false){
            
            try{
                clientes.add(new Cliente(nome, cpf, telefoneum, telefonedois, email, rua, numero, bairro, complemento));
                return true;
            } catch(Exception e){
                return false;
            }     
        }
        return false;
    }
    
    
    
    
    
    
    
    
}