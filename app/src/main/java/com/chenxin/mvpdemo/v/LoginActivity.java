package com.chenxin.mvpdemo.v;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.chenxin.mvpdemo.R;
import com.chenxin.mvpdemo.p.ILoginPresenter;
import com.chenxin.mvpdemo.p.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    //P
    ILoginPresenter presenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();
            }
        });
    }

    @Override
    public void onLoginSuccess() {
        //因为是在子线程中调用的接口回调方法，所以操作界面的时候需要转回到UI线程中来，这里用到了runOnuiThread方法，是activity自带的方法
        //也可以用 AsyncTask 或者是 Handler 来封装。
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, "登陆成功！", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onLoginFail() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, "登陆失败！", Toast.LENGTH_LONG).show();
            }
        });
    }
}
