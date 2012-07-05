
package capaPresentacion;

import capaLogica.VentaController;
import capaNegocio.Venta;
import javax.swing.table.DefaultTableModel;

public class ListaVenta extends javax.swing.JPanel {
    VentaController bdventas = new VentaController("Ventas.txt");
    DefaultTableModel Modelo;
    String[] Titulo = {"FECHA", "TIPO COMPROBANTE","DNI", "IMPORTE"};
    String[][] datos = {};
    public ListaVenta() {
        initComponents();
          Modelo = new DefaultTableModel(datos, Titulo);
        TablaVenta.setModel(Modelo);
         mostrarDatosTable();
    }
private void mostrarDatosTable() {  
         Modelo = new DefaultTableModel(datos, Titulo);
        TablaVenta.setModel(Modelo);
        for (int i = 0; i < bdventas.numeroVentas(); i++) {
            Venta dat = bdventas.obtenerVenta(i);
            Object[] fila = { dat.getFecha(), dat.getTcomprobante(),dat.getCliente(), dat.getTventa()};
            Modelo.addRow(fila); 
        }
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TablaVenta = new javax.swing.JTable();

        TablaVenta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(TablaVenta);

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
    private javax.swing.JTable TablaVenta;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
