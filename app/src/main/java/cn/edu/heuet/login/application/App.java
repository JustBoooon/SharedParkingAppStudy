package cn.edu.heuet.login.application;

import android.app.Application;

import com.xuexiang.xhttp2.XHttpSDK;

import cn.edu.heuet.login.constant.NetConstant;

/**
 * 项目最开始所执行的内容
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        XHttpSDK.init(this);   //初始化网络请求框架，必须首先执行
        XHttpSDK.setBaseUrl(NetConstant.baseService);  //设置网络请求的基础地址
    }
}
