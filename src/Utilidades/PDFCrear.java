package Utilidades;

import Controlador.ListaEnlazada.ListaEnlazada;
import Modelo.HistorialClinico;
import Modelo.Medicina;
import Modelo.Paciente;
import static Vista.frmUsuarioSeleccionarFecha.ListaDePacientes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**/
public class PDFCrear {
/**
 * Metodo que sirve para crear un pdf de las citas por atender
 * 
 */
    public boolean crearPdfCitas() {
        boolean aviso = false;
        PDFCrear pdf = new PDFCrear();
        ListaEnlazada<Paciente> pas = new ListaEnlazada<>();

        pdf.CargarPacientesCitas(pas);
        // Crear un nuevo documento PDF
        Document documento = new Document(PageSize.A4.rotate());
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("CitasAtender.pdf"));

            // Abrir el documento
            documento.open();

            // Crear una tabla con 3 columnas
            PdfPTable tabla = new PdfPTable(6);

            // Crear encabezado
            Paragraph title = new Paragraph();
            Chunk titleChunk = new Chunk("SISTEMA GESTION DE HOSPITAL", FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLD));
            title.add(titleChunk);
            Paragraph title1 = new Paragraph("CITAS POR ATENDER");
            title.setAlignment(Element.ALIGN_CENTER);
            title1.setAlignment(Element.ALIGN_CENTER);
            documento.add(title);
            documento.add(title1);
            Chunk space = new Chunk("\n");
            documento.add(space);

            // Agregar encabezados de tabla
            tabla.addCell("NOMBRE");
            tabla.addCell("APELLIDO");
            tabla.addCell("EDAD");
            tabla.addCell("IDENTIFICACION");
            tabla.addCell("FECHACITA");
            tabla.addCell("HORACITA");

            // Añadir los elementos de la lista enlazada a la tabla
            for (Paciente persona : pas) {
                tabla.addCell(persona.getNombres());
                tabla.addCell(persona.getApellidos());
                tabla.addCell(String.valueOf(persona.getEdad()));
                tabla.addCell(persona.getIdentificacion());
                tabla.addCell(persona.getFechaIngreso());
                tabla.addCell(persona.getHoraAtencion());
            }

            // Añadir la tabla al documento
            documento.add(tabla);

            // Cerrar el documento
            documento.close();
            aviso = true;
            //System.out.println("PDF generado exitosamente888!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aviso;
    }
/**
 * Metodo para crear un reporte en pdf del historial de pacientes
 * 
 * @return retorna el aviso que me sirve para ver si el documento ha sido creado
 */
    public boolean crearPdfHistorialPaciente() {
        boolean aviso = false;
        ListaEnlazada<HistorialClinico> pasA = new ListaEnlazada<>();
        PDFCrear pdf = new PDFCrear();

        pdf.CargarPacientesCitasAtendidas(pasA);
        // Crear un nuevo documento PDF
        Document documento = new Document(PageSize.A4.rotate());
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("HistorialPaciente.pdf"));

            // Abrir el documento
            documento.open();

            // Crear una tabla con 3 columnas
            PdfPTable tabla = new PdfPTable(6);

            // Crear Encabezado
            Paragraph title = new Paragraph();
            Chunk titleChunk = new Chunk("SISTEMA GESTION DE HOSPITAL", FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLD));
            title.add(titleChunk);
            Paragraph title1 = new Paragraph("HISTORIAL PACIENTES");
            title.setAlignment(Element.ALIGN_CENTER);
            title1.setAlignment(Element.ALIGN_CENTER);
            documento.add(title);
            documento.add(title1);
            Chunk space = new Chunk("\n");
            documento.add(space);

            // Agregar encabezados de tabla
            tabla.addCell("NOMBRE");
            tabla.addCell("APELLIDO");
            tabla.addCell("EDAD");
            tabla.addCell("IDENTIFICACION");
            tabla.addCell("FECHACITA");
            tabla.addCell("HORACITA");

            // Añadir los elementos de la lista enlazada a la tabla
            for (HistorialClinico persona : pasA) {
                tabla.addCell(persona.getNombresA());
                tabla.addCell(persona.getApellidosA());
                tabla.addCell(String.valueOf(persona.getEdadA()));
                tabla.addCell(persona.getIdentificacionA());
                tabla.addCell(persona.getFechaIngresoA());
                tabla.addCell(persona.getHoraAtencionA());
            }

            // Añadir la tabla al documento
            documento.add(tabla);

            // Cerrar el documento
            documento.close();

            aviso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aviso;
    }
/**
 * Permite guardar los datos de un json en una lista 
 * @param pas permite ingresar una lista, la cual va a tener los datos del json
 */
    public void CargarPacientesCitas(ListaEnlazada<Paciente> pas) {

        Gson gson = new Gson();

        //Leer el archivo Json
        FileReader reader;

        try {
            reader = new FileReader("ListaPacientes.json");
            ListaEnlazada<Paciente> listaPacienteCargada = gson.fromJson(reader, new TypeToken<ListaEnlazada<Paciente>>() {
            }.getType());
            Integer i = 0;
            for (Paciente paciente : listaPacienteCargada) {
                pas.add(paciente);
                pas.setSize(i);
                i++;

            }

            //System.out.println(pas);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    void CargarPacientesCitasAtendidas(ListaEnlazada<HistorialClinico> pasA) {

        Gson gson = new Gson();

        //Leer el archivo Json
        FileReader reader;

        try {
            reader = new FileReader("HistorialPacientes.json");
            ListaEnlazada<HistorialClinico> listaRegistroCargadas = gson.fromJson(reader, new TypeToken<ListaEnlazada<HistorialClinico>>() {
            }.getType());

            for (HistorialClinico historialClinico : listaRegistroCargadas) {
                pasA.add(historialClinico);
            }
        } catch (FileNotFoundException e) {

        }
    }
/**
 * 
 * @param cedula parametro para buscar un paciente 
 * @return avisa si el documento se crea
 * @throws DocumentException Exepcion por si se genera un error al crear el documento
 */
    public boolean ImprimirBuscado(String cedula) throws DocumentException {
        boolean aviso = false;
        PDFCrear pdf = new PDFCrear();
        ListaEnlazada<Paciente> pas = new ListaEnlazada<>();
        pdf.CargarPacientesCitas(pas);
        Document documento = new Document(PageSize.A4.rotate());

        try {
            try {
                PdfWriter.getInstance(documento, new FileOutputStream("PacienteBuscado.pdf"));

            } catch (FileNotFoundException ex) {
                Logger.getLogger(PDFCrear.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (DocumentException ex) {
            Logger.getLogger(PDFCrear.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Abrir el documento
        documento.open();

        // Crear una tabla con 7 columnas
        PdfPTable tabla = new PdfPTable(7);

        // Crear Encabezado
        Paragraph title = new Paragraph();
        Chunk titleChunk = new Chunk("SISTEMA GESTION DE HOSPITAL", FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLD));
        title.add(titleChunk);
        Paragraph title1 = new Paragraph("HISTORIAL CLINICO DE PACIENTE");
        title.setAlignment(Element.ALIGN_CENTER);
        title1.setAlignment(Element.ALIGN_CENTER);
        documento.add(title);
        documento.add(title1);
        Chunk space = new Chunk("\n");
        documento.add(space);

        // Agregar encabezados de tabla
        tabla.addCell("NOMBRE");
        tabla.addCell("APELLIDO");
        tabla.addCell("EDAD");
        tabla.addCell("IDENTIFICACION");
        tabla.addCell("FECHACITA");
        tabla.addCell("HORACITA");
        tabla.addCell("MOLESTIA");

        for (int i = 0; i <= pas.getSize(); i++) {

            if (pas.get(i).getIdentificacion().equals(cedula)) {

                try {

                    // Añadir los elementos de la lista enlazada a la tabla
                    tabla.addCell(pas.get(i).getNombres());
                    tabla.addCell(pas.get(i).getApellidos());
                    tabla.addCell(pas.get(i).getEdad());
                    tabla.addCell(pas.get(i).getIdentificacion());
                    tabla.addCell(pas.get(i).getFechaIngreso());
                    tabla.addCell(pas.get(i).getHoraAtencion());
                    tabla.addCell(pas.get(i).getMolestia());

                    // Añadir la tabla al documento
                    documento.add(tabla);

                    // Cerrar el documento
                    documento.close();

                    //System.out.println("PDF generado exitosamente888!");
                    aviso = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        return aviso;
    }
/**
 * 
 * @param paciente ingresa los datos del paciente a registrar
 * @param pas lista con los datos a escribir 
 * @throws FileNotFoundException para advertir de un archivo que no ha sido encontrado
 * @throws IOException por si no puede escribir dentro del json
 */
    public void guardarDatos(Paciente paciente, ListaEnlazada<Paciente> pas) throws FileNotFoundException, IOException {
        Gson gson = new Gson();
        File jsonFile = new File("ListaPacientes.json");

        if (jsonFile.exists()) {
            FileReader reader = new FileReader("ListaPacientes.json");
            Paciente[] dataArray = gson.fromJson(reader, Paciente[].class);
            ListaDePacientes = new ListaEnlazada<>();

            for (Paciente data : dataArray) {
                ListaDePacientes.add(data);
            }
        } else {
            ListaDePacientes = new ListaEnlazada<>();

        }
        boolean nombreExiste = false;
        int indice = -1;

        for (int i = 0; i < ListaDePacientes.size(); i++) {
            if (ListaDePacientes.get(i).getIdentificacion().equals(paciente.getIdentificacion())) {
                nombreExiste = true;
                indice = i;
                break;
            }
        }

        if (nombreExiste) {
            ListaDePacientes.get(indice).setNombres(paciente.getNombres());

        } else {
            ListaDePacientes.add(paciente);
        }

        FileWriter writer = new FileWriter("ListaPacientes.json");
        //Agrega la listaMedicamento dentro del Json y lo escribe 
        gson.toJson(ListaDePacientes, writer);
        //Cierro
        writer.close();

    }
/**
 * Guarda los datos correspondiente a un paciente
 * @param paciente nuevo a registra
 * @param pas lista con los datos a escribir
 * @param identificacion para buscar 
 * @throws FileNotFoundException
 * @throws IOException 
 */
    public void guardarDatosPa(Paciente paciente, ListaEnlazada<Paciente> pas, String identificacion) throws FileNotFoundException, IOException {
        Gson gson = new Gson();
        File jsonFile = new File("ListaPacientes.json");

        if (jsonFile.exists()) {
            FileReader reader = new FileReader("ListaPacientes.json");
            Paciente[] dataArray = gson.fromJson(reader, Paciente[].class);
            pas = new ListaEnlazada<>();

            for (Paciente data : dataArray) {
                pas.add(data);
            }
        } else {
            pas = new ListaEnlazada<>();

        }
        boolean nombreExiste = false;
        int indice = -1;

        for (int i = 0; i < pas.size(); i++) {
            if (pas.get(i).getIdentificacion().equals(paciente.getIdentificacion())) {
                        pas.set(i, paciente);
                        nombreExiste = true;
                        indice = i;
                        break;
                    

            }
        }

        if (nombreExiste) {
            pas.get(indice).setNombres(paciente.getNombres());

        } else {
            pas.add(paciente);
        }
        FileWriter writer = new FileWriter("ListaPacientes.json");
        //Agrega la listaMedicamento dentro del Json y lo escribe 
        gson.toJson(pas, writer);
        //Cierro
        writer.close();

    }
}
