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
    private Integer stock;
    private String fechaCaducidad;

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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public boolean entregarMedicina(Integer cantidad) {
        if (this.stock == null || this.stock < cantidad) {
            throw new Error("La cantidad de medicina no es suficiente");
        }

        // Si entrego medicina, le quito la cantidad de unidades que necesite el paciente
        this.stock -= cantidad;

        return true;
    }

}
