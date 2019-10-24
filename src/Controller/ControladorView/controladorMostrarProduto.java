
package Controller.ControladorView;

import Controller.controladorProdutos;
import Model.Produto;
import View.mostrarProduto;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class controladorMostrarProduto {
    mostrarProduto mostrarproduto;
    ArrayList<Produto> produtos;

    public controladorMostrarProduto() {
        produtos=controladorProdutos.getInstance().retornarProdutos();     
        mostrarproduto=new mostrarProduto();
        fazisso();
        atualizarTabela();

    }
    public mostrarProduto retornarmostrarProduto(){
        return mostrarproduto;
    }
    public void fazisso(){
        System.out.println(produtos.size());
    }
    
    public void atualizarTabela(){
        try {
        DefaultTableModel tabelaproduto;
        tabelaproduto=(DefaultTableModel) mostrarproduto.pegarModeloTabela();
                      
        for(int i=0;i<controladorProdutos.getInstance().retornarQuantidade();i++){
              tabelaproduto.addRow(new Object[]{
              produtos.get(i).getNome(),
              produtos.get(i).getPreco(),
              produtos.get(i).getQuantidade(),
              produtos.get(i).getCodigo()
          });
      }
        } catch (Exception e) {      
        }     
}
}
