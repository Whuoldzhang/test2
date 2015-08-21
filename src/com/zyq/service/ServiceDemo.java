package com.zyq.service;

import com.example.helloandroid.ServicePage;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class ServiceDemo extends Service {

	private int i = 0;
	
	public static final String ACTION = "com.zyq.service.ServiceDemo";
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.i("ServiceDemo", "service create");
		super.onCreate();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		Log.i("ServiceDemo","service start");
		super.onStart(intent, startId);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.i("ServiceDemo","service start command");
		Toast.makeText(ServiceDemo.this, "aaaaaaaaaaaaaaaa", Toast.LENGTH_LONG).show();
		Intent rIntent = new Intent();
		rIntent.putExtra("num", i++);
		rIntent.setAction("com.zyq.service.ServiceDemo");
		sendBroadcast(rIntent);
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.i("ServiceDemo","service bind");
		return null;
	}

}
