
package capaPresentacion;

import capaLogica.ProveedorController;
import capaNegocio.Proveedor;
import javax.swing.table.DefaultTableModel;


public class ListaProveedor extends javax.swing.JPanel {
 ProveedorController bdproveedor = new ProveedorController("Proveedor.txt");
    DefaultTableModel Modelo;
    String[] Titulo = {"RUC", "RAZON SOCIAL","DIRECCION", "TELEFONO","CONTACTO","EMAIL","TIPO"};
    String[][] datos = {};
  
    public ListaProveedor() {
        initComponents();
        Modelo = new DefaultTableModel(datos, Titulo);
        TablaProveedor.setModel(Modelo);
         mostrarDatosTable();
    }
   private void mostrarDatosTable() {  
         Modelo = new DefaultTableModel(datos, Titulo);
        TablaProveedor.setModel(Modelo);
        for (int i = 0; i < bdproveedor.numeroProveedores(); i++) {
            Proveedor dat = bdproveedor.obtenerProveedor(i);
            Object[] fila = { dat.getNroDocumento(), dat.getNombre(),dat.getDireccion(), dat.getTelefono(),dat.getContacto(),dat.getEmail(), dat.getTipoPrv()};
            Modelo.addRow(fila); 
        }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TablaProveedor = new javax.swing.JTable();

        TablaProveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(TablaProveedor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProveedor;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
