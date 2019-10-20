
package Controller.ControladorView;

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
    
    
    
    
    
    
    public void abrirJanela(){
        cadastroCliente.getInstance().setVisible(true);
    }
    
    public void fecharJanela(){
        cadastroCliente.getInstance().dispose();
    }
    
    
}
