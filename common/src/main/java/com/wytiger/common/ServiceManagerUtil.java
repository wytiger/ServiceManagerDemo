package com.wytiger.common;

import android.os.IBinder;

import java.lang.reflect.Method;

/**
 * desc: 服务注册与使用工具类
 * more: https://github.com/limpoxe/Android-ServiceManager
 *
 * @author wuyong_cd
 */
public class ServiceManagerUtil {

    /**
     * 向系统添加自定义服务
     *
     * @param name
     * @param service
     */
    public static void addService(String name, IBinder service) {
        try {
            Class serviceManagerClass = Class.forName("android.os.ServiceManager");
            Method addServiceMethod = serviceManagerClass.getDeclaredMethod("addService", String.class, IBinder.class);
            addServiceMethod.setAccessible(true);
            addServiceMethod.invoke(null, name, service);//静态方法，obj传null
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取服务
     *
     * @param name
     * @return
     */
    public static IBinder getService(String name) {
        try {
            Class serviceManagerClass = Class.forName("android.os.ServiceManager");
            Method getServiceMethod = serviceManagerClass.getDeclaredMethod("getService", String.class);
            getServiceMethod.setAccessible(true);
            IBinder iBinder = (IBinder) getServiceMethod.invoke(null, name);//静态方法，obj传null
            return iBinder;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
