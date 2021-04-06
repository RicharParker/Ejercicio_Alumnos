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
public class ArchivoException extends Exception {

    /**
     * Creates a new instance of <code>ArchivoException</code> without detail
     * message.
     */
    public ArchivoException() {
    }

    /**
     * Constructs an instance of <code>ArchivoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ArchivoException(String msg) {
        super(msg);
    }
}
