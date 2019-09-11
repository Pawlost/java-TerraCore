package com.ritualsoftheold.terra.core;

public abstract class Marker {
    protected volatile float x, y, z;

    public Marker(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    protected abstract void move(float x, float y, float z);

    public float getPosX() {
        return x;
    }

    public float getPosY() {
        return y;
    }

    public float getPosZ() {
        return z;
    }

    protected abstract void sendPosition();
}
