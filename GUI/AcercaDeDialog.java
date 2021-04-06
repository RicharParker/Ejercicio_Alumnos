/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author ARCHV
 */
public class AcercaDeDialog extends JDialog{
    
    private JPanel pnls;
    private JPanel pnla;
    private JLabel lbl3;
    
    public AcercaDeDialog(JFrame parent){
        super(parent,true);
        super.setSize(200, 300);
        super.setLocationRelativeTo(null);
        super.setLayout(new FlowLayout());
        
        pnls = new JPanel();
        pnls.setLayout(new BorderLayout());        
        
        pnla = new JPanel();
        pnla.setLayout(new BorderLayout());
        lbl3 = new JLabel(" SOLO PERSONAL AUTORIZADO ");
        pnla.add(lbl3, BorderLayout.NORTH);
        
        super.add(pnls);
        super.add(pnla);
        super.pack();
    }
}
