
package Controller.ControladorView;

import Controller.Tabelas.ModeloTabelaProduto;
import Controller.controladorProdutos;
import Model.Produto;
import View.Alterar.AlterarProduto;
import View.mostrarProduto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class controladorMostrarProduto {
    
    ArrayList<Produto> produtos;
    ModeloTabelaProduto modelotabela;
    AlterarProduto alterarproduto;
    mostrarProduto mostrarproduto;
    
    public controladorMostrarProduto() {
       
        alterarproduto=new AlterarProduto(null, true);
        produtos=controladorProdutos.getInstance().retornarProdutos();     
        modelotabela= new ModeloTabelaProduto(produtos); 
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
   
    
    
    
