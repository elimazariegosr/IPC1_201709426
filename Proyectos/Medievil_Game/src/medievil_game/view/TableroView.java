/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import medievil_game.controller.Archivo;
import medievil_game.controller.Movimiento;
import medievil_game.controller.Tablero;
import medievil_game.controller.Tiempo;
import medievil_game.model.Personaje;

/**
 *
 * @author Mazariegos
 */
public class TableroView extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form TableroView
     */
    
    private int segundos=0, minutos=0;
    private int numrandom=0;
    private boolean continuar = true;
    private Tiempo tim;

    public Tablero tab;
    public Movimiento atac;
    public boolean tablerocreado = true;
    public int tamanio;
    public JLabel lblImagen;
    public ImageIcon imagenvida;
    EmpezarJuego emj = new EmpezarJuego();
    Archivo arch = new Archivo();
    public TableroView() {
        initComponents();
        setLocationRelativeTo(null);

        panel.removeAll();
        lblImagen = new JLabel();
        lblImagen.setBounds(10, 20, 630, 630);
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
        leerFileJ2(2);
        
        Personaje pers = new Personaje();
        pers.agregarImagenes(tab.tam, tab.tam);
        botones(false);
        
        borrarS();
        borrarM();
        seguir();
           txtmi.setText(String.valueOf(minutos));
        txtse.setText(String.valueOf(segundos));
        numero.setText(String.valueOf(numrandom));
      
        tim=null;
        tim = new Tiempo(this);
        tim.start();
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
// poner el numero aleatorio de 1 a 6 i poner un gif    
    public  void aleatorio(){
            numrandom = (int)(Math.random()*6);
            ImageIcon iconogif=null;
            if(numrandom==0){
                numrandom=6;
            }    
            for(int i=1; i <=6; i++){
                if(numrandom==i){
                    ImageIcon gif = new ImageIcon(getClass().
                            getResource("/Pictures/dado" + i + ".png")); 
                    iconogif= new ImageIcon(gif.getImage().
                    getScaledInstance(39,39,Image.SCALE_DEFAULT));
                }
            }
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(TableroView.class.getName()).log(Level.SEVERE, null, ex);
        }
            numero.setIcon(iconogif);
            numero.setText(String.valueOf(numrandom));

    }
    //cambiar imagen despues de poner gif
    public synchronized int aumentarS(){
        segundos++;
        txtse.setText(String.valueOf(segundos));
        return segundos;
    }
    public synchronized int aumentarM(){
        minutos++;
        txtmi.setText(String.valueOf(minutos));
        return minutos;
    }

    public synchronized int getSegundos() {
        return segundos;
    }

    public synchronized int getMinutos() {
        return minutos;
    }
    public synchronized void seguir(){
        continuar =true;
    }
    public void borrarS(){
        txtse.setText(String.valueOf("0"));
        segundos=0;
    }
    public void borrarM(){
        
        txtmi.setText(String.valueOf("0"));
        minutos=0;
    }
    public void botones(boolean des){
        
        btnArriba.setEnabled(des);
        btnAbajo.setEnabled(des);
        btmIzquierda.setEnabled(des);
        btnDerecha.setEnabled(des);
        btnatacar.setEnabled(des);
        
    }
    private final String ruta = System.getProperties().getProperty("user.dir");
    public void obtenerDatos(){
        String cadenaTiempo;
        String cadenaj1 =jTable1.getValueAt(0, 0) + "  Oden: " + jTable1.getValueAt(1, 0) +
                " " + jTable1.getValueAt(2, 0) + " " + jTable1.getValueAt(3, 0);
        String cadenaj2 =jTable2.getValueAt(0, 0) + "  Oden: " + jTable2.getValueAt(1, 0) +
                " " + jTable2.getValueAt(2, 0) + " " + jTable2.getValueAt(3, 0);
        cadenaTiempo= "Tiempo " + txtmi.getText() + 
                ":" + txtse.getText() + "s";
        arch.guardarTodo(cadenaj1,cadenaj2,cadenaTiempo);
    }
    public void leerFile(int numero){
        File archivo =null;
        FileReader fr = null;
        BufferedReader br=null;
        
        try{
        archivo = new File(ruta+"//Nombre"+numero+".txt");    
        
        fr= new FileReader(archivo);
        br= new BufferedReader(fr);
        String linea;
        
        DefaultTableModel model_tabla = new DefaultTableModel();
        if(numero==1){
        
        }
        model_tabla.addColumn("DATOS JUGADOR " + numero);
       while((linea=br.readLine())!=null){
            model_tabla.addRow(new String[]{linea});
          jTable1.setModel(model_tabla);
         } 
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if (fr!= null )fr.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    public void leerFileJ2(int numero){
        File archivo =null;
        FileReader fr = null;
        BufferedReader br=null;
        
        try{
        archivo = new File(ruta+"//Nombre"+numero+".txt");    
        
        fr= new FileReader(archivo);
        br= new BufferedReader(fr);
        String linea;
        
        DefaultTableModel model_tabla = new DefaultTableModel();
        if(numero==1){
        
        }
        model_tabla.addColumn("DATOS JUGADOR " + numero);
       while((linea=br.readLine())!=null){
            model_tabla.addRow(new String[]{linea});
          jTable2.setModel(model_tabla);
         } 
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if (fr!= null )fr.close();
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
        lbljugador1 = new javax.swing.JLabel();
        paneldatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelvidasj1 = new javax.swing.JPanel();
        panelvidj2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtmi = new javax.swing.JLabel();
        txtse = new javax.swing.JLabel();
        btntirardado = new javax.swing.JButton();
        btnatacar = new javax.swing.JButton();
        numero = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconImages(getIconImages());
        setPreferredSize(new java.awt.Dimension(1100, 700));
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

        lbljugador1.setText(".");
        lbljugador1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lbljugador1InputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        paneldatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("JUGADORES");

        panelvidasj1.setBackground(new java.awt.Color(255, 255, 51));
        panelvidasj1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelvidasj1Layout = new javax.swing.GroupLayout(panelvidasj1);
        panelvidasj1.setLayout(panelvidasj1Layout);
        panelvidasj1Layout.setHorizontalGroup(
            panelvidasj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelvidasj1Layout.setVerticalGroup(
            panelvidasj1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        panelvidj2.setBackground(new java.awt.Color(51, 255, 51));
        panelvidj2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelvidj2Layout = new javax.swing.GroupLayout(panelvidj2);
        panelvidj2.setLayout(panelvidj2Layout);
        panelvidj2Layout.setHorizontalGroup(
            panelvidj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelvidj2Layout.setVerticalGroup(
            panelvidj2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nombre:", null},
                {"Personaje 1 :", null},
                {"Personaje 2 :", null},
                {"Personaje 3 :", null}
            },
            new String [] {
                "Title 1", "null"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nombre:", null},
                {"Personaje 1 :", null},
                {"Personaje 2 :", null},
                {"Personaje 3 :", null}
            },
            new String [] {
                "Title 1", "null"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jLabel2.setText(":");

        txtmi.setPreferredSize(new java.awt.Dimension(26, 20));

        txtse.setPreferredSize(new java.awt.Dimension(26, 20));

        javax.swing.GroupLayout paneldatosLayout = new javax.swing.GroupLayout(paneldatos);
        paneldatos.setLayout(paneldatosLayout);
        paneldatosLayout.setHorizontalGroup(
            paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneldatosLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(txtmi, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtse, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelvidasj1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                    .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelvidj2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        paneldatosLayout.setVerticalGroup(
            paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addComponent(panelvidasj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        numero.setText(".");

        btnSalir.setText("Regresar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(paneldatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(lbljugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btntirardado)
                                .addGap(18, 18, 18)
                                .addComponent(btnatacar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnArriba, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btmIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(btnSalir)))
                        .addGap(230, 230, 230))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paneldatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 7, Short.MAX_VALUE)
                                .addComponent(lbljugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(321, 321, 321))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btntirardado)
                                    .addComponent(btnatacar)
                                    .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(btnArriba, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btmIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(btnSalir)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
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
            aleatorio();
            botones(true);
            btntirardado.setEnabled(false);
           
    }//GEN-LAST:event_btntirardadoActionPerformed

    private void btnatacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatacarActionPerformed
        // TODO add your handling code here:
        turno(0,tab,0,"a",0);
        //botones(true);
        //btntirardado.setEnabled(true);
        btnatacar.setEnabled(false);

    }//GEN-LAST:event_btnatacarActionPerformed

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseExited

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
                obtenerDatos();
                new MenuPrincipal().setVisible(true);
                dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
    public void cerrar(){
        dispose();
    }
    boolean turn;
    int turnpers1,turnpers2;
    public void turno(int numero, Tablero tab,int mov, String dir,int jug){
        
        if(turn==false){
                
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
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnatacar;
    private javax.swing.JButton btntirardado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lbljugador1;
    private javax.swing.JLabel numero;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel paneldatos;
    private javax.swing.JPanel panelvidasj1;
    private javax.swing.JPanel panelvidj2;
    private javax.swing.JLabel txtmi;
    private javax.swing.JLabel txtse;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
