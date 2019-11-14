package com.ritualsoftheold.terra.core.utils;

public class CoreUtils {

    private String address;
    private String localAddress;
    private int port = 0;
    private int localPort = 0;
    private boolean isLocalhost = false;

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
        //   return (int) (Math.log(size) / Math.log(8));
        return size / 128;
    }

    //Selects octant based on position and worldSize
    public static int selectOctant(float x, float y, float z, float size) {
        if (x < size / 2 && y < size / 2 && z < size / 2) {
            // 1. Octant
            return 1;
        } else if (x > size / 2 && x < size && y < size / 2 && z < size / 2) {
            // 2. Octant
            return 2;
        } else if (x < size / 2 && y > size / 2 && y < size && z < size / 2) {
            // 3. Octant
            return 3;
        } else if (x > size / 2 && x < size && y > size / 2 && y < size && z < size / 2) {
            // 4. Octant
            return 4;
        } else if (x < size / 2 && y < size / 2 && z > size / 2 && z < size) {
            // 5. Octant
            return 5;
        } else if (x > size / 2 && x < size && y < size / 2 && z > size / 2 && z < size) {
            // 6. Octant
            return 6;
        } else if (x < size / 2 && y > size / 2 && y < size && z > size / 2 && z < size) {
            // 7. Octant
            return 7;
        } else {
            // 8. Octant
            return 8;
        }
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
