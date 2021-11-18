package com.example.funnysnack.ui.Datas;

public class FanArt {

    private String fanart_url;
    private String fanart_title;
    private String fanart_like;
    private String fanart_comment;
    private String registerDate;
    private String nickname;

    public FanArt(String fanart_url, String fanart_title, String fanart_like, String fanart_comment, String registerDate, String nickname) {
        this.fanart_url = fanart_url;
        this.fanart_title = fanart_title;
        this.fanart_like = fanart_like;
        this.fanart_comment = fanart_comment;
        this.registerDate = registerDate;
        this.nickname = nickname;
    }

    public String getFanart_url() {
        return fanart_url;
    }

    public String getFanart_title() {
        return fanart_title;
    }

    public String getFanart_like() {
        return fanart_like;
    }

    public String getFanart_comment() { return fanart_comment; }

    public String getRegisterDate() {
        return registerDate;
    }

    public String getNickname() {
        return nickname;
    }
}
