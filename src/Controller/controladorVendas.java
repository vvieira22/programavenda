package Controller;

import Model.Venda;
import Model.VendaDAO;
import java.util.ArrayList;


public class controladorVendas {
  
    private static controladorVendas instancia;
    private ArrayList<Venda> vendas;
    private int quantidadeVendas;
    
    private controladorVendas() {
        vendas = VendaDAO.getInstance().retornarTodos();
        quantidadeVendas = VendaDAO.getInstance().quantidadeVendas();
    }
    
    public static synchronized controladorVendas getInstance(){
        if(instancia==null)
            instancia=new controladorVendas();
        return instancia;
    }
    
    public boolean inserirVenda(Venda venda){
        int codigo= gerarCodigoVenda();
        int codigoCliente= venda.getCodigoCliente();
        String data= venda.getData();
        float total= venda.getTotal();
        String formaPagamento= venda.getFormaPagamento();
        
            try{                 
                VendaDAO.getInstance().inserirVendanoBanco(codigo, codigoCliente, data, total, formaPagamento);         
                vendas.add(venda);               
                return true;
            } catch(Exception e){
                return false;
            }     
        }
    
    public int gerarCodigoVenda() {
        return VendaDAO.getInstance().quantidadeVendas()+1;
    }
    
}

