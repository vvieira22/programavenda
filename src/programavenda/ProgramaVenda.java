/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programavenda;

import Controller.ControladorView.controladorCadastroCLiente;
import Controller.controladorClientes;
import Model.ClienteDAO;
import View.cadastroCliente;

/**
 *
 * @author vitor
 */
public class ProgramaVenda {

    
    public static void main(String[] args) {
        controladorCadastroCLiente.getInstance().abrirJanela();
    }
   
    
}
