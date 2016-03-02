package com.nicming.mvptestdemo.login.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nicming.mvptestdemo.MainActivity;
import com.nicming.mvptestdemo.R;
import com.nicming.mvptestdemo.login.model.UserInfo;
import com.nicming.mvptestdemo.login.presenter.LoginPresenter;

public class LoginActivity extends Activity implements ILoginView ,View.OnClickListener{

    protected EditText mUserNameEt, mPasswordt;
    protected Button mLoginBtn, mClearBtn;
    protected ProgressBar mProgressbar;
    protected LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    @Override
    public void initViews() {
        mUserNameEt = (EditText) findViewById(R.id.et_login_username);
        mPasswordt = (EditText) findViewById(R.id.et_login_password);
        mLoginBtn = (Button) findViewById(R.id.btn_login);
        mClearBtn = (Button) findViewById(R.id.btn_clear);
        mProgressbar = (ProgressBar) findViewById(R.id.pb_login);
        mLoginBtn.setOnClickListener(this);
        mClearBtn.setOnClickListener(this);
        mPresenter=new LoginPresenter(this);
    }

    @Override
    public String getUsername() {
        return mUserNameEt.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPasswordt.getText().toString();
    }

    @Override
    public void showProgress() {
        mProgressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressbar.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(UserInfo info) {
        startActivity(new Intent(LoginActivity.this, MainActivity.class).putExtra("USER_INFO", info));
    }

    @Override
    public void loginFailure(String msg) {
        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUsername() {
        mUserNameEt.setText("");
    }

    @Override
    public void clearPassword() {
        mPasswordt.setText("");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_login:
                mPresenter.login();
                break;
            case R.id.btn_clear:
                mPresenter.clear();
                break;
            default:
                break;
        }
    }
}
