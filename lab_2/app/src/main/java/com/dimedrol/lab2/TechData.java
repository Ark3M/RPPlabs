package com.dimedrol.lab2;

import java.util.ArrayList;

public class TechData {
    private static ArrayList<Tech> techs = new ArrayList<>();

    public TechData() {
        techs = new ArrayList<>();
    }

    public static Tech get(int index)
    {
        return techs.get(index);
    }

    public static int size()
    {
        return techs.size();
    }

    public static void addAll(ArrayList<Tech> someData) {
        techs.addAll(someData);
        techs.remove(0);
    }
}
