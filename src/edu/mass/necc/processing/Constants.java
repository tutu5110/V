/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mass.necc.processing;

/**
 *
 * @author tutu
 */
public class Constants {

    private static Constants instance;

    private float[] posx;
    
    private float[] posy;

    private Constants() {
      
    }

    public static Constants getInstance() {
        if (instance == null) {
            instance = new Constants();
        }
        return instance;
    }

    
    
    //getters and setters for widht and height...
}
