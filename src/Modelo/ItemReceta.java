/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author vivic
 */
public class ItemReceta {

    private Medicina medicina;
    private Integer cantidad = 1;

    public Medicina getMedicina() {
        return medicina;
    }

    public void setMedicina(Medicina medicina) {
        this.medicina = medicina;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
