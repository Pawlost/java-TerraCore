package com.ritualsoftheold.terra.core.utils;

public class CoreUtils {
    private String address;
    private long port = 0;

    public CoreUtils(String[] args){
        for(int i = 0; i < args.length; i ++){
            if(args[i].equals(Options.ADDRESS_OPTION)){
                address = args[i + 1];
            }else if(args[i].equals(Options.PORT_OPTION)){
                port = Long.parseLong(args[i + 1]);
            }
        }
    }

    public String getAddress() {
        return address;
    }

    public long getPort() {
        return port;
    }
}
