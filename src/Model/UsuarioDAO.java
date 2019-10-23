package Model;

import conexaoBanco.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UsuarioDAO {
    private static UsuarioDAO  instance;

    private UsuarioDAO() {
    }
    
    
    public static synchronized UsuarioDAO getInstance(){
        if(instance==null)
            instance=new UsuarioDAO();
        return instance;
    }
    
    public ArrayList<Usuario> retornarTodos(){
        ArrayList<Usuario> listausuarios= new ArrayList<>();
        String sql="select * from usuario";
        
        try {
            Connection conectar= conexao.getInstance().abrir();      
            PreparedStatement comando=conectar.prepareStatement(sql);
            ResultSet resultset=comando.executeQuery(); //vai pegar uma tabela e armazenar no resultset
            
            while(resultset.next()){
                Usuario usuario= new Usuario(resultset.getString("login"),resultset.getString("senha"),resultset.getString("perfil"),resultset.getString("nome"),resultset.getInt("codigo"));
                listausuarios.add(usuario);
            }
            conectar.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return listausuarios;
    }
    public int quantidadeUsuarios(){
        String sql="select count(*) as quantidade from usuario";       
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
