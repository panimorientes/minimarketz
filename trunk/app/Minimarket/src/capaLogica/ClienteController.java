/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import capaNegocio.Cliente;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Shivi
 */
public class ClienteController {
    //Atributos
    public ArrayList<Cliente> aCliente;
    public String archivo;

    // Constructor
    public ClienteController(String archivo) {
        this.archivo = archivo;
        aCliente = new ArrayList<>();
        cargar();
    }

    // Carga Clientes del archivo
    private void cargar() {
        try {
            long docIde;
            int codigo;
            String tipoC, nombre, linea, direccion,telefono;
            BufferedReader br;
            StringTokenizer st;
            br = new BufferedReader(new FileReader("C:\\minimarket\\Cliente.txt"));

            while ((linea = br.readLine()) != null) {
                st = new StringTokenizer(linea, ",");
                codigo = Integer.parseInt(st.nextToken().trim());
                nombre = st.nextToken().trim();
                docIde= Long.parseLong(st.nextToken().trim());
                telefono=st.nextToken().trim();
                direccion=st.nextToken().trim();
                tipoC=st.nextToken().trim();
                // Para metodo mostrar agregar: JOptionPane.showMessageDialog(null, st);
                aCliente.add(new Cliente(codigo, nombre, tipoC, docIde, telefono, direccion));
            }
            br.close();
        } catch (IOException | NumberFormatException x) {
            System.out.println(x.toString());
        }
    }

    // Guarda los Clientes al archivo
    public void guardar() {
        try {
            PrintWriter pw;
            pw = new PrintWriter(new FileWriter("C:\\minimarket\\Cliente.txt"));

            //	Recorrido del ArrayList
            for (Cliente aux : aCliente) {
                pw.println(aux.getCodigo() + ","
                        + aux.getNombre() + ","
                        + aux.getNroDocumento() + ","
                        + aux.getTelefono()+ ","
                        + aux.getDireccion() + ","
                        + aux.getTipoC());
            }
            pw.close();
        } catch (Exception x) {
            System.out.println(x.toString());
        }
    }

    // Busca un Cliente
    public Cliente buscarCliente(long docIde) {
        for (int i = 0; i < aCliente.size(); i++) {
            Cliente cli = (Cliente) aCliente.get(i);
            if (docIde == cli.getNroDocumento()) {
                return cli;
            }
        }
        return null;
    }
    
    public Cliente buscarCliente(int cod) {
        for (int i = 0; i < aCliente.size(); i++) {
            Cliente cli = (Cliente) aCliente.get(i);
            if (cod == cli.getCodigo()) {
                return cli;
            }
        }
        return null;
    }
    
    public int buscarCliente(Cliente cli){
        return aCliente.indexOf(cli);
    }
    
    // Inserta un Cliente
    public void adicionarCliente(Cliente cli) {
        aCliente.add(cli);
    }
    
    //Modifica un Cliente
    public void modificarCliente(int codigo,String nombre,String tipoC,long docIde,String telefono,String direccion) {
        Cliente ClienteAmodificar=buscarCliente(docIde);
        ClienteAmodificar.setNombre(nombre);
        ClienteAmodificar.setNroDocumento(docIde);
        ClienteAmodificar.setTelefono(telefono);
        ClienteAmodificar.setDireccion(direccion);
        ClienteAmodificar.setTipoC(tipoC);
    }
   
    // Elimina un Cliente
    public void eliminarCliente(Cliente cli) {
        aCliente.remove(cli);
    }
    
    // Retorna el Cliente de la posición dada
    public Cliente obtenerCliente(int indice) {
        return (Cliente) aCliente.get(indice);
    }
    
    // Retorna la cantidad de Clientes
    public int numeroClientees() {
        return aCliente.size();
    }

    // Genera un nuevo código
    public int nuevoCodigo() {
        if (!aCliente.isEmpty())
            return aCliente.get(aCliente.size()-1).getCodigo()+1;
        else
            return 1;
    }       
}
