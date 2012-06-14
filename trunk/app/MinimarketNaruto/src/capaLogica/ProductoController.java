package capaLogica;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import capaNegocio.Producto;

public class ProductoController {

    //Atributos
    public ArrayList<Producto> aProducto;
    public String archivo;

    // Constructor
    public ProductoController(String archivo) {
        this.archivo = archivo;
        aProducto = new ArrayList<>();
        cargar();
    }

    // Carga productos del archivo
    private void cargar() {
        try {
            int codigo, stock;
            String nombre,categoria, imagen, linea;
            double precio;
            BufferedReader br;
            StringTokenizer st;
            br = new BufferedReader(new FileReader("C:\\minimarket\\Productos.txt"));

            while ((linea = br.readLine()) != null) {
                st = new StringTokenizer(linea, ",");
                codigo = Integer.parseInt(st.nextToken().trim());
                nombre = st.nextToken().trim();
                precio = Double.parseDouble(st.nextToken().trim());
                stock = Integer.parseInt(st.nextToken().trim());
                categoria= st.nextToken().trim();
                imagen= st.nextToken().trim();
                // Para metodo mostrar agregar: JOptionPane.showMessageDialog(null, st);
                aProducto.add(new Producto(codigo, nombre, precio, stock,categoria,imagen));
            }
            br.close();
        } catch (IOException | NumberFormatException x) {
            System.out.println(x.toString());
        }
    }

    // Guarda los productos al archivo
    public void guardar() {
        try {
            PrintWriter pw;
            pw = new PrintWriter(new FileWriter("C:\\minimarket\\Productos.txt"));

            //	Recorrido del ArrayList
            for (Producto aux : aProducto) {
                pw.println(aux.getCodigo() + ","
                        + aux.getNombre() + ","
                        + aux.getPrecio() + ","
                        + aux.getStock() + ","
                        + aux.getCategoria() + ","
                        + aux.getImagen());
            }
            pw.close();
        } catch (Exception x) {
            System.out.println(x.toString());
        }
    }

    // Busca un producto
    public Producto buscarProducto(int codigo) {
        for (int i = 0; i < aProducto.size(); i++) {
            Producto pro = (Producto) aProducto.get(i);
            if (codigo == pro.getCodigo()) {
                return pro;
            }
        }
        return null;
    }
    
    public int buscarProducto(Producto pro){
        return aProducto.indexOf(pro);
    }
    
    // Inserta un producto
    public void adicionarProducto(Producto pro) {
        aProducto.add(pro);
    }
    
    //Modifica un producto
    public void modificarProducto(int codPro, String nomPro, double pre, int stock, String cat, String img) {
        Producto productoAmodificar=buscarProducto(codPro);
        productoAmodificar.setNombre(nomPro);
        productoAmodificar.setPrecio(pre);
        productoAmodificar.setStock(stock);
        productoAmodificar.setCategoria(cat);
        productoAmodificar.setImagen(img);
    }
   
    // Elimina un producto
    public void eliminarProducto(Producto pro) {
        aProducto.remove(pro);
    }
    
    // Retorna el producto de la posición dada
    public Producto obtenerProducto(int indice) {
        return (Producto) aProducto.get(indice);
    }
    
    // Retorna la cantidad de Productos
    public int numeroProductos() {
        return aProducto.size();
    }

    // Genera un nuevo código
    public int nuevoCodigo() {
        if (!aProducto.isEmpty())
            return aProducto.get(aProducto.size()-1).getCodigo()+1;
        else
            return 1;
    }       
}
