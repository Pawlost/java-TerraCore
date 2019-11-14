package com.ritualsoftheold.terra.core.octrees;

import com.ritualsoftheold.terra.core.markers.Marker;
import com.ritualsoftheold.terra.core.markers.Type;
import com.ritualsoftheold.terra.core.utils.CoreUtils;
import xerial.larray.LByteArray;
import xerial.larray.LByteBuffer;
import xerial.larray.LIntArray;
import xerial.larray.japi.LArrayJ;

import java.util.*;

public class OffheapOctree extends Marker {

    public final int rootNode;
    private int cursorNode;
    public final int octreeLayers;
    private LByteArray octree;
    private LByteArray
    private static final int MAX_LEAF_SIZE = 16777216;

    public OffheapOctree(int x, int y, int z, int size) {
        super(x, y, z, Type.OCTREE);
        rootNode = 0;
        cursorNode = rootNode;
        octreeLayers = CoreUtils.calculateOctreeLayers(size);
        octree = LArrayJ.newLByteArray(MAX_LEAF_SIZE * 16);
        octree.free();
        octree.putInt(0, 1);
        octree.putInt(1, 1);
    }

    public void createNextLayer(int index) {
  //      OctreeNode octant = CoreUtils.createNode(cursorNode, index);
     //   cursorNode.setChildren(octant, index);
    }

    public int getCursorNode() {
        return cursorNode;
    }
}
