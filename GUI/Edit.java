/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ARCHV
 */
public class Edit  extends JPanel {

    private JLabel lblcaption;
    private JTextField edit;

    public Edit(String caption) {
        this.lblcaption = new JLabel(caption);
        this.edit = new JTextField(10);
        
        super.add(lblcaption);
        super.add(edit);
    }

    public void clear() {
        edit.setText("");
    }

    public String getValue() {
        return edit.getText();
    }
    
    public void setTexto(String texto){
        edit.setText(texto);
    }
}
