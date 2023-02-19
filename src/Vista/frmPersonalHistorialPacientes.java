/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.ImageIcon;
import Utilidades.PDFCrear;
import Controlador.ListaEnlazada.ListaEnlazada;
import Modelo.HistorialClinico;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Victor
 */
public class frmPersonalHistorialPacientes extends javax.swing.JFrame {

  int Xmouse, Ymouse;

  private DefaultTableModel modeloAtendido;
  int contadorAtendido = 0;

  /**
   * Creates new form frmPersonalHistorialPacientes
   */
  public frmPersonalHistorialPacientes() {
    initComponents();
    CargarHistorial();
    this.setLocationRelativeTo(null);
    CargarInterfazAtendidos();
    CargarDatosAtendidos();
  }

  ListaEnlazada<HistorialClinico> clin = new ListaEnlazada<>();

  public void CargarInterfazAtendidos() {
    String datos[][] = {};
    String columna[] = {
      "Tipo identificacion",
      "Cedula",
      "Nombres",
      "Apellidos",
      "Edad",
      "Genero",
      "Telefono",
      "Molestia",
      "Fecha",
      "Hora Atencion",
      "Medicamento",
      "Dosis",
    };
    modeloAtendido = new DefaultTableModel(datos, columna);
    tblRegistroPacientes.setModel(modeloAtendido);
  }

  void CargarHistorial() {
      Gson gson = new Gson();

    //Leer el archivo Json
      FileReader reader;

    try {
      reader = new FileReader("HistorialPacientes.json");
      ListaEnlazada<HistorialClinico> listaRegistroCargadas = gson.fromJson(
        reader,
        new TypeToken<ListaEnlazada<HistorialClinico>>() {}.getType()
      );

      for (HistorialClinico historialClinico : listaRegistroCargadas) {
        clin.add(historialClinico);
      }
    } catch (FileNotFoundException e) {}
  }

  public void CargarDatosAtendidos() {
    HistorialClinico a;

    for (int i = 0; i < clin.size(); i++) {
      a = (HistorialClinico) clin.get(i);
      modeloAtendido.insertRow(contadorAtendido, new Object[] {});
      modeloAtendido.setValueAt(a.getTipoId(), contadorAtendido, 0);
      modeloAtendido.setValueAt(a.getIdentificacionA(), contadorAtendido, 1);
      modeloAtendido.setValueAt(a.getNombresA(), contadorAtendido, 2);
      modeloAtendido.setValueAt(a.getApellidosA(), contadorAtendido, 3);
      modeloAtendido.setValueAt(a.getEdadA(), contadorAtendido, 4);
      modeloAtendido.setValueAt(a.getGeneroA(), contadorAtendido, 5);
      modeloAtendido.setValueAt(a.getTelefonoA(), contadorAtendido, 6);
      modeloAtendido.setValueAt(a.getMolestiaA(), contadorAtendido, 7);
      modeloAtendido.setValueAt(a.getFechaIngresoA(), contadorAtendido, 8);
      modeloAtendido.setValueAt(a.getHoraAtencionA(), contadorAtendido, 9);
      modeloAtendido.setValueAt(a.getMedicamentoA(), contadorAtendido, 10);
      modeloAtendido.setValueAt(a.getDosisA(), contadorAtendido, 11);
    }
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
    jLabel1 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblRegistroPacientes = new javax.swing.JTable();
    btnRegresar = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    btnSalir = new javax.swing.JButton();
    BtnImprimirHistorial1 = new javax.swing.JButton();
    BtnImprimirHistorial2 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("PACIENTES ATENDIDOS");
    setUndecorated(true);

    jPanel1.setBackground(new java.awt.Color(20, 66, 114));

    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("HISTORIAL CLINICO");

    tblRegistroPacientes.setModel(
      new javax.swing.table.DefaultTableModel(
        new Object[][] {
          {},
          {},
          {},
          {},
          {},
          {},
          {},
          {},
          {},
          {},
          {},
          {},
          {},
          {},
          {},
          {},
          {},
          {},
        },
        new String[] {}
      )
    );
    jScrollPane1.setViewportView(tblRegistroPacientes);

    btnRegresar.setIcon(
      new javax.swing.ImageIcon(
        getClass().getResource("/RecursosGraficos/Botones/btnRegresarIcono.png")
      )
    ); // NOI18N
    btnRegresar.setText("REGRESAR");
    btnRegresar.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          btnRegresarActionPerformed(evt);
        }
      }
    );

    jPanel2.setBackground(new java.awt.Color(32, 82, 149));

    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setIcon(
      new javax.swing.ImageIcon(
        getClass().getResource("/RecursosGraficos/Fondos/IconoHistorial.png")
      )
    ); // NOI18N

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
      jPanel2
    );
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel2Layout
            .createSequentialGroup()
            .addContainerGap()
            .addComponent(
              jLabel2,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              212,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addContainerGap(
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
        )
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel2Layout
            .createSequentialGroup()
            .addContainerGap()
            .addComponent(
              jLabel2,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              151,
              Short.MAX_VALUE
            )
            .addContainerGap()
        )
    );

    jLabel3.addMouseMotionListener(
      new java.awt.event.MouseMotionAdapter() {
        public void mouseDragged(java.awt.event.MouseEvent evt) {
          jLabel3MouseDragged(evt);
        }
      }
    );
    jLabel3.addMouseListener(
      new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
          jLabel3MousePressed(evt);
        }
      }
    );

    btnSalir.setIcon(
      new javax.swing.ImageIcon(
        getClass().getResource("/RecursosGraficos/Botones/btnSalirIcono.png")
      )
    ); // NOI18N
    btnSalir.setText("SALIR");
    btnSalir.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          btnSalirActionPerformed(evt);
        }
      }
    );

    BtnImprimirHistorial1.setIcon(
      new javax.swing.ImageIcon(
        getClass()
          .getResource(
            "/RecursosGraficos/Botones/btnMostrarInventarioIcono.png"
          )
      )
    ); // NOI18N
    BtnImprimirHistorial1.setText("Imprimir Historial");

    BtnImprimirHistorial2.setIcon(
      new javax.swing.ImageIcon(
        getClass()
          .getResource(
            "/RecursosGraficos/Botones/btnMostrarInventarioIcono.png"
          )
      )
    ); // NOI18N
    BtnImprimirHistorial2.setText("Imprimir Historial");
    BtnImprimirHistorial2.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          BtnImprimirHistorial2ActionPerformed(evt);
        }
      }
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
      jPanel1
    );
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          javax.swing.GroupLayout.Alignment.TRAILING,
          jPanel1Layout
            .createSequentialGroup()
            .addGap(12, 12, 12)
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(
                  jPanel1Layout
                    .createSequentialGroup()
                    .addGap(237, 237, 237)
                    .addComponent(
                      jLabel1,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      Short.MAX_VALUE
                    )
                )
                .addGroup(
                  jPanel1Layout
                    .createSequentialGroup()
                    .addComponent(btnSalir)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      Short.MAX_VALUE
                    )
                    .addComponent(BtnImprimirHistorial2)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                    )
                    .addComponent(btnRegresar)
                )
                .addGroup(
                  jPanel1Layout
                    .createSequentialGroup()
                    .addComponent(
                      jPanel2,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED
                    )
                    .addComponent(
                      jScrollPane1,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      895,
                      Short.MAX_VALUE
                    )
                )
            )
            .addGap(12, 12, 12)
        )
        .addComponent(
          jLabel3,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          Short.MAX_VALUE
        )
        .addGroup(
          jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
              jPanel1Layout
                .createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BtnImprimirHistorial1)
                .addGap(0, 0, Short.MAX_VALUE)
            )
        )
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel1Layout
            .createSequentialGroup()
            .addComponent(
              jLabel3,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              15,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(
                  jPanel2,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  Short.MAX_VALUE
                )
                .addComponent(
                  jScrollPane1,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  0,
                  Short.MAX_VALUE
                )
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnRegresar)
                .addComponent(btnSalir)
                .addComponent(
                  BtnImprimirHistorial2,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  Short.MAX_VALUE
                )
            )
            .addGap(9, 9, 9)
        )
        .addGroup(
          jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
              jPanel1Layout
                .createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BtnImprimirHistorial1)
                .addGap(0, 0, Short.MAX_VALUE)
            )
        )
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
      getContentPane()
    );
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(
          jPanel1,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          Short.MAX_VALUE
        )
    );
    layout.setVerticalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(
          jPanel1,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          Short.MAX_VALUE
        )
    );

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
    // TODO add your handling code here:
    Xmouse = evt.getX();
    Ymouse = evt.getY();
  }//GEN-LAST:event_jLabel3MousePressed

  private void jLabel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseDragged
    // TODO add your handling code here:
    int x = evt.getXOnScreen();
    int y = evt.getYOnScreen();
    this.setLocation(x - Xmouse, y - Ymouse);
  }//GEN-LAST:event_jLabel3MouseDragged

  private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    // TODO add your handling code here:
    ImageIcon SalirConfirmar = new ImageIcon(
      "src/RecursosGraficos/JoptionPane/JoptionPaneSalirIcono.png"
    );

    int valor = JOptionPane.showConfirmDialog(
      null,
      "¿Esta seguro que quiere salir del sistema?\n",
      "CONFIRMACION DE SALIDA",
      JOptionPane.YES_NO_OPTION,
      JOptionPane.WARNING_MESSAGE,
      SalirConfirmar
    );

    if (valor == JOptionPane.YES_OPTION) {
      System.exit(0);
    }
  }//GEN-LAST:event_btnSalirActionPerformed

  private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {                                             
    // TODO add your handling code here:
    FrmMenuDoctor abrir = new FrmMenuDoctor();
    abrir.setVisible(true);
    this.setVisible(false);
  }

  private void BtnImprimirHistorial2ActionPerformed(
    java.awt.event.ActionEvent evt
  ) {//GEN-FIRST:event_BtnImprimirHistorial2ActionPerformed
    // TODO add your handling code here:
    PDFCrear crea = new PDFCrear();
    if (crea.crearPdfHistorialPaciente() == true) {
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
  }//GEN-LAST:event_BtnImprimirHistorial2ActionPerformed

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
        .getLogger(frmPersonalHistorialPacientes.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger
        .getLogger(frmPersonalHistorialPacientes.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger
        .getLogger(frmPersonalHistorialPacientes.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger
        .getLogger(frmPersonalHistorialPacientes.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          try {
            new frmPersonalHistorialPacientes().setVisible(true);
          } catch (Exception ex) {
            Logger
              .getLogger(frmPersonalHistorialPacientes.class.getName())
              .log(Level.SEVERE, null, ex);
          }
        }
      }
    );
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton BtnImprimirHistorial1;
  private javax.swing.JButton BtnImprimirHistorial2;
  private javax.swing.JButton btnRegresar;
  private javax.swing.JButton btnSalir;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  public static javax.swing.JTable tblRegistroPacientes;
  // End of variables declaration//GEN-END:variables
}
