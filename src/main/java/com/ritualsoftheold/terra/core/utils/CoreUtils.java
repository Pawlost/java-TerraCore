package com.ritualsoftheold.terra.core.utils;

import com.ritualsoftheold.terra.core.octrees.OctreeNode;

public class CoreUtils {

    private String address;
    private String localAddress;
    private int port = 0;
    private int localPort = 0;
    private boolean isLocalhost = false;

    public static final int MAX_LOAD_DISTANCE = 4096;

    public CoreUtils(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case Options.ADDRESS_OPTION:
                    address = args[i + 1];
                    break;
                case Options.LOCAL_ADDRESS_OPTION:
                    localAddress = args[i + 1];
                    break;
                case Options.PORT_OPTION:
                    port = Integer.parseInt(args[i + 1]);
                    break;
                case Options.LOCAL_PORT_OPTION:
                    localPort = Integer.parseInt(args[i + 1]);
                    break;
                case Options.LOCALHOST_OPTION:
                    isLocalhost = true;
                    break;
            }

            if (isLocalhost) {
                address = "localhost";
                localAddress = "localhost";
            }
        }
    }

    //Get octree layer
    public static int calculateOctreeLayers(int size) {
        return (int) (Math.log(size) / Math.log(8));
    }

    //Selects octant based on position and worldSize
    public static int selectOctant(float x, float y, float z, float size) {
        if (x < size / 4 && y < size / 4 && z < size / 4) {
            // 1. Octant
            return 1;
        } else if (x > size / 4 && x < size && y < size / 4 && z < size / 4) {
            // 2. Octant
            return 2;
        } else if (x < size / 4 && y > size / 4 && y < size && z < size / 4) {
            // 3. Octant
            return 3;
        } else if (x > size / 4 && x < size && y > size / 4 && y < size && z < size / 4) {
            // 4. Octant
            return 4;
        } else if (x < size / 4 && y < size / 4 && z > size / 4 && z < size) {
            // 5. Octant
            return 5;
        } else if (x > size / 4 && x < size && y < size / 4 && z > size / 4 && z < size) {
            // 6. Octant
            return 6;
        } else if (x < size / 4 && y > size / 4 && y < size && z > size / 4 && z < size) {
            // 7. Octant
            return 7;
        } else {
            // 4. Octant
            return 8;
        }
    }

    public static OctreeNode createNode(OctreeNode mainNode, int index) {
        switch (index) {
            case 0:
                int difference = (int) (MAX_LOAD_DISTANCE / Math.pow(2, mainNode.layer));
                return new OctreeNode(mainNode.getPosX() - difference / 4, mainNode.getPosY() - difference / 4,
                        mainNode.getPosZ() - difference / 4, mainNode.layer + 1);
            case 1:
                difference = (int) (MAX_LOAD_DISTANCE / Math.pow(2, mainNode.layer));
                return new OctreeNode(mainNode.getPosX() - difference / 4, mainNode.getPosY() + difference / 4,
                        mainNode.getPosZ() - difference / 4, mainNode.layer + 1);
            case 2:
                difference = (int) (MAX_LOAD_DISTANCE / Math.pow(2, mainNode.layer));
                return new OctreeNode(mainNode.getPosX() + difference / 4, mainNode.getPosY() - difference / 4,
                        mainNode.getPosZ() - difference / 4, mainNode.layer + 1);
            case 3:
                difference = (int) (MAX_LOAD_DISTANCE / Math.pow(2, mainNode.layer));
                return new OctreeNode(mainNode.getPosX() + difference / 4, mainNode.getPosY() + difference / 4,
                        mainNode.getPosZ() - difference / 4, mainNode.layer + 1);
            case 4:
                difference = (int) (MAX_LOAD_DISTANCE / Math.pow(2, mainNode.layer));
                return new OctreeNode(mainNode.getPosX() - difference / 4, mainNode.getPosY() - difference / 4,
                        mainNode.getPosZ() + difference / 4, mainNode.layer + 1);
            case 5:
                difference = (int) (MAX_LOAD_DISTANCE / Math.pow(2, mainNode.layer));
                return new OctreeNode(mainNode.getPosX() - difference / 4, mainNode.getPosY() + difference / 4,
                        mainNode.getPosZ() + difference / 4, mainNode.layer + 1);
            case 6:
                difference = (int) (MAX_LOAD_DISTANCE / Math.pow(2, mainNode.layer));
                return new OctreeNode(mainNode.getPosX() + difference / 4, mainNode.getPosY() - difference / 4,
                        mainNode.getPosZ() + difference / 4, mainNode.layer + 1);
            case 7:
                difference = (int) (MAX_LOAD_DISTANCE / Math.pow(2, mainNode.layer));
                return new OctreeNode(mainNode.getPosX() + difference / 4, mainNode.getPosY() + difference / 4,
                        mainNode.getPosZ() + difference / 4, mainNode.layer + 1);
        }
        return null;
    }

    public String getAddress() {
        return address;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public int getLocalPort() {
        return localPort;
    }

    public boolean isLocalhost() {
        return isLocalhost;
    }

    public int getPort() {
        return port;
    }
}
