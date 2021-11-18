package com.example.funnysnack.ui.Datas;

import java.util.ArrayList;

public class Input_Video {

    ArrayList<Video> items = new ArrayList<>();

    public ArrayList<Video> getItems() {

        Video movie1 = new Video("https://www.radiantmediaplayer.com/media/bbb-360p.mp4","http://static.hubzum.zumst.com/hubzum/2018/02/06/09/962ec338ca3b4153b037168ec92756ac.jpg",
                "Black Panther", "1", "2018", "2019-12-01", "바삭이");

        Video movie2 = new Video("https://www.radiantmediaplayer.com/media/bbb-360p.mp4","https://t1.daumcdn.net/cfile/tistory/0138F14A517F77713A",
                "Iron Man 3", "3", "4", "2019-12-02", "스낵이");

        Video movie3 = new Video("https://www.radiantmediaplayer.com/media/bbb-360p.mp4","https://i.ytimg.com/vi/5-mWvUR7_P0/maxresdefault.jpg",
                "Ant Man", "7", "6", "2019-12-03", "타임이");

        items.add(movie1);
        items.add(movie2);
        items.add(movie3);

        items.add(movie1);
        items.add(movie2);
        items.add(movie3);

        items.add(movie1);
        items.add(movie2);
        items.add(movie3);

        return items;
    }
}
