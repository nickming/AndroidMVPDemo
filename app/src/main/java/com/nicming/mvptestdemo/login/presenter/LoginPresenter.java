package com.nicming.mvptestdemo.login.presenter;

import android.os.Handler;

import com.nicming.mvptestdemo.login.model.RequestDataCallback;
import com.nicming.mvptestdemo.login.model.UserManager;
import com.nicming.mvptestdemo.login.view.ILoginView;

/**
 * desc:
 *
 * @author:nickming date:2016/3/1
 * time: 21:27
 * e-mail：962570483@qq.com
 */

public class LoginPresenter implements ILoginPresenter{

    protected ILoginView mLoginView;
    protected Handler handler=new Handler();

    public LoginPresenter(ILoginView mLoginView) {
        this.mLoginView = mLoginView;
    }


    @Override
    public void login() {
        mLoginView.showProgress();


        /**
         * 在异步任务中更新ui
         */
        UserManager.getmInstance().login(mLoginView.getUsername(), mLoginView.getPassword(), new RequestDataCallback() {

            @Override
            public void onSuccess() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoginView.hideProgress();
                        mLoginView.toMainActivity(UserManager.getmInstance().loadCurrentUserInfo());
                    }
                });
            }

            @Override
            public void onFailure(final String msg) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoginView.hideProgress();
                        mLoginView.loginFailure(msg);
                    }
                });

            }
        });
    }

    /*
    在ui线程中更新ui
     */
    @Override
    public void clear() {
        mLoginView.clearPassword();
        mLoginView.clearUsername();
    }
}
