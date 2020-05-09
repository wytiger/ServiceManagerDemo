package com.wytiger.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.wytiger.common.MyServer;
import com.wytiger.common.ServiceManagerUtil;


/**
 * 服务端服务
 */
public class MyServerService extends Service {
    public MyServerService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Binder","服务端启动");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("Binder","服务注册");
                //注册服务
                MyServer myServer = new MyServer();
                ServiceManagerUtil.addService(MyServer.SERVER_NAME, myServer);
            }
        }).start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
