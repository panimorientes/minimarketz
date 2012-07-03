/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

/**
 *
 * @author shivi
 */
public class Empleado extends Persona{
String apellidos;
String sexo;
String afp;
int edad;
int celular;

    public Empleado(int codigo,String nombre,String apellidos,String nroDocumento,String sexo,String direccion,int telefono,  String afp, int edad, int celular) {
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.afp = afp;
        this.edad = edad;
        this.celular = celular;
        
    }


    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }



}
