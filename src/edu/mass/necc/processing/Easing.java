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
public class Easing {

    float incrementBase;

    float increment = 0.01f;
    
    float steps;
    
    float power;

    private static Easing instance;

    private Easing() {
        incrementBase = 1.0f;
        increment = 0.0005f;
        power = 1;
    }

    public static Easing getInstance() {
        if (instance == null) {
            instance = new Easing();
        }
        return instance;
    }

    public void setEasingParameters(float b, float s){
        incrementBase = b;
        steps = s;
    }
    
    public float getEasingOutValues() {
          incrementBase += increment;
          power +=0.1f;
          if(power>30){
              power = 30;
          }
          return (float) Math.pow(incrementBase,power);
    }
}
