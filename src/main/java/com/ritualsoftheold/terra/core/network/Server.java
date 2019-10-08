package com.ritualsoftheold.terra.core.network;

import com.ritualsoftheold.terra.core.markers.Marker;

import java.util.ArrayList;

public interface Server {
    ArrayList<Marker> init(Client client);
    void update();
}
