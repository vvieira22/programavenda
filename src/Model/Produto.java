package Model;

public class Produto {
    private int codigo;
    private float preco;
    private String nome;
    private int quantidade;

    public Produto(int codigo, float preco, String nome, int quantidade) {
        this.codigo = codigo;
        this.preco = preco;
        this.nome = nome;
        this.quantidade = quantidade;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public float getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    
}
