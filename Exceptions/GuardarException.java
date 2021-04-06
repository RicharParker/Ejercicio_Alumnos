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
public class GuardarException extends Exception {

    /**
     * Creates a new instance of <code>GuardarException</code> without detail
     * message.
     */
    public GuardarException() {
    }

    /**
     * Constructs an instance of <code>GuardarException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public GuardarException(String msg) {
        super(msg);
    }
}
