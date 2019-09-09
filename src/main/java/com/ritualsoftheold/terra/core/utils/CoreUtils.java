package com.ritualsoftheold.terra.core.utils;

public class CoreUtils {

    private String address;
    private String localAddress;
    private int port = 0;
    private int localPort = 0;

    public CoreUtils(String[] args){
        boolean isLocalhost = false;
        for(int i = 0; i < args.length; i ++){
            if(args[i].equals(Options.ADDRESS_OPTION)){
                address = args[i + 1];
            }else if(args[i].equals(Options.LOCAL_ADDRESS_OPTION)){
                localAddress = args[i + 1];
            }else if(args[i].equals(Options.PORT_OPTION)){
                port = Integer.parseInt(args[i + 1]);
            }else if(args[i].equals(Options.LOCAL_PORT_OPTION)){
                localPort = Integer.parseInt(args[i + 1]);
            }else if(args[i].equals(Options.LOCALHOST_OPTION)){
                isLocalhost = true;
            }

            if(isLocalhost){
                address = "localhost";
                localAddress = "localhost";
            }
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

    public int getPort() {
        return port;
    }
}
