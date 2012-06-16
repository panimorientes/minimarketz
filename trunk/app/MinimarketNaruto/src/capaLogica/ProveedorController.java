/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import capaNegocio.Proveedor;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ProveedorController {

    //Atributos
    public ArrayList<Proveedor> aProveedor;
    public String archivo;

    // Constructor
    public ProveedorController(String archivo) {
        this.archivo = archivo;
        aProveedor = new ArrayList<>();
        cargar();
    }

    // Carga Proveedors del archivo
    private void cargar() {
        try {
            int telefono,nroDocumento;
            String nombre, linea, direccion,email,lugar,tipoPro;
            BufferedReader br;
            StringTokenizer st;
            br = new BufferedReader(new FileReader("Proveedor.txt"));

            while ((linea = br.readLine()) != null) {
                st = new StringTokenizer(linea, ",");             
                nombre = st.nextToken().trim();
                nroDocumento= Integer.parseInt(st.nextToken().trim());
                telefono=Integer.parseInt(st.nextToken().trim());
                direccion=st.nextToken().trim();
                email=st.nextToken().trim();
                lugar=st.nextToken().trim();
                tipoPro=st.nextToken().trim();
                // Para metodo mostrar agregar: JOptionPane.showMessageDialog(null, st);
                aProveedor.add(new Proveedor(nombre,nroDocumento,telefono,direccion,email,lugar,tipoPro));
            }
            br.close();
        } catch (IOException | NumberFormatException x) {
            System.out.println(x.toString());
        }
    }

    // Guarda los Proveedors al archivo
    public void guardar() {
        try {
            PrintWriter pw;
            pw = new PrintWriter(new FileWriter("Proveedor.txt"));

            //	Recorrido del ArrayList
            for (Proveedor aux : aProveedor) {
                pw.println(aux.getNombre() + ","
                        + aux.getNroDocumento() + ","
                        + aux.getTelefono()+ ","
                        + aux.getDireccion() + ","
                        + aux.getEmail() + ","
                        + aux.getLugar() + ","
                        + aux.getTipoPrv());
            }
            pw.close();
        } catch (Exception x) {
            System.out.println(x.toString());
        }
    }

    // Busca un Proveedor
    public Proveedor buscarProveedor(int codigo) {
        for (int i = 0; i < aProveedor.size(); i++) {
            Proveedor pro = (Proveedor) aProveedor.get(i);
            if (codigo == pro.getCodigo()) {
                return pro;
            }
        }
        return null;
    }
    
    public int buscarProveedor(Proveedor prv){
        return aProveedor.indexOf(prv);
    }
    
    // Inserta un Proveedor
    public void adicionarProveedor(Proveedor prv) {
        aProveedor.add(prv);
    }
    
    //Modifica un Proveedor
    public void modificarProveedor(String nom,int nroDoc,int tel,String dir,String email, String lug, String tipoPro) {
        Proveedor proveedorAmodificar=buscarProveedor(nroDoc);
        proveedorAmodificar.setNombre(nom);
        proveedorAmodificar.setNroDocumento(nroDoc);
        proveedorAmodificar.setTelefono(tel);
        proveedorAmodificar.setDireccion(dir);
        proveedorAmodificar.setEmail(email);
        proveedorAmodificar.setLugar(lug);
        proveedorAmodificar.setTipoPrv(tipoPro);
    }
   
    // Elimina un Proveedor
    public void eliminarProveedor(Proveedor prv) {
        aProveedor.remove(prv);
    }
    
    // Retorna el Proveedor de la posición dada
    public Proveedor obtenerProveedor(int indice) {
        return (Proveedor) aProveedor.get(indice);
    }
    
    // Retorna la cantidad de Proveedors
    public int numeroProveedors() {
        return aProveedor.size();
    }

    // Genera un nuevo código
    public int nuevoCodigo() {
        if (!aProveedor.isEmpty())
            return aProveedor.get(aProveedor.size()-1).getCodigo()+1;
        else
            return 1;
    }       
}
