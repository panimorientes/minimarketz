/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacion;

import capaLogica.ProveedorController;
import capaNegocio.Proveedor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shivi
 */
public class FormProveedor extends javax.swing.JPanel {

    ProveedorController bdproveedor = new ProveedorController("Proveedor.txt");
    DefaultTableModel Modelo;
    String[] Titulo = {"RUC", "RAZON SOCIAL","DIRECCION", "TELEFONO","CONTACTO","EMAIL","TIPO"};
    String[][] datos = {};
    /**
     * Creates new form FormProveedor
     */
    public FormProveedor() {
        initComponents();
        Modelo = new DefaultTableModel(datos, Titulo);
        Tabla.setModel(Modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEmailPrv = new javax.swing.JFormattedTextField();
        txtRazonSPrv = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtContactoPrv = new javax.swing.JTextField();
        comboTipoPrv = new javax.swing.JComboBox();
        botonBuscarPrv = new javax.swing.JButton();
        botonAgregarPrv = new javax.swing.JButton();
        btnSalirPrv = new javax.swing.JButton();
        botonMostrarPrv = new javax.swing.JButton();
        botonNuevoProv = new javax.swing.JButton();
        botonEliminarPrv = new javax.swing.JButton();
        botonEditarPrv = new javax.swing.JButton();
        botonCancelarPrv = new javax.swing.JButton();
        txtRucPrv = new javax.swing.JFormattedTextField();
        tbProveedores = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtDireccionPrv = new javax.swing.JTextField();
        txtTelefonoPrv = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Razon Social:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Email:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("RUC:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Contacto:");

        txtEmailPrv.setEditable(false);

        txtRazonSPrv.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Tipo:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Telefono:");

        txtContactoPrv.setEditable(false);

        comboTipoPrv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Eliga Proveedor", "Distribuidores", "Fabricante", "Proveedor Directos e Indirectos", "Proveedor Local", " " }));
        comboTipoPrv.setEnabled(false);
        comboTipoPrv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoPrvActionPerformed(evt);
            }
        });

        botonBuscarPrv.setText("Buscar Proveedor");
        botonBuscarPrv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarPrvActionPerformed(evt);
            }
        });

        botonAgregarPrv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonAgregarPrv.setText("Agregar");
        botonAgregarPrv.setEnabled(false);
        botonAgregarPrv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarPrvActionPerformed(evt);
            }
        });

        btnSalirPrv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalirPrv.setText("Salir");
        btnSalirPrv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirPrvActionPerformed(evt);
            }
        });

        botonMostrarPrv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonMostrarPrv.setText("Mostar");
        botonMostrarPrv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarPrvActionPerformed(evt);
            }
        });

        botonNuevoProv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonNuevoProv.setText("Nuevo");
        botonNuevoProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoProvActionPerformed(evt);
            }
        });

        botonEliminarPrv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonEliminarPrv.setText("Eliminar");
        botonEliminarPrv.setEnabled(false);
        botonEliminarPrv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarPrvActionPerformed(evt);
            }
        });

        botonEditarPrv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonEditarPrv.setText("Editar");
        botonEditarPrv.setEnabled(false);
        botonEditarPrv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarPrvActionPerformed(evt);
            }
        });

        botonCancelarPrv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonCancelarPrv.setText("Cancelar");
        botonCancelarPrv.setEnabled(false);
        botonCancelarPrv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarPrvActionPerformed(evt);
            }
        });

        txtRucPrv.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###########"))));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProveedores.setViewportView(Tabla);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Direccion:");

        txtDireccionPrv.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtContactoPrv))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(comboTipoPrv, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tbProveedores)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(botonNuevoProv, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAgregarPrv, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEditarPrv, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEliminarPrv, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonMostrarPrv, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCancelarPrv, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtDireccionPrv))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtRucPrv, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonBuscarPrv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                                .addComponent(btnSalirPrv))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRazonSPrv)
                                    .addComponent(txtEmailPrv))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTelefonoPrv, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8)))))
                    .addComponent(jLabel5))
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(botonBuscarPrv)
                    .addComponent(txtRucPrv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalirPrv))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRazonSPrv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTelefonoPrv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(comboTipoPrv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailPrv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtContactoPrv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDireccionPrv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonCancelarPrv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonEliminarPrv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonEditarPrv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonAgregarPrv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonNuevoProv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonMostrarPrv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        jLabel10.setText("MANTENIMIENTO DE PROVEEDOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel10)
                .addContainerGap(44, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarTextos() {
        txtContactoPrv.setText("");
        txtDireccionPrv.setText("");
        txtEmailPrv.setText("");
        txtRazonSPrv.setText("");
        txtRucPrv.setText("");
        txtTelefonoPrv.setText("");
        activarControles();
    }

    private void activarTextos(boolean b) {
        txtContactoPrv.setEditable(b);
        txtDireccionPrv.setEditable(b);
        txtEmailPrv.setEditable(b);
        txtRazonSPrv.setEditable(b);
        txtRucPrv.setEnabled(b);
        txtRucPrv.setEditable(b);
        txtTelefonoPrv.setEnabled(b);
        comboTipoPrv.setEnabled(b);
    }

    private void activarControles() {
        txtRucPrv.setEditable(true);
        botonCancelarPrv.setEnabled(false);
        botonEliminarPrv.setEnabled(false);
        botonNuevoProv.setEnabled(true);
        botonMostrarPrv.setEnabled(true);
        botonBuscarPrv.setEnabled(true);
        botonAgregarPrv.setEnabled(false);
        botonEditarPrv.setEnabled(false);
    }
    
        private void mostrarDatosTable() {  
         Modelo = new DefaultTableModel(datos, Titulo);
        Tabla.setModel(Modelo);
        for (int i = 0; i < bdproveedor.numeroProveedores(); i++) {
            Proveedor dat = bdproveedor.obtenerProveedor(i);
            Object[] fila = { dat.getNroDocumento(), dat.getNombre(),dat.getDireccion(), dat.getTelefono(),dat.getContacto(),dat.getEmail(), dat.getTipoPrv()};
            Modelo.addRow(fila); 
        }
    }
        
    private void buscarProveedor() {
            Proveedor  p=bdproveedor.buscarProveedor(Long.parseLong(txtRucPrv.getText()));
        if (p != null) {
            txtRucPrv.setText(String.valueOf(p.getNroDocumento()));
            txtRazonSPrv.setText(p.getNombre());
            txtContactoPrv.setText(p.getContacto());
            txtDireccionPrv.setText(p.getDireccion()); 
            txtEmailPrv.setText(p.getEmail());
            txtTelefonoPrv.setText(p.getTelefono());
            comboTipoPrv.setSelectedItem(p.getTipoPrv());
            
        } else {
            JOptionPane.showMessageDialog(null, "No exite");
        }
    }

    private void comboTipoPrvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoPrvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoPrvActionPerformed

    private void botonBuscarPrvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarPrvActionPerformed
        // TODO add your handling code here:
        if (txtRucPrv.getText().compareTo("") != 0) {
            int result = JOptionPane.showConfirmDialog(
                    this, "Deseas Buscar al Proveedor para Modificarlo?",
                    "Mensaje..!!",
                    JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                buscarProveedor();
                botonNuevoProv.setEnabled(false);
                botonMostrarPrv.setEnabled(false);
                botonCancelarPrv.setEnabled(true);
                botonEditarPrv.setEnabled(true);
                activarTextos(true);
                txtRucPrv.setEditable(false);
            }
            if (result == JOptionPane.NO_OPTION) {
                buscarProveedor();
                botonEliminarPrv.setEnabled(true);
                botonNuevoProv.setEnabled(false);
                botonCancelarPrv.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese RUC que Desea Buscar");
        }
    }//GEN-LAST:event_botonBuscarPrvActionPerformed

    private void botonAgregarPrvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarPrvActionPerformed
        if (txtContactoPrv.getText().equals("") || txtEmailPrv.getText().equals("") || 
            txtRazonSPrv.getText().equals("") || txtRucPrv.getText().equals("") || txtTelefonoPrv.getText().equals("")) {
            JOptionPane.showMessageDialog(botonAgregarPrv, "CAMPOS VACIOS");
        } else {
            int codigo =bdproveedor.nuevoCodigo();
            long ruc = Long.parseLong(txtRucPrv.getText());
            String razonS = txtRazonSPrv.getText();
            String telefono= txtTelefonoPrv.getText();
            String email =txtEmailPrv.getText();
            String dirPrv= txtDireccionPrv.getText();
            String contacto=txtContactoPrv.getText();
            String tipoPrv = (String) comboTipoPrv.getSelectedItem();

                bdproveedor.adicionarProveedor(new Proveedor(codigo,razonS,ruc,telefono,dirPrv,contacto,email,tipoPrv));
                bdproveedor.guardar();
                JOptionPane.showMessageDialog(botonAgregarPrv, "Agregado correctamente ");
                mostrarDatosTable();
                limpiarTextos();
           
        }
    }//GEN-LAST:event_botonAgregarPrvActionPerformed

    private void btnSalirPrvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirPrvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirPrvActionPerformed

    private void botonMostrarPrvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarPrvActionPerformed
   mostrarDatosTable();
    }//GEN-LAST:event_botonMostrarPrvActionPerformed

    private void botonNuevoProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoProvActionPerformed
        limpiarTextos();
        activarTextos(true);
        txtRucPrv.setEditable(true);
        botonNuevoProv.setEnabled(false);
        botonAgregarPrv.setEnabled(true);
        botonCancelarPrv.setEnabled(true);
        botonBuscarPrv.setEnabled(false);
        botonMostrarPrv.setEnabled(true);
    }//GEN-LAST:event_botonNuevoProvActionPerformed

    private void botonEliminarPrvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarPrvActionPerformed
   
    }//GEN-LAST:event_botonEliminarPrvActionPerformed

    private void botonEditarPrvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarPrvActionPerformed
    
    String  nom=txtRazonSPrv.getText();
    long   ruc=Long.parseLong(txtRucPrv.getText());
    String tel= txtTelefonoPrv.getText();
    String dir= txtDireccionPrv.getText();
    String cont=txtContactoPrv.getText();
    String tipoPro= (String)comboTipoPrv.getSelectedItem();
      
        bdproveedor.modificarProveedor(0, nom, ruc, tel, dir, cont, tipoPro);
        bdproveedor.guardar();        
        JOptionPane.showMessageDialog(null, "Producto Modificado");
        limpiarTextos();
        mostrarDatosTable();
    }//GEN-LAST:event_botonEditarPrvActionPerformed

    private void botonCancelarPrvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarPrvActionPerformed
        // TODO add your handling code here:
        limpiarTextos();
        activarTextos(true);
   
    }//GEN-LAST:event_botonCancelarPrvActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton botonAgregarPrv;
    private javax.swing.JButton botonBuscarPrv;
    private javax.swing.JButton botonCancelarPrv;
    private javax.swing.JButton botonEditarPrv;
    private javax.swing.JButton botonEliminarPrv;
    private javax.swing.JButton botonMostrarPrv;
    private javax.swing.JButton botonNuevoProv;
    private javax.swing.JButton btnSalirPrv;
    private javax.swing.JComboBox comboTipoPrv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane tbProveedores;
    private javax.swing.JTextField txtContactoPrv;
    private javax.swing.JTextField txtDireccionPrv;
    private javax.swing.JFormattedTextField txtEmailPrv;
    private javax.swing.JTextField txtRazonSPrv;
    private javax.swing.JFormattedTextField txtRucPrv;
    private javax.swing.JTextField txtTelefonoPrv;
    // End of variables declaration//GEN-END:variables
}