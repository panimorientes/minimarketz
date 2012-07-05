package capaLogica;

import capaNegocio.Compra;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CompraController {

    //Atributos
    public ArrayList<Compra> aCompra;
    public String archivo;

    // Constructor
    public CompraController(String archivo) {
        this.archivo = archivo;
        aCompra = new ArrayList<>();
        cargar();
    }

    // Carga Compras del archivo
    private void cargar() {
        try {
            int numero, ncomprobante;     
            long proveedor;
            String fecha,tcomprobante,fpago, linea;
            double tcompra;
            BufferedReader br;
            StringTokenizer st;
            br = new BufferedReader(new FileReader("C:\\minimarket\\Compras.txt"));

            while ((linea = br.readLine()) != null) {
                st = new StringTokenizer(linea, ",");
                numero = Integer.parseInt(st.nextToken().trim());
                proveedor=Integer.parseInt(st.nextToken().trim());
                fecha = st.nextToken().trim();
                fpago=st.nextToken().trim();
                tcomprobante = st.nextToken().trim();    
                ncomprobante=Integer.parseInt(st.nextToken().trim());
                tcompra = Double.parseDouble(st.nextToken().trim());
  
                // Para metodo mostrar agregar: JOptionPane.showMessageDialog(null, st);
                aCompra.add(new Compra(numero, proveedor, fecha, tcomprobante,ncomprobante, fpago, tcompra));
            }
            br.close();
        } catch (IOException | NumberFormatException x) {
            System.out.println(x.toString());
        }
    }

    // Guarda los Compras al archivo
    public void guardar() {
        try {
            PrintWriter pw;
            pw = new PrintWriter(new FileWriter("C:\\minimarket\\Compras.txt"));

            //	Recorrido del ArrayList
            for (Compra aux : aCompra) {
                pw.println(aux.getNumero() + ","
                        + aux.getProveedor() + ","
                        + aux.getFecha() + ","                       
                        + aux.getTcomprobante() + ","
                        + aux.getNcomprobante() + ","
                        + aux.getFpago() + ","
                        + aux.getTcompra());
            }
            pw.close();
        } catch (Exception x) {
            System.out.println(x.toString());
        }
    }

    // Busca un Compra
    public Compra buscarCompra(int numero) {
        for (int i = 0; i < aCompra.size(); i++) {
            Compra ven = (Compra) aCompra.get(i);
            if (numero == ven.getNumero()) {
                return ven;
            }
        }
        return null;
    }
    
    public int buscarCompra(Compra com){
        return aCompra.indexOf(com);
    }
    
    // Inserta un Compra
    public void adicionarCompra(Compra com) {
        aCompra.add(com);
    }
    
    //Modifica un Compra
    public void modificarCompra(int numCom,long proveedor, String fecVen, String tcomprobante,int ncomprobante,String fpago,Double tcompra) {
        Compra CompraAmodificar=buscarCompra(numCom);
        CompraAmodificar.setProveedor(proveedor);
        CompraAmodificar.setFecha(fecVen);
        CompraAmodificar.setTcomprobante(tcomprobante);
        CompraAmodificar.setNcomprobante(ncomprobante);
        CompraAmodificar.setFpago(fpago);
        CompraAmodificar.setTcompra(tcompra);
    }
   
    // Elimina un Compra
    public void eliminarCompra(Compra com) {
        aCompra.remove(com);
    }
    
    // Retorna el Compra de la posición dada
    public Compra obtenerCompra(int indice) {
        return (Compra) aCompra.get(indice);
    }
    
    // Retorna la cantidad de Compras
    public int numeroCompras() {
        return aCompra.size();
    }

    // Genera un nuevo código
    public int nuevoCodigo() {
        if (!aCompra.isEmpty())
            return aCompra.get(aCompra.size()-1).getNumero()+1;
        else
            return 1;
    }       
}
