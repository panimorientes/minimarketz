/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

public class Proveedor extends Persona{
         String contacto;
         String lugar;
         String tipoPrv;

    public Proveedor(int codigo,String nombre,int nroDocumento,int telefono,String direccion,String contacto, String lugar, String tipoPrv) {
        this.contacto = contacto;
        this.lugar = lugar;
        this.tipoPrv = tipoPrv;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
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
