package Controller;

import Model.Produto;
import Model.DAO.ProdutoDAO;
import java.util.ArrayList;

public class controladorProdutos {
    
 
    private ArrayList<Produto> produtos;
    private int quantidadeProdutos;
    
   public controladorProdutos() {
       quantidadeProdutos=ProdutoDAO.getInstance().quantidadeProdutos();    
        produtos=ProdutoDAO.getInstance().retornarTodos();
       
    }
  
    public void excluirProduto(int codigo){
            ProdutoDAO.getInstance().removerProdutodoBanco(codigo);       
    }
    
    public boolean inserirProduto(Produto produto) {
        float preco = produto.getPreco();
        String nome = produto.getNome();
        int quantidade = produto.getQuantidade();
        int codigo=gerarCodigoProduto();
        
        try{                 
                ProdutoDAO.getInstance().inserirProdutonoBanco(codigo, preco, nome, quantidade);         
                produtos.add(produto);               
                return true;
            } catch(Exception e){
                return false;
            }
    }
    public int gerarCodigoProduto() {
        return ProdutoDAO.getInstance().quantidadeProdutos()+1;
    }
    public int retornarQuantidade(){
        return quantidadeProdutos;
    }
    
    public ArrayList<Produto> retornarProdutos(){
        return produtos;
    }
    
    public void atualizarProduto(float preco,int quantidade,int codigo){
        ProdutoDAO.getInstance().atualizarProduto(preco, quantidade,codigo);
    }
    
}
