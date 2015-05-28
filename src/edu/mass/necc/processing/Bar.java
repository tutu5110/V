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
public class Bar {
    
    int x;
    
    int y;
    
    int width;
    
    int height;
    
    int numOfSub;
    
    int[] linePos;
    
    boolean isLast;
    boolean isFirst;
    Bar(int _x, int _y){
            x = _x;
            y = _y;
            height = 20;
            width = (int)(Math.random() * 200 + 20);
            numOfSub = (int)(Math.random() * (width/2));
            linePos = new int[numOfSub];
            initiate();
            isFirst = false;
            isLast = false;
    }
    
    public void initiate(){
        for(int i = 0; i < numOfSub; i ++){
            linePos[i] = (int)(x + Math.random() * width);
        }
    }
    
    public int[] getSublinePos(){
        return linePos;
    }
    
}
