/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.Controller;
import Exceptions.AlumnoException;
import Exceptions.ArchivoException;
import Exceptions.CargarException;
import Exceptions.GuardarException;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.SwingUtilities;
import Model.Alumno;
/**
 *
 * @author ARCHV
 */
public class PrincipalFrame extends JFrame {

    private PanelBusqueda pnlBusqueda;
    private JTable tblAlumnos;
    private Controller controlador;
    private Alumnos dlgAlumno;
    private AcercaDeDialog dlgAcerca;
    private EliminarAlumno dlgEliminar;

    private TablaAlumnos modelAlumno;

    public PrincipalFrame () {
        super("Control Escolar");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(700, 250);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);

        try {
            controlador = new Controller();
        } catch (ArchivoException ex) {
            JOptionPane.showMessageDialog(PrincipalFrame.this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (CargarException ex) {
            JOptionPane.showMessageDialog(PrincipalFrame.this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        modelAlumno = new TablaAlumnos(controlador);
        tblAlumnos = new JTable(modelAlumno);
        pnlBusqueda = new PanelBusqueda();
        
        
        dlgAlumno = new Alumnos(this);
        dlgEliminar = new EliminarAlumno(this);
        dlgAcerca = new AcercaDeDialog(this);
        super.setJMenuBar(makeMenu());
        dlgAlumno.setListener(new Listener() {
            @Override
            public void aceptarClick(Alumno alumno) {
                try {
                    controlador.add(alumno);
                    dlgAlumno.setVisible(false);
                    modelAlumno.fireTableDataChanged();
                } catch (AlumnoException ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this,
                            "La matricula ya ha sido insertada",
                            "Matricula invalida",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void eliminar(String g) {
                Alumno a = controlador.buscar(g);
                if (a != null) {
                    int resp = JOptionPane.showConfirmDialog(
                            null,
                            "¿Esta seguro?",
                            "Elimina Usuario",
                            JOptionPane.YES_NO_OPTION);
                    if (JOptionPane.OK_OPTION == resp) {
                        controlador.eliminarAlumno(a);
                        modelAlumno.fireTableDataChanged();
                        dlgEliminar.setVisible(false);
                        JOptionPane.showMessageDialog(
                                PrincipalFrame.this,
                                "Eliminado de manera exitosa",
                                "Usuario Eliminado",
                                JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        dlgEliminar.setVisible(false);
                    }

                } else {
                    JOptionPane.showMessageDialog(
                            PrincipalFrame.this,
                            "Matricula no existente\nPor favor ingresa una matricula valida",
                            "Usuario no Eliminado",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void buscar(String b) {
                Alumno s = controlador.buscar(b);
                if (s != null) {
                    JOptionPane.showMessageDialog(
                            null,
                            s.getString(),
                            "Alumno",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Alumno no encontrado",
                            "No encontrado",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        super.add(new JScrollPane(tblAlumnos), BorderLayout.CENTER);
        super.add(pnlBusqueda, BorderLayout.SOUTH);
        super.setVisible(true);
    }

    private JMenuBar makeMenu() {
        JMenuBar menu = new JMenuBar();

        JMenu mAlumnos = new JMenu("Alumnos");
        JMenuItem miItem = new JMenuItem("Nuevo");
        miItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlgAlumno.setVisible(true);
            }
        });
        JMenuItem miEliminar = new JMenuItem("Eliminar");
        miEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlgEliminar.setVisible(true);
            }
        });

        JMenuItem miGuardar = new JMenuItem("Guardar");
        miGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controlador.guardar();
                } catch (GuardarException ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this,
                            ex.getMessage(),
                            "Error al guardar",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JMenuItem miSalir = new JMenuItem("Salir");
        miSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mAlumnos.add(miItem);
        mAlumnos.add(miEliminar);
        mAlumnos.add(miGuardar);
        mAlumnos.addSeparator();
        mAlumnos.add(miSalir);

        JMenu mAyuda = new JMenu("Ayuda");
        JMenuItem miAcerca = new JMenuItem("Acerca de..");
        miAcerca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlgAcerca.setVisible(true);
            }
        });
        mAyuda.add(miAcerca);

        menu.add(mAlumnos);
        menu.add(mAyuda);

        return menu;
    }
    
    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrincipalFrame();
            }
        });
    }
}
