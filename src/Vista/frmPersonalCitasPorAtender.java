/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ListaEnlazada.ListaEnlazada;
import Modelo.HistorialClinico;
import Modelo.Medicina;
import Modelo.Paciente;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static Vista.frmUsuarioSeleccionarFecha.ListaDePacientes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Victor
 */
public class frmPersonalCitasPorAtender extends javax.swing.JFrame {
    int Xmouse,Ymouse;
    
    public static ListaEnlazada contenedorAtendido = new ListaEnlazada();

    public static DefaultTableModel modelo;
    int EnviarEnFila = 0;

    /**
     * Creates new form frmPersonalCitasPorAtender
     */
    public frmPersonalCitasPorAtender() {
//        frmPersonalInventarioMedico frm = new frmPersonalInventarioMedico();
//        frm.CargarMedicamentos();
        initComponents();
        this.setLocationRelativeTo(null);
        CargarInterfazCitasAtender();
        CargarDatosCitasAtender();
        CargarMedicamentos();
        //imprimirDatos();
  
    }
    ListaEnlazada<Medicina> med = new ListaEnlazada<>();
    void CargarMedicamentos() {
        Gson gson = new Gson();

        //Leer el archivo Json
        FileReader reader;

        try {
            reader = new FileReader("ListaMedicamentos.json");
            ListaEnlazada<Medicina> listaMedicamentosCargadas = gson.fromJson(reader, new TypeToken<ListaEnlazada<Medicina>>() {
            }.getType());

            for (Medicina medicamento : listaMedicamentosCargadas) {
                med.add(medicamento);
                cbxMedicamentos.addItem(medicamento.getNombre());
                
                
               

//                if (!ExisteEnTabla(tblMedicamentos, medicamento.getNombre(), 0)) {
//                    tabla_modelo.addRow(new Object[]{medicamento.getNombre(), medicamento.getStock(), medicamento.getFechaAgregado(), medicamento.getFechaCaducidad()});
//                    tblMedicamentos.setModel(tabla_modelo);
//                } else {
//
//                }
            }
            
            //System.out.println(med.get(1));
        } catch (FileNotFoundException e) {

        }
                    


        //System.out.println(listaMedicamentosCargadas);
    }


    public void CargarInterfazCitasAtender() {
        String datos[][] = {};
        String columna[] = {"Tipo Identificacion","Cedula", "Nombres", "Apellidos", "Edad", "Genero", "Telefono", "Molestia", "Fecha", "Hora Atencion"};
        modelo = new DefaultTableModel(datos, columna);
        tblCitasSinAtender.setModel(modelo);
    }

    public void CargarDatosCitasAtender()  {
        
        Paciente a;
        
        Collections.sort(ListaDePacientes, (Paciente z, Paciente b) -> z.getDia().compareTo(b.getDia()));
        Collections.sort(ListaDePacientes, (Paciente c, Paciente d) -> c.getMes().compareTo(d.getMes()));
        Collections.sort(ListaDePacientes, (Paciente e, Paciente f) -> e.getAnio().compareTo(f.getAnio()));
        
        for (int i = ListaDePacientes.size() - 1; i >= 0; i--) {
            a = (Paciente) frmUsuarioSeleccionarFecha.ListaDePacientes.get(i);
            modelo.insertRow(EnviarEnFila, new Object[]{});
            modelo.setValueAt(a.getTipoIdentificacion(), EnviarEnFila, 0);
            modelo.setValueAt(a.getIdentificacion(), EnviarEnFila, 1);
            modelo.setValueAt(a.getNombres(), EnviarEnFila, 2);
            modelo.setValueAt(a.getApellidos(), EnviarEnFila, 3);
            modelo.setValueAt(a.getEdad(), EnviarEnFila, 4);
            modelo.setValueAt(a.getGenero(), EnviarEnFila, 5);
            modelo.setValueAt(a.getTelefono(), EnviarEnFila, 6);
            modelo.setValueAt(a.getMolestia(), EnviarEnFila, 7);
            modelo.setValueAt(a.getFechaIngreso(), EnviarEnFila, 8);
            modelo.setValueAt(a.getHoraAtencion(), EnviarEnFila, 9);
//            try {
//                System.out.println(ListaDePacientes.get(0));
//                ListaDePacientes.busquedaBinaria("Nombres", "ddd");
//            } catch (Exception ex) {
//                Logger.getLogger(frmPersonalCitasPorAtender.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
//             Medicina m;
//             m = (Medicina) frmPersonalInventarioMedico.ListaMedicamentos.get(0);
//             System.out.println(m);
    }
    
    public void imprimirDatos(){
        try {
                    System.out.println(contenedorAtendido.obtener(0));

            //frmUsuarioSeleccionarFecha.ListaDePacientes.busquedaBinaria("", "");

        } catch (Exception e) {
            System.out.println(e);
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
        tblCitasSinAtender = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtApellidoPaciente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNumeroCedula = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaMolestias = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        txtFechaIngreso = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtHoraAtencion = new javax.swing.JTextField();
        txtNumeroTelefono = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTipoId = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        btnAsignarMedicamento = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cbxMedicamentos = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtPeso2 = new javax.swing.JTextField();
        txtAltura2 = new javax.swing.JTextField();
        txtPresionArterial2 = new javax.swing.JTextField();
        txtPresionCardiaca2 = new javax.swing.JTextField();
        txtTemperatura2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CITAS POR ATENDER");
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CITAS POR ATENDER");

        tblCitasSinAtender.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCitasSinAtender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCitasSinAtenderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCitasSinAtender);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DATOS DEL PACIENTE");

        jLabel4.setText("Nombres");

        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setText("Apellidos");

        txtApellidoPaciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setText("Edad");

        txtEdad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadKeyTyped(evt);
            }
        });

        jLabel7.setText("Cedula");

        txtNumeroCedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroCedulaKeyTyped(evt);
            }
        });

        jLabel8.setText("Genero");

        txtGenero.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setText("Molestias");

        txaMolestias.setColumns(20);
        txaMolestias.setRows(5);
        jScrollPane2.setViewportView(txaMolestias);

        jLabel10.setText("Fecha de ingreso");

        txtFechaIngreso.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel11.setText("Numero Celular");

        jLabel12.setText("Hora de atencion");

        txtHoraAtencion.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtNumeroTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroTelefonoKeyTyped(evt);
            }
        });

        jLabel16.setText("Tipo identificacion");

        txtTipoId.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTipoId, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumeroTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoraAtencion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumeroCedula)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEdad)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtApellidoPaciente)
                            .addComponent(txtFechaIngreso, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGenero)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHoraAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MEDICAMENTOS");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Asignar medicamentos");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Numero");

        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroKeyPressed(evt);
            }
        });

        btnAsignarMedicamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnAsignarMedicamentoIcono.png"))); // NOI18N
        btnAsignarMedicamento.setText("ASIGNAR MEDICAMENTO");
        btnAsignarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarMedicamentoActionPerformed(evt);
            }
        });

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Botones/btnRegresarIcono.png"))); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jButton1.setText("CANCELAR CITA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAsignarMedicamento))
                    .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxMedicamentos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumero))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAsignarMedicamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar)
                .addContainerGap())
        );

        jLabel15.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel15MouseDragged(evt);
            }
        });
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });

        jPanel6.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("VALORACION");

        jLabel30.setText("Peso");

        jLabel31.setText("Altura");

        jLabel32.setText("Presion Arterial");

        jLabel33.setText("Presion cardiaca");

        jLabel34.setText("Temperatura");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTemperatura2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPeso2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAltura2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPresionArterial2)
                    .addComponent(txtPresionCardiaca2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPeso2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAltura2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPresionArterial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPresionCardiaca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTemperatura2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyTyped
        // TODO add your handling code here:
        Character c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtEdadKeyTyped

    private void txtNumeroCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroCedulaKeyTyped
        // TODO add your handling code here:
        Character c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
        if(txtNumeroCedula.getText().length()>=10){
            evt.consume();
        }
    }//GEN-LAST:event_txtNumeroCedulaKeyTyped

    private void txtNumeroTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroTelefonoKeyTyped
        // TODO add your handling code here:
        Character c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
        if(txtNumeroTelefono.getText().length()>=10){
            evt.consume();
        }
    }//GEN-LAST:event_txtNumeroTelefonoKeyTyped

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        FrmMenuDoctor abrir = new FrmMenuDoctor();
        abrir.setVisible(true);
        this.setVisible(false);
//        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAsignarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarMedicamentoActionPerformed
        // TODO add your handling code here:
        

        if(txtNumero.getText().isEmpty() || txtNumero.getText().isEmpty()||txtNumeroCedula.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "No se ha asignado un medicamento","FALTA ASIGNAR MEDICAMENTO",JOptionPane.WARNING_MESSAGE);
        }else{
            frmPersonalHistorialPacientes abrir = new frmPersonalHistorialPacientes();
            abrir.setVisible(false);

            String TipoId = txtTipoId.getText();
            String NumeroCedula = txtNumeroCedula.getText();
            String NombrePaciente = txtNombre.getText();
            String ApellidoPaciente = txtApellidoPaciente.getText();
            String EdadPaciente = txtEdad.getText();
            String GeneroPaciente = txtGenero.getText();
            String TelefonoPaciente = txtNumeroTelefono.getText();
            String MolestiaPaciente = txaMolestias.getText();
            String FechaAtencion = txtFechaIngreso.getText();
            String HoraAtencion = txtHoraAtencion.getText();
            String Medicamento = txtNumero.getText();
            String Dosis =txtNumero.getText();
            
            HistorialClinico claseauto = new HistorialClinico(TipoId,NumeroCedula, NombrePaciente, ApellidoPaciente, EdadPaciente, GeneroPaciente, TelefonoPaciente, MolestiaPaciente, FechaAtencion, HoraAtencion, Medicamento, Dosis);
            contenedorAtendido.add(claseauto);
            if (tblCitasSinAtender.getSelectedRow() != -1) {
                ListaDePacientes.remove(tblCitasSinAtender.getSelectedRow());
                modelo.removeRow(tblCitasSinAtender.getSelectedRow());
                String numero;
                    numero = med.get(cbxMedicamentos.getSelectedIndex()).getStock();
                    
                    if (Integer.valueOf(txtNumero.getText()) > Integer.valueOf(numero)  ) {
                                    JOptionPane.showMessageDialog(null, "No hay suficientes medicinas","Medicinas insuficientes",JOptionPane.WARNING_MESSAGE);
                    }else if (Integer.valueOf(txtNumero.getText()) < Integer.valueOf(numero)) {
                        Integer stock;
                        stock = Integer.valueOf(numero) - Integer.valueOf(txtNumero.getText());
                                           med.get(cbxMedicamentos.getSelectedIndex()).setStock(String.valueOf(stock));

                                  JOptionPane.showMessageDialog(null, "PACIENTE ATENDIDO EXITOSAMENTE");

                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun paciente","PACIENTE NO SELECCIONADO",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
                    //System.out.println(med.get(1));
                    

        
    }//GEN-LAST:event_btnAsignarMedicamentoActionPerformed

    private void tblCitasSinAtenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCitasSinAtenderMouseClicked
        // TODO add your handling code here:
        int seleccionar = tblCitasSinAtender.rowAtPoint(evt.getPoint());
        Paciente a;
        txtTipoId.setText(String.valueOf(tblCitasSinAtender.getValueAt(seleccionar, 0)));
        txtNumeroCedula.setText(String.valueOf(tblCitasSinAtender.getValueAt(seleccionar, 1)));
        txtNombre.setText(String.valueOf(tblCitasSinAtender.getValueAt(seleccionar, 2)));
        txtApellidoPaciente.setText(String.valueOf(tblCitasSinAtender.getValueAt(seleccionar, 3)));
        txtEdad.setText(String.valueOf(tblCitasSinAtender.getValueAt(seleccionar, 4)));
        txtGenero.setText(String.valueOf(tblCitasSinAtender.getValueAt(seleccionar, 5)));
        txtNumeroTelefono.setText(String.valueOf(tblCitasSinAtender.getValueAt(seleccionar, 6)));
        txaMolestias.setText(String.valueOf(tblCitasSinAtender.getValueAt(seleccionar, 7)));
        txtFechaIngreso.setText(String.valueOf(tblCitasSinAtender.getValueAt(seleccionar, 8)));
        txtHoraAtencion.setText(String.valueOf(tblCitasSinAtender.getValueAt(seleccionar, 9)));
        
        //Muestran los datos de valoracion
        for (int i = ListaDePacientes.size() - 1; i >= 0; i--) {
            a = (Paciente) frmUsuarioSeleccionarFecha.ListaDePacientes.get(i);
            if (a.getIdentificacion() == tblCitasSinAtender.getValueAt(seleccionar, 1)) {
                if (a.getValoracion() != null) {
                 txtAltura2.setText(String.valueOf(a.getValoracion().getAltura()));
                 txtPeso2.setText(String.valueOf(a.getValoracion().getPeso()));
                 txtPresionArterial2.setText(String.valueOf(a.getValoracion().getPresionArterial()));
                 txtPresionCardiaca2.setText(String.valueOf(a.getValoracion().getPresionCardiaca()));
                 txtTemperatura2.setText(String.valueOf(a.getValoracion().getTemperatura()));
                }else{
                  JOptionPane.showMessageDialog(null,"No se han rellenado los campos de valoracion");
                }
                 
            }
             
        }
    }//GEN-LAST:event_tblCitasSinAtenderMouseClicked

    private void txtNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_ENTER){
            btnAsignarMedicamento.requestFocus();
        }
    }//GEN-LAST:event_txtNumeroKeyPressed

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        // TODO add your handling code here:
        Xmouse = evt.getX();
        Ymouse = evt.getY();
    }//GEN-LAST:event_jLabel15MousePressed

    private void jLabel15MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseDragged
        // TODO add your handling code here:
        int x =evt.getXOnScreen();
        int y =evt.getYOnScreen();
        this.setLocation(x-Xmouse,y- Ymouse);
    }//GEN-LAST:event_jLabel15MouseDragged

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
            java.util.logging.Logger.getLogger(frmPersonalCitasPorAtender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPersonalCitasPorAtender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPersonalCitasPorAtender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPersonalCitasPorAtender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPersonalCitasPorAtender().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarMedicamento;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxMedicamentos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tblCitasSinAtender;
    public static javax.swing.JTextArea txaMolestias;
    private javax.swing.JTextField txtAltura2;
    public static javax.swing.JTextField txtApellidoPaciente;
    public static javax.swing.JTextField txtEdad;
    public static javax.swing.JTextField txtFechaIngreso;
    public static javax.swing.JTextField txtGenero;
    public static javax.swing.JTextField txtHoraAtencion;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JTextField txtNumero;
    public static javax.swing.JTextField txtNumeroCedula;
    public static javax.swing.JTextField txtNumeroTelefono;
    private javax.swing.JTextField txtPeso2;
    private javax.swing.JTextField txtPresionArterial2;
    private javax.swing.JTextField txtPresionCardiaca2;
    private javax.swing.JTextField txtTemperatura2;
    public static javax.swing.JTextField txtTipoId;
    // End of variables declaration//GEN-END:variables
}
