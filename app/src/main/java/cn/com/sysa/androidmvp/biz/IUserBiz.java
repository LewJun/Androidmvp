package cn.com.sysa.androidmvp.biz;

/**
 * Created by LewJun on 2017/5/3.
 */

public interface IUserBiz {
    void login(String username, String password, OnLoginListener loginListener);
}
