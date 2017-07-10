package com.chenxin.mvpdemo.p;

import com.chenxin.mvpdemo.m.Callback;
import com.chenxin.mvpdemo.m.ILoginModel;
import com.chenxin.mvpdemo.m.LoginModel;
import com.chenxin.mvpdemo.v.ILoginView;

/**
 * Created by chenxin on 2017/7/10.
 * O(∩_∩)O~
 */

public class LoginPresenter implements ILoginPresenter {

    //V
    private ILoginView view;

    //M
    private ILoginModel model;

    public LoginPresenter(ILoginView view) {
        this.view = view;
        this.model = new LoginModel();
    }

    @Override
    public void login() {
        model.login(new Callback() {
            @Override
            public void onSuccess() {
                view.onLoginSuccess();
            }

            @Override
            public void onFail() {
                view.onLoginFail();
            }
        });
    }
}
