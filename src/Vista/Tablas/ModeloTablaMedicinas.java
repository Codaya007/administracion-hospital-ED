/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Tablas;

import Modelo.Medicina;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaMedicinas extends AbstractTableModel{
    private Medicina medicinas[] =  new Medicina[]{};

    public Medicina[] getMedicinas() {
        return medicinas;
    }

    public void setMedicinas(Medicina[] medicinas) {
        if(medicinas.length == 0) this.medicinas = new Medicina[]{};
        else{
            Integer lastIndex = Utilidades.Utilidades.ultimoElementoNoVacio(medicinas);
            
        Medicina result[] = new Medicina[lastIndex == null ? medicinas.length : lastIndex];
        
        
        for (int i = 0; i < result.length; i++) {
            //System.out.println("Elemento " + i + ": " + result[i]);
            result[i] = medicinas[i];
        }
        
        this.medicinas = result;
        }
    }
    
    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public int getRowCount() {
        return medicinas == null ? 0 : medicinas.length;
    }
    
    //creacion de la tabla para la presentacion de las citas
    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0: return "Nro";
            case 1: return "Nombre";    
            case 2: return "Marca";    
            case 3: return "Stock";    
            case 4: return "Fecha registro";    
            default: return null;
        }
    }
    
    @Override
    public Object getValueAt(int i, int i1) {
        Medicina esp = null;
        
        if(medicinas != null){
            esp = medicinas[i];
        }
        
        //System.out.println("Medicina: " + esp);
        
        switch(i1) {
            case 0: 
                return  i+1;    
            case 1: 
                return (esp != null) ? esp.getNombre(): "INDEFINIDO";    
            case 2: 
                return (esp != null) ? esp.getMarca(): "INDEFINIDO";
            case 3: 
                return (esp != null) ? esp.getStock(): "INDEFINIDO";
            case 4: 
                return (esp != null) ? esp.getFechaAgregado(): "INDEFINIDO";
            default: 
                return null;
        }
    }
}
