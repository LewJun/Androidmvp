package cn.com.sysa.androidmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import cn.com.sysa.androidmvp.bean.User;
import cn.com.sysa.androidmvp.presenter.IUserLoginPresenter;
import cn.com.sysa.androidmvp.presenter.UserLoginPresenter;
import cn.com.sysa.androidmvp.view.IUserLoginView;

public class MainActivity extends AppCompatActivity implements IUserLoginView {

    EditText et_username;
    EditText et_password;
    Button btn_login;
    Button btn_clear;
    ProgressBar pb_loading;

    IUserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
    }

    private void initViews() {
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);

        pb_loading = (ProgressBar) findViewById(R.id.pb_loading);

        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.clear();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.login();
            }
        });

    }

    @Override
    public String getUserName() {
        return et_username.getText().toString();
    }

    @Override
    public String getPassword() {
        return et_password.getText().toString();
    }

    @Override
    public void clearUserName() {
        et_username.setText("");
    }

    @Override
    public void clearPassword() {
        et_password.setText("");
    }

    @Override
    public void showLoading() {
        pb_loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb_loading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
    }
}
