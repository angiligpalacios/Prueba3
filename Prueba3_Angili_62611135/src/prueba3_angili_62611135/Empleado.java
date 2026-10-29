/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba3_angili_62611135;

/**
 *
 * @author ANGILI PALACIOS
 */
public abstract class Empleado implements Cloneable{
    private String codigo;
    private String nombre;
    private double salarioBase;
    
    public Empleado(String codigo, String nombre, double salarioBase) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}
