package Utilidades;

import Controlador.ListaEnlazada.ListaEnlazada;
import Modelo.HistorialClinico;
import Modelo.Medicina;
import Modelo.Paciente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDFCrear {

    public void crearPdfCitas() {
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

            // Agregar encabezados de tabla
            tabla.addCell("Nombre");
            tabla.addCell("Apellido");
            tabla.addCell("Edad");
            tabla.addCell("Identificacion");
            tabla.addCell("FechaCita");
            tabla.addCell("HoraCita");

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

            System.out.println("PDF generado exitosamente888!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void crearPdfCitasAtendidas() {

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

            // Agregar encabezados de tabla
            tabla.addCell("Nombre");
            tabla.addCell("Apellido");
            tabla.addCell("Edad");
            tabla.addCell("Identificacion");
            tabla.addCell("FechaCita");
            tabla.addCell("HoraCita");

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

            System.out.println("PDF generado exitosamente888!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void CargarPacientesCitas(ListaEnlazada<Paciente> pas) {

        Gson gson = new Gson();

        //Leer el archivo Json
        FileReader reader;

        try {
            reader = new FileReader("ListaPacientes.json");
            ListaEnlazada<Paciente> listaPacienteCargada = gson.fromJson(reader, new TypeToken<ListaEnlazada<Paciente>>() {
            }.getType());
            Integer i= 0;
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

    public void ImprimirBuscado(String cedula) {
                PDFCrear pdf = new PDFCrear();
        ListaEnlazada<Paciente> pas = new ListaEnlazada<>();
        pdf.CargarPacientesCitas(pas);
        Document documento = new Document(PageSize.A4.rotate());
        System.out.println(pas.getSize());
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

        // Crear una tabla con 3 columnas
        PdfPTable tabla = new PdfPTable(6);

        // Agregar encabezados de tabla
        tabla.addCell("Nombre");
        tabla.addCell("Apellido");
        tabla.addCell("Edad");
        tabla.addCell("Identificacion");
        tabla.addCell("FechaCita");
        tabla.addCell("HoraCita");
System.out.println(pas);


        for (int i = 0; i <= pas.getSize(); i++) {
            System.out.println(pas.getSize());
            if (pas.get(i).getIdentificacion().equals(cedula)) {

                try {

                    // Añadir los elementos de la lista enlazada a la tabla

                        tabla.addCell(pas.get(i).getNombres());
                        tabla.addCell(pas.get(i).getApellidos());
                        tabla.addCell(pas.get(i).getEdad());
                        tabla.addCell(pas.get(i).getIdentificacion());
                        tabla.addCell(pas.get(i).getFechaIngreso());
                        tabla.addCell(pas.get(i).getHoraAtencion());
                    

                    // Añadir la tabla al documento
                    documento.add(tabla);

                    // Cerrar el documento
                    documento.close();

                    System.out.println("PDF generado exitosamente888!");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
