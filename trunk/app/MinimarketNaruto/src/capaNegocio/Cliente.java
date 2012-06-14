/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

/**
 *
 * @author shivi
 */
public class Cliente extends Persona{
    String tipoC;

    public Cliente(int codigo,String nombre,int docIde,int telefono,String direccion,String tipoC) {
        this.tipoC = tipoC;
   
    }
    
    public String getTipoC() {
        return tipoC;
    }

    public void setTipoC(String tipoC) {
        this.tipoC = tipoC;
    }
    
}
