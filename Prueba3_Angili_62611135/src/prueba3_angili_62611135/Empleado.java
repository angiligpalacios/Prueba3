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
        setSalarioBase(salarioBase);
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.trim().isEmpty()) {
            this.codigo = codigo;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase >= 0) {
            this.salarioBase = salarioBase;
        } else {
            this.salarioBase = 0;
        }
    }

    public abstract double calcularSalario();

    public String obtenerCategoria() {
        double salario = calcularSalario();
        if (salario < 1000) {
            return "Básico";
        } else if (salario <= 2000) {
            return "Estándar";
        } else {
            return "Superior";
        }
    }   
    public String mostrarInformacion() {
        return "Código: " + codigo + "Nombre: " + nombre + "Salario Base: " + salarioBase;
    }
    @Override
    public Empleado clone() {
        try {
            return (Empleado) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar el empleado", e);
        }
    }
}
