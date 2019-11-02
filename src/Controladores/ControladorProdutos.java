package Controladores;

import Controladores.ControladoresDAO.controladorProdutosDAO;
import Controller.Tabelas.ModeloTabelaProduto;
import View.View_Produto;


public class ControladorProdutos {
    
    private controladorProdutosDAO controladorprodutosdao;
    private View.View_Produto viewproduto;
    private ModeloTabelaProduto modelotabelaproduto;
    
    public ControladorProdutos() {       
        controladorprodutosdao= new controladorProdutosDAO();
        modelotabelaproduto= new ModeloTabelaProduto(controladorprodutosdao.retornarProdutos());
        viewproduto= new View_Produto(controladorprodutosdao);
    }   
    
    public void atualizarTabela(){
        viewproduto.setarModeloTabela();
    }
    
    public View_Produto retornarViewProduto(){
        return viewproduto;
    }
       
    
    public void abrirJanelaProduto(){     
        viewproduto.setVisible(true);
    }
    
    public void fecharJanelaProduto(){
        viewproduto.dispose();
    }
    
    
    
    
    
    
}
