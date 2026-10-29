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
        modeloTabla = new DefaultTableModel(new String[]{"Código", "Nombre", "Tipo", "Salario Calculado", "Categoría"}, 0);
        tablaEmpleados = new JTable(modeloTabla);
        add(new JScrollPane(tablaEmpleados), BorderLayout.CENTER);

       
        btnRegistrar.addActionListener(e -> registrarEmpleado());
        btnBuscar.addActionListener(e -> buscarEmpleado());
        btnClonar.addActionListener(e -> clonarEmpleado());
        btnComparar.addActionListener(e -> compararEmpleados());
        btnMaximo.addActionListener(e -> mostrarSalarioMaximo());
        btnPromedio.addActionListener(e -> mostrarPromedioSalarial());
        btnLimpiar.addActionListener(e -> limpiarFormulario());

        actualizarEtiquetasCampos();
        
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
    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        for (Empleado emp : listaEmpleados) {
            String tipoStr = (emp instanceof EmpleadoAdministrativo) ? "Administrativo" : "Por horas";
            modeloTabla.addRow(new Object[]{
                emp.getCodigo(),
                emp.getNombre(),
                tipoStr,
                String.format("%.2f", emp.calcularSalario()),
                emp.obtenerCategoria()
            });
        }
    }
    private void buscarEmpleado() {
        String codigo = JOptionPane.showInputDialog(this, "Ingrese el codigo del empleado a buscar:");
        if (codigo != null && !codigo.trim().isEmpty()) {
            for (Empleado emp : listaEmpleados) {
                if (emp.getCodigo().equalsIgnoreCase(codigo.trim())) {
                    JOptionPane.showMessageDialog(this, emp.mostrarInformacion() + "\nSalario Calculado: " + emp.calcularSalario(), "Empleado Encontrado", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "No se encontro ningún empleado con ese codigo.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void registrarEmpleado() {
        try {
            String codigo = txtCodigo.getText().trim();
            String nombre = txtNombre.getText().trim();

            if (codigo.isEmpty() || nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Los campos de codigo y nombre no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (Empleado emp : listaEmpleados) {
                if (emp.getCodigo().equalsIgnoreCase(codigo)) {
                    JOptionPane.showMessageDialog(this, "Ya existe un empleado con el codigo ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            double salarioBase = Double.parseDouble(txtSalarioBase.getText().trim());
            double val1 = Double.parseDouble(txtAdicional1.getText().trim());
            double val2 = Double.parseDouble(txtAdicional2.getText().trim());

            Empleado nuevoEmpleado;
            if (cmbTipo.getSelectedIndex() == 0) {
                nuevoEmpleado = new EmpleadoAdministrativo(codigo, nombre, salarioBase, val1, val2);
            } else {
                nuevoEmpleado = new EmpleadoPorHoras(codigo, nombre, salarioBase, (int) val1, val2);
            }

            listaEmpleados.add(nuevoEmpleado);
            actualizarTabla();
            limpiarFormulario();
            JOptionPane.showMessageDialog(this, "Empleado registrado exitosamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor verifique que los valores numéricos sean validos.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void limpiarFormulario() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtSalarioBase.setText("");
        txtAdicional1.setText("");
        txtAdicional2.setText("");
        txtCodigo.requestFocus();
    }
    private void clonarEmpleado() {
        int filaSeleccionada = tablaEmpleados.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un empleado de la tabla para clonar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Empleado original = listaEmpleados.get(filaSeleccionada);
        Empleado clon = original.clone();

        String nuevoCodigo = JOptionPane.showInputDialog(this, "Ingrese un nuevo código único para el clon:", original.getCodigo() + "-CLON");
        if (nuevoCodigo == null || nuevoCodigo.trim().isEmpty()) return;

        for (Empleado emp : listaEmpleados) {
            if (emp.getCodigo().equalsIgnoreCase(nuevoCodigo.trim())) {
                JOptionPane.showMessageDialog(this, "El código ya existe. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        clon.setCodigo(nuevoCodigo.trim());
        listaEmpleados.add(clon);
        actualizarTabla();
        JOptionPane.showMessageDialog(this, "Empleado clonado y registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    private void compararEmpleados() {
        if (listaEmpleados.size() < 2) {
            JOptionPane.showMessageDialog(this, "Debe haber al menos dos empleados registrados para comparar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String codigo1 = JOptionPane.showInputDialog(this, "Ingrese el codigo del primer empleado:");
        String codigo2 = JOptionPane.showInputDialog(this, "Ingrese el codigo del segundo empleado:");

        Empleado e1 = null, e2 = null;
        for (Empleado emp : listaEmpleados) {
            if (emp.getCodigo().equalsIgnoreCase(codigo1)) e1 = emp;
            if (emp.getCodigo().equalsIgnoreCase(codigo2)) e2 = emp;
        }

        if (e1 == null || e2 == null) {
            JOptionPane.showMessageDialog(this, "Uno o ambos codigos no fueron encontrados.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean mismaReferencia = (e1 == e2);
        boolean mismosAtributos = e1.getNombre().equalsIgnoreCase(e2.getNombre()) && 
                                  e1.getSalarioBase() == e2.getSalarioBase() && 
                                  e1.calcularSalario() == e2.calcularSalario();

        String resultado = "Comparación de Objetos:\n" +
                           "- Misma referencia (==): " + mismaReferencia + "\n" +
                           "- Equivalencia de datos principales: " + mismosAtributos;

        JOptionPane.showMessageDialog(this, resultado, "Resultado de Comparación", JOptionPane.INFORMATION_MESSAGE);
    }
    private void mostrarSalarioMaximo() {
        if (listaEmpleados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay empleados registrados.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Empleado maxEmp = listaEmpleados.get(0);
        for (Empleado emp : listaEmpleados) {
            if (emp.calcularSalario() > maxEmp.calcularSalario()) {
                maxEmp = emp;
            }
        }

        JOptionPane.showMessageDialog(this, "Empleado con mayor salario:\n" + maxEmp.mostrarInformacion() + 
                "\nSalario: " + String.format("%.2f", maxEmp.calcularSalario()), "Salario Máximo", JOptionPane.INFORMATION_MESSAGE);
    }
    private void mostrarPromedioSalarial() {
        if (listaEmpleados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay empleados registrados.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double suma = 0;
        for (Empleado emp : listaEmpleados) {
            suma += emp.calcularSalario();
        }
        double promedio = suma / listaEmpleados.size();

        JOptionPane.showMessageDialog(this, "Salario promedio general: " + String.format("%.2f", promedio), "Promedio Salarial", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
