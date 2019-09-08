package com.ritualsoftheold.terra.core.utils;

import java.util.Arrays;

public class CoreUtils {
    private String address = "";
    private int port = 0;

    public CoreUtils(String[] args){
        for(int i = 0; i < args.length; i ++){
            if(args[i].equals(Constants.ADDRESS_OPTION)){
                address = args[i + 1];
            }else if(args[i].equals(Constants.PORT_OPTION)){
                port = Integer.parseInt(args[i + 1]);
            }
        }
    }

    public String getAddress() {
        return address;
    }
}
