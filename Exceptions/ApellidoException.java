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
public class ApellidoException extends Exception {

    /**
     * Creates a new instance of <code>ApellidoException</code> without detail
     * message.
     */
    public ApellidoException() {
    }

    /**
     * Constructs an instance of <code>ApellidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ApellidoException(String msg) {
        super(msg);
    }
}
