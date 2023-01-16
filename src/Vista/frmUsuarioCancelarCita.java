/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Paciente;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static Vista.frmUsuarioSeleccionarFecha.EnviarContenido;
import java.awt.Color;

/**
 *
 * @author Victor
 */
public class frmUsuarioCancelarCita extends javax.swing.JFrame {
    int Xmouse,Ymouse;

    /**
     * Creates new form frmUsuarioCancelarCita
     */
    public frmUsuarioCancelarCita() {
        initComponents();
        this.setLocationRelativeTo(null);
        btnBuscarCita.requestFocus();
        
        btnRegresar.setToolTipText("Regresa a la interfaz anterior");
        btnSalir.setToolTipText("Cierra todos las interfaces y procesos existentes");
        btnBuscarCita.setToolTipText("Verifica que exista la cita");
        btnCancelarCita.setToolTipText("Elimina la cita que esta registrada");
    }
    
    public boolean ExisteEnTabla(JTable tabla, String dto, int col) {
        ImageIcon CuentaCoCitaIcono = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneCuentaConCitaIcono.png");
        
        boolean Existe = false;
        
        for (int i = 0; i < tabla.getRowCount(); i++) {
            if (tabla.getValueAt(i, col).equals(dto)) {
                Existe = true;
                
                String CedulaConsulta =frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 0).toString();    
                String NombrePaciente = frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 1).toString();
                String ApellidoPaciente = frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 2).toString();
                String EdadConsultar =frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 3).toString();    
                String GeneroConsultar =frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 4).toString();    
                String TelefonoConsultar =frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 5).toString();    
                String MolestiaConsultar =frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 6).toString();    
                String FechaCita = frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 7).toString();
                String HoraCita = frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 8).toString();
                
                
                JOptionPane.showMessageDialog(null,"El usuario "+NombrePaciente+" "+ApellidoPaciente+"  con numero de celuda "+CedulaConsulta +" \ncuenta con una cita para el dia "+FechaCita+" en el horario de "+HoraCita,"CUENTA CON CITA",JOptionPane.INFORMATION_MESSAGE,CuentaCoCitaIcono);
                txaDatosPaciente.setText("Nombres: "+NombrePaciente+" "+ApellidoPaciente+"\nNumero de celuda: "+CedulaConsulta +" \nEdad: "+EdadConsultar +"\nGenero: "+GeneroConsultar+"\nNumero de telefono: "+TelefonoConsultar+"\nEnfermedad: "+MolestiaConsultar+" \nFecha de cita: "+FechaCita+"\nHorario: "+HoraCita);
            }
        }
        return Existe;
    }
    
    public boolean ExisteEnTabla2(JTable tabla, String dto, int col) {
        
        boolean Existe2 = false;
        
        for (int i = 0; i < tabla.getRowCount(); i++) {
            if (tabla.getValueAt(i, col).equals(dto)) {
                Existe2 = true;        
            }
        }
        return Existe2;
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
        lblMovimiento = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNumeroCedulaCancelar = new javax.swing.JTextField();
        btnBuscarCita = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDatosPaciente = new javax.swing.JTextArea();
        btnCancelarCita = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(20, 66, 114));

        lblMovimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMovimiento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblMovimientoMouseDragged(evt);
            }
        });
        lblMovimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMovimientoMousePressed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnSalirIcono.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnRegresarIcono.png"))); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CANCELAR CITA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingresar numero de cedula");

        txtNumeroCedulaCancelar.setForeground(java.awt.Color.gray);
        txtNumeroCedulaCancelar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroCedulaCancelar.setText("Ingreso solo numeros");
        txtNumeroCedulaCancelar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumeroCedulaCancelarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumeroCedulaCancelarFocusLost(evt);
            }
        });
        txtNumeroCedulaCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroCedulaCancelarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroCedulaCancelarKeyTyped(evt);
            }
        });

        btnBuscarCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnCitaConsultarIcono.png"))); // NOI18N
        btnBuscarCita.setText("BUSCAR CITA");
        btnBuscarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCitaActionPerformed(evt);
            }
        });

        txaDatosPaciente.setColumns(20);
        txaDatosPaciente.setRows(5);
        jScrollPane1.setViewportView(txaDatosPaciente);

        btnCancelarCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnCancelarIcono.png"))); // NOI18N
        btnCancelarCita.setText("CANCERLAR CITA");
        btnCancelarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCitaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DATOS DEL PACIENTE");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Fondos/IconoCancelarCitaAntes.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMovimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSalir)
                                .addGap(78, 78, 78))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRegresar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelarCita))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumeroCedulaCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarCita)))))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNumeroCedulaCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCita))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnCancelarCita)
                    .addComponent(btnRegresar))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblMovimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMovimientoMousePressed
        // TODO add your handling code here:
        Xmouse = evt.getX();
        Ymouse = evt.getY();
    }//GEN-LAST:event_lblMovimientoMousePressed

    private void lblMovimientoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMovimientoMouseDragged
        // TODO add your handling code here:
        int x =evt.getXOnScreen();
        int y =evt.getYOnScreen();
        this.setLocation(x-Xmouse,y- Ymouse);
    }//GEN-LAST:event_lblMovimientoMouseDragged

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        ImageIcon SalirConfirmar = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneSalirIcono.png");
        
        int valor = JOptionPane.showConfirmDialog(null, "¿Esta seguro que quiere salir del sistema?\n Se perderan todos los avances", "CONFIRMACION DE SALIDA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, SalirConfirmar);
        
        if(valor == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        frmUsuarioSelecionarUso abrir = new frmUsuarioSelecionarUso();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBuscarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCitaActionPerformed
        // TODO add your handling code here:
        txaDatosPaciente.setText("");
        ImageIcon CedulaInvalidaIcono = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneCedulaInvalidaIcono.png");
        ImageIcon SinRegistroIcono = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneSinRegistroIcono.png");
        ImageIcon SinCitaIcono = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneSinCitaIcono.png");
        ImageIcon NumeroMenor = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneNumeroIgualIcono.png");
        ImageIcon ErrorCedula = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneErrorCampoIcono.png");
        
        String cedula = txtNumeroCedulaCancelar.getText();
        frmPersonalCitasPorAtender abrir = new frmPersonalCitasPorAtender();
        abrir.setVisible(false);
        
        if(txtNumeroCedulaCancelar.getText().isEmpty() || txtNumeroCedulaCancelar.getText().equalsIgnoreCase("Ingreso solo numeros")){
            JOptionPane.showMessageDialog(null, "Ingrese el numero de cedula","NUMERO DE CEDULA VACIO",JOptionPane.ERROR_MESSAGE,CedulaInvalidaIcono);
        }
        else if(cedula.length() < 10) {
            JOptionPane.showMessageDialog(null, "La cedula tiene menos de 10 digitos", "CEDULA MAL ESTABLECIDA", JOptionPane.ERROR_MESSAGE,NumeroMenor);
        }
        else if(!txtNumeroCedulaCancelar.getText().matches("11\\d{8}")){
            JOptionPane.showMessageDialog(null, "El numero de cedula tiene que iniciar con 11","CEDULA NO VALIDO",JOptionPane.ERROR_MESSAGE,ErrorCedula);
        }
        else if(Vista.frmPersonalCitasPorAtender.tblCitasSinAtender.getRowCount() <= 0){
            JOptionPane.showMessageDialog(null, "No hay registros de citas, primero tiene que agendar una cita","NO HAY REGISTROS",JOptionPane.ERROR_MESSAGE,SinRegistroIcono);
        }
        else if(ExisteEnTabla(Vista.frmPersonalCitasPorAtender.tblCitasSinAtender, cedula, 0)== true){ 
            
        }
        else{
            JOptionPane.showMessageDialog(null, "No cuenta con una cita disponible \n Registre una cita","NO CUENTA CON CITA",JOptionPane.INFORMATION_MESSAGE,SinCitaIcono);
        }
    }//GEN-LAST:event_btnBuscarCitaActionPerformed

    private void txtNumeroCedulaCancelarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroCedulaCancelarKeyTyped
        // TODO add your handling code here:
        Character c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }if(txtNumeroCedulaCancelar.getText().length()>=10){
            evt.consume();
        }
    }//GEN-LAST:event_txtNumeroCedulaCancelarKeyTyped

    private void txtNumeroCedulaCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroCedulaCancelarKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_ENTER){
            btnBuscarCita.requestFocus();
        }
    }//GEN-LAST:event_txtNumeroCedulaCancelarKeyPressed

    private void btnCancelarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCitaActionPerformed
        // TODO add your handling code here:

        ImageIcon CedulaInvalidaIcono = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneCedulaInvalidaIcono.png");
        ImageIcon SinCita = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneSinCitaIcono.png");
        ImageIcon NumeroMenor = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneNumeroIgualIcono.png");
        ImageIcon CitaEliminada = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneCitaEliminadaIcono.png");
        ImageIcon CitaNoEliminada = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneCitaNoEliminadaIcono.png");
        ImageIcon Confirmar = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneConfirmarIcono.png");
        ImageIcon SinRegistroIcono = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneSinRegistroIcono.png");
        ImageIcon ErrorCedula = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneErrorCampoIcono.png");

        String cedula = txtNumeroCedulaCancelar.getText();
//        EnviarContenido.removeIf(x -> x.getIdentificacion().equals(cedula));

        if (cedula.isEmpty()|| txtNumeroCedulaCancelar.getText().equalsIgnoreCase("Ingreso solo numeros")) {
            JOptionPane.showMessageDialog(null, "Ingrese el numero de cedula", "NUMERO DE CEDULA VACIO", JOptionPane.ERROR_MESSAGE, CedulaInvalidaIcono);
        } 
        else if (cedula.length() < 10) {
            JOptionPane.showMessageDialog(null, "La cedula tiene menos de 10 digitos", "CEDULA MAL ESTABLECIDA", JOptionPane.ERROR_MESSAGE, NumeroMenor);
        }
        else if(!txtNumeroCedulaCancelar.getText().matches("11\\d{8}")){
            JOptionPane.showMessageDialog(null, "El numero de cedula tiene que iniciar con 11","CEDULA NO VALIDO",JOptionPane.ERROR_MESSAGE,ErrorCedula);
        }
        else if(Vista.frmPersonalCitasPorAtender.tblCitasSinAtender.getRowCount() <= 0){
            JOptionPane.showMessageDialog(null, "No hay registros de citas, primero tiene que agendar una cita","NO HAY REGISTROS",JOptionPane.ERROR_MESSAGE,SinRegistroIcono);
        }
        else {
            if(ExisteEnTabla2(Vista.frmPersonalCitasPorAtender.tblCitasSinAtender, cedula, 0)==true){
                int respuesta = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar la cita?", "CONFIRMAR", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,Confirmar);

                if (respuesta == JOptionPane.YES_OPTION) {
                    
                    EnviarContenido.removeIf(p -> p.getIdentificacion().equals(cedula));
                    JOptionPane.showMessageDialog(null, "La cita se ha eliminado", "CITA ELIMINADA", JOptionPane.INFORMATION_MESSAGE, CitaEliminada);
                    txaDatosPaciente.setText("");
                }else{
                    JOptionPane.showMessageDialog(null, "La cita no se ha eliminado", "CITA NO ELIMINADA", JOptionPane.INFORMATION_MESSAGE, CitaNoEliminada);
                }
            }else{
                JOptionPane.showMessageDialog(null, "No cuenta con cita", "CITA NO DISPONIBLE", JOptionPane.INFORMATION_MESSAGE, SinCita);
            }
            
        }
    }//GEN-LAST:event_btnCancelarCitaActionPerformed

    private void txtNumeroCedulaCancelarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroCedulaCancelarFocusGained
        // TODO add your handling code here:
        if (txtNumeroCedulaCancelar.getText().equals("Ingreso solo numeros")) {
            txtNumeroCedulaCancelar.setText("");
            txtNumeroCedulaCancelar.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtNumeroCedulaCancelarFocusGained

    private void txtNumeroCedulaCancelarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroCedulaCancelarFocusLost
        // TODO add your handling code here:
        if (txtNumeroCedulaCancelar.getText().isEmpty()) {
            txtNumeroCedulaCancelar.setText("Ingreso solo numeros");
            txtNumeroCedulaCancelar.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtNumeroCedulaCancelarFocusLost

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
            java.util.logging.Logger.getLogger(frmUsuarioCancelarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUsuarioCancelarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUsuarioCancelarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUsuarioCancelarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUsuarioCancelarCita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCita;
    private javax.swing.JButton btnCancelarCita;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMovimiento;
    private javax.swing.JTextArea txaDatosPaciente;
    private javax.swing.JTextField txtNumeroCedulaCancelar;
    // End of variables declaration//GEN-END:variables
}
