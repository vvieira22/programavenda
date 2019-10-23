
package Controller.ControladorView;

import Controller.controladorClientes;
import Model.Cliente;
import View.Cadastro.cadastroCliente;
import javax.swing.JOptionPane;

public class controladorCadastroCLiente {

    private static controladorCadastroCLiente instance;
    
    private controladorCadastroCLiente() {
    }
    
    public static controladorCadastroCLiente getInstance(){
        if(instance==null)
            instance=new controladorCadastroCLiente();
        return instance;
    }
    
    public boolean verificarSeTelefoneENumero(String telefone){        
      int numero= Integer.parseInt(telefone);  
      return numero==(int)numero;     
    }
    
    public void cadastrarCliente(String cpf, String nome, String telefoneum, String telefonedois, String email, String rua, int numero, String bairro, String complemento){     
        int codigo= controladorClientes.getInstance().gerarCodigoCliente();
            Cliente clientenovo= new Cliente(nome,cpf,codigo,telefoneum,telefonedois,email,rua,numero,bairro,complemento);
            controladorClientes.getInstance().inserirCliente(clientenovo);
 
    }
      
    
    public void abrirJanela(){
        cadastroCliente.getInstance().setVisible(true);
    }
    
    public void fecharJanela(){
        cadastroCliente.getInstance().dispose();
    }
    
    
}
