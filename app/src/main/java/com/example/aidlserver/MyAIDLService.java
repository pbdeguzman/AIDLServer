package com.example.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.Random;

public class MyAIDLService extends Service {
    private static final String TAG = "MyAIDLService";
    public static String message = "";

    Integer number = 0;

    public MyAIDLService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    IMyAidlInterface.Stub binder = new IMyAidlInterface.Stub() {
        @Override
        public int getColor() throws RemoteException {
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            Log.d(TAG, "getColor" + color);
            return color;
        }

        @Override
        public int increment() throws RemoteException {
            number++;
            Log.d(TAG, "getNumber" + number);
            return number;
        }

        @Override
        public String getMessage() throws RemoteException {
            Log.d(TAG, "getMessage" + message);
            return message;
        }
    };
}