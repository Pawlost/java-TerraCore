package com.ritualsoftheold.terra.core.octrees;

import com.ritualsoftheold.terra.core.markers.Marker;
import com.ritualsoftheold.terra.core.markers.Type;

/*
 *   New Octree definition. Basic Node for a linear octree
 */
public class OctreeNode extends Marker {

    public final int layer;

    private Marker[] children;

    OctreeNode(float x, float y, float z, int layer, Type type) {
        super(x, y, z, type);
        this.layer = layer;
        children = new OctreeNode[8];
    }

    public OctreeNode(float x, float y, float z, int layer) {
        this(x, y, z, layer, Type.OCTANT);
    }

    public void setChildren(OctreeNode ob, int index) {
        this.children[index] = ob;
    }
}
