package capaPresentacion;

public class FormContenedor extends javax.swing.JFrame {

    private FormProducto producto;
    private FormCategoria categoria;
    private VendedorForm vendedor;
    private FormInicio inicio;
    private VentasForm ventas;

    public FormContenedor() {

        super("MINIMARKET MARKO");
        initComponents();
        inicio = new FormInicio();
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
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();

        jMenuItem13.setText("jMenuItem13");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        jMenuItem4.setText("Venta");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuOperaciones.add(jMenuItem4);

        jMenuItem9.setText("Devolucion");
        menuOperaciones.add(jMenuItem9);

        jMenuItem6.setText("Ingreso de stock");
        menuOperaciones.add(jMenuItem6);

        menuPrincipal.add(menuOperaciones);

        menuReportes.setText("Consultas y Reportes");

        jMenuItem10.setText("Listado de vendedores");
        menuReportes.add(jMenuItem10);

        jMenuItem11.setText("Listado de productos");
        menuReportes.add(jMenuItem11);

        jMenuItem12.setText("Listado de preveedores");
        menuReportes.add(jMenuItem12);

        jMenuItem14.setText("Reporte de ventas");
        menuReportes.add(jMenuItem14);

        jMenuItem15.setText("Reporte de ganacias");
        menuReportes.add(jMenuItem15);

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
        vendedor = new VendedorForm();
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

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new VentasForm().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void menuCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCategoriaActionPerformed
        categoria = new FormCategoria();
        this.getContentPane().removeAll();
        this.getContentPane().add(categoria);
        this.pack();
    }//GEN-LAST:event_menuCategoriaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FormContenedor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem menuCategoria;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JMenu menuMantenimiento;
    private javax.swing.JMenu menuOperaciones;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenuItem menuProductos;
    private javax.swing.JMenu menuPrograma;
    private javax.swing.JMenuItem menuProveedor;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenuItem menuVendedor;
    // End of variables declaration//GEN-END:variables
}
