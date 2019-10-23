
package Controller.ControladorView;

/**
 *
 * @author vitor
 */
public class controladorMostrarProduto {
   
    private static controladorMostrarProduto instance;

    private controladorMostrarProduto() {
    }
    
    public static synchronized controladorMostrarProduto getInstance(){
        if(instance==null)
            instance=new controladorMostrarProduto();
        return instance;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
