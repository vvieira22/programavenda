package Model.DAO;

import Model.Produto;
import conexaoBanco.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {
    
    private static ProdutoDAO instance;
    
    private ProdutoDAO() {
        
    }
    
    public static synchronized ProdutoDAO getInstance(){
        if(instance==null)
            instance=new ProdutoDAO();
        return instance;      
    }
    
    public void inserirProdutonoBanco(int codigo, float preco, String nome, int quantidade) throws SQLException {
        
        String sql= "insert into produto(codigo, preco, nome, quantidade) values (?,?,?,?)";
        
        try {
            Connection conectar= conexao.getInstance().abrir();      
            PreparedStatement comando=conectar.prepareStatement(sql);
            
            comando.setInt(1,codigo);
            comando.setFloat(2,preco);
            comando.setString(3,nome);
            comando.setInt(4,quantidade);
            
            comando.execute();
            conectar.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public void removerProdutodoBanco(int codigo) {
        String sql= "delete from produto where codigo=?";
        
        try {
            Connection conectar= conexao.getInstance().abrir();  
            PreparedStatement comando=conectar.prepareStatement(sql);            
            
            comando.setInt(1,codigo);
            
            comando.execute();
            conectar.close(); 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Produto> retornarTodos() {
        ArrayList<Produto> listaproduto = new ArrayList<>();
        String sql= "select * from produto";
        
        try {
            Connection conectar= conexao.getInstance().abrir();      
            PreparedStatement comando=conectar.prepareStatement(sql);
            ResultSet resultset=comando.executeQuery(); //vai pegar uma tabela e armazenar no resultset
            
            while(resultset.next()){
                Produto produto= new Produto(quantidadeProdutos()+1, resultset.getFloat("preco"), resultset.getString("nome"), resultset.getInt("quantidade"));
                listaproduto.add(produto);
            }
            conectar.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return listaproduto;
    }
    
    public int quantidadeProdutos() {
        String sql= "select count(*) as quantidade from produto";
        
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
    
    public void atualizarProduto(int codigo, float preco, String nome, int quantidade) {
        String sql= "update produto set codigo=?, preco=?, nome like ?, quantidade=?";
        
        try {
                      
         Connection conectar = conexao.getInstance().abrir();
          PreparedStatement comando= conectar.prepareStatement(sql); 
          comando.setInt(1,codigo);
          comando.setFloat(2,preco);
          comando.setString(3,nome);
          comando.setInt(4,quantidade);
          
          comando.execute();
          conectar.close();   
          
         } catch (Exception e) {
             e.printStackTrace();
         }
    }

}
