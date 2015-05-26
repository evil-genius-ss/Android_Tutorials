package com.test.mybroadcastreciever;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.test.mybroadcastreciever.R;

public class MainActivity extends Activity {

	private Button btnReciever;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnReciever =(Button) findViewById(R.id.btnReciever);
		btnReciever.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,ActivityBoundReciever.class);
				MainActivity.this.startActivity(intent);
				
			}
		});
	}
}
