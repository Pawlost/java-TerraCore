package com.ritualsoftheold.terra.core.markers;

public abstract class Marker {
    protected volatile float x, y, z;

    private volatile Type type;

    public Marker(float x, float y, float z, Type type){
        this.x = x;
        this.y = y;
        this.z = z;
        this.type = type;
    }

    public float getPosX() {
        return x;
    }

    public float getPosY() {
        return y;
    }

    public float getPosZ() {
        return z;
    }

    public Type getType(){
        return type;
    }
}
