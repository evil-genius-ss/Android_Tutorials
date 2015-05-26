package com.ex.activities;

import com.example.actforresultsample.R;

import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity{

	public static final int REQUEST_MESSAGE_CODE = 100;
	public static final int RESULT_OK_CODE = 101;
	public static final int RESULT_ERROR_CODE = 102;
	private Button launchBtn;
	private TextView messageTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.act1_layout);
		launchBtn = (Button) findViewById(R.id.launchAct2Btn);
		messageTextView = (TextView) findViewById(R.id.msgText);
		launchBtn.setOnClickListener(clickListener);
		super.onCreate(savedInstanceState);
	}


	private OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			start2ndActivity();

		}
	};

	private void start2ndActivity() {
		Intent intent = new Intent(this, SecondActivity.class);
		startActivityForResult(intent, REQUEST_MESSAGE_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == REQUEST_MESSAGE_CODE)  
		{  
			String message = data.getStringExtra("MESSAGE"); 

			if(resultCode == RESULT_OK_CODE){
				messageTextView.setText(message);
				messageTextView.setTextColor(Color.GREEN);
			}else {
				messageTextView.setText(message);
				messageTextView.setTextColor(Color.RED);
			}

		}  
		super.onActivityResult(requestCode, resultCode, data);
	}

}
