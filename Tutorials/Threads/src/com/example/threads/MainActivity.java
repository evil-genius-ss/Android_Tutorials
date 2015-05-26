package com.example.threads;

import java.util.concurrent.atomic.AtomicBoolean;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	ProgressBar bar;
	private TextView textView;
	AtomicBoolean isRunning=new AtomicBoolean(false);

	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			bar.incrementProgressBy(5);
			textView.setText((String) msg.obj);
		}
	};
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle); setContentView(R.layout.activity_main);
		bar = (ProgressBar)findViewById(R.id.progress);
		textView = (TextView)findViewById(R.id.textView);
	}
	public void onStart() {
		super.onStart();
		bar.setProgress(0);
		Thread background=new Thread(new Runnable() { 
			public void run() {
				try {
					for (int i=0;i<20 && isRunning.get();i++) {
						Thread.sleep(1000);
						//handler.sendMessage(handler.obtainMessage());
						//OR
						Message message = handler.obtainMessage();
						message.obj = "Increament No "+i;
						handler.sendMessage(message);
					}
				}
				catch (Throwable t) {
					// just end the background thread }
				}
			}
		});
		isRunning.set(true); 
		background.start();
	}
	public void onStop() { 
		super.onStop(); 
		isRunning.set(false);
	} 
}