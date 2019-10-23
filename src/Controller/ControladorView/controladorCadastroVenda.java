package Controller.ControladorView;

import Controller.controladorVendas;
import Model.Venda;
import View.cadastroVenda;

public class controladorCadastroVenda {
    
    private static controladorCadastroVenda instance;
    
    private controladorCadastroVenda() {
    }
    
    public static controladorCadastroVenda getInstance(){
        if(instance==null)
            instance=new controladorCadastroVenda();
        return instance;
    }
    
    public void cadastrarVenda(String cpfCliente, String data, float total, String formaPagamento){     
        int codigo= controladorVendas.getInstance().gerarCodigoVenda();
            Venda vendanova= new Venda(codigo, cpfCliente, data, total, formaPagamento);
            controladorVendas.getInstance().inserirVenda(vendanova);
 
    }

    public void cadastrarVenda(int parseInt, String text, int parseInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void abrirJanela(){
        cadastroVenda.getInstance().setVisible(true);
    }
    
    public void fecharJanela(){
        cadastroVenda.getInstance().dispose();
    }
}
