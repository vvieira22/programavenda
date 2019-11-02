package Model.DAO;

import Model.Venda;
import conexaoBanco.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class VendaDAO {
    
    private static VendaDAO instance;
    
    private VendaDAO() {
    }
    
    public static synchronized VendaDAO getInstance(){
        if(instance==null)
            instance=new VendaDAO();
        return instance;      
    }

    public void inserirVendanoBanco(int codigo, String cpf_cliente, String data, float total, String formaPagamento){
        
        String sql="insert into venda(codigo, cpf_cliente, data, total, forma_pagamento) values (?,?,now(),?,?)";
            
        try {
            Connection conectar= conexao.getInstance().abrir();      
            PreparedStatement comando=conectar.prepareStatement(sql);
            
            comando.setInt(1,codigo);
            comando.setString(2,cpf_cliente);
            comando.setFloat(3,total);
            comando.setString(4,formaPagamento); 
            
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
                Venda venda= new Venda(Integer.parseInt(resultset.getString("codigo")), resultset.getString("cpf_cliente"), resultset.getString("data"), resultset.getFloat("total"), resultset.getString("forma_pagamento"));
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
                Venda venda= new Venda(quantidadeVendas()+1, resultset.getString("cpf_cliente"), resultset.getString("data"), resultset.getFloat("total"), resultset.getString("forma_pagamento"));
                JOptionPane.showMessageDialog(null, venda.getData());
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
    public String retornarHora(int idvenda){
        String sql="select data from venda where codigo=?";
        
        try {
            Connection conectar= conexao.getInstance().abrir();
            PreparedStatement comando=conectar.prepareCall(sql);
            
            comando.setInt(1,idvenda);
            
            ResultSet resultset=comando.executeQuery(); 
            resultset.next(); 
            return resultset.getString("data");
            
        } catch (Exception e) {
        }
        return null;
    }
    
}
