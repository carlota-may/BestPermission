package com.zxm.bestpermission.tool;

import java.util.ArrayList;

public class Tools {
    public static String[] formatListToArray(ArrayList<String> input) {
        String[] array = new String[input.size()];
        return input.toArray(array);
    }
}
