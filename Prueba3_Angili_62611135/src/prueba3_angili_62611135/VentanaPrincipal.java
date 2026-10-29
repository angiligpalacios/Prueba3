/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba3_angili_62611135;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
/**
 *
 * @author ANGILI PALACIOS
 */
public class VentanaPrincipal extends JFrame {
  private ArrayList<Empleado> listaEmpleados;
    private DefaultTableModel modeloTabla;
    private JTable tablaEmpleados;

    private JTextField txtCodigo, txtNombre, txtSalarioBase, txtAdicional1, txtAdicional2;
    private JComboBox<String> cmbTipo;  
    
    private Scanner angi;
    public VentanaPrincipal() {
       
        listaEmpleados = new ArrayList<>();
        angi = new Scanner(System.in);

        setTitle("Gestion de empleados");
        setSize(950, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        
        JPanel panelFormulario = new JPanel(new GridLayout(4, 4, 10, 10));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del empleado"));

        panelFormulario.add(new JLabel("Codigo: "));
        txtCodigo = new JTextField();
        panelFormulario.add(txtCodigo);
    }
}
