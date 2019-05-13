package com.example.alliance.user.base;

public class UserInformation {

    private int avatar;
    private String name;
    private String phone;
    private String character;

    public UserInformation(int avatar,String name,String phone,String character){
        this.avatar = avatar;
        this.name = name;
        this.phone = phone;
        this.character = character;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
