package cn.com.sysa.androidmvp.view;

import cn.com.sysa.androidmvp.bean.User;

/**
 * Created by LewJun on 2017/5/3.
 */
public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
