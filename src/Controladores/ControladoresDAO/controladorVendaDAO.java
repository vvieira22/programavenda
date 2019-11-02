package Controladores.ControladoresDAO;

import Model.DAO.ItemVendaDAO;
import Model.DAO.VendaDAO;
import Model.ItemVenda;
import Model.Venda;
import java.util.ArrayList;

public class controladorVendaDAO {

    public controladorVendaDAO() {
    } 
    
    public void inserirVenda(Venda venda){              
        VendaDAO.getInstance().inserirVendanoBanco(venda.getCodigo(),venda.getCpfCliente(), venda.getData(),venda.getTotal(),venda.getFormaPagamento());
    }
    
    public void inserirItensVenda(Venda venda,ArrayList<ItemVenda> itensvenda){
        for(int i=0;i<itensvenda.size();i++){
            ItemVendaDAO.getInstance().inserirItemVendanoBanco(1, 
                    itensvenda.get(i).getCodigo_produto(), 
                    itensvenda.get(i).getQuantidade(), 
                    itensvenda.get(i).getPreco(), 
                    itensvenda.get(i).getTotalItem());           
        }
    }
    
    public ArrayList<Venda> retornarVendas(){
       return VendaDAO.getInstance().retornarTodos();
    }
    
    public ArrayList<ItemVenda> retornarItensVendaPorCpf(int codigocliente){
        //return ItemVendaDAO.getInstance().retornarPorCliente(codigocliente);
        return null;
    }
    
    public int retornarQuantidadeVenda(){
        return VendaDAO.getInstance().quantidadeVendas();
    }
    public ArrayList<Venda> retonarPorCpf(int codigoCliente){
        return VendaDAO.getInstance().retornarPorCliente(codigoCliente);
    }
    
}
