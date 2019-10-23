package Model;

public class Cliente {
       
    private String nome;
    private String cpf;
    private int codigo;
    private String telefoneum;
    private String telefonedois;
    private String email;
    private String rua;
    private int numero;
    private String bairro;
    private String complemento;

    public Cliente(String nome, String cpf, int codigo,String telefoneum, String telefonedois, String email, String rua, int numero, String bairro, String complemento) {
        this.nome = nome;
        this.cpf = cpf;
        this.codigo=codigo;
        this.telefoneum = telefoneum;
        this.telefonedois = telefonedois;
        this.email = email;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefoneum(String telefoneum) {
        this.telefoneum = telefoneum;
    }

    public void setTelefonedois(String telefonedois) {
        this.telefonedois = telefonedois;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefoneum() {
        return telefoneum;
    }

    public String getTelefonedois() {
        return telefonedois;
    }

    public String getEmail() {
        return email;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getComplemento() {
        return complemento;
    }  
}
