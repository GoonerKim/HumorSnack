package com.example.funnysnack.ui.Datas;

public class AdLib {

    private String adlib_url;
    private String adlib_title;
    private String adlib_like;
    private String adlib_comment;
    private String registerDate;
    private String nickname;

    public AdLib(String adlib_url, String adlib_title, String adlib_like, String adlib_comment, String registerDate, String nickname) {
        this.adlib_url = adlib_url;
        this.adlib_title = adlib_title;
        this.adlib_like = adlib_like;
        this.adlib_comment = adlib_comment;
        this.registerDate = registerDate;
        this.nickname = nickname;
    }

    public String getAdlib_url() {
        return adlib_url;
    }

    public String getAdlib_title() {
        return adlib_title;
    }

    public String getAdlib_like() {
        return adlib_like;
    }

    public String getAdlib_comment() {
        return adlib_comment;
    }

    public String getNickname() {
        return nickname;
    }

    public String getRegisterDate() {
        return registerDate;
    }
}
