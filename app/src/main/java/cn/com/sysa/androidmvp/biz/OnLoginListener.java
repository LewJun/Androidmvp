package cn.com.sysa.androidmvp.biz;

import cn.com.sysa.androidmvp.bean.User;

/**
 * Created by LewJun on 2017/5/3.
 */

public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
