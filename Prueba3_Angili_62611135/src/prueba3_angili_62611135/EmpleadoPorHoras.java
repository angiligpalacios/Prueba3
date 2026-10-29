/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba3_angili_62611135;

/**
 *
 * @author ANGILI PALACIOS
 */
public class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;
    private double tarifaPorHora;
    
    public EmpleadoPorHoras(String codigo, String nombre, double salarioBase, int horasTrabajadas, double tarifaPorHora) {
        super(codigo, nombre, salarioBase);
        setHorasTrabajadas(horasTrabajadas);
        setTarifaPorHora(tarifaPorHora);
    }
    
    public int getHorasTrabajadas(){
        return horasTrabajadas;
    }
    
    public void setHorasTrabajadas(int horasTrabajadas){
        if(horasTrabajadas>=0){
            this.horasTrabajadas = horasTrabajadas; 
        }
        else{
            this.horasTrabajadas=0;
        }    
    }
    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setTarifaPorHora(double tarifaPorHora) {
        if (tarifaPorHora >= 0) {
            this.tarifaPorHora = tarifaPorHora;
        } else {
            this.tarifaPorHora = 0;
        }
    }
}
