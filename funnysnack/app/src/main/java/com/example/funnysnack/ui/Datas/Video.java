package com.example.funnysnack.ui.Datas;

public class Video {

    private String video_url;
    private String thumbnail;
    private String video_title;
    private String video_like;
    private String video_comment;
    private String registerDate;
    private String nickname;

    public Video(String video_url, String thumbnail, String video_title, String video_like, String video_comment, String registerDate, String nickname) {
        this.video_url = video_url;
        this.thumbnail = thumbnail;
        this.video_title = video_title;
        this.video_like = video_like;
        this.video_comment = video_comment;
        this.registerDate = registerDate;
        this.nickname = nickname;
    }

    public String getVideo_url() {
        return video_url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getVideo_title() {
        return video_title;
    }

    public String getVideo_like() {
        return video_like;
    }

    public String getVideo_comment() {
        return video_comment;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public String getNickname() {
        return nickname;
    }
}
