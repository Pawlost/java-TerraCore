package com.ritualsoftheold.terra.core.octrees;

import com.ritualsoftheold.terra.core.chunk.ChunkLArray;
import com.ritualsoftheold.terra.core.markers.Type;

public class OctreeLeaf extends OctreeNode {

    public final long locCode;
    public final ChunkLArray chunkLArray;

    public OctreeLeaf(float x, float y, float z, int layer, long locCode, ChunkLArray chunkLArray) {
        super(x, y, z, layer, Type.LEAF_OCTANT);
        this.locCode = locCode;
        this.chunkLArray = chunkLArray;
    }
}
