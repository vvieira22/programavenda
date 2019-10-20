
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import conexaoBanco.conexao;
public class ClienteDAO {
    
    
    Connection cone = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    public void inserirClientenoBanco(Cliente cliente){
        
        String sql="insert into clientes(nome,cpf,telefoneum,telefonedois,email,rua,numero,bairro,compelemnto) values (?,?,?,?,?,?,?,?,?,?)";
        
        try {
            Connection conectar= conexao.getInstance().abrir();      
            PreparedStatement comando=conectar.prepareStatement(sql);
        } catch (SQLException e) {
        }
        
        
    }
    
    
    
    
    
    
}
