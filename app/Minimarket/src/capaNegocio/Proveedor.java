/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

public class Proveedor extends Persona{
         String contacto;
         String tipoPrv;
         String email;

    public Proveedor(int codigo,String nombre,long nroDocumento,String telefono,String direccion,String contacto,String email, String tipoPrv) {
        super(codigo, nroDocumento,telefono, nombre, direccion);
        this.email=email;
        this.contacto = contacto;
        this.tipoPrv = tipoPrv;
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTipoPrv() {
        return tipoPrv;
    }

    public void setTipoPrv(String tipoPrv) {
        this.tipoPrv = tipoPrv;
    }
         
         
                    
}
