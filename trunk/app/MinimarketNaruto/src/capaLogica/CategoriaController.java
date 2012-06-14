package capaLogica;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import capaNegocio.Categoria;

public class CategoriaController {

    //Atributos
    public ArrayList<Categoria> aCategoria;
    public String archivo;

    // Constructor
    public CategoriaController(String archivo) {
        this.archivo = archivo;
        aCategoria = new ArrayList<>();
        cargar();
    }

    // Carga Categorias del archivo
    private void cargar() {
        try {
            int codigo;
            String nombre, linea, imagen;
            BufferedReader br;
            StringTokenizer st;
            br = new BufferedReader(new FileReader("C:\\minimarket\\Categorias.txt"));

            while ((linea = br.readLine()) != null) {
                st = new StringTokenizer(linea, ",");
                codigo = Integer.parseInt(st.nextToken().trim());
                nombre = st.nextToken().trim();
                imagen = st.nextToken().trim();
                // Para metodo mostrar agregar: JOptionPane.showMessageDialog(null, st);
                aCategoria.add(new Categoria(codigo, nombre,imagen));
            }
            br.close();
        } catch (IOException | NumberFormatException x) {
            System.out.println(x.toString());
        }
    }

    // Guarda los Categorias al archivo
    public void guardar() {
        try {
            PrintWriter pw;
            pw = new PrintWriter(new FileWriter("C:\\minimarket\\Categorias.txt"));

            //	Recorrido del ArrayList
            for (Categoria aux : aCategoria) {
                pw.println(aux.getCodcateg() + ","
                        + aux.getNomcateg() + ","
                        + aux.getImagen());
            }
            pw.close();
        } catch (Exception x) {
            System.out.println(x.toString());
        }
    }

    // Busca un Categoria
    public Categoria buscarCategoria(int codigo) {
        for (int i = 0; i < aCategoria.size(); i++) {
            Categoria pro = (Categoria) aCategoria.get(i);
            if (codigo == pro.getCodcateg()) {
                return pro;
            }
        }
        return null;
    }
    
    public int buscarCategoria(Categoria pro){
        return aCategoria.indexOf(pro);
    }
    
    // Inserta un Categoria
    public void adicionarCategoria(Categoria pro) {
        aCategoria.add(pro);
    }
    
    //Modifica un Categoria
    public void modificarCategoria(int codCat, String nomCat, String img) {
        Categoria CategoriaAmodificar=buscarCategoria(codCat);
        //CategoriaAmodificar.setCodcateg(codCat);
        CategoriaAmodificar.setNomcateg(nomCat);
        CategoriaAmodificar.setImagen(img);
    }
   
    // Elimina un Categoria
    public void eliminarCategoria(Categoria pro) {
        aCategoria.remove(pro);
    }
    
    // Retorna el Categoria de la posición dada
    public Categoria obtenerCategoria(int indice) {
        return (Categoria) aCategoria.get(indice);
    }
    
    // Retorna la cantidad de Categorias
    public int numeroCategorias() {
        return aCategoria.size();
    }

    // Genera un nuevo código
    public int nuevoCodigo() {
      if (!aCategoria.isEmpty())
            return aCategoria.get(aCategoria.size()-1).getCodcateg()+1;
        else
            return 1;
    }       
}
