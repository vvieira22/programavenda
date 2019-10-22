package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import conexaoBanco.conexao;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClienteDAO {

    private static ClienteDAO instance;
   
    private ClienteDAO() {
    }
                
    public static synchronized ClienteDAO getInstance(){
        if(instance==null)
            instance=new ClienteDAO();
        return instance;      
    }

    public void inserirClientenoBanco(Cliente cliente){
        
        String sql="insert into cliente(nome,cpf,telefoneum,telefonedois,email,rua,numero,bairro,compelemnto) values (?,?,?,?,?,?,?,?,?,?)";
            
        try {
            Connection conectar= conexao.getInstance().abrir();      
            PreparedStatement comando=conectar.prepareStatement(sql);
            
            comando.setString(1,cliente.getNome());
            comando.setString(3,cliente.getCpf());
            comando.setString(3,cliente.getTelefoneum());
            comando.setString(4,cliente.getTelefonedois());
            comando.setString(5,cliente.getEmail());
            comando.setString(6,cliente.getRua());
            comando.setInt(7,cliente.getNumero());
            comando.setString(8,cliente.getBairro());
            comando.setString(9,cliente.getComplemento());  
            
            comando.execute();
            conectar.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }      
    }
    
    public void removerClientedoBanco(String cpf){
        String sql="delete from cliente where cpf like ?";
        
        try {
            Connection conectar= conexao.getInstance().abrir();  
            PreparedStatement comando=conectar.prepareStatement(sql);            
            
            comando.setString(1,cpf);
            
            comando.execute();
            conectar.close();           
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public ArrayList<Cliente> listarTodos(){
        ArrayList<Cliente> listacliente= new ArrayList<>();
        String sql="select * from cliente";
        
        try {
            Connection conectar= conexao.getInstance().abrir();      
            PreparedStatement comando=conectar.prepareStatement(sql);
            ResultSet resultset=comando.executeQuery(); //vai pegar uma tabela e armazenar no resultset
            
            while(resultset.next()){
                Cliente cliente= new Cliente(resultset.getString("nome"), resultset.getString("cpf"), resultset.getString("telefoneum"),resultset.getString("telefonedois"), resultset.getString("email"), resultset.getString("rua"), resultset.getInt("numero"), resultset.getString("bairro"), resultset.getString("complemento"));
                listacliente.add(cliente);
            }
            conectar.close();
        } catch (Exception e) {
        }
        return listacliente;
    }
 
     public int quantidadeClientes(){
        String sql="select count(*) as quantidade from cliente";
        
        try {
            Connection conectar = conexao.getInstance().abrir();
            PreparedStatement comando= conectar.prepareCall(sql);
            
            ResultSet resultset=comando.executeQuery(); 
            resultset.next(); 
            return resultset.getInt("quantidade");
        } catch (SQLException e) {
            return -1;
        }         
    }
     
     
     
}
