package Vista;

import Controlador.ListaEnlazada.ListaEnlazada;
import Modelo.Paciente;
import Modelo.Valoracion;
import static Vista.frmUsuarioSeleccionarFecha.ListaDePacientes;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jaime Mendoza
 */
public class frmPersonalEnfermera extends javax.swing.JFrame {
    int Xmouse,Ymouse;
    
    ListaEnlazada<Valoracion> ListaValoracion = new ListaEnlazada<>();

    /**
     * Creates new form frmPersonalEnfermera
     */
    public frmPersonalEnfermera() {
        initComponents();
        this.setLocationRelativeTo(null);
        CargarDatosCitasAtender();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPrecionArterial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAltura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTemperatura = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtPrecionCardiaca = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbxNumeroCedula = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VALORACION");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(20, 66, 114));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VALORACION DEL PACIENTE");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tomar datos generales del paciente");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Precion arterial");

        txtPrecionArterial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecionArterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecionArterialKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecionArterialKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Altura");

        txtAltura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAltura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAlturaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAlturaKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Peso");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Temperatura");

        txtTemperatura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTemperatura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTemperaturaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTemperaturaKeyTyped(evt);
            }
        });

        txtPeso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesoKeyTyped(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnGuardarInformacionIcono.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnRegresarIcono.png"))); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Precion cardiaca");

        txtPrecionCardiaca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecionCardiaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecionCardiacaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecionCardiacaKeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(32, 82, 149));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Fondos/IconoSignosVitales.png"))); // NOI18N

        cbxNumeroCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNumeroCedulaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxNumeroCedula, 0, 157, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxNumeroCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel12.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel12MouseDragged(evt);
            }
        });
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel12MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addComponent(txtPrecionCardiaca, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecionArterial)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAltura)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTemperatura)
                    .addComponent(txtPeso)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecionArterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecionCardiaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        frmPersonarSeleccionarPersonal abrir = new frmPersonarSeleccionarPersonal();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        
        // Traer los datos de los campos de texto
        float Peso = Float.parseFloat(txtPeso.getText());
        float Altura = Float.parseFloat(txtAltura.getText());
        float PrecionA = Float.parseFloat(txtPrecionArterial.getText());
        float presionC = Float.parseFloat(txtPrecionCardiaca.getText());
        float temperatura = Float.parseFloat(txtTemperatura.getText());
        
        Paciente a = null;
        Valoracion val = new Valoracion();
        val.setAltura(Altura);
        val.setPeso(Peso);
        val.setPresionArterial(PrecionA);
        val.setPresionCardiaca(presionC);
        val.setTemperatura(temperatura);
 
        //Asignar una valoracion a cada paciente
        for (int i = ListaDePacientes.size() - 1; i >= 0; i--) {
            a = (Paciente) frmUsuarioSeleccionarFecha.ListaDePacientes.get(i);
            if (a.getIdentificacion() == cbxNumeroCedula.getSelectedItem()) {
                 a.setValoracion(val);
            }
        }
        
        
        //Condiciones en caso de que los campos esten vacios
        if (txtPrecionArterial.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Los datos acerca de la precion arterial estan vacios", "DATOS VACIOS", JOptionPane.WARNING_MESSAGE);
        } 
        else if (txtAltura.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Los datos acerca de la altura estan vacios", "DATOS VACIOS", JOptionPane.WARNING_MESSAGE);
        } 
        else if (txtPeso.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Los datos acerca del peso estan vacios", "DATOS VACIOS", JOptionPane.WARNING_MESSAGE);
        } 
        else if (txtTemperatura.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Los datos acerca de la temperatura estan vacios", "DATOS VACIOS", JOptionPane.WARNING_MESSAGE);
        } 
        else if (txtPrecionCardiaca.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Los datos acerca de la precion cardiaca estan vacios", "DATOS VACIOS", JOptionPane.WARNING_MESSAGE);
        } 
        else{
             //Escribir los datos en el archivo Json
            ListaValoracion.add(new Valoracion(Peso, Altura, PrecionA, presionC, temperatura));
            
            Gson gson = new Gson();
            
            FileWriter writer;
            
            try {
                writer = new FileWriter("ListaValoracion.json");
                gson.toJson(ListaValoracion, writer);
                writer.close();
            } 
            catch (IOException ex) {
                Logger.getLogger(frmPersonalEnfermera.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            JOptionPane.showMessageDialog(null, "Los datos del paciente se han guardado exitosamente", "DATOS GUARDADOS", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Datos correctamente guardados");
            
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    //Seccion de Keys para los campos de texto cambiar con el enter
    private void txtPrecionArterialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecionArterialKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER)
        {
            txtAltura.requestFocus();
        }
    }//GEN-LAST:event_txtPrecionArterialKeyPressed

    private void txtAlturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlturaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER)
        {
            txtPeso.requestFocus();
        }
    }//GEN-LAST:event_txtAlturaKeyPressed

    private void txtPesoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER)
        {
            txtTemperatura.requestFocus();
        }
    }//GEN-LAST:event_txtPesoKeyPressed

    private void txtTemperaturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTemperaturaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER)
        {
            txtPrecionCardiaca.requestFocus();
        }
    }//GEN-LAST:event_txtTemperaturaKeyPressed

    private void txtPrecionCardiacaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecionCardiacaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER)
        {
            btnGuardar.requestFocus();
        }
    }//GEN-LAST:event_txtPrecionCardiacaKeyPressed

    //Seccion de keys para solo el ingreso de digtios y limitacion de valores
    private void txtPrecionArterialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecionArterialKeyTyped
        // TODO add your handling code here:
        Character c = evt.getKeyChar();
        if (!Character.isDigit(c))
        {
            evt.consume();
        }
        if (txtPrecionArterial.getText().length() >= 9)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecionArterialKeyTyped

    private void txtAlturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlturaKeyTyped
        // TODO add your handling code here:
        Character c = evt.getKeyChar();
        if (!Character.isDigit(c))
        {
            evt.consume();
        }
        if (txtAltura.getText().length() >= 3)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtAlturaKeyTyped

    private void txtPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoKeyTyped
        // TODO add your handling code here:
        Character c = evt.getKeyChar();
        if (!Character.isDigit(c))
        {
            evt.consume();
        }
        if (txtPeso.getText().length() >= 3)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtPesoKeyTyped

    private void txtTemperaturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTemperaturaKeyTyped
        // TODO add your handling code here:
        Character c = evt.getKeyChar();
        if (!Character.isDigit(c))
        {
            evt.consume();
        }
        if (txtTemperatura.getText().length() >= 4)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtTemperaturaKeyTyped

    private void txtPrecionCardiacaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecionCardiacaKeyTyped
        // TODO add your handling code here:
        Character c = evt.getKeyChar();
        if (!Character.isDigit(c))
        {
            evt.consume();
        }
        if (txtPrecionCardiaca.getText().length() >= 5)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecionCardiacaKeyTyped

    private void jLabel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MousePressed
        // TODO add your handling code here:
        Xmouse = evt.getX();
        Ymouse = evt.getY();
    }//GEN-LAST:event_jLabel12MousePressed

    private void jLabel12MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseDragged
        // TODO add your handling code here:
        int x =evt.getXOnScreen();
        int y =evt.getYOnScreen();
        this.setLocation(x-Xmouse,y- Ymouse);
    }//GEN-LAST:event_jLabel12MouseDragged

    private void cbxNumeroCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNumeroCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxNumeroCedulaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(frmPersonalEnfermera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(frmPersonalEnfermera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(frmPersonalEnfermera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(frmPersonalEnfermera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPersonalEnfermera().setVisible(true);
            }
        });
    }
    
    public void CargarDatosCitasAtender() {
        Paciente a;

        for (int i = ListaDePacientes.size() - 1; i >= 0; i--) {
            a = (Paciente) frmUsuarioSeleccionarFecha.ListaDePacientes.get(i);
              System.out.println(a);
              cbxNumeroCedula.addItem(a.getIdentificacion());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxNumeroCedula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPrecionArterial;
    private javax.swing.JTextField txtPrecionCardiaca;
    private javax.swing.JTextField txtTemperatura;
    // End of variables declaration//GEN-END:variables
}
