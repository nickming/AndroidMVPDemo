package com.nicming.mvptestdemo.login.view;

import com.nicming.mvptestdemo.login.model.UserInfo;

/**
 * desc:
 *
 * @author:nickming date:2016/3/1
 * time: 21:05
 * e-mail：962570483@qq.com
 */

public interface ILoginView {

    void initViews();

    String getUsername();

    String getPassword();

    void showProgress();

    void hideProgress();

    void toMainActivity(UserInfo info);

    void loginFailure(String msg);

    void clearUsername();

    void clearPassword();
}
