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
public class Receta {

    private String indicaciones;
    private String descripción;
    private ItemReceta medicinas[];

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public ItemReceta[] getMedicinas() {
        return medicinas;
    }

    public void setMedicinas(ItemReceta[] medicinas) {
        this.medicinas = medicinas;
    }

    @Override
    public String toString() {
        // Añado la descripción de la receta
        String receta = "Descripción:\n";

        receta = receta + this.descripción == null ? "Sin descripción" : this.descripción;

        // Añado una vista de las medicinas
        receta = receta + "===================================================\n";
        receta = receta + "Medicinas:\n";

        for (ItemReceta medicina : medicinas) {
            if (medicina != null) {
                receta = receta + medicina.getMedicina().getNombre() + "        ==>       " + medicina.getCantidad() + "\n";
            }
        }

        receta = receta + "===================================================\n";
        receta = receta + "Indicaciones:\n";
        receta = receta + this.indicaciones == null ? "Sin indicaciones" : this.indicaciones;

        return receta;
    }

}
