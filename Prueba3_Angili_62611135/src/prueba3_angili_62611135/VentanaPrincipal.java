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
        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Tipo:"));
        cmbTipo = new JComboBox<>(new String[]{"Administrativo", "Por horas"});
        cmbTipo.addActionListener(e -> actualizarEtiquetasCampos());
        panelFormulario.add(cmbTipo);

        panelFormulario.add(new JLabel("Salario Base:"));
        txtSalarioBase = new JTextField();
        panelFormulario.add(txtSalarioBase);

        JLabel lblAdicional1 = new JLabel("Bonificacion:");
        panelFormulario.add(lblAdicional1);
        txtAdicional1 = new JTextField();
        panelFormulario.add(txtAdicional1);

        JLabel lblAdicional2 = new JLabel("Descuento:");
        panelFormulario.add(lblAdicional2);
        txtAdicional2 = new JTextField();
        panelFormulario.add(txtAdicional2);
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        JButton btnRegistrar = new JButton("Registrar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnClonar = new JButton("Clonar empleado");
        JButton btnComparar = new JButton("Comparar");
        JButton btnMaximo = new JButton("Salario Maximo");
        JButton btnPromedio = new JButton("Promedio");
        JButton btnLimpiar = new JButton("Limpiar");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnClonar);
        panelBotones.add(btnComparar);
        panelBotones.add(btnMaximo);
        panelBotones.add(btnPromedio);
        panelBotones.add(btnLimpiar);

        JPanel panelNorteCentro = new JPanel(new BorderLayout());
        panelNorteCentro.add(panelFormulario, BorderLayout.CENTER);
        panelNorteCentro.add(panelBotones, BorderLayout.SOUTH);
        add(panelNorteCentro, BorderLayout.NORTH);

        
    }
    private void actualizarEtiquetasCampos() {
        JPanel panel = (JPanel) ((JPanel) getContentPane().getComponent(0)).getComponent(0);
        JLabel lbl1 = (JLabel) panel.getComponent(8);
        JLabel lbl2 = (JLabel) panel.getComponent(10);

        if (cmbTipo.getSelectedIndex() == 0) {
            lbl1.setText("Bonificacion :");
            lbl2.setText("Descuento:");
        } else {
            lbl1.setText("Horas Trabajadas:");
            lbl2.setText("Tarifa por Hora:");
        }
    }
}
