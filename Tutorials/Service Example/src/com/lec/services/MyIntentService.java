package com.lec.services;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyIntentService extends IntentService{


	public MyIntentService() {
		super("");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate() {
		System.out.println("---------------------------onCreate");
		Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_SHORT).show();
		super.onCreate();
	}

	

	//run on main application thread
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("---------------------------onStartCommand");
		Toast.makeText(getApplicationContext(), "onStartCommand", Toast.LENGTH_SHORT).show();
		return START_STICKY;
	}


//Run on woprker thread
	@Override
	protected void onHandleIntent(Intent intent) {
		System.out.println("---------------------------onHandler");
//		Toast.makeText(getApplicationContext(), "onHandleIntent", Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onDestroy() {
		Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();
		super.onDestroy();
	}
	
	

}
