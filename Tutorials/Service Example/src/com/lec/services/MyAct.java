package com.lec.services;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import com.example.servicelec.R;

public class MyAct extends Activity{
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		setContentView(R.layout.act_view);
		intent = new Intent(this, MyService.class);
		startServiceByStartMethod();
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onDestroy() {
		stopServiceBySttopMethod();
		super.onDestroy();
	}


	/*************Service by start Service****************/
	private void startServiceByStartMethod() {
		startService(intent);
	}

	private void stopServiceBySttopMethod() {
		stopService(intent);
	}
	/*************Service by start Service****************/



	/*************Service by Binding****************/
	private void startServiceByBinding() {
		bindService(intent, connection, BIND_AUTO_CREATE);
	}
	private void stopServiceByBinding() {
		unbindService(connection);
	}

	private ServiceConnection connection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Toast.makeText(getApplicationContext(), "onServiceDisconnected "+name, Toast.LENGTH_SHORT).show();

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Toast.makeText(getApplicationContext(), "onServiceConnected "+name, Toast.LENGTH_SHORT).show();

		}
	};
	/*************Service by Binding****************/
}
