package com.wytiger.client;

import android.os.IBinder;
import android.os.RemoteException;

import com.wytiger.common.IMyServer;
import com.wytiger.common.MyServer;
import com.wytiger.common.ServiceManagerUtil;


/**
 * desc:客户端
 *
 * @author wuyong_cd
 */
public class MyClient {
    private static MyClient instance;
    private IMyServer myServer;

    public static MyClient getInstance() {
        if (instance == null) {
            instance = new MyClient();
        }
        return instance;
    }

    private MyClient() {
        // 从ServiceManager中获取服务
        IBinder iBinder = ServiceManagerUtil.getService(MyServer.SERVER_NAME);
        myServer = MyServer.Stub.asInterface(iBinder);
    }

    public void setValue(int value) throws RemoteException {
        myServer.setValue(value);
    }

    public int getValue() throws RemoteException {
        return myServer.getValue();
    }

}
