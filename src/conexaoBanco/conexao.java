
package conexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexao {
    
    private static conexao instance;
    private static final String USUARIO = "root";
    private static final String SENHA = "123456";
    private static final String URL = "jdbc:mysql://localhost:3306/programa_venda?&useSSL=FALSE";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
  
    private conexao() {     
    }
    
    public static synchronized conexao getIntance(){
        if(instance==null)
            instance=new conexao();
        return instance;
    }
    
    
    public static conexao getInstance(){
        if(instance==null)
            instance=new conexao();
        return instance;
    }
    
    public static Connection abrir() {
        
        try {
            Class.forName(DRIVER);
           Connection conexao= DriverManager.getConnection(URL,USUARIO,SENHA);
           return conexao;
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    
    }
    
    

