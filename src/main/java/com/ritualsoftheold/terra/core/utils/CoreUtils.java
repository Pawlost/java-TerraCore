package com.ritualsoftheold.terra.core.utils;

import java.util.Arrays;

public class CoreUtils {
    private String address = "";

    public CoreUtils(String[] args){
        System.out.println(Arrays.toString(args));
        for(int i = 0; i < args.length; i ++){
            if(args[i].equals("-domain")){
                address = args[i + 1];
            }
        }
    }

    public String getAddress() {
        return address;
    }
}
