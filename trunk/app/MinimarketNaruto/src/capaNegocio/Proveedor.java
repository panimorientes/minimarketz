/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

public class Proveedor extends Persona{
         String email;
         String lugar;
         String tipoPrv;

    public Proveedor(String nombre,int nroDocumento,int telefono,String direccion,String email, String lugar, String tipoPrv) {
        this.email = email;
        this.lugar = lugar;
        this.tipoPrv = tipoPrv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getTipoPrv() {
        return tipoPrv;
    }

    public void setTipoPrv(String tipoPrv) {
        this.tipoPrv = tipoPrv;
    }

    
                    
}
