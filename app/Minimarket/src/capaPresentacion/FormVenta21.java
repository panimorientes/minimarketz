
package capaPresentacion;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sigeop.bea.DetalleVenta;
import sigeop.bea.Familia;
import sigeop.bea.Producto;
import sigeop.bea.Venta;
import sigeop.gui.FormProducto;
import sigeop.gui.FormVenta;
import sigeop.map.SqlMapConfig;

public class FormVenta21 extends javax.swing.JInternalFrame {

   DefaultTableModel Modelo;
    String[] Titulo = {"CODIGO", "PRODUCTO", "DESCRIPCION", "CANTIDAD", "PRECIO"};
    String[][] datos = {};
    
    public FormVenta21() {
        initComponents();
         initComponents();
        txtNumeroVenta.setText("" + getNuevoCodigoVenta());
        listarFamilias();
        Modelo = new DefaultTableModel(datos, Titulo);
        tblDetalleVenta.setModel(Modelo);
    }

     private int getNuevoCodigoDetalleVenta() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        int cod = 0;
        try {
            obj = sqlMapClient.queryForObject("getMaxDetalleVenta");
        } catch (SQLException ex) {
            Logger.getLogger(FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (obj != null) {
            cod = ((Integer) obj).intValue();
        }
        return cod + 1;
    }
    
    private int getNuevoCodigoVenta() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        int cod = 0;
        try {
            obj = sqlMapClient.queryForObject("getMaxVenta");
        } catch (SQLException ex) {
            Logger.getLogger(FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (obj != null) {
            cod = ((Integer) obj).intValue();
        }
        return cod + 1;
    }
    
    private boolean validarIngresoDetalle() {
        boolean rsta = false;
        if (tblDetalleVenta.getRowCount() > 0) {
            for (int i = 0; i < tblDetalleVenta.getRowCount(); i++) {
                String dato = String.valueOf(tblDetalleVenta.getValueAt(i, 0));
                if (dato.equals(cboCodPro.getSelectedItem().toString())) {
                    rsta = true;
                }
            }
        }
        return rsta;
    }
    
    private void agregarDetalleTabla() {
        
        if (txtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(btnAgregarProductoTabla, "Escriba la cantidad de productos");
        } else {
            int codPro = (Integer) cboCodPro.getSelectedItem();
            Producto pro = new Producto();
            pro = FormProducto.getProducto(codPro);
            
            String nomProducto = (String) cboProducto.getSelectedItem();
            String precio = txtPrecio.getText();
            String cantidad = txtCantidad.getText();
            Object[] fila = {codPro, nomProducto, pro.getDesPro(), cantidad, precio};
            
            if (!validarIngresoDetalle()) {
                Modelo.addRow(fila);
            } else {
                JOptionPane.showMessageDialog(this, "Producto ya ingresado", "Mensaje", 0, null);
            }
        }
    }
    
    private void calcular() {
        double total = 0.0;
        for (int i = 0; i < tblDetalleVenta.getRowCount(); i++) {
            double subTotal = (Double.parseDouble(this.tblDetalleVenta.getValueAt(i, 4).toString())) * (Integer.parseInt(this.tblDetalleVenta.getValueAt(i, 3).toString()));
            total = total + subTotal;
        }
        txtTotal.setText("" + total);
    }
     private void cargarProductos() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Producto> Productos = new ArrayList<>();
        try {
            Productos = sqlMapClient.queryForList("listProducto", null);
        } catch (SQLException ex) {
            Logger.getLogger(FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < Productos.size(); i++) {
            Producto per = Productos.get(i);
            cboProducto.addItem(per.getNomPro());
            cboCodPro.addItem(per.getCodPro());
            
        }
    }
    
    private void listarProductosDeFamilia(int codFam) {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Producto> productos = new ArrayList<>();
        try {
            productos = sqlMapClient.queryForList("listProductoXFamilia", codFam);
        } catch (SQLException ex) {
            Logger.getLogger(FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < productos.size(); i++) {
            Producto per = productos.get(i);
            cboProducto.addItem(per.getNomPro());
            cboCodPro.addItem(per.getCodPro());
        }
    }
    
    private void listarFamilias() {
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        List<Familia> Familias = new ArrayList<>();
        try {
            Familias = sqlMapClient.queryForList("listFamilia", null);
        } catch (SQLException ex) {
            Logger.getLogger(FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < Familias.size(); i++) {
            Familia cat = Familias.get(i);
            cboFamlia.addItem(cat.getNomFam());
        }
    }
      private void limpiartextos() {
        
        txtNumeroVenta.setText("" + getNuevoCodigoVenta());
        txtTotal.setText("");
        cboCodPro.setSelectedIndex(0);
        cboComprobante.setSelectedIndex(0);
        cboFamlia.setSelectedIndex(0);
        cboComprobante.setSelectedIndex(0);
        
        for (int i = tblDetalleVenta.getRowCount() - 1; i >= 0; i--) {
            Modelo.removeRow(i);            
        }
        
        
    }
    
    private Producto getProducto(int codigo) {
        Producto producto = new Producto();
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        Object obj = null;
        try {
            obj = sqlMapClient.queryForObject("getProducto", codigo);
        } catch (SQLException ex) {
            Logger.getLogger(FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        producto = ((Producto) obj);
        return producto;
    }
    
    private void agregarDetalleVenta(int venta, int codPro, double preDet, int canDet) {
        DetalleVenta det = new DetalleVenta();
        det.setNroDet(getNuevoCodigoDetalleVenta());
        det.setVenta_nroVen(venta);
        det.setProducto_codPro(codPro);
        det.setPreDet(preDet);
        det.setCanDet(canDet);
        
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {
            
            sqlMapClient.insert("insertDetalleVenta", det);
        } catch (SQLException ex) {
            Logger.getLogger(FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void agregarVenta() {
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Venta vnt = new Venta();
        int numVen = Integer.parseInt(txtNumeroVenta.getText());
        vnt.setNroVen(numVen);
        vnt.setNroCom(txtNroComprobante.getText());
        vnt.setTipCom((String) cboComprobante.getSelectedItem());
        vnt.setUsuario_codUsu(Integer.parseInt(txtCodUsu.getText()));
        vnt.setCliente_codCli(Integer.parseInt(txtCodCli.getText()));
        try {
            vnt.setFecVen((Date) formatter.parse(txtFecha.getText()));
            
        } catch (ParseException ex) {
            Logger.getLogger(FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
        try {
            
            sqlMapClient.insert("insertVenta", vnt);
        } catch (SQLException ex) {
            Logger.getLogger(FormVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*for*/
        for (int i = 0; i < tblDetalleVenta.getRowCount(); i++) {
            
            int codPro = Integer.parseInt(this.tblDetalleVenta.getValueAt(i, 0).toString());
            double precio = Double.parseDouble(this.tblDetalleVenta.getValueAt(i, 4).toString());
            int cantidad = Integer.parseInt(this.tblDetalleVenta.getValueAt(i, 3).toString());
            agregarDetalleVenta(numVen, codPro, precio, cantidad);
        }
        actualizarStock();
        JOptionPane.showMessageDialog(this, " Venta Registrada ", "MENSAJE", 2, null);
        
    }
    
    private void actualizarStock() {
        
        for (int i = 0; i < tblDetalleVenta.getRowCount(); i++) {
            Producto pro = new Producto();
            int codPro = Integer.parseInt(this.tblDetalleVenta.getValueAt(i, 0).toString());
            pro = FormProducto.getProducto(codPro);
            int sto = pro.getStoPro();
            int can = Integer.parseInt(this.tblDetalleVenta.getValueAt(i, 3).toString());
            pro.setStoPro(sto - can);
            SqlMapClient sqlMapClient = SqlMapConfig.getSqlMap();
            try {
                
                sqlMapClient.update("updateProducto", pro);
            } catch (SQLException ex) {
                Logger.getLogger(sigeop.gui.FormVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
     private void limpiarAgregar() {
        txtCantidad.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        cboFamlia.setSelectedIndex(0);
        cboProducto.setSelectedIndex(0);
        cboCodPro.setSelectedIndex(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        lblTitulo2 = new javax.swing.JLabel();
        lblEmpleado1 = new javax.swing.JLabel();
        lblOjoDer1 = new javax.swing.JLabel();
        lblOjoIzq1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtHistorial1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDetalleVenta1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        txtAplicar1 = new javax.swing.JButton();
        lblEmpleado4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtRealizarCobro = new javax.swing.JButton();
        cboFamlia = new javax.swing.JComboBox();
        cboProducto = new javax.swing.JComboBox();
        txtPrecio = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnAgregarProductoTabla = new javax.swing.JButton();
        txtStock = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTitulo3 = new javax.swing.JLabel();
        lblTitulo4 = new javax.swing.JLabel();
        txtNumeroVenta = new javax.swing.JTextField();
        cboCodPro = new javax.swing.JComboBox();
        txtFecha = new javax.swing.JTextField();
        cboComprobante = new javax.swing.JComboBox();
        lblTipo = new javax.swing.JLabel();
        lblNroComprobante = new javax.swing.JLabel();
        txtNroComprobante = new javax.swing.JTextField();
        txtCodUsu = new javax.swing.JTextField();
        lblOjoDer2 = new javax.swing.JLabel();
        txtCodCli = new javax.swing.JTextField();
        lblOjoDer3 = new javax.swing.JLabel();
        BtnEliminarFila = new javax.swing.JButton();

        jPanel3.setBackground(new java.awt.Color(117, 175, 224));
        jPanel3.setForeground(new java.awt.Color(117, 175, 224));
        jPanel3.setToolTipText("");

        lblTitulo2.setBackground(new java.awt.Color(51, 51, 51));
        lblTitulo2.setFont(new java.awt.Font("Bauhaus 93", 0, 12)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("REGISTRO DE VENTA");
        lblTitulo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo2.setOpaque(true);

        lblEmpleado1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblEmpleado1.setForeground(new java.awt.Color(255, 255, 255));
        lblEmpleado1.setText("Fecha");

        lblOjoDer1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblOjoDer1.setForeground(new java.awt.Color(255, 255, 255));
        lblOjoDer1.setText("Numero de venta:");

        lblOjoIzq1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblOjoIzq1.setForeground(new java.awt.Color(255, 255, 255));
        lblOjoIzq1.setText("Historial de cobros y movimientos");

        txtHistorial1.setColumns(20);
        txtHistorial1.setRows(5);
        jScrollPane2.setViewportView(txtHistorial1);

        tblDetalleVenta1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Producto", "Descripcion", "Cantidad", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblDetalleVenta1);

        jPanel6.setBackground(new java.awt.Color(5, 104, 159));

        txtAplicar1.setText("Aplicar");
        txtAplicar1.setBorder(null);
        txtAplicar1.setBorderPainted(false);
        txtAplicar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAplicar1ActionPerformed(evt);
            }
        });

        lblEmpleado4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblEmpleado4.setText("TOTAL:");

        txtTotal.setEnabled(false);

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(lblEmpleado4)
                .add(22, 22, 22)
                .add(txtTotal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtAplicar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .add(6, 6, 6))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblEmpleado4)
                    .add(txtAplicar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .add(txtTotal))
                .addContainerGap())
        );

        txtRealizarCobro.setText("Realizar cobro");
        txtRealizarCobro.setBorder(null);
        txtRealizarCobro.setBorderPainted(false);
        txtRealizarCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRealizarCobroActionPerformed(evt);
            }
        });

        cboFamlia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione familia" }));
        cboFamlia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFamliaActionPerformed(evt);
            }
        });

        cboProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione producto" }));
        cboProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductoActionPerformed(evt);
            }
        });

        txtPrecio.setEnabled(false);

        btnAgregarProductoTabla.setText("Agregar producto");
        btnAgregarProductoTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoTablaActionPerformed(evt);
            }
        });

        txtStock.setEnabled(false);

        jLabel12.setText("Stock:");

        jLabel11.setText("Precio:");

        jLabel9.setText("Cantidad:");

        lblTitulo3.setBackground(new java.awt.Color(51, 51, 51));
        lblTitulo3.setFont(new java.awt.Font("Bauhaus 93", 0, 12)); // NOI18N
        lblTitulo3.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo3.setText("SELECCIONAR PRODUCTO");
        lblTitulo3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo3.setOpaque(true);

        lblTitulo4.setBackground(new java.awt.Color(51, 51, 51));
        lblTitulo4.setFont(new java.awt.Font("Bauhaus 93", 0, 12)); // NOI18N
        lblTitulo4.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo4.setText("DETALLE VENTA");
        lblTitulo4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblTitulo4.setOpaque(true);

        cboCodPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pro" }));

        txtFecha.setEditable(false);
        txtFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        txtFecha.setEnabled(false);

        cboComprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FACTURA", "BOLETA" }));
        cboComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboComprobanteActionPerformed(evt);
            }
        });

        lblTipo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(255, 255, 255));
        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipo.setText("Tipo comprobante:");

        lblNroComprobante.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblNroComprobante.setForeground(new java.awt.Color(255, 255, 255));
        lblNroComprobante.setText("Nro comprobante :");

        txtCodUsu.setText("1");

        lblOjoDer2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblOjoDer2.setForeground(new java.awt.Color(255, 255, 255));
        lblOjoDer2.setText("Codigo Usuario");

        txtCodCli.setText("1");

        lblOjoDer3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblOjoDer3.setForeground(new java.awt.Color(255, 255, 255));
        lblOjoDer3.setText("Cliente:");

        BtnEliminarFila.setText("Eliminar Fila");
        BtnEliminarFila.setBorder(null);
        BtnEliminarFila.setBorderPainted(false);
        BtnEliminarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarFilaActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(33, 33, 33)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(lblEmpleado1)
                        .add(18, 18, 18)
                        .add(txtFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(lblOjoDer2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(txtCodUsu, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(lblTipo)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(cboComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(lblOjoDer3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtCodCli, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 87, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(lblOjoDer1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(txtNumeroVenta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(lblNroComprobante)
                        .add(18, 18, 18)
                        .add(txtNroComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 75, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .add(jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                        .add(55, 55, 55)
                        .add(cboFamlia, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(56, 56, 56)
                        .add(cboProducto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(35, 35, 35)
                .add(cboCodPro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(66, 66, 66)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel11)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(txtPrecio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel9)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(txtCantidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(57, 57, 57)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel12)
                        .add(18, 18, 18)
                        .add(txtStock))
                    .add(btnAgregarProductoTabla, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblTitulo4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 718, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, lblTitulo3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 718, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(lblTitulo2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 718, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(jPanel3Layout.createSequentialGroup()
                .add(23, 23, 23)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 682, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jPanel3Layout.createSequentialGroup()
                                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel3Layout.createSequentialGroup()
                                        .add(lblOjoIzq1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 256, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(85, 85, 85))
                                    .add(jPanel3Layout.createSequentialGroup()
                                        .add(BtnEliminarFila, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(55, 55, 55)))
                                .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 645, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(txtRealizarCobro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 144, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(96, 96, 96))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(lblTitulo2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(12, 12, 12)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtNroComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(jPanel3Layout.createSequentialGroup()
                            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(lblEmpleado1)
                                .add(txtFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(lblNroComprobante)
                                .add(lblOjoDer2)
                                .add(txtCodUsu, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(17, 17, 17)
                            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(lblTipo)
                                .add(cboComprobante, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(lblOjoDer1)
                                .add(txtNumeroVenta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(lblOjoDer3)
                                .add(txtCodCli, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .add(18, 18, 18)
                .add(lblTitulo3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtStock, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel11)
                            .add(txtPrecio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel12))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel9)
                            .add(txtCantidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(btnAgregarProductoTabla)))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(cboFamlia, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(cboCodPro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(cboProducto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(lblTitulo4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(BtnEliminarFila, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .add(18, 18, 18)
                        .add(lblOjoIzq1))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE)))
                .add(31, 31, 31)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 78, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(txtRealizarCobro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAplicar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAplicar1ActionPerformed
        
    }//GEN-LAST:event_txtAplicar1ActionPerformed

    private void txtRealizarCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRealizarCobroActionPerformed
        agregarVenta();
        limpiartextos();

    }//GEN-LAST:event_txtRealizarCobroActionPerformed

    private void cboFamliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFamliaActionPerformed
        cboProducto.removeAllItems();
        cboProducto.addItem("ELEGIR");
        cboCodPro.removeAllItems();
        cboCodPro.addItem("ELEGIR");
        listarProductosDeFamilia(cboFamlia.getSelectedIndex());
    }//GEN-LAST:event_cboFamliaActionPerformed

    private void cboProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductoActionPerformed
        if (cboProducto.getSelectedIndex() > 0) {
            cboCodPro.setSelectedIndex(cboProducto.getSelectedIndex());
            String s = cboCodPro.getSelectedItem().toString();
            txtStock.setText("" + getProducto(Integer.parseInt(s)).getStoPro());
            txtPrecio.setText("" + getProducto(Integer.parseInt(s)).getPreVenPro());
        }
    }//GEN-LAST:event_cboProductoActionPerformed

    private void btnAgregarProductoTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoTablaActionPerformed

        if (txtCantidad.getText().equals("") || txtStock.getText().equals("") || txtPrecio.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "CAMPOS VACÍOS", "MENSAJE", 2, null);
        } else {
            if (Integer.parseInt(txtCantidad.getText()) <= Integer.parseInt(txtStock.getText())) {
                agregarDetalleTabla();
                calcular();
                limpiarAgregar();
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese otra cantidad!!!", "STOCK INFUFICIENTE", 2, null);
                txtCantidad.setText("");
            }
        }
    }//GEN-LAST:event_btnAgregarProductoTablaActionPerformed

    private void cboComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboComprobanteActionPerformed
        if (cboComprobante.getSelectedIndex() == 0) {
        } else {
        }
    }//GEN-LAST:event_cboComprobanteActionPerformed

    private void BtnEliminarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarFilaActionPerformed
        Modelo.removeRow(tblDetalleVenta.getSelectedRow());
        calcular();
    }//GEN-LAST:event_BtnEliminarFilaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminarFila;
    private javax.swing.JButton btnAgregarProductoTabla;
    private javax.swing.JComboBox cboCodPro;
    private javax.swing.JComboBox cboComprobante;
    private javax.swing.JComboBox cboFamlia;
    private javax.swing.JComboBox cboProducto;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblEmpleado1;
    private javax.swing.JLabel lblEmpleado4;
    private javax.swing.JLabel lblNroComprobante;
    private javax.swing.JLabel lblOjoDer1;
    private javax.swing.JLabel lblOjoDer2;
    private javax.swing.JLabel lblOjoDer3;
    private javax.swing.JLabel lblOjoIzq1;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTitulo4;
    private javax.swing.JTable tblDetalleVenta1;
    private javax.swing.JButton txtAplicar1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodCli;
    private javax.swing.JTextField txtCodUsu;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextArea txtHistorial1;
    private javax.swing.JTextField txtNroComprobante;
    private javax.swing.JTextField txtNumeroVenta;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JButton txtRealizarCobro;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
