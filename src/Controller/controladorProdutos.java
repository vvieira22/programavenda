package Controller;

import Model.Produto;
import Model.ProdutoDAO;
import java.util.ArrayList;


public class controladorProdutos {
    
    private static controladorProdutos instancia;
    private ArrayList<Produto> produtos;
    private int quantidadeProdutos;
    
    private controladorProdutos() {
        produtos=ProdutoDAO.getInstance().retornarTodos();
        quantidadeProdutos=ProdutoDAO.getInstance().quantidadeProdutos();    
    }
    
    public static synchronized controladorProdutos getInstance(){
        if(instancia==null)
            instancia=new controladorProdutos();
        return instancia;
    }
    
    public void excluirProduto(int codigo){
            ProdutoDAO.getInstance().removerProdutodoBanco(1);       
    }
    
    public boolean inserirProduto(Produto produto) {
        int codigo = produto.getCodigo();
        float preco = produto.getPreco();
        String nome = produto.getNome();
        int quantidade = produto.getQuantidade();
        
        try{                 
                ProdutoDAO.getInstance().inserirProdutonoBanco(codigo, preco, nome, quantidade);         
                produtos.add(produto);               
                return true;
            } catch(Exception e){
                return false;
            }
    }
    
    
}
