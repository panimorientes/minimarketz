package capaPresentacion;

import capaLogica.CompraController;
import capaLogica.VentaController;
import capaNegocio.Compra;
import capaNegocio.Venta;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.table.DefaultTableModel;

public class FormReportes extends javax.swing.JPanel {

    VentaController bdventas = new VentaController("Ventas.txt");
    CompraController bdcompras = new CompraController("Compras.txt");
    DefaultTableModel Modelo1, Modelo2, Modelo3;
    String[] Titulo1 = {"FECHA", "TIPO COMPROBANTE", "DNI", "IMPORTE"};
    String[][] datos1 = {};
    String[] Titulo2 = {"NRO", "RUC PROVEEDOR", "FECHA", "TIPO COMPROBANTE", "NRO COMPROBANTE", "FORMA PAGO", "TOTAL COMPRA"};
    String[][] datos2 = {};
    String[] Titulo3 = {"NRO VENTA", "COSTO VENTA", "TOTAL VENTA", "GANANCIA"};
    String[][] datos3 = {};

    public FormReportes() {
        initComponents();
        Modelo1 = new DefaultTableModel(datos1, Titulo1);
        Modelo2 = new DefaultTableModel(datos2, Titulo2);
        Modelo3 = new DefaultTableModel(datos3, Titulo3);
        TablaVentas.setModel(Modelo1);
        TablaCompra.setModel(Modelo2);
        mostrarDatosTable1();
        mostrarDatosTable2();
        mostrarDatosTable3();
    }

    private void mostrarDatosTable1() {
        Modelo1 = new DefaultTableModel(datos1, Titulo1);
        TablaVentas.setModel(Modelo1);
        for (int i = 0; i < bdventas.numeroVentas(); i++) {
            Venta dat = bdventas.obtenerVenta(i);
            Object[] fila = {dat.getFecha(), dat.getTcomprobante(), dat.getCliente(), dat.getTventa()};
            Modelo1.addRow(fila);
        }
    }

    private void mostrarDatosTable2() {
        Modelo2 = new DefaultTableModel(datos2, Titulo2);
        TablaCompra.setModel(Modelo2);
        for (int i = 0; i < bdcompras.numeroCompras(); i++) {
            Compra dat = bdcompras.obtenerCompra(i);
            Object[] fila = {dat.getNumero(), dat.getProveedor(), dat.getFecha(), dat.getTcomprobante(), dat.getNcomprobante(), dat.getFpago(), dat.getTcompra()};
            Modelo2.addRow(fila);
        }
    }

    private void mostrarDatosTable3() {
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);

        double ganancia = 0.00;
        Modelo3 = new DefaultTableModel(datos3, Titulo3);
        TablaGanancia.setModel(Modelo3);
        for (int i = 0; i < bdventas.numeroVentas(); i++) {
            Venta dat = bdventas.obtenerVenta(i);

            Object[] fila = {dat.getNumero(), df.format(dat.getTventa() * 0.8), df.format(dat.getTventa()), df.format(dat.getTventa() - dat.getTventa() * 0.8)};
            ganancia = ganancia + (dat.getTventa() - dat.getTventa() * 0.8);
            Modelo3.addRow(fila);
        }
        txtGanancia.setText("" + df.format(ganancia));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaVentas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        TablaCompras = new javax.swing.JScrollPane();
        TablaCompra = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        TablaGanacia = new javax.swing.JScrollPane();
        TablaGanancia = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtGanancia = new javax.swing.JTextField();

        TablaVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(TablaVentas);

        jTabbedPane1.addTab("REPORTE DE VENTAS", jScrollPane2);

        TablaCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaCompras.setViewportView(TablaCompra);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TablaCompras, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(TablaCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("REPORTE DE COMPRAS", jPanel1);

        TablaGanancia.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaGanacia.setViewportView(TablaGanancia);

        jLabel1.setText("TOTAL GANANCIA:");

        txtGanancia.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TablaGanacia, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(txtGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(TablaGanacia, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 76, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("REPORTE DE GANANCIA", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaCompra;
    private javax.swing.JScrollPane TablaCompras;
    private javax.swing.JScrollPane TablaGanacia;
    private javax.swing.JTable TablaGanancia;
    private javax.swing.JTable TablaVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtGanancia;
    // End of variables declaration//GEN-END:variables
}
