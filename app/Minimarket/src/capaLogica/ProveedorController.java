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
            long nroDocumento;
            int codigo;
            String nombre,email, linea, direccion,telefono,contacto,tipoPro;
            BufferedReader br;
            StringTokenizer st;
            br = new BufferedReader(new FileReader("C:\\minimarket\\Proveedor.txt"));

            while ((linea = br.readLine()) != null) {
                st = new StringTokenizer(linea, ",");
                codigo = Integer.parseInt(st.nextToken().trim());
                nombre = st.nextToken().trim();
                nroDocumento= Long.parseLong(st.nextToken().trim());
                telefono=st.nextToken().trim();
                direccion=st.nextToken().trim();
                contacto=st.nextToken().trim();
                email=st.nextToken().trim();
                tipoPro=st.nextToken().trim();
                // Para metodo mostrar agregar: JOptionPane.showMessageDialog(null, st);
                aProveedor.add(new Proveedor(codigo,nombre,nroDocumento,telefono,direccion,contacto,email,tipoPro));
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
            pw = new PrintWriter(new FileWriter("C:\\minimarket\\Proveedor.txt"));

            //	Recorrido del ArrayList
            for (Proveedor aux : aProveedor) {
                pw.println(aux.getCodigo() + ","
                        + aux.getNombre() + ","
                        + aux.getNroDocumento() + ","
                        + aux.getTelefono()+ ","
                        + aux.getDireccion() + ","
                        + aux.getContacto() + ","
                        + aux.getEmail() + ","
                        + aux.getTipoPrv());
            }
            pw.close();
        } catch (Exception x) {
            System.out.println(x.toString());
        }
    }

    // Busca un Proveedor
    public Proveedor buscarProveedor(long ruc) {
        for (int i = 0; i < aProveedor.size(); i++) {
            Proveedor prv = (Proveedor) aProveedor.get(i);
            if (ruc == prv.getNroDocumento()) {
                return prv;
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
    public void modificarProveedor(int codPrv,String nom,long nroDoc,String tel,String dir,String cont, String tipoPro) {
        Proveedor proveedorAmodificar=buscarProveedor(codPrv);
        proveedorAmodificar.setNombre(nom);
        proveedorAmodificar.setNroDocumento(nroDoc);
        proveedorAmodificar.setTelefono(tel);
        proveedorAmodificar.setDireccion(dir);
        proveedorAmodificar.setContacto(cont);
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
    public int numeroProveedores() {
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
