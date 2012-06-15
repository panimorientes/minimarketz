/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

public class Proveedor extends Persona{
         String contacto;
         String lugar;
         String tipoPro;

    public Proveedor(int codigo,String nombre,int docIde,int telefono,String direccion,String contacto, String lugar, String tipoPro) {
        this.contacto = contacto;
        this.lugar = lugar;
        this.tipoPro = tipoPro;
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

    public String getTipoP() {
        return tipoPro;
    }

    public void setTipoP(String tipoPro) {
        this.tipoPro = tipoPro;
    }
         
         
                    
}
