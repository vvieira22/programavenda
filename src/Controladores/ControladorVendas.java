package Controladores;

import Controladores.ControladoresDAO.controladorVendaDAO;
import Model.ItemVenda;
import View.Cadastro.cadastroVenda;
import java.util.ArrayList;

public class ControladorVendas {
  private ArrayList<ItemVenda> itensvenda; 
  private cadastroVenda cadastrovenda;
  private controladorVendaDAO controladorvendadao;
    
public void abrirJanelaCadastroItemVenda(){
    cadastrovenda=new cadastroVenda(null, true);
    cadastrovenda.setVisible(true);
}

public void fecharJanelaCadastroItemVenda(){
    cadastrovenda.dispose();
}

 public void inserirNaArrayItemVenda(int codigo_produto,int quantidade,float preco, float totalItem){          
     ItemVenda itemvenda= new ItemVenda(codigo_produto, quantidade, preco, totalItem);
     itensvenda.add(itemvenda);
 }
 
 public void limparArrayListVenda(){
    //CASO A VENDA NAO SE CONCRETIZE, VAI OCORRER UM LIMPAMENTO DA ARRAY!!!!!//
     itensvenda.clear();
  }
 
 public void cadastrarVendaFinal(){
     controladorvendadao=new controladorVendaDAO();
     controladorvendadao.inserirItensVenda(null, itensvenda);
     controladorvendadao.inserirVenda(null);
 }
  
}

