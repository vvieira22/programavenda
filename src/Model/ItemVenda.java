package Model;

public class ItemVenda {
    private int quantidade;
    private float preco;
    private float totalItem;

    public ItemVenda(int quantidade, float preco, float totalItem) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.totalItem = totalItem;
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
