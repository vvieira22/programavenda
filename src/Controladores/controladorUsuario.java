/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Model.Usuario;
import Model.DAO.UsuarioDAO;
import java.util.ArrayList;
/**
 *
 * @author vitor
 */

public class controladorUsuario {
    private static controladorUsuario instance;
    private ArrayList<Usuario> usuarios;
    private int quantidade;
    
    private controladorUsuario() {
         usuarios=UsuarioDAO.getInstance().retornarTodos();
         quantidade=UsuarioDAO.getInstance().quantidadeUsuarios();
    }

    public static synchronized controladorUsuario getInstance(){
        if(instance==null)
            instance=new controladorUsuario();
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
