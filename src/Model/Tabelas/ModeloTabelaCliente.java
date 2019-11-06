/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Tabelas;

import Model.Cliente;
import Model.Produto;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vvieira
 */
public class ModeloTabelaCliente extends AbstractTableModel {

    private static final int colunaNome=0;
    private static final int colunaCpf=1;   
    private static final int colunaCodigo=2;
    private  String[] colunas= new String[]{"Nome","CPF","Codigo"};
    private ArrayList<Cliente> clientes;
    
    public ModeloTabelaCliente(ArrayList<Cliente> clientes) {
        this.clientes= clientes;
    }

        @Override
        public String getColumnName(int columnIndex){
            return colunas[columnIndex];
        }

    @Override
    public int getRowCount() {
        return clientes.size();
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
        Cliente cliente= clientes.get(row);
        switch(col){
            case colunaNome:
                return cliente.getNome();
            case colunaCpf:
                return cliente.getCpf();
            case colunaCodigo:
                return cliente.getCodigo();
            
        }
        return "";
    }
    
    @Override
     public void setValueAt(Object aValue, int row, int column){
         Cliente cliente= clientes.get(row);
         switch(column){
            case colunaNome:
              //  produto.setNome(produto.());
            case colunaCpf:
               // produto.atualizarPreco(produto.getPreco());
            case colunaCodigo:
           //       produto.atualizarQuantidade(produto.getQuantidade());
         }
     } 
     
    

  
}
