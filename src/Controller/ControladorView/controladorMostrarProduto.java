
package Controller.ControladorView;

import Controller.Tabelas.ModeloTabelaProduto;
import Controller.controladorProdutos;
import Model.Produto;
import View.Alterar.AlterarProduto;
import View.mostrarProduto;
import java.util.ArrayList;


public class controladorMostrarProduto {
    
    ArrayList<Produto> produtos;
    ModeloTabelaProduto modelotabela;
    AlterarProduto alterarproduto;
    mostrarProduto mostrarproduto;
    
    public controladorMostrarProduto() {
        produtos= new controladorProdutos().retornarProdutos();
        modelotabela= new ModeloTabelaProduto(produtos); 
        alterarproduto=new AlterarProduto(null, true);
        mostrarproduto= new mostrarProduto(alterarproduto,modelotabela);
       
        
         setarModelo();
    }
    
   public void setarModelo(){
       mostrarproduto.setarModelo(this.modelotabela);
   }
   
   public void abrirJanela(){
       mostrarproduto.setVisible(true);
   }
   
  public mostrarProduto retornar(){
      return mostrarproduto;
  }
  
  public void abrirAlterarProduto(){
      alterarproduto.setVisible(true);
  }
  
  public void fecharAlterarProduto(){
      alterarproduto.dispose();
  }
  
}
   
    
    
    
