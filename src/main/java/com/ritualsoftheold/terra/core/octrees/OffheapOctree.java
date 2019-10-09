package com.ritualsoftheold.terra.core.octrees;

import com.ritualsoftheold.terra.core.markers.Marker;
import com.ritualsoftheold.terra.core.markers.Type;
import com.ritualsoftheold.terra.core.utils.CoreUtils;

import java.util.*;

public class OffheapOctree extends Marker {

    public final OctreeNode rootNode;
    private OctreeNode cursorNode;
    public final int octreeLayers;
    private ArrayList<Marker> octree;

    public OffheapOctree(int x, int y, int z, int size) {
        super(x, y, z, Type.OCTREE);
        rootNode = new OctreeNode(x, y, z, 0);
        cursorNode = rootNode;
        octree = new ArrayList<>();
        octreeLayers = CoreUtils.calculateOctreeLayers(size);
    }

    public void createNextLayer(int index) {
        OctreeNode octant = CoreUtils.createNode(cursorNode, index);
        cursorNode.setChildren(octant, index);
    }

    public void addOctant(Marker octant){
        octree.add(octant);
    }

    public ArrayList<Marker> getOctreeNodes() {
        return octree;
    }

    public OctreeNode getCursorNode() {
        return cursorNode;
    }
}
