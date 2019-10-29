package Model;

public class ItemVenda {
    private int codigo_produto;
    private int quantidade;
    private float preco;
    private float totalItem;

    public ItemVenda(int codigo_produto,int quantidade, float preco, float totalItem) {
        this.codigo_produto=codigo_produto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.totalItem = totalItem;
    }

    public int getCodigo_produto() {
        return codigo_produto;
    }

    public void setCodigo_produto(int codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setTotalItem(float totalItem) {
        this.totalItem = totalItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public float getTotalItem() {
        return totalItem;
    }
    
}
