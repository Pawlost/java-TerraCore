package com.ritualsoftheold.terra.core.chunk;

import com.ritualsoftheold.terra.core.DataConstants;
import com.ritualsoftheold.terra.core.compression.Palette;
import com.ritualsoftheold.terra.core.markers.Marker;
import com.ritualsoftheold.terra.core.markers.Type;
import com.ritualsoftheold.terra.core.materials.Registry;
import com.ritualsoftheold.terra.core.materials.TerraObject;
import xerial.larray.LByteArray;
import xerial.larray.japi.LArrayJ;

import java.nio.ByteBuffer;

public class ChunkLArray extends Marker {
    private boolean isDifferent = false;
    private Registry reg;

    private LByteArray chunkVoxelData;
    private Palette palette;

    public ChunkLArray(float x, float y, float z, ByteBuffer base, Registry reg) {
        this(x, y, z, base, reg, LArrayJ.newLByteArray(DataConstants.CHUNK_MAX_BLOCKS));
    }

    public ChunkLArray(float x, float y, float z, ByteBuffer base, Registry reg, LByteArray chunkVoxelData) {
        super(x, y, z, Type.CHUNK);
        this.reg = reg;
        palette = new Palette();
        this.chunkVoxelData = chunkVoxelData;
        palette.writeBytes(base);
        chunkVoxelData.clear();
    }

    public TerraObject get(int idx) {
        int id = palette.getMaterialID(chunkVoxelData.getByte(idx));
        return reg.getForWorldId(id);
    }

    public void set(int x, int y, int z, ByteBuffer data) {
        int idx = x + y * DataConstants.BLOCKS + z * DataConstants.BLOCKS * DataConstants.BLOCKS;
        byte id = palette.writeBytes(data);
        chunkVoxelData.update(idx, id);
    }

    public void set(int idx, ByteBuffer data) {
        byte id = palette.writeBytes(data);
        chunkVoxelData.update(idx, id);
    }

    public LByteArray getChunkVoxelData() {
        return chunkVoxelData;
    }

    public void free() {
        chunkVoxelData.free();
        palette.empty();
    }

    public void setDifferent(boolean different) {
        isDifferent = different;
    }

    public boolean isDifferent() {
        return isDifferent;
    }
}
