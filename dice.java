package com.shelja;

import java.util.Random;

public class dice {
    private final int numFaces; //maximum face value
    private int faceValue; //current value showing on the dice
    // Constructor: Sets the initial face value.
    public dice(int _numFaces) {
        numFaces = _numFaces;
        roll();
    }
    // Rolls the dice
    public void roll() {
        Random rand = new Random();
        int curr_faceValue = 1 + rand.nextInt(numFaces);
        setFaceValue(curr_faceValue);
    }
    // Face value setter/mutator.
    private void setFaceValue (int value) {
        if (value <= numFaces)
            faceValue = value;
    }
    public int getFaceValue() {
        return faceValue;
    }
    // Face value getter/setter.
    public int getNumFaces() {
        return numFaces;
    }
}
