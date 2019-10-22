package Model;

public class Usuario {
    private String nome;
    private String login;
    private String senha;
    private String perfil;

    public Usuario(String nome, String login, String senha, String perfil) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getPerfil() {
        return perfil;
    }
    
    
}
