package com.nicming.mvptestdemo.login.model;

/**
 * desc:
 *
 * @author:nickming date:2016/3/2
 * time: 12:46
 * e-mail：962570483@qq.com
 */

public class UserManager implements IUserManager {

    protected static UserManager mInstance;

    protected UserInfo mCurrentUserInfo;

    public static UserManager getmInstance() {
        if (mInstance == null) {
            synchronized (UserManager.class) {
                if (mInstance == null)
                    mInstance = new UserManager();
            }

        }
        return mInstance;
    }

    @Override
    public UserInfo loadCurrentUserInfo() {
        return mCurrentUserInfo;
    }

    @Override
    public void login(final String username, final String password, final RequestDataCallback callback) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (username.equals("123") && password.equals("123")) {
                    if (callback != null) {
                        mCurrentUserInfo = new UserInfo(username, password);
                        callback.onSuccess();
                    }
                } else {
                    if (callback != null) {
                        callback.onFailure("信息出错!");
                    }
                }
            }
        }).start();

    }
}
