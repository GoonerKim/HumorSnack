package com.example.HumorSnack.ui.Datas;

public class FanArt {

    private String fanArt_url;
    private String fanArt_title;
    private String fanArt_like;
    private String fanArt_comment;
    private String registerDate;
    private String nickname;

    public FanArt(String fanArt_url, String fanArt_title, String fanArt_like, String fanArt_comment, String registerDate, String nickname) {
        this.fanArt_url = fanArt_url;
        this.fanArt_title = fanArt_title;
        this.fanArt_like = fanArt_like;
        this.fanArt_comment = fanArt_comment;
        this.registerDate = registerDate;
        this.nickname = nickname;
    }

    public String getFanart_url() {
        return fanArt_url;
    }

    public String getFanart_title() {
        return fanArt_title;
    }

    public String getFanart_like() {
        return fanArt_like;
    }

    public String getFanart_comment() { return fanArt_comment; }

    public String getRegisterDate() {
        return registerDate;
    }

    public String getNickname() {
        return nickname;
    }
}
