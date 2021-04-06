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
public class CargarException extends Exception {

    /**
     * Creates a new instance of <code>CargarException</code> without detail
     * message.
     */
    public CargarException() {
    }

    /**
     * Constructs an instance of <code>CargarException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public CargarException(String msg) {
        super(msg);
    }
}
