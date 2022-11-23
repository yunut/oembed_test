package com.jys.oembedtest.commontest.three;


public enum Point {
    LOSS(0), DRAW(1), WIN(3);

    private int value;
    private Point(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

