package com.hesong.callcenter.activity;

public class FriendProfile {
    private String name;
    private String sipAddress;
    private int pictureId;
    private int state;
    
    public FriendProfile(String name, String sipAddress, int pictureId,
            int state) {
        super();
        this.name = name;
        this.sipAddress = sipAddress;
        this.pictureId = pictureId;
        this.state = state;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSipAddress() {
        return sipAddress;
    }
    public void setSipAddress(String sipAddress) {
        this.sipAddress = sipAddress;
    }
    public int getPictureId() {
        return pictureId;
    }
    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    

}
