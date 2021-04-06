/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Alumno;
/**
 *
 * @author ARCHV
 */
public interface Listener {
    public void aceptarClick(Alumno alumno);
    
    public void eliminar(String a);

    public void buscar(String b);
}
