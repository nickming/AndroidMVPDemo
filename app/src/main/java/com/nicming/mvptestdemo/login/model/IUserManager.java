package com.nicming.mvptestdemo.login.model;

/**
 * desc:
 *
 * @author:nickming date:2016/3/2
 * time: 12:46
 * e-mail：962570483@qq.com
 */

public interface IUserManager {

    UserInfo loadCurrentUserInfo();
    void login(String username,String password,RequestDataCallback callback);
}
