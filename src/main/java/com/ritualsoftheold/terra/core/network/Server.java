package com.ritualsoftheold.terra.core.network;

import com.ritualsoftheold.terra.core.octrees.OctreeBase;

import java.util.ArrayList;

public interface Server {
    ArrayList<OctreeBase> init(Client client);
    void update();
}
