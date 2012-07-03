
package capaNegocio;


public class Cliente extends Persona{
    String tipoC;

    public Cliente(int codigo,String nombre,String tipoC,int docIde,int telefono,String direccion) {
        super(codigo, docIde,  telefono,nombre,  direccion);
        this.tipoC = tipoC;
   
    }
    
    public String getTipoC() {
        return tipoC;
    }

    public void setTipoC(String tipoC) {
        this.tipoC = tipoC;
    }
    
}
