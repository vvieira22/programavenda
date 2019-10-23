package Controller.ControladorView;

import Controller.controladorProdutos;
import Model.Produto;
import View.cadastroProduto;


public class controladorCadastroProduto {
    
    private static controladorCadastroProduto instance;
    
    private controladorCadastroProduto() {  
    }
    
    public static controladorCadastroProduto getInstance(){
        if(instance==null)
            instance=new controladorCadastroProduto();
        return instance;
    }
    
    public void cadastrarProduto(int codigo, float preco, String nome, int quantidade){
   
            Produto produtonovo= new Produto(codigo, preco, nome, quantidade);
            controladorProdutos.getInstance().inserirProduto(produtonovo);
 
    }
    
    public void abrirJanela(){
        cadastroProduto.getInstance().setVisible(true);
    }
    
    public void fecharJanela(){
        cadastroProduto.getInstance().dispose();
    }
}
