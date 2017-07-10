package com.chenxin.mvpdemo.v;

/**
 * Created by chenxin on 2017/7/10.
 * O(∩_∩)O~
 */

public interface ILoginView {

    /**
     * 登陆成功回调的方法
     */
    void onLoginSuccess();

    /**
     * 登陆失败回调的方法
     */
    void onLoginFail();
}
