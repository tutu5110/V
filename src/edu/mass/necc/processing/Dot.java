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
public class Dot {

    public int x;

    public int y;

    public float size;

    public int r;

    public int g;

    public int b;

    public int alpha;
    
    private int delay;
    
    private int inidelay;
    
    private int di = 1;
    
    private float maxSize;
    
    private float n;
    
    private float noiseIncrement = 0.01f;
    
    private float waveSizeIncrement = (float) (Math.random() * 1);
    
    private float waveAlphaIncrement = (int)(Math.random() * 3 ) + 10;
    
    private float waveFinalSize = 3 + (int)(Math.random() * 3);
    
    Dot(int _x, int _y, float _size) {
        x = _x;
        y = _y;
        size = _size;

        r = 255;

        g = 255;

        b = 255;
        
       maxSize = (float) (Math.random() * 3 +Math.random() * 2);
        
        n= (float) (Math.random()* 1.0f);

        alpha = (int) (Math.random() * 255);
        
        delay = (int) (Math.random() * 300);
        
        inidelay = delay;
    }

    public void update() {
        wiggle();
        //  colorWiggle();


    }
    
   public void highPower(){
       alpha += waveAlphaIncrement;
       if(alpha > 255)
           alpha = 255;
       size += waveSizeIncrement;
       if(size > waveFinalSize)
           size = waveFinalSize;
   }
    private void wiggle() {
        alpha--;
        if (alpha < 0) {
            // force alpha stop
            alpha = 0;
           pause();
        }
    }
    
   public void SizeChange(float incre){
       if(size > maxSize)
            di = -1;
       if(size<1)
           di = 1;
       
       size = size + (n + incre) * di;
           
    }
    
   
    private void pause(){
        delay --;
        if(delay<0){
            delay = inidelay;
             alpha = (int) (Math.random() * 255);
        }
    }

    private void colorWiggle() {
        r = (int) (Math.random() * 255 + 100);
        g = (int) (Math.random() * 255 + 100);
        b = (int) (Math.random() * 255 + 100);
        if (r > 255) {
            r = 255;
        }
        if (g > 255) {
            g = 255;
        }
        if (b > 255) {
            b = 255;
        }
    }
}
