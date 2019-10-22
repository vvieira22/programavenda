
package Controller.ControladorView;

import Controller.controladorClientes;
import View.cadastroCliente;

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
    
    public void cadastrarCliente(){
        String nome=cadastroCliente.getInstance().getCampoNome();
        String cpf=cadastroCliente.getInstance().getCampoCpf();
        String telefoneum=cadastroCliente.getInstance().getCampoTelefoneUm();      
        String telefonedois=cadastroCliente.getInstance().getCampoTelefoneDois();
        String email=cadastroCliente.getInstance().getCampoEmail();
        String rua=cadastroCliente.getInstance().getCampoRua();
        int numero=cadastroCliente.getInstance().getCampoNumero();
        String bairro=cadastroCliente.getInstance().getCampoBairro();
        String complemento=cadastroCliente.getInstance().getCampoComplemento();

      if(telefonedois==null){  
        if(verificarSeTelefoneENumero(telefoneum)==true){
        controladorClientes.getInstance().inserirCliente(null, null, null, null, null, null, numero, null, null);
    }
      }
        else{      
            if(verificarSeTelefoneENumero(telefoneum)==true || verificarSeTelefoneENumero(telefonedois)==true)
                controladorClientes.getInstance().inserirCliente(null, null, null, null, null, null, numero, null, null);         
            else
              cadastroCliente.getInstance().setarImagemStatusCpf();    
    }  
     }
      
    
    public void abrirJanela(){
        cadastroCliente.getInstance().setVisible(true);
    }
    
    public void fecharJanela(){
        cadastroCliente.getInstance().dispose();
    }
    
    
}
