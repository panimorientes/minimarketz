
package capaPresentacion;

import capaLogica.ProductoController;
import capaNegocio.Producto;
import javax.swing.table.DefaultTableModel;


public class ListaProducto extends javax.swing.JPanel {
ProductoController bdproducto = new ProductoController("Productos.txt");
  DefaultTableModel Modelo;
    String[] Titulo = {"CODIGO", "NOMBRE", "PRECIO", "STOCK", "CATEGORIA"};
    String[][] datos = {};
  
    public ListaProducto() {
        initComponents();
        Modelo = new DefaultTableModel(datos, Titulo);
        TablaProductos.setModel(Modelo);
        mostrarDatosTable();
    }
   private void mostrarDatosTable() {
        Modelo = new DefaultTableModel(datos, Titulo);
        TablaProductos.setModel(Modelo);
        for (int i = 0; i < bdproducto.numeroProductos(); i++) {
            Producto dat = bdproducto.obtenerProducto(i);
            Object[] fila = {dat.getCodigo(), dat.getNombre(), dat.getPrecio(), dat.getStock(), dat.getCategoria()};
            Modelo.addRow(fila);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();

        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TablaProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProductos;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
