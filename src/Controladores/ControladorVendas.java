package Controladores;

import Controladores.ControladoresDAO.controladorProdutoDAO;
import Controladores.ControladoresDAO.controladorVendaDAO;
import Model.ItemVenda;
import Model.Produto;
import Model.Venda;
import View.Cadastro.cadastroVenda;
import View.View_Venda;
import java.util.ArrayList;

public class ControladorVendas {
  ArrayList<Produto> arrayprodutos;
  private ArrayList<ItemVenda> itensvenda; 
  private controladorVendaDAO controladorvendadao;
  private controladorProdutoDAO controladorprodutosdao;
  
  View_Venda view_venda;

    public ControladorVendas() {
       itensvenda=new ArrayList<ItemVenda>();
       controladorprodutosdao=new controladorProdutoDAO();
        view_venda=new View_Venda();
    }

  public void abrirJanela(){
      
      view_venda.setVisible(true);
      
  }
  public View_Venda retornarJanela(){
      return view_venda;
  }
  public ArrayList<Produto> retornarProdutos(){
      return arrayprodutos;
  }
 
 ///// ------------------------------------------------------------------------------/////
 
 /*A SEGUIR TUDO É PARA ADICIONAR PRÉVIAMENTE UMA LISTA DE ITEM VENDA, 
 SO VAI PARA O BANCO SE A VENDA SE CONCRETIZAR!*/
  
  //CASO A VENDA NAO SE CONCRETIZE, VAI OCORRER UM LIMPAMENTO DA ARRAY!!!!
  
 public void limparArrayListVenda(){
     itensvenda.clear();
    }
 
 public void inserirNaArrayItemVenda(int codigo_produto,int quantidade,float preco, float totalItem){               
     ItemVenda itemvenda= new ItemVenda(codigo_produto, quantidade, preco, totalItem);
     itensvenda.add(itemvenda); 
     System.out.println(itensvenda.get(0).getQuantidade());
 }
 public boolean verificarSeProdutoJaExiste(int id){
     return controladorprodutosdao.verificarSeProdutoExiste(id);
 }
 
  
public ArrayList<ItemVenda> retornarArrayAntesDeCadastrarNoBanco(){
    return itensvenda;
}
 
 
 
 public int receberArraydeProdutosAtualizada(){
     
     arrayprodutos=controladorprodutosdao.retornarProdutos();
     return arrayprodutos.size();
 }
 
 public void removerNaArrayItemVenda(int codigo_produto){
     for(int i=0;i<itensvenda.size();i++){
         if(codigo_produto==itensvenda.get(i).getCodigo_produto())
             itensvenda.remove(i);
     }
 }
 
 ///// ------------------------------------------------------------------------------/////
 
    
 
 
 
 public void atualizarTabela(){
     view_venda.setarModeloTabela();
 }
 public void cadastrarVendaFinal(Venda venda, ArrayList<ItemVenda> arrayitemvenda){
     controladorvendadao=new controladorVendaDAO();
     controladorvendadao.inserirVenda(venda);
     controladorvendadao.inserirItensVenda(venda, arrayitemvenda);
 }
  
}

