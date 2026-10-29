/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba3_angili_62611135;

/**
 *
 * @author ANGILI PALACIOS
 */
public class EmpleadoAdministrativo extends Empleado {
    private double bonificacion;
    private double descuento;
    
    public EmpleadoAdministrativo(String codigo, String nombre, double salarioBase, double bonificacion, double descuento) {
        super(codigo, nombre, salarioBase);
        
    }
    public double getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(double bonificacion) {
        if (bonificacion >= 0) {
            this.bonificacion = bonificacion;
        } else {
            this.bonificacion = 0;
        }
    }
}
