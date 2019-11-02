
package Controller.Tabelas;

import Model.Venda;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vvieira
 */
public class ModeloTabelaVenda extends AbstractTableModel {

    private static final int colunaData=1;
    private static final int colunaTotal=2;
    private static final int colunaCpf=0;      
    
    private final  String[] colunas= new String[]{"Cpf Cliente","Data","Total"};
    private ArrayList<Venda> venda;
    
    public ModeloTabelaVenda(ArrayList<Venda> venda) {
        this.venda=venda;
    }
   

        @Override
        public String getColumnName(int columnIndex){
            return colunas[columnIndex];
        }

    @Override
    public int getRowCount() {
        return venda.size();
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
        Venda venda= this.venda.get(row);
        switch(col){
            case colunaCpf:
                return venda.getCpfCliente();
            case colunaData:             /*        
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
                Date data; 
            data = formato.parse(venda.getData());
            formato.applyPattern("dd/MM/yyyy hh:mm:ss a");                           
                String dataFormatada = formato.format(data);
                return dataFormatada;            */
                return venda.getData();
       //} catch (ParseException ex) {
         //  
        //}                 
            case colunaTotal:
                return venda.getTotal();//+"  R$";
        }
        return "";
    }
    
    @Override
     public void setValueAt(Object aValue, int row, int column){
         Venda vendaa= venda.get(row);
         switch(column){
            case colunaCpf:
              //  produto.setNome(produto.());
            case colunaData:
               // prodto.atualizarPreco(produto.getPreco());
            case colunaTotal:
           //       produto.atualizarQuantidade(produto.getQuantidade());
            
         }
     } 
     
     public Venda obterProduto(int indice) {
         return venda.get(indice);
     }

  
}
