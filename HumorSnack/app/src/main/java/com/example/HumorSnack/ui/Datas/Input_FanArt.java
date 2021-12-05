package com.example.HumorSnack.ui.Datas;

import java.util.ArrayList;

public class Input_FanArt {

    ArrayList<FanArt> items = new ArrayList<>();

    public ArrayList<FanArt> getItems() {

        FanArt fanart1 = new FanArt("http://static.hubzum.zumst.com/hubzum/2018/02/06/09/962ec338ca3b4153b037168ec92756ac.jpg",
                "Black Panther", "1", "2018", "2019-12-01", "바삭이");

        FanArt fanart2 = new FanArt("https://t1.daumcdn.net/cfile/tistory/0138F14A517F77713A",
                "Iron Man 3", "3", "4", "2019-12-02", "스낵이");

        FanArt fanart3 = new FanArt("https://i.ytimg.com/vi/5-mWvUR7_P0/maxresdefault.jpg",
                "Ant Man", "7", "6", "2019-12-03", "타임이");

        items.add(fanart1);
        items.add(fanart2);
        items.add(fanart3);

        items.add(fanart1);
        items.add(fanart2);
        items.add(fanart3);

        items.add(fanart1);
        items.add(fanart2);
        items.add(fanart3);

        return items;
    }
}
