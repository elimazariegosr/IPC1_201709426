/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game.view;

import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.ImageIcon;
import medievil_game.model.Personaje;
import medievil_game.controller.Archivo;
import medievil_game.controller.Tablero;
/**
 *
 * @author Mazariegos
 */
public class EmpezarJuego extends javax.swing.JFrame {
      Personaje personaje = new Personaje();
      Archivo arch = new Archivo();
      /**
     * Creates new form EmpezarJuego
     */
    public EmpezarJuego() {
        initComponents();
        setLocationRelativeTo(null);
        personaje.agregarImagenes(75, 75);

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnmago1 = new javax.swing.JButton();
        btnprincesa3 = new javax.swing.JButton();
        btnguerrero2 = new javax.swing.JButton();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        btnprincesa6 = new javax.swing.JButton();
        btnguerrero5 = new javax.swing.JButton();
        btnmago4 = new javax.swing.JButton();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        btniniciar = new javax.swing.JButton();
        txtjugador1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtjugador2 = new javax.swing.JTextField();
        txteny = new javax.swing.JTextField();
        txtenx = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SELECCION DE PERSONAJES");
        setPreferredSize(new java.awt.Dimension(700, 400));
        setResizable(false);

        btnmago1.setText("M");
        btnmago1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmago1ActionPerformed(evt);
            }
        });

        btnprincesa3.setText("P");
        btnprincesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprincesa3ActionPerformed(evt);
            }
        });

        btnguerrero2.setText("G");
        btnguerrero2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguerrero2ActionPerformed(evt);
            }
        });

        lbl1.setText(".");

        lbl2.setText(".");
        lbl2.setPreferredSize(new java.awt.Dimension(75, 75));

        lbl3.setText(".");
        lbl3.setPreferredSize(new java.awt.Dimension(75, 75));

        btnprincesa6.setText("P");
        btnprincesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprincesa6ActionPerformed(evt);
            }
        });

        btnguerrero5.setText("G");
        btnguerrero5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguerrero5ActionPerformed(evt);
            }
        });

        btnmago4.setText("M");
        btnmago4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmago4ActionPerformed(evt);
            }
        });

        lbl4.setText(".");

        lbl5.setText(".");
        lbl5.setPreferredSize(new java.awt.Dimension(75, 75));

        lbl6.setText(".");
        lbl6.setPreferredSize(new java.awt.Dimension(75, 75));

        btniniciar.setText("Iniciar Juego");
        btniniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniniciarActionPerformed(evt);
            }
        });

        jLabel1.setText("Jugador 1");

        jLabel2.setText("Jugador 2");

        jLabel3.setText("X            Y    ");

        jLabel4.setText("Ingrese tamaño");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnmago1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)
                        .addGap(251, 251, 251)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnguerrero2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnprincesa3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnmago4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtjugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtjugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(294, 294, 294)
                                .addComponent(btnguerrero5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(jLabel4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(txtenx, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txteny, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btniniciar)
                            .addComponent(btnprincesa6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnmago4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnguerrero5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnprincesa6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnmago1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnguerrero2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnprincesa3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtjugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtjugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btniniciar)
                        .addComponent(txteny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtenx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRegresar)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnprincesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprincesa3ActionPerformed
        // TODO add your handling code here:
      validarJugador1(2);
      btnprincesa3.setEnabled(false);
    }//GEN-LAST:event_btnprincesa3ActionPerformed

    private void btnprincesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprincesa6ActionPerformed
        // TODO add your handling code here:
        validarJugador2(2);
        btnprincesa6.setEnabled(false);
    }//GEN-LAST:event_btnprincesa6ActionPerformed

    private void btnmago1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmago1ActionPerformed
        // TODO add your handling code here:
        validarJugador1(0);
        
        btnmago1.setEnabled(false);
    }//GEN-LAST:event_btnmago1ActionPerformed

    private void btnguerrero2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguerrero2ActionPerformed
        // TODO add your handling code here:
        validarJugador1(1);
        btnguerrero2.setEnabled(false);
    }//GEN-LAST:event_btnguerrero2ActionPerformed

    private void btniniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniniciarActionPerformed
        // TODO add your handling code here:
                if(lbl1.getText()!="." && lbl2.getText()!="." && lbl3.getText()!="." &&
                        lbl4.getText()!="." && lbl5.getText()!="." && lbl6.getText()!="." &&
                        txtjugador1.getText()!="" && txtjugador2.getText() !=null &&
                        txteny.getText()!=null && txtenx!= null){
                
                arch.ordenJ(lbl1.getText(),lbl2.getText(),lbl3.getText(),
                        lbl4.getText(),lbl5.getText(),lbl6.getText());
                
                arch.guardarNombreJ(txtjugador1.getText(),Integer.parseInt(lbl1.getText()),
                        Integer.parseInt(lbl2.getText()),Integer.parseInt(lbl3.getText()),1);
                
                arch.guardarNombreJ(txtjugador2.getText(),Integer.parseInt(lbl4.getText()),
                        Integer.parseInt(lbl5.getText()),Integer.parseInt(lbl6.getText()),2);
                arch.guardarTam(txteny.getText());
                Tablero tab = new Tablero();
                TableroView menu = new TableroView();
                menu.setVisible(true);
                btniniciar.setEnabled(false);
                txtjugador1.setEnabled(false);
                txtjugador2.setEnabled(false);
                txtjugador1.setEnabled(false);
                txteny.setEnabled(false);
                txtenx.setEnabled(false);
                dispose();
                }
    }//GEN-LAST:event_btniniciarActionPerformed

    private void btnmago4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmago4ActionPerformed
        // TODO add your handling code here:
        validarJugador2(0);
        btnmago4.setEnabled(false);
    }//GEN-LAST:event_btnmago4ActionPerformed

    private void btnguerrero5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguerrero5ActionPerformed
        // TODO add your handling code here:
        validarJugador2(1);
        btnguerrero5.setEnabled(false);
    }//GEN-LAST:event_btnguerrero5ActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        new MenuPrincipal().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed
    
    public void validarJugador1(int numero){
        if(numero == 0 || numero ==1 || numero ==2)
        {
            
            System.out.println("hay numero "+numero);
            if(lbl1.getText()=="."){
                System.out.println("lbl1 "+numero);
                lbl1.setIcon(personaje.imagen[numero]);
                lbl1.setText(String.valueOf(numero));
                
                return;    
            }else if(lbl2.getText()=="."){
                lbl2.setIcon(personaje.imagen[numero]);
                lbl2.setText(String.valueOf(numero));
                return;    
            }else if(lbl3.getText()=="."){
                lbl3.setIcon(personaje.imagen[numero]);
                lbl3.setText(String.valueOf(numero));
                return;
            }
        }
    }
    public void validarJugador2(int numero){
       
        if(numero == 0 || numero ==1 || numero ==2)
        {
            System.out.println("hay numero "+numero);
            if(lbl4.getText()=="."){
                System.out.println("lbl1 "+numero);
                lbl4.setText(String.valueOf(numero));
                lbl4.setIcon(personaje.imagen[numero]);

                return;    
            }else if(lbl5.getText()=="." && lbl5.getText()!=String.valueOf(numero)){
                lbl5.setText(String.valueOf(numero));
                lbl5.setIcon(personaje.imagen[numero]);

                return;    
            }else if(lbl6.getText()=="."){
                lbl6.setText(String.valueOf(numero));
                lbl6.setIcon(personaje.imagen[numero]);

                return;
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmpezarJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpezarJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpezarJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpezarJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpezarJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnguerrero2;
    private javax.swing.JButton btnguerrero5;
    private javax.swing.JButton btniniciar;
    private javax.swing.JButton btnmago1;
    private javax.swing.JButton btnmago4;
    private javax.swing.JButton btnprincesa3;
    private javax.swing.JButton btnprincesa6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JTextField txtenx;
    private javax.swing.JTextField txteny;
    private javax.swing.JTextField txtjugador1;
    private javax.swing.JTextField txtjugador2;
    // End of variables declaration//GEN-END:variables
}
