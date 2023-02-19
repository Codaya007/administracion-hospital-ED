package Vista;

import static Controlador.UtilidadesFechas.validarFecha;

import Controlador.ListaEnlazada.ListaEnlazada;
import Modelo.Medicina;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author Victor
 */
public class frmPersonalInventarioMedico extends javax.swing.JFrame {

  DefaultTableModel tabla_modelo = new DefaultTableModel();
  int Xmouse, Ymouse;

  ListaEnlazada<Medicina> ListaMedicamentos = new ListaEnlazada<>();

  /**
   * Creates new form frmPersonalInventarioMedico
   */
  public frmPersonalInventarioMedico() {
    initComponents();
    this.setLocationRelativeTo(null);
    //Nombre de las columnas
    tabla_modelo.addColumn("Nombre medicamento");
    tabla_modelo.addColumn("Cantidad");
    tabla_modelo.addColumn("Fecha agregado");
    tabla_modelo.addColumn("Fecha caducidad");

    tabla_modelo.setColumnIdentifiers(
      new Object[] {
        "Nombre medicamento",
        "Cantidad",
        "Fecha agregado",
        "Fecha caducidad",
      }
    );

    CargarMedicamentos();
  }

  private void CargarMedicamentos() {
    Gson gson = new Gson();

    //Leer el archivo Json
    FileReader reader;

    try {
      reader = new FileReader("ListaMedicamentos.json");
      ListaEnlazada<Medicina> listaMedicamentosCargadas = gson.fromJson(
        reader,
        new TypeToken<ListaEnlazada<Medicina>>() {}.getType()
      );

      for (Medicina medicamento : listaMedicamentosCargadas) {
        if (!ExisteEnTabla(tblMedicamentos, medicamento.getNombre(), 0)) {
          tabla_modelo.addRow(
            new Object[] {
              medicamento.getNombre(),
              medicamento.getStock(),
              medicamento.getFechaAgregado(),
              medicamento.getFechaCaducidad(),
            }
          );
          tblMedicamentos.setModel(tabla_modelo);
        } else {}
      }
    } catch (FileNotFoundException e) {}
  }

  public boolean ExisteEnTabla(JTable tabla, String dto, int col) {
    boolean Existe = false;

    String nuevoValor = txtCantidadMedicamento.getText();
    String FechaActualizada = txtFechaCaducidad.getText();

    for (int i = 0; i < tabla.getRowCount(); i++) {
      if (tabla.getValueAt(i, col).equals(dto)) {
        tabla.setValueAt(nuevoValor, i, 1);
        tabla.setValueAt(FechaActualizada, i, 3);

        Existe = true;
      }
    }
    return Existe;
  }

  //Metodo para eliminar todos los datos de la tabla
  private void VaciarI() {
    int cantidadfilas = tblMedicamentos.getRowCount();

    ImageIcon advertencia = new ImageIcon(
      "src/RecursosGraficos/JoptionPane/warning.png"
    );
    int valor = JOptionPane.showConfirmDialog(
      null,
      "¿Esta seguro de vaciar el inventario ?\n Todos los datos seran borrados",
      "PANEL DE CONFIRMACION",
      JOptionPane.YES_NO_OPTION,
      JOptionPane.WARNING_MESSAGE,
      advertencia
    );

    //Condicion si la respuesta fue si se ejecuta el for
    if (valor == JOptionPane.YES_OPTION) {
      //El for va a ir disminuyendo hasta que ya no quede nada
      for (int i = cantidadfilas - 1; i >= 0; i--) {
        tabla_modelo.removeRow(i);
      }
    }
  }

  //Metodo para eliminar la fila de la tabla de inventario
  private void Eliminar() throws IOException {
    int filaselecionada = tblMedicamentos.getSelectedRow();
    if (filaselecionada >= 0) {
      tabla_modelo.removeRow(filaselecionada);

      Gson gson = new Gson();

      //Leer el archivo Json
      FileReader reader;

      try {
        reader = new FileReader("ListaMedicamentos.json");
        ListaEnlazada<Medicina> listaMedicamentosCargadas = gson.fromJson(
          reader,
          new TypeToken<ListaEnlazada<Medicina>>() {}.getType()
        );

        int posicionAEliminar = tblMedicamentos.getSelectedRowCount();

        listaMedicamentosCargadas.remove(posicionAEliminar);

        FileWriter writer;
        try {
          writer = new FileWriter("ListaMedicamentos.json");
          gson.toJson(listaMedicamentosCargadas, writer);
          writer.close();
        } catch (IOException ex) {
          Logger
            .getLogger(frmPersonalInventarioMedico.class.getName())
            .log(Level.SEVERE, null, ex);
        }
      } catch (FileNotFoundException ex) {
        Logger
          .getLogger(frmPersonalInventarioMedico.class.getName())
          .log(Level.SEVERE, null, ex);
      }
    } else {
      JOptionPane.showMessageDialog(
        null,
        "Seleccione el medicamento a eliminar",
        "Seleccione una fila",
        JOptionPane.ERROR_MESSAGE
      );
    }
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jPanel1 = new javax.swing.JPanel();
    jPanel2 = new javax.swing.JPanel();
    jLabel4 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    btnRegresar = new javax.swing.JButton();
    btnAgregarMedicamento = new javax.swing.JButton();
    jScrollPane2 = new javax.swing.JScrollPane();
    tblMedicamentos = new javax.swing.JTable();
    btnVerificarMedicamento = new javax.swing.JButton();
    jLabel5 = new javax.swing.JLabel();
    txtNombreMedicamento = new javax.swing.JTextField();
    txtCantidadMedicamento = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    txtFechaCaducidad = new javax.swing.JTextField();
    btnGuardarMedicamentos = new javax.swing.JButton();
    btnEliminar = new javax.swing.JButton();
    btnSalir = new javax.swing.JButton();

    jTable1.setModel(
      new javax.swing.table.DefaultTableModel(
        new Object[][] {
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
          { null, null, null, null },
        },
        new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }
      )
    );
    jScrollPane1.setViewportView(jTable1);

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("INVENTARIO");
    setUndecorated(true);

    jPanel1.setBackground(new java.awt.Color(20, 66, 114));

    jPanel2.setBackground(new java.awt.Color(32, 82, 149));

    jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel4.setIcon(
      new javax.swing.ImageIcon(
        getClass().getResource("/RecursosGraficos/Fondos/IconoMedicamento.png")
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
              jLabel4,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              223,
              Short.MAX_VALUE
            )
            .addContainerGap()
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
              jLabel4,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              215,
              Short.MAX_VALUE
            )
            .addContainerGap()
        )
    );

    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("INVENTARIO");

    jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(255, 255, 255));
    jLabel2.setText("Medicamentos");

    jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setText("Cantidad");

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

    btnAgregarMedicamento.setIcon(
      new javax.swing.ImageIcon(
        getClass()
          .getResource(
            "/RecursosGraficos/Botones/btnAgregarMedicamentoIcono.png"
          )
      )
    ); // NOI18N
    btnAgregarMedicamento.setText("AGREGAR");
    btnAgregarMedicamento.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          btnAgregarMedicamentoActionPerformed(evt);
        }
      }
    );

    tblMedicamentos.setModel(
      new javax.swing.table.DefaultTableModel(
        new Object[][] {},
        new String[] {}
      )
    );
    jScrollPane2.setViewportView(tblMedicamentos);

    btnVerificarMedicamento.setIcon(
      new javax.swing.ImageIcon(
        getClass()
          .getResource(
            "/RecursosGraficos/Botones/btnMostrarInventarioIcono.png"
          )
      )
    ); // NOI18N
    btnVerificarMedicamento.setText("VER MEDICAMENTO DISPONIBLE");
    btnVerificarMedicamento.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          btnVerificarMedicamentoActionPerformed(evt);
        }
      }
    );

    jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel5.addMouseMotionListener(
      new java.awt.event.MouseMotionAdapter() {
        public void mouseDragged(java.awt.event.MouseEvent evt) {
          jLabel5MouseDragged(evt);
        }
      }
    );
    jLabel5.addMouseListener(
      new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
          jLabel5MousePressed(evt);
        }
      }
    );

    txtNombreMedicamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txtNombreMedicamento.addKeyListener(
      new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
          txtNombreMedicamentoKeyTyped(evt);
        }
      }
    );

    txtCantidadMedicamento.setHorizontalAlignment(
      javax.swing.JTextField.CENTER
    );
    txtCantidadMedicamento.addKeyListener(
      new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
          txtCantidadMedicamentoKeyTyped(evt);
        }
      }
    );

    jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(255, 255, 255));
    jLabel6.setText("Fecha caducidad");

    btnVaciar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    btnVaciar.setIcon(
      new javax.swing.ImageIcon(
        getClass().getResource("/RecursosGraficos/Botones/vaciar.png")
      )
    ); // NOI18N
    btnVaciar.setText("VACIAR");
    btnVaciar.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          btnVaciarActionPerformed(evt);
        }
      }
    );

    txtFechaCaducidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txtFechaCaducidad.addKeyListener(
      new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
          txtFechaCaducidadKeyTyped(evt);
        }
      }
    );

    btnGuardarMedicamentos.setIcon(
      new javax.swing.ImageIcon(
        getClass()
          .getResource(
            "/RecursosGraficos/Botones/btnGuardarInformacionIcono.png"
          )
      )
    ); // NOI18N
    btnGuardarMedicamentos.setText("GUARDAR");
    btnGuardarMedicamentos.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          btnGuardarMedicamentosActionPerformed(evt);
        }
      }
    );

    btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    btnEliminar.setIcon(
      new javax.swing.ImageIcon(
        getClass().getResource("/RecursosGraficos/Botones/btn remove.png")
      )
    ); // NOI18N
    btnEliminar.setText("ELIMINAR");
    btnEliminar.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          btnEliminarActionPerformed(evt);
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

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
      jPanel1
    );
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(
          jLabel5,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          Short.MAX_VALUE
        )
        .addGroup(
          jPanel1Layout
            .createSequentialGroup()
            .addGap(7, 7, 7)
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                  jPanel1Layout
                    .createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(
                      jPanel2,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED
                    )
                    .addGroup(
                      jPanel1Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.LEADING
                        )
                        .addComponent(
                          jLabel1,
                          javax.swing.GroupLayout.Alignment.TRAILING,
                          javax.swing.GroupLayout.DEFAULT_SIZE,
                          492,
                          Short.MAX_VALUE
                        )
                        .addGroup(
                          jPanel1Layout
                            .createSequentialGroup()
                            .addGroup(
                              jPanel1Layout
                                .createParallelGroup(
                                  javax.swing.GroupLayout.Alignment.TRAILING,
                                  false
                                )
                                .addComponent(
                                  txtNombreMedicamento,
                                  javax.swing.GroupLayout.Alignment.LEADING
                                )
                                .addComponent(
                                  jLabel3,
                                  javax.swing.GroupLayout.Alignment.LEADING,
                                  javax.swing.GroupLayout.DEFAULT_SIZE,
                                  javax.swing.GroupLayout.DEFAULT_SIZE,
                                  Short.MAX_VALUE
                                )
                                .addComponent(
                                  txtCantidadMedicamento,
                                  javax.swing.GroupLayout.Alignment.LEADING
                                )
                                .addComponent(
                                  txtFechaCaducidad,
                                  javax.swing.GroupLayout.Alignment.LEADING
                                )
                                .addComponent(
                                  jLabel6,
                                  javax.swing.GroupLayout.Alignment.LEADING,
                                  javax.swing.GroupLayout.DEFAULT_SIZE,
                                  324,
                                  Short.MAX_VALUE
                                )
                                .addComponent(
                                  jLabel2,
                                  javax.swing.GroupLayout.DEFAULT_SIZE,
                                  javax.swing.GroupLayout.DEFAULT_SIZE,
                                  Short.MAX_VALUE
                                )
                            )
                            .addGap(0, 0, Short.MAX_VALUE)
                        )
                    )
                )
                .addGroup(
                  jPanel1Layout
                    .createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(btnSalir)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED
                    )
                    .addComponent(btnRegresar)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                    )
                    .addComponent(btnAgregarMedicamento)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      Short.MAX_VALUE
                    )
                    .addComponent(btnVaciar)
                )
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
            )
            .addGroup(
              jPanel1Layout
                .createParallelGroup(
                  javax.swing.GroupLayout.Alignment.LEADING,
                  false
                )
                .addGroup(
                  jPanel1Layout
                    .createSequentialGroup()
                    .addComponent(btnEliminar)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                    )
                    .addComponent(btnGuardarMedicamentos)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED
                    )
                    .addComponent(btnVerificarMedicamento)
                )
                .addComponent(jScrollPane2)
            )
            .addGap(13, 13, 13)
        )
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          jPanel1Layout
            .createSequentialGroup()
            .addComponent(
              jLabel5,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              14,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                  jPanel1Layout
                    .createSequentialGroup()
                    .addGroup(
                      jPanel1Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.LEADING,
                          false
                        )
                        .addGroup(
                          jPanel1Layout
                            .createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(
                              jPanel2,
                              javax.swing.GroupLayout.PREFERRED_SIZE,
                              javax.swing.GroupLayout.DEFAULT_SIZE,
                              javax.swing.GroupLayout.PREFERRED_SIZE
                            )
                        )
                        .addComponent(
                          jScrollPane2,
                          javax.swing.GroupLayout.PREFERRED_SIZE,
                          0,
                          Short.MAX_VALUE
                        )
                    )
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                    )
                    .addGroup(
                      jPanel1Layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.BASELINE
                        )
                        .addComponent(btnGuardarMedicamentos)
                        .addComponent(btnVerificarMedicamento)
                        .addComponent(btnVaciar)
                        .addComponent(btnEliminar)
                        .addComponent(btnRegresar)
                        .addComponent(btnAgregarMedicamento)
                        .addComponent(btnSalir)
                    )
                )
                .addGroup(
                  jPanel1Layout
                    .createSequentialGroup()
                    .addComponent(jLabel1)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                    )
                    .addComponent(jLabel2)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                    )
                    .addComponent(
                      txtNombreMedicamento,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                    )
                    .addComponent(jLabel3)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                    )
                    .addComponent(
                      txtCantidadMedicamento,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                    )
                    .addComponent(jLabel6)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                    )
                    .addComponent(
                      txtFechaCaducidad,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                )
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
            )
            .addGroup(
              jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                  jPanel1Layout
                    .createParallelGroup(
                      javax.swing.GroupLayout.Alignment.BASELINE
                    )
                    .addComponent(btnGuardarMedicamentos)
                    .addComponent(btnVerificarMedicamento)
                    .addComponent(btnAgregarMedicamento)
                )
                .addComponent(
                  btnEliminar,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  38,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(btnRegresar)
            )
            .addContainerGap(12, Short.MAX_VALUE)
        )
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
      getContentPane()
    );
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addComponent(
              jPanel1,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(0, 0, Short.MAX_VALUE)
        )
    );
    layout.setVerticalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(
          jPanel1,
          javax.swing.GroupLayout.PREFERRED_SIZE,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          javax.swing.GroupLayout.PREFERRED_SIZE
        )
    );

    pack();
  } // </editor-fold>//GEN-END:initComponents

  // Boton para regresar a la ventana anterior
  private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnRegresarActionPerformed
    // Condicion si alguno de los campos no esta vacio
    //Se mostrara la siguiente advertencia
    if (
      !txtNombreMedicamento.getText().isEmpty() ||
      !txtCantidadMedicamento.getText().isEmpty() ||
      !txtFechaCaducidad.getText().isEmpty()
    ) {
      int result = JOptionPane.showConfirmDialog(
        null,
        "Estas seguro de regresar? \nSe perderan todos los avances no guardados",
        "CONFIRMAR SALIDA",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.INFORMATION_MESSAGE
      );
      if (result == JOptionPane.YES_OPTION) {
        FrmMenuSuperAdmin abrir = new FrmMenuSuperAdmin();
        abrir.setVisible(true);
        this.setVisible(false);
      }
    } else {
      FrmMenuSuperAdmin abrir = new FrmMenuSuperAdmin();
      abrir.setVisible(true);
      this.setVisible(false);
    }
  } //GEN-LAST:event_btnRegresarActionPerformed

  private void btnAgregarMedicamentoActionPerformed(
    java.awt.event.ActionEvent evt
  ) { //GEN-FIRST:event_btnAgregarMedicamentoActionPerformed
    //Formato de fecha
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    //Variables
    String fechaActual = formatoFecha.format(new Date());
    String NombreMedicina = txtNombreMedicamento.getText();
    String CantidadMedicina = txtCantidadMedicamento.getText();
    String FechaCaducidad = txtFechaCaducidad.getText();

    //Condiciones si los datos estan vacios
    if (txtNombreMedicamento.getText().isEmpty()) {
      JOptionPane.showMessageDialog(
        null,
        "Ingrese un medicamento, el campo esta vacio",
        "MEDICAMENTO VACIO",
        JOptionPane.ERROR_MESSAGE
      );
    } else if (txtCantidadMedicamento.getText().isEmpty()) {
      JOptionPane.showMessageDialog(
        null,
        "Ingrese la cantidad, el campo esta vacio",
        "CANTIDAD VACIO",
        JOptionPane.ERROR_MESSAGE
      );
    } else if (txtFechaCaducidad.getText().isEmpty()) {
      JOptionPane.showMessageDialog(
        null,
        "Por favor ingrese la fecha",
        "NO EXISTE FECHA",
        JOptionPane.WARNING_MESSAGE
      );
    } else if (
      ExisteEnTabla(tblMedicamentos, NombreMedicina, 0) == true
    ) {} else {
      boolean resultado = true;
      String fecha1 = txtFechaCaducidad.getText();
      resultado = validarFecha(fecha1);

      //Validar el formato de fecha
      if (
        txtFechaCaducidad.getText().matches("^\\d{1,2}/\\d{1,2}/\\d{4}$")
      ) {} else {
        JOptionPane.showMessageDialog(
          null,
          "La fecha tiene que contener 2 / en formato dia/mes/año",
          "FECHA SIN FORMATO0",
          JOptionPane.WARNING_MESSAGE
        );
      }
      if (resultado == true) {
        ListaMedicamentos.add(
          new Medicina(
            NombreMedicina,
            CantidadMedicina,
            fechaActual,
            FechaCaducidad
          )
        );

        JOptionPane.showMessageDialog(
          null,
          "El medicamento se ha agregado",
          "MEDICAMENTO AGREGADO",
          JOptionPane.INFORMATION_MESSAGE
        );

        tabla_modelo.addRow(
          new Object[] {
            NombreMedicina,
            CantidadMedicina,
            fechaActual,
            FechaCaducidad,
          }
        );

        tblMedicamentos.setModel(tabla_modelo);
      } else {
        JOptionPane.showMessageDialog(
          null,
          "El formato de la fecha esta mal,tiene que tener limites\n de dias 30 o 31 y mes maximo 12 ,Por favor revisar",
          "FORMATO DE FECHA MAL ESTABLECIDO",
          JOptionPane.WARNING_MESSAGE
        );
      }
    }
  } //GEN-LAST:event_btnAgregarMedicamentoActionPerformed

  //Lee el archivo Json y trae los datos hacia la tabla
  private void btnVerificarMedicamentoActionPerformed(
    java.awt.event.ActionEvent evt
  ) { //GEN-FIRST:event_btnVerificarMedicamentoActionPerformed
    if (tblMedicamentos.getRowCount() >= 0) {
      Gson gson = new Gson();

      //Leer el archivo Json
      FileReader reader;

      try {
        reader = new FileReader("ListaMedicamentos.json");
        ListaEnlazada<Medicina> listaMedicamentosCargadas = gson.fromJson(
          reader,
          new TypeToken<ListaEnlazada<Medicina>>() {}.getType()
        );

        for (Medicina medicamento : listaMedicamentosCargadas) {
          if (!ExisteEnTabla(tblMedicamentos, medicamento.getNombre(), 0)) {
            tabla_modelo.addRow(
              new Object[] {
                medicamento.getNombre(),
                medicamento.getStock(),
                medicamento.getFechaAgregado(),
                medicamento.getFechaCaducidad(),
              }
            );
            tblMedicamentos.setModel(tabla_modelo);
          } else {}
        }
      } catch (FileNotFoundException e) {}
    } else {}
  } //GEN-LAST:event_btnVerificarMedicamentoActionPerformed

  private void jLabel5MousePressed(java.awt.event.MouseEvent evt) { //GEN-FIRST:event_jLabel5MousePressed
    // TODO add your handling code here:
    Xmouse = evt.getX();
    Ymouse = evt.getY();
  } //GEN-LAST:event_jLabel5MousePressed

  private void jLabel5MouseDragged(java.awt.event.MouseEvent evt) { //GEN-FIRST:event_jLabel5MouseDragged
    // TODO add your handling code here:
    int x = evt.getXOnScreen();
    int y = evt.getYOnScreen();
    this.setLocation(x - Xmouse, y - Ymouse);
  } //GEN-LAST:event_jLabel5MouseDragged

  private void txtNombreMedicamentoKeyTyped(java.awt.event.KeyEvent evt) { //GEN-FIRST:event_txtNombreMedicamentoKeyTyped
    //Limitaciones para el campo de texto Medicamento
    int key = evt.getKeyChar();

    boolean mayusculas = key >= 65 && key <= 90;
    boolean minusculas = key >= 97 && key <= 122;
    boolean espacio = key == 32;

    if (!(minusculas || mayusculas || espacio)) {
      evt.consume();
    }

    if (txtNombreMedicamento.getText().length() >= 30) {
      evt.consume();
    }
  } //GEN-LAST:event_txtNombreMedicamentoKeyTyped

  private void txtCantidadMedicamentoKeyTyped(java.awt.event.KeyEvent evt) { //GEN-FIRST:event_txtCantidadMedicamentoKeyTyped
    //Limitaciones para evitar que el usuario ingrese letras ademas establecer la cantidad limite
    Character c = evt.getKeyChar();

    if (!Character.isDigit(c)) {
      evt.consume();
    }
    if (txtCantidadMedicamento.getText().length() >= 10000000) {
      evt.consume();
    }
  } //GEN-LAST:event_txtCantidadMedicamentoKeyTyped

  private void txtFechaCaducidadKeyTyped(java.awt.event.KeyEvent evt) { //GEN-FIRST:event_txtFechaCaducidadKeyTyped
    //Limitaciones para evitar que el usuario ingrese letras
    int key = evt.getKeyChar();
    boolean slash = key == 47;

    Character c = evt.getKeyChar();

    if (!(Character.isDigit(c) || slash)) {
      evt.consume();
    }
    if (txtFechaCaducidad.getText().length() >= 10) {
      evt.consume();
    }
  } //GEN-LAST:event_txtFechaCaducidadKeyTyped

  private void btnGuardarMedicamentosActionPerformed(
    java.awt.event.ActionEvent evt
  ) { //GEN-FIRST:event_btnGuardarMedicamentosActionPerformed
    //Formato de fecha
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    String fechaActual = formatoFecha.format(new Date());
    //Traer los datos de los textFIeld
    String NombreMedicina = txtNombreMedicamento.getText();
    String CantidadMedicina = txtCantidadMedicamento.getText();
    String FechaCaducidad = txtFechaCaducidad.getText();

    Gson gson = new Gson();

    try {
      //Condiciones si los datos estan vacios
      if (txtNombreMedicamento.getText().isEmpty()) {
        JOptionPane.showMessageDialog(
          null,
          "Ingrese un medicamento, el campo esta vacio",
          "MEDICAMENTO VACIO",
          JOptionPane.ERROR_MESSAGE
        );
      } else if (txtCantidadMedicamento.getText().isEmpty()) {
        JOptionPane.showMessageDialog(
          null,
          "Ingrese la cantidad, el campo esta vacio",
          "CANTIDAD VACIO",
          JOptionPane.ERROR_MESSAGE
        );
      } else if (txtFechaCaducidad.getText().isEmpty()) {
        JOptionPane.showMessageDialog(
          null,
          "Por favor ingrese la fecha",
          "NO EXISTE FECHA",
          JOptionPane.WARNING_MESSAGE
        );
      } //Si la condicion no se cumple crear archivo Json
      else {
        //Nombre archivo
        File jsonFile = new File("ListaMedicamentos.json");

        //Si el archivo ya exite entonces que se realize la condicion de lectura
        if (jsonFile.exists()) {
          FileReader reader = new FileReader("ListaMedicamentos.json");
          Medicina[] dataArray = gson.fromJson(reader, Medicina[].class);
          ListaMedicamentos = new ListaEnlazada<>();

          for (Medicina data : dataArray) {
            ListaMedicamentos.add(data);
          }
        } else {
          ListaMedicamentos = new ListaEnlazada<>();
        }

        Medicina nuevoMedicamento = new Medicina(
          NombreMedicina,
          CantidadMedicina,
          fechaActual,
          FechaCaducidad
        );

        boolean nombreExiste = false;
        int indice = -1;

        for (int i = 0; i < ListaMedicamentos.size(); i++) {
          if (
            ListaMedicamentos
              .get(i)
              .getNombre()
              .equals(nuevoMedicamento.getNombre())
          ) {
            nombreExiste = true;
            indice = i;
            break;
          }
        }

        if (nombreExiste) {
          ListaMedicamentos.get(indice).setStock(nuevoMedicamento.getStock());
          ListaMedicamentos
            .get(indice)
            .setFechaAgregado(nuevoMedicamento.getFechaAgregado());
          ListaMedicamentos
            .get(indice)
            .setFechaCaducidad(nuevoMedicamento.getFechaCaducidad());
        } else {
          ListaMedicamentos.add(nuevoMedicamento);
        }

        //Agregar datos al archivo Json
        FileWriter writer = new FileWriter("ListaMedicamentos.json");
        //Agrega la listaMedicamento dentro del Json y lo escribe
        gson.toJson(ListaMedicamentos, writer);
        //Cierro
        writer.close();
      }
      //Catch si es que ocurre algun error
    } catch (IOException ex) {
      Logger
        .getLogger(frmPersonalInventarioMedico.class.getName())
        .log(Level.SEVERE, null, ex);
    }
  } //GEN-LAST:event_btnGuardarMedicamentosActionPerformed

  private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnEliminarActionPerformed
    try {
      Eliminar();
    } catch (IOException ex) {
      Logger
        .getLogger(frmPersonalInventarioMedico.class.getName())
        .log(Level.SEVERE, null, ex);
    }
  } //GEN-LAST:event_btnEliminarActionPerformed

  private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnSalirActionPerformed
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
  } //GEN-LAST:event_btnSalirActionPerformed

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
        .getLogger(frmPersonalInventarioMedico.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger
        .getLogger(frmPersonalInventarioMedico.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger
        .getLogger(frmPersonalInventarioMedico.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger
        .getLogger(frmPersonalInventarioMedico.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          new frmPersonalInventarioMedico().setVisible(true);
        }
      }
    );
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAgregarMedicamento;
  private javax.swing.JButton btnEliminar;
  private javax.swing.JButton btnGuardarMedicamentos;
  private javax.swing.JButton btnRegresar;
  private javax.swing.JButton btnSalir;
  private javax.swing.JButton btnVaciar;
  private javax.swing.JButton btnVerificarMedicamento;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTable jTable1;
  private javax.swing.JTable tblMedicamentos;
  private javax.swing.JTextField txtCantidadMedicamento;
  private javax.swing.JTextField txtFechaCaducidad;
  private javax.swing.JTextField txtNombreMedicamento;
  // End of variables declaration//GEN-END:variables
}
