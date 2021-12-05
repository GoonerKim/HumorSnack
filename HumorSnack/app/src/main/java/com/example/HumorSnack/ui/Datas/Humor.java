package com.example.HumorSnack.ui.Datas;

public class Humor {

    private String humor_url;
    private String humor_title;
    private String humor_like;
    private String humor_comment;
    private String registerDate;
    private String nickname;

    public Humor(String humor_url, String humor_title, String humor_like, String humor_comment, String registerDate, String nickname) {
        this.humor_url = humor_url;
        this.humor_title = humor_title;
        this.humor_like = humor_like;
        this.humor_comment = humor_comment;
        this.registerDate = registerDate;
        this.nickname = nickname;
    }

    public String getHumor_url() {
        return humor_url;
    }


    public String getHumor_title() {
        return humor_title;
    }


    public String getHumor_like() {
        return humor_like;
    }


    public String getHumor_comment() {
        return humor_comment;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public String getNickname() {
        return nickname;
    }

}
