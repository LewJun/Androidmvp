package cn.com.sysa.androidmvp.presenter;

import android.os.Handler;

import cn.com.sysa.androidmvp.bean.User;
import cn.com.sysa.androidmvp.biz.IUserBiz;
import cn.com.sysa.androidmvp.biz.OnLoginListener;
import cn.com.sysa.androidmvp.biz.UserBiz;
import cn.com.sysa.androidmvp.view.IUserLoginView;

/**
 * Created by LewJun on 2017/5/3.
 */
public class UserLoginPresenter implements IUserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login() {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed() {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });

            }
        });
    }

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }


}
