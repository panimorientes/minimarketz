package capaLogica;

import capaNegocio.DetalleVenta;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DetalleVentaController {

    //Atributos
    public ArrayList<DetalleVenta> aDetalleVenta;
    public String archivo;

    // Constructor
    public DetalleVentaController(String archivo) {
        this.archivo = archivo;
        aDetalleVenta = new ArrayList<>();
        cargar();
    }

    // Carga DetalleVentas del archivo
    private void cargar() {
        try {
            int codigo,numven,item,codpro,can;
            String linea;
            double precio,subtot;
            BufferedReader br;
            StringTokenizer st;
            br = new BufferedReader(new FileReader("C:\\minimarket\\DetalleVentas.txt"));

            while ((linea = br.readLine()) != null) {
                st = new StringTokenizer(linea, ",");
                codigo = Integer.parseInt(st.nextToken().trim());
                numven = Integer.parseInt(st.nextToken().trim());
                item = Integer.parseInt(st.nextToken().trim());
                codpro = Integer.parseInt(st.nextToken().trim());
                can = Integer.parseInt(st.nextToken().trim());
                precio= Double.parseDouble(st.nextToken().trim());
                subtot= Double.parseDouble(st.nextToken().trim());
                // Para metodo mostrar agregar: JOptionPane.showMessageDialog(null, st);
                aDetalleVenta.add(new DetalleVenta(codigo,numven, item, codpro, can,precio, subtot));
            }
            br.close();
        } catch (IOException | NumberFormatException x) {
            System.out.println(x.toString());
        }
    }

    // Guarda los DetalleVentas al archivo
    public void guardar() {
        try {
            PrintWriter pw;
            pw = new PrintWriter(new FileWriter("C:\\minimarket\\DetalleVentas.txt"));

            //	Recorrido del ArrayList
            for (DetalleVenta aux : aDetalleVenta) {
                pw.println(aux.getCodigo() + ","
                        + aux.getNumVenta() + ","
                        + aux.getItem() + ","
                        + aux.getCodPro() + ","
                        + aux.getCan() + ","
                        + aux.getPrecio() + ","
                        + aux.getSubTot() );
            }
            pw.close();
        } catch (Exception x) {
            System.out.println(x.toString());
        }
    }

    // Busca un DetalleVenta
    public DetalleVenta buscarDetalleVenta(int codigo) {
        for (int i = 0; i < aDetalleVenta.size(); i++) {
            DetalleVenta pro = (DetalleVenta) aDetalleVenta.get(i);
            if (codigo == pro.getCodigo()) {
                return pro;
            }
        }
        return null;
    }
    
    public int buscarDetalleVenta(DetalleVenta detven){
        return aDetalleVenta.indexOf(detven);
    }
    
    // Inserta un DetalleVenta
    public void adicionarDetalleVenta(DetalleVenta detven) {
        aDetalleVenta.add(detven);
    }
    
    //Modifica un DetalleVenta
    public void modificarDetalleVenta(int codigo, int numven, int item, int codpro, int can, double precio,double subtot) {
        DetalleVenta DetalleVentaAmodificar=buscarDetalleVenta(codigo);
        DetalleVentaAmodificar.setNumVenta(numven);
        DetalleVentaAmodificar.setItem(item);
        DetalleVentaAmodificar.setCodPro(codpro);
        DetalleVentaAmodificar.setCan(can);
        DetalleVentaAmodificar.setPrecio(precio);
        DetalleVentaAmodificar.setSubTot(subtot);
    }
   
    // Elimina un DetalleVenta
    public void eliminarDetalleVenta(DetalleVenta detven) {
        aDetalleVenta.remove(detven);
    }
    
    // Retorna el DetalleVenta de la posición dada
    public DetalleVenta obtenerDetalleVenta(int indice) {
        return (DetalleVenta) aDetalleVenta.get(indice);
    }
    
    // Retorna la cantidad de DetalleVentas
    public int numeroDetalleVentas() {
        return aDetalleVenta.size();
    }

    // Genera un nuevo código
    public int nuevoCodigo() {
        if (!aDetalleVenta.isEmpty())
            return aDetalleVenta.get(aDetalleVenta.size()-1).getCodigo()+1;
        else
            return 1;
    }       
}
