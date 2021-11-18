package com.example.funnysnack.ui.Datas;

import java.util.ArrayList;

public class Input_Comment {

    ArrayList<Comment> items = new ArrayList<>();

    public ArrayList<Comment> getItems() {

        Comment comment1 = new Comment("우와 대박이다 ㅋㅋㅋㅋㅋㅋ",
                "7", "2019-12-01", "아이디123");

        Comment comment2 = new Comment("오 개신기 ㄷㄷ;;",
                "5", "2019-12-01", "바삭이입니다");

        Comment comment3 = new Comment("헐 어떻게 한거지",
                "2", "2019-12-03", "유머스낵꿀잼");

        items.add(comment1);
        items.add(comment2);
        items.add(comment3);

        return items;
    }
}
