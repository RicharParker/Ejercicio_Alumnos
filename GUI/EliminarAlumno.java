/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author ARCHV
 */
public class EliminarAlumno extends JDialog{
    
    private Edit edtEliminar;
    private JButton btnEliminar;
    
    private Listener listener;
    
    public EliminarAlumno(JFrame parent){
        super(parent, true);
        super.setSize(450, 250);
        super.setLayout(new FlowLayout());
        super.setLocationRelativeTo(parent);
        
        edtEliminar = new Edit("Dame el numero de control");
        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.eliminar(edtEliminar.getValue());
                edtEliminar.clear();
            }
        });
        
        super.add(edtEliminar);
        super.add(btnEliminar);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
    

}
