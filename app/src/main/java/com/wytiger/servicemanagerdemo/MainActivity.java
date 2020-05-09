package com.wytiger.servicemanagerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

import com.wytiger.client.MyClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int oldValue = -1;
        try {
            oldValue = MyClient.getInstance().getValue();
            MyClient.getInstance().setValue(100);
            int newValue = MyClient.getInstance().getValue();
            Log.d("Binder", "oldValue=" + oldValue + ",newValue=" + newValue);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
