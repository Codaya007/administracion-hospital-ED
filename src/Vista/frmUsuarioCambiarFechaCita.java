/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import static Controlador.UtilidadesFechas.validarFecha;
import Modelo.Paciente;
import Modelo.Persona;
import static Vista.frmUsuarioSeleccionarFecha.EnviarContenido;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Victor
 */
public class frmUsuarioCambiarFechaCita extends javax.swing.JFrame {
    int Xmouse,Ymouse;

    /**
     * Creates new form frmUsuarioCambiarFechaCita
     */
    public frmUsuarioCambiarFechaCita() {
        initComponents();
        this.setLocationRelativeTo(null);
        btnConsultar.requestFocus();
        btnConsultar.setToolTipText("Consulta si tiene una cita");
    }
    
    public boolean ExisteEnTabla(JTable tabla, String dto, int col) {
        
        boolean Existe = false;
        
        for (int i = 0; i < tabla.getRowCount(); i++) {
            if (tabla.getValueAt(i, col).equals(dto)) {
                Existe = true;  
                String CedulaConsulta = frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 0).toString();
                String NombrePaciente = frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 1).toString();
                String ApellidoPaciente = frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 2).toString();
                String EdadConsultar = frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 3).toString();
                String GeneroConsultar = frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 4).toString();
                String TelefonoConsultar = frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 5).toString();
                String MolestiaConsultar = frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 6).toString();
                String FechaCita = frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 7).toString();
                String HoraCita = frmPersonalCitasPorAtender.tblCitasSinAtender.getValueAt(i, 8).toString();
                
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNumeroCedula = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtFechaCita = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnCambiarFecha = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbxHorarioA = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDatosPaciente = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(20, 66, 114));

        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CAMBIAR FECHA DE CITA");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Fondos/IconoReagendarPanel.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingresar numero de cedula");

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
        txtNumeroCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroCedulaKeyTyped(evt);
            }
        });

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnCitaConsultarIcono.png"))); // NOI18N
        btnConsultar.setText(" CONSULTAR");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnRegresarIcono.png"))); // NOI18N
        jButton1.setText("REGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnSalirIcono.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(20, 66, 114));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CAMBIAR FECHA");

        txtFechaCita.setForeground(java.awt.Color.gray);
        txtFechaCita.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaCita.setText("dd/mm/aaaa");
        txtFechaCita.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFechaCitaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaCitaFocusLost(evt);
            }
        });
        txtFechaCita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaCitaKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ingresar fecha para reagendar");

        btnCambiarFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnCambiarFechaIcono.png"))); // NOI18N
        btnCambiarFecha.setText("CAMBIAR");
        btnCambiarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarFechaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Seleccionar horario");

        cbxHorarioA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "13:00 - 14:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00" }));
        cbxHorarioA.setSelectedItem(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFechaCita)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCambiarFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxHorarioA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxHorarioA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCambiarFecha)
                .addContainerGap())
        );

        txaDatosPaciente.setColumns(20);
        txaDatosPaciente.setRows(5);
        jScrollPane1.setViewportView(txaDatosPaciente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSalir)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNumeroCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(btnSalir)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumeroCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsultar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
        Xmouse = evt.getX();
        Ymouse = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        // TODO add your handling code here:
        int x =evt.getXOnScreen();
        int y =evt.getYOnScreen();
        this.setLocation(x-Xmouse,y- Ymouse);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void txtNumeroCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroCedulaKeyTyped
        // TODO add your handling code here:
        Character c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }if(txtNumeroCedula.getText().length()>=10){
            evt.consume();
        }
    }//GEN-LAST:event_txtNumeroCedulaKeyTyped

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        frmUsuarioSelecionarUso abrir = new frmUsuarioSelecionarUso();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        ImageIcon SalirConfirmar = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneSalirIcono.png");
        
        int valor = JOptionPane.showConfirmDialog(null, "¿Esta seguro que quiere salir del sistema?\n Se perderan todos los avances", "CONFIRMACION DE SALIDA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, SalirConfirmar);
        if(valor == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        txaDatosPaciente.setText("");
        
        ImageIcon CedulaInvalidaIcono = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneCedulaInvalidaIcono.png");
        ImageIcon SinRegistroIcono = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneSinRegistroIcono.png");
        ImageIcon SinCita = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneSinCitaIcono.png");
        ImageIcon NumeroMenor = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneNumeroIgualIcono.png");
        ImageIcon ErrorCedula = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneErrorCampoIcono.png");
        
        String cedula = txtNumeroCedula.getText();
        frmPersonalCitasPorAtender abrir = new frmPersonalCitasPorAtender();
        abrir.setVisible(false);
        
        if(txtNumeroCedula.getText().isEmpty() || txtNumeroCedula.getText().equalsIgnoreCase("Ingreso solo numeros")){
            JOptionPane.showMessageDialog(null, "Ingrese el numero de cedula","NUMERO DE CEDULA VACIO",JOptionPane.ERROR_MESSAGE,CedulaInvalidaIcono);
        }
        else if(cedula.length() < 10) {
            JOptionPane.showMessageDialog(null, "La cedula tiene menos de 10 digitos", "CEDULA MAL ESTABLECIDA", JOptionPane.ERROR_MESSAGE,NumeroMenor);
        }
        else if(!txtNumeroCedula.getText().matches("11\\d{8}")){
            JOptionPane.showMessageDialog(null, "El numero de cedula tiene que iniciar con 11","CEDULA NO VALIDO",JOptionPane.ERROR_MESSAGE,ErrorCedula);
        }
        else if(Vista.frmPersonalCitasPorAtender.tblCitasSinAtender.getRowCount() <= 0){
            JOptionPane.showMessageDialog(null, "No hay registros de citas, primero tiene que agendar una cita","NO HAY REGISTROS",JOptionPane.ERROR_MESSAGE,SinRegistroIcono);
        }
        else if(ExisteEnTabla(Vista.frmPersonalCitasPorAtender.tblCitasSinAtender, cedula, 0)== true){ 
            
        }
        else{
            JOptionPane.showMessageDialog(null, "No cuenta con una cita disponible \n Registre una cita","NO CUENTA CON CITA",JOptionPane.INFORMATION_MESSAGE,SinCita);
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnCambiarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarFechaActionPerformed
        // TODO add your handling code here:
        ImageIcon CedulaInvalidaIcono = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneCedulaInvalidaIcono.png");
        ImageIcon SinCita = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneSinCitaIcono.png");
        ImageIcon NumeroMenor = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneNumeroIgualIcono.png");
        ImageIcon CitaEliminada = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneCitaEliminadaIcono.png");
        ImageIcon SinRegistroIcono = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneSinRegistroIcono.png");
        ImageIcon ErrorCedula = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneErrorCampoIcono.png");
        ImageIcon FechaVacia = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneFechaVaciaIcono.png");
        ImageIcon HorarioVacio = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneHorarioVacioIcono.png");
        ImageIcon FechaPasada = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneFechaPasadaIcono.png");
        ImageIcon HorarioNoDisponible = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneHorarioLLenoIcono.png");
        ImageIcon MuyLejana = new ImageIcon("src/RecursosGraficos/JoptionPane/JoptionPaneFechaLejanaIcono.png");


        try {
            String cedula = txtNumeroCedula.getText();
//        EnviarContenido.removeIf(x -> x.getIdentificacion().equals(cedula));

            if (cedula.isEmpty() || txtNumeroCedula.getText().equalsIgnoreCase("Ingreso solo numeros")) {
                JOptionPane.showMessageDialog(null, "Ingrese el numero de cedula", "NUMERO DE CEDULA VACIO", JOptionPane.ERROR_MESSAGE, CedulaInvalidaIcono);
            } 
            else if (cedula.length() < 10) {
                JOptionPane.showMessageDialog(null, "La cedula tiene menos de 10 digitos", "CEDULA MAL ESTABLECIDA", JOptionPane.ERROR_MESSAGE, NumeroMenor);
            } 
            else if (!txtNumeroCedula.getText().matches("11\\d{8}")) {
                JOptionPane.showMessageDialog(null, "El numero de cedula tiene que iniciar con 11", "CEDULA NO VALIDO", JOptionPane.ERROR_MESSAGE, ErrorCedula);
            } 
            else if (txtFechaCita.getText().isEmpty() || txtFechaCita.getText().equalsIgnoreCase("dd/mm/aaaa")) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese la fecha", "CAMPO VACIOS", JOptionPane.WARNING_MESSAGE, FechaVacia);
            } 
            else if (cbxHorarioA.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese el horario", "CAMPO VACIOS", JOptionPane.WARNING_MESSAGE, HorarioVacio);
            } 
            else if (Vista.frmPersonalCitasPorAtender.tblCitasSinAtender.getRowCount() <= 0) {
                JOptionPane.showMessageDialog(null, "No hay registros de citas, primero tiene que agendar una cita", "NO HAY REGISTROS", JOptionPane.ERROR_MESSAGE, SinRegistroIcono);
            } 
            
            else {
                if (ExisteEnTabla(Vista.frmPersonalCitasPorAtender.tblCitasSinAtender, cedula, 0) == true) {
                    boolean resultado = true;
                    String FechaSeleccionada = txtFechaCita.getText();
                    resultado = validarFecha(FechaSeleccionada);
                    String CbxHoraAtencion = cbxHorarioA.getSelectedItem().toString();

                    SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar calendario = GregorianCalendar.getInstance();
                    Date fechaHoy = calendario.getTime();
                    String Fe = txtFechaCita.getText();
                    Date fechaSeleccionada = formatoDeFecha.parse(Fe);
                    Date fechaLimite = formatoDeFecha.parse("30/12/2040");

                    boolean exist = EnviarContenido.stream().anyMatch(p -> p.getFechaIngreso().equals(Fe) && p.getHoraAtencion().equals(CbxHoraAtencion));

                    if (txtFechaCita.getText().matches("^\\d{1,2}/\\d{1,2}/\\d{4}$")) {
                        
                    } 
                    else {
                        JOptionPane.showMessageDialog(null, "La fecha tiene que contener 2 / en formato dia/mes/año", "FECHA SIN FORMATO0", JOptionPane.WARNING_MESSAGE, MuyLejana);
                    }
                    if (resultado == true) {

                        if (fechaSeleccionada.before(fechaHoy)) {
                            JOptionPane.showMessageDialog(null, "La fecha seleccionada ya ha pasado", "FECHA PASADO", JOptionPane.INFORMATION_MESSAGE, FechaPasada);
                        } 
                        else if (fechaSeleccionada.after(fechaLimite)) {
                            JOptionPane.showMessageDialog(null, "La fecha seleccionada es muy lejana", "FECHA DEMASIADO LEJANA", JOptionPane.INFORMATION_MESSAGE, MuyLejana);
                        } 
                        else {
                            if (exist) {
                                JOptionPane.showMessageDialog(null, "La hora de atencion ya no esta disponible", "NO DISPONIBLE", JOptionPane.INFORMATION_MESSAGE, HorarioNoDisponible);
                            } 
                            else {
                                for (Paciente objeto : EnviarContenido) {
                                    if (objeto.getIdentificacion().equals(txtNumeroCedula.getText())) {
                                        objeto.setFechaIngreso(txtFechaCita.getText());
                                        objeto.setHoraAtencion(cbxHorarioA.getSelectedItem().toString());
                                        JOptionPane.showMessageDialog(null, "La cita se ha cambiado para el dia " + txtFechaCita.getText() + "\n con el horario de " + cbxHorarioA.getSelectedItem().toString(), "CITA REAGENDADA", JOptionPane.INFORMATION_MESSAGE, CitaEliminada);
                                    }
                                }
                            }
                        }
                    } 
                    else {
                        JOptionPane.showMessageDialog(null, "El formato de la fecha esta mal,tiene que tener limites\n de dias 30 o 31 y mes maximo 12 ,Por favor revisar", "FORMATO DE FECHA MAL ESTABLECIDO", JOptionPane.WARNING_MESSAGE, MuyLejana);
                    }
                } 
                else {
                    JOptionPane.showMessageDialog(null, "No cuenta con una cita disponible \n Registre una cita", "NO CUENTA CON CITA", JOptionPane.INFORMATION_MESSAGE, SinCita);
                }
            }
        }
        catch (Exception e) {

        }
    }//GEN-LAST:event_btnCambiarFechaActionPerformed

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

    private void txtFechaCitaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaCitaFocusGained
        // TODO add your handling code here:
        if (txtFechaCita.getText().equals("dd/mm/aaaa")) {
            txtFechaCita.setText("");
            txtFechaCita.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtFechaCitaFocusGained

    private void txtFechaCitaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaCitaFocusLost
        // TODO add your handling code here:
        if (txtFechaCita.getText().isEmpty()) {
            txtFechaCita.setText("dd/mm/aaaa");
            txtFechaCita.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtFechaCitaFocusLost

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
            java.util.logging.Logger.getLogger(frmUsuarioCambiarFechaCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUsuarioCambiarFechaCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUsuarioCambiarFechaCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUsuarioCambiarFechaCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUsuarioCambiarFechaCita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarFecha;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxHorarioA;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaDatosPaciente;
    private javax.swing.JTextField txtFechaCita;
    public static javax.swing.JTextField txtNumeroCedula;
    // End of variables declaration//GEN-END:variables
}
