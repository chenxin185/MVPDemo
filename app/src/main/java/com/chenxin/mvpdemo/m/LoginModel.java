package com.chenxin.mvpdemo.m;

/**
 * Created by chenxin on 2017/7/10.
 * O(∩_∩)O~
 */

public class LoginModel implements ILoginModel {

    @Override
    public void login(final Callback callback) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                //用一个Thread来模拟登陆
                if (Math.random() > 0.5) {
                    callback.onSuccess();
                } else {
                    callback.onFail();
                }
            }
        }.start();
    }

}
