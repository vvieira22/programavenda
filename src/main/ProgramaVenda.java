/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Controller.ControladorView.controladorCadastroCLiente;
import Controller.ControladorView.controladorCadastroProduto;
import Controller.ControladorView.controladorCadastroVenda;
import Controller.ControladorView.controladorLogin;
import Controller.ControladorView.controladorMostrarProduto;
import Controller.controladorClientes;
import Controller.controladorProdutos;
import Model.DAO.ClienteDAO;
import View.Cadastro.cadastroCliente;
import View.Cadastro.cadastroProduto;
import View.JanelaPrincipal;
import View.mostrarProduto;

/**
 *
 * @author vitor
 */
public class ProgramaVenda {

    
    public static void main(String[] args) {
        
       cadastroProduto.getInstance().setVisible(true);
       JanelaPrincipal rs= new JanelaPrincipal();
       rs.setVisible(true);
         
    }
   
    
}
