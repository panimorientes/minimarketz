
package capaLogica;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import capaNegocio.DetalleCompra;

public class DetalleCompraController {
     //Atributos
    public ArrayList<DetalleCompra> aDetalleCompra;
    public String archivo;

    // Constructor
    public DetalleCompraController(String archivo) {
        this.archivo = archivo;
        aDetalleCompra = new ArrayList<>();
        cargar();
    }

    // Carga DetalleCompras del archivo
    private void cargar() {
        try {
            int codigo,numven,item,codpro,can;
            String linea;
            double precio,subtot;
            BufferedReader br;
            StringTokenizer st;
            br = new BufferedReader(new FileReader("C:\\minimarket\\DetalleCompras.txt"));

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
                aDetalleCompra.add(new DetalleCompra(codigo,numven, item, codpro, can,precio, subtot));
            }
            br.close();
        } catch (IOException | NumberFormatException x) {
            System.out.println(x.toString());
        }
    }

    // Guarda los DetalleCompras al archivo
    public void guardar() {
        try {
            PrintWriter pw;
            pw = new PrintWriter(new FileWriter("C:\\minimarket\\DetalleCompras.txt"));

            //	Recorrido del ArrayList
            for (DetalleCompra aux : aDetalleCompra) {
                pw.println(aux.getCodigo() + ","
                        + aux.getNumCompra() + ","
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

    // Busca un DetalleCompra
    public DetalleCompra buscarDetalleCompra(int codigo) {
        for (int i = 0; i < aDetalleCompra.size(); i++) {
            DetalleCompra pro = (DetalleCompra) aDetalleCompra.get(i);
            if (codigo == pro.getCodigo()) {
                return pro;
            }
        }
        return null;
    }
    
    public int buscarDetalleCompra(DetalleCompra detcom){
        return aDetalleCompra.indexOf(detcom);
    }
    
    // Inserta un DetalleCompra
    public void adicionarDetalleCompra(DetalleCompra detcom) {
        aDetalleCompra.add(detcom);
    }
    
    //Modifica un DetalleCompra
    public void modificarDetalleCompra(int codigo, int numven, int item, int codpro, int can, double precio,double subtot) {
        DetalleCompra DetalleCompraAmodificar=buscarDetalleCompra(codigo);
        DetalleCompraAmodificar.setNumCompra(numven);
        DetalleCompraAmodificar.setItem(item);
        DetalleCompraAmodificar.setCodPro(codpro);
        DetalleCompraAmodificar.setCan(can);
        DetalleCompraAmodificar.setPrecio(precio);
        DetalleCompraAmodificar.setSubTot(subtot);
    }
   
    // Elimina un DetalleCompra
    public void eliminarDetalleCompra(DetalleCompra detcom) {
        aDetalleCompra.remove(detcom);
    }
    
    // Retorna el DetalleCompra de la posición dada
    public DetalleCompra obtenerDetalleCompra(int indice) {
        return (DetalleCompra) aDetalleCompra.get(indice);
    }
    
    // Retorna la cantidad de DetalleCompras
    public int numeroDetalleCompras() {
        return aDetalleCompra.size();
    }

    // Genera un nuevo código
    public int nuevoCodigo() {
        if (!aDetalleCompra.isEmpty())
            return aDetalleCompra.get(aDetalleCompra.size()-1).getCodigo()+1;
        else
            return 1;
    }       
}
