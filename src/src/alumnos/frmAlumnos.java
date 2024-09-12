package alumnos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmAlumnos extends JFrame {
    private JTextField txtNombre;
    private JTextField txtApPaterno;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JCheckBox CBDiscapacidad;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JTextField txtApMaterno;
    private JTextField txtCURP;
    private JPanel pnlPrincipal;
    private JComboBox cmbSexo;
    private BotonGuardarListener botonGuardarListener;

    public frmAlumnos() {
        setTitle("Alumnos");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(pnlPrincipal);
        pack();

        poblarComboBox();
        setLocationRelativeTo(null);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarDatos();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Borrar();
            }
        });

    }
    public void setBotonGuardarListener(BotonGuardarListener listener) {
        this.botonGuardarListener = listener;
    }
    private void enviarDatos(){
        String nombre = txtNombre.getText();
        String apPaterno = txtApPaterno.getText();
        String apMaterno = txtApMaterno.getText();
        String CURP = txtCURP.getText();
        String sexo = cmbSexo.getSelectedItem().toString();
        String correo = txtCorreo.getText();
        String telefono = txtTelefono.getText();
        Boolean discapacidad = CBDiscapacidad.isSelected();
        Alumno dato = new Alumno(nombre,apPaterno,apMaterno,CURP,sexo, telefono,correo,discapacidad);

        if(botonGuardarListener != null){
            botonGuardarListener.guardando(dato);
        }
        Borrar();
    }

    private void Borrar(){
        txtNombre.setText("");
        txtApPaterno.setText("");
        txtApMaterno.setText("");
        txtCURP.setText("");
        cmbSexo.setSelectedIndex(0);
        txtCorreo.setText("");
        txtTelefono.setText("");
        CBDiscapacidad.setSelected(false);
    }

    private void poblarComboBox(){
        DefaultComboBoxModel  <Genero>comboBoxModel = (DefaultComboBoxModel<Genero>) cmbSexo.getModel();
       for(Genero genero : Genero.values()){
            comboBoxModel.addElement(genero);
        }
    }
}
