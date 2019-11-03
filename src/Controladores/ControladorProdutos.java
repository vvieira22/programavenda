package Controladores;

import Controladores.ControladoresDAO.controladorProdutoDAO;
import Model.Tabelas.ModeloTabelaProduto;
import View.View_Produto;


public class ControladorProdutos {
    
    private controladorProdutoDAO controladorprodutosdao;
    private View.View_Produto viewproduto;
    private ModeloTabelaProduto modelotabelaproduto;
    
    public ControladorProdutos() {       
        controladorprodutosdao= new controladorProdutoDAO();
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
