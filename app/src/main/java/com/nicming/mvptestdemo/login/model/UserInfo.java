package com.nicming.mvptestdemo.login.model;

import java.io.Serializable;

/**
 * desc:
 *
 * @author:nickming date:2016/3/1
 * time: 20:49
 * e-mail：962570483@qq.com
 */

public class UserInfo implements Serializable{

    String username;
    String passowrd;

    public UserInfo(String username, String passowrd) {
        this.username = username;
        this.passowrd = passowrd;
    }

    public UserInfo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }
}
