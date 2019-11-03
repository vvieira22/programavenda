package Controladores.ControladoresDAO;

import Model.Produto;
import Model.DAO.ProdutoDAO;
import java.util.ArrayList;

public class controladorProdutoDAO {
       
    public controladorProdutoDAO() {        
    }
  
    public void excluirProduto(int codigo){
        ProdutoDAO.getInstance().removerProdutodoBanco(codigo);       
    }
    
    public boolean inserirProduto(float preco, String nome, int quantidade) {      
        int codigo=gerarCodigoProduto();
        
        try{                 
            ProdutoDAO.getInstance().inserirProdutonoBanco(codigo, preco, nome, quantidade);                     
                return true;
            } catch(Exception e){
                return false;
            }
    }
    
    public int gerarCodigoProduto() {
        return ProdutoDAO.getInstance().quantidadeProdutos()+1;
    }  
    public boolean verificarSeProdutoExiste(int id){
        return ProdutoDAO.getInstance().verificarSeProdutoJaExiste(id);
    }
    public ArrayList<Produto> retornarProdutos(){
        return ProdutoDAO.getInstance().retornarTodos();
    }
    
    public void atualizarProduto(float preco,int quantidade,int codigo){
        ProdutoDAO.getInstance().atualizarProduto(preco, quantidade,codigo);
    }
    
}
