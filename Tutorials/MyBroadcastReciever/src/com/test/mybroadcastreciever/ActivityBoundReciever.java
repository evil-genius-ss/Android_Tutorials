package com.test.mybroadcastreciever;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class ActivityBoundReciever extends Activity {

	private BroadcastReceiver receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_bound_reciever);
		   
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		IntentFilter filter = new IntentFilter();
		filter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
		  

		  receiver =new BroadcastReceiver(){

			@Override
			public void onReceive(Context context, Intent intent) {
				
				Toast.makeText(context, "Wifi state changed",Toast.LENGTH_LONG).show();
			}
			  
		  };
		 registerReceiver(receiver, filter);
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		unregisterReceiver(receiver);
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}
