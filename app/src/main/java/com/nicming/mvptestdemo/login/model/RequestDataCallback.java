package com.nicming.mvptestdemo.login.model;

/**
 * desc:
 *
 * @author:nickming date:2016/3/2
 * time: 12:47
 * e-mail：962570483@qq.com
 */

public interface RequestDataCallback {

    void  onSuccess();

    void  onFailure(String msg);
}
