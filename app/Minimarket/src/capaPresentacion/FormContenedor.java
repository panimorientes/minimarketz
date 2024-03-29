package capaPresentacion;

public class FormContenedor extends javax.swing.JFrame {

    private FormProducto producto;
    private FormCategoria categoria;
    private FormInicio inicio;
    private FormVenta ventas;
    private FormCompra compras;
    private FormProveedor proveedor;
    private ListaProducto listap;
    private ListaProveedor listaprv;
    private FormReportes listaventa;
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
        Salir = new javax.swing.JMenuItem();
        menuMantenimiento = new javax.swing.JMenu();
        menuProductos = new javax.swing.JMenuItem();
        menuProveedor = new javax.swing.JMenuItem();
        menuCategoria = new javax.swing.JMenuItem();
        menuOperaciones = new javax.swing.JMenu();
        menuVentas = new javax.swing.JMenuItem();
        menuCompra = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        menuListaProductos = new javax.swing.JMenuItem();
        menuListaProveedores = new javax.swing.JMenuItem();
        menuReporte = new javax.swing.JMenuItem();

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

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        menuPrograma.add(Salir);

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

        menuListaProductos.setText("Listado de productos");
        menuListaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListaProductosActionPerformed(evt);
            }
        });
        menuReportes.add(menuListaProductos);

        menuListaProveedores.setText("Listado de preveedores");
        menuListaProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListaProveedoresActionPerformed(evt);
            }
        });
        menuReportes.add(menuListaProveedores);

        menuReporte.setText("Reporte de ventas");
        menuReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReporteActionPerformed(evt);
            }
        });
        menuReportes.add(menuReporte);

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

    private void menuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInicioActionPerformed
        inicio = new FormInicio();
        this.getContentPane().removeAll();
        this.getContentPane().add(inicio);
        this.pack();
    }//GEN-LAST:event_menuInicioActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
      System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

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

    private void menuListaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListaProductosActionPerformed
        listap = new ListaProducto();
        this.getContentPane().removeAll();
        this.getContentPane().add(listap);
        this.pack();
    }//GEN-LAST:event_menuListaProductosActionPerformed

    private void menuListaProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListaProveedoresActionPerformed
        listaprv = new ListaProveedor();
        this.getContentPane().removeAll();
        this.getContentPane().add(listaprv);
        this.pack();
    }//GEN-LAST:event_menuListaProveedoresActionPerformed

    private void menuReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReporteActionPerformed
        listaventa = new FormReportes();
        this.getContentPane().removeAll();
        this.getContentPane().add(listaventa);
        this.pack();
    }//GEN-LAST:event_menuReporteActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FormContenedor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem menuCategoria;
    private javax.swing.JMenuItem menuCompra;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JMenuItem menuListaProductos;
    private javax.swing.JMenuItem menuListaProveedores;
    private javax.swing.JMenu menuMantenimiento;
    private javax.swing.JMenu menuOperaciones;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenuItem menuProductos;
    private javax.swing.JMenu menuPrograma;
    private javax.swing.JMenuItem menuProveedor;
    private javax.swing.JMenuItem menuReporte;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenuItem menuVentas;
    // End of variables declaration//GEN-END:variables
}
