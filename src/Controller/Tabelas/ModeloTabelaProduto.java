/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Tabelas;

import Model.Produto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vvieira
 */
public class ModeloTabelaProduto extends AbstractTableModel {

    private static final int colunaNome=0;
    private static final int colunaPreco=1;   
    private static final int colunaQuantidade=2;
    private static final int colunaCodigo=3;
    private  String[] colunas= new String[]{"Nome","Preço","Quantidade","Código"};
    private ArrayList<Produto> produtos;
    
    public ModeloTabelaProduto(ArrayList<Produto> produto) {
        this.produtos= produto;
    }

        @Override
        public String getColumnName(int columnIndex){
            return colunas[columnIndex];
        }

    
       
    
    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
        public boolean isCellEditable(int rowIndex,int columnIndex){
            return false;
        }
   
    @Override
    public Object getValueAt(int row, int col){
        Produto produto= produtos.get(row);
        switch(col){
            case colunaNome:
                return produto.getNome();
            case colunaPreco:
                return produto.getPreco();
            case colunaQuantidade:
                return produto.getQuantidade();
            case  colunaCodigo:
                return produto.getCodigo();
        }
        return "";
    }
    
    @Override
     public void setValueAt(Object aValue, int row, int column){
         Produto produto= produtos.get(row);
         switch(column){
            case colunaNome:
              //  produto.setNome(produto.());
            case colunaPreco:
               // produto.atualizarPreco(produto.getPreco());
            case colunaQuantidade:
           //       produto.atualizarQuantidade(produto.getQuantidade());
            case  colunaCodigo:
             //    produto.atualizarCodigo(produto.getCodigo());
         }
     } 
     
     public Produto obterProduto(int indice) {
         return produtos.get(indice);
     }
     
     public void incluirProduto(Produto produto) {
         produtos.add(produto);
         int ultimo = getRowCount()-1;
         //FireTableRowsInserted(ultimo,ultimo);
     }
     
     public void atualizarProduto(int indice, Produto produto) {
         produtos.set(indice, produto);
        // FireTableRowsUpdated(indice,produto);
         
     }
     
     public void excluirPessoa(int indice) {
         produtos.remove(indice);
        // FireTableRowsDeleted(indice,indice);
     }

  
}
