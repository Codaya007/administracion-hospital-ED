/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Paciente;
import static Utilidades.UtilidadesFechas.validarFecha;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Victor
 */
public class frmUsuarioSeleccionarFecha extends javax.swing.JFrame {
    int Xmouse,Ymouse;
 
    public static LinkedList<Paciente> EnviarContenido = new LinkedList<>();

    /**
     * Creates new form frmAgendarCita
     */
    public frmUsuarioSeleccionarFecha() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        btnAgendarCita.setToolTipText("Verifica la disponibilidad y guarda los datos");
        btnRegresar.setToolTipText("Regresa a la interfaz anterior");
        btnSalir.setToolTipText("Cierra todos las interfaces y procesos existentes");

    }

    public boolean ExisteEnTabla(JTable tabla, String cedula, int col) {
        
        boolean Existe = false;
        
        for (int i = 0; i < tabla.getRowCount(); i++) {
            if (tabla.getValueAt(i, col).equals(cedula)) {
                Existe = true;
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

        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtFechaCita = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbxHorarioAtencion = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnAgendarCita = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnRegresarInicio = new javax.swing.JButton();
        barramovimineto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INGRESAR LA FECHA PARA LA CITA");
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(20, 66, 114));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha de la cita");

        txtFechaCita.setForeground(java.awt.Color.gray);
        txtFechaCita.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaCita.setText("DIA / MES / AÑO");
        txtFechaCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtFechaCitaMousePressed(evt);
            }
        });
        txtFechaCita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFechaCitaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaCitaKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Horarios de atencion");

        cbxHorarioAtencion.setMaximumRowCount(9);
        cbxHorarioAtencion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "13:00 - 14:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00" }));
        cbxHorarioAtencion.setSelectedItem(null);
        cbxHorarioAtencion.setToolTipText("");
        cbxHorarioAtencion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxHorarioAtencionKeyPressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 153, 153));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("*Ingresar en formato dd/mm/aaaa*");

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficosFondos/regresarIcono.png"))); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnAgendarCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficosFondos/fechaValidaIcono.png"))); // NOI18N
        btnAgendarCita.setText("  AGENDAR");
        btnAgendarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarCitaActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficosFondos/calendarioIcono.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("SELECCIONAR FECHA");

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficosFondos/salirIcono.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnRegresarInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficosFondos/InicioIcono.png"))); // NOI18N
        btnRegresarInicio.setText("INICIO");
        btnRegresarInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarInicioActionPerformed(evt);
            }
        });

        barramovimineto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        barramovimineto.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barramoviminetoMouseDragged(evt);
            }
        });
        barramovimineto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barramoviminetoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barramovimineto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaCita, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxHorarioAtencion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegresarInicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgendarCita)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(barramovimineto, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxHorarioAtencion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnAgendarCita)
                    .addComponent(btnRegresar)
                    .addComponent(btnRegresarInicio))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgendarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarCitaActionPerformed
        // TODO add your handling code here:
        ImageIcon FechaVacia = new ImageIcon("src/RecursosGraficosFondos/FechaVacia.png");
        ImageIcon HorarioVacio = new ImageIcon("src/RecursosGraficosFondos/HorarioVacio.png");
        ImageIcon YaCuenta = new ImageIcon("src/RecursosGraficosFondos/YaCuenta.png");
        ImageIcon FechaPasada = new ImageIcon("src/RecursosGraficosFondos/FechaPasada.png");
        ImageIcon HorarioNoDisponible = new ImageIcon("src/RecursosGraficosFondos/HorarioLLeno.png");

        ImageIcon MuyLejana = new ImageIcon("src/RecursosGraficosFondos/FechaLejana.png");
        ImageIcon Agendado = new ImageIcon("src/RecursosGraficosFondos/Agendada.png");
        ImageIcon LimpiarDatos= new ImageIcon("src/RecursosGraficosFondos/LimpiarDatos.png");

        try {
            if (txtFechaCita.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese la fecha", "CAMPO VACIOS", JOptionPane.WARNING_MESSAGE, FechaVacia);
            } 
            else if (cbxHorarioAtencion.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese el horario", "CAMPO VACIOS", JOptionPane.WARNING_MESSAGE, HorarioVacio);
            } 
            else {
                if (txtFechaCita.getText().matches("^\\d{1,2}/\\d{1,2}/\\d{4}$")) {
                } 
                else {
                    JOptionPane.showMessageDialog(null, "La fecha tiene que contener 2 / en formato dia/mes/año", "FECHA SIN FORMATO0", JOptionPane.WARNING_MESSAGE, MuyLejana);
                }
                
                String fecha1;
                boolean resultado = true;
                fecha1 = txtFechaCita.getText();
                resultado = validarFecha(fecha1);
                String CbxHoraAtencion = cbxHorarioAtencion.getSelectedItem().toString();
                String cedula = Vista.frmUsuarioIngresarDatos.txtNumeroCedula.getText();

                SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
                Calendar calendario = GregorianCalendar.getInstance();
                Date fechaHoy = calendario.getTime();
                String Fe = txtFechaCita.getText();
                Date fechaSeleccionada = formatoDeFecha.parse(Fe);
                Date fechaLimite = formatoDeFecha.parse("30/12/2040");

                if (resultado == true) {
                    frmPersonalCitasPorAtender abrir = new frmPersonalCitasPorAtender();
                    abrir.setVisible(false);

                    if (fechaSeleccionada.before(fechaHoy)) {
                        JOptionPane.showMessageDialog(null, "La fecha seleccionada ya ha pasado", "FECHA PASADO", JOptionPane.INFORMATION_MESSAGE, FechaPasada);
                    } 
                    else if (ExisteEnTabla(Vista.frmPersonalCitasPorAtender.tblCitasSinAtender, fecha1, 7) == true & ExisteEnTabla(Vista.frmPersonalCitasPorAtender.tblCitasSinAtender, CbxHoraAtencion, 8)) {
                        JOptionPane.showMessageDialog(null, "La hora de atencion ya no esta disponible", "NO DISPONIBLE", JOptionPane.INFORMATION_MESSAGE, HorarioNoDisponible);
                    } 
                    else if (ExisteEnTabla(Vista.frmPersonalCitasPorAtender.tblCitasSinAtender, cedula, 0) == true) {
                        JOptionPane.showMessageDialog(null, "El usuario con numero de cedula " + cedula + " \nya tiene una cita agendada", "YA CUENTA CON CITA", JOptionPane.INFORMATION_MESSAGE, YaCuenta);
                    } 
                    else if (fechaSeleccionada.after(fechaLimite)) {
                        JOptionPane.showMessageDialog(null, "La fecha seleccionada es muy lejana", "FECHA DEMASIADO LEJANA", JOptionPane.INFORMATION_MESSAGE, MuyLejana);
                    } 
                    else {

                        String NumeroCedula = Vista.frmUsuarioIngresarDatos.txtNumeroCedula.getText();
                        String NombrePaciente = Vista.frmUsuarioIngresarDatos.txtNombrePaciente.getText();
                        String ApellidoPaciente = Vista.frmUsuarioIngresarDatos.txtApellidoPaciente.getText();
                        String EdadPaciente = Vista.frmUsuarioIngresarDatos.txtEdadPaciente.getText();
                        String GeneroPaciente = Vista.frmUsuarioIngresarDatos.cbxGeneroPaciente.getSelectedItem().toString();
                        String TelefonoPaciente = Vista.frmUsuarioIngresarDatos.txtNumeroTelefono.getText();
                        String MolestiaPaciente = Vista.frmUsuarioIngresarDatos.txaMolestias.getText();
                        String FechaAtencion = txtFechaCita.getText();
                        String HoraAtencion = cbxHorarioAtencion.getSelectedItem().toString();

                        Date miFecha = new SimpleDateFormat("dd/MM/yyyy").parse(txtFechaCita.getText());
                        calendario.setTime(miFecha);
                        int anio = calendario.get(Calendar.YEAR);
                        int mes = calendario.get(Calendar.MONTH);
                        int dia = calendario.get(Calendar.DAY_OF_MONTH);

                        String Dia = String.valueOf(dia);
                        String Mes = String.valueOf(mes);
                        String Anio = String.valueOf(anio);

                        Paciente paciente = new Paciente(NumeroCedula, NombrePaciente, ApellidoPaciente, EdadPaciente, GeneroPaciente, TelefonoPaciente, MolestiaPaciente, FechaAtencion, HoraAtencion, Dia, Mes, Anio);
                        EnviarContenido.add(paciente);

                        JOptionPane.showMessageDialog(null, "Cita agendada exitosamente", "AGENDADO", JOptionPane.INFORMATION_MESSAGE, Agendado);
                        
                        txtFechaCita.setText("DIA / MES / AÑO");
                        txtFechaCita.setForeground(Color.gray);
                        cbxHorarioAtencion.setSelectedItem(null);
                        
                        
                        int result = JOptionPane.showConfirmDialog(null, "Quiere limpiar todos los campos, \npara crear una nueva cita", "CONFIRMAR LIMPIEZA", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, LimpiarDatos);

                        if (result == JOptionPane.YES_OPTION) {
                            Vista.frmUsuarioIngresarDatos.txtNumeroCedula.setText("");
                            Vista.frmUsuarioIngresarDatos.txtNombrePaciente.setText("");
                            Vista.frmUsuarioIngresarDatos.txtApellidoPaciente.setText("");
                            Vista.frmUsuarioIngresarDatos.txtEdadPaciente.setText("");
                            Vista.frmUsuarioIngresarDatos.cbxGeneroPaciente.setSelectedItem(null);
                            Vista.frmUsuarioIngresarDatos.txtNumeroTelefono.setText("");
                            Vista.frmUsuarioIngresarDatos.txaMolestias.setText("");
                        }else{
                            
                        }
                        
                        
                    }
                } 
                else {
                    JOptionPane.showMessageDialog(null, "El formato de la fecha esta mal,tiene que tener limites de dias 30 o 31 y mes maximo 12 ,Por favor revisar", "FORMATO DE FECHA MAL ESTABLECIDO", JOptionPane.WARNING_MESSAGE, MuyLejana);
                }
            }
        } 
        catch (ParseException ex) {
        }
        Collections.sort(EnviarContenido, (Paciente g, Paciente h) -> g.getHoraAtencion().compareTo(h.getHoraAtencion()));
    }//GEN-LAST:event_btnAgendarCitaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        ImageIcon Seguro = new ImageIcon("src/RecursosGraficosFondos/ConfirmarSeguro.png");
        
        if (!txtFechaCita.getText().equalsIgnoreCase("DIA / MES / AÑO")  || cbxHorarioAtencion.getSelectedItem() != null){
            int result = JOptionPane.showConfirmDialog(null, "Estas seguro de salir? \nSe perderan todos los avances no guardados", "CONFIRMAR SALIDA", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,Seguro);
            
            if (result == JOptionPane.YES_OPTION) {
                this.dispose();
            }
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtFechaCitaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaCitaKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        boolean slash = key == 47;
        Character c = evt.getKeyChar();

        if (!(Character.isDigit(c) || slash)) {
            evt.consume();
        }
        if (txtFechaCita.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFechaCitaKeyTyped

    private void txtFechaCitaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaCitaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_ENTER){
            cbxHorarioAtencion.requestFocus();
        }
    }//GEN-LAST:event_txtFechaCitaKeyPressed

    private void cbxHorarioAtencionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxHorarioAtencionKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_ENTER){
            btnAgendarCita.requestFocus();
        }
    }//GEN-LAST:event_cbxHorarioAtencionKeyPressed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        ImageIcon SalirConfirmar = new ImageIcon("src/RecursosGraficosFondos/SalirIconoPane.png");
        
        int valor = JOptionPane.showConfirmDialog(null, "¿Esta seguro que quiere salir del sistema?\n Se perderan todos los avances", "CONFIRMACION DE SALIDA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, SalirConfirmar);
        
        if(valor == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void barramoviminetoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barramoviminetoMousePressed
        // TODO add your handling code here:
        Xmouse = evt.getX();
        Ymouse = evt.getY();
    }//GEN-LAST:event_barramoviminetoMousePressed

    private void barramoviminetoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barramoviminetoMouseDragged
        // TODO add your handling code here:
        int x =evt.getXOnScreen();
        int y =evt.getYOnScreen();
        this.setLocation(x-Xmouse,y- Ymouse);
    }//GEN-LAST:event_barramoviminetoMouseDragged

    private void txtFechaCitaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaCitaMousePressed
        // TODO add your handling code here:
        if(txtFechaCita.getText().equals("DIA / MES / AÑO")){
            txtFechaCita.setText("");
            txtFechaCita.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtFechaCitaMousePressed

    private void btnRegresarInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarInicioActionPerformed
        // TODO add your handling code here:

        ImageIcon Seguro = new ImageIcon("src/RecursosGraficosFondos/ConfirmarSeguro.png");

        if (!txtFechaCita.getText().equalsIgnoreCase("DIA / MES / AÑO")  || cbxHorarioAtencion.getSelectedItem() != null){
            int result = JOptionPane.showConfirmDialog(null, "Estas seguro de regresar? \nSe perderan todos los avances no guardados", "CONFIRMAR SALIDA", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,Seguro);

            if (result == JOptionPane.YES_OPTION) {
                frmPrincipal abrir = new frmPrincipal();
                abrir.setVisible(true);
                this.setVisible(false);
            }

        } else {
            frmPrincipal abrir = new frmPrincipal();
            abrir.setVisible(true);
            this.setVisible(false);
        }

    }//GEN-LAST:event_btnRegresarInicioActionPerformed

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
            java.util.logging.Logger.getLogger(frmUsuarioSeleccionarFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUsuarioSeleccionarFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUsuarioSeleccionarFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUsuarioSeleccionarFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUsuarioSeleccionarFecha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barramovimineto;
    private javax.swing.JButton btnAgendarCita;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRegresarInicio;
    private javax.swing.JButton btnSalir;
    public static javax.swing.JComboBox<String> cbxHorarioAtencion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JTextField txtFechaCita;
    // End of variables declaration//GEN-END:variables
}
