/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mass.necc.processing;

import processing.core.*;

/**
 *
 * @author tutu
 */
public class body extends PApplet {

    CubeSolver[] cs;

    Bar[] bars;

    int[] tmp;

    final private int totalWidth = 1800;

    final private int totalHeight = 800;

    final private int totalBars = 500;

    private int y = 10;
    
    float[] globalIncrement;
    
    int linect;
    
    public boolean sketchFullScreen() {
        return false;
    }

    public void setup() {
        size(totalWidth, totalHeight);
        strokeCap(ROUND);
        background(0);
        this.frameRate(30);
        smooth();
        noStroke();
        fill(255);
        bars = new Bar[totalBars];
        linect = 0;
        for (int i = 0; i < totalBars; i++) {
            if(i>0)
            bars[i] = new Bar(bars[i-1].width +bars[i-1].x  + (int)(Math.random() * 20+5), y);
            else
            bars[i] = new Bar(0, y);
            
            if(bars[i].x > totalWidth){
                y += 30;
                linect++;
                bars[i].isFirst = true;
                bars[i-1].isLast = true;
                bars[i].x = bars[i].x - (bars[i].x/totalWidth * totalWidth);
            }
        }
        
        globalIncrement = new float[linect+1];

    }

    public void draw() {
        fill(0);
        rect(0, 0, width, height);
        linect = 0;
        for (int i = 0; i < totalBars; i++) {
            fill(255);
            if(i>0)
                 if(bars[i].y != bars[i-1].y)
                        linect ++;
            globalIncrement[linect] += (Math.random() * 0.01);
            if(bars[i].isFirst)
                fill(125,212,15);
            else
                fill(255);
            if(bars[i].isFirst && (bars[i].x +  globalIncrement[linect]) > 250){
                bars[i-1].y = bars[i].y;
                bars[i-1].x = -100;
            //   tmp = updateTmpPos(i, bars[i].x +  globalIncrement[linect] + 100);
                bars[i-1].isFirst = true;
                bars[i].isFirst = false;
            }
            tmp = bars[i].getSublinePos();
            rect(bars[i].x +  globalIncrement[linect], bars[i].y, bars[i].width, bars[i].height);
            fill(0);
            for (int j = 0; j < tmp.length; j++) {
                rect(tmp[j] + globalIncrement[linect], bars[i].y, 1, bars[i].height);
            }
        }
    }
//    private int[] updateTmpPos(int index, int d){
//        if(index > 0){
//            //get distance
//            
//        }
//               
//    }
    private int confine(int num, int low, int high) {
        if (num < low) {
            return low;
        }
        if (num > high) {
            return high;
        }
        return num;

    }

    private float confine(float a, float b) {
        if (a >= b) {
            return b;
        }
        return a;
    }

    private float QuadeaseInOut(float t, float b, float c, float d) {
        t /= d / 2;
        if (t < 1) {
            return c / 2 * t * t + b;
        }
        t--;
        return -c / 2 * (t * (t - 2) - 1) + b;
    }

    private float SineInOut(float t, float b, float c, float d) {
        return -c / 2 * ((float) Math.cos(Math.PI * t / d) - 1) + b;
    }

    private int confine(int a, int b) {
        if (a >= b) {
            return b;
        }
        return a;
    }
}
