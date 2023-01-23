/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Medicina {

    private String id;
    
    private String nombre;
    private String marca;
    private String stock;
    
    private String fechaAgregado;
    private String fechaCaducidad;
    
    public Medicina(String nombre,String stock,String fechaAgregado, String fechaCaducidad){
        
        this.nombre = nombre;
        this.stock = stock;
        this.fechaAgregado = fechaAgregado;
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getFechaAgregado() {
        return fechaAgregado;
    }

    public void setFechaAgregado(String fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

//    public boolean entregarMedicina(Integer cantidad) {
//        if (this.stock == null || this.stock < cantidad) {
//            throw new Error("La cantidad de medicina no es suficiente");
//        }
//
//        // Si entrego medicina, le quito la cantidad de unidades que necesite el paciente
//        this.stock -= cantidad;
//
//        return true;
//    }

}
