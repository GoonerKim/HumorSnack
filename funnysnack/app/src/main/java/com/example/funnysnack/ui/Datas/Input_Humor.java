package com.example.funnysnack.ui.Datas;

import java.util.ArrayList;

public class Input_Humor {

    ArrayList<Humor> items = new ArrayList<>();

    public ArrayList<Humor> getItems() {

        Humor humor1 = new Humor("http://static.hubzum.zumst.com/hubzum/2018/02/06/09/962ec338ca3b4153b037168ec92756ac.jpg",
                "Black Panther", "1", "2018", "2019-12-01", "바삭이");

        Humor humor2 = new Humor("https://t1.daumcdn.net/cfile/tistory/0138F14A517F77713A",
                "Iron Man 3", "3", "4", "2019-12-02", "스낵이");

        Humor humor3 = new Humor("https://i.ytimg.com/vi/5-mWvUR7_P0/maxresdefault.jpg",
                "Ant Man", "7", "6", "2019-12-03", "타임이");

        items.add(humor1);
        items.add(humor2);
        items.add(humor3);

        items.add(humor1);
        items.add(humor2);
        items.add(humor3);

        items.add(humor1);
        items.add(humor2);
        items.add(humor3);

        return items;
    }
}
