/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_lfydp.Frontend;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import proyecto2_lfydp.Backend.Analizador;
import proyecto2_lfydp.Backend.ManejadorDeArchivos;

/**
 *
 * @author jessiel
 */
public class Principal extends javax.swing.JFrame {

    File archivo;
    String texto;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        buscadorArchivo=new JFileChooser();
        manejadorDeArchivos = new ManejadorDeArchivos();
        paneText.disable();
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
        lblTitulo = new javax.swing.JLabel();
        btnSeleccionarArchivo = new javax.swing.JButton();
        lblNombreArchivo = new javax.swing.JLabel();
        btnCargarTexto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        paneText = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("ANALIZADOR  LEXICO");

        btnSeleccionarArchivo.setText("Seleccionar Archivo");
        btnSeleccionarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarArchivoActionPerformed(evt);
            }
        });

        lblNombreArchivo.setText("NOMBRE DEL ARCHIVO");

        btnCargarTexto.setText("Cargar Texto");
        btnCargarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarTextoActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(paneText);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(398, 398, 398)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(408, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnCargarTexto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeleccionarArchivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2)
                .addGap(99, 99, 99))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblTitulo)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnSeleccionarArchivo)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombreArchivo)
                        .addGap(78, 78, 78)
                        .addComponent(btnCargarTexto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarArchivoActionPerformed
        // TODO add your handling code here:
        if(buscadorArchivo.showDialog(this, "ABRIR ARCHIVO")==JFileChooser.APPROVE_OPTION){
            archivo=buscadorArchivo.getSelectedFile();
            lblNombreArchivo.setText(archivo.getName());
        }
    }//GEN-LAST:event_btnSeleccionarArchivoActionPerformed

    private void btnCargarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarTextoActionPerformed
        // TODO add your handling code here:
        try {
            texto = manejadorDeArchivos.extraerTexto(archivo);
            paneText.setText(texto);
            Analizador analizador = new Analizador();
            analizador.analizadorLexicoRun(texto);
        } catch (IOException e) {
        }
        
    }//GEN-LAST:event_btnCargarTextoActionPerformed
    
    private JFileChooser buscadorArchivo;
    private ManejadorDeArchivos manejadorDeArchivos;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarTexto;
    private javax.swing.JButton btnSeleccionarArchivo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNombreArchivo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextPane paneText;
    // End of variables declaration//GEN-END:variables
}
