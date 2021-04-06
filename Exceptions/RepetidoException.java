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
public class RepetidoException extends Exception {

    /**
     * Creates a new instance of <code>RepetidoException</code> without detail
     * message.
     */
    public RepetidoException() {
    }

    /**
     * Constructs an instance of <code>RepetidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public RepetidoException(String msg) {
        super(msg);
    }
}
