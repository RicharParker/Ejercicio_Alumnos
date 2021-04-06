/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author ARCHV
 */
public class PanelBusqueda extends JPanel {

    private JLabel lblBuscar;
    private JTextField edtBuscar;
    private JButton btnBuscar;

    private Listener listener;

    public PanelBusqueda() {
        super.setLayout(new FlowLayout());

        lblBuscar = new JLabel("Buscar: ");
        edtBuscar = new JTextField(25);
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.buscar(edtBuscar.getText());
                edtBuscar.setText("");
            }
        });

        super.add(lblBuscar);
        super.add(edtBuscar);
        super.add(btnBuscar);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
    


}