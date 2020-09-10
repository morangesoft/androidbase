package com.morangesoft.gm.general;

public class TheApp {
    private static volatile TheApp shared = new TheApp();
    public static TheApp getInstance(){
        return shared;
    }

    public String currentMdl;

}
