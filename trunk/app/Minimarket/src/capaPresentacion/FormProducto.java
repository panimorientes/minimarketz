/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacion;

import util.metodos;
import capaLogica.CategoriaController;
import javax.swing.JOptionPane;
import capaLogica.ProductoController;
import capaNegocio.Producto;
import javax.swing.table.DefaultTableModel;
import capaNegocio.Categoria;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shivi
 */
public class FormProducto extends javax.swing.JPanel {
    ProductoController bdproducto = new ProductoController("Productos.txt");
    CategoriaController bdcategoria = new CategoriaController("Categorias.txt");
    DefaultTableModel Modelo;
    String[] Titulo = {"CODIGO", "NOMBRE", "PRECIO", "STOCK","CATEGORIA","IMAGEN"};
    String[][] datos = {};
    
    metodos m = new metodos() {
    };
    String ImagenURL;
    
    public FormProducto() {
        initComponents();
        cargarCategorias();
        Modelo = new DefaultTableModel(datos, Titulo);
        Tabla.setModel(Modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpImageProd = new javax.swing.JPanel();
        botonExaminar = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        preProducto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboCategoria = new javax.swing.JComboBox();
        stockProducto = new javax.swing.JTextField();
        botonBuscarProducto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomProducto = new javax.swing.JTextField();
        botonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botonMostrar = new javax.swing.JButton();
        codProducto = new javax.swing.JTextField();
        botonAgregar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonNuevo = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        jpImageProd.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jpImageProdLayout = new javax.swing.GroupLayout(jpImageProd);
        jpImageProd.setLayout(jpImageProdLayout);
        jpImageProdLayout.setHorizontalGroup(
            jpImageProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );
        jpImageProdLayout.setVerticalGroup(
            jpImageProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );

        botonExaminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonExaminar.setText("Examinar");
        botonExaminar.setEnabled(false);
        botonExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExaminarActionPerformed(evt);
            }
        });

        botonEditar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonEditar.setText("Modificar");
        botonEditar.setEnabled(false);
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        preProducto.setEditable(false);

        jLabel6.setText("CATEGORIA");

        jLabel3.setText("PRECIO");

        cboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Eliga su Categoria" }));
        cboCategoria.setEnabled(false);

        stockProducto.setEditable(false);

        botonBuscarProducto.setText("Buscar");
        botonBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarProductoActionPerformed(evt);
            }
        });

        jLabel4.setText("STOCK");

        jLabel2.setText("NOMBRE");

        nomProducto.setEditable(false);

        botonCancelar.setText("Cancelar");
        botonCancelar.setEnabled(false);
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("CODIGO");

        botonMostrar.setText("Mostrar");
        botonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarActionPerformed(evt);
            }
        });

        codProducto.setName("");

        botonAgregar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonAgregar.setText("Agregar");
        botonAgregar.setEnabled(false);
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.setEnabled(false);
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonNuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonNuevo.setText("Nuevo");
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(botonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpImageProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonExaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonAgregar)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(botonEditar)
                                .addGap(16, 16, 16)
                                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonCancelar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(41, 41, 41)
                                                .addComponent(codProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(nomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(preProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(stockProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(botonBuscarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(175, 175, 175))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jpImageProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonExaminar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(codProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonBuscarProducto))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(nomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(preProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(stockProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonAgregar)
                        .addComponent(botonNuevo)
                        .addComponent(botonCancelar)
                        .addComponent(botonEditar)
                        .addComponent(botonEliminar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonSalir)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        jLabel5.setText("MANTENIMIENTO DE PRODUCTO");

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
        jScrollPane2.setViewportView(Tabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(jLabel5))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void cargarImagen(Producto p){
        try {
            jpImageProd.removeAll();
            URL url = new URL(p.getImagen());
            m.setObtener(url);
            m.Mostrar(jpImageProd);
        } catch (MalformedURLException ex) {
            Logger.getLogger(FormProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarCategoria(Producto p){
        String nomCategoria=p.getCategoria();
        for (int i = 0; i < bdcategoria.numeroCategorias(); i++) {
            Categoria dat = bdcategoria.obtenerCategoria(i);
            if(dat.getNombre().equals(nomCategoria))
                cboCategoria.setSelectedIndex(i+1);
        }
    }
    
    private void limpiarTextos() {
        codProducto.setText("");
        nomProducto.setText("");
        preProducto.setText("");
        stockProducto.setText("");
        activarControles();
    }
    
    private void activarTextos(boolean b) {
        codProducto.setEditable(b);
        nomProducto.setEditable(b);
        stockProducto.setEditable(b);
        preProducto.setEditable(b);
        cboCategoria.setEnabled(b);
    }
    
    private void activarControles() {
        codProducto.setEditable(true);
        botonCancelar.setEnabled(false);
        botonEliminar.setEnabled(false);
        botonNuevo.setEnabled(true);
        botonMostrar.setEnabled(true);
        botonBuscarProducto.setEnabled(true);
        botonAgregar.setEnabled(false);
        botonExaminar.setEnabled(false);
        botonEditar.setEnabled(false);
    }
    
    private void cargarCategorias(){
    for (int i = 0; i < bdcategoria.numeroCategorias(); i++) {
            Categoria dat = bdcategoria.obtenerCategoria(i);
            cboCategoria.addItem(dat.getNombre());
        }
    }
    
    private void mostrarDatosTable() {  
         Modelo = new DefaultTableModel(datos, Titulo);
        Tabla.setModel(Modelo);
        for (int i = 0; i < bdproducto.numeroProductos(); i++) {
            Producto dat = bdproducto.obtenerProducto(i);
            Object[] fila = {dat.getCodigo(), dat.getNombre(), dat.getPrecio(), dat.getStock(),dat.getCategoria(),dat.getImagen()};
            Modelo.addRow(fila); 
        }
    }
    
    private void buscarProducto() {
    Producto p=bdproducto.buscarProducto(Integer.parseInt(codProducto.getText()));
        if (p != null) {
            codProducto.setText(String.valueOf(p.getCodigo()));
            nomProducto.setText(p.getNombre());
            stockProducto.setText(String.valueOf(p.getStock()));
            preProducto.setText(String.valueOf(p.getPrecio())); 
            cargarImagen(p);
            cargarCategoria(p);
        } else {
            JOptionPane.showMessageDialog(null, "No exite");
        }
    }
     
    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
      
        if (nomProducto.getText().equals("") || preProducto.getText().equals("") || stockProducto.getText().equals("")) {
            JOptionPane.showMessageDialog(botonAgregar, "CAMPOS VACIOS");
        } else {
            int codigo = Integer.parseInt(codProducto.getText());
            String nombre = nomProducto.getText();
            double precio = Double.parseDouble(preProducto.getText());
            int stock = Integer.parseInt(stockProducto.getText());
            String categoria= (String)cboCategoria.getSelectedItem();
            String imagen=m.ObtenerUrl();
            
            if (precio == 0 || stock == 0) {
                JOptionPane.showMessageDialog(botonAgregar, "El campo debe ser mayor a 0");
            } else {
                bdproducto.adicionarProducto(new Producto(codigo, nombre, precio, stock,categoria, imagen));
                bdproducto.guardar();
                JOptionPane.showMessageDialog(botonAgregar, "Agregado correctamente ");
                     mostrarDatosTable();
        limpiarTextos();
            }
        }
   
    }//GEN-LAST:event_botonAgregarActionPerformed
        
    private void botonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarActionPerformed
         
         mostrarDatosTable();
    }//GEN-LAST:event_botonMostrarActionPerformed
 
    private void botonExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExaminarActionPerformed
        jpImageProd.removeAll();
        m.Abrir_Dialogo(jpImageProd);
        ImagenURL = m.ObtenerUrl();
    }//GEN-LAST:event_botonExaminarActionPerformed
    
    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        limpiarTextos();
        activarTextos(true);
        codProducto.setEditable(false);
        botonNuevo.setEnabled(false);
        botonAgregar.setEnabled(true);
        botonCancelar.setEnabled(true);
        botonExaminar.setEnabled(true);
        botonBuscarProducto.setEnabled(false);
        botonMostrar.setEnabled(true);
        codProducto.setText(bdproducto.nuevoCodigo()+"");
    }//GEN-LAST:event_botonNuevoActionPerformed
    
    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        int cod=Integer.parseInt(codProducto.getText());
        String nom=nomProducto.getText();
        double pre= Double.parseDouble(preProducto.getText());
        int stock=Integer.parseInt(stockProducto.getText());
        String categoria= (String)cboCategoria.getSelectedItem();
        String imagen=m.ObtenerUrl();
        bdproducto.modificarProducto(cod,nom,pre,stock,categoria,imagen);
        bdproducto.guardar();        
        JOptionPane.showMessageDialog(null, "Producto Modificado");
        limpiarTextos();
        mostrarDatosTable();
    }//GEN-LAST:event_botonEditarActionPerformed
   private void limpiarImagen(){
       jpImageProd.removeAll();
       jpImageProd.repaint();
   }    
    private void botonBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarProductoActionPerformed
        limpiarImagen();
        if (codProducto.getText().compareTo("") != 0) {
            int result = JOptionPane.showConfirmDialog(
                    this, "¿Deseas Buscar el Producto para Modificarlo?",
                    "Mensaje..!!",
                    JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION) {
                 
                buscarProducto();
                botonNuevo.setEnabled(false);
                botonMostrar.setEnabled(false);
                botonCancelar.setEnabled(true);
                botonExaminar.setEnabled(true);
                botonEliminar.setEnabled(true);
                botonEditar.setEnabled(true);
                activarTextos(true);
            }
            if (result == JOptionPane.NO_OPTION) {
                buscarProducto();
                botonEliminar.setEnabled(true);
                botonNuevo.setEnabled(false);
                botonCancelar.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese codigo de producto que desee buscar");
        }
    }//GEN-LAST:event_botonBuscarProductoActionPerformed
    
    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        Producto productoAeliminar = bdproducto.buscarProducto(Integer.parseInt(codProducto.getText()));
        bdproducto.eliminarProducto(productoAeliminar);
        bdproducto.guardar();        
        JOptionPane.showMessageDialog(null, "Producto Eliminado");
        mostrarDatosTable();
        limpiarTextos();
        limpiarImagen();
    }//GEN-LAST:event_botonEliminarActionPerformed
    
    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonSalirActionPerformed
    
    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        limpiarImagen();
        limpiarTextos();
        activarTextos(true);
    }//GEN-LAST:event_botonCancelarActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonBuscarProducto;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonExaminar;
    private javax.swing.JButton botonMostrar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JButton botonSalir;
    private javax.swing.JComboBox cboCategoria;
    private javax.swing.JTextField codProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpImageProd;
    private javax.swing.JTextField nomProducto;
    private javax.swing.JTextField preProducto;
    private javax.swing.JTextField stockProducto;
    // End of variables declaration//GEN-END:variables
}
