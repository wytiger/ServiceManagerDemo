package com.wytiger.common;

import android.os.RemoteException;

/**
 * desc:服务端实现
 *
 * @author wuyong_cd
 */
public class MyServer extends IMyServer.Stub {
    public static final String SERVER_NAME="MyServer";
    private int value;

    @Override
    public void setValue(int value) throws RemoteException {
        this.value = value;
    }

    @Override
    public int getValue() throws RemoteException {
        return value;
    }
}
