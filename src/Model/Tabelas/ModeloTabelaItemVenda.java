/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Tabelas;

import Model.ItemVenda;
import Model.Produto;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vvieira
 */
public class ModeloTabelaItemVenda extends AbstractTableModel {

    private static final int colunaCodigo=0;
    private static final int colunaQuantidade=1;   
    private static final int colunaPreco=2;
    private static final int colunaTotal=3;
    private  String[] colunas= new String[]{"Codigo Produto","Quantidade","Preço","Total"};
    private ArrayList<ItemVenda> itemvenda;
    
    public ModeloTabelaItemVenda(ArrayList<ItemVenda> ItemVenda) {
        this.itemvenda= ItemVenda;
    }

        @Override
        public String getColumnName(int columnIndex){
            return colunas[columnIndex];
        }

    @Override
    public int getRowCount() {
        return itemvenda.size();
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
        ItemVenda itemvendaa= itemvenda.get(row);
        switch(col){
            case colunaCodigo:
                return itemvendaa.getCodigo_produto();
            case colunaQuantidade:
                return itemvendaa.getQuantidade();
            case colunaPreco:
                return itemvendaa.getPreco();
            case  colunaTotal:
                return itemvendaa.getTotalItem();
        }
        return "";
    }
    
    @Override
     public void setValueAt(Object aValue, int row, int column){
        // Produto produto= produtos.get(row);
         switch(column){
            case colunaCodigo:
              
            case colunaQuantidade:
               
            case colunaPreco:
           
            case  colunaTotal:
           
         }
     } 
     
     public ItemVenda obterProduto(int indice) {
         return itemvenda.get(indice);
     }
     
     public void incluirProduto(Produto produto) {
         //produtos.add(produto);
         int ultimo = getRowCount()-1;
         //FireTableRowsInserted(ultimo,ultimo);
     }
     
     public void atualizarProduto(int indice, Produto produto) {
        // produtos.set(indice, produto);
        // FireTableRowsUpdated(indice,produto);
         
     }
     
     public void excluirPessoa(int indice) {
        // produtos.remove(indice);
        // FireTableRowsDeleted(indice,indice);
     }

  
}
