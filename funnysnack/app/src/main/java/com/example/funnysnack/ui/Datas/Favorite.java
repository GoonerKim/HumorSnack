package com.example.funnysnack.ui.Datas;

public class Favorite {

    private String fav_url;
    private String fav_title;
    private String fav_like;
    private String fav_comment;
    private String registerDate;
    private String nickname;

    public Favorite(String fav_url, String fav_title, String fav_like, String fav_comment, String registerDate, String nickname) {
        this.fav_url = fav_url;
        this.fav_title = fav_title;
        this.fav_like = fav_like;
        this.fav_comment = fav_comment;
        this.registerDate = registerDate;
        this.nickname = nickname;
    }

    public String getFav_url() {
        return fav_url;
    }

    public String getFav_title() {
        return fav_title;
    }

    public String getFav_like() {
        return fav_like;
    }

    public String getFav_comment() {
        return fav_comment;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public String getNickname() {
        return nickname;
    }
}
