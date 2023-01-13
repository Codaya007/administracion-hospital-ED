/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Arrays;

/**
 *
 * @author Victor
 */
public class Rol {

    private Integer id;
    private String nombre;
    private String descripcion;
    private static final String[] ROLES_PERMITIDOS = new String[]{
        "Medico",
        "Enfermera",
        "Paciente"
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(Controlador.Utilidades.contains(ROLES_PERMITIDOS, nombre)){
            throw new Error("Los roles permitidos son: " + Arrays.toString(ROLES_PERMITIDOS));
        }
        
        this.nombre = nombre;
    }

}
