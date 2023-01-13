/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Vista.frmUsuarioSeleccionarFecha;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Victor
 */
public class UtilidadesFechas extends frmUsuarioSeleccionarFecha{
    
    //validacion de facha en formato dd/mm/aaaa
    public static boolean validarFecha(String fecha) {
        
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
        
    }
    
//    public String Fechas() throws ParseException{
//        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
//        String FechaSelecionada = txtFechaCita.getText();
//        Date FechaFinal = formatoFecha.parse(FechaSelecionada);
//        System.out.print("La fecha actual es "+ Fechas());
//        return FechaFinal.toString();
//
//    }
//    public static Date fechaActual = new Date();
//    
//    private static  SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
//    
//    public static void main(String[] args) {
//        
//        try {
//            //        System.out.print("La fecha actual es "+ formatoFecha.format(fechaActual));
//            System.out.print("La fecha actual es "+ Fechas());
//        } catch (ParseException ex) {
//            Logger.getLogger(UtilidadesFechas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
