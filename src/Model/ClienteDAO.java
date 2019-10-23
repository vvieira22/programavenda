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

    public void inserirClientenoBanco(String nome, String cpf, String telefoneum, String telefonedois, String email, String rua, int numero, String bairro, String complemento){
        
        String sql="insert into cliente(nome,cpf,telefoneum,telefonedois,email,rua,numero,bairro,complemento) values (?,?,?,?,?,?,?,?,?)";
            
        try {
            Connection conectar= conexao.getInstance().abrir();      
            PreparedStatement comando=conectar.prepareStatement(sql);
            
            comando.setString(1,nome);
            comando.setString(2,cpf);
            comando.setString(3,telefoneum);
            comando.setString(4,telefonedois);
            comando.setString(5,email);
            comando.setString(6,rua);
            comando.setInt(7,numero);
            comando.setString(8,bairro);
            comando.setString(9,complemento);  
            
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
            e.printStackTrace();
        }
    }
    public boolean verificarCpf(String cpf){
        String sql= "select * from cliente where cpf like ?";
          try {
             Connection conectar= conexao.getInstance().abrir();      
             PreparedStatement comando= conectar.prepareCall(sql);
             comando.setString(1,cpf);
             ResultSet resultset=comando.executeQuery(); 
             resultset.next();
             
             if(resultset.getString("cpf").equals(cpf))
                 return true;          
        } catch (Exception e) {
            return false;      
        }
           return false;  
        }
    
    public ArrayList<Cliente> retornarTodos(){
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
           e.printStackTrace();
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
     
     public void atualizarCliente(String cpf,String telefoneum,String telefonedois,String email, String rua, int numero, String bairro, String complemento){
         String sql="update cliente set telefoneum like ?, telefonedois like ?, email like ?, rua like ?, numero=?, bairro like ?, complemento like ? where cpf like ?";
         
         try {
                      
         Connection conectar = conexao.getInstance().abrir();
          PreparedStatement comando= conectar.prepareStatement(sql); 
          comando.setString(1,telefoneum);
          comando.setString(2,telefonedois);
          comando.setString(3,email);
          comando.setString(4,rua);
          comando.setInt(5,numero);
          comando.setString(6,bairro);
          comando.setString(7,complemento);
          comando.setString(8,cpf);    
          
          comando.execute();
          conectar.close();   
          
         } catch (Exception e) {
             e.printStackTrace();
         }
     
     }
     
}
