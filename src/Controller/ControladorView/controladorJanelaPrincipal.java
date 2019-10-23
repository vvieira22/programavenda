
package Controller.ControladorView;


public class controladorJanelaPrincipal {

    private static controladorJanelaPrincipal instance;
    
    
    
    private controladorJanelaPrincipal() {
    }
    
    public static synchronized controladorJanelaPrincipal getIstance(){
        if(instance==null)
            instance=new controladorJanelaPrincipal();
        return instance;
    }
    
    public void abrirmostrarProduto(){
        
    }
    
    public void abrirmostrarUsuario(){
        
    }
    
    public void abrirmostrarVenda(){
        
    }
    
    public void abrirmostrarCliente(){
        
    }
    
    
    
    
    
    
}
