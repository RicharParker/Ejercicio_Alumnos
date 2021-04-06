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
public class NumeroException extends Exception {

    /**
     * Creates a new instance of <code>NumeroException</code> without detail
     * message.
     */
    public NumeroException() {
    }

    /**
     * Constructs an instance of <code>NumeroException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public NumeroException(String msg) {
        super(msg);
    }
}
