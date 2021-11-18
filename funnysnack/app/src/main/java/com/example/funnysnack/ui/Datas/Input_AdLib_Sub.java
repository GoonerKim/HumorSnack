package com.example.funnysnack.ui.Datas;

import java.util.ArrayList;

public class Input_AdLib_Sub {

    ArrayList<AdLib_Sub> items = new ArrayList<>();

    public ArrayList<AdLib_Sub> getItems() {

        AdLib_Sub mw1 = new AdLib_Sub("11월 4주차");
        AdLib_Sub mw2 = new AdLib_Sub("11월 3주차");
        AdLib_Sub mw3 = new AdLib_Sub("11월 2주차");

        items.add(mw1);
        items.add(mw2);
        items.add(mw3);

        return items;
    }
}
