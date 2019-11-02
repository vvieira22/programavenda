package Model.DAO;

import Model.Venda;
import conexaoBanco.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ItemVendaDAO {
    
    private static ItemVendaDAO instance;
    
    private ItemVendaDAO() {
    }
    
    public static synchronized ItemVendaDAO getInstance(){
        if(instance==null)
            instance=new ItemVendaDAO();
        return instance;      
    }
    
    public void inserirItemVendanoBanco(int codigo_venda, int codigo_produto, int quantidade , float preco,float precototal){
        
        String sql="insert into item_venda(codigo_venda, codigo_produto, quantidade, preco ,total_item) values (?,?,?,?,?)";
            
        try {
            Connection conectar= conexao.getInstance().abrir();      
            PreparedStatement comando=conectar.prepareStatement(sql);
            
            comando.setInt(1,1);
            comando.setInt(2,codigo_produto);
            comando.setInt(3,quantidade);
            comando.setFloat(4,preco);
            comando.setFloat(5,precototal); 
            
            comando.execute();
            conectar.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }      
    }
    
    public ArrayList<Venda> retornarTodos(){
        ArrayList<Venda> listaVenda= new ArrayList<>();
        String sql="select * from venda";
        
        try {
            Connection conectar= conexao.getInstance().abrir();      
            PreparedStatement comando=conectar.prepareStatement(sql);
            ResultSet resultset=comando.executeQuery(); //vai pegar uma tabela e armazenar no resultset
            
            while(resultset.next()){
                Venda venda= new Venda(quantidadeVendas()+1, resultset.getString("cpf_cliente"), resultset.getString("data"), resultset.getFloat("total"), resultset.getString("formaPagamento"));
                listaVenda.add(venda);
            }
            conectar.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return listaVenda;
    }
    
    public ArrayList<Venda> retornarPorCliente(int codigoCliente){
        ArrayList<Venda> listaVenda= new ArrayList<>();
        String sql="select * from venda where codigoCliente = ?";
        
        try {
            Connection conectar= conexao.getInstance().abrir();      
            PreparedStatement comando=conectar.prepareStatement(sql);
            ResultSet resultset=comando.executeQuery(); //vai pegar uma tabela e armazenar no resultset
            
            while(resultset.next()){
                Venda venda= new Venda(quantidadeVendas()+1, resultset.getString("cpf_cliente"), resultset.getString("data"), resultset.getFloat("total"), resultset.getString("formaPagamento"));
                listaVenda.add(venda);
            }
            conectar.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return listaVenda;
    }
    
    public int quantidadeVendas(){
        String sql="select count(*) as quantidade from venda";
        
        try {
            Connection conectar = conexao.getInstance().abrir();
            PreparedStatement comando= conectar.prepareCall(sql);          
            ResultSet resultset=comando.executeQuery(); 
            resultset.next(); 
            return resultset.getInt("quantidade");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return -1;
        }         
    }   
}
