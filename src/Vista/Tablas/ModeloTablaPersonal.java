/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Tablas;

import Modelo.Cuenta;
import Modelo.Persona;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaPersonal extends AbstractTableModel{
    private Cuenta cuentas[] =  new Cuenta[]{};

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta[] cuentas) {
        if(cuentas.length == 0) this.cuentas = new Cuenta[]{};
        else{
        Cuenta result[] = new Cuenta[Utilidades.Utilidades.ultimoElementoNoVacio(cuentas)];
        // System.out.println("Longitud de cuentas: " + result.length);
        
        for (int i = 0; i < result.length; i++) {
            // System.out.println("Elemento " + i + ": " + result[i]);
            result[i] = cuentas[i];
        }
        
        this.cuentas = result;
        }
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return cuentas == null ? 0 : cuentas.length;
    }
    
    //creacion de la tabla para la presentacion de las citas
    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0: return "Nro";
            case 1: return "Nombres";    
            case 2: return "Apellidos";    
            case 3: return "Rol";    
            default: return null;
        }
    }
    
    @Override
    public Object getValueAt(int i, int i1) {
        Persona persona = null;
        
        if(cuentas != null){
            persona = cuentas[i].getPersona();
        }
        
        switch(i1) {
            case 0: 
                return (persona != null) ? persona.getIdentificacion(): i+1;    
            case 1: 
                return (persona != null) ? persona.getNombres(): "Indefinido";    
            case 2: 
                return (persona != null) ? persona.getApellidos(): "Indefinido";    
            case 3: 
                return (persona != null) ? persona.getRol(): "Indefinido";    
            default: 
                return null;
        }
    }
}
