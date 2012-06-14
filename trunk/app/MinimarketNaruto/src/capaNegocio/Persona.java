/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

/**
 *
 * @author shivi
 */
public class Persona {
    private int codigo;
    private int docIde;
    public int telefono;
    private String nombre;
    private String direccion;
 
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDocIde() {
        return docIde;
    }

    public void setDocIde(int docIde) {
        this.docIde = docIde;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
    
    
            
    
}
