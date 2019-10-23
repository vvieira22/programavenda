package Controller.ControladorView;

import Controller.ControladorUsuario;
import View.Login;
import javax.swing.JOptionPane;

public class controladorLogin {
    private static controladorLogin instance;
    
    private controladorLogin() {
    }
    
    public static controladorLogin getInstance(){
        if(instance==null)
            instance=new controladorLogin();
        return instance;
    }
    
    public boolean realizarLogin(String login, String senha){  
        if(ControladorUsuario.getInstance().fazerLogin(login, senha)==true)
            return true;     
        return false;
    }
    
    public void abrirJanela(){
        Login.getIntance().setVisible(true);
    }
    
    
    
}
