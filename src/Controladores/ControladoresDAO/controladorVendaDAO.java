package Controladores.ControladoresDAO;

import Model.DAO.VendaDAO;
import Model.Venda;
import java.util.ArrayList;

public class controladorVendaDAO {

    public controladorVendaDAO() {
    } 
    
    public void inserirVenda(Venda venda){        
        VendaDAO.getInstance().inserirVendanoBanco(VendaDAO.getInstance().quantidadeVendas()+1,venda.getCpfCliente(), venda.getData(),venda.getTotal(),venda.getFormaPagamento());
    }
    public ArrayList<Venda> retornarVendas(){
       return VendaDAO.getInstance().retornarTodos();
    }
    
    public ArrayList<Venda> retonarPorCpf(int codigoCliente){
        return VendaDAO.getInstance().retornarPorCliente(codigoCliente);
    }
    
}
