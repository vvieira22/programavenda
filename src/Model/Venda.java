package Model;

public class Venda {
    private int codigo;
    private int codigoCliente;
    private String data;
    private float total;
    private String formaPagamento;

    public Venda(int codigo, int codigoCliente, String data, float total, String formaPagamento) {
        this.codigo = codigo;
        this.codigoCliente = codigoCliente;
        this.data = data;
        this.total = total;
        this.formaPagamento = formaPagamento;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public void setTotal(float total) {
        this.total = total;
    }
    
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public int getCodigoCliente() {
        return codigoCliente;
    }

    public String getData() {
        return data;
    }

    public float getTotal() {
        return total;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }
    
}
