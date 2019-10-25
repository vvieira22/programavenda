package Controller.ControladorView;

import Controller.controladorProdutos;
import Model.Produto;
import View.Cadastro.cadastroProduto;


public class controladorCadastroProduto {
    
    private controladorProdutos controladorprodutos;
    
    private controladorCadastroProduto() {  
        controladorprodutos= new controladorProdutos();
    }
    
    
    public void cadastrarProduto(float preco, String nome, int quantidade){
            int codigo= controladorprodutos.gerarCodigoProduto();
            Produto produtonovo= new Produto(codigo, preco, nome, quantidade);
            controladorprodutos.inserirProduto(produtonovo);
 
    }
    
    public void abrirJanela(){
        cadastroProduto.getInstance().setVisible(true);
    }
    
    public void fecharJanela(){
        cadastroProduto.getInstance().dispose();
    }
}
