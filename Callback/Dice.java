/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Callback;

import java.util.Random;

/**
 *
 * @author erso
 */
public class Dice {
    private static Random generator = new Random();
    private static final int MAX = 6;
    
    private int d1;
    private int d2;
    private int count;
    
    public int throwDice(){
        d1 = generator.nextInt(MAX) + 1;
        d2 = generator.nextInt(MAX) + 1;
        count++;
        return d1 + d2;
    }

    @Override
    public String toString() {
        return count + ": d1=" + d1 + ", d2=" + d2;
    }
    
    public boolean equalsMax(){
        return d1 == MAX && d2 == MAX;
    }

    public int getDie1() {
        return d1;
    }

    public int getDie2() {
        return d2;
    }
}
