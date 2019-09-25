package com.ritualsoftheold.terra.core.compression;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;

public class Palette {

    private HashMap<Integer, ByteBuffer> paletteArray;
    private ArrayList<Integer> ids;

    public Palette(){
        paletteArray = new HashMap<>();
        ids = new ArrayList<>();
    }

    public byte writeBytes(ByteBuffer data){
        data.rewind();
        int id = data.getInt();
        if(!ids.contains(id)) {
            ids.add(id);
            paletteArray.put(id, data);
        }
        return (byte) ids.indexOf(id);
    }

    public byte[] getMaterialBytes(byte id){
        Integer key =  ids.get(id);
        return paletteArray.get(key).array();
    }

    public int getMaterialID(byte id){
        try {
            return ids.get(id);
        }catch (IndexOutOfBoundsException ex){
            System.out.println(ex.fillInStackTrace());
        }
        return 0;
    }

    public boolean isFull(){
        return ids.size() < 255;
    }

    public void empty(){
        paletteArray.clear();
        ids.clear();
    }
}
