package com.lec.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service{


	@Override
	public void onCreate() {
		Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_SHORT).show();
		super.onCreate();
	}

	//run on main application thread
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(getApplicationContext(), "onStartCommand "+ intent, Toast.LENGTH_SHORT).show();
		return START_REDELIVER_INTENT;
	}


	@Override
	public void onDestroy() {
		Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();
		super.onDestroy();
	}

	
	private MyBinder myBinder = new MyBinder();
	@Override
	public IBinder onBind(Intent intent) {
		Toast.makeText(getApplicationContext(), "onBind", Toast.LENGTH_SHORT).show();
		myBinder.Name = "Subhan";
		return myBinder;
	}



}
