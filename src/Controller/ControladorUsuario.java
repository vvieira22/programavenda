/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import Model.UsuarioDAO;
import java.util.ArrayList;
/**
 *
 * @author vitor
 */

public class ControladorUsuario {
    private static ControladorUsuario instance;
    private ArrayList<Usuario> usuarios;
    private int quantidade;
    
    private ControladorUsuario() {
         usuarios=UsuarioDAO.getInstance().retornarTodos();
         quantidade=UsuarioDAO.getInstance().quantidadeUsuarios();
    }

    public static synchronized ControladorUsuario getInstance(){
        if(instance==null)
            instance=new ControladorUsuario();
        return instance;
    }
 
    
    public boolean fazerLogin(String login, String senha){
        for(int i=0;i<quantidade;i++){
            if(usuarios.get(i).getLogin().equals(login) && usuarios.get(i).getSenha().equals(senha))
                return true;
        }
        return false;       
    }
    
    
    
    
    
    
    
    
    
    
}
