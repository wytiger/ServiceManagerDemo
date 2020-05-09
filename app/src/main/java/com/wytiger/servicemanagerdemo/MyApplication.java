package com.wytiger.servicemanagerdemo;

import android.app.Application;
import android.content.Intent;

import com.wytiger.server.MyServerService;

/**
 * desc:
 *
 * @author wuyong_cd
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //启动服务端
        startService(new Intent(this, MyServerService.class));
    }
}
