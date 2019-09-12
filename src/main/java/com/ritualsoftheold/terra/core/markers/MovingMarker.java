package com.ritualsoftheold.terra.core.markers;

public abstract class MovingMarker extends Marker {

    public MovingMarker(float x, float y, float z) {
        super(x, y, z, Type.ENTITY);
    }

    protected abstract void sendPosition(float x, float y, float z);

    public abstract void move(float x, float y, float z);
}
