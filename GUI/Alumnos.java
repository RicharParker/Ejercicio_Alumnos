/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Exceptions.ApellidoException;
import Exceptions.CalificacionException;
import Exceptions.CarreraException;
import Exceptions.VacioException;
import Exceptions.NumeroException;
import Exceptions.RepetidoException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Model.Alumno;
import Model.Carrera;
/**
 *
 * @author ARCHV
 */
public class Alumnos extends JDialog {

    private final String[] COMBO = {"", "SISTEMAS", "NUTRICION", "ARQUITECTURA", "CIVIL", "CONTADURIA"};

    private Edit edtNumero;
    private Edit edtNombre;
    private Edit edtPaterno;
    private Edit edtMaterno;
    private EditCalificacion edtCalificacion;

    private JLabel lblCarrera;
    private JComboBox cbCarrera;
    private JPanel pnlCarrera;

    private JButton btnAceptar;
    private JButton btnCancelar;
    private JPanel pnlBoton;

    private Listener listener;

    public Alumnos(JFrame parent) {
        super(parent, true);
        super.setSize(450, 600);
        super.setLayout(new GridLayout(7, 1));
        super.setLocationRelativeTo(parent);

        edtNumero = new Edit("No. Control: ");
        edtNombre = new Edit("Nombre: ");
        edtPaterno = new Edit("Apellido parterno: ");
        edtMaterno = new Edit("Apellido Materno: ");
        edtCalificacion = new EditCalificacion("Calificacion: ");

        cbCarrera = new JComboBox(COMBO);
        lblCarrera = new JLabel("Carrera: ");
        pnlCarrera = new JPanel();
        pnlCarrera.add(lblCarrera);
        pnlCarrera.add(cbCarrera);

        pnlBoton = new JPanel();
        pnlBoton.setLayout(new FlowLayout());
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Alumno al = new Alumno(edtNumero.getValue(),
                            edtNombre.getValue(),
                            edtPaterno.getValue(),
                            edtMaterno.getValue(),
                            edtCalificacion.getValue(),
                            setCarrera(cbCarrera.getSelectedIndex()));
                    listener.aceptarClick(al);
                   
                } catch ( NumeroException | VacioException | ApellidoException | CalificacionException | CarreraException | RepetidoException ex) {
                    JOptionPane.showMessageDialog(Alumnos.this,
                            ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } 
            }
        });
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Alumnos.this.setVisible(false);
                limpiar();
            }
        });
        pnlBoton.add(btnAceptar);
        pnlBoton.add(btnCancelar);

        super.add(edtNumero);
        super.add(edtNombre);
        super.add(edtPaterno);
        super.add(edtMaterno);
        super.add(edtCalificacion);
        super.add(pnlCarrera);
        super.add(pnlBoton);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    private Carrera setCarrera(Integer i) {
        switch (i) {
            case 0:
                return null;
            case 1:
                return Carrera.SISTEMAS;
            case 2:
                return Carrera.NUTRICION;
            case 3:
                return Carrera.ARQUITECTURA;
            case 4:
                return Carrera.CIVIL;
            case 5:
                return Carrera.CONTADURIA;
            default:
                return null;
        }
    }

    private void limpiar() {
        edtNumero.clear();
        edtNombre.clear();
        edtPaterno.clear();
        edtMaterno.clear();
        edtCalificacion.clear();
        cbCarrera.setSelectedIndex(0);
    }
    
}



