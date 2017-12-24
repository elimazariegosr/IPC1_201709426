/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game.view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import medievil_game.controller.Movimiento;
import medievil_game.controller.Tablero;
import medievil_game.model.Personaje;

/**
 *
 * @author Mazariegos
 */
public class TableroView extends javax.swing.JFrame {

    /**
     * Creates new form TableroView
     */
    
    public Tablero tab;
    public Movimiento atac;
    public boolean tablerocreado = true;
    public int tamanio;
    public JLabel lblImagen;
    public ImageIcon imagenvida;
    public TableroView() {
        initComponents();
        panel.removeAll();
        lblImagen = new JLabel();
        lblImagen.setBounds(10, 20, 610, 610);
        ImageIcon imagen = new ImageIcon(getClass().
                getResource("/Pictures/mapa.jpg"));
        ImageIcon icono = new ImageIcon(imagen.getImage().
                getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(),
                        Image.SCALE_DEFAULT));
        lblImagen.setIcon(icono);
        lblImagen.setOpaque(true);
        
        panel.repaint();
        panel.setOpaque(false);
        
        panelvidasj1.repaint();
        panelvidasj1.setOpaque(true);
        
        panelvidj2.repaint();
        panelvidj2.setOpaque(true);
        
        tab= new Tablero(panel,panelvidasj1,panelvidj2);
        getContentPane().add(lblImagen);
        
       leerFile(1);
      Personaje pers = new Personaje();
      pers.agregarImagenes(tab.tam, tab.tam);
      botones(false);
        
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public void botones(boolean des){
        
        btnArriba.setEnabled(des);
        btnAbajo.setEnabled(des);
        btmIzquierda.setEnabled(des);
        btnDerecha.setEnabled(des);
        btnatacar.setEnabled(des);
    }
   
    public void leerFile(int numero){
       
        BufferedReader br1=null,br2=null;
        try{
        String linea;
        br1 = new BufferedReader(new FileReader("Nombres"+numero+".txt"));
        //br2 = new BufferedReader(new FileReader(""));  
        linea = br1.readLine();
        
                txajugadorT.setText(linea);
            
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if (br1!= null )br1.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        btnAbajo = new javax.swing.JButton();
        btmIzquierda = new javax.swing.JButton();
        btnDerecha = new javax.swing.JButton();
        btnArriba = new javax.swing.JButton();
        numero = new javax.swing.JTextField();
        lbljugador1 = new javax.swing.JLabel();
        panelvidasj2 = new javax.swing.JPanel();
        paneldatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelvidasj1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txajugadorT = new javax.swing.JTextArea();
        panelvidj2 = new javax.swing.JPanel();
        btntirardado = new javax.swing.JButton();
        btnatacar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );

        btnAbajo.setText("↓");
        btnAbajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbajoActionPerformed(evt);
            }
        });

        btmIzquierda.setText("←");
        btmIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmIzquierdaActionPerformed(evt);
            }
        });

        btnDerecha.setText("→");
        btnDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDerechaActionPerformed(evt);
            }
        });

        btnArriba.setText("↑");
        btnArriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArribaActionPerformed(evt);
            }
        });

        numero.setEditable(false);
        numero.setText(".");

        lbljugador1.setText(".");
        lbljugador1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lbljugador1InputMethodTextChanged(evt);
            }
        });

        javax.swing.GroupLayout panelvidasj2Layout = new javax.swing.GroupLayout(panelvidasj2);
        panelvidasj2.setLayout(panelvidasj2Layout);
        panelvidasj2Layout.setHorizontalGroup(
            panelvidasj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );
        panelvidasj2Layout.setVerticalGroup(
            panelvidasj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 102, Short.MAX_VALUE)
        );

        paneldatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Jugador en turno");

        panelvidasj1.setBackground(new java.awt.Color(255, 204, 0));
        panelvidasj1.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout panelvidasj1Layout = new javax.swing.GroupLayout(panelvidasj1);
        panelvidasj1.setLayout(panelvidasj1Layout);
        panelvidasj1Layout.setHorizontalGroup(
            panelvidasj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );
        panelvidasj1Layout.setVerticalGroup(
            panelvidasj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        txajugadorT.setColumns(20);
        txajugadorT.setRows(5);
        txajugadorT.setEnabled(false);
        jScrollPane2.setViewportView(txajugadorT);

        panelvidj2.setBackground(new java.awt.Color(51, 255, 51));
        panelvidj2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelvidj2Layout = new javax.swing.GroupLayout(panelvidj2);
        panelvidj2.setLayout(panelvidj2Layout);
        panelvidj2Layout.setHorizontalGroup(
            panelvidj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );
        panelvidj2Layout.setVerticalGroup(
            panelvidj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout paneldatosLayout = new javax.swing.GroupLayout(paneldatos);
        paneldatos.setLayout(paneldatosLayout);
        paneldatosLayout.setHorizontalGroup(
            paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelvidj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paneldatosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelvidasj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        paneldatosLayout.setVerticalGroup(
            paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelvidasj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(panelvidj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        btntirardado.setText("tirar dado");
        btntirardado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntirardadoActionPerformed(evt);
            }
        });

        btnatacar.setText("Atacar");
        btnatacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatacarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnArriba, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btmIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(paneldatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(panelvidasj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbljugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btntirardado)
                        .addGap(43, 43, 43)
                        .addComponent(btnatacar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(panelvidasj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(paneldatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 11, Short.MAX_VALUE)
                                .addComponent(lbljugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnatacar)
                                    .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btntirardado))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btnArriba, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btmIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(197, 197, 197))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbajoActionPerformed
        // TODO add your handling code here:
               turno(Integer.parseInt(numero.getText()),tab,1,"y",0);
               botones(false);
                btntirardado.setEnabled(true);


    }//GEN-LAST:event_btnAbajoActionPerformed

    private void btnArribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArribaActionPerformed
        // TODO add your handling code here:
                 turno(Integer.parseInt(numero.getText()),tab,-1,"y",0);
                 botones(false);
                btntirardado.setEnabled(true);

    }//GEN-LAST:event_btnArribaActionPerformed

    private void btmIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmIzquierdaActionPerformed
        // TODO add your handling code here:
              turno(Integer.parseInt(numero.getText()),tab,-1,"x",0);
              botones(false);
            btntirardado.setEnabled(true);

    }//GEN-LAST:event_btmIzquierdaActionPerformed

    private void btnDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDerechaActionPerformed
        // TODO add your handling code here:
       turno(Integer.parseInt(numero.getText()),tab,1,"x",0);
       botones(false);
       btntirardado.setEnabled(true);

    }//GEN-LAST:event_btnDerechaActionPerformed

    private void lbljugador1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lbljugador1InputMethodTextChanged
        
        // TODO add your handling code here:
    }//GEN-LAST:event_lbljugador1InputMethodTextChanged

    private void btntirardadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntirardadoActionPerformed
        // TODO add your handling code here:
    
        for(int i=1;i<7;i++){
            int numerodado =(int) (Math.random() * i);
            if(numerodado==0){
                numerodado=6;
            }
            numero.setText(String.valueOf(numerodado));
           try {
               Thread.sleep(10);
           } catch (InterruptedException ex) {
               Logger.getLogger(TableroView.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        botones(true);
        btntirardado.setEnabled(false);
    }//GEN-LAST:event_btntirardadoActionPerformed

    private void btnatacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatacarActionPerformed
        // TODO add your handling code here:
        turno(0,tab,0,"a",0);
        //botones(true);
        //btntirardado.setEnabled(true);

    }//GEN-LAST:event_btnatacarActionPerformed

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseExited
    public void cerrar(){
        dispose();
    }
    boolean turn;
    int turnpers1,turnpers2;
    public void turno(int numero, Tablero tab,int mov, String dir,int jug){
        
        if(turn==false){
                
            leerFile(2);
            if(numero==0){
            turn=false;
            
            }else{
                if(turnpers1==0){
                    System.out.println("tuno"+turnpers1);
                    turnpers1+=1;
                }else if(turnpers1==1){
                    System.out.println("tuno"+turnpers1);
                    turnpers1+=1;
                }else if(turnpers1==2){
                    System.out.println("tuno"+turnpers1);
                    turnpers1=0;
                }
                turn=true;
            }
            Movimiento movs = new Movimiento(numero,tab,mov,dir,1,turnpers1,0);
            movs.start(); 
        }else if(turn==true){
            leerFile(1);
            
            if(numero==0){
                turn=true;
                
            }else{
                if(turnpers2==0){
                    System.out.println("tuno"+turnpers2);
                    turnpers2+=1;
                }else if(turnpers2==1){
                    System.out.println("tuno"+turnpers2);
                    turnpers2+=1;
                }else if(turnpers2==2){
                    System.out.println("tuno"+turnpers2);
                    turnpers2=0;
                }
                turn=false;
            }
            
            Movimiento movs = new Movimiento(numero,tab,mov,dir,2,0,turnpers2);
            movs.start();                
            
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
            java.util.logging.Logger.getLogger(TableroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableroView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmIzquierda;
    private javax.swing.JButton btnAbajo;
    private javax.swing.JButton btnArriba;
    private javax.swing.JButton btnDerecha;
    private javax.swing.JButton btnatacar;
    private javax.swing.JButton btntirardado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbljugador1;
    private javax.swing.JTextField numero;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel paneldatos;
    private javax.swing.JPanel panelvidasj1;
    private javax.swing.JPanel panelvidasj2;
    private javax.swing.JPanel panelvidj2;
    private javax.swing.JTextArea txajugadorT;
    // End of variables declaration//GEN-END:variables
    
}
