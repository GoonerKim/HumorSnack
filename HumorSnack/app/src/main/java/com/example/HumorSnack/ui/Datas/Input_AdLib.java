package com.example.HumorSnack.ui.Datas;

import java.util.ArrayList;

public class Input_AdLib {

    ArrayList<AdLib> items = new ArrayList<>();

    public ArrayList<AdLib> getItems() {

        AdLib adlib1 = new AdLib("http://static.hubzum.zumst.com/hubzum/2018/02/06/09/962ec338ca3b4153b037168ec92756ac.jpg",
                "Black Panther", "1", "3", "2019-12-01", "바삭이");

        AdLib adlib2 = new AdLib("https://t1.daumcdn.net/cfile/tistory/0138F14A517F77713A",
                "Iron Man 3", "3", "5", "2019-12-02", "스낵이");

        AdLib adlib3 = new AdLib("https://i.ytimg.com/vi/5-mWvUR7_P0/maxresdefault.jpg",
                "Ant Man", "7", "9", "2019-12-03", "타임이");

        items.add(adlib1);
        items.add(adlib2);
        items.add(adlib3);

        items.add(adlib1);
        items.add(adlib2);
        items.add(adlib3);

        items.add(adlib1);
        items.add(adlib2);
        items.add(adlib3);

        return items;
    }
}
