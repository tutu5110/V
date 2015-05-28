/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mass.necc.processing;

import java.util.HashMap;

/**
 *
 * @author tutu
 */
public class CubeSolver {

    public float x;
    public float y;
    public float width;
    public float height;
    private int totalWidth = 1800;
    HashMap<Float, Float> hm;
    int animateStage = 0;
    float tg_width;
    int cd = 5;
    int shuffle = 5;
    public boolean isActive;
    int initialDelay;
    int delay = 5;
    boolean initialized = false;
    boolean readyForUpdate = false;
    
    CubeSolver(float _x, float _y, float _width, float _height, int _delay) {
        x = _x;
        y = _y;
        width = _width;
        height = _height;
        hm = new HashMap<Float, Float>();
        tg_width = width + (int) (Math.random() * 100 + 10);
        isActive = false;
        cd = _delay;
        shuffle = _delay;
        initialDelay =_delay;
        delay = _delay;
    }

    public int getCDLength() {
        return cd;
    }

    public boolean ready() {
        if (initialDelay <= 0 && !initialized) {
            initialized = true;
            return true;
            
        } else {
            initialDelay--;
            return false;
        }
    }

    public void update() {
        switch (animateStage) {
            case 0:
                width += 3;
                if (width > tg_width) {
                    animateStage = 1;
                }
                break;

            case 1:
                cd--;
                if (cd < 0) {
                    animateStage = 2;
                }
                break;

            case 2:
                width -= 3;
                x += 3;
                if (width < 3) {
                    animateStage = 3;
                    isActive = false;
                    width = 0;
                }
                break;
            case 3:
               shuffle --;
               if(shuffle < 0){
                   if(x > totalWidth){
                       x = -300;
                   }
                   cd = delay;
                   initialDelay = delay;
                   shuffle = delay;
                   animateStage = 0;
                   isActive = true;
               }
               break;
            default:
                break;
        }
    }

}
