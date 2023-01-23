/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Valoracion {

    private Float peso;
    private Float altura;
    private Float presionArterial;
    private Float presionCardiaca;
    private Float temperatura;
    
    public Valoracion(Float peso,Float altura,Float presionArterial,Float presionCardiaca,Float temperatura){
        
        this.peso = peso;
        this.altura = altura;
        this.presionArterial = presionArterial;
        this.presionCardiaca = presionCardiaca;
        this.temperatura = temperatura;
        
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Float getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(Float presionArterial) {
        this.presionArterial = presionArterial;
    }

    public Float getPresionCardiaca() {
        return presionCardiaca;
    }

    public void setPresionCardiaca(Float presionCardiaca) {
        this.presionCardiaca = presionCardiaca;
    }

    public Float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Float temperatura) {
        this.temperatura = temperatura;
    }

}
