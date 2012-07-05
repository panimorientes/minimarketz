package capaPresentacion;

public class FormContenedor extends javax.swing.JFrame {

    private FormProducto producto;
    private FormCategoria categoria;
    private FormVendedor vendedor;
    private FormInicio inicio;
    private FormVenta ventas;
    private FormCompra compras;
    private FormCliente cliente;
    private FormProveedor proveedor;
    

    public FormContenedor() {

        super();
        initComponents();
        inicio = new FormInicio();
        this.setSize(640, 480);
        this.setLocationRelativeTo(null);
        this.add(inicio);
        this.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem13 = new javax.swing.JMenuItem();
        menuPrincipal = new javax.swing.JMenuBar();
        menuPrograma = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        menuMantenimiento = new javax.swing.JMenu();
        menuProductos = new javax.swing.JMenuItem();
        menuProveedor = new javax.swing.JMenuItem();
        menuVendedor = new javax.swing.JMenuItem();
        menuCategoria = new javax.swing.JMenuItem();
        menuOperaciones = new javax.swing.JMenu();
        menuVentas = new javax.swing.JMenuItem();
        menuCompra = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        menuListaVendedores = new javax.swing.JMenuItem();
        menuListaProductos = new javax.swing.JMenuItem();
        menuListaProveedores = new javax.swing.JMenuItem();
        menuReporteVentas = new javax.swing.JMenuItem();
        menuReporteGanancias = new javax.swing.JMenuItem();

        jMenuItem13.setText("jMenuItem13");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestión de Minimarket");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new java.awt.FlowLayout());

        menuPrograma.setText("Programa");

        menuInicio.setText("Inicio");
        menuInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInicioActionPerformed(evt);
            }
        });
        menuPrograma.add(menuInicio);

        jMenuItem8.setText("Salir");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        menuPrograma.add(jMenuItem8);

        menuPrincipal.add(menuPrograma);

        menuMantenimiento.setText("Mantenimientos");

        menuProductos.setText("Productos");
        menuProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProductosActionPerformed(evt);
            }
        });
        menuMantenimiento.add(menuProductos);

        menuProveedor.setText("Proveedores");
        menuProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProveedorActionPerformed(evt);
            }
        });
        menuMantenimiento.add(menuProveedor);

        menuVendedor.setText("Vendedores");
        menuVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVendedorActionPerformed(evt);
            }
        });
        menuMantenimiento.add(menuVendedor);

        menuCategoria.setText("Categoría");
        menuCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCategoriaActionPerformed(evt);
            }
        });
        menuMantenimiento.add(menuCategoria);

        menuPrincipal.add(menuMantenimiento);

        menuOperaciones.setText("Operaciones");

        menuVentas.setText("Venta");
        menuVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVentasActionPerformed(evt);
            }
        });
        menuOperaciones.add(menuVentas);

        menuCompra.setText("Compra");
        menuCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCompraActionPerformed(evt);
            }
        });
        menuOperaciones.add(menuCompra);

        menuPrincipal.add(menuOperaciones);

        menuReportes.setText("Consultas y Reportes");

        menuListaVendedores.setText("Listado de vendedores");
        menuReportes.add(menuListaVendedores);

        menuListaProductos.setText("Listado de productos");
        menuReportes.add(menuListaProductos);

        menuListaProveedores.setText("Listado de preveedores");
        menuReportes.add(menuListaProveedores);

        menuReporteVentas.setText("Reporte de ventas");
        menuReportes.add(menuReporteVentas);

        menuReporteGanancias.setText("Reporte de ganacias");
        menuReportes.add(menuReporteGanancias);

        menuPrincipal.add(menuReportes);

        setJMenuBar(menuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProductosActionPerformed
        producto = new FormProducto();
        this.getContentPane().removeAll();
        this.getContentPane().add(producto);
        this.pack();
    }//GEN-LAST:event_menuProductosActionPerformed

    private void menuVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVendedorActionPerformed
        vendedor = new FormVendedor();
        this.getContentPane().removeAll();
        this.getContentPane().add(vendedor);
        this.pack();
    }//GEN-LAST:event_menuVendedorActionPerformed

    private void menuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInicioActionPerformed
        inicio = new FormInicio();
        this.getContentPane().removeAll();
        this.getContentPane().add(inicio);
        this.pack();
    }//GEN-LAST:event_menuInicioActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
      System.exit(0);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void menuVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVentasActionPerformed
        ventas = new FormVenta();
        this.getContentPane().removeAll();
        this.getContentPane().add(ventas);
        this.pack();
    }//GEN-LAST:event_menuVentasActionPerformed

    private void menuCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCategoriaActionPerformed
        categoria = new FormCategoria();
        this.getContentPane().removeAll();
        this.getContentPane().add(categoria);
        this.pack();
    }//GEN-LAST:event_menuCategoriaActionPerformed

    private void menuProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProveedorActionPerformed
        proveedor = new FormProveedor();
        this.getContentPane().removeAll();
        this.getContentPane().add(proveedor);
        this.pack();
     
    }//GEN-LAST:event_menuProveedorActionPerformed

    private void menuCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCompraActionPerformed
        compras = new FormCompra();
        this.getContentPane().removeAll();
        this.getContentPane().add(compras);
        this.pack();
    }//GEN-LAST:event_menuCompraActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FormContenedor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem menuCategoria;
    private javax.swing.JMenuItem menuCompra;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JMenuItem menuListaProductos;
    private javax.swing.JMenuItem menuListaProveedores;
    private javax.swing.JMenuItem menuListaVendedores;
    private javax.swing.JMenu menuMantenimiento;
    private javax.swing.JMenu menuOperaciones;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenuItem menuProductos;
    private javax.swing.JMenu menuPrograma;
    private javax.swing.JMenuItem menuProveedor;
    private javax.swing.JMenuItem menuReporteGanancias;
    private javax.swing.JMenuItem menuReporteVentas;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenuItem menuVendedor;
    private javax.swing.JMenuItem menuVentas;
    // End of variables declaration//GEN-END:variables
}
