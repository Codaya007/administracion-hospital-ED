/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Utilidades.PDFCrear;
import com.lowagie.text.DocumentException;
import java.awt.Color;
import java.lang.System.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Victor
 */
public class frmUsuarioConsultarCita extends javax.swing.JFrame {

  int Xmouse, Ymouse;

  /**
   * Creates new form frmUsuarioConsultarCita
   */
  public frmUsuarioConsultarCita() {
    initComponents();
    this.setLocationRelativeTo(null);
    btnRegresar.requestFocus();

    btnVerificarCita.setToolTipText("Verifica que exista la cita");
    btnRegresar.setToolTipText("Regresa a la interfaz anterior");
    btnSalir.setToolTipText(
      "Cierra todos las interfaces y procesos existentes"
    );
  }

    public boolean ExisteEnLista(JTable tabla, String dto, int col) {
        ImageIcon CuentaCoCitaIcono = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneCuentaConCitaIcono.png");

        boolean Existe = false;

        for (int i = 0; i < tabla.getRowCount(); i++) {
            if (tabla.getValueAt(i, col).equals(dto)) {
                Existe = true;

                String NombrePaciente = frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 2).toString();
                String ApellidoPaciente = frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 3).toString();
                String FechaCita = frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 8).toString();
                String HoraCita = frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 9).toString();
                String CedulaConsulta = frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 1).toString();

                JOptionPane.showMessageDialog(null, "El usuario " + NombrePaciente + " " + ApellidoPaciente + "  con numero de celuda " + CedulaConsulta + " \ncuenta con una cita para el dia " + FechaCita + " en el horario de " + HoraCita, "CUENTA CON CITA", JOptionPane.INFORMATION_MESSAGE, CuentaCoCitaIcono);
            }
        }
        return Existe;
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
        jLabel2 = new javax.swing.JLabel();
        txtNumeroCedula = new javax.swing.JTextField();
        btnVerificarCita = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        barraMovimiento = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONSULTAR CITA");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(20, 66, 114));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ingresar el numero de cedula");

        txtNumeroCedula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNumeroCedula.setForeground(java.awt.Color.gray);
        txtNumeroCedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroCedula.setText("Ingreso solo numeros");
        txtNumeroCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumeroCedulaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumeroCedulaFocusLost(evt);
            }
        });
        txtNumeroCedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNumeroCedulaMousePressed(evt);
            }
        });
        txtNumeroCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroCedulaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroCedulaKeyTyped(evt);
            }
        });

        btnVerificarCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnCitaConsultarIcono.png"))); // NOI18N
        btnVerificarCita.setText("VERIFICAR CITA");
        btnVerificarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarCitaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONSULTA DE CITAS");

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnRegresarIcono.png"))); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Fondos/IconoConsultaPanel.png"))); // NOI18N

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnSalirIcono.png"))); // NOI18N
        btnSalir.setText("   SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        barraMovimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        barraMovimiento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraMovimientoMouseDragged(evt);
            }
        });
        barraMovimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraMovimientoMousePressed(evt);
            }
        });

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnMostrarInventarioIcono.png"))); // NOI18N
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barraMovimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnVerificarCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNumeroCedula, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnSalir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnImprimir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRegresar)))))
                        .addGap(12, 12, 12))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(barraMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btnVerificarCita)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalir)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnRegresar)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
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

  private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
    // TODO add your handling code here:
    FrmMenuPaciente abrir = new FrmMenuPaciente();
    abrir.setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_btnRegresarActionPerformed

  private void btnVerificarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarCitaActionPerformed
    // TODO add your handling code here:
    ImageIcon CedulaInvalidaIcono = new ImageIcon(
      "src/RecursosGraficos/JoptionPane/JoptionPaneCedulaInvalidaIcono.png"
    );
    ImageIcon SinRegistroIcono = new ImageIcon(
      "src/RecursosGraficos/JoptionPane/JoptionPaneSinRegistroIcono.png"
    );
    ImageIcon SinCitaIcono = new ImageIcon(
      "src/RecursosGraficos/JoptionPane/JoptionPaneSinCitaIcono.png"
    );
    ImageIcon NumeroMenor = new ImageIcon(
      "src/RecursosGraficos/JoptionPane/JoptionPaneNumeroIgualIcono.png"
    );
    ImageIcon ErrorCedula = new ImageIcon(
      "src/RecursosGraficos/JoptionPane/JoptionPaneErrorCampoIcono.png"
    );

    String cedula = txtNumeroCedula.getText();
    frmPersonalCitasPorAtender abrir = new frmPersonalCitasPorAtender();
    abrir.setVisible(false);
    if (
      txtNumeroCedula.getText().isEmpty() ||
      txtNumeroCedula.getText().equalsIgnoreCase("Ingreso solo numeros")
    ) {
      JOptionPane.showMessageDialog(
        null,
        "Ingrese el numero de cedula",
        "NUMERO DE CEDULA VACIO",
        JOptionPane.ERROR_MESSAGE,
        CedulaInvalidaIcono
      );
    } else if (cedula.length() < 10) {
      JOptionPane.showMessageDialog(
        null,
        "La cedula tiene menos de 10 digitos",
        "CEDULA MAL ESTABLECIDA",
        JOptionPane.ERROR_MESSAGE,
        NumeroMenor
      );
    } else if (
      Vista.frmPersonalCitasPorAtender.tblCitasSinAtender.getRowCount() <= 0
    ) {
      JOptionPane.showMessageDialog(
        null,
        "No hay registros de citas, primero tiene que agendar una cita",
        "NO HAY REGISTROS",
        JOptionPane.ERROR_MESSAGE,
        SinRegistroIcono
      );
    } else if (
      ExisteEnLista(
        Vista.frmPersonalCitasPorAtender.tblCitasSinAtender,
        cedula,
        1
      ) ==
      true
    ) {} else {
      JOptionPane.showMessageDialog(
        null,
        "No cuenta con una cita disponible \n Registre una cita",
        "NO CUENTA CON CITA",
        JOptionPane.INFORMATION_MESSAGE,
        SinCitaIcono
      );
    }
  }//GEN-LAST:event_btnVerificarCitaActionPerformed

  private void txtNumeroCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroCedulaKeyTyped
    // TODO add your handling code here:
    int key = evt.getKeyChar();
    boolean delete = key == 8;

    Character c = evt.getKeyChar();

    if (!(Character.isDigit(c) || delete)) {
      evt.consume();
      JOptionPane.showMessageDialog(
        null,
        "Solo ingreso de numeros",
        "TEXTO NO VALIDO",
        JOptionPane.WARNING_MESSAGE
      );
    }
    if (txtNumeroCedula.getText().length() >= 10) {
      evt.consume();
    }
  }//GEN-LAST:event_txtNumeroCedulaKeyTyped

  private void txtNumeroCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroCedulaKeyPressed
    // TODO add your handling code here:
    if (evt.getKeyCode() == evt.VK_ENTER) {
      btnVerificarCita.requestFocus();
    }
  }//GEN-LAST:event_txtNumeroCedulaKeyPressed

  private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    // TODO add your handling code here:
    ImageIcon SalirConfirmar = new ImageIcon(
      "src/RecursosGraficos/JoptionPane/JoptionPaneSalirIcono.png"
    );

    int valor = JOptionPane.showConfirmDialog(
      null,
      "¿Esta seguro que quiere salir del sistema?\n Se perderan todos los avances",
      "CONFIRMACION DE SALIDA",
      JOptionPane.YES_NO_OPTION,
      JOptionPane.WARNING_MESSAGE,
      SalirConfirmar
    );

    if (valor == JOptionPane.YES_OPTION) {
      System.exit(0);
    }
  }//GEN-LAST:event_btnSalirActionPerformed

  private void barraMovimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMovimientoMousePressed
    // TODO add your handling code here:
    Xmouse = evt.getX();
    Ymouse = evt.getY();
  }//GEN-LAST:event_barraMovimientoMousePressed

  private void barraMovimientoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMovimientoMouseDragged
    // TODO add your handling code here:
    int x = evt.getXOnScreen();
    int y = evt.getYOnScreen();
    this.setLocation(x - Xmouse, y - Ymouse);
  }//GEN-LAST:event_barraMovimientoMouseDragged

  private void txtNumeroCedulaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNumeroCedulaMousePressed
    // TODO add your handling code here:
    //        if(txtNumeroCedula.getText().equals("9999999999")){
    //            txtNumeroCedula.setText("");
    //            txtNumeroCedula.setForeground(Color.BLACK);
    //        }

  }//GEN-LAST:event_txtNumeroCedulaMousePressed

  private void txtNumeroCedulaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroCedulaFocusGained
    // TODO add your handling code here:
    if (txtNumeroCedula.getText().equals("Ingreso solo numeros")) {
      txtNumeroCedula.setText("");
      txtNumeroCedula.setForeground(Color.BLACK);
    }
  }//GEN-LAST:event_txtNumeroCedulaFocusGained

  private void txtNumeroCedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroCedulaFocusLost
    // TODO add your handling code here:
    if (txtNumeroCedula.getText().isEmpty()) {
      txtNumeroCedula.setText("Ingreso solo numeros");
      txtNumeroCedula.setForeground(Color.GRAY);
    }
  }//GEN-LAST:event_txtNumeroCedulaFocusLost

  private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
    PDFCrear crea = new PDFCrear();
    try {
      if (crea.ImprimirBuscado(txtNumeroCedula.getText()) == true) {
        JOptionPane.showMessageDialog(
          null,
          " Su pdf ha sido creado",
          "PDF CREADO EXITOSAMENTE",
          JOptionPane.INFORMATION_MESSAGE
        );
      } else {
        JOptionPane.showMessageDialog(
          null,
          " Su pdf no ha sido creado, cree una cita",
          "ERROR",
          JOptionPane.INFORMATION_MESSAGE
        );
      }
    } catch (DocumentException ex) {}
  }//GEN-LAST:event_btnImprimirActionPerformed

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
      java.util.logging.Logger
        .getLogger(frmUsuarioConsultarCita.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger
        .getLogger(frmUsuarioConsultarCita.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger
        .getLogger(frmUsuarioConsultarCita.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger
        .getLogger(frmUsuarioConsultarCita.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          new frmUsuarioConsultarCita().setVisible(true);
        }
      }
    );
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barraMovimiento;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerificarCita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNumeroCedula;
    // End of variables declaration//GEN-END:variables
}
