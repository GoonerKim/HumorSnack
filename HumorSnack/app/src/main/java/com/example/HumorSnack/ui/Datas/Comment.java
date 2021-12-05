package com.example.HumorSnack.ui.Datas;

public class Comment {

    private String reply;
    private String reply_like;
    private String registerDate;
    private String nickname;

    public Comment(String reply, String reply_like, String registerDate, String nickname) {
        this.reply = reply;
        this.reply_like = reply_like;
        this.registerDate = registerDate;
        this.nickname = nickname;
    }

    public String getReply() {
        return reply;
    }

    public String getReply_like() {
        return reply_like;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public String getNickname() {
        return nickname;
    }
}
