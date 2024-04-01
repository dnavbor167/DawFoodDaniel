/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package daw;

/**
 *
 * @author danielnavasborjas
 */
public enum Iva {
    IVA_ALCOHOL_REFRESCOS(0.21),
    IVA_COMIDA_POSTRES_RESTOBEBIDAS(0.1);
    
    //Creación de atributo encapsulado
    private double cantidadIva;

    //Creación de constructor
    private Iva(double cantidadIva) {
        this.cantidadIva = cantidadIva;
    }

    public double getCantidadIva() {
        return cantidadIva;
    }
    
}
