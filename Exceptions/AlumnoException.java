/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author ARCHV
 */
public class AlumnoException extends Exception {

    /**
     * Creates a new instance of <code>AlumnoException</code> without detail
     * message.
     */
    public AlumnoException() {
    }

    /**
     * Constructs an instance of <code>AlumnoException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public AlumnoException(String msg) {
        super(msg);
    }
}
