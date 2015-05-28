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
public class FadeCube {

    float x;
    float y;
    float width;
    float height;
    float brightness;
    int life;

    FadeCube() {
        brightness = 1;
    }

    FadeCube(float _x, float _y, float _width, float _height) {
        x = _x;
        y = _y;
        width = _width;
        height = _height;
        brightness = 1;

    }

    FadeCube(int _x, int _y, int _size, int _life) {
        x = _x;
        y = _y;
        width = _size;
        height = _size;
        life = _life;
    }

    FadeCube(float _x, float _y, float _size) {
        x = _x;
        y = _y;
        width = _size;
        height = _size;
        brightness = 1;
    }

    public int getFillColor(){
        if(life < 0 )
             return 0;
        return 255;
    }
    
    public int getLife(){
        return life;
    }
    public int getAniamteCubePosition() {
        if (life > 0) {
            x += 5;
            life--;
        }
        return (int) x;
    }

    public void setInitialBrightness(float b) {
        brightness = b;
    }

    public float getCubeBrightnessIncrement() {
        brightness *= 1.08;
        return confine(brightness, 0, 100);
    }

    public float getCubeBrightnessDecreament() {
        brightness -= 3;
        return confine(brightness, 0, 100);
    }

    public void resetCubeBrightness() {
        brightness = 1;
    }

    public float getCubeX() {
        return x;
    }

    public float getCubeY() {
        return y;
    }

    public float getCubeW() {
        return width;
    }

    public float getCubeH() {
        return height;
    }

    private float confine(float num, float lower, float upper) {
        if (num > upper) {
            return upper;
        }
        if (num < lower) {
            return lower;
        }
        return num;
    }
}
